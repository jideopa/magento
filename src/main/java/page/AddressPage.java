package page;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressPage extends Base {
    @FindBy(css = "#street_1")
    public WebElement streetAddressInputField;
    @FindBy(css = "input#city")
    public WebElement cityInputField;
    @FindBy(css = "input#zip")
    public WebElement inputZipOrPostalCodeField;
    @FindBy(css = "button[title='Save Address'] > span")
    public WebElement saveAddressButton;
    @FindBy(css = "select#country")
    public WebElement selectCountryDropDown;
    @FindBy(css = "input#telephone")
    public WebElement phoneNumberField;
    public AddressPage() {
        PageFactory.initElements(driver, this);
    }
}
