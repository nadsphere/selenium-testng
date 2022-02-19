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
import pages.QuoteHomePage;

import java.util.List;

public class AddQuoteTestPageObj {
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
        Thread.sleep(5000);
//        close browser
        driver.quit();
    }

    @Test
    public void addQuoteWithColorYellow() throws Exception {
        QuoteHomePage homePage = new QuoteHomePage(driver);
        homePage.openPage();
        homePage.inputQuote("Lorem Ipsum");
        Thread.sleep(3000);
        homePage.selectColor("Yellow");
        Thread.sleep(3000);
        homePage.clickButtonAddQuote();
        String actualData = homePage.getSecondQuote();
        Assert.assertEquals(actualData, "Lorem Ipsum");
    }
}
