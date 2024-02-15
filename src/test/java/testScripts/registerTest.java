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
import org.testng.annotations.Test;

import basePackage.baseClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.currentDate;

public class registerTest extends baseClass{
	
	public WebDriver driver;
	currentDate cd = new currentDate();
	
	@BeforeMethod
	public void launchBrowser() throws IOException
	{
		configurationFileRead();
		driver = browserLaunchApplicationLaunch(p.getProperty("browser"));
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
	
	@Test (priority=1)
	public void registerMandatoryFields()
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
        driver.findElement(By.linkText("Register")).click();
        
        driver.findElement(By.xpath("//input[@id=\"input-firstname\"]")).sendKeys("akash");
        driver.findElement(By.xpath("//input[@id=\"input-lastname\"]")).sendKeys("akash");
        driver.findElement(By.xpath("//input[@id=\"input-email\"]")).sendKeys("akash"+cd.returnDate()+"@gmail.com");
        driver.findElement(By.xpath("//input[@id=\"input-telephone\"]")).sendKeys("8742908898");
        driver.findElement(By.xpath("//input[@id=\"input-password\"]")).sendKeys("Aadi@123");
        driver.findElement(By.xpath("//input[@id=\"input-confirm\"]")).sendKeys("Aadi@123");
        driver.findElement(By.xpath("//input[@name='agree']")).click();
        driver.findElement(By.xpath("//input[@value=\"Continue\"]")).click();
        
        Assert.assertTrue(driver.findElement(By.xpath("//h1[text()='Your Account Has Been Created!']")).isDisplayed());
        
//        driver.quit();    
        
	}
	
	
	@Test (priority=2)
	public void registerAllFields()
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
      
//      driver.get("https://tutorialsninja.com/demo/");
      
//      driver.findElement(By.xpath("//span[text()='My Account']")).click();
		   driver.findElement(By.linkText("Register")).click();
	        
	        driver.findElement(By.xpath("//input[@id=\"input-firstname\"]")).sendKeys("akash");
	        driver.findElement(By.xpath("//input[@id=\"input-lastname\"]")).sendKeys("akash");
	        driver.findElement(By.xpath("//input[@id=\"input-email\"]")).sendKeys("akash"+cd.returnDate()+"@gmail.com");
	        driver.findElement(By.xpath("//input[@id=\"input-telephone\"]")).sendKeys("8742908898");
	        driver.findElement(By.xpath("//input[@id=\"input-password\"]")).sendKeys("Aadi@123");
	        driver.findElement(By.xpath("//input[@id=\"input-confirm\"]")).sendKeys("Aadi@123");
	        driver.findElement(By.xpath("//input[@name='agree']")).click();
	        driver.findElement(By.xpath("(//input[@value='1'])[2]")).click();
	        driver.findElement(By.xpath("//input[@value=\"Continue\"]")).click();
	        
	        Assert.assertTrue(driver.findElement(By.xpath("//h1[text()='Your Account Has Been Created!']")).isDisplayed());
	             
//      driver.quit();    
		
		
	}

}
