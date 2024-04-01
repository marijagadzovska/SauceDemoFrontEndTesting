package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ProductsPage {
    private WebDriver driver;

    Actions actions;

    private By burgerMenu = By.id("react-burger-menu-btn");
    private By productsTitle = By.className("title");
    private By addBackpackToCartButton = By.id("add-to-cart-sauce-labs-backpack");
    private By selectBackpack = By.id("item_4_title_link");
    private By backpackTitle = By.xpath("//*[@id=\"item_4_title_link\"]/div");
    private By addBikeToCartButton = By.id("add-to-cart-sauce-labs-bike-light");
    private By addTshirtToCartButton = By.id("add-to-cart-sauce-labs-bolt-t-shirt");
    private By textFromAddBackpackToCartButton = By.id("remove-sauce-labs-backpack");
    private By mostExpensivePriceText = By.xpath("//*[@id=\"inventory_container\"]/div/div[1]/div[2]/div[2]/div");
    private By yourCartIcon = By.id("shopping_cart_container");
    private By firstProductZtoA = By.id("item_3_title_link");
    private By firstProductAtoZ = By.id("item_4_title_link");
    private By cartItemNumber = By.className("shopping_cart_badge");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
    }

    public boolean isProductsPageDisplayed() {
        return driver.findElement(productsTitle).getText().equals("Products");
    }
    public void clickAddBackpackToCardButton(){
        driver.findElement(addBackpackToCartButton).click();
    }
    public void clickBurgerMenu(){
        driver.findElement(burgerMenu).click();
    }
    public void clickOnBackpackTitle(){
        driver.findElement(selectBackpack).click();
    }
    public String returnTextFromAddBackpackToCardButton(){
        return driver.findElement(textFromAddBackpackToCartButton).getText();
    }
    public List<WebElement> getAllOptionsFromOrderingDropDown(){
        Select orderingDropdown = new Select(driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select")));
        return orderingDropdown.getOptions();
    }
    public String getMostExpensivePriceText(){
        return driver.findElement(mostExpensivePriceText).getText();
    }
    public void selectOrderingDropDownOption(int optionNumber){
        Select orderingDropdown = new Select(driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select")));
        orderingDropdown.selectByIndex(optionNumber);
    }
    public String getTextFromDropdown(){
        Select orderingDropdown = new Select(driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select")));
        return orderingDropdown.getFirstSelectedOption().getText();
    }
    public void clickYourCartButton(){
        driver.findElement(yourCartIcon).click();
    }
    public String getFirstProductFromZtoAText(){
        return driver.findElement(firstProductZtoA).getText();
    }
    public String getFirstProductFromAtoZText(){
        return driver.findElement(firstProductAtoZ).getText();
    }
    public void clickAddBikeToCardButton(){
        driver.findElement(addBikeToCartButton).click();
    }
    public String itemCountOnCart(){
        return driver.findElement(cartItemNumber).getText();
    }
    public void clickAddTshirtToCardButton(){
        driver.findElement(addTshirtToCartButton).click();
    }
    public void hoverElement(){
        WebElement backpackTitleElement = driver.findElement(selectBackpack);
        actions.moveToElement(backpackTitleElement).perform();
    }
    public String getColorFromBackpackTitle(){
        Color bacpacColorTitle = Color.fromString(driver.findElement(backpackTitle).getCssValue("color"));
        return bacpacColorTitle.asHex();
    }
    public String getTheColorOfTheRemoveButton(){
        Color removeButtonColor = Color.fromString(driver.findElement(textFromAddBackpackToCartButton).getCssValue("color"));
        return removeButtonColor.asHex();
    }
}
