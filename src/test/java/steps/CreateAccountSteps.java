package steps;

import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import pages.CreateAccountPage;

public class CreateAccountSteps {

    CreateAccountPage createAccountPage;

    @Step
    public void clickNewHere() {
        createAccountPage.clickNewHere();
    }

    @Step
    public void enterName(String input) {
        createAccountPage.enterName(input);
    }

    @Step
    public String enterEmail(String input) {
        Serenity.recordReportData().withTitle("Registered Email ID")
                .andContents(createAccountPage.enterEmail(input));
        return createAccountPage.enterEmail(input);
    }

    @Step
    public void enterPass(String input) {
        createAccountPage.enterPass(input);
    }

    @Step
    public void re_enterPass(String input) {
        createAccountPage.re_enterPass(input);
    }

    @Step
    public void clickContinue() {
        createAccountPage.clickContinue();
    }

    @Step
    public void validateRegisteredUserLogin(String input) {
        createAccountPage.validateRegisteredUserLogin(input);
    }
}
