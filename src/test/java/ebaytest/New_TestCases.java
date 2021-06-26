package ebaytest;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class New_TestCases extends New_SetupBrowser {

    private static final Logger logger = Logger.getLogger(New_TestCases.class);

    @Test(enabled = true)
    public static void checkLogo() {
        boolean actualDisplay = driver.findElement(By.id("gh-la")).isDisplayed();
        Assert.assertTrue(actualDisplay, "Hi, Logo Not Display");      //Alternative way:
        logger.info("Hi, Logo can visible");
        waitFor(2);
        closeBrowser();
    }
    @Test(enabled = true)
    public static void checkUrl() {
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.ebay.com/";
        Assert.assertEquals(actualUrl, expectedUrl, "Hi, Url Not Match");
        logger.info("Hi, Assertion Successfull");
        waitFor(2);
        closeBrowser();
    }

}
