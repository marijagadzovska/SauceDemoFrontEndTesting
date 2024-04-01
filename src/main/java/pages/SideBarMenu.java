package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;

public class SideBarMenu {

   private WebDriver driver;
  Actions actions;
  private By allItems = By.id("inventory_sidebar_link");
  private By aboutText = By.id("about_sidebar_link");
  private By logoutText = By.id("logout_sidebar_link");
  private By resetAppStateText = By.id("reset_sidebar_link");

  public SideBarMenu(WebDriver driver) {
       this.driver = driver;
        this.actions = new Actions(driver);
  }

  public String getAllItemsText(){
     return driver.findElement(allItems).getText();
  }
  public String getAboutText(){
       return driver.findElement(aboutText).getText();
  }
  public String getLogoutText(){
      return driver.findElement(logoutText).getText();
  }
  public String getResetAppStateText(){
       return driver.findElement(resetAppStateText).getText();
  }
  public void hoverAboutElement(){
      WebElement hoverOnAbout = driver.findElement(aboutText);
      actions.moveToElement(hoverOnAbout).perform();
  }
  public void hoverAllItemsElement(){
      WebElement hoverOnAll = driver.findElement(allItems);
      actions.moveToElement(hoverOnAll).perform();
  }
  public void hoverOnResetAppStateElement(){
      WebElement hoverOnAll = driver.findElement(resetAppStateText);
      actions.moveToElement(hoverOnAll).perform();
  }
  public void hoverLogoutElement(){
      WebElement hoverOnAll = driver.findElement(logoutText);
      actions.moveToElement(hoverOnAll).perform();
  }
  public String getColorFromAboutTitle(){
      Color bacpacColorTitle = Color.fromString(driver.findElement(aboutText).getCssValue("color"));
      return bacpacColorTitle.asHex();
  }
  public String getColorFromAllItemsTitle(){
      Color bacpacColorTitle = Color.fromString(driver.findElement(allItems).getCssValue("color"));
      return bacpacColorTitle.asHex();
  }
  public String getColorFromLogoutTitle(){
      Color bacpacColorTitle = Color.fromString(driver.findElement(logoutText).getCssValue("color"));
      return bacpacColorTitle.asHex();
  }
  public String getColorFromResetAppStateTitle(){
      Color bacpacColorTitle = Color.fromString(driver.findElement(resetAppStateText).getCssValue("color"));
      return bacpacColorTitle.asHex();
  }
  public void clickAboutTitle(){
      driver.findElement(aboutText).click();
  }
  public String getHrefFromAbout(){
      WebElement aboutTextElement = driver.findElement(aboutText);
      return aboutTextElement.getAttribute("href");
  }
  public String getHrefFromLogout(){
      WebElement aboutTextElement = driver.findElement(logoutText);
      return aboutTextElement.getAttribute("href");
  }


}
