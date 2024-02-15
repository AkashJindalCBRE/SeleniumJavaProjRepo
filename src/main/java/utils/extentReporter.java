package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class extentReporter {
	
	public static ExtentReports generateExtentReport() throws IOException
	{
		
		// Create an object for ExtentReports
		
		ExtentReports extentReportsObject = new ExtentReports(); // also add Maven dependency of ExtentReports : of com.aventstack » extentreports
		
//		 Go to official website of ExtentReports : https://extentreports.com/
//		right hand side : docs --> version 5 --> Java
//		left side menu : Getting Started --> Reporters
//		spark reporter we will use
		
		// Create an object of Spark Reporter
		// report will be generated in html format, so we will provide path of generated report
		
//		ExtentReport is the folder we created in test-output folder and ExtetReport.html is the report name, that we will provide to spark reporter
		
		File extentReportFile = new File(System.getProperty("user.dir") + "\\test-output\\ExtentReports\\ExtentReport.html");
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFile);
		
//		Now, set some configutaion using this spark reporter object : sparkReporter
//		to have a look, go back to ExtentReport website, left side menu : A Complete Example, then click on "online here" link
//		this is the default example, how extent report looks like
//		however we can change configurations
		
//		1. Theme
		
		sparkReporter.config().setTheme(Theme.DARK);
		
//		2. Report Name
		
		sparkReporter.config().setReportName("Extent Report Name");
		
//		3. Document Title : URL of generated extent report page
		
		sparkReporter.config().setDocumentTitle("Automation Report Title");
		
//		4. Time-stamp
		
		sparkReporter.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");
		
//		attach spark reporter to extent report
		
		extentReportsObject.attachReporter(sparkReporter);
		
//		now, provide user and application information to extent report
		
//		on the website, left side menu, last option is dashboard : https://www.extentreports.com/docs/v5/wiki/spark/spark.html#
//		so, we will now add information to be displayed under the table, the table we can see on the dashboard
		
//		1. Application URL from property file
		
		Properties p = new Properties();
		File f = new File(System.getProperty("user.dir")+"\\src\\main\\java\\config\\configuration.properties");
		FileInputStream fis = new FileInputStream(f);
		p.load(fis);
		
		extentReportsObject.setSystemInfo("Application URL : ", p.getProperty("url"));
		
//		2. Browser name
		
		extentReportsObject.setSystemInfo("Application Browser : ", p.getProperty("browser"));
		
//		3. Email
		
		extentReportsObject.setSystemInfo("Application Email : ", p.getProperty("email"));
		
//		4. Password
		
		extentReportsObject.setSystemInfo("Application Password : ", p.getProperty("password"));
		
//		 5. Operating System and username and Java version
		
//		for this, create a package "experiment" and "demo" class
		
		extentReportsObject.setSystemInfo("Operating System : ", System.getProperty("os.version"));
		
		extentReportsObject.setSystemInfo("Java Version : ", System.getProperty("java.version"));
		
		extentReportsObject.setSystemInfo("User Name : ", System.getProperty("user.name"));
		
//		now, return this extentReports, so change "void" in main method as to ExtentReports, extent name class name 
		
		return extentReportsObject; 		

//		call this extent report in listeners
		
	}

}