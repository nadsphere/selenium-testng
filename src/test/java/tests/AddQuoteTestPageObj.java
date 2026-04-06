package tests;

import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QuoteHomePage;
import utils.ConfigReader;
import utils.ExtentReportManager;

public class AddQuoteTestPageObj extends BaseTest {

    @Test(description = "Add a quote with Yellow color and verify it appears")
    public void addQuoteWithColorYellow() {
        QuoteHomePage homePage = new QuoteHomePage(driver);

        logInfo("Opening application");
        homePage.openPage(ConfigReader.getAppUrl());

        int initialCount = homePage.getQuoteCount();
        logInfo("Initial quote count: " + initialCount);

        logInfo("Adding new quote with Yellow color");
        homePage.addQuoteWithColor("Selenium TestNG Demo Quote", "Yellow");

        int finalCount = homePage.getQuoteCount();
        logInfo("Final quote count: " + finalCount);

        String quoteText = homePage.getQuoteText(finalCount - 1);
        Assert.assertEquals(quoteText, "Selenium TestNG Demo Quote", "Quote text mismatch");
        Assert.assertEquals(finalCount, initialCount + 1, "Quote count should increase by 1");

        logPass("Quote added successfully with Yellow color");
    }

    @Test(description = "Add multiple quotes with different colors")
    public void addMultipleQuotes() {
        QuoteHomePage homePage = new QuoteHomePage(driver);

        logInfo("Opening application");
        homePage.openPage(ConfigReader.getAppUrl());

        String[][] quotes = {
                {"First Quote - Red", "Red"},
                {"Second Quote - Blue", "Blue"},
                {"Third Quote - Green", "Green"}
        };

        for (String[] quoteData : quotes) {
            logInfo("Adding: " + quoteData[0]);
            homePage.addQuoteWithColor(quoteData[0], quoteData[1]);
        }

        int finalCount = homePage.getQuoteCount();
        Assert.assertTrue(finalCount >= 3, "Should have at least 3 quotes");

        logPass("Multiple quotes added successfully");
    }

    @Test(description = "Verify quote persistence after page refresh")
    public void verifyQuotePersistence() {
        QuoteHomePage homePage = new QuoteHomePage(driver);

        logInfo("Opening application");
        homePage.openPage(ConfigReader.getAppUrl());

        String testQuote = "Persistent Quote Test";
        homePage.addQuoteWithColor(testQuote, "Yellow");

        logInfo("Refreshing page to verify persistence");
        driver.navigate().refresh();

        boolean isDisplayed = homePage.isQuoteDisplayed(testQuote);
        Assert.assertTrue(isDisplayed, "Quote should persist after page refresh");

        logPass("Quote persistence verified");
    }
}
