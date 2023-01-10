package steps.libraries;

import base.Base;
import lombok.SneakyThrows;
import org.openqa.selenium.Keys;
import page.AddToCartPage;
import page.UpdateCartPage;
import utils.PageWaitTime;

import java.util.concurrent.TimeUnit;

public class UpdateItemStep extends Base {
    private AddToCartPage addToCartPage = new AddToCartPage();
    private UpdateCartPage updateCartPage = new UpdateCartPage();


    @SneakyThrows
    public void updateQty(int qty)  {
      addToCartPage.cartTrolleyButton.click();
        TimeUnit.SECONDS.sleep(PageWaitTime.WAIT_TIME.getPageWaitTime());
        updateCartPage.editQtyInputFielD.sendKeys(Keys.BACK_SPACE);
        updateCartPage.editQtyInputFielD.sendKeys(String.valueOf(qty));
        updateCartPage.updateItemButton.click();
        updateCartPage.closeCartContent.click();

    }

    @SneakyThrows
    public void addGwynEnduranceTeeYellowToCart(){
        int qty =1;
        TimeUnit.SECONDS.sleep(PageWaitTime.WAIT_TIME.getPageWaitTime());
        updateCartPage.smallSizeOptionLabel.click();
        updateCartPage.yellowColorOptionLabel.click();
        addToCartPage.qtyInputField.sendKeys(Keys.BACK_SPACE);
        addToCartPage.qtyInputField.sendKeys(Keys.BACK_SPACE,String.valueOf(qty));
        addToCartPage.addToCartButton.click();
    }

    @SneakyThrows
    public void addQuestLumaFlexToCart(String item){
        CommonStep commonStep = new CommonStep();
        addToCartPage.searchInput.sendKeys(item,Keys.ENTER);
        TimeUnit.SECONDS.sleep(PageWaitTime.WAIT_TIME.getPageWaitTime());
        commonStep.scrollDownToElement(updateCartPage.questLumaFlexItemButton);
        updateCartPage.questLumaFlexItemButton.click();
        updateCartPage.addQuestLumaFlexToCart.click();
    }
}
