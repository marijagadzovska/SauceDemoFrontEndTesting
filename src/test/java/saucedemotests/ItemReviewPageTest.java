package saucedemotests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ItemReviewPage;
import pages.LoginPage;
import pages.ProductsPage;

import static org.junit.Assert.*;

public class ItemReviewPageTest {

    private WebDriver driver;
    private LoginPage loginPage;
    private ProductsPage productsPage;
    private ItemReviewPage itemReviewPage;
    @Before
    public void setUp() {
        //Initialize ChromeDriver instance
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        itemReviewPage = new ItemReviewPage(driver);

        //Enter username and password
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");

        //Click on the login button
        loginPage.clickLoginButton();
    }

    @Test
    public void checkBackpackItemSeparatelyTest(){
        productsPage.clickAddBackpackToCardButton();
        productsPage.clickOnBackpackTitle();
        //System.out.println(itemReviewPage.getItemTitleText());
        assertEquals("#e2231a",itemReviewPage.getRemoveBackpackButtonColor());
        assertEquals("Sauce Labs Backpack",itemReviewPage.getItemTitleText());
        assertEquals("$29.99",itemReviewPage.getItemPrice());
        assertEquals("carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.",itemReviewPage.getItemDescriptionText());
        itemReviewPage.clickRemoveBackpack();
        assertEquals("#132322",itemReviewPage.getAddToCartBackpackButtonColor());
        assertFalse(itemReviewPage.isItemNumberDisplayed());
    }
    @After
    public void tearDown(){
        driver.quit();
    }
}
