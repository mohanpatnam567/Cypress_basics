package SmokeTestModule;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import java.util.concurrent.TimeUnit;

import org.apache.poi.ddf.EscherColorRef.SysIndexSource;
import org.apache.poi.hssf.record.DrawingRecordForBiffViewer;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import CommonMethods.DriverSetup;
import CommonMethods.PropertyfileConfig;



public class SkillValidations {

	static ExcelReadWrite ExcelObj = new ExcelReadWrite();

	public static void PrimarySkillCardCheck(WebDriver driver, String Browser, String TestCaseID, ExtentTest SmokeTest_test)
	{
		PrimarySkillNameCheck(driver, Browser, TestCaseID, SmokeTest_test);
		PrimaryProficiencyNameCheck(driver, Browser, TestCaseID, SmokeTest_test);
		PrimarySkillChangeStatusCheck(driver, Browser, TestCaseID, SmokeTest_test);
		PrimarySkillLastAssessedStatusCheck(driver, Browser, TestCaseID, SmokeTest_test);
	}

	public static void SecondarySkillCardCheck(WebDriver driver, String Browser, String TestCaseID, ExtentTest SmokeTest_test)
	{
		SecondarySkillNameCheck(driver, Browser, TestCaseID, SmokeTest_test);
		SecondaryProficiencyNameCheck(driver, Browser, TestCaseID, SmokeTest_test);
		SecondarySkillSwapStatusCheck(driver, Browser, TestCaseID, SmokeTest_test);
		SecondarySkillLastAssessedStatusCheck(driver, Browser, TestCaseID, SmokeTest_test);
		SecondarySkillDeleteTrashStatusCheck(driver, Browser, TestCaseID, SmokeTest_test);
	}

