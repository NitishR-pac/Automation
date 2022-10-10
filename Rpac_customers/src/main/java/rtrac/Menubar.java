package rtrac;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Menubar {
	WebDriver driver;
	public Menubar(WebDriver driver) {
		this.driver = driver; 
	}
	public void clickonorder() { 
		driver.findElement(By.id("Order")).click();
	}
	public void clickoncatalog() {
		driver.findElement(By.id("Catalog Items")).click();
	}
	public void clickonreleasepo() {
		driver.findElement(By.id("Release PO")).click();
	}
	public void reports() {
		driver.findElement(By.id("Reports")).click();
	}
	public void orderstatus() {
		driver.findElement(By.id("Order Status")).click();
	}
}