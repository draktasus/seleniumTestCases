package webDriverAuto;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class searchedItem {
	 private static WebDriver myDriver;
	 
	 public void redirect(String baseUrl){
		    myDriver.get(baseUrl + "/arama?q=samsung");
		  }
	  
	  public searchedItem(WebDriver driver){
		  myDriver = driver;
	  }
	  public WebElement btn_Link(String text){
		    return myDriver.findElement(By.linkText(text));
		  }
	  public WebElement btn_fav(){
		    return myDriver.findElement(By.xpath("//*[@data-position='3']/span"));
		  }

}
