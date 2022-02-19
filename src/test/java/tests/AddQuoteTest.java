package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class AddQuoteTest {
    private ChromeDriver driver;

    @BeforeTest
    public void initializeSession() {
//        wedrivermanager
        WebDriverManager.chromedriver().setup();
//        chrome options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
//        init browser
        driver = new ChromeDriver(options);
//        maximize window
        driver.manage().window().maximize();
    }

    @AfterTest
    public void destroySession() throws InterruptedException {
//        delay
        Thread.sleep(5000);
//        close browser
        driver.quit();
    }

    @Test
    public void addQuoteWithColorYellow() {
        driver.get("http://bdd.atlasid.tech/");

        By locatorInputQuote = By.id("inputQuote");
        WebElement inputQuote = driver.findElement(locatorInputQuote);
        inputQuote.sendKeys("Lorem Ipsum heheheh");

//        select color
        By locatorSelector = By.id("colorSelect");
        WebElement selectColor = driver.findElement(locatorSelector);
        Select select = new Select(selectColor);
        select.selectByVisibleText("Yellow");

//        click
        By locatorButton = By.id("buttonAddQuote");
        WebElement buttonAddQuote = driver.findElement(locatorButton);
        buttonAddQuote.click();

//        findElements
        By locatorLabelQuotes = By.name("quoteText");
//        tampung tipe data
        List<WebElement> quotes = driver.findElements(locatorLabelQuotes);
//        ambil quote kedua
        WebElement quoteSecond = quotes.get(1);
        String actualData = quoteSecond.getText();
//        Assert (jika nilainya sesuai)
        Assert.assertEquals(actualData, "Lorem Ipsum heheheh");
//        Assert (jika saah valuenya)
//        Assert.assertEquals(actualData, "Lorem Ipsum", "quote is not same");

    }
}

// simplify code ke dalam class lain
