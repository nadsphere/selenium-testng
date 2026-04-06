package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.WaitUtils;

import java.util.List;

public class QuoteHomePage {
    private WebDriver driver;
    private WaitUtils wait;

    private final By INPUT_QUOTE = By.id("inputQuote");
    private final By COLOR_SELECT = By.id("colorSelect");
    private final By BUTTON_ADD_QUOTE = By.id("buttonAddQuote");
    private final By QUOTE_TEXT = By.name("quoteText");
    private final By BUTTON_DELETE_QUOTE = By.className("btn-delete-quote");

    public QuoteHomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtils(driver);
    }

    public void openPage(String url) {
        driver.get(url);
        wait.waitForElementVisible(INPUT_QUOTE);
    }

    public void inputQuote(String quote) {
        WebElement inputElement = wait.waitForElementVisible(INPUT_QUOTE);
        inputElement.clear();
        inputElement.sendKeys(quote);
    }

    public void selectColor(String color) {
        WebElement selectElement = wait.waitForElementVisible(COLOR_SELECT);
        Select select = new Select(selectElement);
        select.selectByVisibleText(color);
    }

    public void clickAddQuote() {
        WebElement button = wait.waitForElementClickable(BUTTON_ADD_QUOTE);
        button.click();
    }

    public String getQuoteText(int index) {
        List<WebElement> quotes = driver.findElements(QUOTE_TEXT);
        if (index >= 0 && index < quotes.size()) {
            return quotes.get(index).getText();
        }
        throw new IndexOutOfBoundsException("Quote index out of bounds: " + index);
    }

    public int getQuoteCount() {
        return wait.waitForNumberOfElements(QUOTE_TEXT);
    }

    public void deleteQuote(int index) {
        List<WebElement> deleteButtons = driver.findElements(BUTTON_DELETE_QUOTE);
        if (index >= 0 && index < deleteButtons.size()) {
            wait.waitForElementClickable(BUTTON_DELETE_QUOTE).click();
        }
    }

    public boolean isQuoteDisplayed(String quoteText) {
        List<WebElement> quotes = driver.findElements(QUOTE_TEXT);
        return quotes.stream().anyMatch(q -> q.getText().equals(quoteText));
    }

    public void addQuoteWithColor(String quote, String color) {
        inputQuote(quote);
        selectColor(color);
        clickAddQuote();
    }
}
