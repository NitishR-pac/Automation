package rtrac;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ReleasePO {
WebDriver driver;
	

	public ReleasePO(WebDriver driver) {
		this.driver = driver;
	}
	public void searchpo() throws Exception {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"tblServiceBureauOrder_length\"]/span[2]/span/a")).click();
	}
	public void searchponvalidation() throws Exception {
		 WebElement searchpo =  driver.findElement(By.xpath("//*[@id=\"searchId0\"]"));
		 searchpo.sendKeys(("KL002RC"));
		 searchpo.sendKeys(Keys.ENTER);
		 searchpo.clear();
		 searchpo.sendKeys(Keys.ENTER);
		  WebElement vendorname =  driver.findElement(By.xpath("//*[@id=\"searchId1\"]"));
		  vendorname.sendKeys(("MAS"));
		  vendorname.sendKeys(Keys.ENTER);
		  vendorname.clear();
		 // searchpo.sendKeys(Keys.ENTER);
		  WebElement vendorID =  driver.findElement(By.xpath("//*[@id=\"searchId2\"]"));
		  vendorID.sendKeys("test");
		  Thread.sleep(1000);
		  vendorID.clear();
		  vendorID.sendKeys(("00002197"));
		  vendorID.sendKeys(Keys.ENTER);
		  vendorID.clear();
		  WebElement nooflines =  driver.findElement(By.xpath("//*[@id=\"searchId3\"]"));
		  nooflines.sendKeys(("1"));
		  nooflines.sendKeys(Keys.ENTER);
		  nooflines.clear();
		  WebElement Quantity =  driver.findElement(By.xpath("//*[@id=\"searchId4\"]"));
		  Quantity.sendKeys(("1"));
		  Quantity.sendKeys(Keys.ENTER);
		  Quantity.clear();
		  WebElement Status =  driver.findElement(By.xpath("//*[@id=\"searchId5\"]"));
		  Status.sendKeys(("new"));
		  Status.sendKeys(Keys.ENTER);
		  Status.clear();
		  WebElement cdate =  driver.findElement(By.xpath("//*[@id=\"searchId6\"]"));
		  cdate.sendKeys(("22-05-10"));
		  cdate.sendKeys(Keys.ENTER);
		  cdate.clear();
		  Status.sendKeys(Keys.ENTER);
		  driver.findElement(By.xpath("//*[@id=\"tblServiceBureauOrder_length\"]/span[3]/a")).click();
	}
	public void properpagination() throws Exception {
		  Select count = new Select(driver.findElement(By.name("tblServiceBureauOrder_length")));
		  count.selectByVisibleText("10");
		 
		 
		 List <WebElement> rows = driver.findElements(By.xpath("//*[@id=\"tblServiceBureauOrder\"]/tbody/tr")); 
	        System.out.println("No of rows are : " + rows.size());
	       int c=11;
	        if(c>rows.size()) {
	        	System.out.println("pass");
		        JavascriptExecutor js = (JavascriptExecutor) driver;
		        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		        driver.findElement(By.xpath("//*[@id='tblServiceBureauOrder_paginate']//span//a[2]")).click();
		       // Thread.sleep(3000);
		        driver.findElement(By.xpath("//*[@id='tblServiceBureauOrder_paginate']//span//a[3]")).click();
	        	
	        }else {
	        	System.out.println("fail");
	        }
	       // Thread.sleep(2000);
	       driver.findElement(By.xpath("//*[@id=\"tblServiceBureauOrder_length\"]/span[3]/a")).click();
	       driver.findElement(By.id("idIsShowChecked")).click();
	}
		public void validorinvalid() throws InterruptedException {
			
			driver.findElement(By.xpath("//*[@id=\"tblServiceBureauOrder\"]/tbody/tr[1]/td[1]/span/a")).click();
			//Thread.sleep(2000);
			WebElement checkboxes = driver.findElement(By.name("select_all"));
			checkboxes.click();
			checkboxes.click();
			WebElement we=driver.findElement(By.xpath("//*[@id=\"tblEMPOOrder\"]/tbody/tr[1]/td[13]/input"));
			we.clear();
			we.sendKeys("test");
			we.clear();
			we.sendKeys("1");
			if (checkboxes.isEnabled()) {					
	            System.out.println("Checkbox is selected");					

	        } else {			
	            System.out.println("Checkbox is diselected");					
	        }
			
			driver.findElement(By.id("btnAddtoCart")).click();
			
			//Thread.sleep(5000);
		}
		public void validorinvalidqty() throws InterruptedException {
	       
			driver.findElement(By.xpath("//*[@id=\"tblServiceBureauOrder\"]/tbody/tr[1]/td[1]/span/a")).click();
	     	WebElement checkboxes = driver.findElement(By.name("select_all"));
			checkboxes.click();
			checkboxes.click();
			WebElement we=driver.findElement(By.xpath("//*[@id=\"tblEMPOOrder\"]/tbody/tr[1]/td[13]/input"));
			we.clear();
			we.sendKeys("test");
			we.clear();
			we.sendKeys("1"); 
			
			if (checkboxes.isEnabled()) {					
	            System.out.println("Checkbox is selected");					

	        } else {			
	            System.out.println("Checkbox is diselected");					
	        }
			
			WebElement changemultipleqty = driver.findElement(By.xpath("//*[@id=\"tblEMPOOrder\"]/tbody/tr[2]/td[13]/input"));
			changemultipleqty.clear();
			changemultipleqty.sendKeys("test");
			changemultipleqty.clear();
			changemultipleqty.sendKeys("1");
			driver.findElement(By.id("btnAddtoCart")).click();
			
			//Thread.sleep(15000);
		}
		
}
