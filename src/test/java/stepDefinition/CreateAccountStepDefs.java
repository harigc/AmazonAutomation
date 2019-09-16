package stepDefinition;

import com.google.common.collect.Maps;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import pages.CreateAccountPage;
import steps.CreateAccountSteps;

import java.util.Map;

public class CreateAccountStepDefs {
    @Steps
    CreateAccountSteps createAccountSteps;

    @When("^Click on New Here option$")
    public void newHire() {
        createAccountSteps.clickNewHere();
    }

    @When("^Click on Continue button$")
    public void signInOption() {
        createAccountSteps.clickContinue();
    }

    @Then("^Fill the Create Account form$")
    public void createAccount(DataTable table) {
        for (Map<String, String> row : table.asMaps(String.class, String.class)) {
            String field = row.get("Field");
            String value = row.get("Value");
            createAccountForm(field, value);
        }
    }

    @When("^Validating the registered user \"([^\"]*)\"$")
    public void validateRegisteredUser(String input) {
        createAccountSteps.validateRegisteredUserLogin(input);
    }

    @Then("^I login to exp\\.o Booking as an? \"(End User|Configurator|Administrator|Nokia User)\"$")
    public void hello() {

    }

    public void createAccountForm(String field, String value) {
        switch (field) {
            case "Name":
                createAccountSteps.enterName(value);
                break;

            case "Email":
                createAccountSteps.enterEmail(value);
                break;

            case "Password":
                createAccountSteps.enterPass(value);
                break;

            case "RePassword":
                createAccountSteps.re_enterPass(value);
                break;
        }
    }
}
