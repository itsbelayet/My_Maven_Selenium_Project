package ebaytest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

public class MyCloudExecution {

    @Test
    public void validateUserCanExecuteTestsInBrowserstack() throws MalformedURLException {
        String userName = "belayethossain_dGwQnL";
        String accessKey = "5dxDZbfgQEpj2x5KmFtC";

        String urlOfBrowserstack = "https://" + userName + ":" + accessKey + "@hub-cloud.browserstack.com/wd/hub";
        URL url = new URL(urlOfBrowserstack);//

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("os_version", "Mojave");
        caps.setCapability("resolution", "1600x1200");
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "91.0");
        caps.setCapability("os", "OS X");
        caps.setCapability("name", "My cloud execution test : 01.6");

        WebDriver driver = new RemoteWebDriver(url, caps);//

        //Run Test case-1
//        driver.get("https://www.ebay.com/");
//        WebElement dropDownElement = driver.findElement(By.id("gh-cat"));
//        Select select = new Select(dropDownElement);
//        select.selectByVisibleText("Travel");
//        driver.findElement(By.id("gh-btn")).click();

        driver.get("https://www.bestbuy.com/");
        try{
            driver.findElement(By.xpath("//button[@class='c-close-icon c-modal-close-icon']")).click();
        }catch (Exception ignore){
        }
        driver.findElement(By.xpath("//*[@id='gh-search-input']")).sendKeys("dslr camera");
        driver.findElement(By.xpath("//button[@class='header-search-button']")).click();
        String actualText = driver.findElement(By.xpath("//h1[@class='search-title']")).getText();
        String expectedText = "\"dslr camera\"";
        Assert.assertEquals(actualText, expectedText, "Hi, Text Not Match");
        driver.quit();
    }
}
