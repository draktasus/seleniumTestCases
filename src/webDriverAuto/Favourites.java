package webDriverAuto;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Favourites {

	
      private static WebDriver myDriver;
	  
	  public void redirect(String baseUrl){
		    myDriver.get(baseUrl + "/hesabim/istek-listelerim");
		  }
	  public Favourites(WebDriver driver){
		  myDriver = driver;
	  }
	  public WebElement btn_fav_select(int index){
		   List<WebElement> myWebElList=myDriver.findElements(By.className("hOpenMenuContent"));
		    //dropdown listenin bütün elemanları webElement tipinde bir listeye aktarılır.  
		  return  myWebElList.get(index);//listenin ikinci elamanı(favoriler secenegi) seçilir.
		   
		  }
	  public  List<WebElement> listOfFav(){
		  List<WebElement> fav_list=myDriver.findElements(By.className("listItemProductList"));
		    //dropdown listenin bütün elemanları webElement tipinde bir listeye aktarılır.  
		  return fav_list;//listenin ikinci elamanı(favoriler secenegi) seçilir.
		   
		  }
	 
	   
}
