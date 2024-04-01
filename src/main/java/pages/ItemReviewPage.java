package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.Color;

public class ItemReviewPage {
    private WebDriver driver;

    private By itemTitle = By.xpath("//*[@id=\"inventory_item_container\"]/div/div/div[2]/div[1]");
    private By itemDescription = By.xpath("//*[@id=\"inventory_item_container\"]/div/div/div[2]/div[2]");
    private By itemPrice = By.xpath("//*[@id=\"inventory_item_container\"]/div/div/div[2]/div[3]");
    private By removeBackpackButton = By.id("remove");
    private By addBackpackToCartButton = By.id("add-to-cart");
    private By cartItemNumber = By.className("shopping_cart_badge");


    public ItemReviewPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getItemTitleText(){
        return driver.findElement(itemTitle).getText();
    }
    public String getItemDescriptionText(){
        return driver.findElement(itemDescription).getText();
    }
    public String getItemPrice(){
        return driver.findElement(itemPrice).getText();
    }
    public void clickRemoveBackpack(){
        driver.findElement(removeBackpackButton).click();
    }
    public String getAddToCartBackpackButtonColor(){
        Color loginButtonBackgroundColour = Color.fromString(driver.findElement(addBackpackToCartButton).getCssValue("color"));
        return loginButtonBackgroundColour.asHex();
    }
    public String getRemoveBackpackButtonColor(){
        Color loginButtonBackgroundColour = Color.fromString(driver.findElement(removeBackpackButton).getCssValue("color"));
        return loginButtonBackgroundColour.asHex();
    }
    public boolean isItemNumberDisplayed(){
        try{
            driver.findElement(cartItemNumber).getText();
            return true;
        } catch (NoSuchElementException e){
            return false;
        }
    }
}
