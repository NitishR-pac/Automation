package rtrac;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Addtocart {
	WebDriver driver;
	 

	public Addtocart(WebDriver driver) {
		this.driver = driver;
	}
	By clickonicon = (By.xpath("//span[@class='icon-space btn btn-xs']"));
	By clickonaddtocart = By.id("btnAddtoCart");
	By clickonibcart = By.id("lblCart");
	
	public void clickonaddtocartbtn() {
		driver.findElement(By.id("btnSave")).click();
		driver.findElement(By.className("Cart")).click();
	}
	public void clickonicon() throws Exception {
		driver.findElement(clickonicon).click();
		//Thread.sleep(2000);
	}
	public void clickonchkbox() throws Exception{
		//Thread.sleep(2000);
		driver.findElement(By.name("chkPO")).click();
	}
	public void clickonaddtocart() {
		driver.findElement(clickonaddtocart).click();
	}
	
	public void clickonaddtoibcart() throws Exception  {
		//Thread.sleep(2000);
		driver.findElement(clickonibcart).click();
}
	public void clickonpo_forbackforth() throws Exception {
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"lblCart\"]")).click();	
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
       // Thread.sleep(2000);
		String strvalue = driver.findElement(By.xpath("//*[@id=\"tblShoppingCart\"]/tbody/tr/td[6]")).getText();
		 String expected = "1";
         System.out.println(strvalue);
		   if(expected.equals(strvalue)){
		       System.out.println("Quentity update successfully");
		   }
		   else {
		       System.out.println("Wrong Quentity update successfully");
		   }
		driver.findElement(By.xpath("//*[@id=\"tblShoppingCart\"]/tbody/tr/td[2]/span/a")).click();
		 //Thread.sleep(3000);       
		driver.findElement(By.id("btnAddtoCart")).click();
		//Thread.sleep(3000);
	}
	
	public void clickonpo_forbackforthformultiple() throws Exception {
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"lblCart\"]")).click();	
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
       // Thread.sleep(2000);
		String strvalue = driver.findElement(By.xpath("//*[@id=\"tblShoppingCart\"]/tbody/tr/td[5]")).getText();
		 String expected = "2";
         System.out.println(strvalue);
		   if(expected.equals(strvalue)){
		       System.out.println("No of line inserted properly ");
		   }
		   else {
		       System.out.println("No of count mismatch");
		   }
		driver.findElement(By.xpath("//*[@id=\"tblShoppingCart\"]/tbody/tr/td[2]/span/a")).click();
		 //Thread.sleep(3000);       
		driver.findElement(By.id("btnAddtoCart")).click();
		//Thread.sleep(3000);
	}

	public void checkboxSelect() throws InterruptedException 
    {
        
        JavascriptExecutor js = (JavascriptExecutor) driver;
           js.executeScript("window.scrollBy(0,350)", "");
           Thread.sleep(2000);
         
         List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
         int size= checkboxes.size();
         System.out.println(size);
         for(int i=0; i<2; i++)
         {
             checkboxes.get(i).click();
         }
    
	
	
}
	public void closemoq() throws Exception {
		driver.findElement(By.xpath("//button[@class='btn btn-default']")).click();
		//Thread.sleep(3000);
	}
}
