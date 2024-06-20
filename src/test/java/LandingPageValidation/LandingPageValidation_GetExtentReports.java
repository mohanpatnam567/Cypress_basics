package LandingPageValidation;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Properties;
import javax.imageio.ImageIO;
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

public class LandingPageValidation_GetExtentReports {

	static WebDriver driver;
	static ExtentReports LPVTest_report;
	static ExtentHtmlReporter Report;
	static ExtentTest LPVTest_test;
	public static Properties prop = PropertyfileConfig.Propertyfile();		
	
	public static void GetExtentReports_StartReports(String Scenario) 
	{
		LocalDateTime DT = LocalDateTime.now();
		String DTime = DT.toString();
		String D_T = DTime.replaceAll("[^a-zA-Z0-9]", "_");
		Report = new ExtentHtmlReporter(System.getProperty("user.dir") +"/Extent Reports/"+Scenario+" "+D_T+".html");
		LPVTest_report = new ExtentReports();
		LPVTest_report.attachReporter(Report);
		
		LPVTest_report.setSystemInfo("Project", "MyCompetency");
		LPVTest_report.setSystemInfo("Environment",prop.getProperty("Environment"));
		
		LPVTest_report.setSystemInfo("URL",prop.getProperty("Main_Url"));
		LPVTest_report.setSystemInfo("Server",prop.getProperty("ServerName"));
		
		LPVTest_report.setSystemInfo("Database",prop.getProperty("Database_Name"));
		LPVTest_report.setSystemInfo("Module","Expert Assessment Module");
		LPVTest_report.setSystemInfo("Tester",prop.getProperty("Tester"));
		LPVTest_report.setSystemInfo("Scenario",Scenario);
	}
	
	public static ExtentReports getReport()
	{
	    return LPVTest_report;
	}
	
	public static void PassTest(WebDriver driver, ExtentTest LPVTest_test, String Statuss)
	{	try 
	 	{
		
		   LPVTest_test.pass(Statuss, MediaEntityBuilder.createScreenCaptureFromPath(capture(driver)).build());
		   
	 	} 
		catch (IOException e) 
		{

			System.out.println(e);
		}
	}

	public static void FailTest(WebDriver driver, ExtentTest LPVTest_test, String Statuss)
	{	try 
		{
		
		   LPVTest_test.fail(Statuss, MediaEntityBuilder.createScreenCaptureFromPath(capture(driver)).build());
			
							
		} 
		catch (IOException e) 
		{

		System.out.println(e);
		}	
	}
	
	public static void Exception(WebDriver driver, ExtentTest LPVTest_test, java.lang.Exception e)
	{
		LPVTest_test.log(Status.FAIL, e);
	}
	
	public static void DBCheck(WebDriver driver, ExtentTest LPVTest_test, String Statuss)
	{
		try 
		{
			LPVTest_test.log(Status.PASS, Statuss);
		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}
	}

	public static String RobotScreenshot() throws AWTException, IOException 
	{	
		Robot robot = new Robot();
		Dimension dimension =Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle rectangle = new Rectangle(dimension);
		BufferedImage src= robot.createScreenCapture(rectangle);
		LocalDateTime DT = LocalDateTime.now();
		String DTime = DT.toString();
		String D_T = DTime.replaceAll("[^a-zA-Z0-9]", "_");
		String path= System.getProperty("user.dir") + "/Extent Reports/ErrorScreenshots/" +D_T+".png";
		File dest = new File(path);
		ImageIO.write(src, "png", dest);
		return path;
	}

	public static String capture(WebDriver driver)
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		LocalDateTime DT = LocalDateTime.now();
		String DTime = DT.toString();
		String D_T = DTime.replaceAll("[^a-zA-Z0-9]", "_");
		String dest= System.getProperty("user.dir") + "/Extent Reports/ErrorScreenshots/" +D_T+".png";
		File destination = new File(dest);
		try 
		{
			FileUtils.copyFile(source, destination);
		}
		catch (IOException e) 
		{
			System.out.println(e);
		}        
		return dest;
	}

	
}
