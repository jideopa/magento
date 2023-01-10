package page;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpdateCartPage extends Base {
    @FindBy(css = "button[title='Update']")
    public WebElement updateItemButton;
    @FindBy(css = "button#btn-minicart-close")
    public WebElement closeCartContent;
    @FindBy(css = ".size.swatch-attribute > div[role='listbox'] > div:nth-of-type(2)")
    public WebElement smallSizeOptionLabel;
    @FindBy(css = ".color.swatch-attribute > div[role='listbox'] > div:nth-of-type(3)")
    public WebElement yellowColorOptionLabel;
    @FindBy(css = "img[alt='Quest Lumaflex™ Band']")
    public WebElement questLumaFlexItemButton;
    @FindBy(css = "button#product-addtocart-button > span")
    public WebElement addQuestLumaFlexToCart;
    @FindBy(css = ".cart-item-qty")
    public WebElement editQtyInputFielD;


    public UpdateCartPage() {
        PageFactory.initElements(driver, this);
    }


}
