import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.DriverUtils;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUpBaseTest() {
        driver = setUpDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownBaseTest() {
        tearDown(driver);
    }

    protected WebDriver setUpDriver() {
        return DriverUtils.setUpDriver();
    }

    protected void quitDriver(WebDriver driver) {
        DriverUtils.quitDriver(driver);
    }

    protected void tearDown(WebDriver driver) {
        quitDriver(driver);
    }
}
