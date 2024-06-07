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

public class YourCartTest {

    private WebDriver driver;
    private LoginPage loginPage;
    private ProductsPage productsPage;
    private YourCartPage yourCartPage;
    private CheckoutYourInformationPage checkoutYourInformationPage;

    @Before
    public void setUp() {
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
    }

    @Test
    public void continueShoppingButtonTest(){
        productsPage.clickYourCartButton();
        yourCartPage.continueShoppingButton();

        assertTrue(productsPage.isProductsPageDisplayed());
    }

    @Test
    public void checkoutButtonTest(){
        productsPage.clickYourCartButton();
        yourCartPage.clickCheckoutButton();

        assertTrue(checkoutYourInformationPage.isCheckoutYourInformationPageDisplayed());
    }

    @Test
    public void addOneItemToYourCartAndRemoveIt(){
        productsPage.clickAddBackpackToCardButton();
        productsPage.clickYourCartButton();
        assertEquals("1",productsPage.itemCountOnCart());
        assertEquals("Sauce Labs Backpack",yourCartPage.getTextFromBackpackTitle());
        assertEquals("$29.99",yourCartPage.getPriceFromFirstItem());
        assertEquals("Remove",yourCartPage.getBackpackRemoveButtonText());
        yourCartPage.clickRemoveButtonInYourCartPage();
        assertFalse(yourCartPage.isBackpackItemDisplayed());
        assertFalse(yourCartPage.isItemNumberDisplayed());
    }

    @Test
    public void addTwoItemsToYourCart(){
        productsPage.clickAddTshirtToCardButton();
        productsPage.clickAddBikeToCardButton();
        productsPage.clickYourCartButton();
        assertEquals("2",productsPage.itemCountOnCart());
        assertEquals("Sauce Labs Bolt T-Shirt",yourCartPage.getTextFromTshirtTitle());
        assertEquals("Get your testing superhero on with the Sauce Labs bolt T-shirt. From American Apparel, 100% ringspun combed cotton, heather gray with red bolt.",yourCartPage.getDescriptionFromFirstItem());
        assertEquals("$15.99",yourCartPage.getPriceFromFirstItem());


        assertEquals("Sauce Labs Bike Light",yourCartPage.getTextFromBikeTitle());
        assertEquals("A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included.",yourCartPage.getDescriptionFromSecondItem());
        assertEquals("$9.99",yourCartPage.getPriceFromSecondItem());
        yourCartPage.clickRemoveBikeButtonInYourCartPage();
        assertFalse(yourCartPage.isBikeItemDisplayed());
        assertEquals("1",yourCartPage.itemCountOnCart());
    }

    @Test
    public void colorOfTheCheckoutButton(){
        productsPage.clickYourCartButton();
        assertEquals("#3ddc91",yourCartPage.colorOFTheCheckoutButton());
        assertEquals("#ffffff",yourCartPage.colorOFTheContinueShoppingButton());
    }

    @After
    public void tearDown(){
        driver.quit();
    }


}
