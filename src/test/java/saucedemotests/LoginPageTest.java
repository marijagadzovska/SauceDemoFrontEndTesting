package saucedemotests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.ProductsPage;

import static org.junit.Assert.*;

public class LoginPageTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private ProductsPage productsPage;


    @Before
    public void setUp() {
        //Initialize ChromeDriver instance
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
    }

    @Test
    public void loginTest() {
        //Enter username and password
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");

        //Click on the login button
        loginPage.clickLoginButton();

        //verify login successful
        assertTrue(productsPage.isProductsPageDisplayed());
    }

    @Test
    public void errorMessage() {
        loginPage.enterUsername("sdsd");
        loginPage.enterPassword("dfsf");

        //Click on the login button
        loginPage.clickLoginButton();
        System.out.println(loginPage.getErrorMessage());
        assertEquals("Epic sadface: Username and password do not match any user in this service",loginPage.getErrorMessage());
    }

    @Test
    public void errorMessages() {
        loginPage.enterUsername("locked_out_user");
        loginPage.enterPassword("secret_sauce");

        //Click on the login button
        loginPage.clickLoginButton();
        System.out.println(loginPage.getErrorMessage());
        assertEquals("Epic sadface: Sorry, this user has been locked out.",loginPage.getErrorMessage());
    }

    @Test
    public void errorMessageStandardUser() {
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("");

        //Click on the login button
        loginPage.clickLoginButton();
        System.out.println(loginPage.getErrorMessage());
        assertEquals("Epic sadface: Password is required",loginPage.getErrorMessage());
    }

    @Test
    public void errorMessageUsernameRequired() {
        loginPage.enterUsername("");
        loginPage.enterPassword("");

        loginPage.clickLoginButton();
        System.out.println(loginPage.getErrorMessage());
        assertEquals("Epic sadface: Username is required",loginPage.getErrorMessage());
    }

    @Test
    public void errorMessageXButtonTest(){
        loginPage.clickLoginButton();
        loginPage.clickXErrorMessageButton();

        assertFalse(loginPage.isErrorMessageDisplayed());
    }

    @Test
    public void loginFormInitialStateUserInterfacesTest(){
        assertEquals("#3ddc91",loginPage.getLoginButtonColor());
        assertEquals("16px",loginPage.getLoginButtonFontSize());
        assertEquals("\"DM Sans\", Arial, Helvetica, sans-serif",loginPage.getLoginButtonFontType());

        assertEquals("14px",loginPage.getUsernameFontSize());
        assertEquals("\"DM Sans\", Arial, Helvetica, sans-serif",loginPage.getUsernameFontType());

        assertEquals("14px",loginPage.getPasswordFontSize());
        assertEquals("\"DM Sans\", Arial, Helvetica, sans-serif",loginPage.getPasswordFontType());

    }

    @Test
    public void loginFormErrorStateUserInterfacesTest() {
        loginPage.clickLoginButton();
        assertEquals("#e2231a",loginPage.getUsernameBorderButtonFieldColor());
        assertEquals("#e2231a",loginPage.getPasswordBorderButtonFieldColor());
        assertEquals("#e2231a",loginPage.getErrorMessageContainerColor());
    }

    @After
    public void tearDown(){
        driver.quit();
    }

}