	public static void getResult(java.lang.Exception E, WebDriver driver, ExtentTest SmokeTest_test) {
		String error = E.toString();
		
		
		System.out.println("\n" + "************************************************************" + "\n");
		System.out.println(error);
		if (error.contains("NoSuchElementException") || error.contains("NotFoundException")
				|| error.contains("WebDriverException")) {
			SmokeTest_test.log(Status.FAIL, "Test case failed due to the " + error);
			SmokeTest_test.log(Status.FAIL, "Category : Invalid Locator/webpage is still loading");
		} else if (error.contains("StaleElementReferenceException")) {
			SmokeTest_test.log(Status.FAIL, "Test case failed due to the " + error);
			SmokeTest_test.log(Status.FAIL, "Category : Page Loaded/Refreshed");
		} else if (error.contains("MoveTargetOutOfBoundsException")) {
			SmokeTest_test.log(Status.FAIL, "Test case failed due to the " + error);
			SmokeTest_test.log(Status.FAIL, "Category : ActionsChains move() method is invalid");
		} else if (error.contains("NoSuchFrameException") || error.contains("NoSuchWindowException")
				|| error.contains("InvalidSwitchToTargetException")) {
			SmokeTest_test.log(Status.FAIL, "Test case failed due to the " + error);
			SmokeTest_test.log(Status.FAIL, "Category :  Frame or Window target to be switched doesn’t exist");
		} else if (error.contains("NoAlertPresentException")) {
			SmokeTest_test.log(Status.FAIL, "Test case failed due to the " + error);
			SmokeTest_test.log(Status.FAIL, "Category : Alert doesn’t exist or is not available");
		} else if (error.contains("UnexpectedAlertPresentException") || error.contains("UnhandledAlertException")) {
			SmokeTest_test.log(Status.FAIL, "Test case failed due to the " + error);
			SmokeTest_test.log(Status.FAIL, "Category : unexpected alert open");
		} else if (error.contains("ElementNotVisibleException")) {
			SmokeTest_test.log(Status.FAIL, "Test case failed due to the " + error);
			SmokeTest_test.log(Status.FAIL, "Category : Page not loaded/Element is hidden");
		} else if (error.contains("ElementNotSelectableException")) {
			SmokeTest_test.log(Status.FAIL, "Test case failed due to the " + error);
			SmokeTest_test.log(Status.FAIL, "Category : Element is disabled/can not be clicked/selected");
		} else if (error.contains("TimeoutException")) {
			SmokeTest_test.log(Status.FAIL, "Test case failed due to the " + error);
			SmokeTest_test.log(Status.FAIL,
					"Category : Page not loaded/Search operation finished before element loaded");
		} else if (error.contains("NoSuchSessionException")) {
			SmokeTest_test.log(Status.FAIL, "Test case failed due to the " + error);
			SmokeTest_test.log(Status.FAIL, "Category : Browser Closed/Quitted");
		} else if (error.contains("NoSuchAttributeException")) {
			SmokeTest_test.log(Status.FAIL, "Test case failed due to the " + error);
			SmokeTest_test.log(Status.FAIL, "Category : Attribute of element could not be found");
		} else if (error.contains("ScreenshotException")) {
			SmokeTest_test.log(Status.FAIL, "Test case failed due to the " + error);
			SmokeTest_test.log(Status.FAIL, "Category : A screen capture was made impossible");
		} else {
			System.out.println("Inside the Else");
			SmokeTest_test.log(Status.FAIL, E);
		}

	}
	public static void PrimarySkillNameCheck(WebDriver driver, String Browser, String TestCaseID, ExtentTest SmokeTest_test)
	{
		String Title = "Primary Skill Name Validation";
		try
		{
			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(90));
			JavascriptExecutor executor = (JavascriptExecutor)driver;

			try
			{
				wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(PageObjects.SkillLoadingIconXpath)));
			}
			catch (Exception e)
			{}

			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PageObjects.PrimarySkillCardXpath)));
			WebElement Skill = driver.findElement(By.xpath(PageObjects.PrimarySkillNameXpath));
			String SkillName = driver.findElement(By.xpath(PageObjects.PrimarySkillNameXpath)).getText();
			if (Skill.isDisplayed())
			{
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Employee Primary Skill Displayed in HomePage Is :"+SkillName);
				ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: Primary Skill Name should be displayed", "The Actual Result is:" +SkillName, "Pass");
			}
			else
			{
				SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Employee Primary Skill is NOT Displayed in Home Page");
				ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: Primary Skill Name should be displayed", "The Actual Result is:" +SkillName, "Fail");
			}

			WebElement Skill1 = driver.findElement(By.xpath(PageObjects.PrimarySkillNameXpath));
			executor.executeScript("arguments[0].click();", Skill1);

			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PageObjects.SkillJourneyPageTitleCssSelector)));
			WebElement SkillTitle = driver.findElement(By.cssSelector(PageObjects.SkillJourneyPageTitleCssSelector));
			if (SkillTitle.isDisplayed())
			{
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Skill Journey Page Is Displayed");
				ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: Skill Journey Page should be displayed", "The Actual Result is: Skill Journey Page is displayed", "Pass");
				ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: Skill Title should be displayed in the Journey Page", "The Actual Result is: Skill Title is displayed in the Journey Page", "Pass");
			}
			else
			{
				SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Skill Journey Page Is NOT Displayed");
				ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: Skill Journey Page should be displayed", "The Actual Result is: Skill Journey Page is not displayed", "Fail");
				ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: Skill Title should be displayed in the Journey Page", "The Actual Result is: Skill Title is not displayed in the Journey Page", "Fail");
			}

			try
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PageObjects.SkillJourneyPageRatingCssSelector)));
			}
			catch (Exception e)
			{
				driver.navigate().refresh();
				wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(PageObjects.SkillLoadingIconInJourney)));
			}
			driver.navigate().refresh();
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PageObjects.SkillJourneyPageAssessmentStatusCssSelector)));
			WebElement ProficiencyRating = driver.findElement(By.cssSelector(PageObjects.SkillJourneyPageRatingCssSelector));
			if (ProficiencyRating.isDisplayed())
			{
				executor.executeScript("arguments[0].scrollIntoView(true);", ProficiencyRating);
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Skill Journey Page Proficiency Rating Is Displayed");
				ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: Proficiency Rating should be displayed in the Journey Page", "The Actual Result is: Proficiency Rating is displayed in the Journey Page", "Pass");
			}
			else
			{
				SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Skill Journey Page Proficiency Rating Is NOT Displayed");
				ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: Proficiency Rating should be displayed in the Journey Page", "The Actual Result is: Proficiency Rating is not displayed in the Journey Page", "Fail");
			}

			try
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PageObjects.SkillJourneyPageAssessmentStatusCssSelector)));
			}
			catch (Exception e)
			{}

			WebElement AssessmentStatus = driver.findElement(By.cssSelector(PageObjects.SkillJourneyPageAssessmentStatusCssSelector));
			if (AssessmentStatus.isDisplayed())
			{
				executor.executeScript("arguments[0].scrollIntoView(true);", AssessmentStatus);
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Skill Journey Page Overall Assessment Status Is Displayed");
				ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: Assessment Status should be displayed in the Journey Page", "The Actual Result is: Assessment Status is displayed in the Journey Page", "Pass");
			}
			else
			{
				SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Skill Journey Page Overall Assessment Status Is NOT Displayed");
				ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: Assessment Status should be displayed in the Journey Page", "The Actual Result is: Assessment Status is not displayed in the Journey Page", "Fail");
			}

			WebElement SkillSummary = driver.findElement(By.cssSelector(PageObjects.SkillJourneyPageSkillSummaryCssSelector));
			if (SkillSummary.isDisplayed())
			{
				executor.executeScript("arguments[0].scrollIntoView(true);", SkillSummary);
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Skill Journey Page Skill Summary Is Displayed");
				ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: Skill Summary should be displayed in the Journey Page", "The Actual Result is: Skill Summary is displayed in the Journey Page", "Pass");
			}
			else
			{
				SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Skill Journey Page Skill Summary Is NOT Displayed");
				ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: Skill Summary should be displayed in the Journey Page", "The Actual Result is: Skill Summary is not displayed in the Journey Page", "Fail");
			}

			try
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PageObjects.LearningRoadMap)));
			}
			catch (Exception e)
			{
				driver.navigate().refresh();
				wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(PageObjects.SkillLoadingIconInJourney)));
			}

			if (driver.findElements(By.cssSelector(PageObjects.LearningRoadMap)).size()!=0)
			{
				WebElement RoadMapLink = driver.findElement(By.cssSelector(PageObjects.LearningRoadMap));
				executor.executeScript("arguments[0].scrollIntoView(true);", RoadMapLink);
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Learning Road Map Link is Displayed Inside the Journey Page");
				String OldScreen = driver.getWindowHandle();
				executor.executeScript("arguments[0].click();", RoadMapLink);

				Set<String> AllWindow = driver.getWindowHandles();
				for (String Window : AllWindow)
				{
					driver.switchTo().window(Window);
				}

				try
				{
					Thread.sleep(2000);
					wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PageObjects.LearningRoadMapPage)));
				}
				catch (Exception e)
				{}

				if (driver.findElements(By.cssSelector(PageObjects.LearningRoadMapPage)).size()!=0)
				{
					SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Learning Road Map Page is Displayed");
				}
				else
				{
					SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Learning Road Map Page is NOT Displayed");
				}

				try
				{
					wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PageObjects.LearningRoadMapSection)));
				}
				catch (Exception e)
				{}

				if (driver.findElements(By.cssSelector(PageObjects.LearningRoadMapSection)).size()!=0)
				{
					SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Learning Road Map Section is Displayed");
					try
					{
						wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PageObjects.LearningRoadMapProficiency)));
					}
					catch (Exception e)
					{}

					if (driver.findElements(By.cssSelector(PageObjects.LearningRoadMapProficiency)).size()!=0)
					{
						SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Learning Road Map Proficiency P1 Is Displayed");
					}
					else
					{
						SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Learning Road Map Proficiency Is NOT Displayed");
					}

					WebElement P2Proficiency = driver.findElement(By.cssSelector(PageObjects.LearningRoadMapProficiencyP2));
					executor.executeScript("arguments[0].click();", P2Proficiency);

					try
					{
						wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PageObjects.LearningRoadMapProficiencyP2Xpath)));
					}
					catch (Exception e)
					{}

					if (driver.findElements(By.xpath(PageObjects.LearningRoadMapProficiencyP2Xpath)).size()!=0)
					{
						SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Learning Road Map Proficiency P2 Is Displayed");
					}
					else
					{
						SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Learning Road Map Proficiency Is NOT Displayed");
					}

					WebElement P5Proficiency = driver.findElement(By.cssSelector(PageObjects.LearningRoadMapProficiencyP5));
					executor.executeScript("arguments[0].click();", P5Proficiency);

					try
					{
						wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PageObjects.LearningRoadMapProficiencyP5Xpath)));
					}
					catch (Exception e)
					{}

					if (driver.findElements(By.xpath(PageObjects.LearningRoadMapProficiencyP5Xpath)).size()!=0)
					{
						SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Learning Road Map Proficiency P5 Is Displayed");
					}
					else
					{
						SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Learning Road Map Proficiency Is NOT Displayed");
					}
				}
				else
				{
					SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Learning Road Map Section is NOT Displayed");
				}
				driver.close();
				driver.switchTo().window(OldScreen);
			}
			else
			{
				SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Learning Road Map Link is NOT Displayed Inside the Journey Page");
			}

			WebElement BackToHome1 = driver.findElement(By.xpath(PageObjects.BackToHome));
			executor.executeScript("arguments[0].click();", BackToHome1);
		}
		catch (Exception E)
		{
			ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: Primary Skill Name should be displayed", "The Actual Result is: Exception: " +E, "Fail");
		}
	}

	public static void SecondarySkillNameCheck(WebDriver driver, String Browser, String TestCaseID, ExtentTest SmokeTest_test)
	{
		String Title = "Secondary Skill Name Check";
		try
		{
			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(90));
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PageObjects.SecondarySkillCardCss)));
			JavascriptExecutor executor = (JavascriptExecutor) driver;

			try
			{
				wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(PageObjects.SkillLoadingIconXpath)));
			}
			catch (Exception e)
			{}

			WebElement SecondarySkillTitle = driver.findElement(By.cssSelector(PageObjects.PrimarySkilLSection));
			executor.executeScript("arguments[0].scrollIntoView(true);", SecondarySkillTitle);

			WebElement Proficiency = driver.findElement(By.xpath(PageObjects.SecondarySkillNameXpath));
			String ProficiencyRanking = driver.findElement(By.xpath(PageObjects.SecondarySkillNameXpath)).getText();
			if (Proficiency.isDisplayed())
			{
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Secondary Skill Card Is Displayed for the Employee");
				ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: Secondary Skill Name should be displayed", "The Actual Result is:" +ProficiencyRanking, "Pass");
			}
			else
			{
				SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Secondary Skill Card Is NOT Displayed for the Employee");
				ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: Secondary Skill Name should be displayed", "The Actual Result is:" +ProficiencyRanking, "Fail");
			}

			WebElement Proficiency1 = driver.findElement(By.xpath(PageObjects.SecondarySkillNameXpath));
			executor.executeScript("arguments[0].click();", Proficiency1);

			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PageObjects.SkillJourneyPageTitleCssSelector)));
			WebElement SkillTitle = driver.findElement(By.cssSelector(PageObjects.SkillJourneyPageTitleCssSelector));
			if (SkillTitle.isDisplayed())
			{
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Skill Journey Page Is Displayed for the Employee");
				ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: Skill Journey Page should be displayed", "The Actual Result is: Skill Journey Page is displayed", "Pass");
				ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: Skill Title should be displayed in the Journey Page", "The Actual Result is: Skill Title is displayed in the Journey Page", "Pass");
			}
			else
			{
				SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Skill Journey Page Is NOT Displayed for the Employee");
				ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: Skill Journey Page should be displayed", "The Actual Result is: Skill Journey Page is not displayed", "Fail");
				ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: Skill Title should be displayed in the Journey Page", "The Actual Result is: Skill Title is not displayed in the Journey Page", "Fail");
			}
			try
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PageObjects.SkillJourneyPageRatingCssSelector)));
			}
			catch (Exception e)
			{
				driver.navigate().refresh();
				wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(PageObjects.SkillLoadingIconInJourney)));
			}

			WebElement ProficiencyRating = driver.findElement(By.cssSelector(PageObjects.SkillJourneyPageRatingCssSelector));
			if (ProficiencyRating.isDisplayed())
			{
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Skill Journey Page Proficiency Rating Is Displayed");
				ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: Proficiency Rating should be displayed in the Journey Page", "The Actual Result is: Proficiency Rating is displayed in the Journey Page", "Pass");
			}
			else
			{
				SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Skill Journey Page Proficiency Rating Is NOT Displayed");
				ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: Proficiency Rating should be displayed in the Journey Page", "The Actual Result is: Proficiency Rating is not displayed in the Journey Page", "Fail");
			}

			try
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PageObjects.SkillJourneyPageAssessmentStatusCssSelector)));
			}
			catch (Exception e)
			{}

			WebElement AssessmentStatus = driver.findElement(By.cssSelector(PageObjects.SkillJourneyPageAssessmentStatusCssSelector));
			if (AssessmentStatus.isDisplayed())
			{
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Skill Journey Page Overall Assessment Status Is Displayed");
				ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: Assessment Status should be displayed in the Journey Page", "The Actual Result is: Assessment Status is displayed in the Journey Page", "Pass");
			}
			else
			{
				SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Skill Journey Page Overall Assessment Status Is NOT Displayed");
				ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: Assessment Status should be displayed in the Journey Page", "The Actual Result is: Assessment Status is not displayed in the Journey Page", "Fail");
			}

			WebElement SkillSummary = driver.findElement(By.cssSelector(PageObjects.SkillJourneyPageSkillSummaryCssSelector));
			if (SkillSummary.isDisplayed())
			{
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Skill Journey Page Skill Summary Is Displayed");
				ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: Skill Summary should be displayed in the Journey Page", "The Actual Result is: Skill Summary is displayed in the Journey Page", "Pass");
			}
			else
			{
				SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Skill Journey Page Skill Summary Is NOT Displayed");
				ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: Skill Summary should be displayed in the Journey Page", "The Actual Result is: Skill Summary is not displayed in the Journey Page", "Fail");
			}

			try
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PageObjects.LearningRoadMap)));
			}
			catch (Exception e)
			{
				driver.navigate().refresh();
				wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(PageObjects.SkillLoadingIconInJourney)));
			}

			if (driver.findElements(By.cssSelector(PageObjects.LearningRoadMap)).size()!=0)
			{
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Learning Road Map Link is Displayed Inside the Journey Page");
				String OldScreen = driver.getWindowHandle();
				WebElement RoadMapLink = driver.findElement(By.cssSelector(PageObjects.LearningRoadMap));
				executor.executeScript("arguments[0].click();", RoadMapLink);

				Set<String> AllWindow = driver.getWindowHandles();
				for (String Window : AllWindow)
				{
					driver.switchTo().window(Window);
				}

				try
				{
					Thread.sleep(2000);
					wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PageObjects.LearningRoadMapPage)));
				}
				catch (Exception e)
				{}

				if (driver.findElements(By.cssSelector(PageObjects.LearningRoadMapPage)).size()!=0)
				{
					SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Learning Road Map Page is Displayed");
				}
				else
				{
					SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Learning Road Map Page is NOT Displayed");
				}

				try
				{
					wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PageObjects.LearningRoadMapSection)));
				}
				catch (Exception e)
				{}

				if (driver.findElements(By.cssSelector(PageObjects.LearningRoadMapSection)).size()!=0)
				{
					SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Learning Road Map Section is Displayed");
					try
					{
						wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PageObjects.LearningRoadMapProficiency)));
					}
					catch (Exception e)
					{}

					if (driver.findElements(By.cssSelector(PageObjects.LearningRoadMapProficiency)).size()!=0)
					{
						SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Learning Road Map Proficiency P1 Is Displayed");
					}
					else
					{
						SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Learning Road Map Proficiency Is NOT Displayed");
					}

					WebElement P2Proficiency = driver.findElement(By.cssSelector(PageObjects.LearningRoadMapProficiencyP2));
					executor.executeScript("arguments[0].click();", P2Proficiency);

					try
					{
						wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PageObjects.LearningRoadMapProficiency)));
					}
					catch (Exception e)
					{}

					if (driver.findElements(By.cssSelector(PageObjects.LearningRoadMapProficiency)).size()!=0)
					{
						SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Learning Road Map Proficiency P2 Is Displayed");
					}
					else
					{
						SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Learning Road Map Proficiency Is NOT Displayed");
					}

					WebElement P5Proficiency = driver.findElement(By.cssSelector(PageObjects.LearningRoadMapProficiencyP5));
					executor.executeScript("arguments[0].click();", P5Proficiency);

					try
					{
						wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PageObjects.LearningRoadMapProficiency)));
					}
					catch (Exception e)
					{}

					if (driver.findElements(By.cssSelector(PageObjects.LearningRoadMapProficiency)).size()!=0)
					{
						SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Learning Road Map Proficiency P5 Is Displayed");
					}
					else
					{
						SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Learning Road Map Proficiency Is NOT Displayed");
					}
				}
				else
				{
					SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Learning Road Map Section is NOT Displayed");
				}
				driver.close();
				driver.switchTo().window(OldScreen);
			}
			else
			{
				SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Learning Road Map Link is NOT Displayed Inside the Journey Page");
			}

			WebElement BackToHome1 = driver.findElement(By.xpath(PageObjects.BackToHome));
			executor.executeScript("arguments[0].click();", BackToHome1);
		}
		catch (Exception E)
		{
			ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: Primary Skill Name should be displayed", "The Actual Result is: Exception: " +E, "Fail");
		}
	}

	public static void PrimaryProficiencyNameCheck(WebDriver driver, String Browser, String TestCaseID, ExtentTest SmokeTest_test)
	{
		String Title = "Primary Skill Proficiency Name Check Validation";
		try
		{
			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(90));
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PageObjects.PrimarySkillCardXpath)));
			Thread.sleep(4000);
			try
			{
				wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(PageObjects.SkillLoadingIconXpath)));
			}
			catch (Exception e)
			{}
			driver.findElement(By.xpath(PageObjects.PrimarySkillCardXpath));
			WebElement Proficiency = driver.findElement(By.xpath(PageObjects.PrimaryProficiencyXpath));
			String ProficiencyRanking = driver.findElement(By.xpath(PageObjects.PrimaryProficiencyXpath)).getText();

			if (Proficiency.isDisplayed())
			{
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, ProficiencyRanking);
				ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: Proficiency should be displayed", "The Actual Result is:" +ProficiencyRanking, "Pass");
			}
			else
			{
				SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Proficiency is Displayed for the Employee");
				ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: Proficiency should be displayed", "The Actual Result is:" +ProficiencyRanking, "Fail");
			}
		}
		catch (Exception E)
		{
			SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Proficiency is Displayed for the Employee");
			ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: Proficiency should be displayed", "The Actual Result is: Exception: " +E, "Fail");
		}
	}

	public static void SecondaryProficiencyNameCheck(WebDriver driver, String Browser, String TestCaseID, ExtentTest SmokeTest_test)
	{
		String Title = "Secondary Skill Proficiency Name Check Validation";
		try
		{
			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(90));
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PageObjects.SecondarySkillCardCss)));
			JavascriptExecutor executor = (JavascriptExecutor)driver;

			try
			{
				wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(PageObjects.SkillLoadingIconXpath)));
			}
			catch (Exception e)
			{}

			WebElement SecondarySkillTitle = driver.findElement(By.cssSelector(PageObjects.PrimarySkilLSection));
			executor.executeScript("arguments[0].scrollIntoView(true);", SecondarySkillTitle);

			WebElement Proficiency = driver.findElement(By.xpath(PageObjects.SecondaryProficiencyXpath));
			String ProficiencyRanking = driver.findElement(By.xpath(PageObjects.SecondaryProficiencyXpath)).getText();

			if (Proficiency.isDisplayed())
			{
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Proficiency Is Displayed Correctly in the Home Page");
				ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: Proficiency should be displayed", "The Actual Result is:" +ProficiencyRanking, "Pass");
			}
			else  
			{
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Proficiency Is NOT Displayed Correctly in the Home Page");
				ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: Proficiency should be displayed", "The Actual Result is:" +ProficiencyRanking, "Fail");
			}
		}
		catch (Exception E)
		{
			SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Proficiency is Displayed for the Employee");
			ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: Proficiency should be displayed", "The Actual Result is: Exception: " +E, "Fail");
		}
	}

	public static void SecondarySkillSwapStatusCheck(WebDriver driver, String Browser, String TestCaseID, ExtentTest SmokeTest_test)
	{
		String Title = "Secondary Skill Swap Image Status Validation";
		try
		{
			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(90));
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PageObjects.SecondarySkillNameXpath)));
			WebElement PencilStatus = driver.findElement(By.cssSelector(PageObjects.SecondarySkillSwapStatusCssSelector));

			if (PencilStatus.isDisplayed())
			{
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Secondary Skill Swap Button is Displayed in the Employee Home Page");
				ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: Skill Swap Button should be displayed", "The Actual Result is:" +PencilStatus.isDisplayed(), "Pass");
			}
			else
			{
				SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Secondary Skill Swap Button is NOT Displayed in the Employee Home Page");
				ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: Skill Swap Button should be displayed", "The Actual Result is:" +PencilStatus.isDisplayed(), "Fail");
			}
		}
		catch (Exception E)
		{
			ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: Skill Swap Button should be displayed", "The Actual Result is: Exception" +E, "Fail");
		}
	}

	public static void PrimarySkillChangeStatusCheck(WebDriver driver, String Browser, String TestCaseID, ExtentTest SmokeTest_test)
	{
		String Title = "Primary Skill Change Status Validation";
		try
		{
			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(90));
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PageObjects.PrimarySkillCardXpath)));
			WebElement ChangeBtnStatus = driver.findElement(By.cssSelector(PageObjects.PrimaryChangeStatusCssSelector));

			if (ChangeBtnStatus.isDisplayed())
			{
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Primary Skill Change Button is Displayed for Employee HomePage");
				ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: Pencil Icon should be displayed", "The Actual Result is:" +ChangeBtnStatus.isDisplayed(), "Pass");
			}
			else
			{
				SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Primary Skill Change is NOT Displayed for Employee HomePage");
				ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: Pencil Icon should be displayed", "The Actual Result is:" +ChangeBtnStatus.isDisplayed(), "Fail");
			}
		}
		catch (Exception E)
		{
			ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: Pencil Icon should be displayed", "The Actual Result is: Exception" +E, "Fail");
		}
	}

	public static void SecondarySkillDeleteTrashStatusCheck(WebDriver driver, String Browser, String TestCaseID, ExtentTest SmokeTest_test)
	{
		String Title = "Secondary Skill Trash Image Status Validation";
		try
		{
			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(90));
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PageObjects.SecondarySkillCardCss)));
			WebElement TrashIcon = driver.findElement(By.cssSelector(PageObjects.SecondaryTrashbinStatusCssSelector));

			if (TrashIcon.isDisplayed())
			{
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Trash Icon Is Displayed in the Employee Home Page");
				ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: Trash Icon should be displayed", "The Actual Result is:" +TrashIcon.isDisplayed(), "Pass");
			}
			else
			{
				SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Trash Icon Is NOT Displayed in the Employee Home Page");
				ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: Trash Icon should be displayed", "The Actual Result is:" +TrashIcon.isDisplayed(), "Fail");
			}
		}	
		catch (Exception E)
		{
			ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: Trash Icon should be displayed", "The Actual Result is: Exception" +E, "Fail");
		}
	}


	public static void PrimarySkillLastAssessedStatusCheck(WebDriver driver, String Browser, String TestCaseID, ExtentTest SmokeTest_test)
	{
		String Title = "Primary Skill Last Assessed Status Validation";
		try
		{
			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(90));
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PageObjects.PrimarySkillCardXpath)));
			WebElement LastAssessedStatus = driver.findElement(By.cssSelector(PageObjects.PrimaryLastAssessedStatusCssSelector));
			String LastAssessedStatusTxt = driver.findElement(By.cssSelector(PageObjects.PrimaryLastAssessedStatusCssSelector)).getText();

			if (LastAssessedStatus.isDisplayed())
			{
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Last Assessed Status Is Displayed in the Employee Home Page "+LastAssessedStatusTxt);
				ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: Skill Last Assessed Status should be displayed", "The Actual Result is:" +LastAssessedStatus.isDisplayed(), "Pass");
			}
			else
			{
				SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Last Assessed Status Is NOT Displayed in the Employee Home Page");
				ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: Skill Last Assessed Status should be displayed", "The Actual Result is:" +LastAssessedStatus.isDisplayed(), "Fail");
			}
		}
		catch (Exception E)
		{
			ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: Skill Last Assessed Status should be displayed", "The Actual Result is: Exception" +E, "Fail");
		}
	}

	public static void SecondarySkillLastAssessedStatusCheck(WebDriver driver, String Browser, String TestCaseID, ExtentTest SmokeTest_test)
	{
		String Title = "Secondary Skill Last Assessed Status Validation";
		try
		{
			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(90));
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PageObjects.SecondarySkillNameXpath)));
			WebElement LastAssessedStatus = driver.findElement(By.cssSelector(PageObjects.SecondaryLastAssessedStatusCssSelector));

			if (LastAssessedStatus.isDisplayed())
			{
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Skill Last Assessed Status is Displayed in the Home Page");
				ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: Skill Last Assessed Status should be displayed", "The Actual Result is:" +LastAssessedStatus.isDisplayed(), "Pass");
			}
			else
			{
				SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Skill Last Assessed Status is NOT Displayed in the Home Page");
				ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: Skill Last Assessed Status should be displayed", "The Actual Result is:" +LastAssessedStatus.isDisplayed(), "Fail");
			}
		}
		catch (Exception E)
		{
			System.out.println(E);
			ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: Skill Last Assessed Status should be displayed", "The Actual Result is: Exception" +E, "Fail");
		}
	}

	public static void MettlPageAssessment(WebDriver driver, String Browser, String TestCaseID, ExtentTest SmokeTest_test)
	{
		String Title = "Mettl Assessment Page Validations";
		try
		{
			JavascriptExecutor executor = (JavascriptExecutor)driver;

			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(90));
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PageObjects.PrimaryInitiateButtonStatusXpath)));
			WebElement InitiateButton = driver.findElement(By.xpath(PageObjects.PrimaryInitiateButtonStatusXpath));

			if(InitiateButton.isDisplayed())
			{
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "INITIATE ASSESSMENT Button is Displayed In the Employee HomePage");
				ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: Initiate Assessment button should be displayed", "The Actual Result is:" +InitiateButton.isDisplayed(), "Pass");
				executor.executeScript("arguments[0].click();", InitiateButton);
			}

			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PageObjects.SamplePageInstructionXpath)));
			if (driver.findElements(By.xpath(PageObjects.IAcceptCheckBoxXpath)).size()!=0)
			{
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "I Accept CheckBox is Clicked By the Employee");
				WebElement AcceptCheckBox = driver.findElement(By.xpath(PageObjects.IAcceptCheckBoxXpath));
				executor.executeScript("arguments[0].click();", AcceptCheckBox);
				Thread.sleep(5000);
			}
			else
			{
				SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "I Accept CheckBox is NOT Clicked By the Employee");
			}

			if (driver.findElements(By.xpath(PageObjects.StartAssessmentBtnXpath)).size()!=0)
			{
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Start Assessment Button is Displayed in the Instructions Page");
				WebElement AssessmentStartButton = driver.findElement(By.xpath(PageObjects.StartAssessmentBtnXpath));
				ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: Start Assessment button should be displayed", "The Actual Result is:" +AssessmentStartButton.isDisplayed(), "Pass");
				//executor.executeScript("arguments[0].click();", AssessmentStartButton);
			}
			else
			{
				SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Start Assessment Button is NOT Displayed in the Instructions Page");
			}

			/*
			 * try { wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
			 * PageObjects.MettlPageStartNextBtnXpath))); } catch (Exception e) {}
			 * 
			 * if
			 * (driver.findElements(By.xpath(PageObjects.MettlPageStartNextBtnXpath)).size()
			 * != 0) { SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test,
			 * "Employee is Redirected to the Mettl Page to Take Sample Assessment");
			 * WebElement NextbtnMettl =
			 * driver.findElement(By.xpath(PageObjects.MettlPageStartNextBtnXpath));
			 * executor.executeScript("arguments[0].click();", NextbtnMettl); } else {
			 * SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test,
			 * "Employee is NOT Redirected to the Mettl Page to Take Sample Assessment"); }
			 */

		}
		catch(Exception E)
		{
			ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: Assessment Page should be displayed", "The Actual Result is: Exception" +E, "Fail");
		}
		driver.navigate().back();
	}

	public static void MettlSampleAssessment(WebDriver driver, String Browser, String TestCaseID, ExtentTest SmokeTest_test)
	{
		String Title = "Mettl Sample Assessment Page Validations";
		try
		{
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(90));
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PageObjects.TakeSampleAssessmentBtnXpath)));
			WebElement InitiateButton = driver.findElement(By.xpath(PageObjects.TakeSampleAssessmentBtnXpath));

			if(InitiateButton.isDisplayed())
			{
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Take Sample Assessment Button is Displayed In Employee Home Page");
				ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: Take Sample Assessment button should be displayed", "The Actual Result is:" +InitiateButton.isDisplayed(), "Pass");
				WebElement InitiateButton1 = driver.findElement(By.xpath(PageObjects.TakeSampleAssessmentBtnXpath));
				executor.executeScript("arguments[0].click();", InitiateButton1);
			}

			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PageObjects.SamplePageInstructionXpath)));
			if (driver.findElements(By.xpath(PageObjects.IAcceptCheckBoxXpath)).size()!=0)
			{
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "I Accept CheckBox is Clicked By the Employee");
				WebElement AcceptCheckBox = driver.findElement(By.xpath(PageObjects.IAcceptCheckBoxXpath));
				executor.executeScript("arguments[0].click();", AcceptCheckBox);
				Thread.sleep(5000);
			}
			else
			{
				SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "I Accept CheckBox is NOT Clicked By the Employee");
			}

			if (driver.findElements(By.xpath(PageObjects.StartAssessmentBtnXpath)).size()!=0)
			{
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Start Assessment Button is Displayed in the Instructions Page");
				WebElement AssessmentStartButton = driver.findElement(By.xpath(PageObjects.StartAssessmentBtnXpath));
				ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: Start Assessment button should be displayed", "The Actual Result is:" +AssessmentStartButton.isDisplayed(), "Pass");
				executor.executeScript("arguments[0].click();", AssessmentStartButton);
			}
			else
			{
				SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Start Assessment Button is NOT Displayed in the Instructions Page");
			}

			try
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PageObjects.MettlPageStartNextBtnXpath)));
			}
			catch (Exception e)
			{}

			ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: Assessment Main Page should be displayed", "The Actual Result is: Assessment Main Page is displayed" , "Pass");

			if (driver.findElements(By.xpath(PageObjects.MettlPageStartNextBtnXpath)).size() != 0)
			{
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Employee is Redirected to the Mettl Page to Take Sample Assessment");
				WebElement NextbtnMettl = driver.findElement(By.xpath(PageObjects.MettlPageStartNextBtnXpath));
				executor.executeScript("arguments[0].click();", NextbtnMettl);
			}
			else
			{
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Employee is NOT Redirected to the Mettl Page to Take Sample Assessment");
			}

			try
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PageObjects.MettlPageStartTestBtnXpath)));
			}
			catch (Exception e)
			{}

			if (driver.findElements(By.xpath(PageObjects.MettlPageStartTestBtnXpath)).size() != 0)
			{
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Start Test Button in Mettl Page to Take Sample Assessment");
				WebElement NextbtnMettl = driver.findElement(By.xpath(PageObjects.MettlPageStartTestBtnXpath));
				executor.executeScript("arguments[0].click();", NextbtnMettl);
			}
			else
			{
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Employee is NOT Redirected to the Mettl Page to Take Sample Assessment");
			}

			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PageObjects.MettlPageQuestionSectionXpath)));
			if (driver.findElements(By.xpath(PageObjects.MettlPageQ1Option1BtnXpath)).size()!=0)
			{
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Employee Successfully See the Quetions for Sample Assessment");
				WebElement Question1Optiona = driver.findElement(By.xpath(PageObjects.MettlPageQ1Option1BtnXpath));
				executor.executeScript("arguments[0].click();", Question1Optiona);
			}
			else
			{
				SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Employee NOT Successfully See the Quetions for Sample Assessment");
			}

			/*
			 * WebElement Question1Next =
			 * driver.findElement(By.xpath(PageObjects.MettlPageQuestion2BtnXpath));
			 * executor.executeScript("arguments[0].click();", Question1Next);
			 * 
			 * wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
			 * PageObjects.MettlPageQ2Option1BtnXpath))); WebElement Question2Optiona =
			 * driver.findElement(By.xpath(PageObjects.MettlPageQ2Option1BtnXpath));
			 * executor.executeScript("arguments[0].click();", Question2Optiona);
			 * 
			 * WebElement Question2Next =
			 * driver.findElement(By.xpath(PageObjects.MettlPageQuestion3BtnXpath));
			 * executor.executeScript("arguments[0].click();", Question2Next);
			 * 
			 * wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
			 * PageObjects.MettlPageQ31Option1BtnXpath))); WebElement Question3Optiona =
			 * driver.findElement(By.xpath(PageObjects.MettlPageQ31Option1BtnXpath));
			 * executor.executeScript("arguments[0].click();", Question3Optiona);
			 * 
			 * WebElement Question3Next =
			 * driver.findElement(By.xpath(PageObjects.MettlPageQuestion4BtnXpath));
			 * executor.executeScript("arguments[0].click();", Question3Next);
			 * 
			 * wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
			 * PageObjects.MettlPageQ4Option1BtnXpath))); WebElement Question4Optiona =
			 * driver.findElement(By.xpath(PageObjects.MettlPageQ4Option1BtnXpath));
			 * executor.executeScript("arguments[0].click();", Question4Optiona);
			 * 
			 * WebElement Question4Next =
			 * driver.findElement(By.xpath(PageObjects.MettlPageQuestion5BtnXpath));
			 * executor.executeScript("arguments[0].click();", Question4Next);
			 * 
			 * wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
			 * PageObjects.MettlPageQ5Option1BtnXpath))); WebElement Question5Optiona =
			 * driver.findElement(By.xpath(PageObjects.MettlPageQ5Option1BtnXpath));
			 * executor.executeScript("arguments[0].click();", Question5Optiona);
			 */
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PageObjects.MettlPageFinishTestButton)));
			WebElement FinishButton = driver.findElement(By.xpath(PageObjects.MettlPageFinishTestButton));
			executor.executeScript("arguments[0].click();", FinishButton);

			if (driver.findElements(By.cssSelector(PageObjects.MettlPageFinishBtnCss)).size()!=0)
			{
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Mettl Page Finish Assessment Button Is Displayed");
				WebElement FinishBtn = driver.findElement(By.cssSelector(PageObjects.MettlPageFinishBtnCss));
				executor.executeScript("arguments[0].click();", FinishBtn);
			}
			else
			{
				SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Mettl Page Finish Assessment Button Is NOT Displayed");
			}

			try
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PageObjects.ThankYouFeedBackXpath)));
			}
			catch (Exception e)
			{}

			if (driver.findElements(By.xpath(PageObjects.ThankYouFeedBackXpath)).size() != 0)
			{
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "FeedBack Section Is Displayed After Taking Sample Assessment");
			}
			else
			{
				SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "FeedBack Section Is NOT Displayed After Taking Sample Assessment");
			}

			WebElement HomePageButton = driver.findElement(By.cssSelector(PageObjects.HomePageLogoCssSelector));
			executor.executeScript("arguments[0].click();", HomePageButton);

			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PageObjects.PrimarySkillNameXpath)));
		}
		catch(Exception E)
		{
			ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: Assessment Page should be displayed", "The Actual Result is: Exception" +E, "Fail");
		}
	}

	public static void UploadPageNavigation(WebDriver driver, String Browser, String TestCaseID, ExtentTest SmokeTest_test)
	{
		String Title = "RSM Upload Validation";
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PageObjects.HamMenuButtonCssSelector)));
			WebElement element = driver.findElement(By.cssSelector(PageObjects.HamMenuButtonCssSelector));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", element);

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PageObjects.AdminMenuCssselector)));
			driver.findElement(By.cssSelector(PageObjects.AdminMenuUploadCssselector)).click();

			List<WebElement> SelectOptions = driver.findElements(By.cssSelector(PageObjects.UploadOptionsCss));
			int i =1;
			for (WebElement SelectOption : SelectOptions)
			{
				SmokeTest_GetExtentReports.PassTestWithoutScreenshot(driver, SmokeTest_test, "Upload Dropdown Option "+i+" : "+SelectOption.getText());
				i++;
			}

			if (i>=50)
			{
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "All the "+(i-1)+" Upload Options are Available for the Admin to Upload");
			}
			else
			{
				SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "All the Upload Options are NOT Available for the Admin to Upload");
			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(PageObjects.DropDownId)));
			Select DateDropdown = new Select(driver.findElement(By.id(PageObjects.DropDownId)));
			DateDropdown.selectByValue("6");
			driver.findElement(By.id(PageObjects.SearchButtonId)).click();
			Thread.sleep(2000);

		}

		catch(Exception E)
		{
			ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Page should navigate to respective Page", "Exception Ocurred: "+E, "Fail");
		}
		driver.findElement(By.cssSelector(PageObjects.OldHomePageLogoCssSelector)).click();
	}

	public static void HomePageValidation(WebDriver driver, String Browser, String TestCaseID, ExtentTest SmokeTest_test)
	{
		String Title = "HomePage Validation";
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PageObjects.HomePageCarouselCssSelector)));
			driver.findElement(By.cssSelector(PageObjects.HomePageCarouselCssSelector)).click();
			JavascriptExecutor executor = (JavascriptExecutor) driver;

			WebElement HomePageLogo1 = driver.findElement(By.cssSelector(PageObjects.HomePageLogoCssSelector));
			Actions action =  new Actions(driver);
			action.click(HomePageLogo1).build().perform();

			Thread.sleep(1000);
			String HomePageLogo = driver.findElement(By.cssSelector(PageObjects.HomePageLogoCssSelector)).getText();
			if (HomePageLogo.contains("Competency"))
			{
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "myCompetency Title is Displayed in the Home Page Header");
				ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: Competency", "The Actual Result is:" +HomePageLogo, "Pass");
			}
			else
			{
				SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "myCompetency Title is NOT Displayed in the Home Page Header");
				ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: Competency", "The Actual Result is:" +HomePageLogo, "Fail");
			}
			if (driver.findElements(By.xpath(PageObjects.SupervisorXpath)).size() != 0)
			{
				String SupervisorSection = driver.findElement(By.xpath(PageObjects.SupervisorXpath)).getText();
				String Name = SupervisorSection.substring(SupervisorSection.lastIndexOf(':')+1);
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Supervior Name Displayed for the Employee is "+Name.trim());
			}
			else
			{
				//SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Supervior Name is NOT Displayed for the Employee");
			}
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PageObjects.PrimarySkillSectionCss)));
			if (driver.findElements(By.cssSelector(PageObjects.PrimarySkillSectionCss)).size() != 0)
			{
				WebElement PrimarySection = driver.findElement(By.cssSelector(PageObjects.PrimarySkillSectionCss));
				executor.executeScript("arguments[0].scrollIntoView();", PrimarySection);
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Primary Skill Section Is Displayed For The Employee");
			}
			else
			{
				SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Primary Skill Section Is NOT Displayed For The Employee");
			}
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PageObjects.AddSecondarySkillCss)));
			if (driver.findElements(By.cssSelector(PageObjects.AddSecondarySkillCss)).size()!=0)
			{
				WebElement AddSecSkill = driver.findElement(By.cssSelector(PageObjects.AddSecondarySkillCss));
				executor.executeScript("arguments[0].scrollIntoView();", AddSecSkill);
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Add Secondary Skill Button is Displayed for the Employee");
			}
			else
			{
				SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Add Secondary Skill Button is NOT Displayed for the Employee");
			}
		}
		catch(Exception E)
		{
			ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Page should navigate to respective Page", "Exception Ocurred: "+E, "Fail");
			System.out.println(E);
		}
	}

	public static void FooterAndFeedBackValidation(WebDriver driver, String Browser, String TestCaseID, ExtentTest SmokeTest_test)
	{
		String Title = "Footer and Feedback Validation";
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PageObjects.HomePageCarouselCssSelector)));
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("window.scrollTo(0, document.body.scrollHeight)");

			if (driver.findElements(By.cssSelector(PageObjects.FooterCssSelector)).size()!=0)
			{
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Footer Section is Displayed in the myComp Website");
				if (driver.findElements(By.cssSelector(PageObjects.TechnicalIssueCssSelector)).size()!=0)
				{
					SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Technical Issue myCompetency Helpdesk Link is Displayed");
				}
				else
				{
					SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Technical Issue myCompetency Helpdesk Link is NOT Displayed");
				}

				if (driver.findElements(By.cssSelector(PageObjects.QueriesCssSelector)).size()!=0)
				{
					SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Got Queries Phone Number is Displayed");
				}
				else
				{
					SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Got Queries Phone Number is NOT Displayed");
				}

				List<WebElement> FooterLinks = driver.findElements(By.cssSelector(PageObjects.FooterLinkCssSelector));
				for (WebElement Footerlink : FooterLinks)
				{
					String Name = Footerlink.getText();
					SmokeTest_GetExtentReports.PassTestWithoutScreenshot(driver, SmokeTest_test, "Footer Links Displayed in the myCompetency Are : "+Name);
				}

				if (driver.findElements(By.cssSelector(PageObjects.myCompCopyRightsCssSelector)).size()!=0)
				{
					SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "myCompetency Copyrights is Displayed");
				}
				else
				{
					SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "myCompetency Copyrights is NOT Displayed");
				}

				if (driver.findElements(By.cssSelector(PageObjects.DipaHomePageCssSelector)).size()!=0)
				{
					SmokeTest_GetExtentReports.PassTestWithoutScreenshot(driver, SmokeTest_test, "Talk to DiPA is Displayed in myCompetency");
				}
				else
				{
					SmokeTest_GetExtentReports.FailTestWithoutScreenshot(driver, SmokeTest_test, "Talk to DiPA is NOT Displayed in myCompetency");
				}

			}
			else
			{
				SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Footer Section is NOT Displayed in the myComp Website");
			}

			if (driver.findElements(By.cssSelector(PageObjects.FeedbackHomeCssSelector)).size()!=0)
			{
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Feedback Button is Displayed on the HomePage");
				WebElement FeedbackBtn = driver.findElement(By.cssSelector(PageObjects.FeedbackHomeCssSelector));
				executor.executeScript("arguments[0].click();", FeedbackBtn);

				try
				{
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PageObjects.FeedbackPopUpCssSelector)));
				}
				catch (Exception e)
				{}

				if (driver.findElements(By.cssSelector(PageObjects.FeedbackPopUpCssSelector)).size()!=0)
				{
					SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Feedback Popup is Displayed On Clicking on the Button in HomePage");
					if (driver.findElements(By.cssSelector(PageObjects.FeedbackDropDownCssSelector)).size()!=0)
					{
						SmokeTest_GetExtentReports.PassTestWithoutScreenshot(driver, SmokeTest_test, "Feedback Popup Dropdown is Displayed");

						WebElement dropdown = driver.findElement(By.cssSelector(PageObjects.FeedbackDropDownCssSelector));

						Actions action = new Actions(driver);
						action.moveToElement(dropdown).click().build().perform();

						int i=1;
						List<WebElement> CommonFeedbackOptions = driver.findElements(By.cssSelector(PageObjects.FeedbackDropDownAllOptionCssSelector));

						for (WebElement EachOption : CommonFeedbackOptions)
						{
							SmokeTest_GetExtentReports.PassTestWithoutScreenshot(driver, SmokeTest_test, "Options Displayed inside the Feedback Popup Dropdown Are "+i+" : "+EachOption.getText());
							++i;
						}

						wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PageObjects.FeedbackDropDownFirstOptionCssSelector)));

						if (driver.findElements(By.cssSelector(PageObjects.FeedbackDropDownFirstOptionCssSelector)).size()!=0)
						{
							SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Feedback Popup Dropdown Options Are Displayed");
							WebElement dropdownoption1 = driver.findElement(By.cssSelector(PageObjects.FeedbackDropDownFirstOptionCssSelector));
							executor.executeScript("arguments[0].click();", dropdownoption1);

							if (driver.findElements(By.cssSelector(PageObjects.FeedbackCloseBtnCssSelector)).size()!=0)
							{
								SmokeTest_GetExtentReports.PassTestWithoutScreenshot(driver, SmokeTest_test, "Feedback Popup Close Button is Displayed");
							}
							else
							{
								SmokeTest_GetExtentReports.FailTestWithoutScreenshot(driver, SmokeTest_test, "Feedback Popup Close Button is NOT Displayed");
							}

							wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PageObjects.FeedbackEmojiCssSelector)));
							if (driver.findElements(By.cssSelector(PageObjects.FeedbackEmojiCssSelector)).size()!=0)
							{
								SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Feedback Emoji is Displayed After Selecting an Option");
								if (driver.findElements(By.cssSelector(PageObjects.FeedbackHappyEmojiCssSelector)).size()!=0)
								{
									WebElement HappyEmoji = driver.findElement(By.cssSelector(PageObjects.FeedbackHappyEmojiCssSelector));
									executor.executeScript("arguments[0].click();", HappyEmoji);
									try
									{
										wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PageObjects.FeedbackSubmitCssSelector)));
									}
									catch (Exception e)
									{}

									if (driver.findElements(By.cssSelector(PageObjects.FeedbackSubmitCssSelector)).size()!=0)
									{
										SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Feedback Popup Submit Button is Displayed");
										WebElement SubmitBtn = driver.findElement(By.cssSelector(PageObjects.FeedbackSubmitCssSelector));
										executor.executeScript("arguments[0].click();", SubmitBtn);

										wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PageObjects.FeedbackAlertCssSelector)));
										if (driver.findElements(By.cssSelector(PageObjects.FeedbackAlertCssSelector)).size()!=0)
										{
											SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Feedback PopUp Submit Alert Popup is Displayed");
											WebElement AlertOkBtn = driver.findElement(By.cssSelector(PageObjects.FeedbackAlertOkCssSelector));
											executor.executeScript("arguments[0].click();", AlertOkBtn);
										}
										else 
										{
											SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Feedback PopUp Submit Alert Popup is NOT Displayed");
										}
									}
									else
									{
										if (driver.findElements(By.cssSelector(PageObjects.FeedbackSubmitStageCssSelector)).size()!=0)
										{
											WebElement StageBtn = driver.findElement(By.cssSelector(PageObjects.FeedbackSubmitStageCssSelector));
											executor.executeScript("arguments[0].click();", StageBtn);
										}
										SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Feedback Popup Submit Button is NOT Displayed");
									}
								}
								else
								{
									SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Feedback Happy Emoji is Displayed Feedback PopUp");
								}
							}
							else
							{
								SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Feedback Emoji is NOT Displayed After Selecting an Option");
							}
						}
						else
						{
							SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Feedback Popup Dropdown Options Are NOT Displayed");
						}


					}
					else
					{
						SmokeTest_GetExtentReports.FailTestWithoutScreenshot(driver, SmokeTest_test, "Feedback Popup Dropdown is NOT Displayed");
					}
				}
				else
				{
					SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Feedback Popup is NOT Displayed On Clicking on the Button in HomePage");
				}

			}
			else
			{
				SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Feedback Button is NOT Displayed on the HomePage");
			}
			driver.navigate().refresh();
		}
		catch(Exception E)
		{
			ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Page should navigate to respective Page", "Exception Ocurred: "+E, "Fail");
			System.out.println(E);
		}
	}


	public static void FooterLinksValidation(WebDriver driver, String Browser, String TestCaseID, ExtentTest SmokeTest_test)
	{
		String Title = "Footer Link Validation";
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PageObjects.HomePageCarouselCssSelector)));
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("window.scrollTo(0, document.body.scrollHeight)");

			if (driver.findElements(By.cssSelector(PageObjects.FooterCssSelector)).size()!=0)
			{
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Footer Section is Displayed in the myComp Website");
				if (driver.findElements(By.cssSelector(PageObjects.TechnicalIssueCssSelector)).size()!=0)
				{
					if (driver.findElements(By.xpath(PageObjects.TechnicalIssueXpathLink)).size()!=0)
					{
						String LinkAddress = driver.findElement(By.xpath(PageObjects.TechnicalIssueXpathLink)).getAttribute("href");
						if (LinkAddress.contains("https://support.accenture.com"))
						{
							SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Support Link from myCompetency Helpdesk is Displayed Correctly");
						}
						else
						{
							SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Support Link from myCompetency Helpdesk is NOT Displayed Correctly");
						}
					}
				}
				else
				{
					SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Technical Issue myCompetency Helpdesk Link is NOT Displayed");
				}

				List<WebElement> FooterLinks = driver.findElements(By.cssSelector(PageObjects.FooterLinkCssSelector));
				for (WebElement Footerlink : FooterLinks)
				{
					String Name = Footerlink.getText();
					SmokeTest_GetExtentReports.PassTestWithoutScreenshot(driver, SmokeTest_test, "Footer Links Displayed in the myCompetency Are : "+Name);
					executor.executeScript("arguments[0].click();", Footerlink);

					int SiteMap = driver.findElements(By.xpath(PageObjects.SiteMapPageTitle)).size();
					int TermsandData = driver.findElements(By.xpath(PageObjects.TermOfUseCloseXpath)).size();

					if (SiteMap!=0 || TermsandData!=0)
					{
						SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Employee Is Navigated Successfully Post Clicking the Footer");
					}
					else
					{
						SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Employee Is NOT Navigated Successfully Post Clicking the Footer");
					}

					if (TermsandData!=0)
					{
						WebElement CloseBtn = driver.findElement(By.xpath(PageObjects.TermOfUseCloseXpath));
						executor.executeScript("arguments[0].click();", CloseBtn);
					}

					if (SiteMap!=0)
					{
						driver.navigate().back();
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PageObjects.HomePageCarouselCssSelector)));
					}
					executor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
				}
			}
			else
			{
				SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Footer Section is NOT Displayed in the myComp Website");
			}


			driver.navigate().refresh();
		}
		catch(Exception E)
		{
			ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Page should navigate to respective Page", "Exception Ocurred: "+E, "Fail");
			System.out.println(E);
		}
	}

	public static void AdminMenuAvailabiltyValidation(WebDriver driver, String Browser, String TestCaseID, ExtentTest SmokeTest_test)
	{
		String Title = "Admin Menu Availability Validation";
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));
			JavascriptExecutor executor = (JavascriptExecutor)driver;

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PageObjects.SkillHistorymenuCssSelector)));
			WebElement SkillHistoryMenu = driver.findElement(By.cssSelector(PageObjects.SkillHistorymenuCssSelector));
			WebElement HowItWorksMenu = driver.findElement(By.cssSelector(PageObjects.LearnAboutMyCompetencyButtonCssSelector));
			if(SkillHistoryMenu.isDisplayed())
			{
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Skill History Button is Displayed for the Admin");
				ExcelObj.WriteExcel(TestCaseID, Browser, Title, "Skill History Menu should be displayed", "Skill History Menu is displayed: "+SkillHistoryMenu.isDisplayed(), "Pass");
			}
			if(HowItWorksMenu.isDisplayed())
			{
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "About Button is Displayed for the Admin");
				ExcelObj.WriteExcel(TestCaseID, Browser, Title, "About Menu should be displayed", "About Menu is displayed: "+HowItWorksMenu.isDisplayed(), "Pass");
			}
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PageObjects.HamMenuButtonCssSelector)));
			WebElement element = driver.findElement(By.cssSelector(PageObjects.HamMenuButtonCssSelector));
			executor.executeScript("arguments[0].click();", element);

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PageObjects.MainMenuSectionCssselector)));
			WebElement MenuSection = driver.findElement(By.cssSelector(PageObjects.MainMenuSectionCssselector));
			List<WebElement> AdminMenu = driver.findElements(By.cssSelector(PageObjects.MainMenuListCssselector));
			if(MenuSection.isDisplayed())
			{
				ExcelObj.WriteExcel(TestCaseID, Browser, Title, "Menu List should be displayed", "Menu List is displayed", "Pass");
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Menu List is Displayed for the Admin");
				for(int i=1; i<=AdminMenu.size(); i++)
				{
					String MenuName = AdminMenu.get(i-1).getText();
					SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Admin Menu Options Displayed "+i+" : "+MenuName);
					ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Menu Items should be displayed", "Menu Items are displayed: "+MenuName, "Pass");
				}
			}
			else
			{
				SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Menu List is NOT Displayed for the Admin");
				ExcelObj.WriteExcel(TestCaseID, Browser, Title, "Menu List should be displayed", "Menu List is not displayed", "Fail");
			}
			WebElement element1 = driver.findElement(By.cssSelector(PageObjects.HamMenuButtonCssSelector));
			executor.executeScript("arguments[0].click();", element1);
		}
		catch(Exception E)
		{
			ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Page should navigate to respective Page", "Exception Ocurred: "+E, "Fail");
		}
	}

	public static void SelfServiceReportDownloadValidations(WebDriver driver, String Browser, String TestCaseID, ExtentTest SmokeTest_test, String ReportName)
	{
		String Title = "Self Service Report Download Validation";
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));
			JavascriptExecutor executor = (JavascriptExecutor)driver;

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PageObjects.HamMenuButtonCssSelector)));
			WebElement element = driver.findElement(By.cssSelector(PageObjects.HamMenuButtonCssSelector));
			executor.executeScript("arguments[0].click();", element);

			try
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PageObjects.SelfServiceReportOptionXpath)));
			}
			catch (Exception e)
			{}

			if (driver.findElements(By.xpath(PageObjects.SelfServiceReportOptionXpath)).size()!=0)
			{
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Self Service Report Admin Option is Available for the Current Login");
				WebElement SSButton = driver.findElement(By.xpath(PageObjects.SelfServiceReportOptionXpath));
				executor.executeScript("arguments[0].click();", SSButton);

				Thread.sleep(10000);
				try
				{
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PageObjects.ReportDownloadXpath)));
				}
				catch (Exception e)
				{}

				if (driver.findElements(By.xpath(PageObjects.ReportDownloadXpath)).size()!=0)
				{
					SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Report Download Option is Displayed Inside The Self Service Options");
					WebElement ReportDownloadBtn = driver.findElement(By.xpath(PageObjects.ReportDownloadXpath));
					executor.executeScript("arguments[0].click();", ReportDownloadBtn);

					try
					{
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PageObjects.SelfSeriveResultsXpath)));
					}
					catch (Exception e)
					{}

					if (driver.findElements(By.xpath(PageObjects.SelfSeriveResultsXpath)).size()!=0)
					{
						SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Self Service Report is Displayed Inside Report Download Page");
					}
					else
					{
						SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Self Service Report is NOT Displayed Inside Report Download Page");
					}

					if (driver.findElements(By.xpath(PageObjects.ExecuteButtonXpath)).size()!=0)
					{
						SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Execute Button is Displayed Inside Report Download Page");
					}
					else
					{
						SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Execute Button is NOT Displayed Inside Report Download Page");
					}

					if (driver.findElements(By.xpath(PageObjects.RefreshButtonXpath)).size()!=0)
					{
						SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Refresh Button is Displayed Inside Report Download Page");
					}
					else
					{
						SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Refresh Button is NOT Displayed Inside Report Download Page");
					}

					if (driver.findElements(By.cssSelector(PageObjects.SearchBoxDropdownCss)).size()!=0)
					{
						SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Seach Dropdown is Displayed Inside Report Download Page");
					}
					else
					{
						SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Seach Dropdown is NOT Displayed Inside Report Download Page");
					}

					WebElement SeachDropBtn = driver.findElement(By.cssSelector(PageObjects.SearchBoxDropdownCss));
					executor.executeScript("arguments[0].click();", SeachDropBtn);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PageObjects.SelfSeriveDropDownOptionsXpath)));

					List<WebElement> DropdownReports = driver.findElements(By.xpath(PageObjects.SelfSeriveDropDownOptionsXpath));

					int i = 0;
					for (i = 1; i <= DropdownReports.size(); i++)
					{
						SmokeTest_GetExtentReports.PassTestWithoutScreenshot(driver, SmokeTest_test, "Report Number "+i+" is "+DropdownReports.get(i-1).getText());
					}

					if (i == 35)
					{
						SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "All The Reports are Displayed in the Dropdown Box");
					}

					WebElement SeachTextBox = driver.findElement(By.xpath(PageObjects.SelfSeriveSearchBoxXpath));
					SeachTextBox.sendKeys(ReportName);

					WebElement FirstOption = driver.findElement(By.xpath(PageObjects.SelfSeriveDropdownFirstOptionXpath));
					executor.executeScript("arguments[0].click();", FirstOption);

					WebElement target = driver.findElement(By.xpath(PageObjects.ExecuteButtonXpath));
					Actions action = new Actions(driver);
					action.moveToElement(target).build().perform();

					WebElement Execute = driver.findElement(By.xpath(PageObjects.ExecuteButtonXpath));
					executor.executeScript("arguments[0].click();", Execute);

					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PageObjects.SelfSeriveResultsXpath)));

					Thread.sleep(10000);

					WebElement RefreshBtnA = driver.findElement(By.xpath(PageObjects.RefreshButtonXpath));
					executor.executeScript("arguments[0].click();", RefreshBtnA);

					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PageObjects.SelfSeriveResultsXpath)));

					WebElement RefreshBtnB = driver.findElement(By.xpath(PageObjects.RefreshButtonXpath));
					executor.executeScript("arguments[0].click();", RefreshBtnB);

					try
					{
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PageObjects.SelfSeriveResultsFirstRowReportDownloadXpath)));
					}
					catch (Exception e)
					{
						WebElement RefreshBtn = driver.findElement(By.xpath(PageObjects.RefreshButtonXpath));
						executor.executeScript("arguments[0].click();", RefreshBtn);
					}

					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PageObjects.SelfSeriveResultsXpath)));

					if (driver.findElements(By.xpath(PageObjects.SelfSeriveResultsFirstRowReportDownloadXpath)).size()!=0)
					{
						SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Report Is Generated Successfully");
						WebElement ReportStatus = driver.findElement(By.xpath(PageObjects.SelfSeriveResultsFirstRowRunStatusXpath));
						String Status = ReportStatus.getText();
						if (Status.equals("OK"))
						{
							SmokeTest_GetExtentReports.PassTestWithoutScreenshot(driver, SmokeTest_test, "Report Status Post Execution is "+Status);
						}
						else
						{
							SmokeTest_GetExtentReports.FailTestWithoutScreenshot(driver, SmokeTest_test, "Report Status Post Execution is "+Status);
						}

						if (driver.findElements(By.xpath(PageObjects.SelfSeriveResultsFirstRowReportDateXpath)).size()!=0)
						{
							String ReportRunDate = driver.findElement(By.xpath(PageObjects.SelfSeriveResultsFirstRowReportDateXpath)).getText();
							SmokeTest_GetExtentReports.PassTestWithoutScreenshot(driver, SmokeTest_test, "Report Last Run Date is "+ReportRunDate+" Displayed in the SS Download Page");
						}
						else
						{
							SmokeTest_GetExtentReports.FailTestWithoutScreenshot(driver, SmokeTest_test, "Report Last Run Date is NOT Displayed in the SS Download Page");
						}

						if (driver.findElements(By.xpath(PageObjects.SelfSeriveResultsFirstRowReportRunByXpath)).size()!=0)
						{
							String ReportRunBy = driver.findElement(By.xpath(PageObjects.SelfSeriveResultsFirstRowReportRunByXpath)).getText();
							SmokeTest_GetExtentReports.PassTestWithoutScreenshot(driver, SmokeTest_test, "Report Last Run By is "+ReportRunBy+" Displayed in the SS Download Page");
						}
						else
						{
							SmokeTest_GetExtentReports.FailTestWithoutScreenshot(driver, SmokeTest_test, "Report Last Run By is NOT Displayed in the SS Download Page");
						}

						WebElement DownloadOptionClick = driver.findElement(By.xpath(PageObjects.SelfSeriveResultsFirstRowReportDownloadXpath));
						executor.executeScript("arguments[0].click();", DownloadOptionClick);
					}
					else
					{
						WebElement RefreshBtn1 = driver.findElement(By.xpath(PageObjects.RefreshButtonXpath));
						executor.executeScript("arguments[0].click();", RefreshBtn1);
						try
						{
							wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PageObjects.SelfSeriveResultsFirstRowReportDownloadXpath)));
						}
						catch (Exception e)
						{
							WebElement RefreshBtn = driver.findElement(By.xpath(PageObjects.RefreshButtonXpath));
							executor.executeScript("arguments[0].click();", RefreshBtn);
						}

						if (driver.findElements(By.xpath(PageObjects.SelfSeriveResultsFirstRowReportDownloadXpath)).size()!=0)
						{
							SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Report Is Generated Successfully");
							WebElement ReportStatus = driver.findElement(By.xpath(PageObjects.SelfSeriveResultsFirstRowRunStatusXpath));
							String Status = ReportStatus.getText();
							if (Status.equals("OK"))
							{
								SmokeTest_GetExtentReports.PassTestWithoutScreenshot(driver, SmokeTest_test, "Report Status Post Execution is "+Status);
							}
							else
							{
								SmokeTest_GetExtentReports.FailTestWithoutScreenshot(driver, SmokeTest_test, "Report Status Post Execution is "+Status);
							}

							if (driver.findElements(By.xpath(PageObjects.SelfSeriveResultsFirstRowReportDateXpath)).size()!=0)
							{
								String ReportRunDate = driver.findElement(By.xpath(PageObjects.SelfSeriveResultsFirstRowReportDateXpath)).getText();
								SmokeTest_GetExtentReports.PassTestWithoutScreenshot(driver, SmokeTest_test, "Report Last Run Date is "+ReportRunDate+" Displayed in the SS Download Page");
							}
							else
							{
								SmokeTest_GetExtentReports.FailTestWithoutScreenshot(driver, SmokeTest_test, "Report Last Run Date is NOT Displayed in the SS Download Page");
							}

							if (driver.findElements(By.xpath(PageObjects.SelfSeriveResultsFirstRowReportRunByXpath)).size()!=0)
							{
								String ReportRunBy = driver.findElement(By.xpath(PageObjects.SelfSeriveResultsFirstRowReportRunByXpath)).getText();
								SmokeTest_GetExtentReports.PassTestWithoutScreenshot(driver, SmokeTest_test, "Report Last Run By is "+ReportRunBy+" Displayed in the SS Download Page");
							}
							else
							{
								SmokeTest_GetExtentReports.FailTestWithoutScreenshot(driver, SmokeTest_test, "Report Last Run By is NOT Displayed in the SS Download Page");
							}

							WebElement DownloadOptionClick = driver.findElement(By.xpath(PageObjects.SelfSeriveResultsFirstRowReportDownloadXpath));
							executor.executeScript("arguments[0].click();", DownloadOptionClick);
						}
					}

					if (driver.findElements(By.xpath(PageObjects.SelfSeriveResultsFirstRowReportDownloadXpath)).size()!=0)
					{
						SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, ReportName+" is generated Successfully after Executing");
					}
					else 
					{
						SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, ReportName+" is NOT generated after Executing");
					}

				}
				else
				{
					SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Report Download Option is NOT Displayed Inside The Self Service Options");
				}
			}
			else
			{
				SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Self Service Report Admin Option is NOT Available for the Current Login");
			}
		}
		catch(Exception E)
		{
			ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Page should navigate to respective Page", "Exception Ocurred: "+E, "Fail");
		}
	}


	public static void SelfServiceReportDownloadAnotherReport(WebDriver driver, String Browser, String TestCaseID, ExtentTest SmokeTest_test, String ReportName)
	{
		String Title = "Self Service Report Download Validation";
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));
			JavascriptExecutor executor = (JavascriptExecutor)driver;

			try
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PageObjects.SearchBoxDropdownCss)));
			}
			catch (Exception e)
			{}

			WebElement SeachDropBtn = driver.findElement(By.cssSelector(PageObjects.SearchBoxDropdownCss));
			executor.executeScript("arguments[0].click();", SeachDropBtn);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PageObjects.SelfSeriveDropDownOptionsXpath)));

			WebElement SeachTextBox = driver.findElement(By.xpath(PageObjects.SelfSeriveSearchBoxXpath));
			SeachTextBox.clear();
			SeachTextBox.sendKeys(ReportName);

			WebElement FirstOption = driver.findElement(By.xpath(PageObjects.SelfSeriveDropdownFirstOptionXpath));
			executor.executeScript("arguments[0].click();", FirstOption);

			WebElement target = driver.findElement(By.xpath(PageObjects.ExecuteButtonXpath));
			Actions action = new Actions(driver);
			action.moveToElement(target).build().perform();

			WebElement Execute = driver.findElement(By.xpath(PageObjects.ExecuteButtonXpath));
			executor.executeScript("arguments[0].click();", Execute);

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PageObjects.SelfSeriveResultsXpath)));

			Thread.sleep(20000);

			WebElement RefreshBtn4 = driver.findElement(By.xpath(PageObjects.RefreshButtonXpath));
			executor.executeScript("arguments[0].click();", RefreshBtn4);

			try
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PageObjects.SelfSeriveResultsFirstRowReportDownloadXpath)));
			}
			catch (Exception e)
			{
				WebElement RefreshBtn = driver.findElement(By.xpath(PageObjects.RefreshButtonXpath));
				executor.executeScript("arguments[0].click();", RefreshBtn);
			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PageObjects.SelfSeriveResultsXpath)));

			if (driver.findElements(By.xpath(PageObjects.SelfSeriveResultsFirstRowReportDownloadXpath)).size()!=0)
			{
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Report Is Generated Successfully");
				WebElement ReportStatus = driver.findElement(By.xpath(PageObjects.SelfSeriveResultsFirstRowRunStatusXpath));
				String Status = ReportStatus.getText();
				if (Status.equals("OK"))
				{
					SmokeTest_GetExtentReports.PassTestWithoutScreenshot(driver, SmokeTest_test, "Report Status Post Execution is "+Status);
				}
				else
				{
					SmokeTest_GetExtentReports.FailTestWithoutScreenshot(driver, SmokeTest_test, "Report Status Post Execution is "+Status);
				}

				if (driver.findElements(By.xpath(PageObjects.SelfSeriveResultsFirstRowReportDateXpath)).size()!=0)
				{
					String ReportRunDate = driver.findElement(By.xpath(PageObjects.SelfSeriveResultsFirstRowReportDateXpath)).getText();
					SmokeTest_GetExtentReports.PassTestWithoutScreenshot(driver, SmokeTest_test, "Report Last Run Date is "+ReportRunDate+" Displayed in the SS Download Page");
				}
				else
				{
					SmokeTest_GetExtentReports.FailTestWithoutScreenshot(driver, SmokeTest_test, "Report Last Run Date is NOT Displayed in the SS Download Page");
				}

				if (driver.findElements(By.xpath(PageObjects.SelfSeriveResultsFirstRowReportRunByXpath)).size()!=0)
				{
					String ReportRunBy = driver.findElement(By.xpath(PageObjects.SelfSeriveResultsFirstRowReportRunByXpath)).getText();
					SmokeTest_GetExtentReports.PassTestWithoutScreenshot(driver, SmokeTest_test, "Report Last Run By is "+ReportRunBy+" Displayed in the SS Download Page");
				}
				else
				{
					SmokeTest_GetExtentReports.FailTestWithoutScreenshot(driver, SmokeTest_test, "Report Last Run By is NOT Displayed in the SS Download Page");
				}

				Thread.sleep(7000);
				WebElement DownloadOptionClick = driver.findElement(By.xpath(PageObjects.SelfSeriveResultsFirstRowReportDownloadXpath));
				executor.executeScript("arguments[0].click();", DownloadOptionClick);
				Thread.sleep(7000);
			}
			else
			{
				WebElement RefreshBtn1 = driver.findElement(By.xpath(PageObjects.RefreshButtonXpath));
				executor.executeScript("arguments[0].click();", RefreshBtn1);
				try
				{
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PageObjects.SelfSeriveResultsFirstRowReportDownloadXpath)));
				}
				catch (Exception e)
				{
					WebElement RefreshBtn = driver.findElement(By.xpath(PageObjects.RefreshButtonXpath));
					executor.executeScript("arguments[0].click();", RefreshBtn);
				}

				if (driver.findElements(By.xpath(PageObjects.SelfSeriveResultsFirstRowReportDownloadXpath)).size()!=0)
				{
					SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Report Is Generated Successfully");
					WebElement ReportStatus = driver.findElement(By.xpath(PageObjects.SelfSeriveResultsFirstRowRunStatusXpath));
					String Status = ReportStatus.getText();
					if (Status.equals("OK"))
					{
						SmokeTest_GetExtentReports.PassTestWithoutScreenshot(driver, SmokeTest_test, "Report Status Post Execution is "+Status);
					}
					else
					{
						SmokeTest_GetExtentReports.FailTestWithoutScreenshot(driver, SmokeTest_test, "Report Status Post Execution is "+Status);
					}

					if (driver.findElements(By.xpath(PageObjects.SelfSeriveResultsFirstRowReportDateXpath)).size()!=0)
					{
						String ReportRunDate = driver.findElement(By.xpath(PageObjects.SelfSeriveResultsFirstRowReportDateXpath)).getText();
						SmokeTest_GetExtentReports.PassTestWithoutScreenshot(driver, SmokeTest_test, "Report Last Run Date is "+ReportRunDate+" Displayed in the SS Download Page");
					}
					else
					{
						SmokeTest_GetExtentReports.FailTestWithoutScreenshot(driver, SmokeTest_test, "Report Last Run Date is NOT Displayed in the SS Download Page");
					}

					if (driver.findElements(By.xpath(PageObjects.SelfSeriveResultsFirstRowReportRunByXpath)).size()!=0)
					{
						String ReportRunBy = driver.findElement(By.xpath(PageObjects.SelfSeriveResultsFirstRowReportRunByXpath)).getText();
						SmokeTest_GetExtentReports.PassTestWithoutScreenshot(driver, SmokeTest_test, "Report Last Run By is "+ReportRunBy+" Displayed in the SS Download Page");
					}
					else
					{
						SmokeTest_GetExtentReports.FailTestWithoutScreenshot(driver, SmokeTest_test, "Report Last Run By is NOT Displayed in the SS Download Page");
					}

					Thread.sleep(7000);
					WebElement DownloadOptionClick = driver.findElement(By.xpath(PageObjects.SelfSeriveResultsFirstRowReportDownloadXpath));
					executor.executeScript("arguments[0].click();", DownloadOptionClick);
					Thread.sleep(7000);
				}
			}

			if (driver.findElements(By.xpath(PageObjects.SelfSeriveResultsFirstRowReportDownloadXpath)).size()!=0)
			{
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, ReportName+" is generated Successfully after Executing");
			}
			else 
			{
				SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, ReportName+" is NOT generated after Executing");
			}

		}
		catch(Exception E)
		{
			ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Page should navigate to respective Page", "Exception Ocurred: "+E, "Fail");
			System.out.println(E);
		}
	}


	public static void AdminMenuValidation(WebDriver driver, String Browser, String TestCaseID, ExtentTest SmokeTest_test)
	{
		String Title = "Admin Menu Validation";
		try
		{
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PageObjects.HamMenuButtonCssSelector)));

			WebElement element = driver.findElement(By.cssSelector(PageObjects.HamMenuButtonCssSelector));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", element);

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PageObjects.MainMenuListCssselector)));
			List<WebElement> AdminMenu = driver.findElements(By.cssSelector(PageObjects.MainMenuListCssselector));

			for(int i=1; i<=AdminMenu.size(); i++)
			{
				try
				{
					AdminMenu = driver.findElements(By.cssSelector(PageObjects.MainMenuListCssselector));
					Thread.sleep(3000);
					String MenuName = AdminMenu.get(i-1).getText();
					if(MenuName.contains("Log Out")||MenuName.contains("Home")||MenuName.contains("Other Resources"))
					{
						continue;
					}

					AdminMenu.get(i-1).click();
					Thread.sleep(4000);
					try
					{
						driver.switchTo().alert().accept(); 
					}
					catch(Exception E)
					{}

					if (driver.findElements(By.cssSelector(PageObjects.SkillApprovalPageCloseBtnCssselector)).size()!=0)
					{
						WebElement CloseBtn = driver.findElement(By.cssSelector(PageObjects.SkillApprovalPageCloseBtnCssselector));
						executor.executeScript("arguments[0].click();", CloseBtn);
					}

					if(driver.findElements(By.cssSelector(PageObjects.CertiPopupCssselector)).size() != 0)
					{
						WebElement CloseBtn = driver.findElement(By.cssSelector(PageObjects.CertiPopupCloseBtnCssselector));
						Thread.sleep(4000);
						Actions actions = new Actions(driver);
						actions.moveToElement(CloseBtn).click(CloseBtn).build().perform();
						Thread.sleep(4000);
					}

					if(driver.findElements(By.cssSelector(PageObjects.HomePageLogoCssSelector)).size() != 0) 
					{
						String PageTitle = driver.getTitle();

						if(PageTitle!="Error")
						{
							SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Admin has successfully clicked "+MenuName+" and navigated successfully to the Page "+driver.getTitle());
							ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Page should navigate to: "+MenuName, "Navigated to: "+driver.getTitle(), "Pass");
						}
						else
						{
							SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Admin is NOT navigated successfully to the Page "+driver.getTitle());
							ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Page should navigate to: "+MenuName, "Navigated to: "+driver.getTitle(), "Fail");
						}
					}
					else if(driver.findElements(By.cssSelector(PageObjects.OldHomePageLogoCssSelector)).size() != 0)
					{
						String PageTitle = driver.getTitle();

						if(PageTitle!="Error")
						{
							SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Admin has successfully clicked "+MenuName+" and navigated successfully to the Page "+driver.getTitle());
							ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Page should navigate to: "+MenuName, "Navigated to: "+driver.getTitle(), "Pass");
						}
						else
						{
							SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Admin is NOT navigated successfully to the Page "+driver.getTitle());
							ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Page should navigate to: "+MenuName, "Navigated to: "+driver.getTitle(), "Fail");
						}
					}
					else if(driver.findElements(By.cssSelector(PageObjects.HomePageLogoCssInSSReportPage)).size() != 0)
					{
						String PageTitle = driver.getTitle();

						if(PageTitle!="Error")
						{
							SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Admin has successfully clicked "+MenuName+" and navigated successfully to the Page "+driver.getTitle());
							ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Page should navigate to: "+MenuName, "Navigated to: "+driver.getTitle(), "Pass");
						}
						else
						{
							SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Admin is NOT navigated successfully to the Page "+driver.getTitle());
							ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Page should navigate to: "+MenuName, "Navigated to: "+driver.getTitle(), "Fail");
						}
					}
					else
					{
						SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Admin is NOT navigated successfully to the Page "+driver.getTitle());
						ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Page should navigate to: "+MenuName, "Navigated to: "+driver.getTitle(), "Fail");
					}

					if(driver.findElements(By.xpath(PageObjects.CloseButtonXpath)).size() != 0)
					{
						Thread.sleep(4000);
						WebElement CloseBtn = driver.findElement(By.xpath(PageObjects.CloseButtonXpath));
						executor.executeScript("arguments[0].click();", CloseBtn);
						Thread.sleep(4000);
					}


					driver.navigate().back();
					Thread.sleep(3500);
					if (driver.findElements(By.cssSelector(PageObjects.HamMenuButtonCssSelector)).size() == 0)
					{
						DriverSetup.SiteNavigation();
						driver.navigate().refresh();
					}
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PageObjects.HamMenuButtonCssSelector)));

					WebElement element1 = driver.findElement(By.cssSelector(PageObjects.HamMenuButtonCssSelector));
					executor.executeScript("arguments[0].click();", element1);
				}
				catch (Exception e)
				{
					System.out.println(e.getMessage());
					SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, e.getMessage());
				}
			}
			driver.navigate().refresh();
		}
		catch(Exception E)
		{
			System.out.println(E);
			SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, E.getMessage());
			ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Page should navigate to respective Page", "Exception Ocurred: "+E, "Fail");
		}
	}

	public static void AssessmentsettingspageValidation(WebDriver driver, String Browser, String TestCaseID, ExtentTest SmokeTest_test)
	{
		String Title = "Assessment Settings Page Validation";
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PageObjects.HamMenuButtonCssSelector)));
			WebElement element = driver.findElement(By.cssSelector(PageObjects.HamMenuButtonCssSelector));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", element);

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PageObjects.AdminMenuCssselector)));
			driver.findElement(By.cssSelector(PageObjects.AssessmentSettingsMenuCssselector)).click();

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PageObjects.AssessmentPageTitleCssSelector)));
			String PageTitle = driver.findElement(By.cssSelector(PageObjects.AssessmentPageTitleCssSelector)).getText();

			if(PageTitle.contains("Assessment Settings"))
			{
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Admin Navigated to the Assessment Settings Page Successfully");
				ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: Page Tile should be displayed", "The Actual Result is:" +PageTitle, "Pass");
			}
			else
			{
				SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Admin is NOT Navigated to the Assessment Settings Page Successfully");
				ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: Page Tile should be displayed", "The Actual Result is:" +PageTitle, "Fail");
			}


			if(driver.findElement(By.cssSelector(PageObjects.AssessmentPageMainTableCssSelector)).isDisplayed())
			{
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Admin Navigated to the Assessment Settings Page Successfully");
				ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: Main Table should be displayed", "The Actual Result is: Main Table is displayed", "Pass");
			}

			if(driver.findElement(By.cssSelector(PageObjects.AssessmentPageAccordionCssSelector)).isDisplayed())
			{
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Admin Navigated to the Assessment Settings Page Successfully");
				ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: Accordion should be displayed", "The Actual Result is: Accordion is displayed", "Pass");
			}

			if(driver.findElement(By.cssSelector(PageObjects.AssessmentPageUpdateButtonCssSelector)).isDisplayed())
			{
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Update Button is displayed in Assessment Settings Page Successfully");
				ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: Update Button should be displayed", "The Actual Result is: Update Button is displayed", "Pass");
			}

			if(driver.findElement(By.cssSelector(PageObjects.AssessmentPageResetButtonCssSelector)).isDisplayed())
			{
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Reset Button is displayed in Assessment Settings Page Successfully");
				ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: Reset Button should be displayed", "The Actual Result is: Reset Button is displayed", "Pass");
			}

			int i = 1;
			List<WebElement> AssessmentSettingsTitles = driver.findElements(By.xpath(PageObjects.AssessmentSettingsPageOptionsXpath));
			for (WebElement AssessmentSettingsTitle : AssessmentSettingsTitles)
			{
				if (!AssessmentSettingsTitle.getText().equals(""))
				{
					SmokeTest_GetExtentReports.PassTestWithoutScreenshot(driver, SmokeTest_test, "Option "+i+": "+AssessmentSettingsTitle.getText());
					i++;
				}
			}

			if ((i) >= 105)
			{
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "All The Assessment Settings Options Are Displayed for the Employee");
			}
			else
			{
				SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "All The Assessment Settings Options Are NOT Displayed for the Employee");
			}

		}
		catch(Exception E)
		{
			ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Page should navigate to respective Page", "Exception Ocurred: "+E, "Fail");
			System.out.println(E);
		}
		driver.navigate().back();
	}


	public static void MySkillHistoryPageValidation(WebDriver driver, String Browser, String TestCaseID, ExtentTest SmokeTest_test)
	{
		String Title = "My Skill History Page Validation";
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PageObjects.HamMenuButtonCssSelector)));
			WebElement element = driver.findElement(By.cssSelector(PageObjects.SkillHistorymenuCssSelector));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", element);

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PageObjects.SkillHistoryTitleCssSelector)));
			String PageTitle = driver.findElement(By.cssSelector(PageObjects.SkillHistoryTitleCssSelector)).getText();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PageObjects.SkillGridXpath)));
			Thread.sleep(5000);
			if(PageTitle.contains("My Skill Change History"))
			{
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "My Skill Change History Page Title Is Displayed Correctly");
				ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: Page Tile should be displayed", "The Actual Result is:" +PageTitle, "Pass");
			}
			else
			{
				SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "My Skill Change History Page Title Is NOT Displayed Correctly");
				ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: Page Tile should be displayed", "The Actual Result is:" +PageTitle, "Fail");
			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PageObjects.AllSkillTabCssSelector)));
			WebElement AllSkillTab = driver.findElement(By.cssSelector(PageObjects.AllSkillTabCssSelector));
			if(AllSkillTab.isDisplayed())
			{
				AllSkillTab.click();
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "My Skill Change History Page All Tab Is Displayed Correctly");
				ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: All Skill Tab should be displayed", "The Actual Result is: All Skill Tab is displayed", "Pass");
				ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: All Skill Grid Table should be displayed", "The Actual Result is: All Skill Gridb Table is displayed", "Pass");
			}

			WebElement PrimarySkillTab = driver.findElement(By.cssSelector(PageObjects.PrimarySkillTabCssSelector));
			if(PrimarySkillTab.isDisplayed())
			{
				PrimarySkillTab.click();
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "My Skill Change History Page Primary Skill Tab Is Displayed Correctly");
				ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: Primary Skill Tab should be displayed", "The Actual Result is: Primary Skill Tab is displayed", "Pass");
				ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: Primary Skill Grid Table should be displayed", "The Actual Result is: Primary Skill Grid Table is displayed", "Pass");
			}

			WebElement SecondarySkillTab = driver.findElement(By.cssSelector(PageObjects.SecondarySkillTabCssSelector));
			if(SecondarySkillTab.isDisplayed())
			{
				SecondarySkillTab.click();
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "My Skill Change History Page Secondary Skill Tab Is Displayed Correctly");
				ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: Secondary Skill Tab should be displayed", "The Actual Result is: Secondary Skill Tab is displayed", "Pass");
				ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: Secondary Skill Grid Table should be displayed", "The Actual Result is: Secondary Skill Grid Table is displayed", "Pass");
			}

			WebElement Dropdown = driver.findElement(By.cssSelector(PageObjects.RecordCountDropDownCssSelector));
			if(Dropdown.isDisplayed())
			{
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "My Skill Change History Page Show More Records Dropdown Is Displayed Correctly");
				ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: Show Records DropDown should be displayed", "The Actual Result is: Show Records DropDown is displayed", "Pass");
			}

			WebElement Pagination = driver.findElement(By.cssSelector(PageObjects.PaginationContentCssSelector));
			if(Pagination.isDisplayed())
			{
				Robot robot = new Robot();
				robot.keyPress(KeyEvent.VK_END);
				robot.keyRelease(KeyEvent.VK_END);

				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "My Skill Change History Page Pagination Option Is Displayed Correctly");
				ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: Pagination should be displayed", "The Actual Result is: Pagination is displayed", "Pass");
			}
		}
		catch(Exception E)
		{
			ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Page should navigate to respective Page", "Exception Ocurred: "+E, "Fail");
		}
		driver.navigate().back();
	}

	public static void Carouselclose(WebDriver driver, String Browser, String TestCaseID)
	{
		String Title = "HomePage Validation";
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PageObjects.CarouselclosebuttonCssSelector)));
			driver.findElement(By.cssSelector(PageObjects.CarouselclosebuttonCssSelector)).click();
		}
		catch(Exception E)
		{
			ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Page should navigate to respective Page", "Exception Ocurred: "+E, "Fail");
		}
	}

	public static void AddSecondarySkill(WebDriver driver, String Browser, String TestCaseID, ExtentTest SmokeTest_test)
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));
			try
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PageObjects.AddSecondarySkillCssSelector)));
			}
			catch (Exception e)
			{}

			if (driver.findElements(By.cssSelector(PageObjects.AddSecondarySkillCssSelector)).size()!=0)
			{
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Add Secondary Skill Button is Displayed in the Employee Home Page");
				WebElement element = driver.findElement(By.cssSelector(PageObjects.AddSecondarySkillCssSelector));
				JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();", element);
			}
			else
			{
				SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Add Secondary Skill Button is NOT Displayed in the Employee Home Page");
			}
		}
		catch(Exception E)
		{
			ExcelObj.WriteExcel(TestCaseID, Browser, "Exception", "The Page should navigate to respective Page", "Exception Ocurred: "+E, "Fail");
		}
	}

	public static void LearnAboutMyCompetencyCheck(WebDriver driver, String Browser, String TestCaseID, ExtentTest SmokeTest_test)
	{
		String Title = "Home Page Learn About My Competency button Validation";
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PageObjects.HomePageLogoCssSelector)));
			Thread.sleep(3000);
			WebElement element = driver.findElement(By.cssSelector(PageObjects.LearnAboutMyCompetencyButtonCssSelector));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", element);
			Thread.sleep(3000);

			if(driver.findElement(By.cssSelector(PageObjects.CarouselCssSelector)).isDisplayed())
			{
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "About myCompetency Pop-Up Is Displayed for the Employee");
				ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: Carousel should be displayed, When Learn About My Competency button is clicked", "The Actual Result is: Carousel is displayed", "Pass");

				try
				{
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PageObjects.HowItWorkTabInAbt)));
				}
				catch (Exception e)
				{}

				WebElement HowItWorkTab = driver.findElement(By.cssSelector(PageObjects.HowItWorkTabInAbt));
				executor.executeScript("arguments[0].click();", HowItWorkTab);
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "How It Works Tab inside About myCompetency Pop-Up Is Displayed for the Employee");

				WebElement CertRoadMapTab = driver.findElement(By.cssSelector(PageObjects.CertRoadMap));
				executor.executeScript("arguments[0].click();", CertRoadMapTab);
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Certification Road Map Tab inside About myCompetency Pop-Up Is Displayed for the Employee");

				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PageObjects.OtherResourceTabInAbt)));
				WebElement OthRes = driver.findElement(By.cssSelector(PageObjects.OtherResourceTabInAbt));
				executor.executeScript("arguments[0].click();", OthRes);
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Other-Resources Tab inside About myCompetency Pop-Up Is Displayed for the Employee");

				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PageObjects.CloseButtoninAbotPopup)));
				WebElement AbtMyCompClose = driver.findElement(By.cssSelector(PageObjects.CloseButtoninAbotPopup));
				executor.executeScript("arguments[0].click();", AbtMyCompClose);
			}
			else
			{
				SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "About myCompetency Pop-Up Is NOT Displayed for the Employee");
				ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: Carousel should be displayed, When Learn About My Competency button is clicked", "The Actual Result is: Carousel is not displayed", "Fail");
			}
		}
		catch(Exception E)
		{
			ExcelObj.WriteExcel(TestCaseID, Browser, "Exception", "The Page should navigate to respective Page", "Exception Ocurred: "+E, "Fail");
		}
	}

	public static void SupervisorNameClick(WebDriver driver, String Browser, String TestCaseID)
	{
		String Title = "HomePage Supervisor Name Click Validation";
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PageObjects.HomePageLogoCssSelector)));
			Thread.sleep(3000);
			try
			{
				driver.findElement(By.cssSelector(PageObjects.CarouselclosebuttonCssSelector)).click();
				Thread.sleep(3000);
			}
			catch(Exception E){}

			driver.findElement(By.cssSelector(PageObjects.ProfileSectionCssSelector));
			WebElement element = driver.findElement(By.cssSelector(PageObjects.SupervisorNameClickCssSelector));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", element);
			ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1));
			Thread.sleep(5000);
			String Pagetitle = driver.getTitle();
			if(Pagetitle.contains("Accenture Service Tool"))
			{
				ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: It should navigate to AST Page, When supervisor link is clicked", "The Actual Result is: AST page is displayed", "Pass");
			}
			else
			{
				ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: It should navigate to AST Page, When supervisor link is clicked", "The Actual Result is: AST page is not displayed", "Fail");
			}
			driver.close();
			driver.switchTo().window(tabs.get(0));
		}
		catch(Exception E)
		{
			ExcelObj.WriteExcel(TestCaseID, Browser, "Exception", "The Page should navigate to respective Page", "Exception Ocurred: "+E, "Fail");
		}
		driver.get("https://mycompetency.accenture.com/");
	}

	public static void ViewLearningPathClick(WebDriver driver, String Browser, String TestCaseID)
	{
		String Title = "HomePage View Learning Path Click Validation";
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PageObjects.HomePageLogoCssSelector)));
			Thread.sleep(3000);
			WebElement element = driver.findElement(By.xpath(PageObjects.ViewLearningPathLinkXpath));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", element);
			ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PageObjects.SkillSearchResultTitleCssSelector)));
			WebElement PageTitle = driver.findElement(By.cssSelector(PageObjects.SkillSearchResultTitleCssSelector));
			if(PageTitle.isDisplayed())
			{
				ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: Search Result Title should be displayed", "The Actual Result is: Search Result Title is displayed", "Pass");
			}
			else
			{
				ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: Search Result Title should be displayed", "The Actual Result is: Search Result Title is not displayed", "Fail");
			}
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PageObjects.ViewCourseDetailButtonXpath)));
			WebElement CourseDetailButton = driver.findElement(By.xpath(PageObjects.ViewCourseDetailButtonXpath));
			if(CourseDetailButton.isDisplayed())
			{
				ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: View Course Detail Buttons should be displayed", "The Actual Result is: View Course Detail Buttons are displayed", "Pass");
			}
			else
			{
				ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: View Course Detail Buttons should be displayed", "The Actual Result is: View Course Detail Buttons are not displayed", "Fail");
			}
			WebElement Pagination = driver.findElement(By.cssSelector(PageObjects.SkillSearchResultPageinationSelector));
			if(Pagination.isDisplayed())
			{
				ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: Pageination should be displayed", "The Actual Result is: Pageination is displayed", "Pass");
			}
			else
			{
				ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: Pageination should be displayed", "The Actual Result is: Pageination is not displayed", "Fail");
			}
			WebElement DropDown = driver.findElement(By.cssSelector(PageObjects.SkillSearchResultPageinationSelector));
			if(DropDown.isDisplayed())
			{
				ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: Show Records DropDown should be displayed", "The Actual Result is: Show Records DropDown is displayed", "Pass");
			}
			else
			{
				ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: Show Records DropDown should be displayed", "The Actual Result is: Show Records DropDown is not displayed", "Fail");
			}
			WebElement Result = driver.findElement(By.cssSelector(PageObjects.SkillCourseDetailsCssSelector));
			if(Result.isDisplayed())
			{
				ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: Recommended Courses Results should be displayed", "The Actual Result is: Recommended Courses Results are displayed", "Pass");
			}
			else
			{
				ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: Recommended Courses Results should be displayed", "The Actual Result is: Recommended Courses Results are not displayed", "Fail");
			}
			WebElement Filter = driver.findElement(By.cssSelector(PageObjects.FilterCssSelector));
			if(Filter.isDisplayed())
			{
				ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: Filter should be displayed", "The Actual Result is: Filter is displayed", "Pass");
			}
			else
			{
				ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: Filter should be displayed", "The Actual Result is: Filter is not displayed", "Fail");
			}
			driver.close();
			driver.switchTo().window(tabs.get(0));
		}
		catch(Exception E)
		{
			ExcelObj.WriteExcel(TestCaseID, Browser, "Exception", "The Page should navigate to respective Page", "Exception Ocurred: "+E, "Fail");
		}
	}

	public static void AskDIPAClick(WebDriver driver, String Browser, String TestCaseID)
	{
		String Title = "HomePage Ask DIPA Click Validation";
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(150));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PageObjects.HomePageLogoCssSelector)));
			Thread.sleep(3000);

			WebElement element = driver.findElement(By.cssSelector(PageObjects.DIPAImageCssSelector));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", element);
			Thread.sleep(5000);
			ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
			driver.switchTo().window(tabs2.get(1));
			AccentureAccountClick(driver, Browser, TestCaseID);
			Thread.sleep(5000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PageObjects.DIPAPopupCssSelector)));
			driver.findElement(By.cssSelector(PageObjects.DIPAPopupCssSelector));
			driver.findElement(By.cssSelector(PageObjects.DIPAPopupCloseButtonCssSelector)).click();
			Thread.sleep(2000);
			//			WebElement Logo = driver.findElement(By.cssSelector(PageObjects.DIPAHomepageLogoCssSelector));
			String PageTitle = driver.getTitle();
			System.out.println(PageTitle);

			if(PageTitle == "DIPA")
			{
				ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: It should navigate to DIPA Home Page, When DIPA Icon is clicked", "The Actual Result is: DIPA Home page is displayed", "Pass");
			}
			else
			{
				ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: It should navigate to DIPA Home Page, When DIPA Icon is clicked", "The Actual Result is: DIPA Home page is not displayed", "Fail");
			}
			driver.close();
			driver.switchTo().window(tabs2.get(0));
		}
		catch(Exception E)
		{
			ExcelObj.WriteExcel(TestCaseID, Browser, "Exception", "The Page should navigate to respective Page", "Exception Ocurred: "+E, "Fail");
		}
	}

	public static void SymantecVerification(WebDriver driver)
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PageObjects.SymantecPopupCssSelector)));
			Thread.sleep(3000);

			JavascriptExecutor Executor = (JavascriptExecutor) driver;
			if (driver.findElements(By.cssSelector(PageObjects.SymentecDevice)).size()!=0)
			{
				WebElement UseCode = driver.findElement(By.cssSelector(PageObjects.UseSecurityCodeCss));
				Executor.executeScript("arguments[0].click();", UseCode);
				Thread.sleep(5000);

				if (driver.findElements(By.cssSelector(PageObjects.ConfirmIdentiyCss)).size()!=0)
				{
					System.out.println("Please Enter The Symentec Code Sent To Your Mobile Phone:");

					InputStreamReader ipstream = new InputStreamReader(System.in);
					BufferedReader Br = new BufferedReader(ipstream);
					String SymentecCode = Br.readLine();

					driver.findElement(By.cssSelector(PageObjects.OtpInputCss)).sendKeys(SymentecCode);
					WebElement ContinueBtn = driver.findElement(By.cssSelector(PageObjects.ContinueBtnCss));
					Executor.executeScript("arguments[0].click();", ContinueBtn);
					Thread.sleep(5000);

					if (driver.findElements(By.cssSelector(PageObjects.HomepageBannerCss)).size()!=0)
					{
						System.out.println("Employee Logged In Successfully");
					}
					else
					{
						System.out.println("Employee NOT Logged In Successfully");
					}
				}
				else
				{
					System.out.println("Use Code Button is NOT Clicked by Automation");
				}
			}
			else
			{
				System.out.println("Symentec Popup is not Displayed for the Employee");
			}

		}
		catch(Exception E)
		{
			System.out.println("Symantec Authentication Error "+E.getMessage());
		}
	}

	public static void SymantecPushVerification(WebDriver driver)
	{
		try
		{
			JavascriptExecutor Executor = (JavascriptExecutor) driver;
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PageObjects.SymantecPopupCssSelector)));
			Thread.sleep(3000);

			if (driver.findElements(By.cssSelector(PageObjects.SymentecDevice)).size()!=0)
			{
				String DeviceName = driver.findElement(By.cssSelector(PageObjects.SymentecDevice)).getText();
				System.out.println(DeviceName);
				if (DeviceName.contains("Ram_Mobile_Phone"))
				{
					System.out.println("Please Approve The Push Notification In Your Device "+DeviceName);
					Thread.sleep(7000);

					if (driver.findElements(By.cssSelector(PageObjects.SkipBtn)).size()!=0)
					{
						WebElement SkipBtnSymentec = driver.findElement(By.cssSelector(PageObjects.SkipBtn));
						Executor.executeScript("arguments[0].click();", SkipBtnSymentec);
					}
					else
					{
						WebElement SendAgain = driver.findElement(By.cssSelector(PageObjects.SymentecCodeResendCss));
						Executor.executeScript("arguments[0].click();", SendAgain);
						Thread.sleep(7000);

						WebElement SkipBtnSymentec = driver.findElement(By.cssSelector(PageObjects.SkipBtn));
						Executor.executeScript("arguments[0].click();", SkipBtnSymentec);

						if (driver.findElements(By.cssSelector(PageObjects.HomepageBannerCss)).size()!=0)
						{
							System.out.println("Employee Logged In Successfully");
						}
						else
						{
							SymantecVerification(driver);
							System.out.println("Employee NOT Logged In Successfully");
						}
					}
				}
				else
				{
					System.out.println("Device Displayed is Wrong : "+DeviceName);
				}
			}
			else
			{
				System.out.println("Symentec Popup is not Displayed for the Employee");
			}
		}
		catch(Exception E)
		{
			System.out.println("Symantec Authentication Error");
		}
	}

	public static void AccentureAccountClick(WebDriver driver, String Browser, String TestCaseID)
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PageObjects.AccentureAccountFieldCssSelector)));
			Thread.sleep(3000);
			WebElement element = driver.findElement(By.cssSelector(PageObjects.AccentureAccountFieldCssSelector));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", element);
		}
		catch(Exception E)
		{
			ExcelObj.WriteExcel(TestCaseID, Browser, "Exception", "The Page should navigate to respective Page", "Exception Ocurred: "+E, "Fail");
		}
	}

	public static void DeleteSkillAndSwapIcon(WebDriver driver, String Browser, String TestCaseID, ExtentTest SmokeTest_test)
	{
		String Title = "Secondary Skill Delete and Swap Icon Status Validation";
		try
		{
			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(90));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			try
			{
				wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(PageObjects.SkillLoadingIconXpath)));
			}
			catch (Exception e)
			{
				System.out.println(e);
			}

			WebElement SecondarySkillTitle = driver.findElement(By.cssSelector(PageObjects.PrimarySkilLSection));
			executor.executeScript("arguments[0].scrollIntoView(true);", SecondarySkillTitle);

			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PageObjects.SecondarySkillNameXpath)));
			if (driver.findElements(By.cssSelector(PageObjects.SecondaryTrashbinStatusCssSelector)).size()!=0)
			{
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Trash Bin Icon is Displayed in HomePage to Delete the Skill");
				ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: Trash Icon should be displayed", "The Actual Result is: True", "Pass");

				WebElement TrashIcon1 = driver.findElement(By.cssSelector(PageObjects.SecondaryTrashbinStatusCssSelector));
				executor.executeScript("arguments[0].click();", TrashIcon1);
				try
				{
					wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PageObjects.DeleteSkillPopupCssSelector)));
				}
				catch (Exception e)
				{
					WebElement TrashIcon2 = driver.findElement(By.cssSelector(PageObjects.SecondaryTrashbinStatusCssSelector));
					executor.executeScript("arguments[0].click();", TrashIcon2);
				}

				if (driver.findElements(By.cssSelector(PageObjects.DeleteSkillPopupCssSelector)).size()!=0)
				{
					SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Delete Skill PopUp is Displayed After Clicking the Trash Bin Icon");
				}
				else
				{
					SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Delete Skill PopUp is NOT Displayed After Clicking the Trash Bin Icon");
				}
				WebElement CnfCheckBox = driver.findElement(By.xpath(PageObjects.CnfCheckBox));
				executor.executeScript("arguments[0].click();", CnfCheckBox);

				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PageObjects.ProceedBtn)));
				WebElement ProceedBtn = driver.findElement(By.xpath(PageObjects.ProceedBtn));
				if(ProceedBtn.isEnabled()) {
					SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Proceed Button is Enabled After Selecting the Checkbox");
				}else {
					SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Proceed Button is Not Enabled After Selecting the Checkbox");
				}
				executor.executeScript("arguments[0].click();", ProceedBtn);

				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PageObjects.RsnForSkillDlt)));
				if(driver.findElements(By.xpath(PageObjects.RsnForSkillDlt)).size()!=0) {
					SmokeTest_GetExtentReports.PassTestWithoutScreenshot(driver, SmokeTest_test, "Reason for Deleting the Skill PopUp is Displayed");
				}else {
					SmokeTest_GetExtentReports.FailTestWithoutScreenshot(driver, SmokeTest_test, "Reason for Deleting the Skill PopUp is Not Displayed");
				}

				if(driver.findElements(By.xpath(PageObjects.RsnSelect)).size()!=0) {
					SmokeTest_GetExtentReports.PassTestWithoutScreenshot(driver, SmokeTest_test, "Select Reason for Deleting Skill Dropdown is Displayed");
				}else {
					SmokeTest_GetExtentReports.FailTestWithoutScreenshot(driver, SmokeTest_test, "Select Reason for Deleting Skill Dropdown is Not Displayed");
				}
				WebElement SelectDropDwn = driver.findElement(By.xpath(PageObjects.RsnSelect));
				
				WebElement Dropdown0 = driver.findElement(By.xpath(PageObjects.RsnSelect));
				Actions action = new Actions(driver);
				action.moveToElement(Dropdown0).click(Dropdown0).build().perform();

				Thread.sleep(4000);
				
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PageObjects.DeleteRsnOpt1)));
				if(driver.findElements(By.xpath(PageObjects.DeleteRsnOpt1)).size()!=0) {
					SmokeTest_GetExtentReports.PassTestWithoutScreenshot(driver, SmokeTest_test, "Reasons for Deleting Skill are Shown After Clicking the Dropdown is Displayed");
				}else {
					SmokeTest_GetExtentReports.FailTestWithoutScreenshot(driver, SmokeTest_test, "Reasons for Deleting Skill are Not Shown After Clicking the Dropdown is Displayed");
				}
				WebElement OthersOpt = driver.findElement(By.xpath(PageObjects.DeleteRsnOpt1));
				executor.executeScript("arguments[0].click();", OthersOpt);


				if (driver.findElements(By.cssSelector(PageObjects.DeleteSkillCommentCssSelector)).size()!=0)
				{
					SmokeTest_GetExtentReports.PassTestWithoutScreenshot(driver, SmokeTest_test, "Delete Skill PopUp Comment Section is Displayed");
				}
				else
				{
					SmokeTest_GetExtentReports.FailTestWithoutScreenshot(driver, SmokeTest_test, "Delete Skill PopUp Comment Section is NOT Displayed");
				}

				if (driver.findElements(By.cssSelector(PageObjects.DeleteSkillCommentCssSelector)).size()!=0)
				{
					SmokeTest_GetExtentReports.PassTestWithoutScreenshot(driver, SmokeTest_test, "Delete Skill PopUp Comment Section is Displayed");
					driver.findElement(By.cssSelector(PageObjects.DeleteSkillCommentCssSelector)).sendKeys("Going to Delete the Secondary Skill");
				}
				else
				{
					SmokeTest_GetExtentReports.FailTestWithoutScreenshot(driver, SmokeTest_test, "Delete Skill PopUp Comment Section is NOT Displayed");
				}

				if (driver.findElements(By.xpath(PageObjects.OKButtonXpath)).size()!=0)
				{
					SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Okay Button is Displayed In the Delete PopUp");
				}
				else
				{
					SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Okay Button is NOT Displayed In the Delete PopUp");
				}

				if (driver.findElements(By.xpath(PageObjects.CloseButtonXpath)).size()!=0)
				{
					SmokeTest_GetExtentReports.PassTestWithoutScreenshot(driver, SmokeTest_test, "Delete Skill PopUp Cancel Button is Displayed");
				}
				else
				{
					SmokeTest_GetExtentReports.FailTestWithoutScreenshot(driver, SmokeTest_test, "Delete Skill PopUp Cancel Button is NOT Displayed");
				}

				WebElement DeleteCloseBtn = driver.findElement(By.cssSelector(PageObjects.DeleteSkillPopupCloseCss));
				executor.executeScript("arguments[0].click();", DeleteCloseBtn);

				WebElement AddSecScroll = driver.findElement(By.cssSelector(PageObjects.AddSecondarySkillCss));
				executor.executeScript("arguments[0].scrollIntoView(true);", AddSecScroll);

				Thread.sleep(3000);
				try
				{
					wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PageObjects.SecondarySkillSwapStatusCssSelector)));
				}
				catch (Exception e)
				{}

				if (driver.findElements(By.cssSelector(PageObjects.SecondarySkillSwapStatusCssSelector)).size()!=0)
				{
					SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Secondary Skill Swap Option is Displayed in the Home Page");
					WebElement SwapIcon = driver.findElement(By.cssSelector(PageObjects.SecondarySkillSwapStatusCssSelector));
					executor.executeScript("arguments[0].click();", SwapIcon);
				}
				else
				{
					SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Secondary Skill Swap Option is NOT Displayed in the Home Page");
				}

				try
				{
					wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PageObjects.SecondarySkillSwapPopUpCssSelector)));
				}
				catch (Exception e)
				{}

				if (driver.findElements(By.cssSelector(PageObjects.SecondarySkillSwapPopUpCssSelector)).size()!=0)
				{
					SmokeTest_GetExtentReports.PassTestWithoutScreenshot(driver, SmokeTest_test, "Secondary Skill Swap PopUp is Displayed After Clicking Swap Icon");
				}
				else
				{
					SmokeTest_GetExtentReports.FailTestWithoutScreenshot(driver, SmokeTest_test, "Secondary Skill Swap PopUp is NOT Displayed After Clicking Swap Icon");
				}

				try
				{
					if (driver.findElements(By.cssSelector(PageObjects.SecondarySkillSwapPopUpMonthDropdownCssSelector)).size()!=0)
					{

						wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PageObjects.SecondarySkillSwapPopUpMonthDropdownCssSelector)));

						WebElement Dropdown10 = driver.findElement(By.cssSelector(PageObjects.SecondarySkillSwapPopUpMonthDropdownCssSelector));
						Actions action1 = new Actions(driver);
						action1.moveToElement(Dropdown10).click(Dropdown10).build().perform();

						Thread.sleep(4000);
						wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PageObjects.SkillSwapDropDownOptionCss)));
						WebElement DropdownOption = driver.findElement(By.cssSelector(PageObjects.SkillSwapDropDownOptionCss));
						Actions action2 = new Actions(driver);
						action2.moveToElement(DropdownOption).click(DropdownOption).build().perform();
						SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Secondary Skill Swap PopUp Project Name Dropdown is Displayed for the Employee");

					}
					else
					{
						SmokeTest_GetExtentReports.FailTestWithoutScreenshot(driver, SmokeTest_test, "Secondary Skill Swap PopUp Project Name Dropdown is NOT Displayed for the Employee");
					}
				}
				catch (Exception e)
				{
					System.out.println(e.getMessage());
				}

				/*
				 * if
				 * (driver.findElements(By.cssSelector(PageObjects.SkillSwapPopupTextCss)).size(
				 * )!=0) { WebElement TextBox =
				 * driver.findElement(By.cssSelector(PageObjects.SkillSwapPopupTextCss));
				 * TextBox.sendKeys("Skill Swap Comments");
				 * SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test,
				 * "Skill Swap Input for Project Name is Displayed for the Employee"); } else {
				 * SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test,
				 * "Skill Swap Input for Project Name is NOT Displayed for the Employee"); }
				 */
				
				if (driver.findElements(By.xpath(PageObjects.TotalExp)).size()!=0)
				{
					WebElement TextBox = driver.findElement(By.xpath(PageObjects.TotalExp));
					TextBox.sendKeys("24");
					SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Skill Swap Input for Total Expereince is Displayed for the Employee");
				}
				else
				{
					SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Skill Swap Input for Total Expereince is NOT Displayed for the Employee");
				}
				
				try
				{
					if (driver.findElements(By.xpath(PageObjects.ReasoonForSkillChange)).size()!=0)
					{

						wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PageObjects.ReasoonForSkillChange)));

						WebElement Dropdown2 = driver.findElement(By.xpath(PageObjects.ReasoonForSkillChange));
						Actions action3 = new Actions(driver);
						action3.moveToElement(Dropdown2).click(Dropdown2).build().perform();

						Thread.sleep(4000);
						wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PageObjects.ReasoonForSkillChangeOption1)));
						WebElement DropdownOption = driver.findElement(By.xpath(PageObjects.ReasoonForSkillChangeOption1));
						Actions action4 = new Actions(driver);
						action4.moveToElement(DropdownOption).click(DropdownOption).build().perform();
						SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Secondary Skill Swap PopUp Reason Dropdown is Displayed for the Employee");

					}
					else
					{
						SmokeTest_GetExtentReports.FailTestWithoutScreenshot(driver, SmokeTest_test, "Secondary Skill Swap PopUp Reason Dropdown is NOT Displayed for the Employee");
					}
				}
				catch (Exception e)
				{
					System.out.println(e.getMessage());
				}


				if (driver.findElements(By.cssSelector(PageObjects.SubmitRequestButtonCss)).size()!=0)
				{
					SmokeTest_GetExtentReports.PassTestWithoutScreenshot(driver, SmokeTest_test, "Skill Swap Submit Request Button is Displayed for the Employee");
				}
				else
				{
					SmokeTest_GetExtentReports.FailTestWithoutScreenshot(driver, SmokeTest_test, "Skill Swap Submit Request Button is NOT Displayed for the Employee");
				}

				/*
				 * if
				 * (driver.findElements(By.cssSelector(PageObjects.SkillSwapPopupCloseCss)).size
				 * ()!=0) { SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test,
				 * "Skill Swap PopUp Close Button is Displayed for the Employee"); WebElement
				 * SwapClose =
				 * driver.findElement(By.cssSelector(PageObjects.SkillSwapPopupCloseCss));
				 * executor.executeScript("arguments[0].click();", SwapClose); } else {
				 * SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test,
				 * "Skill Swap PopUp Close Button is NOT Displayed for the Employee"); }
				 */

				ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: Skill card should be deleted", "The Actual Result is: Skill card is deleted", "Pass");
			}
			else
			{
				ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: Trash Icon should be displayed", "The Actual Result is:False", "Fail");
			}
		}	
		catch (Exception E)
		{
			System.out.println(E.getMessage());
			ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: Trash Icon should be displayed", "The Actual Result is: Exception" +E, "Fail");
		}
	}

	public static void SkillAcceleratorGuidance_HomePage_Validation(WebDriver driver, String Browser, String TestCaseID, ExtentTest SmokeTest_test) 
	{
		String Title = "SkillAcceleratorGuidance_Validation";
		try
		{
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));
			JavascriptExecutor Executor = (JavascriptExecutor) driver;

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PageObjects.HomePageLogoCssSelector)));

			if(driver.findElements(By.cssSelector(PageObjects.SkillAcceleratorGuideRecommendedSectionCss)).size()!=0)
			{
				WebElement SAGSectionScroll = driver.findElement(By.cssSelector(PageObjects.SkillAcceleratorGuideRecommendedSectionCss));
				Executor.executeScript("arguments[0].scrollIntoView();", SAGSectionScroll);

				Robot robot = new Robot();
				robot.keyPress(KeyEvent.VK_END);
				robot.keyRelease(KeyEvent.VK_END);

				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Skill Accelerator Guide Section is Displayed in Home Page");
				ExcelObj.WriteExcel(TestCaseID, Browser, Title, "Skill Guidance Section should be Displayed", "Skill Guidance Section in HomePage is Displayed", "Pass");

				if (driver.findElements(By.cssSelector(PageObjects.SkillAcceleratorGuideHeadingCss)).size()!=0)
				{
					String SkillGuidancePageHeading = driver.findElement(By.cssSelector(PageObjects.SkillAcceleratorGuideHeadingCss)).getText();
					if (SkillGuidancePageHeading.contains("Skill Accelerator Guide Recommendations"))
					{
						SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "SAG Section Title Displayed Is Correct :"+SkillGuidancePageHeading);
					}
					else
					{
						SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "SAG Section Title Displayed Is Incorrect :"+SkillGuidancePageHeading);
					}

					if(driver.findElements(By.xpath(PageObjects.NoSAGSkill)).size()!=0) {
						SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "No SAG Skills Are Available for Employee");
					}
					else if (driver.findElements(By.cssSelector(PageObjects.RecommendedSkillinSAGCss)).size()!=0)
					{
						if (driver.findElements(By.cssSelector(PageObjects.RecommendedSkillPaginationCss)).size() != 0)
						{
							SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Pagination for SAG Recommeded Section Is Displayed");
						}
						else
						{
							SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Pagination for SAG Recommeded Section Is NOT Displayed");
						}

						if (driver.findElements(By.cssSelector(PageObjects.SAGAddtoSecondaryBtnCss)).size() != 0)
						{
							SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Add Secondary Skill Button is Displayed in the SAG Recommendation Section");
						}
						else
						{
							SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Add Secondary Skill Button is NOT Displayed in the SAG Recommendation Section");
						}

						if (driver.findElements(By.cssSelector(PageObjects.SAGFeedBackSectionCss)).size() != 0)
						{
							SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Employee Feedback Section for SAG Recommendation is Displayed");
						}
						else
						{
							SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Employee Feedback Section for SAG Recommendation is NOT Displayed");
						}

						if (driver.findElements(By.cssSelector(PageObjects.SAGTrendGraphButtonCss)).size() != 0)
						{
							WebElement DemandTrendOpenBtn = driver.findElement(By.cssSelector(PageObjects.SAGTrendGraphButtonCss));
							Executor.executeScript("arguments[0].click();", DemandTrendOpenBtn);

							wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PageObjects.SAGTrendGraphPopUpCss)));
							if (driver.findElements(By.cssSelector(PageObjects.SAGTrendGraphPopUpCss)).size() != 0)
							{
								SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Demand Trend Graph Pop Up is Displayed For The Skill");
							}
							else
							{
								SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Demand Trend Graph Pop Up is NOT Displayed For The Skill");
							}

							if (driver.findElements(By.cssSelector(PageObjects.DemandTrendMonthlyCss)).size()!=0)
							{
								SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Monthly Button Is Displayed in the Demand Trend Graph");
								wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PageObjects.DemandTrendLineGraphCss)));
								if (driver.findElements(By.cssSelector(PageObjects.DemandTrendLineGraphCss)).size()!=0)
								{
									SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Demand Trend Line Graph is Displayed for Monthly Basis");
								}
								else
								{
									SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Demand Trend Line Graph is NOT Displayed for Monthly Basis");
								}
							}
							else
							{
								SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Monthly Button Is NOT Displayed in the Demand Trend Graph");
							}

							if (driver.findElements(By.cssSelector(PageObjects.DemandTrendQuaterlyCss)).size()!=0)
							{
								SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Quaterly Button Is Displayed in the Demand Trend Graph");
								WebElement QuaterlyBtn = driver.findElement(By.cssSelector(PageObjects.DemandTrendQuaterlyCss));
								QuaterlyBtn.click();
								wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PageObjects.DemandTrendLineGraphCss)));
								if (driver.findElements(By.cssSelector(PageObjects.DemandTrendLineGraphCss)).size()!=0)
								{
									SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Demand Trend Line Graph is Displayed for Quaterly Basis");
								}
								else
								{
									SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Demand Trend Line Graph is NOT Displayed for Quaterly Basis");
								}
							}
							else
							{
								SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Quaterly Button Is NOT Displayed in the Demand Trend Graph");
							}

							if (driver.findElements(By.cssSelector(PageObjects.DemandTrendYearlyCss)).size()!=0)
							{
								SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Yearly Button Is Displayed in the Demand Trend Graph");
								WebElement QuaterlyBtn = driver.findElement(By.cssSelector(PageObjects.DemandTrendYearlyCss));
								QuaterlyBtn.click();
								wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PageObjects.DemandTrendLineGraphCss)));
								if (driver.findElements(By.cssSelector(PageObjects.DemandTrendLineGraphCss)).size()!=0)
								{
									SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Demand Trend Line Graph is Displayed for Yearly Basis");
								}
								else
								{
									SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Demand Trend Line Graph is NOT Displayed for Yearly Basis");
								}
							}
							else
							{
								SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Yearly Button Is NOT Displayed in the Demand Trend Graph");
							}

							WebElement SAGPopUpClosebtn = driver.findElement(By.cssSelector(PageObjects.DemandTrendCloseBtnCss));
							Executor.executeScript("arguments[0].click();", SAGPopUpClosebtn);

						}
						else
						{
							SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "SAG Recommended Section Demand Graph NOT Displayed for Employee");
						}
					}
					else
					{
						SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "No Skill Is Available for Recommendation To Employee");
					}
				}
				else
				{
					SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "No Skill for the Employee in Recommended Section");
				}
			}
			else
			{
				SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Skill Accelerator Guide Section is NOT Displayed in Home Page");
				ExcelObj.WriteExcel(TestCaseID, Browser, Title, "Skill Guidance Start Up Page should be Displayed", "Skill Guidance Start Up Page is not Displayed", "Fail");
			}

		}
		catch(Exception E)
		{
			System.out.println(E);
			ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: Skill Guidance Start Up Page be displayed", "The Actual Result is: Exception" +E, "Fail");
		}
	}
	public static void SkillsOfInterestTabValidation(WebDriver driver, String Browser, ExtentTest SmokeTest_test) {
		try
		{
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));
			JavascriptExecutor Executor = (JavascriptExecutor) driver;

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PageObjects.HomePageLogoCssSelector)));
			WebElement SOITab = driver.findElement(By.xpath(PageObjects.SOITab));
			if(SOITab.isDisplayed()) {
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Skills of Interest Tab is Displayed in Home Page");
			}else {
				SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Skills of Interest Tab is Not Displayed in Home Page");
			}
			Executor.executeScript("arguments[0].click();", SOITab);

			if(driver.findElements(By.xpath(PageObjects.SOISkillsPresentTxt)).size()!=0 || driver.findElements(By.xpath(PageObjects.SOISkillsNotTxt)).size()!=0) {
				if(driver.findElements(By.xpath(PageObjects.SOISkillsNotTxt)).size()!=0) {
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PageObjects.SOISkillsNotTxt)));
					WebElement SOISkillsNotPresent = driver.findElement(By.xpath(PageObjects.SOISkillsNotTxt));
					if(SOISkillsNotPresent.isDisplayed()) {
						SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Skills of Interest Skills are Not Available for Employee");
					}
				}else {
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PageObjects.SOISkillsPresentTxt)));
					WebElement SOISkillsNotPresent = driver.findElement(By.xpath(PageObjects.SOISkillsPresentTxt));
					if(SOISkillsNotPresent.isDisplayed()) {
						SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Skills of Interest Skills are Available for Employee");
					}
					else {
						SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Skills of Interest Skills are Not Available for Employee");
					}
				}
			}
			if(driver.findElements(By.xpath(PageObjects.SOISkillsPresentTxt)).size()!=0) {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PageObjects.SOISkillsHeader)));
				WebElement SOIHeader = driver.findElement(By.xpath(PageObjects.SOISkillsHeader));
				Executor.executeScript("arguments[0].scrollIntoView(true);", SOIHeader);
				if(driver.findElement(By.xpath(PageObjects.SOISkillsHeader)).isDisplayed()) {
					SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Skills of Interest Skills Header is Shown for the Skills");
				}else {
					SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Skills of Interest Skills Header is Not Shown for the Skills");
				}
				
				if(driver.findElement(By.xpath(PageObjects.SOISkillAction)).isDisplayed()) {
					SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Action and Status is Shown for Skills of Interest Skills");
				}else {
					SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Action and Status is Shown for Skills of Interest Skills");
				}
				
				if(driver.findElement(By.xpath(PageObjects.SOISkillActionText)).isDisplayed()) {
					SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Text to Complete the Assessment is Shown below the Action and Status");
				}else {
					SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Text to Complete the Assessment is Shown below the Action and Status");
				}
				
				if(driver.findElement(By.xpath(PageObjects.SOISkillDeleteBtn)).isDisplayed()) {
					SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Trash Icon is Disaplyed for Skills of Interest Skills");
				}else {
					SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Trash Icon is Not Disaplyed for Skills of Interest Skills");
				}
			}
		}
		catch(Exception E) {
			System.out.println(E);
			 SmokeTest_GetExtentReports.Exception(driver, SmokeTest_test, E);
		}
	}
	
	 /****************************** Landing page header ********************************/

	public static void LandingPageHeader(WebDriver driver, ExtentTest SmokeTest_test,
		ExtentReports SmokeTest_report) {
	try {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100)); 
		driver.findElement(PageObjects.webNavigationClose).click();
		Thread.sleep(3000);
		WebElement MycompetencyHeader = driver.findElement(By.xpath(PageObjects.Mycompetency));
		if(MycompetencyHeader.isDisplayed())
		{
			SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test,
					"Mycompetency Logo is present");
		}
		else
		{
			SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test,
					"Mycompetency Logo is not present");
		}	
		
		WebElement FeedbackHeader = driver
				.findElement(By.xpath(PageObjects.Feedback));
		if(FeedbackHeader.isDisplayed())
		{
			SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test,
					"FeedBack is present in New Landing Page");
		}
		else
		{
			SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test,
					"FeedBack is not present in New Landing Page");
		}	
		
		
		WebElement AboutHeader = driver
				.findElement(By.xpath(PageObjects.About));
		if(AboutHeader.isDisplayed())
		{
			SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test,
					"Resources is present in New Landing Page");
		}
		else
		{
			SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test,
					"Resources is not present in New Landing Page");
		}	
		
		WebElement SkillprofileHeader = driver
				.findElement(By.xpath(PageObjects.SkillProfile));
		if(SkillprofileHeader.isDisplayed())
		{
			SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test,
					"SkillProfile is present in New Landing Page");
		}
		else
		{
			SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test,
					"SkillProfile is not present in New Landing Page");
		}
		
		
		WebElement SearchbuttonHeader = driver
				.findElement(By.xpath(PageObjects.Searchbutton));
		if(SearchbuttonHeader.isDisplayed())
		{
			SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test,
					"HamBurger is present in New Landing Page");
		}
		else
		{
			SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test,
					"HamBurger is not present in New Landing Page");
		}}
		
		 catch (Exception E) 
			{
			 System.out.println(E);
			 SmokeTest_GetExtentReports.Exception(driver, SmokeTest_test, E);
			}

		 }
	
	/****************************** Landing page footer ********************************/

	public static void LandingPageFooter(WebDriver driver, ExtentTest SmokeTest_test,
		ExtentReports LPVTest_report) {
	try {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
		/*JavascriptExecutor Executer = (JavascriptExecutor) driver;
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PageObjects.StaySignedIn)));
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(PageObjects.StaySignedInNo)));
		driver.findElement(By.id(PageObjects.StaySignedInNo)).click();*/
		Thread.sleep(2000);
		
		WebElement RaiseTicketfooter = driver.findElement(By.xpath(PageObjects.RaiseticketHyperlink));
		JavascriptExecutor Executer = (JavascriptExecutor) driver;
		Executer.executeScript("arguments[0].scrollIntoView();", RaiseTicketfooter);
		if(RaiseTicketfooter.isDisplayed())
		{
			SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test,
					"Click here hyperlink is present under Got Any Technical Issue");
		}
		else
		{
			SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test,
					"Click here hyperlink is not present under Got Any Technical Issue");
		}	
		
		WebElement SiteMapfooter = driver
				.findElement(By.xpath(PageObjects.Sitemap));
		if(SiteMapfooter.isDisplayed())
		{
			SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test,
					"Site Map hyperlink is present in Footer");
		}
		else
		{
			SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test,
					"Site Map hyperlink is not present in Footer");
		}	
		
		
		WebElement TermsOfUsefooter = driver
				.findElement(By.xpath(PageObjects.TermsOfUse));
		if(TermsOfUsefooter.isDisplayed())
		{
			SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test,
					"Terms of Use hyperlink is present in Footer");
		}
		else
		{
			SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test,
					"Terms of Use hyperlink is not present in Footer");
		}	
		
		WebElement PrivacyPolicyFooter = driver
				.findElement(By.xpath(PageObjects.PrivacyPolicy));
		if(PrivacyPolicyFooter.isDisplayed())
		{
			SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test,
					"Data Privacy Statement hyperlink is present in Footer");
		}
		else
		{
			SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test,
					"Data Privacy Statement hyperlink is not present in Footer");
		}
		
		
		WebElement CookiePolicyfooter = driver
				.findElement(By.xpath(PageObjects.CookiePolicy));
		if(CookiePolicyfooter.isDisplayed())
		{
			SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test,
					"CopyRight Text is present in Footer");
		}
		else
		{
			SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test,
					"CopyRight Text is not present in Footer");
		}}
		
		
		 catch (Exception E) 
			{
			 System.out.println(E);
			 SmokeTest_GetExtentReports.Exception(driver, SmokeTest_test, E);
			}

		 }
	

	public static void feedbackPopUpValidation(WebDriver driver, ExtentTest SmokeTest_test,  ExtentReports SmokeTest_report) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			JavascriptExecutor js = (JavascriptExecutor) driver;
