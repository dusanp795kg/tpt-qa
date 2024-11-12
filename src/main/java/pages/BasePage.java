package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.DriverUtils;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        Assert.assertFalse(DriverUtils.hasDriverQuit(driver), "Driver instance has quit!");
        this.driver = driver;
    }

    private WebDriverWait getWebDriverWait(int timeout) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeout));
    }

    protected void openUrl(String url) {
        driver.get(url);
    }

    protected void clickOnElement(By locator) {
        WebElement element = getWebElement(locator);
        if (isElementPresent(locator)) {
            element.click();
        }
    }

    protected void typeTextToWebElement(By locator, String text) {
        WebElement element = getWebElement(locator);
        element.sendKeys(text);
    }

    protected WebElement getWebElement(By locator) {
        return driver.findElement(locator);
    }

    protected boolean verifyElement(By locator) {
        WebElement element = getWebElement(locator);
        return isElementDisplayed(element);
    }

    protected boolean isElementDisplayed(WebElement element) {
        return element.isDisplayed();
    }

    protected void verifyBackgroundElementColor(By locator, String expectedColorHex) {
        WebElement element = getWebElement(locator);
        String actualColor = element.getCssValue("background-color");
        String actualColorHex = Color.fromString(actualColor).asHex();
        Assert.assertEquals(actualColorHex, expectedColorHex, "The color of the element does not match the expected value.");
    }

    protected WebElement waitForWebElementToBeVisible(By locator, int timeout) {
        WebDriverWait wait = getWebDriverWait(timeout);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected boolean isWebElementDisplayed(By locator) {
        try {
            WebElement element = getWebElement(locator);
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    protected boolean isWebElementVisible(By locator, int timeout) {
        try {
            WebElement element = waitForWebElementToBeVisible(locator, timeout);
            return element != null;
        } catch (Exception e) {
            return false;
        }
    }

    protected boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    protected void waitUntilClickable(By locator) {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(locator));
    }
}
