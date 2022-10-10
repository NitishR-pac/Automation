package rtrac;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IndexPage {
	public static Properties prop;
	WebDriver driver; 
	Loginpage logindetail;
	Menubar Menubar;
	CatalogPage CatalogPage;
	Logout Logout;
	ReleasePO ReleasePO;
	HomePage HomePage;
	public static ExtentReports extentReports;
	public static ExtentTest extentTest;
	Addtocart Addtocart;
	@Parameters("browserName")
	@BeforeTest  
	public void setup(ITestContext context, @Optional("chrome") String browserName) throws Exception {
			
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://devrtrac.r-pac.com/");
		
		
	}  
	////////////////////////Home Page//////////////////////
	@Test(testName="HomePage",priority=0,enabled=false)
	public void homepage() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		long startTime = System.currentTimeMillis();
		SoftAssert Softassert = new SoftAssert();
		extentTest=extentReports.createTest("Home Page");
		
		Loginpage page = new Loginpage(driver); 
		page.enterhanesusername();
		page.login();   
		page.enterhanespassword();
		page.login(); 
		page.comparedata();
		extentTest.info("Compare new orders count with releasePO count"); 
		HomePage hp = new HomePage(driver);
		hp.clickonorder();
		hp.clickonuser();
		hp.resetpassword();
		extentTest.info("Password Changed successfully"); 
		hp.resetpasswordwithwrong();
		extentTest.info("Password doesn't match");
		Logout logout= new Logout(driver);
		logout.clickonlogout();
		
	}
		
	
	///////////////////////////////////////////////////////
	///////////////////////////Release PO//////////////////
	
	@Test(testName="ReleasePO",priority=1,enabled=false)
	public void releasePOvalidation() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		long startTime = System.currentTimeMillis();
		SoftAssert Softassert = new SoftAssert();
		extentTest=extentReports.createTest("In Release PO filter are working ");
		Loginpage page = new Loginpage(driver); 
		page.enterhanesusername();
		page.login();   
		page.enterhanespassword();
		page.login(); 
		Menubar order = new Menubar(driver);
		order.clickonorder();
		order.clickonreleasepo();
		ReleasePO releasepo= new ReleasePO(driver);
		releasepo.searchpo();
		releasepo.searchponvalidation();
		Logout logout= new Logout(driver);
		logout.clickonlogout(); 
		//Thread.sleep(4000);
	}
	@Test(testName="ReleasePO",priority=2,enabled=false)
	public void ReleasePO_pagenation () throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		long startTime = System.currentTimeMillis();
		SoftAssert Softassert = new SoftAssert();
		extentTest=extentReports.createTest("Verify Proper Pageination working or not");
		Loginpage page = new Loginpage(driver); 
		page.enterhanesusername();
		page.login();   
		page.enterhanespassword();
		page.login(); 
		Menubar order = new Menubar(driver);
		order.clickonorder();
		order.clickonreleasepo();
		ReleasePO releasepo= new ReleasePO(driver);
		releasepo.properpagination();
		Logout logout= new Logout(driver);
		logout.clickonlogout(); 
		//Thread.sleep(7000);
	}
	@Test(testName="ReleasePO",priority=3,enabled=false)
	public void ReleasePO_valid_or_invaliddata_try_to_add () throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		long startTime = System.currentTimeMillis();
		SoftAssert Softassert = new SoftAssert();
		extentTest=extentReports.createTest("Check box check or uncheck");
		Loginpage page = new Loginpage(driver); 
		page.enterhanesusername();
		page.login();   
		page.enterhanespassword();
		page.login(); 
		Menubar order = new Menubar(driver);
		order.clickonorder();
		order.clickonreleasepo();
		ReleasePO releasepo= new ReleasePO(driver);
		releasepo.validorinvalid(); 
		Addtocart ac=new Addtocart(driver);
		ac.clickonpo_forbackforth();
		Logout logout= new Logout(driver);
		logout.clickonlogout(); 
		 
		//Thread.sleep(7000);
		//
	}
	@Test(testName="ReleasePO",priority=4)
	public void Number_of_lines_showproper() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		long startTime = System.currentTimeMillis();
		SoftAssert Softassert = new SoftAssert();
		extentTest=extentReports.createTest("Check box check or uncheck");
		Loginpage page = new Loginpage(driver); 
		page.enterhanesusername();
		page.login();   
		page.enterhanespassword();
		page.login(); 
		Menubar order = new Menubar(driver);
		order.clickonorder();
		order.clickonreleasepo();
		ReleasePO releasepo= new ReleasePO(driver);
		releasepo.validorinvalidqty(); 
		Addtocart ac=new Addtocart(driver);
		ac.clickonpo_forbackforthformultiple();
		Logout logout= new Logout(driver);
		logout.clickonlogout(); 
		
		//Thread.sleep(7000);
	}
	
	
	
	
							/////////////////////////
	
							//		Testcase for calalog
	@Test(testName="catalog",priority=0,enabled=false)
	public void cattalog_image_validation() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		long startTime = System.currentTimeMillis();
		SoftAssert Softassert = new SoftAssert();
		extentTest=extentReports.createTest("Image validation in catalog");
		Loginpage page = new Loginpage(driver); 
		page.enterhanesusername();
		page.login();   
		page.enterhanespassword();
		page.login(); 
		Menubar order = new Menubar(driver);
		order.clickonorder();
		order.clickoncatalog();
		CatalogPage cp = new CatalogPage(driver);
		cp.imgaction();
		Logout logout= new Logout(driver);
		logout.clickonlogout(); 
	}
	
	
	
	@Test(testName="catalog",priority=1,enabled=false)
	public void catalog_qty_validation() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		long startTime = System.currentTimeMillis();
		SoftAssert Softassert = new SoftAssert();
		extentTest=extentReports.createTest("verify qty text validation in catalog ");
		Loginpage page = new Loginpage(driver); 
		page.enterhanesusername();
		page.login();   
		page.enterhanespassword();
		page.login(); 
		Menubar order = new Menubar(driver);
		order.clickonorder();
		order.clickoncatalog();
		CatalogPage cp = new CatalogPage(driver);
		cp.chktxtvalidation();
		Logout logout= new Logout(driver);
		logout.clickonlogout();
	}
	
	@Test(testName="catalog",priority=2,enabled=false)
	public void catalog_qty_column_validation() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		long startTime = System.currentTimeMillis();
		SoftAssert Softassert = new SoftAssert();
		extentTest=extentReports.createTest("Verify column length ");
		Loginpage page = new Loginpage(driver); 
		page.enterhanesusername();
		page.login();   
		page.enterhanespassword();
		page.login(); 
		Menubar order = new Menubar(driver);
		order.clickonorder();
		order.clickoncatalog();
		CatalogPage cp = new CatalogPage(driver);
		cp.chknumericincat();
		
		Logout logout= new Logout(driver);
		logout.clickonlogout();
	}
	@Test(testName="catalog",priority=3,enabled=false)
	public void verify_catalog_and_addtocart() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		long startTime = System.currentTimeMillis();
		SoftAssert Softassert = new SoftAssert();
		extentTest=extentReports.createTest("verify checkbox when qty is inserted ");
		Loginpage page = new Loginpage(driver); 
		page.enterhanesusername();
		page.login();   
		page.enterhanespassword();
		page.login(); 
		Menubar order = new Menubar(driver);
		order.clickonorder();
		order.clickoncatalog();
		CatalogPage cp = new CatalogPage(driver);
		cp.cataAddtocart();
		//Thread.sleep(10000);
		Logout logout= new Logout(driver);
		logout.clickonlogout();
	}
		
	
	//////////////////// add screenshots ////////////////////
	
	@AfterTest
	public void aftertest() throws Exception {
		//Thread.sleep(40000);
		
		Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {



           protected PasswordAuthentication getPasswordAuthentication() {



                return new PasswordAuthentication("mailtobishnupriyabehera@gmail.com", "ismonvmqyvstcmlo");
}
            });



       try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("bishnupriya.behera@r-pac.com"));
            message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("bishnupriya.behera@r-pac.com"));
            message.setSubject("Testcase Report");
            BodyPart messageBodyPart1 = new MimeBodyPart();
            messageBodyPart1.setText("this is rtrac testcase report");
            MimeBodyPart messageBodyPart2 = new MimeBodyPart();
           // String filename = "System.getProperty(\"user.dir\")+\"\\Default test.pdf\";
           // System.out.println("C:\\Users\\Bishnupriya.Behera\\eclipse-workspace\\Rpacpom\\Alltests.html");
            String filename = System.getProperty("user.dir")+"\\TC_Reports.html";
            DataSource source = new FileDataSource(filename);
            messageBodyPart2.setDataHandler(new DataHandler(source));
            messageBodyPart2.setFileName(filename);
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart2);
            multipart.addBodyPart(messageBodyPart1);
            message.setContent(multipart);
            Transport.send(message);
            System.out.println("=====Email Sent=====");



       } catch (MessagingException e) {



           throw new RuntimeException(e);




    }
		driver.quit();
	}
	
	
	/////////////////Add annotation for extent report/////////////////////////
	@BeforeSuite
	public void initialiseExtentReports() {
	
		ExtentSparkReporter sparkReporter_all = new ExtentSparkReporter("TC_Reports.html");
		extentReports = new ExtentReports();
		extentReports.attachReporter(sparkReporter_all);
		
		extentReports.setSystemInfo("os", System.getProperty("os.name"));
		extentReports.setSystemInfo("java", System.getProperty("java.name"));
	}
	@AfterSuite
	public void generateExeentReports () throws Exception  {
		extentReports.flush();
		Desktop.getDesktop().browse(new File("TC_Reports.html").toURI());
	}
	///////////////////
	
	@AfterMethod
    public void checkStatus(Method m,ITestResult result) {
		 long a = (result.getEndMillis()-result.getStartMillis())/1000;
		 //System.out.println("Time taken to run test is :"+a+" miliiseconds");
		 extentTest.info("Time taken to run test is :"+a+" Seconds");
        if(result.getStatus() == ITestResult.FAILURE ) {
        String screenshotpath = null;
        screenshotpath = getScreenshot(driver, result.getTestContext().getName(), screenshotpath);
        extentTest.addScreenCaptureFromPath(screenshotpath);
        extentTest.fail(result.getThrowable());
        }else if(result.getStatus() == ITestResult.SUCCESS ) {
        	
        extentTest.pass(m.getName()+"is passed");
        
        }

        
		   

       }
    




    public static String getScreenshot(WebDriver driver,String name, String screenshotpath) {



       TakesScreenshot ts=(TakesScreenshot) driver;
        File src=ts.getScreenshotAs(OutputType.FILE);



       String path=System.getProperty("user.dir")+"/Screenshot/"+System.currentTimeMillis()+".png";



       File destination=new File(path);
        



       try
        {
            FileUtils.copyFile(src, destination);
        } catch (IOException e)
        {
            System.out.println("Capture Failed "+e.getMessage());
        }



       return path;
       
}
}
