package testScripts;

import static org.testng.Assert.assertTrue;

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

public class searchTest extends baseClass{
	
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
     // driver.findElement(By.xpath("//span[text()='My Account']")).click();
//      driver.findElement(By.linkText("Login")).click();
	}
	
	
	
	@AfterMethod
	public void closeDriver()
	{
		driver.quit();
	}
	
	@Test (priority=1)
	public void searchWithValidProduct()
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
		String productToSrch = "HP";
       driver.findElement(By.name("search")).sendKeys(productToSrch);
       driver.findElement(By.xpath("//div[@id='search']/descendant::button")).click();
        
        Assert.assertTrue(driver.findElement(By.xpath("//a[text()='HP LP3065']")).isDisplayed(),productToSrch+" product is not there in the list.");
        
//        driver.quit();    
        
	}
	
	
	@Test (priority=2)
	public void searchWithValidInvalidProduct()
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
		String productToSrch = "Akash";
		driver.findElement(By.name("search")).sendKeys(productToSrch);
	       driver.findElement(By.xpath("//div[@id='search']/descendant::button")).click();
	        
	       String validationMsg = driver.findElement(By.xpath("//p[text()='There is no product that matches the search criteria.']")).getText();
	       Assert.assertEquals(validationMsg, "There is no product that matches the search criteria.","Expected validation message is not displayed.");
	             
//      driver.quit();    
		
		
	}

}
