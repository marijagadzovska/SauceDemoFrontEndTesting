package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.Color;

public class LoginPage {
    private WebDriver driver;

    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");
    private By errorMessageContainer = By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]");
    private By errorMsg = By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3");
    private By xErrorMessageButton = By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3/button");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }
    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }
    public String getErrorMessage() {
        return driver.findElement(errorMsg).getText();
    }
    public void clickXErrorMessageButton(){
        driver.findElement(xErrorMessageButton).click();
    }
    public boolean isErrorMessageDisplayed(){
        try{
            driver.findElement(errorMsg).getText();
            return true;
        } catch (NoSuchElementException e){
            return false;
        }
    }
    public String getUsernameFontSize(){
        return driver.findElement(usernameField).getCssValue("font-size");
    }
    public String getUsernameFontType(){
        return driver.findElement(usernameField).getCssValue("font-family");
    }
    public String getUsernameBorderButtonFieldColor(){
        Color loginButtonBackgroundColour = Color.fromString(driver.findElement(usernameField).getCssValue("border-bottom-color"));
        return loginButtonBackgroundColour.asHex();
    }
    public String getPasswordFontSize(){
        return driver.findElement(passwordField).getCssValue("font-size");
    }
    public String getPasswordFontType(){
        return driver.findElement(passwordField).getCssValue("font-family");
    }
    public String getPasswordBorderButtonFieldColor(){
        Color passwordButtonBackgroundColour = Color.fromString(driver.findElement(passwordField).getCssValue("border-bottom-color"));
        return passwordButtonBackgroundColour.asHex();
    }
    public String getLoginButtonColor(){
        Color loginButtonBackgroundColour = Color.fromString(driver.findElement(loginButton).getCssValue("background-color"));
        return loginButtonBackgroundColour.asHex();
    }
    public String getLoginButtonFontSize(){
        return driver.findElement(loginButton).getCssValue("font-size");
    }
    public String getLoginButtonFontType(){
        return driver.findElement(loginButton).getCssValue("font-family");
    }
    public String getErrorMessageContainerColor(){
        Color errorMessageBackgroundColour = Color.fromString(driver.findElement(errorMessageContainer).getCssValue("background-color"));
        return errorMessageBackgroundColour.asHex();
    }
}
