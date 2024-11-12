import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.FirstTaskLandingPage;
import pages.FirstTaskWindow;

public class Task2 extends BaseTest {

    @Test
    public void Task2_test1() {

        SoftAssert softAssert = new SoftAssert();

        FirstTaskLandingPage firstTaskLandingPage = new FirstTaskLandingPage(driver).open();
        FirstTaskWindow window = firstTaskLandingPage.clickOpenWindowButton();
        softAssert.assertTrue(window.verifyWindowElements(), "Some elements might be missing or they are changed!");
        window.maximizeWindow();
        Assert.assertTrue(window.verifyMaximizeButtonNotDisplayed(), "Maximize button should be invisible, but it's still visible.");
        window.closeWindow();
        Assert.assertTrue(window.verifyWindowIsClosed(), "Window should be closed, but it's still visible.");

        softAssert.assertAll();
    }
}