/*
        	wait.until(ExpectedConditions.visibilityOfElementLocated(PageObjects.webNavigationClose));
			if (driver.findElements(PageObjects.webNavigationClose).size() != 0) {
				wait.until(ExpectedConditions.visibilityOfElementLocated(PageObjects.webNavigationClose));
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test,"Welcome PopUp Displayed in Landing Page");
				driver.findElement(PageObjects.webNavigationClose).click();
			} else {
				SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test,"Welcome PopUp Not Displayed in Landing Page");
			}*/

			
			wait.until(ExpectedConditions.visibilityOfElementLocated(PageObjects.feedbcakBtn));
			WebElement feedBtn = driver.findElement(PageObjects.feedbcakBtn);
			feedBtn.sendKeys(Keys.ARROW_UP);
			if(feedBtn.isDisplayed()) {
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Feedback Button Displayed in Landing Page");
			}else {
				SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Feedback Button Not Displayed in Landing Page");
			}
			feedBtn.click();

			wait.until(ExpectedConditions.visibilityOfElementLocated(PageObjects.feedbackHdr));
			WebElement feedHdr = driver.findElement(PageObjects.feedbackHdr);
			if(feedHdr.isDisplayed()) {
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Feedback PopUp Opended After Clicing on Feedback Button");
			}else {
				SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Feedback PopUp Not Opended After Clicing on Feedback Button");
			}

			String expFeeHdr = "We appreciate you taking time for the Feedback!";
			String actFeedHdr = feedHdr.getText();
			if(actFeedHdr.equalsIgnoreCase(expFeeHdr)) {
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Correct Header Displayed in Feedback PopUp: "+actFeedHdr);
			}else {
				SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Incorrect Header Displayed in Feedback PopUp: "+actFeedHdr);
			}
			wait.until(ExpectedConditions.visibilityOfElementLocated(PageObjects.label1));
			WebElement label1 = driver.findElement(PageObjects.label1);
			String expLabel1 = "Please select the experience you would like to rate *";
			String actLabel1 = label1.getText();
			if(expLabel1.equalsIgnoreCase(actLabel1)) {
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Correct Label Displayed Above The Select Value Dropdown: "+actLabel1);
			}else {
				SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Incorrect Label Displayed Above The Select Value Dropdown: "+actLabel1);
			}

			WebElement expDropdown = driver.findElement(PageObjects.expDrpDown);
			if(expDropdown.isDisplayed()) {
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Experience Dropdown is Displayed Below the Label");
			}else {
				SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Experience Dropdown is Not Displayed Below the Label");
			}
			expDropdown.click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(PageObjects.featuresList));
			WebElement expList = driver.findElement(PageObjects.featuresList);
			if(expList.isDisplayed()) {
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "List of Features Displayed after Clicking on Dropdown ");
			}else {
				SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "List of Features Not Displayed after Clicking on Dropdown ");
			}
			expList.click();
			if(driver.findElement(PageObjects.selectedFeature).isDisplayed()) {
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Selected Feature Disaplyed in Dropdown");
			}else {
				SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Selected Feature Not Disaplyed in Dropdown");
			}

			WebElement label2 = driver.findElement(PageObjects.label2);
			String expLabel2 = "Please rate the experience in the scale of 1 to 5 *";
			String actLabel2 = label2.getText();
			if(expLabel2.equalsIgnoreCase(actLabel2)) {
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Correct Label Displayed Above the Start Ratings: "+actLabel2);
			}else {
				SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Incorrect Label Displayed Above the Start Ratings: "+actLabel2);
			}

			WebElement rating = driver.findElement(PageObjects.starRatingAll);
			if(rating.isDisplayed()) {
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Star Rating Displayed in Feedback PopUp");
			}else {
				SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Star Rating Not Displayed in Feedback PopUp");
			}
			driver.findElement(PageObjects.singleStar).click();

			WebElement label3 = driver.findElement(PageObjects.label3);
			String expLabel3 = "Add Comments *";
			String actLabel3 = label3.getText();
			if(expLabel3.equalsIgnoreCase(actLabel3)) {
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Correct Label Displayed Above the Feedback Textbox: "+actLabel3);
			}else {
				SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Incorrect Label Displayed Above the Feedback Textbox: "+actLabel3);
			}

			WebElement feedTextbox = driver.findElement(PageObjects.feedbackInput);
			if(feedTextbox.isDisplayed()) {
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Textbox is Displayed in Feedback PopUp for User Input");
			}else {
				SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Textbox is Not Displayed in Feedback PopUp for User Input");
			}
			feedTextbox.sendKeys("Testing user input for feedback textbox");

			WebElement charLimit = driver.findElement(PageObjects.charLimit);
			js.executeScript("arguments[0].scrollIntoView();", charLimit);
			String chrLimitStr = charLimit.getText();
			if(charLimit.isDisplayed() && chrLimitStr.contains("Characters")) {
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Character Limit Text is Displlayed Below the Textbox: "+chrLimitStr);
			}else {
				SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Character Limit Text is Not Displlayed Below the Textbox: "+chrLimitStr);
			}

			WebElement submitBtn = driver.findElement(PageObjects.submitBtn);
			if(submitBtn.isDisplayed()) {
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Submit Buttton is Displayed in Feedback PopUp");
			}else {
				SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Submit Buttton is Not Displayed in Feedback PopUp");
			}

			WebElement cancelBtn = driver.findElement(PageObjects.submitBtn);
			if(cancelBtn.isDisplayed()) {
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Cancel Buttton is Displayed in Feedback PopUp");
			}else {
				SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Cancel Buttton is Not Displayed in Feedback PopUp");
			}

			submitBtn.click();

			wait.until(ExpectedConditions.visibilityOfElementLocated(PageObjects.confHeader));
			wait.until(ExpectedConditions.visibilityOfElementLocated(PageObjects.confMsg));
			WebElement confPopup = driver.findElement(PageObjects.confHeader);
			if(confPopup.isDisplayed()) {
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Confirmation PopUp Displayed Post Submitting the Feedback");
			}else {
				SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Confirmation PopUp Not Displayed Post Submitting the Feedback");
			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(PageObjects.confMsg));
			Thread.sleep(1000);			
			WebElement confMsg = driver.findElement(PageObjects.confMsg);
			String expConMsg = "Thank you";
			String actConMsg = confMsg.getText();
			if(confMsg.isDisplayed() && actConMsg.contains(expConMsg))
			{
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Correct Text is Displayed in Confirmation PopUp");
			}else 
			{
				SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Inorrect Text is Displayed in Confirmation PopUp");
			}
			
			if(confMsg.isDisplayed()) 
			{
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Confirmation PopUp Closed Post Clicking on Close Icon");
			}else 
			{
				SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Confirmation PopUp Not Closed Post Clicking on Close Icon");
			}
			driver.findElement(PageObjects.confCloseBtn).click();

		} catch (Exception e) {
			System.out.println(e);
			SmokeTest_GetExtentReports.Exception(driver, SmokeTest_test, e);
		}
	}


	public static void skillProfileSectionValidation(WebDriver driver, ExtentTest SmokeTest_test,ExtentReports SmokeTest_report ) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(500));
			JavascriptExecutor js = (JavascriptExecutor) driver; 
			/*
			if(currentUrl.equalsIgnoreCase(prop.getProperty("Main_Url"))){
				System.out.println("Navigated to Correct URL"); }else {
					System.out.println("Navigated to Old URL, Navigating again");
					driver.get(prop.getProperty("Main_Url")); } Thread.sleep(3000);
			 */

			/*if(driver.findElements(PageObjects.webNavigationClose).size()!=0) {
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Welcome PopUp Displayed in Landing Page");
				driver.findElement(PageObjects.webNavigationClose).click();
			}else {
				SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Welcome PopUp Not Displayed in Landing Page");
			}*/

			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(PageObjects.userIcon));
			if(driver.findElement(PageObjects.userIcon).isDisplayed()) {
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "User Icon Displayed inside Skill Profile Section in Landing Page");
			}else {
				SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "User Icon Not Displayed inside Skill Profile Section in Landing Page");
			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(PageObjects.skillProfileHeader));
			if(driver.findElement(PageObjects.skillProfileHeader).isDisplayed()) {
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Skill Profile Header Section is Displayed in Landing Page");
			}else {
				SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Skill Profile Header Section is Not Displayed in Landing Page");
			}
