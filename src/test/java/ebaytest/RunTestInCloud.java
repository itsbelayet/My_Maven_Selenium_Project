package ebaytest;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class RunTestInCloud {

    private static WebDriver driver;
    private static final Logger logger = Logger.getLogger(RunTestInCloud.class);


//    @BeforeMethod
//    private static WebDriver setupCloud() throws MalformedURLException {
//        String userName = "belayethossain_dGwQnL";
//        String accessKey = "5dxDZbfgQEpj2x5KmFtC";
//
//        String urlOfBrowserstack = "https://" + userName + ":" + accessKey + "@hub-cloud.browserstack.com/wd/hub";
//        URL url = new URL(urlOfBrowserstack);//
//        DesiredCapabilities caps = new DesiredCapabilities();
//        caps.setCapability("os_version", "Mojave");
//        caps.setCapability("resolution", "1600x1200");
//        caps.setCapability("browser", "Chrome");
//        caps.setCapability("browser_version", "91.0");
//        caps.setCapability("os", "OS X");
//        caps.setCapability("name", "My New cloud execution test : 01.1");
//        WebDriver driver = new RemoteWebDriver(url, caps);//
//        return driver;
//    }

    @BeforeMethod
    private static void setupBrowser() {
        System.setProperty("webdriver.chrome.driver", "BrowserDriver/windows/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public static void closeBrowser() {
        driver.quit();
    }

    // Waiting Method
    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Navigate Back
    public static void navigateBack() {     // This Method perform to Back one screen
        driver.navigate().back();
    }

    @Test(enabled = true)
    public static void testGoogleSearchBox() throws InterruptedException {
        driver.get("https://www.google.com/");
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input")).sendKeys("Belayet");
        //logger.info("Hi, Successfully Find Search Box");
        closeBrowser();
    }

    @Test(enabled = true)
    public static void testYoutubeSearchBox() {
        driver.get("https://www.amazon.com/");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Mobile");
        driver.findElement(By.cssSelector("#nav-search-submit-text > input")).click();
        //logger.info("Hi, Successfully Click the Search Button");
        closeBrowser();
    }

    @Test(enabled = true)
    public static void testSearchBoxGoogle() {
        driver.get("https://www.google.com/");
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input")).sendKeys("Dhaka");
        //logger.info("Hi, Successfully Search Box");
        closeBrowser();
    }

    @Test(enabled = true)
    public static void testSearchBoxYoutube() {
        driver.get("https://www.amazon.com/");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Mobile");
        driver.findElement(By.cssSelector("#nav-search-submit-text > input")).click();
        //logger.info("Hi, Successfully Find Search Box");
        closeBrowser();
    }

    @Test(enabled = true)
    public static void checkUrl() {
        driver.get("https://www.google.com/");
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.google.com/";
        Assert.assertEquals(actualUrl, expectedUrl, "Hi, Url Not Match");
        //logger.info("Hi, Assertion Successfull");
        closeBrowser();
    }

    @Test(enabled = true)
    public static void checkLogo() {
        driver.get("https://www.ebay.com/");
        boolean actualDisplay = driver.findElement(By.id("gh-la")).isDisplayed();
        //Assert.assertEquals(actualDisplay,true,"Hi, Logo Not Display");
        Assert.assertTrue(actualDisplay, "Hi, Logo Not Display");      //Alternative way:
        //logger.info("Hi, Logo can visible");
        closeBrowser();
    }

    @Test(enabled = true)
    public static void checkBox2() {
        driver.get("https://www.ebay.com/");
        driver.findElement(By.xpath("//*[@id='gh-ac']")).sendKeys("dslr camera");
        driver.findElement(By.xpath("//*[@id='gh-btn']")).click();
        String actualText = driver.findElement(By.xpath("//h1[@class='srp-controls__count-heading']")).getText();
        Assert.assertTrue(actualText.contains("dslr camera"), "Hi, Tex Not Match");
        // logger.info("Hi, Successfully Search Box");
        closeBrowser();
    }

    @Test(enabled = true)
    public static void dropDown() {          // Scroll Down
        driver.get("https://www.ebay.com/");
        WebElement dropDownElement = driver.findElement(By.id("gh-cat"));
        Select select = new Select(dropDownElement);
        select.selectByVisibleText("Travel");
        driver.findElement(By.id("gh-btn")).click();
        //logger.info("Hi, Successfully Click");
        closeBrowser();
    }

    @Test(enabled = true)
    public static void selectByMouseHover() {       // Mouse Hover
        driver.get("https://www.ebay.com/");
        WebElement item = driver.findElement(By.linkText("Motors"));
        Actions actions = new Actions(driver);
        actions.moveToElement(item).build().perform();
        driver.findElement(By.linkText("Motorcycles")).click();
        //logger.info("Hi, Successfully Click Link Text");
        closeBrowser();
    }

    @Test(enabled = true)
    public static void scrollDown() {
        driver.get("https://www.ebay.com/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1500)");
        //logger.info("Hi, Successfully Scroll Down");
        closeBrowser();
    }

    @Test(enabled = true)
    public static void scrollDownToElement() {
        driver.get("https://www.ebay.com/");
        WebElement element = driver.findElement(By.linkText("Security center"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        //logger.info("Hi, Successfully Scroll down to Element");
        closeBrowser();
    }

    @Test(enabled = true)
    public static void dragNdrop() {     // Drag and Drop
        driver.get("http://demo.guru99.com/test/drag_drop.html");
        WebElement source = driver.findElement(By.xpath("(//li[@id='fourth'])[1]"));
        WebElement destination = driver.findElement(By.id("amt7"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(source, destination).build().perform();
        //logger.info("Hi, Successfully Drag and Draw");
        closeBrowser();
    }

    @Test(enabled = true)
    public static void scrollToFrame() {
        driver.get("https://demoqa.com/frames");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)");     // It's Scroll the Main Frame
        driver.switchTo().frame("frame2");
        js.executeScript("window.scrollBy(0,1000)");    // It's Scroll the 2nd Frama
        driver.switchTo().defaultContent();
        //logger.info("Hi, Successfully scroll Frame");
        closeBrowser();
    }

    @Test(enabled = true)
    public static void extractElementFromDropDownOptions() {
        driver.get("https://www.ebay.com/");
        List<WebElement> dropDownList = driver.findElements(By.xpath("//*[@id='gh-cat']/option"));
        System.out.println(dropDownList.size());
        for (WebElement ddl : dropDownList) {
            System.out.println(ddl.getText());                  // Display Options Texts
            //System.out.println(ddl.getAttribute("value"));    // Display Options values
        }
        //logger.info("Successfully Display Option Texts");
        closeBrowser();
    }

    @Test(enabled = true)
    public void clickOnRegister() {
        driver.get("https://www.ebay.com/");
        driver.findElement(By.linkText("Security center")).click();
        navigateBack();
        //logger.info("Hi, Successfully Click Link Text Register");
        closeBrowser();
    }

    @Test(enabled = true)
    public void selectFromDropdown() {
        driver.get("https://www.ebay.com/");
        WebElement dropdownMenu = driver.findElement(By.id("gh-cat"));
        Select select = new Select(dropdownMenu);
        select.selectByVisibleText("Music");
        //logger.info("Hi, Successfully Select from Drop Box");
        closeBrowser();
    }

    @Test(enabled = true)
    public void handlePopupWindow() {    // Popup menue can't view properly
        driver.get("http://demo.guru99.com/test/delete_customer.php");
        driver.findElement(By.name("cusid")).sendKeys("1");
        driver.findElement(By.name("submit")).click();
        driver.switchTo().alert().accept();
        //logger.info("Hi, Successfully Handle Popup Window");
        closeBrowser();
    }

    @Test(enabled = true)
    public void handleMultipleWindow() {
        driver.get("https://www.google.com/gmail/about/#");
        driver.findElement(By.linkText("Create an account")).click();
        Set<String> afterOpenNewWindow = driver.getWindowHandles();
        String currentWindow = driver.getWindowHandle();

        for (String win : afterOpenNewWindow) {
            if (!win.equalsIgnoreCase(currentWindow)) {
                driver.switchTo().window(win);
            }
        }
        driver.findElement(By.xpath("//*[@id='firstName']")).sendKeys("Mohammed");
        driver.findElement(By.xpath("//*[@id='lastName']")).sendKeys("Hossain");
        driver.findElement(By.xpath("//*[@id='passwd']/div[1]/div/div[1]/input")).sendKeys("123456789");
        driver.findElement(By.xpath("//*[@name='ConfirmPasswd']")).sendKeys("12345678");
        driver.findElement(By.xpath("//*[@id='accountDetailsNext']")).click();
        String actualText = driver.findElement(By.xpath("//*[@id='view_container']/div/div/div[2]/div/div[1]/div/form/span/section/div/div/div[3]/div[2]/div[2]/span")).getText();
        Assert.assertEquals(actualText, "Those passwords didn’t match. Try again.", "Hi, Test fail");
        //logger.info("Hi, Successfully Handel Multiple Window");
        closeBrowser();
    }

    @Test(enabled = true)
    public static void checkBox1() {
        driver.get("https://www.bestbuy.com/");
        try {
            driver.findElement(By.xpath("//button[@class='c-close-icon c-modal-close-icon']")).click();
        } catch (Exception ignore) {

        }
        waitFor(2);
        driver.findElement(By.xpath("//*[@id='gh-search-input']")).sendKeys("dslr camera");
        driver.findElement(By.xpath("//button[@class='header-search-button']")).click();
        String actualText = driver.findElement(By.xpath("//h1[@class='search-title']")).getText();
        String expectedText = "\"dslr camera\"";
        Assert.assertEquals(actualText, expectedText, "Hi, Text Not Match");
        //logger.info("Hi, Successfully Click search Box");
        closeBrowser();
    }
}
