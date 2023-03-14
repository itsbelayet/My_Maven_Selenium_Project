package amazon;

import org.openqa.selenium.By;
import org.testng.Assert;

public class HomePage extends HomePageWebElements {

    public void checkHomePageTitle() throws InterruptedException {
        String expectedTitle = "Amazon.com. Spend less. Smile more.";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Test Fail: Title does not match");
        Thread.sleep(5000);
    }
    public void searchBox1() throws InterruptedException {
        driver.findElement(By.id(serchBoxWebElements)).sendKeys(searchToys);
        Thread.sleep(3000);
        driver.findElement(By.cssSelector(serchButtonWebElement)).click();
        Thread.sleep(5000);
    }
    public void validationsBox1(){
        String expectedText = "\"toys\"";
        String actualText = driver.findElement(By.xpath(toysActualTextWebElement)).getText();
        Assert.assertEquals(actualText, expectedText, "Test Fail: Search keyword does not match");
    }
    public void searchBox2() throws InterruptedException {
        driver.findElement(By.id(serchBoxWebElements)).sendKeys(serchHand);
        Thread.sleep(3000);
        driver.findElement(By.cssSelector(serchButtonWebElement)).click();
        Thread.sleep(5000);
    }
    public void validatesearchBox2(){
        String expectedText = "\"Hand Sanitizer\"";
        String actualText = driver.findElement(By.xpath(actualProductHand)).getText();
        Assert.assertEquals(actualText, expectedText, "Test Fail: Search keyword does not match");
    }
    public void searchBox3() throws InterruptedException {
        driver.findElement(By.id(serchBoxWebElements)).sendKeys(searchRolex);
        Thread.sleep(3000);
        driver.findElement(By.cssSelector(serchButtonWebElement)).click();      //serchClickButton
        Thread.sleep(5000);
    }
    public void validatesearchBox3(){
        String expectedText = "\"rolex\"";
        String actualText = driver.findElement(By.xpath(actualProductRolex)).getText();
        Assert.assertEquals(actualText, expectedText, "Test Fail: Search keyword does not match");
    }
    public void searchBox4() throws InterruptedException {
        driver.findElement(By.id(serchBoxWebElements)).sendKeys(serchIphone);
        Thread.sleep(3000);
        driver.findElement(By.cssSelector(serchButtonWebElement)).click();
        Thread.sleep(5000);
    }
    public void validatesearchBox4(){
        String expectedText = "\"iphone 13 pro max\"";
        String actualText = driver.findElement(By.xpath(actualProductIphone)).getText();
        Assert.assertEquals(actualText, expectedText, "Test Fail: Search keyword does not match");
    }

    public void searchBox5() throws InterruptedException {
        driver.findElement(By.id(serchBoxWebElements)).sendKeys(serchComputer);
        Thread.sleep(3000);
        driver.findElement(By.cssSelector(serchButtonWebElement)).click();
        Thread.sleep(5000);
    }
    public void validatesearchBox5(){
        String expectedText = "\"Desktop Computer\"";
        String actualText = driver.findElement(By.xpath(actualProductComputer)).getText();
        Assert.assertEquals(actualText, expectedText, "Test Fail: Search keyword does not match");
        //System.out.println(actualText);
    }

    public void loginWithValidCredential(){
        driver.findElement(By.xpath(halloSignIn)).click();
        driver.findElement(By.id(logInMail)).sendKeys(emailName);
        driver.findElement(By.xpath(continueButton)).click();
        driver.findElement(By.xpath(passwordButton)).sendKeys(passWord);
        driver.findElement(By.xpath(clickButton)).click();
    }

    public void searchToys(){
        driver.findElement(By.id(serchBoxWebElements)).sendKeys(searchToys);
        driver.findElement(By.cssSelector(serchButtonWebElement)).click();
//        driver.findElement(By.xpath(continueButton1)).click();
//        driver.findElement(By.xpath(continueButton2)).click();
//        driver.findElement(By.xpath(continueButton3)).click();
//        driver.findElement(By.xpath(continueButton4)).click();
//        driver.findElement(By.xpath(continueButton5)).click();
//        driver.findElement(By.xpath(continueButton6)).click();
     }
}