/*
			wait.until(ExpectedConditions.visibilityOfElementLocated(PageObjects.plusIcon));
			if(driver.findElement(PageObjects.plusIcon).isDisplayed()) {
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Plus Icon is Displayed Skill Profile Section in Landing Page");
			}else {
				SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Plus Icon is Not Displayed Skill Profile Section in Landing Page");
			}*/

			wait.until(ExpectedConditions.visibilityOfElementLocated(PageObjects.primarySkillTag));
			if(driver.findElement(PageObjects.primarySkillTag).isDisplayed()) {
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Primary Skill Tag is Displayed Inside Primary Skill Card");
			}else {
				SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Primary Skill Tag is Not Displayed Inside Primary Skill Card");
			}

			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(PageObjects.primarySkillName));
			if(driver.findElement(PageObjects.primarySkillName).isDisplayed()) {
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Primary Skill Name is Displayed inside Primary Skill Card");
			}else {
				SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Primary Skill Name is Not Displayed inside Primary Skill Card");
			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(PageObjects.primaryProf));
			if(driver.findElement(PageObjects.primaryProf).isDisplayed()) {
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Primary Skill Proficiency is Displayed inside Primary Skill Card");
			}else {
				SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Primary Skill Proficiency is Not Displayed inside Primary Skill Card");
			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(PageObjects.secSkillName1));
			if(driver.findElement(PageObjects.secSkillName1).isDisplayed()) {
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Secondary Skill Name is Displayed inside First Secondary Skill Card");
			}else {
				SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Secondary Skill Name is Not Displayed inside First Secondary Skill Card");
			}

			WebElement secondSecSkill = driver.findElement(PageObjects.secSkillName2);
			js.executeScript("arguments[0].scrollIntoView();", secondSecSkill);
			wait.until(ExpectedConditions.visibilityOfElementLocated(PageObjects.secSkillProf1));
			if(driver.findElement(PageObjects.secSkillProf1).isDisplayed()) {
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Secondary Skill Proficiency is Displayed inside First Secondary Skill Card");
			}else {
				SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Secondary Skill Proficiency is Not Displayed inside First Secondary Skill Card");
			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(PageObjects.secSkillName2));
			if(driver.findElement(PageObjects.secSkillName2).isDisplayed()) {
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Secondary Skill Name is Displayed inside Second Secondary Skill Card");
			}else {
				SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Secondary Skill Name is Not Displayed inside Second Secondary Skill Card");
			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(PageObjects.secSkillProf2));
			if(driver.findElement(PageObjects.secSkillProf2).isDisplayed()) {
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Secondary Skill Proficiency is Displayed inside Second Secondary Skill Card");
			}else {
				SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Secondary Skill Proficiency is Not Displayed inside Second Secondary Skill Card");
			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(PageObjects.skillCountText));
			if(driver.findElement(PageObjects.skillCountText).isDisplayed()) {
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Skill Count Text is Displayed Below the Seconday Skill Card");
			}else {
				SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Skill Count Text is Not Displayed Below the Seconday Skill Card");
			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(PageObjects.seeAllSkills));
			if(driver.findElement(PageObjects.seeAllSkills).isDisplayed()) {
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "See all Skills Link is Displayed Below the Seconday Skill Card");
			}else {
				SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "See all Skills Link is Not Displayed Below the Seconday Skill Card");
			}
		}
		catch(Exception e) {
			System.out.println(e);
			SmokeTest_GetExtentReports.Exception(driver, SmokeTest_test, e);
		}
	}
	
	public static void QuickLinksSectionValidation(WebDriver driver, ExtentTest SmokeTest_test,ExtentReports LPVTest_report ) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(500));
			JavascriptExecutor js = (JavascriptExecutor) driver; 

			//String currentUrl = driver.getCurrentUrl();

			/*if(currentUrl.equalsIgnoreCase(prop.getProperty("Main_Url"))){
				System.out.println("Navigated to Correct URL");
			}else {
				System.out.println("Navigated to Incorrect URL, Navigating again");
				driver.get(prop.getProperty("Main_Url"));
			}*/
			Thread.sleep(3000);
