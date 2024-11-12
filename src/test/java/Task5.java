import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.DropdownsPage;

public class Task5 extends BaseTest {
    @Test
    public void Task5_test1() throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();

        DropdownsPage dropdownsPage = new DropdownsPage(driver).open();

        dropdownsPage.clickOnMultiSelect();
        softAssert.assertTrue(dropdownsPage.verifyAllOptionsDisplayedInMultiSelect(), "Options in Multi select aren't displayed as expected");
        dropdownsPage.chooseFavoriteSports();
        softAssert.assertTrue(dropdownsPage.verifyChosenSports(), "The chosen sports aren't displayed in the Multi Select field as expected");


        softAssert.assertAll();

    }
}
