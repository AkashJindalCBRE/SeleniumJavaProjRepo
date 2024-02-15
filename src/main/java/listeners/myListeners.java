package listeners;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import experiment.demo;
import utils.extentReporter;

public class myListeners implements ITestListener{
	
	ExtentReports extentReport;
	ExtentTest extentTest;
	
	
	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
//		ITestListener.super.onStart(context); // remove, not needed
		
		// call extent report before starting execution
		
	try {
		extentReport = extentReporter.generateExtentReport();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		
		// this is to print logs in console, which will be printed only after adding "listeners" path in testng.xml
		System.out.println("Execution of Project Tests Started");
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
//		ITestListener.super.onTestStart(result); // remove, not needed
		
//		this is to print logs in console, which will be printed only after adding "listeners" path in testng.xml
		String testName = result.getName(); // will return name of test started for execution
		
		extentTest = extentReport.createTest(testName); // generate name for extent report
		extentTest.log(Status.INFO, testName + " started executing.");
//		
//		System.out.println("Execution of " + testName + " Started Executing"); // this is for console log
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
//		ITestListener.super.onTestSuccess(result); // remove, not needed
//		this is to print logs in console, which will be printed only after adding "listeners" path in testng.xml
		String testName = result.getName(); // will return name of test started for execution
		
		extentTest = extentReport.createTest(testName); // generate status of test
		extentTest.log(Status.PASS, testName + " got passed successfully.");
//		
//		System.out.println("Execution of " + testName + " executed successfully."); // this is for console log
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
//		ITestListener.super.onTestFailure(result); // remove, not needed
//		this is to print logs in console, which will be printed only after adding "listeners" path in testng.xml
		String testName = result.getName(); // will return name of test started for execution		
//		
		WebDriver driver = null;
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		File srcScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); // take screenshot
		
		// now set screenshot to destination path, create Screenshot folder in project manually
		
		String screenShotPath = System.getProperty("user.dir")+"//Screenshots"+testName+".png";
		
		// save screenshot to destination folder
		
		try {
			FileHandler.copy(srcScreenshot, new File(screenShotPath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//attach the screenshot to extent report
				
		extentTest = extentReport.createTest(testName); // generate status of test
//		
		extentTest.addScreenCaptureFromPath(screenShotPath);
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.FAIL, testName + " got failed.");
//		
//		System.out.println("Execution of " + testName + " Failed.");
//		System.out.println(result.getThrowable());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
//		ITestListener.super.onTestSkipped(result); // remove, not needed
//		this is to print logs in console, which will be printed only after adding "listeners" path in testng.xml
		String testName = result.getName(); // will return name of test started for execution
//		
		extentTest = extentReport.createTest(testName); // generate status of test
//		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.SKIP, testName + " skipped execution.");
//		
//		System.out.println("Execution of " + testName + " Skipped.");
//		System.out.println(result.getThrowable());
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
//		ITestListener.super.onFinish(context); // remove, not needed
		
		extentReport.flush(); // report will be created
		
//		this is to print logs in console, which will be printed only after adding "listeners" path in testng.xml
//		System.out.println("Execution of Project Tests Finished");
	}
	
	

}
