package webDriverAuto;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class LogInPage {

	  private static WebDriver myDriver;
	  
	  public void redirect(String baseUrl){
		    myDriver.get(baseUrl + "/giris-yap");
		  }
	  
	  public LogInPage(WebDriver driver){
		  myDriver = driver;
	  }
	  
	  public WebElement txt_eMail(){
	    return myDriver.findElement(By.id("email"));
	  }
	  public WebElement txt_password(){
		    return myDriver.findElement(By.id("password"));
		  }
	  
	  public WebElement btn_log(){
	    return myDriver.findElement(By.id("loginButton"));
	  }

}