/*
			if(driver.findElements(PageObjects.webNavigationClose).size()!=0) {
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Welcome PopUp Displayed in Landing Page");
				driver.findElement(PageObjects.webNavigationClose).click();
			}else {
				SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Welcome PopUp Not Displayed in Landing Page");
			}*/

			wait.until(ExpectedConditions.visibilityOfElementLocated(PageObjects.SCLink));
			if(driver.findElement(PageObjects.SCLink).isDisplayed()) {
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Change Primary Skill Link is Displyaed in Quick Links Section");
				//js.executeScript("arguments[0].setAttribute('style', 'border:2px solid red; background:yellow')", driver.findElement(PageObjects.firstLink));

			}else {
				SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Change Primary Skill Link is Not Displyaed in Quick Links Section");
			}
			
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(PageObjects.firstLink));
			if(driver.findElement(PageObjects.firstLink).isDisplayed()) {
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Add Secondary Skill Link is Displyaed in Quick Links Section");
				//js.executeScript("arguments[0].setAttribute('style', 'border:2px solid red; background:yellow')", driver.findElement(PageObjects.firstLink));

			}else {
				SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Add Secondary Skill Link is Not Displyaed in Quick Links Section");
			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(PageObjects.secondLink));
			if(driver.findElement(PageObjects.secondLink).isDisplayed()) {
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Certification Road Map Link is Displyaed in Quick Links Section");
			}else {
				SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Certification Road Map Link is Not Displyaed in Quick Links Section");
			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(PageObjects.secondLink));
			if(driver.findElement(PageObjects.secondLink).isDisplayed()) {
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Expert List Link is Displyaed in Quick Links Section");
			}else {
				SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Expert List Link is Not Displyaed in Quick Links Section");
			}
		}
		catch(Exception e) {
			System.out.println(e);
			SmokeTest_GetExtentReports.Exception(driver, SmokeTest_test, e);
		}
	}

	public static void getToKnowMyCompAndSAGValidation(WebDriver driver, ExtentTest SmokeTest_test,ExtentReports SmokeTest_report ) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(500));
			JavascriptExecutor js = (JavascriptExecutor) driver; 

			/* String currentUrl = driver.getCurrentUrl();

			   if(currentUrl.equalsIgnoreCase(prop.getProperty("Main_Url"))){
			   System.out.println("Navigated to Correct URL"); }else {
			   System.out.println("Navigated to Incorrect URL, Navigating again");
			   driver.get(prop.getProperty("Main_Url")); } Thread.sleep(3000);
			 

			if(driver.findElements(PageObjects.webNavigationClose).size()!=0) {
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Welcome PopUp Displayed in Landing Page");
				driver.findElement(PageObjects.webNavigationClose).click();
			}else {
				SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Welcome PopUp Not Displayed in Landing Page");
			}*/

			wait.until(ExpectedConditions.visibilityOfElementLocated(PageObjects.aboutHeader));
			WebElement aboutHeader = driver.findElement(PageObjects.aboutHeader);
			if(aboutHeader.isDisplayed()) {
				js.executeScript("arguments[0].scrollIntoView();", aboutHeader); 
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Know About MyCompetency is Displyaed in New Landing Page");
			}else {
				SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Know About MyCompetency is Displyaed in New Landing Page");
			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(PageObjects.firstVidCard));
			if(driver.findElement(PageObjects.firstVidCard).isDisplayed()) {
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "First Video is Displayed in Know About MyCompetency Section");
			}else {
				SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "First Video is Not Displayed in Know About MyCompetency Section");
			}


			/*wait.until(ExpectedConditions.visibilityOfElementLocated(PageObjects.firstVidPlayBtn));
			if(driver.findElement(PageObjects.firstVidPlayBtn).isDisplayed()) { 
				SmokeTest_GetExtentReports.PassTest(driver,SmokeTest_test, "Play Button is Displayed inside First Video"); 
			}else {
				SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test,"Play Button is NotDisplayed inside First Video");
			}*/

			wait.until(ExpectedConditions.visibilityOfElementLocated(PageObjects.secondVidCard));
			if(driver.findElement(PageObjects.secondVidCard).isDisplayed()) {
				SmokeTest_GetExtentReports.PassTest(driver,SmokeTest_test,"Second Video is Displayed in Know About MyCompetency Section"); }else {
					SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test,"Second Video is Not Displayed in Know About MyCompetency Section"); }
