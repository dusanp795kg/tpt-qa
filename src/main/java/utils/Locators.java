package utils;

import org.openqa.selenium.By;

public class Locators {

    /**
     * FirstTaskDialogBox
     */

    public static final By dialogLocator = By.xpath("//div[@role='dialog']");
    public static final By dialogTitleLocator = By.xpath("//span[contains(@id,'kendo-dialog-title')]");
    public static final By dialogCloseButtonLocator = By.xpath("//button[@title='Close']");
    public static final By dialogContentLocator = By.xpath("//div[contains(@id,'kendo-dialog-content')]");
    public static final By dialogNoButtonLocator = By.xpath("//button//span[text()='No']");
    public static final By dialogYesButtonLocator = By.xpath("//button[@themecolor='primary']");

    /**
     * FirstTaskLandingPage
     */

    public static final String firstTaskPageUrl = Constants.BASE_URL + "/dialogs/preview?theme=default-main";

    public static final By openDialogButtonLocator = By.xpath("//button//span[text()='Open dialog']");
    public static final By openWindowButtonLocator = By.xpath("//button//span[text()='Open window']");

    /**
     * FirstTaskWindow
     */

    public static final By windowLocator = By.xpath("//kendo-window[@role='dialog']");
    public static final By windowTitleLocator = By.xpath("//span[contains(@id,'kendo-window-title')]");
    public static final By windowMinimizeButtonLocator = By.xpath("//button[@title='Minimize']");
    public static final By windowMaximizeButtonLocator = By.xpath("//button[@title='Maximize']");
    public static final By windowCloseButtonLocator = By.xpath("//button[@title='Close']");
    public static final By windowContentLocator = By.xpath("//div[@class='k-window-content']//p[text()='Additional info']");

    /**
     * EmployeesPage
     */

    public static final String employeesPageUrl = Constants.BASE_URL + "/grid/filter-all-columns?theme=default-main";

    public static final By countryColumnMenuLocator = By.xpath("//a[@title='Country Column Menu']");
    public static final By contactNameColumnMenuLocator = By.xpath("//a[@title='Contact Name Column Menu']");
    public static final By statusColumnMenuLocator = By.xpath("//a[@title='Status Column Menu']");
    public static final By columnMenuFilterLocator = By.xpath("//div[text()=' Filter ']");
    public static final By columnColumnsFilterLocator = By.xpath("//kendo-grid-columnmenu-item[@icon='columns']");
    public static final By filterOperatorLocator = By.xpath("//kendo-dropdownlist[@aria-label='Country Filter Operators']//button[@aria-label='Select']");
    public static final By filterOptionIsEqualToLocator = By.xpath("//span[text()='Is equal to']");
    public static final By filterInputTextLocator = By.xpath("//input[@aria-label='Country Filter']");
    public static final By filterButtonLocator = By.xpath("//button[@type='submit']");
    public static final By employeeRowLocator = By.xpath("//tr[@role='row' and contains(@class,'k-master-row')]");
    public static final By columnsFilterCountryLocator = By.xpath("//span[text()='Country']/../input");
    public static final By columnsFilterStatusLocator = By.xpath("//span[text()='Status']/../input");
    public static final By columnsFilterRatingLocator = By.xpath("//span[text()='Rating']/../input");
    public static final By columnsFilterEngagementLocator = By.xpath("//span[text()='Engagement']/../input");
    public static final By columnsFilterBudgetLocator = By.xpath("//span[text()='Budget']/../input");
    public static final By applyButtonLocator = By.xpath("//button[text()='Apply']");
    public static final By statusFilterIsTrueLocator = By.xpath("//label[text()='Is True']/../input");
    public static final By exportToExcelButtonLocator = By.xpath("//button[@kendogridexcelcommand]");


    /**
     * DropdownsPage
     */

    public static final String dropDownPageUrl = Constants.BASE_URL + "/dropdowns/overview?theme=default-main";

    public static final By autocompleteInputFieldLocator = By.xpath("//input[@placeholder='Your favorite sport']");

    public static By yourFavoriteSport(String sport) {
        return By.xpath("//li//span[text()='" + sport + "']");
    }

    public static final By clearAutocompleteInputFieldLocator = By.xpath("//kendo-autocomplete//span");
    public static final By multiSelectInputFieldLocator = By.xpath("//kendo-multiselect[contains(@class,'k-multiselect')]//input");

    public static final By multiSelectClearButtonLocator = By.xpath("//kendo-multiselect//span[@title='clear']");

    public static By getSportLocatorInMultiSelect(String sport) {
        return By.xpath("//kendo-list//li//span[contains(@class,'item-text')][text()='" + sport + "']");
    }

    public static By getChosenSportLocator(String sport) {
        return By.xpath("//kendo-multiselect//span[contains(@class,'k-chip-label')][text()='" + sport + "']");
    }


}
