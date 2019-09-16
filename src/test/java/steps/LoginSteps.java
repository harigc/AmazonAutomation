package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

public class LoginSteps {

    LoginPage loginPage;

    WebDriver driver;

    @Step
    public void launchApplicationStep(String URL) {
        loginPage.launchApplication(URL);
    }

    @Step
    public void clickSignInStep() {
        loginPage.clickSignIn();
    }

    @Step
    public void enterEmailStep(String input) {
        loginPage.enterEmail(input);
    }

    @Step
    public void enterPasswordStep(String input) {
        loginPage.enterPassword(input);
    }

    @Step
    public void clickLoginStep() {
        loginPage.clickLogin();
    }

    @Step
    public void emailError(String input) {
        loginPage.emailError(input);
    }

    @Step
    public void passError(String input) {
        loginPage.passError(input);
    }

    @Step
    public void authError(String input) {
        loginPage.authError(input);
    }
}
