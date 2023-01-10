package page;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Base {
    @FindBy(css = "input#email")
    public WebElement inputEmailField;
    @FindBy(css = "fieldset #pass")
    public WebElement inputPasswordField;
    @FindBy(css = "fieldset button")
    public WebElement signButton;
    @FindBy(css = ".panel [tabindex='-1']")
    public WebElement customerWelcomePanel;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }
}
