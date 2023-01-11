package steps.libraries;

import base.Base;
import lombok.SneakyThrows;
import org.awaitility.Awaitility;
import org.openqa.selenium.Keys;
import page.AddToCartPage;
import utils.PageWaitTime;

import java.util.concurrent.TimeUnit;

public class AddToCartStep extends Base {
    private AddToCartPage addToCartPage = new AddToCartPage();
    private CommonStep commonStep = new CommonStep();

    @SneakyThrows
    public void searchForItem(String item){
        addToCartPage.searchInput.sendKeys(item, Keys.ENTER);
        Awaitility.await().atMost(PageWaitTime.WAIT_TIME.getPageWaitTime(), TimeUnit.SECONDS).until(addToCartPage.gwynEnduranceTeeItem::isDisplayed);
        commonStep.scrollDownToElement(addToCartPage.gwynEnduranceTeeItem);
        addToCartPage.gwynEnduranceTeeItem.click();
        TimeUnit.SECONDS.sleep(PageWaitTime.WAIT_TIME.getPageWaitTime());
        addToCartPage.optionMediumSizeLabelButton.click();
        addToCartPage.optionGreenColorLabelButton.click();

    }

    @SneakyThrows
    public void enterQty(String qty){
        addToCartPage.qtyInputField.sendKeys(Keys.DELETE, qty);
        addToCartPage.addToCartButton.click();
        TimeUnit.SECONDS.sleep(PageWaitTime.WAIT_TIME.getPageWaitTime());
    }

    @SneakyThrows
    public String getTotalPrice() {
        addToCartPage.cartTrolleyButton.click();
        TimeUnit.SECONDS.sleep(PageWaitTime.WAIT_TIME.getPageWaitTime());
        return addToCartPage.totalPriceText.getText();
    }

}
