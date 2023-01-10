package page;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCartPage extends Base {
    @FindBy(css = "input#search")
    public WebElement searchInput;
    @FindBy(css = "li:nth-of-type(1) > .product-item-info  strong > a")
    public WebElement gwynEnduranceTeeItem;
    @FindBy(css = ".size.swatch-attribute > div[role='listbox'] > div:nth-of-type(3)")
    public WebElement optionMediumSizeLabelButton;
    @FindBy(css = "[attribute-code='color'] [index='1']")
    public WebElement optionGreenColorLabelButton;
    @FindBy(css = "input#qty")
    public WebElement qtyInputField;
    @FindBy(css = "button#product-addtocart-button")
    public WebElement addToCartButton;
    @FindBy(css = ".amount.price-container > .price-wrapper > .price")
    public WebElement totalPriceText;
    @FindBy(css = ".minicart-wrapper > .action.showcart")
    public WebElement cartTrolleyButton;
    @FindBy(css = "a[title='Remove item']")
    public WebElement removeItem;
    @FindBy(css = ".action-accept.action-primary > span")
    public WebElement okToRemoveItemPopUp;

    public AddToCartPage() {
        PageFactory.initElements(driver, this);
    }

}
