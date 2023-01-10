package steps.libraries;

import base.Base;
import lombok.extern.log4j.Log4j2;
import org.junit.Assert;
import page.LoginPage;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
@Log4j2
public class LoginStep extends Base {

   private LoginPage loginPage = new LoginPage();
    public void completeLoginForm(){
        Properties properties = new Properties();
        FileReader reader= null;

        try {
            reader= new FileReader("src/test/resources/config.properties");
            properties.load(reader);
        } catch (IOException e) {

            e.printStackTrace();
        }

        loginPage.inputEmailField.sendKeys(properties.getProperty("email"));
        loginPage.inputPasswordField.sendKeys(properties.getProperty("password"));
        loginPage.signButton.click();
        Assert.assertTrue(welcomePanelIsDisplayed());
        log.info("User is Logged in");
    }

    boolean welcomePanelIsDisplayed(){

        return loginPage.customerWelcomePanel.isDisplayed();
    }

}
