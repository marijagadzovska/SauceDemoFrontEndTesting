package saucedemotests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CheckoutYourInformationPage;
import pages.LoginPage;
import pages.ProductsPage;
import pages.YourCartPage;

import static org.junit.Assert.*;

public class CheckoutYourInformationPageTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private ProductsPage productsPage;
    private YourCartPage yourCartPage;
    private CheckoutYourInformationPage checkoutYourInformationPage;

    @Before
    public void setUp() {
        //Initialize ChromeDriver instance
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        yourCartPage = new YourCartPage(driver);
        checkoutYourInformationPage = new CheckoutYourInformationPage(driver);

        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");

        loginPage.clickLoginButton();
        productsPage.clickYourCartButton();
        yourCartPage.clickCheckoutButton();
    }

    @Test
    public void errorMessageForUsername(){
        checkoutYourInformationPage.clickContinueButton();
        checkoutYourInformationPage.getErrorMessage();
        assertEquals("Error: First Name is required",checkoutYourInformationPage.getErrorMessage());
        checkoutYourInformationPage.clickXErrorMessageButton();
        assertTrue(checkoutYourInformationPage.isErrorMessageDisplayed());
    }
    @Test
    public void errorMessageForLastname(){
        checkoutYourInformationPage.usernameField("John");
        checkoutYourInformationPage.zipCodeField("7000");
        checkoutYourInformationPage.clickContinueButton();
        checkoutYourInformationPage.getErrorMessage();
        assertEquals("Error: Last Name is required",checkoutYourInformationPage.getErrorMessage());
        checkoutYourInformationPage.clickXErrorMessageButton();
        assertTrue(checkoutYourInformationPage.isErrorMessageDisplayed());
    }
    @Test
    public void errorMessageForZipCode(){
        checkoutYourInformationPage.usernameField("John");
        checkoutYourInformationPage.lastnameField("Smith");
        checkoutYourInformationPage.clickContinueButton();
        checkoutYourInformationPage.getErrorMessage();
        assertEquals("Error: Postal Code is required",checkoutYourInformationPage.getErrorMessage());
        checkoutYourInformationPage.clickXErrorMessageButton();
        assertTrue(checkoutYourInformationPage.isErrorMessageDisplayed());
    }
    @After
    public void tearDown(){
        driver.quit();
    }
}