/*
			wait.until(ExpectedConditions.visibilityOfElementLocated(PageObjects.secondVidPlayBtn));
			if(driver.findElement(PageObjects.secondVidPlayBtn).isDisplayed()) { SmokeTest_GetExtentReports.PassTest(driver,
					SmokeTest_test, "Play Button is Displayed inside Second Video"); 
			}else {
				SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test,"Play Button is NotDisplayed inside Second Video"); }
*/

			if(driver.findElements(PageObjects.SAGHeader).size()!=0) {
				//wait.until(ExpectedConditions.visibilityOfElementLocated(PageObjects.SAGHeader));
				if(driver.findElement(PageObjects.SAGHeader).isDisplayed()) {
					SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Skill Accelerater Guidance Section is Displyaed in New Landing Page");
				}else {
					SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Skill Accelerater Guidance Section is Not Displyaed in New Landing Page");
				}

				wait.until(ExpectedConditions.visibilityOfElementLocated(PageObjects.viewMoreBtn));
				if(driver.findElement(PageObjects.viewMoreBtn).isDisplayed()) {
					SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "View More Button is Displayed in SAG Section");
				}else {
					SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "View More Button is Not Displayed in SAG Section");
				}
			}else {
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Employee Don't Have Recommended Skills");
			}
		}
		catch(Exception e) {
			SmokeTest_GetExtentReports.Exception(driver, SmokeTest_test, e);
			System.out.println(e);
		}
	}
	
	 public static void CentrePaletteValidation(WebDriver driver, ExtentTest SmokeTest_test, ExtentReports LPVTest_report) 
	 
	 {
		// TODO Auto-generated method stub
		 
		
		 
		 try {
			    
			    Properties prop = PropertyfileConfig.Propertyfile();
			   
			    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(50));
			   /* wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PageObjects.JumptoTop)));
				WebElement JumpToTop = driver.findElement(By.xpath(PageObjects.JumptoTop));
				JumpToTop.click();
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "JumpToTop is displayed in the New Landing Page");
				
				JumpToTop.click();
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "JumpToTop is clicked in the New Landing Page");
				*/
			   
			    //driver.findElement(PageObjects.webNavigationClose).click();
			    /*WebElement Click = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PageObjects.BannerOK)));
			    Click.click();
				Thread.sleep(3000);*/
			    
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PageObjects.Carousel)));
				WebElement Carousel = driver.findElement(By.xpath(PageObjects.Carousel));
				Thread.sleep(3000);
				
				if (Carousel.isDisplayed())
				{
					SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Carousel is displayed in the New Landing Page");
				}
				else
				{
					SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Carousel is not displayed in the New Landing Page");
	 
				}
				
				Thread.sleep(1000);
				WebElement Learnmore =driver.findElement(By.xpath(PageObjects.Learnmore));
				
				if (Learnmore.isDisplayed())
				{
					SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Learnmore Button is displayed in the New Landing Page");
				}
				else
				{
					SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Learnmore Button is not displayed in the New Landing Page");
	 
				}
			} 

		catch (Exception E) 
		{
			//SmokeTest_GetExtentReports.Exception(driver, SmokeTest_test, E);
			getResult(E, driver, SmokeTest_test);
		}
	 }
	 
	 public static void Widget1Validation(WebDriver driver, ExtentTest SmokeTest_test, ExtentReports LPVTest_report) 

	 {
	 	
	 	 try {
	 		    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(100));
	 		   
	 			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PageObjects.Widget1Box)));
	 			WebElement Widget1Box = driver.findElement(By.xpath(PageObjects.Widget1Box));
	 			if (Widget1Box.isDisplayed())
	 			{
	 				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test,"Widget1Box is displayed in the New Landing Page");
	 			}
	 			else
	 			{
	 				SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Widget1Box is not displayed in the New Landing Page");
	  
	 			}
	 			
	 			Thread.sleep(1000);
	 			WebElement Widget1Text =driver.findElement(By.xpath(PageObjects.Widget1Text));
	 			if (Widget1Text.isDisplayed())
	 			{
	 				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test,"Widget1Text is displayed in the New Landing Page");
	 			}
	 			else
	 			{
	 				SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Widget1Text is not displayed in the New Landing Page");
	  
	 			}
	 			

	 			Thread.sleep(500);
	 			WebElement Widget1Arrow =driver.findElement(By.xpath(PageObjects.Widget1Arrow));
	 			if (Widget1Arrow.isDisplayed())
	 			{
	 				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test,"Widget1Arrow is displayed in the New Landing Page");
	 			}
	 			else
	 			{
	 				SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Widget1Arrow is not displayed in the New Landing Page");
	  
	 			}
	 			
	 			
	 			
	 	// TODO Auto-generated method stub
	 	
	         }
	 	 

	 		catch (Exception E) 
	 		{
	 			//SmokeTest_GetExtentReports.Exception(driver, SmokeTest_test, E);
	 			getResult(E, driver, SmokeTest_test);
	 		}
	 }
	 

