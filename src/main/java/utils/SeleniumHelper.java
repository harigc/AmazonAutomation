package utils;


import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import static org.junit.jupiter.api.Assertions.assertEquals;

import net.serenitybdd.core.pages.PageObject;


public class SeleniumHelper extends PageObject {
    Actions action = new Actions(getDriver());

    public SeleniumHelper(WebDriver driver) {
        super(driver);
    }

    /**
     * Get attribute "value" of the element
     *
     * @param element element
     * @return value
     */
    protected String getValue(WebElement element) {
        return element.getAttribute("value");
    }

    protected void clickElement(WebElement element) {
        element.click();
    }

    /**
     * This method will select dropdown value by select visible text method
     *
     * @param xpath - The xpath is the element to locate dropdown
     * @param Value - The value to be selected
     * @throws IOException
     * @author Hansul Fathima
     */
    protected boolean dropdownSelectByValue(WebElement xpath, String Value) throws IOException {
        boolean bReturn = false;
        try {
            Select drpCountry = new Select(xpath);
            drpCountry.selectByValue(Value);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return bReturn;
    }

    /**
     * This method will select dropdown value by select visible text method
     *
     * @param xpath - The xpath is the element to locate dropdown
     * @param Value - The value to be selected
     * @throws IOException
     * @author Hansul Fathima
     */
    protected boolean dropdownSelectByVisibleText(WebElement xpath, String Value) throws IOException {
        boolean bReturn = false;
        try {
            Select drpCountry = new Select(xpath);
            drpCountry.selectByVisibleText(Value);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return bReturn;
    }

    protected void textAssertion(String expectedText, WebElement element) {
        try {
            String actualText = element.getText().trim();
            assertEquals(expectedText, actualText);
        } catch (Exception ex) {
            System.err.println("An InterruptedException was caught: " + ex.getMessage());
        }
    }

    protected void mouseHover(WebElement element) {
        try {
            action.moveToElement(element).perform();
        } catch (Exception ex) {
            System.err.println("An InterruptedException was caught: " + ex.getMessage());

        }
    }
}
