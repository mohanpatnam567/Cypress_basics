package SmokeTestModule;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import CommonMethods.PropertyfileConfig;


public class SmokeTest_GetExtentReports {

	static WebDriver driver;
	static ExtentHtmlReporter Report;
	static ExtentReports SmokeTest_report;	
	static ExtentTest SmokeTest_test;
	public static Properties prop = PropertyfileConfig.Propertyfile();

	public static void GetExtentReports_StartReports(String Scenario) 
	{
		LocalDateTime DT = LocalDateTime.now();
		String DTime = DT.toString();
		String D_T = DTime.replaceAll("[^a-zA-Z0-9]", "_");
		Report = new ExtentHtmlReporter(System.getProperty("user.dir") +"/Extent Reports/"+Scenario+" "+D_T+".html");
		SmokeTest_report = new ExtentReports();
		SmokeTest_report.attachReporter(Report);
		
		SmokeTest_report.setSystemInfo("Project", "MyCompetency");
		SmokeTest_report.setSystemInfo("Environment",prop.getProperty("Environment"));
		
		
		SmokeTest_report.setSystemInfo("URL",prop.getProperty("Main_Url"));
		SmokeTest_report.setSystemInfo("Server",prop.getProperty("ServerName"));
		
		SmokeTest_report.setSystemInfo("Database",prop.getProperty("Database_Name"));
		SmokeTest_report.setSystemInfo("Module","Executive Assessment Module");
		SmokeTest_report.setSystemInfo("Tester",prop.getProperty("Tester"));
		SmokeTest_report.setSystemInfo("Scenario",Scenario);
	}

	public static ExtentReports getReport()
	{
		return SmokeTest_report;
	}

	public static void PassTest(WebDriver driver, ExtentTest SmokeTest_test, String Statuss)
	{	
		try 
		{
			SmokeTest_test.pass(Statuss, MediaEntityBuilder.createScreenCaptureFromPath(capture(driver).replace(System.getProperty("user.dir"), "..")).build());
		} 
		catch (IOException e) 
		{
			System.out.println(e);
		}
	}
	
	public static void PassTestWithoutScreenshot(WebDriver driver, ExtentTest SmokeTest_test, String Statuss)
	{	
		SmokeTest_test.log(Status.PASS, Statuss);
	}
	
	public static void FailTestWithoutScreenshot(WebDriver driver, ExtentTest SmokeTest_test, String Statuss)
	{	
		SmokeTest_test.log(Status.FAIL, Statuss);
	}

	public static void FailTest(WebDriver driver, ExtentTest SmokeTest_test, String Statuss )
	{	

		try 
		{
			SmokeTest_test.fail(Statuss, MediaEntityBuilder.createScreenCaptureFromPath(capture(driver).replace(System.getProperty("user.dir"), "..")).build());
		}
		catch (IOException e) 
		{
			System.out.println(e);
		}
	}

	public static void Exception(WebDriver driver,ExtentTest SmokeTest_test, java.lang.Exception e)
	{
		SmokeTest_test.log(Status.FAIL, e);
	}

	public static void DBCheck(WebDriver driver,ExtentTest SmokeTest_test, String Statuss)
	{
		try 
		{
			SmokeTest_test.log(Status.PASS, Statuss);
		}
		catch (Exception e) 
		{
			System.out.println(e);
		}
	}

	public static void getResult(java.lang.Exception E,WebDriver driver,ExtentTest SmokeTest_test) 
	{      
		String error = E.toString();
		System.out.println("\n"+"************************************************************"+"\n");
		System.out.println(error);
		if (error.contains("NoSuchElementException")
				||error.contains("NotFoundException")
				||error.contains("WebDriverException")) 
		{
			SmokeTest_test.log(Status.FAIL, "Test case failed due to the " + error);
			SmokeTest_test.log(Status.FAIL, "Category : Invalid Locator/webpage is still loading");
		}
		else if (error.contains("StaleElementReferenceException")) 
		{
			SmokeTest_test.log(Status.FAIL, "Test case failed due to the " + error);
			SmokeTest_test.log(Status.FAIL, "Category : Page Loaded/Refreshed");
		}
		else if (error.contains("MoveTargetOutOfBoundsException")) 
		{
			SmokeTest_test.log(Status.FAIL, "Test case failed due to the " + error);
			SmokeTest_test.log(Status.FAIL, "Category : ActionsChains move() method is invalid");
		}
		else if (error.contains("NoSuchFrameException")
				||error.contains("NoSuchWindowException")
				||error.contains("InvalidSwitchToTargetException")) 
		{
			SmokeTest_test.log(Status.FAIL, "Test case failed due to the " + error);
			SmokeTest_test.log(Status.FAIL, "Category :  Frame or Window target to be switched doesn’t exist");
		}
		else if (error.contains("NoAlertPresentException")) 
		{
			SmokeTest_test.log(Status.FAIL, "Test case failed due to the " + error);
			SmokeTest_test.log(Status.FAIL, "Category : Alert doesn’t exist or is not available");
		}
		else if (error.contains("UnexpectedAlertPresentException")
				||error.contains("UnhandledAlertException")) 
		{
			SmokeTest_test.log(Status.FAIL, "Test case failed due to the " + error);
			SmokeTest_test.log(Status.FAIL, "Category : unexpected alert open");
		}
		else if (error.contains("ElementNotVisibleException")) 
		{
			SmokeTest_test.log(Status.FAIL, "Test case failed due to the " + error);
			SmokeTest_test.log(Status.FAIL, "Category : Page not loaded/Element is hidden");
		}
		else if (error.contains("ElementNotSelectableException")) 
		{
			SmokeTest_test.log(Status.FAIL, "Test case failed due to the " + error);
			SmokeTest_test.log(Status.FAIL, "Category : Element is disabled/can not be clicked/selected");
		}
		else if (error.contains("TimeoutException")) 
		{
			SmokeTest_test.log(Status.FAIL, "Test case failed due to the " + error);
			SmokeTest_test.log(Status.FAIL, "Category : Page not loaded/Search operation finished before element loaded");
		}
		else if (error.contains("NoSuchSessionException")) 
		{
			SmokeTest_test.log(Status.FAIL, "Test case failed due to the " + error);
			SmokeTest_test.log(Status.FAIL, "Category : Browser Closed/Quitted");
		}
		else if (error.contains("NoSuchAttributeException")) 
		{
			SmokeTest_test.log(Status.FAIL, "Test case failed due to the " + error);
			SmokeTest_test.log(Status.FAIL, "Category : Attribute of element could not be found");
		}
		else if (error.contains("ScreenshotException")) 
		{
			SmokeTest_test.log(Status.FAIL, "Test case failed due to the " + error);
			SmokeTest_test.log(Status.FAIL, "Category : A screen capture was made impossible");
		}
		else if (error.contains("SQLServerException")) 
		{
			System.out.print("SQL Server Exception");
		}
		else
		{
			System.out.println("Inside the Else");
			SmokeTest_test.log(Status.FAIL, E);
		}

	}


	public static String capture(WebDriver driver) 
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		System.out.println(driver);
		File source = ts.getScreenshotAs(OutputType.FILE);
		System.out.println(source);		
		LocalDateTime DT = LocalDateTime.now();
		String DTime = DT.toString();
		String D_T = DTime.replaceAll("[^a-zA-Z0-9]", "_");
		String dest= System.getProperty("user.dir") + "/Extent Reports/ErrorScreenshots/" +D_T+".png";
		File destination = new File(dest);

		try {
			FileUtils.copyFile(source, destination);
		} 
		catch (IOException e) {

			System.out.println(e);
		}		
		return dest;
	}


}