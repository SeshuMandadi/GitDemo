package seshu.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponents {
	
	String name ="Seshu";
	WebDriver driver;
	
	public AbstractComponents(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public void waitForElementToAppear(By findBy) {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	
	}
	
	public void waitForElementToDisappear(WebElement ele) {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	
	wait.until(ExpectedConditions.invisibilityOf(ele));
	
	}
}
