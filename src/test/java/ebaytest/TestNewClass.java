package ebaytest;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class TestNewClass {

    public static WebDriver driver;
    private static final Logger logger = Logger.getLogger(TestNewClass.class);


    // Setup Browser:
    // One approach to setup Browser Individually
    public static void setupChromeBrowser(String url) {
        System.setProperty("webdriver.chrome.driver", "BrowserDriver/windows/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(url);
    }
    public static void setupFirefoxBrowser(String url) {
        System.setProperty("webdriver.gecko.driver", "BrowserDriver/Windows/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get(url);
    }



    // Another approach to setup Browser Combined
    public static void setupBrowser(String browserName, String url) {
        if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "BrowserDriver/windows/chromedriver.exe");
            driver = new ChromeDriver();
        } else {
            System.setProperty("webdriver.gecko.driver", "BrowserDriver/Windows/geckodriver.exe");
            driver = new FirefoxDriver();
        }
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get(url);
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



    // Run Test case using Individual Browser setup
    @Test(enabled = true)
    public static void testGoogleSearchBox() throws InterruptedException {
        setupFirefoxBrowser("https://www.google.com/");
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input")).sendKeys("Belayet");
        logger.info("Hi, Successfully Find Search Box");
        closeBrowser();
    }
    @Test(enabled = true)
    public static void testYoutubeSearchBox() {         //
        setupChromeBrowser("https://www.amazon.com/");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Mobile");
        driver.findElement(By.cssSelector("#nav-search-submit-text > input")).click();
        logger.info("Hi, Successfully Click the Search Button");
        closeBrowser();
    }



    // Run Test case using Combined Browser setup
    @Test(enabled = true)
    public static void testSearchBoxGoogle() {
        setupBrowser("chrome", "https://www.google.com/");
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input")).sendKeys("Dhaka");
        logger.info("Hi, Successfully Search Box");
        closeBrowser();
    }

    @Test(enabled = true)
    public static void testSearchBoxYoutube() {
        setupBrowser("Firefox", "https://www.amazon.com/");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Mobile");
        driver.findElement(By.cssSelector("#nav-search-submit-text > input")).click();
        logger.info("Hi, Successfully Find Search Box");
        closeBrowser();
    }
    @Test(enabled = true)
    public static void checkUrl() {
        setupBrowser("chrome", "https://www.google.com/");
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.google.com/";
        Assert.assertEquals(actualUrl, expectedUrl, "Hi, Url Not Match");
        logger.info("Hi, Assertion Successfull");
        closeBrowser();
    }
    @Test(enabled = true)
    public static void checkLogo() {
        setupBrowser("chrome", "https://www.ebay.com/");
        boolean actualDisplay = driver.findElement(By.id("gh-la")).isDisplayed();
        //Assert.assertEquals(actualDisplay,true,"Hi, Logo Not Display");
        Assert.assertTrue(actualDisplay, "Hi, Logo Not Display");      //Alternative way:
        logger.info("Hi, Logo can visible");
        closeBrowser();
    }
    @Test(enabled = true)
    public static void checkBox2() {
        setupBrowser("chrome", "https://www.ebay.com/");
        driver.findElement(By.xpath("//*[@id='gh-ac']")).sendKeys("dslr camera");
        driver.findElement(By.xpath("//*[@id='gh-btn']")).click();
        String actualText = driver.findElement(By.xpath("//h1[@class='srp-controls__count-heading']")).getText();
        Assert.assertTrue(actualText.contains("dslr camera"), "Hi, Tex Not Match");

        //***************** Alternative approach
//        String actualText = driver.findElement(By.xpath("//*[@id='mainContent']/div[1]/div/div[2]/div[1]/div[1]/h1/span[2]")).getText();
//        String expectedText = "dslr camera";
//        Assert.assertEquals(actualText,expectedText,"Hi, Tex Not Match");
        logger.info("Hi, Successfully Search Box");
        closeBrowser();
    }
    @Test(enabled = true)
    public static void dropDown() {          // Scroll Down
        setupBrowser("chrome", "https://www.ebay.com/");
        WebElement dropDownElement = driver.findElement(By.id("gh-cat"));
        Select select = new Select(dropDownElement);
        select.selectByVisibleText("Travel");
        //select.selectByIndex(30);
        driver.findElement(By.id("gh-btn")).click();
        logger.info("Hi, Successfully Click");
        closeBrowser();
    }
    @Test(enabled = true)
    public static void selectByMouseHover() {       // Mouse Hover
        setupBrowser("chrome", "https://www.ebay.com/");
        WebElement item = driver.findElement(By.linkText("Motors"));
        Actions actions = new Actions(driver);
        actions.moveToElement(item).build().perform();
        driver.findElement(By.linkText("Motorcycles")).click();
        logger.info("Hi, Successfully Click Link Text");
        closeBrowser();
    }
    @Test(enabled = true)
    public static void scrollDown() {
        setupBrowser("chrome", "https://www.ebay.com/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1500)");
        logger.info("Hi, Successfully Scroll Down");
        closeBrowser();
    }
    @Test(enabled = true)
    public static void scrollDownToElement() {
        setupBrowser("chrome", "https://www.ebay.com/");
        WebElement element = driver.findElement(By.linkText("Security center"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        logger.info("Hi, Successfully Scroll down to Element");
        closeBrowser();
    }
    @Test(enabled = true)
    public static void dragNdrop() {     // Drag and Drop
        setupBrowser("chrome", "http://demo.guru99.com/test/drag_drop.html");
        WebElement source = driver.findElement(By.xpath("(//li[@id='fourth'])[1]"));
        WebElement destination = driver.findElement(By.id("amt7"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(source, destination).build().perform();
        logger.info("Hi, Successfully Drag and Draw");
        closeBrowser();
    }
    @Test(enabled = true)
    public static void scrollToFrame() {
        setupBrowser("chrome", "https://demoqa.com/frames");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)");     // It's Scroll the Main Frame
        driver.switchTo().frame("frame2");
        js.executeScript("window.scrollBy(0,1000)");    // It's Scroll the 2nd Frama
        driver.switchTo().defaultContent();
        logger.info("Hi, Successfully scroll Frame");
        closeBrowser();
    }
    @Test(enabled = true)
    public static void extractElementFromDropDownOptions() {
        setupBrowser("chrome", "https://www.ebay.com/");
        List<WebElement> dropDownList = driver.findElements(By.xpath("//*[@id='gh-cat']/option"));
        System.out.println(dropDownList.size());
        for (WebElement ddl : dropDownList) {
            System.out.println(ddl.getText());                  // Display Options Texts
            //System.out.println(ddl.getAttribute("value"));    // Display Options values
        }
        logger.info("Successfully Display Option Texts");
        closeBrowser();
    }
    @Test(enabled = true)
    public void clickOnRegister() {
        setupBrowser("chrome", "https://www.ebay.com/");
        driver.findElement(By.linkText("Security center")).click();
        navigateBack();
        logger.info("Hi, Successfully Click Link Text Register");
        closeBrowser();
    }
    @Test(enabled = true)
    public void selectFromDropdown() {
        setupBrowser("chrome", "https://www.ebay.com/");
        WebElement dropdownMenu = driver.findElement(By.id("gh-cat"));
        Select select = new Select(dropdownMenu);
        select.selectByVisibleText("Music");
        logger.info("Hi, Successfully Select from Drop Box");
        closeBrowser();
    }
    @Test(enabled = true)
    public void handlePopupWindow() {    // Popup menue can't view properly
        setupBrowser("chrome", "http://demo.guru99.com/test/delete_customer.php");
        driver.findElement(By.name("cusid")).sendKeys("1");
        driver.findElement(By.name("submit")).click();
//        String dataFromAlert=driver.switchTo().alert().getText();
//        System.out.println(dataFromAlert);
        driver.switchTo().alert().accept();
        //driver.switchTo().alert().accept();
        logger.info("Hi, Successfully Handle Popup Window");
        closeBrowser();
    }
    @Test(enabled = true)
    public static void checkBox1() {
        setupBrowser("chrome", "https://www.bestbuy.com/");
        
        // This try block used  when an unexpected popup will appear
        try{
            driver.findElement(By.xpath("//button[@class='c-close-icon c-modal-close-icon']")).click();
        }catch (Exception ignore){

        }
        waitFor(2);
        driver.findElement(By.xpath("//*[@id='gh-search-input']")).sendKeys("dslr camera");
        driver.findElement(By.xpath("//button[@class='header-search-button']")).click();
        String actualText = driver.findElement(By.xpath("//h1[@class='search-title']")).getText();
        String expectedText = "\"dslr camera\"";
        Assert.assertEquals(actualText, expectedText, "Hi, Text Not Match");
        logger.info("Hi, Successfully Click search Box");
        closeBrowser();
    }

    //************************* Problem
    @Test(enabled = true)
    public void handleMultipleWindow() {
        setupBrowser("chrome", "https://www.google.com/gmail/about/#");
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
        logger.info("Hi, Successfully Handel Multiple Window");
        closeBrowser();
    }

}
