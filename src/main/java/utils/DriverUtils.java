package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DriverUtils {

    public static WebDriver setUpDriver() {
        WebDriver driver;

        try {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.TIMEOUT_10_SEC));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Constants.TIMEOUT_10_SEC));
            driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(Constants.TIMEOUT_10_SEC));
            driver.manage().window().maximize();
        } catch (Exception e) {
            throw new RuntimeException("Failed to initialize Chrome driver", e);
        }

        return driver;
    }

    public static boolean hasDriverQuit(WebDriver driver) {
        return driver == null || ((ChromeDriver) driver).getSessionId() == null;
    }

    public static void quitDriver(WebDriver driver) {
        if (!hasDriverQuit(driver)) {
            driver.quit();
        }
    }
}
