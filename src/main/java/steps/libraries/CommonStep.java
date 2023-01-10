package steps.libraries;

import base.Base;
import io.cucumber.java.After;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.awaitility.Awaitility;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import page.AddToCartPage;
import utils.PageWaitTime;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
@Log4j2
public class CommonStep extends Base {
    AddToCartPage addToCartPage = new AddToCartPage();
    static JavascriptExecutor js = (JavascriptExecutor) driver;

    public void OpenPage(String page) {
        Properties properties = new Properties();
        FileReader fileReader = null;
        try {
            fileReader = new FileReader("src/test/resources/config.properties");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            properties.load(fileReader);
        } catch (IOException e) {
            e.printStackTrace();
        }

        driver.get(properties.getProperty(page));
        Awaitility.await().atMost(5, TimeUnit.SECONDS);
        System.out.println("Page is launch");
    }

    public void scrollDownToElement(WebElement element) {
       log.info("Strolling to element");
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public void SelectADropDown(WebElement webElement, String value) {
        Select dropDown = new Select(webElement);
        dropDown.selectByValue(value);
    }

    @SneakyThrows
    @After(order = 3)
    public void deleteCart() {
        addToCartPage.removeItem.click();
        TimeUnit.SECONDS.sleep(PageWaitTime.WAIT_TIME.getPageWaitTime());
        addToCartPage.okToRemoveItemPopUp.click();
        log.info("Cart item deleted");
    }
}
