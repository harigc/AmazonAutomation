package stepDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import steps.LoginSteps;

public class LoginStepDefs {
    @Steps
    LoginSteps loginStep;

    @Given("^Launch the application \"([^\"]*)\"$")
    public void launchApplication(String URL) {
        loginStep.launchApplicationStep(URL);
    }

    @When("^Clicked on Sign option$")
    public void signInOption() {
        loginStep.clickSignInStep();
    }

    @Then("^Enter the username \"([^\"]*)\"$")
    public void userName(String input) {
        loginStep.enterEmailStep(input);
    }

    @Then("^Enter the password \"([^\"]*)\"$")
    public void password(String input) {
        loginStep.enterPasswordStep(input);
    }

    @Then("^Click Login$")
    public void login() {
        loginStep.clickLoginStep();
    }

    @Then("^Validate the business error message \"([^\"]*)\"$")
    public void errorMessage(String errorMessage) {
        if (errorMessage.contains("password")) {
            loginStep.passError(errorMessage);
        } else if (errorMessage.contains("mail")) {
            loginStep.emailError(errorMessage);
        } else if (errorMessage.contains("problem")) {
            loginStep.authError(errorMessage);
        }
    }
}
