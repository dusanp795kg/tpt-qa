package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import utils.Constants;
import utils.Locators;

public class FirstTaskDialogBoxPage extends BasePage {

    public FirstTaskDialogBoxPage(WebDriver driver) {
        super(driver);
    }

    private boolean isDialogBoxOpened(int timeout) {
        return isWebElementVisible(Locators.dialogLocator, timeout);
    }

    public FirstTaskDialogBoxPage verifyDialogBoxOpened() {
        Assert.assertTrue(isDialogBoxOpened(Constants.TIMEOUT_5_SEC), "DialogBox is NOT opened!");
        return this;
    }

    public boolean verifyDialogElements() {
        By[] dialogLocators = {
                Locators.dialogTitleLocator,
                Locators.dialogCloseButtonLocator,
                Locators.dialogContentLocator,
                Locators.dialogNoButtonLocator,
                Locators.dialogYesButtonLocator,
        };
        for (By locator : dialogLocators) {
            if (!verifyElement(locator)) {
                return false;
            }
        }
        return true;
    }

    public FirstTaskDialogBoxPage verifyBackgroundColourOfYesButton(String expectedColorHex) {
        verifyBackgroundElementColor(Locators.dialogYesButtonLocator, expectedColorHex);
        return this;
    }

    public FirstTaskDialogBoxPage focusOnXButton() {
        WebElement element = getWebElement(Locators.dialogCloseButtonLocator);
        new Actions(driver).moveToElement(element).perform();
        return this;
    }

    public FirstTaskLandingPage pressEnterKey() {
        WebElement element = getWebElement(Locators.dialogCloseButtonLocator);
        element.sendKeys(Keys.ENTER);
        return new FirstTaskLandingPage(driver);
    }

    public boolean verifyDialogBoxIsClosed() {
        return !isWebElementDisplayed(Locators.dialogLocator);
    }
}
