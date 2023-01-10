package steps.libraries;

import base.Base;
import org.openqa.selenium.Keys;
import page.AddressPage;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class AddressStep extends Base {
    private AddressPage addressPage = new AddressPage();
    private CommonStep commonStep = new CommonStep();

    public void setAddress() {
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
        addressPage.streetAddressInputField.sendKeys(Keys.DELETE, properties.getProperty("street"));
        addressPage.cityInputField.sendKeys(Keys.DELETE, properties.getProperty("city"));
        addressPage.inputZipOrPostalCodeField.sendKeys(Keys.DELETE, properties.getProperty("postcode"));
        commonStep.SelectADropDown(addressPage.selectCountryDropDown, properties.getProperty("country-id"));
        addressPage.phoneNumberField.sendKeys(Keys.DELETE, properties.getProperty("phone-number"));
        addressPage.saveAddressButton.click();
    }

}
