package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QuoteHomePage;
import utils.ConfigReader;

public class ColorSelectionTest extends BaseTest {

    @Test(description = "Test quote color selection - Red")
    public void addQuoteWithRedColor() {
        QuoteHomePage homePage = new QuoteHomePage(driver);

        logInfo("Opening application");
        homePage.openPage(ConfigReader.getAppUrl());

        String quote = "Red Color Test Quote";
        homePage.addQuoteWithColor(quote, "Red");

        Assert.assertTrue(homePage.isQuoteDisplayed(quote), "Quote should be displayed");
        logPass("Red color quote added successfully");
    }

    @Test(description = "Test quote color selection - Blue")
    public void addQuoteWithBlueColor() {
        QuoteHomePage homePage = new QuoteHomePage(driver);

        logInfo("Opening application");
        homePage.openPage(ConfigReader.getAppUrl());

        String quote = "Blue Color Test Quote";
        homePage.addQuoteWithColor(quote, "Blue");

        Assert.assertTrue(homePage.isQuoteDisplayed(quote), "Quote should be displayed");
        logPass("Blue color quote added successfully");
    }

    @Test(description = "Test quote color selection - Green")
    public void addQuoteWithGreenColor() {
        QuoteHomePage homePage = new QuoteHomePage(driver);

        logInfo("Opening application");
        homePage.openPage(ConfigReader.getAppUrl());

        String quote = "Green Color Test Quote";
        homePage.addQuoteWithColor(quote, "Green");

        Assert.assertTrue(homePage.isQuoteDisplayed(quote), "Quote should be displayed");
        logPass("Green color quote added successfully");
    }

    @Test(description = "Test empty quote submission")
    public void submitEmptyQuote() {
        QuoteHomePage homePage = new QuoteHomePage(driver);

        logInfo("Opening application");
        homePage.openPage(ConfigReader.getAppUrl());

        int initialCount = homePage.getQuoteCount();
        homePage.addQuoteWithColor("", "Yellow");

        int finalCount = homePage.getQuoteCount();
        Assert.assertEquals(finalCount, initialCount, "Empty quote should not be added");

        logPass("Empty quote submission handled correctly");
    }
}
