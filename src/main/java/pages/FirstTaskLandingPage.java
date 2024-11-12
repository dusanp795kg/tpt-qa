package pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.Locators;

public class FirstTaskLandingPage extends BasePage {

    public FirstTaskLandingPage(WebDriver driver) {
        super(driver);
    }

    public FirstTaskLandingPage open() {
        openUrl(Locators.firstTaskPageUrl);
        return this;
    }

    public boolean isOpenDialogButton() {
        return isWebElementDisplayed(Locators.openDialogButtonLocator);
    }

    public boolean isOpenWindowButton() {
        return isWebElementDisplayed(Locators.openWindowButtonLocator);
    }


    public FirstTaskDialogBoxPage clickOpenDialogButton() {
        Assert.assertTrue(isOpenDialogButton(), "'Open dialog' Button is NOT displayed on the Page");
        clickOnElement(Locators.openDialogButtonLocator);
        FirstTaskDialogBoxPage firstTaskDialogBox = new FirstTaskDialogBoxPage(driver);
        return firstTaskDialogBox.verifyDialogBoxOpened();
    }

    public FirstTaskWindow clickOpenWindowButton() {
        Assert.assertTrue(isOpenWindowButton(), "'Open window' Button is NOT displayed on the Page");
        clickOnElement(Locators.openWindowButtonLocator);
        FirstTaskWindow firstTaskWindow = new FirstTaskWindow(driver);
        return firstTaskWindow.verifyWindowOpened();
    }
}
