package rtrac;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver = driver; 
	}
	public void clickonorder() throws Exception { 
		Thread.sleep(2000);
		driver.findElement(By.id("divNEWORDERS")).click();
	    WebElement m = driver.findElement(By.id("divTotalOrder"));
	     String s = m.getText();
	    driver.navigate().to("https://devcoredbi.r-pac.com/ServiceBureauOrder/ServiceBureauOrder");
	   // Thread.sleep(6000);
	   
	    Thread.sleep(3000);
	   
	    WebElement gettextdetails = driver.findElement(By.id("tblServiceBureauOrder_info"));
	        String tdetails =  gettextdetails.getText(); 
	        String[] arrOfStr = tdetails.split(" "); 
	        for(int i=6; i< arrOfStr.length; i++)
	        {
	            System.out.println(arrOfStr[5]); 
	        }
	        if(arrOfStr[5].equals(s)) {
	        	System.out.println("Values are equal");
			} else {
				System.out.println("Values are NOT equal");
			}
	        
	        driver.navigate().back();
		    driver.findElement(By.id("divNEWORDERS")).click();
		  JavascriptExecutor js = ((JavascriptExecutor) driver);
			 js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		    //Thread.sleep(3000);
			driver.findElement(By.id("divORDERSPENDINGAPPROVAL")).click();
			//Thread.sleep(3000);
			driver.findElement(By.id("divORDERSINPROCESSL")).click();
			//Thread.sleep(3000);
			driver.findElement(By.id("divSHIPPEDORDERS")).click();
			
}
		public void clickonuser() throws Exception {
		
		   driver.findElement(By.xpath("//*[@id=\"aUserInfo\"]")).click();
			driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/button/i")).click();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

		}
		public void resetpassword() throws Exception {
			JavascriptExecutor js = (JavascriptExecutor) driver;
		      //Scroll down till the bottom of the page
		      js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
			//Thread.sleep(2000);
			driver.findElement(By.id("aResetPassword")).click();
			WebElement pw = driver.findElement(By.id("Password"));
			pw.clear();
			pw.sendKeys("User@123");
			driver.findElement(By.id("Password")).sendKeys("User@123");
			driver.findElement(By.id("NewPassword")).sendKeys("User@123");
			driver.findElement(By.id("RetypePassword")).sendKeys("User@123");
			driver.findElement(By.xpath("//*[@id=\"divbtn\"]/div[2]/button[1]")).click();
			//Thread.sleep(4000);
			driver.findElement(By.className("countdown")).click();
		}
		
		public void resetpasswordwithwrong() throws Exception {
			JavascriptExecutor js = (JavascriptExecutor) driver;
		      //Scroll down till the bottom of the page
		      js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
			//Thread.sleep(2000);
			driver.findElement(By.id("aResetPassword")).click();
			WebElement pw = driver.findElement(By.id("Password"));
			pw.clear();
			pw.sendKeys("User@123");
			driver.findElement(By.id("Password")).sendKeys("User@123");
			driver.findElement(By.id("NewPassword")).sendKeys("User@123");
			driver.findElement(By.id("RetypePassword")).sendKeys("Us2er@123");
			driver.findElement(By.xpath("//*[@id=\"divbtn\"]/div[2]/button[1]")).click();
			//Thread.sleep(4000);
			driver.findElement(By.className("countdown")).click();
		}
		
		
}
