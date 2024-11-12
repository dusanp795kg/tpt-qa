import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.FirstTaskDialogBoxPage;
import pages.FirstTaskLandingPage;

public class Task1 extends BaseTest {

    @Test
    public void Task1_test1() {

        SoftAssert softAssert = new SoftAssert();

        FirstTaskLandingPage firstTaskLandingPage = new FirstTaskLandingPage(driver).open();
        FirstTaskDialogBoxPage dialogBox = firstTaskLandingPage.clickOpenDialogButton();
        softAssert.assertTrue(dialogBox.verifyDialogElements(), "Some elements might be missing or they are changed.");
        dialogBox.verifyBackgroundColourOfYesButton("#ff6358").focusOnXButton().pressEnterKey();
        Assert.assertTrue(dialogBox.verifyDialogBoxIsClosed(), "Dialog box should be closed, but it's still visible.");

        softAssert.assertAll();
    }
}
