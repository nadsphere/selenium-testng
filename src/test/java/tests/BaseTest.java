package tests;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import utils.ExtentReportManager;
import utils.WebDriverFactory;

import java.lang.reflect.Method;

public class BaseTest {
    protected WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
        ExtentReportManager.createInstance();
    }

    @AfterSuite
    public void afterSuite() {
        ExtentReportManager.flush();
    }

    @BeforeMethod
    public void setUp(Method method) {
        driver = WebDriverFactory.createDriver();
        ExtentReportManager.setTest(
                ExtentReportManager.getTest() != null
                        ? ExtentReportManager.getTest()
                        : ExtentReportManager.createInstance().createTest(method.getName())
        );
        ExtentReportManager.getTest().log(Status.INFO, "Test started: " + method.getName());
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    protected void logInfo(String message) {
        ExtentReportManager.getTest().log(Status.INFO, message);
    }

    protected void logPass(String message) {
        ExtentReportManager.getTest().log(Status.PASS, message);
    }

    protected void logFail(String message) {
        ExtentReportManager.getTest().log(Status.FAIL, message);
    }
}
