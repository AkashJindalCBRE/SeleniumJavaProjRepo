package testScripts;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basePackage.baseClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.currentDate;

public class loginTest extends baseClass {
	
	public WebDriver driver;
	currentDate cd = new currentDate();
	
	@BeforeMethod
	public void launchBrowser() throws IOException
	{
		configurationFileRead();
		driver = browserLaunchApplicationLaunch(p.getProperty("browser")); // "p" object is accessible as it is public in baseClass
//		String browserName = "Chrome";
//		
//		if (browserName.equals("Chrome"))
//		{
//			driver = new ChromeDriver();
//		}
//		else
//		{
//			if(browserName.equals("Safari"))
//			{
//				driver = new SafariDriver();
//			}
//			else
//			{
//				if(browserName.equals("Firefox"))
//						{
//					driver = new FirefoxDriver(); 
//						}
//			}
//		}
//		
//		
////		driver = new ChromeDriver();
//		driver.manage().window().maximize();
//        
////      driver.get("https://tutorialsninja.com/demo/");
//      
//      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//      driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
//      
//      driver.get("https://tutorialsninja.com/demo/");
      driver.findElement(By.xpath("//span[text()='My Account']")).click();
//      driver.findElement(By.linkText("Login")).click();
	}
	
	
	
	@AfterMethod
	public void closeDriver()
	{
		driver.quit();
	}
	
	@Test (priority=1,dataProvider="loginAndPasswordDataFromExcelFile")
	public void loginFunction(String id, String pwd) // "id" and "pwd" are used to store data from dataProvider method "loginAndPasswordData"
	{
		// Setup WebDriver Manager
//        WebDriverManager.chromedriver().setup();

        // Create a new instance of the Chrome driver
//        driver = new ChromeDriver();
        
//        driver.manage().window().maximize();
//        
////        driver.get("https://tutorialsninja.com/demo/");
//        
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
//        
//        driver.get("https://tutorialsninja.com/demo/");
        
//        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Login")).click();
        
        // getting email and password from testData.properties file
        
//        driver.findElement(By.xpath("//input[@id=\"input-email\"]")).sendKeys(p.getProperty("email"));
//        driver.findElement(By.xpath("//input[@id=\"input-password\"]")).sendKeys(p.getProperty("password"));
        
        //here, "p.getProperty("email")" and "p.getProperty("password")" to be fetched from dataProvider method,
        //so, we will modify it as below, where "id" and "pwd" are this method's argument who get data from
        // data provider method "loginAndPasswordData (hardcoded), or loginAndPasswordDataFromExcelFile (where data is fetched from excel file)"
        driver.findElement(By.xpath("//input[@id=\"input-email\"]")).sendKeys(id);
        driver.findElement(By.xpath("//input[@id=\"input-password\"]")).sendKeys(pwd);
        
        driver.findElement(By.xpath("//input[@value='Login']")).click();
        
        Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
        
//        driver.quit();    
        
	}
	
	// if like to read the login id and password from DataProvider using a method, we will create two dimensional 
	// array, and call this method in test case 1, using DataProvider annotation
	@DataProvider
	public Object[][] loginAndPasswordData()
	{
		Object[][] data = {  {"akashjindal.87@gmail.com","12345"},
						{"akashjindal.88@gmail.com","12345"},
						{"akashjindal.89@gmail.com","12345"} };
		return data;	}

	// if we like to read the data from excel file, we will first add three dependencies from maven : Apache POI,
	// , Apache POI API based on OPC and  OOXML Schemas and Apache POI common
	// create a method to read excel data in utils : currentData class
	
	@DataProvider
	public Object[][] loginAndPasswordDataFromExcelFile() throws IOException
	{
		Object[][] data = cd.readExcelData("Sheet1");
		return data;
	}
	
	
	@Test (priority=2)
	public void invalidLogin()
	{
//		WebDriverManager.chromedriver().setup();
//		
//		driver = new ChromeDriver();
//		
//		driver.manage().window().maximize();
        
//      driver.get("https://tutorialsninja.com/demo/");
//      
//      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//      driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
//      
//      driver.get("https://tutorialsninja.com/demo/");
      
//      driver.findElement(By.xpath("//span[text()='My Account']")).click();
      driver.findElement(By.linkText("Login")).click();
//      
      //pass invalid id
      driver.findElement(By.xpath("//input[@id=\"input-email\"]")).sendKeys(p.getProperty("email")+cd.returnDate()+"@gmail.com");
      //pass invalid password
      driver.findElement(By.xpath("//input[@id=\"input-password\"]")).sendKeys(td.getProperty("invalidPassword"));
      driver.findElement(By.xpath("//input[@value='Login']")).click();
      
      Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Warning: No match for E-Mail Address and/or Password.']")).isDisplayed());
            
//      driver.quit();    
		
		
	}

}