public static void Widget2Validation(WebDriver driver, ExtentTest SmokeTest_test, ExtentReports LPVTest_report) 

{
	
	 try {
		    Properties prop = PropertyfileConfig.Propertyfile();
		   /* String CurrentUrl = driver.getCurrentUrl();
		    if(CurrentUrl.equalsIgnoreCase(prop.getProperty("Main_Url"))) {
		    	System.out.println("Navigated to Correct URL");
		    }
		    else {
		    	System.out.println("Navigated to InCorrect URL,Navigate again!");
		    	driver.get(prop.getProperty("Main_Url"));
		    }
		    
		    if(driver.findElements(PageObjects.webNavigationClose).size()!=0) {
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Welcome PopUp Displayed in Landing Page");
				driver.findElement(PageObjects.webNavigationClose).click();
			}else {
				SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Welcome PopUp Not Displayed in Landing Page");
			}*/
		 
		    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(100));
		   /* WebElement Click = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PageObjects.BannerOK)));
		    Click.click();
			Thread.sleep(3000);*/
					    
		    JavascriptExecutor JS = (JavascriptExecutor) driver;
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PageObjects.Widget2Box)));
			WebElement Widget2Box = driver.findElement(By.xpath(PageObjects.Widget2Box));
			JS.executeScript("arguments[0].scrollIntoView(true);", Widget2Box);
			if (Widget2Box.isDisplayed())
			{
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test,"Widget2Box is displayed in the New Landing Page");
			}
			else
			{
				SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Widget2Box is not displayed in the New Landing Page");

			}
			
			Thread.sleep(1000);
			
			WebElement Widget2Text = driver.findElement(By.xpath(PageObjects.Widget2Text));
			if (Widget2Text.isDisplayed())
			{
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test,"Widget2Text is displayed in the New Landing Page");
			}
			else
			{
				SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Widget2Text is not displayed in the New Landing Page");

			}
			
			Thread.sleep(1000);
			
			WebElement Widget2Button = driver.findElement(By.xpath(PageObjects.Widget2Button));
			if (Widget2Button.isDisplayed())
			{
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test,"Widget2Button is displayed in the New Landing Page");
			}
			else
			{
				SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Widget2Button is not displayed in the New Landing Page");

			}
			
			Thread.sleep(1000);
	
			WebElement Widget2ButtonText = driver.findElement(By.xpath(PageObjects.Widget2ButtonText));
			if (Widget2ButtonText.isDisplayed())
			{
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test,"Widget2ButtonText is displayed in the New Landing Page");
			}
			else
			{
				SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Widget2ButtonText is not displayed in the New Landing Page");

			}
			
			Thread.sleep(1000);
			
	 }

	 
	 catch (Exception E) 
		{
			//SmokeTest_GetExtentReports.Exception(driver, SmokeTest_test, E);
			getResult(E, driver, SmokeTest_test);
		}

	 }

public static void Widget3Validation(WebDriver driver, ExtentTest SmokeTest_test, ExtentReports LPVTest_report) 

{
	 try {
		    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		    
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PageObjects.Widget3BoxText)));
			WebElement Widget3BoxText = driver.findElement(By.xpath(PageObjects.Widget2Box));
			if (Widget3BoxText.isDisplayed())
			{
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test,"Widget3BoxText is displayed in the New Landing Page");
			}
			else
			{
				SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Widget3BoxText is not displayed in the New Landing Page");

			}
	 }

	 
	 catch (Exception E) 
		{
			//SmokeTest_GetExtentReports.Exception(driver, SmokeTest_test, E);
			getResult(E, driver, SmokeTest_test);
		}

	 }



}


