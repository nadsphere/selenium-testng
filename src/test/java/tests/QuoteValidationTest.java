package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QuoteHomePage;
import utils.ConfigReader;

public class QuoteValidationTest extends BaseTest {

    @Test(description = "Test quote with special characters")
    public void addQuoteWithSpecialCharacters() {
        QuoteHomePage homePage = new QuoteHomePage(driver);

        logInfo("Opening application");
        homePage.openPage(ConfigReader.getAppUrl());

        String specialQuote = "Quote with special chars: @#$%^&*()_+-=[]{}|;':\",./<>?";
        homePage.addQuoteWithColor(specialQuote, "Yellow");

        Assert.assertTrue(homePage.isQuoteDisplayed(specialQuote), "Quote with special characters should be displayed");
        logPass("Quote with special characters handled correctly");
    }

    @Test(description = "Test quote with unicode characters")
    public void addQuoteWithUnicode() {
        QuoteHomePage homePage = new QuoteHomePage(driver);

        logInfo("Opening application");
        homePage.openPage(ConfigReader.getAppUrl());

        String unicodeQuote = "Quote with unicode: Hello World Alpha Beta Gamma";
        homePage.addQuoteWithColor(unicodeQuote, "Blue");

        Assert.assertTrue(homePage.isQuoteDisplayed(unicodeQuote), "Quote with unicode should be displayed");
        logPass("Quote with unicode characters handled correctly");
    }

    @Test(description = "Test quote with very long text")
    public void addQuoteWithLongText() {
        QuoteHomePage homePage = new QuoteHomePage(driver);

        logInfo("Opening application");
        homePage.openPage(ConfigReader.getAppUrl());

        String longQuote = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. ".repeat(10);
        homePage.addQuoteWithColor(longQuote, "Green");

        Assert.assertTrue(homePage.isQuoteDisplayed(longQuote), "Long quote should be displayed");
        logPass("Long quote handled correctly");
    }

    @Test(description = "Test sequential quote additions")
    public void sequentialQuoteAdditions() {
        QuoteHomePage homePage = new QuoteHomePage(driver);

        logInfo("Opening application");
        homePage.openPage(ConfigReader.getAppUrl());

        String[] colors = {"Red", "Blue", "Green", "Yellow", "Purple"};
        int initialCount = homePage.getQuoteCount();

        for (int i = 0; i < colors.length; i++) {
            homePage.addQuoteWithColor("Sequential Quote " + (i + 1), colors[i]);
        }

        int finalCount = homePage.getQuoteCount();
        Assert.assertEquals(finalCount, initialCount + colors.length, "All sequential quotes should be added");

        logPass("Sequential quote additions working correctly");
    }
}
