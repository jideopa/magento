package steps.libraries;

import base.Base;
import org.awaitility.Awaitility;
import org.openqa.selenium.Keys;
import page.AddToCartPage;
import utils.PageWaitTime;

import java.util.concurrent.TimeUnit;

public class AddToCartStep extends Base {
    private AddToCartPage addToCartPage = new AddToCartPage();
    private CommonStep commonStep = new CommonStep();


    public void searchForItem(String item) throws InterruptedException {
        addToCartPage.searchInput.sendKeys(item, Keys.ENTER);
        Awaitility.await().atMost(PageWaitTime.WAIT_TIME.getPageWaitTime(), TimeUnit.SECONDS).until(addToCartPage.gwynEnduranceTeeItem::isDisplayed);
        commonStep.scrollDownToElement(addToCartPage.gwynEnduranceTeeItem);
        addToCartPage.gwynEnduranceTeeItem.click();
        TimeUnit.SECONDS.sleep(PageWaitTime.WAIT_TIME.getPageWaitTime());
        addToCartPage.optionMediumSizeLabelButton.click();
        addToCartPage.optionGreenColorLabelButton.click();

    }

    public void enterQty(String qty) throws InterruptedException {
        addToCartPage.qtyInputField.sendKeys(Keys.DELETE, qty);
        addToCartPage.addToCartButton.click();
        TimeUnit.SECONDS.sleep(PageWaitTime.WAIT_TIME.getPageWaitTime());
    }

    public String getTotalPrice() throws InterruptedException {
        addToCartPage.cartTrolleyButton.click();
        TimeUnit.SECONDS.sleep(PageWaitTime.WAIT_TIME.getPageWaitTime());
        return addToCartPage.totalPriceText.getText();
    }

}
