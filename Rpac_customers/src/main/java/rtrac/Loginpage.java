package rtrac;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Loginpage {
	WebDriver driver; 
	public Loginpage(WebDriver driver) {
		this.driver = driver;
	}
	Properties pro = new Properties();
	
	
	
	public void enterhanesusername() throws Exception {
		Loginpage objectRepo = new Loginpage(driver);
		File src = new File("D:\\Rpac_customers (1)\\Rpac_customers\\Object_Repo.properties");
		FileInputStream fis = new FileInputStream(src);
		pro.load(fis); 
		driver.findElement(By.xpath(pro.getProperty("Email"))).sendKeys(pro.getProperty("EmailTestData"));
	}
	public void enterhanespassword() {
		driver.findElement(By.xpath(pro.getProperty("Password"))).sendKeys(pro.getProperty("PasswordTestData"));
	}
	
	public void login() {
		driver.findElement(By.id("btnsignIn")).click();
		
	}
	
	
	public void comparedata() throws Exception {
		  JavascriptExecutor js = (JavascriptExecutor) driver;
	      js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		driver.findElement(By.id("aUserInfo")).click();
		WebElement n =driver.findElement(By.xpath("//div [@class='form-group']//div[2]"));
		String upd = n.getText();
		System.out.println(upd);
		String style=(pro.getProperty("EmailTestData7"));
		//System.out.println(style);
		//System.out.println(upd);
	       System.out.println(" Equal");
		 if(style.equals(upd)){
			  System.out.println("Fail");
		    }
	        else {
	        	System.out.println("Pass");
	          
	        }
		 
		 driver.findElement(By.xpath("//*[@id=\"divlbl\"]/div/div/div[6]/div[3]/button")).click();
		
	}
}
