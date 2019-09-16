package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import utils.SeleniumHelper;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class LoginPage extends SeleniumHelper {
    // PageFactory
    @FindBy(id = "nav-link-accountList")

    private WebElement account;

    @FindBy(xpath = "//*[@data-nav-ref='nav_signin']//span[@class='nav-action-inner']")

    private WebElement signButton;

    @FindBy(id = "ap_email")

    private WebElement email;

    @FindBy(id = "ap_password")

    private WebElement password;

    @FindBy(id = "signInSubmit")

    private WebElement loginButton;

    @FindBy(xpath = "//*[@id='auth-email-missing-alert']//div[@class='a-alert-content']")

    private WebElement emailError;

    @FindBy(xpath = "//*[@id='auth-password-missing-alert']//div[@class='a-alert-content']")

    private WebElement passwordError;

    @FindBy(css = "h4.a-alert-heading")

    private WebElement authError;

    @FindBy(id = "continue")

    private List<WebElement> continueButton;

    @FindBy(id = "continue")

    private WebElement continueB;


    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public void launchApplication(String URL) {
        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(3, TimeUnit.MINUTES);
        getDriver().manage().timeouts().pageLoadTimeout(4, TimeUnit.MINUTES);
        getDriver().get(URL);
    }

    public void clickSignIn() {
        mouseHover(account);
        clickOn(signButton);
    }

    public void enterEmail(String input) {
        typeInto(email, input + CreateAccountPage.constructEmail);
    }

    public void enterPassword(String input) {
        try {
            if ((continueB).isDisplayed()) {
                clickOn(continueB);
                typeInto(password, input);
            } else {
                typeInto(password, input);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clickLogin() {
        clickOn(loginButton);
    }

    public void emailError(String input) {
        textAssertion(input, emailError);
    }

    public void passError(String input) {
        textAssertion(input, passwordError);
    }

    public void authError(String input) {
        textAssertion(input, authError);
    }
}
