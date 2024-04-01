package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.Color;

public class YourCartPage {

    private WebDriver driver;

    private By continueShoppingButton = By.id("continue-shopping");
    private By checkoutButton = By.id("checkout");
    private By backpackTitle = By.id("item_4_title_link");
    private By bikeTitle = By.id("item_0_title_link");
    private By firstItemDescription = By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]/div[2]/div[1]");
    private By secondItemDescription = By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[4]/div[2]/div[1]");
    private By firstItemPrice = By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]/div[2]/div[2]/div");
    private By secondItemPrice = By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[4]/div[2]/div[2]/div");
    private By backpackRemoveButton = By.id("remove-sauce-labs-backpack");
    private By cartItemNumber = By.className("shopping_cart_badge");
   private By tshirtTitle = By.id("item_1_title_link");
   private By bikeRemoveButton = By.id("remove-sauce-labs-bike-light");

    public YourCartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void continueShoppingButton() {
        driver.findElement(continueShoppingButton).click();
    }
    public void clickCheckoutButton(){
        driver.findElement(checkoutButton).click();
    }
    public String getTextFromBackpackTitle(){
        return driver.findElement(backpackTitle).getText();
    }
    public String getDescriptionFromFirstItem(){
        return driver.findElement(firstItemDescription).getText();
    }
    public String getPriceFromFirstItem(){
        return driver.findElement(firstItemPrice).getText();
    }
    public void clickRemoveButtonInYourCartPage(){
        driver.findElement(backpackRemoveButton).click();
    }
    public String getBackpackRemoveButtonText(){
        return driver.findElement(backpackRemoveButton).getText();
    }
    public boolean isBackpackItemDisplayed(){
        try{
            driver.findElement(backpackTitle).getText();
            return true;
        } catch (NoSuchElementException e){
            return false;
        }
    }
    public boolean isItemNumberDisplayed(){
        try{
            driver.findElement(cartItemNumber).getText();
            return true;
        } catch (NoSuchElementException e){
            return false;
        }
    }
    public String itemCountOnCart(){
        return driver.findElement(cartItemNumber).getText();
    }
    public String getTextFromTshirtTitle(){
        return driver.findElement(tshirtTitle).getText();
    }
    public String getDescriptionFromSecondItem(){
        return driver.findElement(secondItemDescription).getText();
    }
    public String getPriceFromSecondItem(){
        return driver.findElement(secondItemPrice).getText();
    }
    public String getTextFromBikeTitle(){
        return driver.findElement(bikeTitle).getText();
    }
    public void clickRemoveBikeButtonInYourCartPage(){
        driver.findElement(bikeRemoveButton).click();
    }
    public boolean isBikeItemDisplayed(){
        try{
            driver.findElement(bikeTitle).getText();
            return true;
        } catch (NoSuchElementException e){
            return false;
        }
    }
    public String colorOFTheCheckoutButton(){
        Color checkoutButtonColor = Color.fromString(driver.findElement(checkoutButton).getCssValue("background-color"));
        return checkoutButtonColor.asHex();
    }
    public String colorOFTheContinueShoppingButton(){
        Color checkoutButtonColor = Color.fromString(driver.findElement(continueShoppingButton).getCssValue("background-color"));
        return checkoutButtonColor.asHex();
    }
}
