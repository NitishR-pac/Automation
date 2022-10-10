package rtrac;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Logout {
WebDriver driver;
	
	

	public Logout(WebDriver driver) {
		this.driver = driver; 
	}
	
	By clickonconform = By.id("btnConfirmOrder");
		
	public void clickonconform()  {
		   JavascriptExecutor js = (JavascriptExecutor) driver;
		   js.executeScript("window.scrollBy(0,350)", "");
		   driver.findElement(By.id("btnConfirmOrder")).click();
		
	}
	
	public void clickonlogout() throws Exception{
		
		  
		   driver.findElement(By.id("didInfo")).click();
		   driver.findElement(By.xpath("//a[@href='/Home/Logout']")).click();
	}
	
	public void adlerlogout() throws Exception {
		driver.findElement(By.xpath("//*[@id='language']/div[2]")).click();
		//Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='language']/ul/li[3]")).click();
	}
}
