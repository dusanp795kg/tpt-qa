package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Constants;
import utils.Locators;

public class DropdownsPage extends BasePage {


    public DropdownsPage(WebDriver driver) {
        super(driver);
    }

    public DropdownsPage open() {
        openUrl(Locators.dropDownPageUrl);
        return this;
    }

    public void chooseAutocompleteSports() {
        typeTextToWebElement(Locators.autocompleteInputFieldLocator, "Football");
        if (isElementPresent(Locators.yourFavoriteSport("Football"))) ;
        clickOnElement(Locators.yourFavoriteSport("Football"));
    }

    public boolean verifyChosenSport() {
        boolean isSportChosen = isElementPresent(Locators.clearAutocompleteInputFieldLocator);
        return isSportChosen;
    }

    public void clearChosenSport() {
        clickOnElement(Locators.clearAutocompleteInputFieldLocator);
    }

    public void chooseFavoriteSports() {

        clickOnElement(Locators.multiSelectClearButtonLocator);

        clickOnElement(Locators.multiSelectInputFieldLocator);
        clickOnElement(Locators.getSportLocatorInMultiSelect("Tennis"));

        clickOnElement(Locators.multiSelectInputFieldLocator);
        clickOnElement(Locators.getSportLocatorInMultiSelect("Football"));
    }

    public void clickOnMultiSelect() {
        clickOnElement(Locators.multiSelectInputFieldLocator);
    }

    public boolean verifyAllOptionsDisplayedInMultiSelect() {

        By[] sportsLocators = {
                Locators.getSportLocatorInMultiSelect("Baseball5"),
                Locators.getSportLocatorInMultiSelect("Basketball"),
                Locators.getSportLocatorInMultiSelect("Cricket"),
                Locators.getSportLocatorInMultiSelect("Field Hockey"),
                Locators.getSportLocatorInMultiSelect("Football"),
                Locators.getSportLocatorInMultiSelect("Table Tennis"),
                Locators.getSportLocatorInMultiSelect("Tennis"),
                Locators.getSportLocatorInMultiSelect("Volleyball")
        };

        for (By locator : sportsLocators) {
            if (!isWebElementVisible(locator, Constants.TIMEOUT_5_SEC)) {
                throw new RuntimeException("Sport not found for locator: " + locator.toString());
            }
        }
        return true;
    }

    public boolean verifyChosenSports() {

        By[] chosenSportsLocators = {
                Locators.getChosenSportLocator("Tennis"),
                Locators.getChosenSportLocator("Football"),
        };

        for (By locator : chosenSportsLocators) {
            if (!isWebElementDisplayed(locator)) {
                throw new RuntimeException("Chosen sport not found for locator: " + locator.toString());
            }
        }
        return true;
    }

}
