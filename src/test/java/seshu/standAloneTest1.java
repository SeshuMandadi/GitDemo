package seshu;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import seshu.pageobjects.LandingPage;
import seshu.pageobjects.ProductCatalogue;

public class standAloneTest1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		String productName ="ZARA COAT 3";

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	
		
	//	driver.manage().window().maximize();
		
		
		
		LandingPage landingPage = new LandingPage(driver);
		landingPage.goTo();
		landingPage.loginApplication("test021@gmail.com", "Iamking@000");
		
		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
		
	Thread.sleep(2000);
	
	driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
	
	List <WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
	
	Boolean match = cartProducts.stream().anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));
	Assert.assertTrue(match);
	
	driver.findElement(By.cssSelector(".totalRow button")).click();
	
	//actions class - send keys
	
	Actions a = new Actions(driver);
	
	a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "India"  ).build().perform();
	
	 JavascriptExecutor js = (JavascriptExecutor)driver;
		
	//wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".ta-results")));
	js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
Thread.sleep(2000);
	
	 js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	 
	driver.findElement(By.cssSelector(".action__submit")).click();
	
	//Text message comfirmation.
	String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
	Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	
	
	
	
	
	}

}
