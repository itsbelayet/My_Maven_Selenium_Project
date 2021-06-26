package amazon;

import config.WebAPI;

public class HomePageWebElements extends WebAPI {

    public String serchBoxWebElements = "twotabsearchtextbox";    // Search Box for Tex Box
    public String searchToys = "toys";
    public String serchHand = "Hand Sanitizer";
    public String searchRolex = "rolex";
    public String serchIphone = "iphone 12 pro max";
    public String serchComputer = "Desktop Computer";

    public String serchButtonWebElement = "#nav-search-submit-text > input";  // Search Box Button for Click

    // Actual Text
    public String toysActualTextWebElement = "//span[@class='a-color-state a-text-bold']";
    public String actualProductRolex = "//*[@id=\"search\"]/span/div/span/h1/div/div[1]/div/div/span[3]";
    public String actualProductHand = "//*[@id=\"search\"]/span/div/span/h1/div/div[1]/div/div/span[3]";
    public String actualProductIphone = "//span[text()='\"iphone 12 pro max\"']";
    public String actualProductComputer="//*[@class=\"a-color-state a-text-bold\"]";
    // Login
    public String logInMail = "ap_email";
    public String halloSignIn = "//span[text()='Hello, Sign in']";
    public String emailName = "mh.shahib@gmail.com";
    public String passwordButton = "//*[@id=\"ap_password\"]";
    public String passWord = "Test123456";
    public String continueButton = "//*[@id=\"continue\"]";
    public String clickButton = "//*[@id=\"signInSubmit\"]";

    public String continueButton1 = "//span[contains(text(),'Drawing Tablet')]";
    public String continueButton2 = "//*[@id=\"a-autoid-13-announce\"]/div/div[2]";
    public String continueButton3 = "//*[@id=\"a-autoid-0-announce\"]";
    public String continueButton4 = "//*[@id=\"quantity_2\"]";
    public String continueButton5 = "//*[@id=\"add-to-cart-button\"]";
    public String continueButton6 = "//*[@id=\"hlb-ptc-btn-native\"]";

}
