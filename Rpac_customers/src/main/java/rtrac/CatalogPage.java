package rtrac;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CatalogPage {
	WebDriver driver;
	Properties pro = new Properties();
		
		public CatalogPage(WebDriver driver) {
			this.driver = driver; 
		}
		public void chknumericincat() {
			WebElement cachk =driver.findElement(By.xpath("//*[@id='txtOrderQty_DIMUDSP '] |//*[@id=\"txtOrderQty_ZU-1\"]"));
			cachk.clear();
			//Thread.sleep(3000);
			cachk.sendKeys("test");
			cachk.sendKeys("123");
		}
		public void chktxtvalidation() {
			WebElement cachk =driver.findElement(By.xpath("//*[@id='txtOrderQty_DIMUDSP '] |//*[@id=\"txtOrderQty_ZU-1\"]"));
			cachk.clear();
			cachk.sendKeys("44423333333999999000999888");
			WebElement cachk2 =driver.findElement(By.xpath("//*[@id='txtOrderQty_COMPSOX2'] |//*[@id=\"txtOrderQty_ZU-2\"]"));
			cachk2.sendKeys("9898989");
			driver.findElement(By.xpath("//*[@id='AllChk']")).click();
		}
		
		public void cataAddtocart() {
			WebElement cachk =driver.findElement(By.xpath("//*[@id='txtOrderQty_DIMUDSP '] |//*[@id=\"txtOrderQty_ZU-1\"]"));
			cachk.clear();
			cachk.sendKeys("444");
			
			((JavascriptExecutor) driver)
		     .executeScript("window.scrollTo(0, document.body.scrollHeight)");
			driver.findElement(By.id("btnSave")).click();
		}
		public void imgaction() {
			driver.findElement(By.id("img1")).click();
			driver.findElement(By.xpath("//*[@id=\"PreviewImageModal\"]/div/div/div[1]/button")).click();
			driver.findElement(By.id("img1")).click();
			driver.findElement(By.xpath("//*[@id=\"PreviewImageModal\"]/div/div/div[1]/button")).click();
			driver.findElement(By.id("img1")).click();
			driver.findElement(By.xpath("//*[@id=\"PreviewImageModal\"]/div/div/div[1]/button")).click();
			driver.findElement(By.id("img1")).click();
			driver.findElement(By.xpath("//*[@id=\"PreviewImageModal\"]/div/div/div[1]/button")).click();
			driver.findElement(By.id("img1")).click();
			driver.findElement(By.xpath("//*[@id=\"PreviewImageModal\"]/div/div/div[1]/button")).click();
			driver.findElement(By.id("img1")).click();
			driver.findElement(By.xpath("//*[@id=\"PreviewImageModal\"]/div/div/div[1]/button")).click();
		}
		
}
