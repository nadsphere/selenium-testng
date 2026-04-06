package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WaitUtils;

public class LoginPage {
    private WebDriver driver;
    private WaitUtils wait;

    private final By USERNAME_INPUT = By.id("username");
    private final By PASSWORD_INPUT = By.id("password");
    private final By LOGIN_BUTTON = By.id("loginButton");
    private final By ERROR_MESSAGE = By.className("error-message");
    private final By SUCCESS_MESSAGE = By.className("success-message");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtils(driver);
    }

    public void openPage(String url) {
        driver.get(url);
    }

    public void enterUsername(String username) {
        WebElement input = wait.waitForElementVisible(USERNAME_INPUT);
        input.clear();
        input.sendKeys(username);
    }

    public void enterPassword(String password) {
        WebElement input = wait.waitForElementVisible(PASSWORD_INPUT);
        input.clear();
        input.sendKeys(password);
    }

    public void clickLogin() {
        WebElement button = wait.waitForElementClickable(LOGIN_BUTTON);
        button.click();
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }

    public boolean isErrorDisplayed() {
        try {
            return wait.waitForElementVisible(ERROR_MESSAGE).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isLoginSuccessful() {
        try {
            return wait.waitForElementVisible(SUCCESS_MESSAGE).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
