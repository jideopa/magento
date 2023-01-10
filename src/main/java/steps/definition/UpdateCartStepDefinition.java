package steps.definition;

import base.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import steps.libraries.UpdateItemStep;

public class UpdateCartStepDefinition extends Base {
    private UpdateItemStep updateItemStep = new UpdateItemStep();

    @And("the quantity of Gwyn Endurance Tee is update to {int}")
    public void theQuantityOfGwynEnduranceTeeIsUpdateTo(int price){
        updateItemStep.updateQty(price);
    }

    @When("Gwyn Endurance Tee Small Yellow and {string} Band is added")
    public void gwynEnduranceTeeSmallYellowAndBandIsAdded(String item){
        updateItemStep.addGwynEnduranceTeeYellowToCart();
        updateItemStep.addQuestLumaFlexToCart(item);
    }
}
