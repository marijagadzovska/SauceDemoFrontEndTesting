package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class CheckoutYourInformationPage {
    private WebDriver driver;
    private By checkoutYourInformationPage = By.className("title");
    private By continueButton = By.id("continue");
    private By usernameField = By.id("first-name");
    private By lastnameField = By.id("last-name");
    private By zipCodeField = By.id("postal-code");
    private By errorMessage = By.xpath("//*[@id=\"checkout_info_container\"]/div/form/div[1]/div[4]");
    private By xErrorMessageButton = By.className("error-button");


    public CheckoutYourInformationPage(WebDriver driver) {
        this.driver = driver;
    }
    public boolean isCheckoutYourInformationPageDisplayed() {
        return driver.findElement(checkoutYourInformationPage).getText().equals("Checkout: Your Information");
    }
    public void clickContinueButton(){
        driver.findElement(continueButton).click();
    }
    public String getErrorMessage(){
        return driver.findElement(errorMessage).getText();
    }
    public void clickXErrorMessageButton(){
        driver.findElement(xErrorMessageButton).click();
    }
    public boolean isErrorMessageDisplayed(){
        try{
            driver.findElement(errorMessage).getText();
            return true;
        } catch (NoSuchElementException e){
            return false;
        }
    }
    public void usernameField(String username){
        driver.findElement(usernameField).sendKeys(username);
    }
    public void lastnameField(String lastname){
        driver.findElement(lastnameField).sendKeys(lastname);
    }
    public void zipCodeField(String zipCode){
        driver.findElement(zipCodeField).sendKeys(zipCode);
    }
}
