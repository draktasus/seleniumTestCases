package webDriverAuto;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class DeleteFavourites {

	  private static WebDriver myDriver;
	  
	  public void redirect(String baseUrl){
		    myDriver.get(baseUrl + "/hesabim/favorilerim");
		  }
	  
	  public DeleteFavourites(WebDriver driver){
		  myDriver = driver;
	  }
	  
	  public WebElement btn_delete(){
		    return myDriver.findElement(By.className("deleteProFromFavourites"));
		  }
	  public String product()
	  {
		  return myDriver.findElement(By.className("columnContent")).toString();
	  }
}  