package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.SeleniumHelper;

public class CreateAccountPage extends SeleniumHelper {

    static final long number = (long) Math.floor(Math.random() * 900000000L) + 10000000L;

    static String value = Long.toString(number);

    public static String constructEmail = value + "@gmail.com";

    @FindBy(xpath = "//*[@id='nav-flyout-ya-newCust']//a")

    private WebElement newCustomer;
    @FindBy(id = "ap_customer_name")

    private WebElement name;
    @FindBy(id = "ap_email")

    private WebElement email;
    @FindBy(id = "ap_password")

    private WebElement password;
    @FindBy(id = "ap_password_check")

    private WebElement repeatPassword;
    @FindBy(id = "nav-link-accountList")

    private WebElement account;
    @FindBy(id = "continue")

    private WebElement continueB;

    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }

    public void clickNewHere() {
        mouseHover(account);
        clickOn(newCustomer);
    }

    public void enterName(String input) {
        typeInto(name, input);
    }

    public String enterEmail(String input) {
        String completeEmail = input + constructEmail;
        typeInto(email, completeEmail);
        return completeEmail;
    }

    public void enterPass(String input) {
        typeInto(password, input);
    }

    public void re_enterPass(String input) {
        typeInto(repeatPassword, input);
    }

    public void clickContinue() {
        clickOn(continueB);
    }

    public void validateRegisteredUserLogin(String input) {
        typeInto(email, enterEmail(input));
    }
}
