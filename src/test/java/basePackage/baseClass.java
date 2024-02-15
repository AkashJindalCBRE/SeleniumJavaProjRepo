package basePackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class baseClass {
	
	WebDriver driver;
	
	public Properties p; // public is used so that this can be used in sub class or other class for configutaion.properties file
	public Properties td; // public is used so that this can be used in sub class or other class for testData.properties file
	
 //method to read configuration.properties file
 // "System.getProperty("user.dir")" will point to the system project path, after that add the configuration file path
	
	public void configurationFileRead() throws IOException 
	{
	
//		Properties p = new Properties(); "Properties p;" is declared global so that using p object, configuration's file data can be fetched
		p = new Properties();
		File f1 = new File(System.getProperty("user.dir")+"\\src\\main\\java\\config\\configuration.properties");
		FileInputStream fis1 = new FileInputStream(f1);
		p.load(fis1);
		
		td = new Properties();
		File f2 = new File(System.getProperty("user.dir")+"\\src\\main\\java\\testData\\testData.properties");
		FileInputStream fis2 = new FileInputStream(f2);
		td.load(fis2);
		
		
		
	}
	
	//method to launch broswer and application
	
	public WebDriver browserLaunchApplicationLaunch(String broswer)
	{
//String browserName = "Chrome";
		
		if (broswer.equalsIgnoreCase("Chrome"))
		{
			driver = new ChromeDriver();
		}
		else
		{
			if(broswer.equalsIgnoreCase("Safari"))
			{
				driver = new SafariDriver();
			}
			else
			{
				if(broswer.equalsIgnoreCase("Firefox"))
						{
					driver = new FirefoxDriver(); 
						}
			}
		}
		
		
//		driver = new ChromeDriver();
		driver.manage().window().maximize();
        
//      driver.get("https://tutorialsninja.com/demo/");
      
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
      driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
      
      driver.get(p.getProperty("url"));
      
      return driver;
	}

}
