package saucedemotests;

import org.junit.After;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.ProductsPage;

import static org.junit.Assert.assertEquals;

public class LoginPageParameterizedTest {
    private WebDriver driver;
    private LoginPage loginPage;
    @ParameterizedTest
    @ValueSource(strings = {"wrong username","standard_user"})
    void errorMessageInvalidUsernameAndPasswordTest(String username) {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        loginPage = new LoginPage(driver);

        loginPage.enterUsername(username);
        loginPage.enterPassword("password");

        loginPage.clickLoginButton();

        assertEquals("Epic sadface: Username and password do not match any user in this service",loginPage.getErrorMessage());
    }
    @After
    public void tearDown(){
        driver.quit();
    }

}
