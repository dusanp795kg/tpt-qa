package pages;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Locators;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class EmployeesPage extends BasePage {


    public EmployeesPage(WebDriver driver) {
        super(driver);
    }

    public EmployeesPage open() {
        openUrl(Locators.employeesPageUrl);
        return this;
    }

    public void openFilters() {
        if (isElementPresent(Locators.countryColumnMenuLocator))
            clickOnElement(Locators.countryColumnMenuLocator);
        else clickOnElement(Locators.contactNameColumnMenuLocator);
    }

    public void filterUSEmployees() {
        openFilters();
        waitUntilClickable(Locators.columnMenuFilterLocator);
        clickOnElement(Locators.columnMenuFilterLocator);
        clickOnElement(Locators.filterOperatorLocator);
        clickOnElement(Locators.filterOptionIsEqualToLocator);
        typeTextToWebElement(Locators.filterInputTextLocator, "US");
        clickOnElement(Locators.filterButtonLocator);
    }

    public void switchColumns() {
        openFilters();
        waitUntilClickable(Locators.columnColumnsFilterLocator);
        clickOnElement(Locators.columnColumnsFilterLocator);
        clickOnElement(Locators.columnsFilterCountryLocator);
        clickOnElement(Locators.columnsFilterStatusLocator);
        clickOnElement(Locators.columnsFilterRatingLocator);
        clickOnElement(Locators.columnsFilterEngagementLocator);
        clickOnElement(Locators.columnsFilterBudgetLocator);
        clickOnElement(Locators.applyButtonLocator);
    }

    public void printUSEmployeeInfo() {
        switchColumns();

        List<WebElement> employees = driver.findElements(Locators.employeeRowLocator);
        for (WebElement employee : employees) {
            System.out.println("Employee info: " + employee.getText() + "\n");
        }
    }

    public void filterOnlineEmployees() {
        waitUntilClickable(Locators.statusColumnMenuLocator);
        clickOnElement(Locators.statusColumnMenuLocator);
        clickOnElement(Locators.columnMenuFilterLocator);
        clickOnElement(Locators.statusFilterIsTrueLocator);
        clickOnElement(Locators.filterButtonLocator);
    }

    public void exportOnlineUSEmployees() {
        switchColumns();
        filterOnlineEmployees();
        clickOnElement(Locators.exportToExcelButtonLocator);
    }

    public String getExcelData(String sheetName, int rowNumber, int cellNumber) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\My pc\\Downloads\\Employees.xlsx");
        Workbook workbook = new XSSFWorkbook(fileInputStream);
        Sheet sheet = workbook.getSheet(sheetName);
        Row row = sheet.getRow(rowNumber);
        Cell cell = row.getCell(cellNumber);
        String cellText = cell.toString();

        workbook.close();
        fileInputStream.close();

        return cellText;
    }

    public boolean verifyExportedTable() throws IOException {
        String country = "US";
        String status = "TRUE";

        for (int i = 2; i < 14; i++) {
            String cell = getExcelData("Sheet1", i, 2);
            if (!cell.equals(country))
                return false;
        }

        for (int i = 2; i < 14; i++) {
            String cell = getExcelData("Sheet1", i, 3);
            if (!cell.equals(status))
                return false;
        }
        return true;
    }
}
