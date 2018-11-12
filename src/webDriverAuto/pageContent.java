package webDriverAuto;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class pageContent {
  
  private static WebDriver myDriver;
  
 
  
  public pageContent(WebDriver driver){
	  myDriver = driver;
  }
  
  public WebElement btn_search(){
    return myDriver.findElement(By.id("searchbtn"));
  }
  public WebElement btn_LogIn(){
	    return myDriver.findElement(By.linkText("Giriş yap"));
	  }
  
  public WebElement data_search(){
    return myDriver.findElement(By.id("searchData"));
  }
  
}