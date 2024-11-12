import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DropdownsPage;

public class Task4 extends BaseTest {

    @Test
    public void Task4_test1()  {

        DropdownsPage dropdownsPage = new DropdownsPage(driver).open();

        dropdownsPage.chooseAutocompleteSports();
        Assert.assertTrue(dropdownsPage.verifyChosenSport(), "Sport is not chosen");
        dropdownsPage.clearChosenSport();
    }
}