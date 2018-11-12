package webDriverTests;

//import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

//import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.Select;

import webDriverAuto.*;
 //test case leri alfabetik sıraya göre senkron çalışması için çağırdığımız metod
@FixMethodOrder(MethodSorters.NAME_ASCENDING)  
class testCases {
	
	  public static WebDriver driver;
	  private static String baseUrl;
	  
	  public static String searchName = "Samsung";
	  public static String email="bahadr.ural@gmail.com";
	  public static String password="keytorcN11";
	  public static Object fav_item_3;
	  
	  public static pageContent page ;
	  public static searchedItem Search;
	  public static LogInPage log;
	  public static Favourites fav;
	  public static DeleteFavourites delete;
	  @BeforeClass
	  public static void setUp() throws Exception {
	   
	    driver = new ChromeDriver();
	    baseUrl = "https://www.n11.com/";

	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
// sayfaların yüklenmesi için gerekli zamanı belirliyoruz.
	    driver.manage().timeouts().pageLoadTimeout(200, TimeUnit.SECONDS);
// test case lerde kullanmak için daha önceden oluşturduğumuz class larımız
	    page = new pageContent(driver);
	    Search = new searchedItem(driver);
	    fav = new Favourites(driver);
	    log= new LogInPage(driver);
	    delete= new DeleteFavourites(driver);
	  }
	  @Test
	  public void test01MainPageLoad() throws Exception {
	    //anasayfanın açılması
	    if (driver.getTitle().equals("n11.com - Alışverişin Uğurlu Adresi"))//sayfa açıldı mı kontrol etmek için sayfa başlığına bakıyoruz.
	    {
	    	 System.out.println("Successfully opened the website https://www.n11.com/");
	    }
	    else 
	    	System.out.println("https://www.n11.com/ is not opened");
	  }
	  @Test
	  public void test02LogIn() throws Exception {
	    //kullanıcı girişi
	    page.btn_LogIn().click();
	    driver.manage().timeouts().pageLoadTimeout(200, TimeUnit.SECONDS);
	    log.redirect(baseUrl);
	    log.txt_eMail().clear();//text in boş olup olmadığını kontrol ettiriyoruz.
	    log.txt_eMail().sendKeys(email);//text de veri gönderiyoruz.
	    log.txt_password().clear();
	    log.txt_password().sendKeys(password);
	    log.btn_log().click();
	    driver.manage().timeouts().pageLoadTimeout(200, TimeUnit.SECONDS);
	  }

	  @Test
	  public void test03searchItem() throws Exception {
	    // nesneyi bul

	    page.data_search().clear();//sayfadaki arama bölümü temizlenir.
	    page.data_search().sendKeys(searchName);//aranan kelime arama yerine gönderilir.
	    
	    page.btn_search().click();// arama tuşu tetiklenir.
	    driver.manage().timeouts().pageLoadTimeout(200, TimeUnit.SECONDS);
	    Search.redirect(baseUrl);//sayfaya yönlendirilir.
	  }
	  @Test
	  public void test04GoPage2() throws Exception {
	    //2. sayfaya yönlendirme

	    Search.btn_Link("2").click();
	    driver.manage().timeouts().pageLoadTimeout(200, TimeUnit.SECONDS);
	    if (driver.getTitle().equals("Samsung - n11.com - 2/11872"))//arama bölümünün 2.sayfaya yönlendirildiğini görmek için 2. sayfanın başlığını kontrol ediyoruz. 
	    {
	    	System.out.println("page 2 is opened which was searched title samsung");
	    }
	  }
	  @Test
	  public void test05AddFavorites() throws Exception {
	    //favorilere ekleme yapma
		fav_item_3=Search.btn_fav().getClass();//sonraki sayfada favoriye alınan ürünün doğruluğunu karşılaştırmak için değişkene atılan object.
		Search.btn_fav().click();//listedeki 3. ürünün favorilere ekle tuşunu aktifleştirir.
		   driver.manage().timeouts().pageLoadTimeout(200, TimeUnit.SECONDS);
	    fav.redirect(baseUrl);//favoriler sekmesinde işlem yapmak için test programı ilgili sayfaya yönlendirilir.
	    fav.btn_fav_select(1).click();//kullanıcının favoriye aldığı ürünleri görmesi için sayfaya yönlendirme.
	    driver.manage().timeouts().pageLoadTimeout(200, TimeUnit.SECONDS);
	    List<WebElement> fav_list=fav.listOfFav();
	    for(int i=0;i<fav_list.size();i++)
	    {
	    	if(fav_list.get(i).equals(fav_item_3))
	    	{
	    		System.out.println("Favourite product found!");
	    	}
	    }
	    
	  }
	  @Test
	  public void test06DelFavorites() throws Exception {
		  delete.redirect(baseUrl);//favorilerin oldugu adrese yönlendirme.
		  delete.btn_delete().click();//favoriye alınan ürünün kaldırılması.
		   driver.manage().timeouts().pageLoadTimeout(200, TimeUnit.SECONDS);
		  if(delete.product().isEmpty())//favorilerde ürün var mı yok mu bakılır.
		  {
			  System.out.println("Favourited product deleted!");
		  }
	  
	  }
}
