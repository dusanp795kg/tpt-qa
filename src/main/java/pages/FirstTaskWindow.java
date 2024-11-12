package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.Constants;
import utils.Locators;

public class FirstTaskWindow extends BasePage {

    public FirstTaskWindow(WebDriver driver) {
        super(driver);
    }

    private boolean isWindowOpened(int timeout) {
        return isWebElementVisible(Locators.windowLocator, timeout);
    }

    public FirstTaskWindow verifyWindowOpened() {
        Assert.assertTrue(isWindowOpened(Constants.TIMEOUT_5_SEC), "Window is NOT opened!");
        return this;
    }

    public boolean verifyWindowElements() {
        By[] windowLocators = {
                Locators.windowTitleLocator,
                Locators.windowMinimizeButtonLocator,
                Locators.windowMaximizeButtonLocator,
                Locators.windowCloseButtonLocator,
                Locators.windowContentLocator
        };
        for (By locator : windowLocators) {
            if (!verifyElement(locator)) {
                return false;
            }
        }
        return true;
    }

    public void maximizeWindow() {
        clickOnElement(Locators.windowMaximizeButtonLocator);
    }

    public boolean verifyMaximizeButtonNotDisplayed() {
        return !isWebElementDisplayed(Locators.windowMaximizeButtonLocator);
    }

    public boolean verifyWindowIsClosed() {
        return !isWebElementDisplayed(Locators.windowLocator);
    }

    public void closeWindow() {
        clickOnElement(Locators.windowCloseButtonLocator);
    }
}
