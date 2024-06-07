package saucedemotests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.ProductsPage;
import pages.SideBarMenu;

import static org.junit.Assert.assertEquals;

public class SideBarMenuTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private ProductsPage productsPage;
    private SideBarMenu sideBarMenu;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        sideBarMenu = new SideBarMenu(driver);

        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");

        loginPage.clickLoginButton();

        productsPage.clickBurgerMenu();
    }

    @Test
    public void hoverOnAboutElementTest()throws InterruptedException{
        Thread.sleep(500);
        sideBarMenu.hoverAboutElement();
        assertEquals("About",sideBarMenu.getAboutText());
        assertEquals("#3ddc91",sideBarMenu.getColorFromAboutTitle());
        assertEquals("https://saucelabs.com/",sideBarMenu.getHrefFromAbout());
    }
    @Test
    public void hoverOnAllItemsElementTest()throws InterruptedException {
        Thread.sleep(500);
        sideBarMenu.hoverAllItemsElement();
        assertEquals("All Items",sideBarMenu.getAllItemsText());
        assertEquals("#3ddc91", sideBarMenu.getColorFromAllItemsTitle());
    }
    @Test
    public void hoverOnLogoutElementTest()throws InterruptedException {
        Thread.sleep(500);
        sideBarMenu.hoverLogoutElement();
        assertEquals("Logout",sideBarMenu.getLogoutText());
        assertEquals("#3ddc91",sideBarMenu.getColorFromLogoutTitle());
    }
    @Test
    public void hoverOnResetAppStateTest()throws InterruptedException {
        Thread.sleep(500);
        sideBarMenu.hoverOnResetAppStateElement();
        assertEquals("Reset App State",sideBarMenu.getResetAppStateText());
        assertEquals("#3ddc91", sideBarMenu.getColorFromResetAppStateTitle());
    }
    @After
    public void tearDown(){
        driver.quit();
    }
}
