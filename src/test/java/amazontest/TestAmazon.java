package amazontest;

import amazon.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestAmazon extends HomePage {
    @Test
    public void getPageTitle() throws InterruptedException {
        String expectedTitle="Amazon.com. Spend less. Smile more.";
        String actualTitle=driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle,"Test Fail: Title does not match");
    }
    @Test(enabled = true)
    public void checkPageTitle() throws InterruptedException {
        checkHomePageTitle();
    }
    @Test(enabled = true)
    public void loginTest(){
        loginWithValidCredential();
    }
    @Test(enabled = true)
    public void checksearchBox1() throws InterruptedException {
        searchBox1();
        validationsBox1();
    }
    @Test(enabled = true)
    public void checksearBox2() throws InterruptedException {
        searchBox2();
        validatesearchBox2();
    }
    @Test(enabled = true)
    public void checksearchBox3()throws InterruptedException{
        searchBox3();
        validatesearchBox3();
    }
    @Test(enabled = true)
    public void checksearchBox4() throws InterruptedException {
        searchBox4();
        validatesearchBox4();
    }
    @Test(enabled = true )
    public void checksearchBox5() throws InterruptedException {
        searchBox5();
        validatesearchBox5();
    }
    @Test(enabled = true)
    public void searchProduct(){
        searchToys();
    }
}
