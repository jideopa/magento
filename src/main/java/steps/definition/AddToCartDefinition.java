package steps.definition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.assertj.core.api.SoftAssertions;
import steps.libraries.AddToCartStep;
import steps.libraries.AddressStep;
import steps.libraries.CommonStep;
import steps.libraries.LoginStep;

public class AddToCartDefinition {
    private CommonStep commonStep = new CommonStep();
    private AddToCartStep addToCartStep = new AddToCartStep();
    private LoginStep loginStep = new LoginStep();
    private AddressStep addressStep = new AddressStep();

    @Given("user is on the {string}")
    public void userIsOnThe(String page){
        commonStep.OpenPage(page);
        loginStep.completeLoginForm();

    }


    @And("user add {int} {string} is added to cart")
    public void userAddIsAddedToCart(int qty, String item) throws InterruptedException {
        addToCartStep.searchForItem(item);
        addToCartStep.enterQty(String.valueOf(qty));
    }

    @Then("cart total should be {string}")
    public void cartTotalShouldBe(String price) throws InterruptedException {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(price).isEqualTo(addToCartStep.getTotalPrice());
        softly.assertAll();
    }

    @And("UK address is set on {string}")
    public void ukAddressIsSetOn(String page) {
        commonStep.OpenPage(page);
        addressStep.setAddress();
    }
}
