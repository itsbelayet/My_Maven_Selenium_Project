package amazontest;

import amazon.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestAmazon extends HomePage {

    public void testGetTitle() throws InterruptedException {
        String amazonUrl="https://www.amazon.com/";
        String chromeDriverPath="BrowserDriver/windows/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",chromeDriverPath);
        WebDriver driver=new ChromeDriver();
        driver.get(amazonUrl);
        String expectedTitle="Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more1";
        String actualTitle=driver.getTitle();
        // Validate Title
        Assert.assertEquals(actualTitle,expectedTitle,"Test Fail: Title does not match");
        Thread.sleep(5000);
        driver.quit();
    }
    @Test(enabled = false)
    public void checkPageTitle() throws InterruptedException {
        checkHomePageTitle();
    }
    @Test(enabled = false)
    public void loginTest(){
        loginWithValidCredential();
    }

    @Test(enabled = false)
    public void checksearchBox1() throws InterruptedException {
        searchBox1();
        validationsBox1();
    }
    @Test(enabled = false)
    public void checksearBox2() throws InterruptedException {
        searchBox2();
        validatesearchBox2();
    }
    @Test(enabled = false)
    public void checksearchBox3()throws InterruptedException{
        searchBox3();
        validatesearchBox3();
    }
    @Test(enabled = false)
    public void checksearchBox4() throws InterruptedException {
        searchBox4();
        validatesearchBox4();
    }
    @Test(enabled = true)
    public void checksearchBox5() throws InterruptedException {
        searchBox5();
        validatesearchBox5();
    }
    @Test(enabled = false)
    public void searchProduct(){
        searchToys();
    }
}
