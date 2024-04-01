package saucedemotests;

import org.checkerframework.checker.signature.qual.DotSeparatedIdentifiersOrPrimitiveType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.ProductsPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ProductsPageTest {
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

        //Enter username and password
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");

        //Click on the login button
        loginPage.clickLoginButton();
    }

    @Test
    public void addToCartTest(){
        productsPage.clickAddBackpackToCardButton();
        assertEquals("Remove",productsPage.returnTextFromAddBackpackToCardButton());
    }
    @Test
    public void orderingDropDownTest(){
        System.out.println("-----"+productsPage.getAllOptionsFromOrderingDropDown().get(0).getText());
        assertEquals("Name (A to Z)",productsPage.getAllOptionsFromOrderingDropDown().get(0).getText());
        assertEquals("Name (Z to A)",productsPage.getAllOptionsFromOrderingDropDown().get(1).getText());
        assertEquals("Price (low to high)",productsPage.getAllOptionsFromOrderingDropDown().get(2).getText());
        assertEquals("Price (high to low)",productsPage.getAllOptionsFromOrderingDropDown().get(3).getText());
    }

    @Test
    public void orderingProductsFromHighToLowPrice(){
        productsPage.selectOrderingDropDownOption(3);

        assertEquals("Price (high to low)",productsPage.getTextFromDropdown());
        assertEquals("$49.99",productsPage.getMostExpensivePriceText());
    }

    @Test
    public void orderingProductsFromLowToHighPrice(){
        productsPage.selectOrderingDropDownOption(2);

        assertEquals("Price (low to high)",productsPage.getTextFromDropdown());
        assertEquals("$7.99",productsPage.getMostExpensivePriceText());
    }

    @Test
    public void orderingProductsFromNameZToATest(){
        productsPage.selectOrderingDropDownOption(1);

        assertEquals("Name (Z to A)",productsPage.getTextFromDropdown());
        assertEquals("Test.allTheThings() T-Shirt (Red)",productsPage.getFirstProductFromZtoAText());
    }

    @Test
    public void orderingProductsFromNameAToZTest(){
        productsPage.selectOrderingDropDownOption(0);

        assertEquals("Name (A to Z)",productsPage.getTextFromDropdown());
        assertEquals("Sauce Labs Backpack",productsPage.getFirstProductFromAtoZText());
    }

    @Test
    public void colorOfTheElementsTest(){
        productsPage.clickAddBackpackToCardButton();
        assertEquals("#e2231a",productsPage.getTheColorOfTheRemoveButton());
    }

    @Test
    public void testBackpackTitleTextColor(){
        assertEquals("#18583a",productsPage.getColorFromBackpackTitle());
        productsPage.hoverElement();
        assertEquals("#3ddc91",productsPage.getColorFromBackpackTitle());
    }
    @After
    public void tearDown(){
        driver.quit();
    }

}
