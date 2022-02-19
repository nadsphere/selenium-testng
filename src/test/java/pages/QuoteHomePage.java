package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

public class QuoteHomePage {
    private ChromeDriver driver;

//    make a constructor
    public QuoteHomePage(ChromeDriver driver) {
        this.driver = driver;
    }

    public void openPage() {
        driver.get("http://bdd.atlasid.tech/");
    }

    public void inputQuote(String quote) {
        By locatorInputQuote = By.id("inputQuote");
        WebElement inputQuote = driver.findElement(locatorInputQuote);
        inputQuote.sendKeys(quote);
    }

    public void selectColor(String color) {
        By locatorSelector = By.id("colorSelect");
        WebElement selectColor = driver.findElement(locatorSelector);
        Select select = new Select(selectColor);
        select.selectByVisibleText(color);
    }

    public void clickButtonAddQuote() {
        By locatorButton = By.id("buttonAddQuote");
        WebElement buttonAddQuote = driver.findElement(locatorButton);
        buttonAddQuote.click();
    }

    public String getSecondQuote() {
//        findElements
        By locatorLabelQuotes = By.name("quoteText");
//        tampung tipe data
        List<WebElement> quotes = driver.findElements(locatorLabelQuotes);
//        ambil quote kedua
        WebElement quoteSecond = quotes.get(1);
        String actualData = quoteSecond.getText();
        return actualData;
    }
}