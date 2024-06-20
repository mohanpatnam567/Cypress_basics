package LandingPageValidation;



import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import CommonMethods.PropertyfileConfig;


public class LandingPageValidation_CommonMethods {
	static Properties prop = PropertyfileConfig.Propertyfile();
	public static void getResult(java.lang.Exception E, WebDriver driver, ExtentTest LPVTest_test) {
		String error = E.toString();


		System.out.println("\n" + "************************************************************" + "\n");
		System.out.println(error);
		if (error.contains("NoSuchElementException") || error.contains("NotFoundException")
				|| error.contains("WebDriverException")) {
			LPVTest_test.log(Status.FAIL, "Test case failed due to the " + error);
			LPVTest_test.log(Status.FAIL, "Category : Invalid Locator/webpage is still loading");
		} else if (error.contains("StaleElementReferenceException")) {
			LPVTest_test.log(Status.FAIL, "Test case failed due to the " + error);
			LPVTest_test.log(Status.FAIL, "Category : Page Loaded/Refreshed");
		} else if (error.contains("MoveTargetOutOfBoundsException")) {
			LPVTest_test.log(Status.FAIL, "Test case failed due to the " + error);
			LPVTest_test.log(Status.FAIL, "Category : ActionsChains move() method is invalid");
		} else if (error.contains("NoSuchFrameException") || error.contains("NoSuchWindowException")
				|| error.contains("InvalidSwitchToTargetException")) {
			LPVTest_test.log(Status.FAIL, "Test case failed due to the " + error);
			LPVTest_test.log(Status.FAIL, "Category :  Frame or Window target to be switched doesn’t exist");
		} else if (error.contains("NoAlertPresentException")) {
			LPVTest_test.log(Status.FAIL, "Test case failed due to the " + error);
			LPVTest_test.log(Status.FAIL, "Category : Alert doesn’t exist or is not available");
		} else if (error.contains("UnexpectedAlertPresentException") || error.contains("UnhandledAlertException")) {
			LPVTest_test.log(Status.FAIL, "Test case failed due to the " + error);
			LPVTest_test.log(Status.FAIL, "Category : unexpected alert open");
		} else if (error.contains("ElementNotVisibleException")) {
			LPVTest_test.log(Status.FAIL, "Test case failed due to the " + error);
			LPVTest_test.log(Status.FAIL, "Category : Page not loaded/Element is hidden");
		} else if (error.contains("ElementNotSelectableException")) {
			LPVTest_test.log(Status.FAIL, "Test case failed due to the " + error);
			LPVTest_test.log(Status.FAIL, "Category : Element is disabled/can not be clicked/selected");
		} else if (error.contains("TimeoutException")) {
			LPVTest_test.log(Status.FAIL, "Test case failed due to the " + error);
			LPVTest_test.log(Status.FAIL,
					"Category : Page not loaded/Search operation finished before element loaded");
		} else if (error.contains("NoSuchSessionException")) {
			LPVTest_test.log(Status.FAIL, "Test case failed due to the " + error);
			LPVTest_test.log(Status.FAIL, "Category : Browser Closed/Quitted");
		} else if (error.contains("NoSuchAttributeException")) {
			LPVTest_test.log(Status.FAIL, "Test case failed due to the " + error);
			LPVTest_test.log(Status.FAIL, "Category : Attribute of element could not be found");
		} else if (error.contains("ScreenshotException")) {
			LPVTest_test.log(Status.FAIL, "Test case failed due to the " + error);
			LPVTest_test.log(Status.FAIL, "Category : A screen capture was made impossible");
		} else {
			System.out.println("Inside the Else");
			LPVTest_test.log(Status.FAIL, E);
		}

	}

	public static void NextUserLogin_Stage(WebDriver driver)
	{
		driver.findElement(By.xpath(LandingPageValidation_PageObjects.NewUser)).click();
	}

	public static void MicrosoftStaySignedInPage(WebDriver driver,ExtentTest LPVTest_test , ExtentReports BATest_report,String currentURL)
	{
		try 
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LandingPageValidation_PageObjects.StaySignedIn)));
			Thread.sleep(1000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(LandingPageValidation_PageObjects.StaySignedInNo)));
			driver.findElement(By.id(LandingPageValidation_PageObjects.StaySignedInNo)).click();
			Thread.sleep(2000);	
		}
		catch (Exception E) 
		{
			//LandingPageValidation_GetExtentReports.Exception(driver, LPVTest_test, E);
			getResult(E, driver, LPVTest_test);
		}
	}

	public static void MicrosoftSignCheck(WebDriver driver, ExtentTest LPVTest_test,ExtentReports BATest_report, String Admin_login) 

	{
		Properties prop = PropertyfileConfig.Propertyfile();

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(LandingPageValidation_PageObjects.EmailField)));
			Thread.sleep(3000);
			driver.findElement(By.cssSelector(LandingPageValidation_PageObjects.EmailField)).sendKeys(prop.getProperty(Admin_login));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(LandingPageValidation_PageObjects.NextField)));
			driver.findElement(By.cssSelector(LandingPageValidation_PageObjects.NextField)).click();
			System.out.println("Navigated to ESO Account Login Page");
			Thread.sleep(5000);
		} 

		catch (Exception E) 
		{
			//LandingPageValidation_GetExtentReports.Exception(driver, LPVTest_test, E);
			getResult(E, driver, LPVTest_test);
		}

	}

	public static void CentrePaletteValidation(WebDriver driver, ExtentTest LPVTest_test, ExtentReports LPVTest_report) 

	{
		// TODO Auto-generated method stub



		try {

			Properties prop = PropertyfileConfig.Propertyfile();

			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(50));
			/* wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PageObjects.JumptoTop)));
				WebElement JumpToTop = driver.findElement(By.xpath(PageObjects.JumptoTop));
				JumpToTop.click();
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "JumpToTop is displayed in the New Landing Page");

				JumpToTop.click();
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "JumpToTop is clicked in the New Landing Page");
			 */

			//driver.findElement(PageObjects.webNavigationClose).click();
			//			WebElement Click = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LandingPageValidation_PageObjects.BannerOK)));
			//			    Click.click();
			//				Thread.sleep(3000);

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LandingPageValidation_PageObjects.Carousel)));
			WebElement Carousel = driver.findElement(By.xpath(LandingPageValidation_PageObjects.Carousel));
			Thread.sleep(3000);

			if (Carousel.isDisplayed())
			{
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "Carousel is displayed in the New Landing Page");
			}
			else
			{
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "Carousel is not displayed in the New Landing Page");

			}

			Thread.sleep(1000);
			WebElement Learnmore =driver.findElement(By.xpath(LandingPageValidation_PageObjects.Learnmore));

			if (Learnmore.isDisplayed())
			{
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "Learnmore Button is displayed in the New Landing Page");
			}
			else
			{
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "Learnmore Button is not displayed in the New Landing Page");

			}
		} 

		catch (Exception E) 
		{
			//LandingPageValidation_GetExtentReports.Exception(driver, LPVTest_test, E);
			getResult(E, driver, LPVTest_test);
		}
	}

	public static void Widget1Validation(WebDriver driver, ExtentTest LPVTest_test, ExtentReports LPVTest_report) 

	{

		try {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(100));

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LandingPageValidation_PageObjects.Widget1Box)));
			WebElement Widget1Box = driver.findElement(By.xpath(LandingPageValidation_PageObjects.Widget1Box));
			if (Widget1Box.isDisplayed())
			{
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test,"Widget1Box is displayed in the New Landing Page");
			}
			else
			{
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "Widget1Box is not displayed in the New Landing Page");

			}

			Thread.sleep(1000);
			WebElement Widget1Text =driver.findElement(By.xpath(LandingPageValidation_PageObjects.Widget1Text));
			if (Widget1Text.isDisplayed())
			{
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test,"Widget1Text is displayed in the New Landing Page");
			}
			else
			{
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "Widget1Text is not displayed in the New Landing Page");

			}


			Thread.sleep(500);
			WebElement Widget1Arrow =driver.findElement(By.xpath(LandingPageValidation_PageObjects.Widget1Arrow));
			if (Widget1Arrow.isDisplayed())
			{
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test,"Widget1Arrow is displayed in the New Landing Page");
			}
			else
			{
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "Widget1Arrow is not displayed in the New Landing Page");

			}



			// TODO Auto-generated method stub

		}


		catch (Exception E) 
		{
			//LandingPageValidation_GetExtentReports.Exception(driver, LPVTest_test, E);
			getResult(E, driver, LPVTest_test);
		}
	}

	public static void Widget2Validation(WebDriver driver, ExtentTest LPVTest_test, ExtentReports LPVTest_report) 

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
	 				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "Welcome PopUp Displayed in Landing Page");
	 				driver.findElement(PageObjects.webNavigationClose).click();
	 			}else {
	 				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "Welcome PopUp Not Displayed in Landing Page");
	 			}*/

			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(100));
			/* WebElement Click = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PageObjects.BannerOK)));
	 		    Click.click();
	 			Thread.sleep(3000);*/

			JavascriptExecutor JS = (JavascriptExecutor) driver;
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LandingPageValidation_PageObjects.Widget2Box)));
			WebElement Widget2Box = driver.findElement(By.xpath(LandingPageValidation_PageObjects.Widget2Box));
			JS.executeScript("arguments[0].scrollIntoView(true);", Widget2Box);
			if (Widget2Box.isDisplayed())
			{
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test,"Widget2Box is displayed in the New Landing Page");
			}
			else
			{
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "Widget2Box is not displayed in the New Landing Page");

			}

			Thread.sleep(1000);

			WebElement Widget2Text = driver.findElement(By.xpath(LandingPageValidation_PageObjects.Widget2Text));
			if (Widget2Text.isDisplayed())
			{
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test,"Widget2Text is displayed in the New Landing Page");
			}
			else
			{
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "Widget2Text is not displayed in the New Landing Page");

			}

			Thread.sleep(1000);

			WebElement Widget2Button = driver.findElement(By.xpath(LandingPageValidation_PageObjects.Widget2Button));
			if (Widget2Button.isDisplayed())
			{
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test,"Widget2Button is displayed in the New Landing Page");
			}
			else
			{
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "Widget2Button is not displayed in the New Landing Page");

			}

			Thread.sleep(1000);

			WebElement Widget2ButtonText = driver.findElement(By.xpath(LandingPageValidation_PageObjects.Widget2ButtonText));
			if (Widget2ButtonText.isDisplayed())
			{
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test,"Widget2ButtonText is displayed in the New Landing Page");
			}
			else
			{
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "Widget2ButtonText is not displayed in the New Landing Page");

			}

			Thread.sleep(1000);

		}


		catch (Exception E) 
		{
			//LandingPageValidation_GetExtentReports.Exception(driver, LPVTest_test, E);
			getResult(E, driver, LPVTest_test);
		}

	}

	public static void Widget3Validation(WebDriver driver, ExtentTest LPVTest_test, ExtentReports LPVTest_report) 

	{
		try {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LandingPageValidation_PageObjects.Widget3BoxText)));
			WebElement Widget3BoxText = driver.findElement(By.xpath(LandingPageValidation_PageObjects.Widget2Box));
			if (Widget3BoxText.isDisplayed())
			{
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test,"Widget3BoxText is displayed in the New Landing Page");
			}
			else
			{
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "Widget3BoxText is not displayed in the New Landing Page");

			}
		}


		catch (Exception E) 
		{
			//LandingPageValidation_GetExtentReports.Exception(driver, LPVTest_test, E);
			getResult(E, driver, LPVTest_test);
		}

	}

	public static void Logoutsite(WebDriver driver, ExtentTest LPVTest_test, ExtentReports LPVTest_report) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			JavascriptExecutor Executor = (JavascriptExecutor) driver;

			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath(LandingPageValidation_PageObjects.HamMenuButtonXpath)));
			WebElement element = driver.findElement(By.xpath(LandingPageValidation_PageObjects.HamMenuButtonXpath));
			Executor.executeScript("arguments[0].click();", element);
			Thread.sleep(250);
			if (driver.findElements(By.xpath(LandingPageValidation_PageObjects.Logoutxpath)).size() != 0) {
				wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath(LandingPageValidation_PageObjects.Logoutxpath)));
				driver.findElement(By.xpath(LandingPageValidation_PageObjects.Logoutxpath)).click();
				Thread.sleep(2000);
				System.out.println("Successfully Logged Out");
			} else {
				wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath(LandingPageValidation_PageObjects.HamMenuButtonXpath)));
				WebElement element1 = driver.findElement(By.xpath(LandingPageValidation_PageObjects.HamMenuButtonXpath));
				Executor.executeScript("arguments[0].click();", element1);
				Thread.sleep(250);
				wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath(LandingPageValidation_PageObjects.Logoutxpath)));
				driver.findElement(By.xpath(LandingPageValidation_PageObjects.Logoutxpath)).click();
				Thread.sleep(2000);
				System.out.println("Successfully Logged Out");
			}

		} catch (Exception E) {
			getResult(E, driver, LPVTest_test);
		}
	}

	public static void RSM_Upload(WebDriver driver, ExtentTest LPVTest_test, ExtentReports LPVTest_report) {
		String Path = System.getProperty("user.dir") + "\\TestData\\Master Assessment\\Resource_Skill_Mapping.xlsx";
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			JavascriptExecutor Executor = (JavascriptExecutor) driver;
			LPVTest_report = LandingPageValidation_GetExtentReports.getReport();

			if(driver.findElements(LandingPageValidation_PageObjects.webNavigationClose).size()!=0) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "Welcome PopUp Displayed in Landing Page");
				driver.findElement(LandingPageValidation_PageObjects.webNavigationClose).click();
			}else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "Welcome PopUp Not Displayed in Landing Page");
			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LandingPageValidation_PageObjects.HamMenuButtonXpath)));
			WebElement element = driver.findElement(By.xpath(LandingPageValidation_PageObjects.HamMenuButtonXpath));
			Executor.executeScript("arguments[0].click();", element);
			Thread.sleep(250);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LandingPageValidation_PageObjects.AdminMenuXpathSelector)));
			WebElement AdminMenu = driver.findElement(By.xpath(LandingPageValidation_PageObjects.AdminMenuXpathSelector));

			if (AdminMenu.isDisplayed()) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test,"Admin Functions is displayed in the Admin Menu");
			} else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test,"Admin Functions is NOT displayed in the Admin Menu");
			}
			Executor.executeScript("arguments[0].click();", AdminMenu);
			WebElement UploadMenu = driver.findElement(By.xpath(LandingPageValidation_PageObjects.AdminMenuUploadXpathSelector));
			Executor.executeScript("arguments[0].scrollIntoView();", UploadMenu);
			UploadMenu.click();

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(LandingPageValidation_PageObjects.DropDownId)));
			WebElement DateDropdownMenu = driver.findElement(By.id(LandingPageValidation_PageObjects.DropDownId));
			Select DateDropdown = new Select(driver.findElement(By.id(LandingPageValidation_PageObjects.DropDownId)));
			DateDropdown.selectByValue("6");
			if (DateDropdownMenu.isDisplayed()) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test,
						"RSM DropDown is displayed in the Upload Page");
			} else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test,
						"RSM DropDown is NOT displayed in the Upload Page");
			}
			driver.findElement(By.id(LandingPageValidation_PageObjects.SearchButtonId)).click();
			Thread.sleep(2000);
			driver.findElement(By.cssSelector(LandingPageValidation_PageObjects.FileUploadButtonCssSelector)).sendKeys(Path);
			Thread.sleep(2000);
			driver.findElement(By.cssSelector(LandingPageValidation_PageObjects.UploadButtonCssSelector)).click();
			Thread.sleep(2000);
			wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.id(LandingPageValidation_PageObjects.ResultTableId)));
			String ErrorStatus = driver
					.findElement(By.cssSelector(LandingPageValidation_PageObjects.UploadErrorStatusCssSelector)).getText();
			//String Error = driver.findElement(By.cssSelector(LandingPageValidation_PageObjects.RSMUploadErrorCssSelector))
			//		.getText();
			if (ErrorStatus.contains("N")) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test,
						"RSM Upload is Successfull " + ErrorStatus);
			} else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test,
						"RSM Upload is NOT Successfull ");// + Error);
			}
			Thread.sleep(2000);
			WebElement element1 = driver
					.findElement(By.cssSelector(LandingPageValidation_PageObjects.OldHomePageLogoCssSelector));
			Executor.executeScript("arguments[0].click();", element1);
		} 
		catch (Exception E) {
			getResult(E, driver, LPVTest_test);
			LandingPageValidation_GetExtentReports.Exception(driver, LPVTest_test, E);
		}
	}

	public static void skillProfileSectionValidation(WebDriver driver, ExtentTest LPVTest_test,ExtentReports LPVTest_report ) {
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
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "Welcome PopUp Displayed in Landing Page");
				driver.findElement(PageObjects.webNavigationClose).click();
			}else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "Welcome PopUp Not Displayed in Landing Page");
			}*/

			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(LandingPageValidation_PageObjects.userIcon));
			if(driver.findElement(LandingPageValidation_PageObjects.userIcon).isDisplayed()) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "User Icon Displayed inside Skill Profile Section in Landing Page");
			}else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "User Icon Not Displayed inside Skill Profile Section in Landing Page");
			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(LandingPageValidation_PageObjects.skillProfileHeader));
			if(driver.findElement(LandingPageValidation_PageObjects.skillProfileHeader).isDisplayed()) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "Skill Profile Header Section is Displayed in Landing Page");
			}else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "Skill Profile Header Section is Not Displayed in Landing Page");
			}
			/*
			wait.until(ExpectedConditions.visibilityOfElementLocated(PageObjects.plusIcon));
			if(driver.findElement(PageObjects.plusIcon).isDisplayed()) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "Plus Icon is Displayed Skill Profile Section in Landing Page");
			}else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "Plus Icon is Not Displayed Skill Profile Section in Landing Page");
			}*/

			wait.until(ExpectedConditions.visibilityOfElementLocated(LandingPageValidation_PageObjects.primarySkillTag));
			if(driver.findElement(LandingPageValidation_PageObjects.primarySkillTag).isDisplayed()) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "Primary Skill Tag is Displayed Inside Primary Skill Card");
			}else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "Primary Skill Tag is Not Displayed Inside Primary Skill Card");
			}

			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(LandingPageValidation_PageObjects.primarySkillName));
			if(driver.findElement(LandingPageValidation_PageObjects.primarySkillName).isDisplayed()) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "Primary Skill Name is Displayed inside Primary Skill Card");
			}else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "Primary Skill Name is Not Displayed inside Primary Skill Card");
			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(LandingPageValidation_PageObjects.primaryProf));
			if(driver.findElement(LandingPageValidation_PageObjects.primaryProf).isDisplayed()) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "Primary Skill Proficiency is Displayed inside Primary Skill Card");
			}else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "Primary Skill Proficiency is Not Displayed inside Primary Skill Card");
			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(LandingPageValidation_PageObjects.secSkillName1));
			if(driver.findElement(LandingPageValidation_PageObjects.secSkillName1).isDisplayed()) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "Secondary Skill Name is Displayed inside First Secondary Skill Card");
			}else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "Secondary Skill Name is Not Displayed inside First Secondary Skill Card");
			}

			WebElement secondSecSkill = driver.findElement(LandingPageValidation_PageObjects.secSkillName2);
			js.executeScript("arguments[0].scrollIntoView();", secondSecSkill);
			wait.until(ExpectedConditions.visibilityOfElementLocated(LandingPageValidation_PageObjects.secSkillProf1));
			if(driver.findElement(LandingPageValidation_PageObjects.secSkillProf1).isDisplayed()) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "Secondary Skill Proficiency is Displayed inside First Secondary Skill Card");
			}else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "Secondary Skill Proficiency is Not Displayed inside First Secondary Skill Card");
			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(LandingPageValidation_PageObjects.secSkillName2));
			if(driver.findElement(LandingPageValidation_PageObjects.secSkillName2).isDisplayed()) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "Secondary Skill Name is Displayed inside Second Secondary Skill Card");
			}else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "Secondary Skill Name is Not Displayed inside Second Secondary Skill Card");
			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(LandingPageValidation_PageObjects.secSkillProf2));
			if(driver.findElement(LandingPageValidation_PageObjects.secSkillProf2).isDisplayed()) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "Secondary Skill Proficiency is Displayed inside Second Secondary Skill Card");
			}else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "Secondary Skill Proficiency is Not Displayed inside Second Secondary Skill Card");
			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(LandingPageValidation_PageObjects.skillCountText));
			if(driver.findElement(LandingPageValidation_PageObjects.skillCountText).isDisplayed()) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "Skill Count Text is Displayed Below the Seconday Skill Card");
			}else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "Skill Count Text is Not Displayed Below the Seconday Skill Card");
			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(LandingPageValidation_PageObjects.seeAllSkills));
			if(driver.findElement(LandingPageValidation_PageObjects.seeAllSkills).isDisplayed()) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "See all Skills Link is Displayed Below the Seconday Skill Card");
			}else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "See all Skills Link is Not Displayed Below the Seconday Skill Card");
			}
		}
		catch(Exception e) {
			System.out.println(e);
			LandingPageValidation_GetExtentReports.Exception(driver, LPVTest_test, e);
		}
	}

	public static void QuickLinksSectionValidation(WebDriver driver, ExtentTest LPVTest_test,ExtentReports LPVTest_report ) {
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
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "Welcome PopUp Displayed in Landing Page");
				driver.findElement(PageObjects.webNavigationClose).click();
			}else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "Welcome PopUp Not Displayed in Landing Page");
			}*/

			wait.until(ExpectedConditions.visibilityOfElementLocated(LandingPageValidation_PageObjects.SCLink));
			if(driver.findElement(LandingPageValidation_PageObjects.SCLink).isDisplayed()) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "Change Primary Skill Link is Displyaed in Quick Links Section");
				//js.executeScript("arguments[0].setAttribute('style', 'border:2px solid red; background:yellow')", driver.findElement(PageObjects.firstLink));

			}else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "Change Primary Skill Link is Not Displyaed in Quick Links Section");
			}


			wait.until(ExpectedConditions.visibilityOfElementLocated(LandingPageValidation_PageObjects.firstLink));
			if(driver.findElement(LandingPageValidation_PageObjects.firstLink).isDisplayed()) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "Add Secondary Skill Link is Displyaed in Quick Links Section");
				//js.executeScript("arguments[0].setAttribute('style', 'border:2px solid red; background:yellow')", driver.findElement(PageObjects.firstLink));

			}else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "Add Secondary Skill Link is Not Displyaed in Quick Links Section");
			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(LandingPageValidation_PageObjects.secondLink));
			if(driver.findElement(LandingPageValidation_PageObjects.secondLink).isDisplayed()) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "Certification Road Map Link is Displyaed in Quick Links Section");
			}else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "Certification Road Map Link is Not Displyaed in Quick Links Section");
			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(LandingPageValidation_PageObjects.secondLink));
			if(driver.findElement(LandingPageValidation_PageObjects.secondLink).isDisplayed()) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "Expert List Link is Displyaed in Quick Links Section");
			}else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "Expert List Link is Not Displyaed in Quick Links Section");
			}
		}
		catch(Exception e) {
			System.out.println(e);
			LandingPageValidation_GetExtentReports.Exception(driver, LPVTest_test, e);
		}
	}

	public static void getToKnowMyCompAndSAGValidatio(WebDriver driver, ExtentTest LPVTest_test,ExtentReports LPVTest_report ) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			JavascriptExecutor js = (JavascriptExecutor) driver; 

			/* String currentUrl = driver.getCurrentUrl();

		   if(currentUrl.equalsIgnoreCase(prop.getProperty("Main_Url"))){
		   System.out.println("Navigated to Correct URL"); }else {
		   System.out.println("Navigated to Incorrect URL, Navigating again");
		   driver.get(prop.getProperty("Main_Url")); } Thread.sleep(3000);


			if(driver.findElements(LandingPageValidation_PageObjects.webNavigationClose).size()!=0) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "Welcome PopUp Displayed in Landing Page");
				driver.findElement(LandingPageValidation_PageObjects.webNavigationClose).click();
			}else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "Welcome PopUp Not Displayed in Landing Page");
			}*/

			wait.until(ExpectedConditions.visibilityOfElementLocated(LandingPageValidation_PageObjects.aboutHeader));
			WebElement aboutHeader = driver.findElement(LandingPageValidation_PageObjects.aboutHeader);
			if(aboutHeader.isDisplayed()) {
				js.executeScript("arguments[0].scrollIntoView();", aboutHeader); 
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "Know About MyCompetency is Displyaed in New Landing Page");
			}else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "Know About MyCompetency is Displyaed in New Landing Page");
			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(LandingPageValidation_PageObjects.firstVidCard));
			if(driver.findElement(LandingPageValidation_PageObjects.firstVidCard).isDisplayed()) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "First Video is Displayed in Know About MyCompetency Section");
			}else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "First Video is Not Displayed in Know About MyCompetency Section");
			}


			wait.until(ExpectedConditions.visibilityOfElementLocated(LandingPageValidation_PageObjects.firstVidPlayBtn));
			if(driver.findElement(LandingPageValidation_PageObjects.firstVidPlayBtn).isDisplayed()) { 
				LandingPageValidation_GetExtentReports.PassTest(driver,LPVTest_test, "Play Button is Displayed inside First Video"); 
			}else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test,"Play Button is NotDisplayed inside First Video");
			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(LandingPageValidation_PageObjects.secondVidCard));
			if(driver.findElement(LandingPageValidation_PageObjects.secondVidCard).isDisplayed()) {
				LandingPageValidation_GetExtentReports.PassTest(driver,LPVTest_test,"Second Video is Displayed in Know About MyCompetency Section"); }else {
					LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test,"Second Video is Not Displayed in Know About MyCompetency Section"); }

			wait.until(ExpectedConditions.visibilityOfElementLocated(LandingPageValidation_PageObjects.secondVidPlayBtn));
			if(driver.findElement(LandingPageValidation_PageObjects.secondVidPlayBtn).isDisplayed()) { LandingPageValidation_GetExtentReports.PassTest(driver,
					LPVTest_test, "Play Button is Displayed inside Second Video"); 
			}else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test,"Play Button is NotDisplayed inside Second Video"); }


			if(driver.findElements(LandingPageValidation_PageObjects.SAGHeader).size()!=0) {
				wait.until(ExpectedConditions.visibilityOfElementLocated(LandingPageValidation_PageObjects.SAGHeader));
				if(driver.findElement(LandingPageValidation_PageObjects.SAGHeader).isDisplayed()) {
					LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "Skill Accelerater Guidance Section is Displyaed in New Landing Page");
				}else {
					LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "Skill Accelerater Guidance Section is Not Displyaed in New Landing Page");
				}

				wait.until(ExpectedConditions.visibilityOfElementLocated(LandingPageValidation_PageObjects.viewMoreBtn));
				if(driver.findElement(LandingPageValidation_PageObjects.viewMoreBtn).isDisplayed()) {
					LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "View More Button is Displayed in SAG Section");
				}else {
					LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "View More Button is Not Displayed in SAG Section");
				}
			}else {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "Employee Don't Have Recommended Skills");
			}
		}
		catch(Exception e) {
			LandingPageValidation_GetExtentReports.Exception(driver, LPVTest_test, e);
			System.out.println(e);
		}
	}

	public static void secSkillsValidationHigProf(WebDriver driver, ExtentTest LPVTest_test,ExtentReports LPVTest_report, String PriSkill, String SecSkill1, String SecSkill2 ) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			JavascriptExecutor js = (JavascriptExecutor) driver; 

			String priSkill = prop.getProperty(PriSkill);
			String secSkill1 = prop.getProperty(SecSkill1);
			String secSkill2 = prop.getProperty(SecSkill2);

			if(driver.findElements(LandingPageValidation_PageObjects.webNavigationClose).size()!=0) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "Welcome PopUp Displayed in Landing Page");
				driver.findElement(LandingPageValidation_PageObjects.webNavigationClose).click();
			}else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "Welcome PopUp Not Displayed in Landing Page");
			}
			wait.until(ExpectedConditions.presenceOfElementLocated(LandingPageValidation_PageObjects.skillProfileHeader));

			wait.until(ExpectedConditions.visibilityOfElementLocated(LandingPageValidation_PageObjects.skillProfileHeader));
			if(driver.findElement(LandingPageValidation_PageObjects.skillProfileHeader).isDisplayed()) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "Skill Profile Header is Displayed in Landing Page");
			}else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "Skill Profile Header is Not Displayed in Landing Page");
			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(LandingPageValidation_PageObjects.primarySkillName));
			WebElement priS = driver.findElement(LandingPageValidation_PageObjects.primarySkillName);
			String priSkillName = priS.getText();

			if(priSkill.equalsIgnoreCase(priSkillName)) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "Primary Skill Displayed in Skill Profile Section, Skill Name:" +priSkillName);
			}else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "Primary Skill Not Displayed in Skill Profile Section");
			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(LandingPageValidation_PageObjects.secSkillName1));
			WebElement secS = driver.findElement(LandingPageValidation_PageObjects.secSkillName1);
			String secSkillName = secS.getText();
			int fullProfLenSec1=0;
			int halfProfLenSec1=0;
			if(driver.findElements(LandingPageValidation_PageObjects.profFullStarSec1).size()!=0) {
				fullProfLenSec1 = driver.findElements(LandingPageValidation_PageObjects.profFullStarSec1).size();
			}
			if(driver.findElements(LandingPageValidation_PageObjects.profFullStarSec1).size()!=0) {
				halfProfLenSec1 = driver.findElements(LandingPageValidation_PageObjects.profHalfStarSec1).size();
			}
			/*
			 * if(fullProfLen<0) { LandingPageValidation_GetExtentReports.PassTest(driver,
			 * LPVTest_test, "Employee Don't Have Any Proficiency"); }else
			 * if(fullProfLen==1) { LandingPageValidation_GetExtentReports.PassTest(driver,
			 * LPVTest_test, "Employee's Current Proficiency is P1"); }else
			 * if(fullProfLen==2) { LandingPageValidation_GetExtentReports.PassTest(driver,
			 * LPVTest_test, "Employee's Current Proficiency is P2"); }else
			 * if(fullProfLen==3 && halfProfLen==0) {
			 * LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test,
			 * "Employee's Current Proficiency is P3"); }else if(fullProfLen==3 &&
			 * halfProfLen==1) { LandingPageValidation_GetExtentReports.PassTest(driver,
			 * LPVTest_test, "Employee's Current Proficiency is P3+"); }else
			 * if(fullProfLen==4 && halfProfLen==0) {
			 * LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test,
			 * "Employee's Current Proficiency is P4"); }else if(fullProfLen==4 &&
			 * halfProfLen==1) { LandingPageValidation_GetExtentReports.PassTest(driver,
			 * LPVTest_test, "Employee's Current Proficiency is P4+"); }else {
			 * LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test,
			 * "Employee's Current Proficiency is P5"); }
			 */
			System.out.println(fullProfLenSec1+" "+halfProfLenSec1);
			if(secSkill1.equalsIgnoreCase(secSkillName) || (fullProfLenSec1==4 && halfProfLenSec1==1)) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "Secondary Skill "+secSkillName+" With P4+ Proficiency is Displayed in Skill Profile Section");
			}else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "Secondary Skill "+secSkillName+" With P4+ Proficiency is Not Displayed in Skill Profile Section");
			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(LandingPageValidation_PageObjects.secSkillName2));
			WebElement secS2 = driver.findElement(LandingPageValidation_PageObjects.secSkillName2);
			js.executeScript("arguments[0].scrollIntoView();", secS2);
			String secSkillName2 = secS2.getText();
			int fullProfLenSec2=0;
			int halfProfLenSec2=0;
			if(driver.findElements(LandingPageValidation_PageObjects.profFullStarSec2).size()!=0) {
				fullProfLenSec2 = driver.findElements(LandingPageValidation_PageObjects.profFullStarSec2).size();
			}
			if(driver.findElements(LandingPageValidation_PageObjects.profHalfStarSec2).size()!=0) {
				halfProfLenSec2=driver.findElements(LandingPageValidation_PageObjects.profHalfStarSec2).size();
			}
			System.out.println(fullProfLenSec2+" "+halfProfLenSec2);
			if(secSkill2.equalsIgnoreCase(secSkillName2) ||  (fullProfLenSec2==3 && halfProfLenSec2==1)) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "Secondary Skill "+secSkillName2+" With P3+ Proficiency is Displayed in Skill Profile Section");
			}else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "Secondary Skill "+secSkillName2+" With P3+ Proficiency is Not Displayed in Skill Profile Section");
			}
		}
		catch(Exception E) {
			System.err.println(E);
			LandingPageValidation_GetExtentReports.Exception(driver, LPVTest_test, E);
		}
	}

	public static void secSkillsValidationRecentlyAdded(WebDriver driver, ExtentTest LPVTest_test,ExtentReports LPVTest_report, String PriSkill, String SecSkill1, String SecSkill2 ) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			JavascriptExecutor js = (JavascriptExecutor) driver; 

			String priSkill = prop.getProperty(PriSkill);
			String secSkill1 = prop.getProperty(SecSkill1);
			String secSkill2 = prop.getProperty(SecSkill2);

			if(driver.findElements(LandingPageValidation_PageObjects.webNavigationClose).size()!=0) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "Welcome PopUp Displayed in Landing Page");
				driver.findElement(LandingPageValidation_PageObjects.webNavigationClose).click();
			}else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "Welcome PopUp Not Displayed in Landing Page");
			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(LandingPageValidation_PageObjects.skillProfileHeader));
			if(driver.findElement(LandingPageValidation_PageObjects.skillProfileHeader).isDisplayed()) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "Skill Profile Header is Displayed in Landing Page");
			}else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "Skill Profile Header is Not Displayed in Landing Page");
			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(LandingPageValidation_PageObjects.primarySkillName));
			WebElement priS = driver.findElement(LandingPageValidation_PageObjects.primarySkillName);
			String priSkillName = priS.getText();

			if(priSkill.equalsIgnoreCase(priSkillName)) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "Primary Skill "+priSkillName+" Displayed in Skill Profile Section");
			}else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "Primary Skill "+priSkillName+" Not Displayed in Skill Profile Section");
			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(LandingPageValidation_PageObjects.secSkillName1));
			WebElement secS = driver.findElement(LandingPageValidation_PageObjects.secSkillName1);
			String secSkillName = secS.getText();
			int fullProfLenSec1=0;
			int halfProfLenSec1=0;
			if(driver.findElements(LandingPageValidation_PageObjects.profFullStarSec1).size()!=0) {
				fullProfLenSec1 = driver.findElements(LandingPageValidation_PageObjects.profFullStarSec1).size();
			}
			if(driver.findElements(LandingPageValidation_PageObjects.profFullStarSec1).size()!=0) {
				halfProfLenSec1 = driver.findElements(LandingPageValidation_PageObjects.profHalfStarSec1).size();
			}
			if(secSkill1.equalsIgnoreCase(secSkillName)  && (fullProfLenSec1==3 && halfProfLenSec1==1)) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "Secondary Skill "+secSkillName+" With P3+ Proficiency is Displayed in Skill Profile Section");
			}else if (secSkill1.equalsIgnoreCase(secSkillName)  && (fullProfLenSec1==0 && halfProfLenSec1==0)){
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "Recently Added Secondary Skill "+secSkillName+" is Displayed in Skill Profile Section");
			}
			else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "Recently Added Secondary Skill "+secSkillName+" is Not Displayed in Skill Profile Section");
			}

			if(driver.findElements(LandingPageValidation_PageObjects.secSkillName2).size()!=0) {
				wait.until(ExpectedConditions.visibilityOfElementLocated(LandingPageValidation_PageObjects.secSkillName2));
				WebElement secS2 = driver.findElement(LandingPageValidation_PageObjects.secSkillName2);
				js.executeScript("arguments[0].scrollIntoView();", secS2);
				String secSkillName2 = secS2.getText();
				if(secSkill2.equalsIgnoreCase(secSkillName2)) {
					LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "Recently Added Secondary Skill "+secSkillName2+" is Displayed in Skill Profile Section");
				}else {
					LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "Recently Added Secondary Skill "+secSkillName2+" is Not Displayed in Skill Profile Section");
				}	
			}else {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "User Have Only One Secondary Skill");
			}

		}
		catch(Exception E) {
			System.err.println(E);
			LandingPageValidation_GetExtentReports.Exception(driver, LPVTest_test, E);
		}
	}
	public static void secSkillsValidationNoSecSkills(WebDriver driver, ExtentTest LPVTest_test,ExtentReports LPVTest_report, String PriSkill) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			JavascriptExecutor js = (JavascriptExecutor) driver; 

			String priSkill = prop.getProperty(PriSkill);

			if(driver.findElements(LandingPageValidation_PageObjects.webNavigationClose).size()!=0) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "Welcome PopUp Displayed in Landing Page");
				driver.findElement(LandingPageValidation_PageObjects.webNavigationClose).click();
			}else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "Welcome PopUp Not Displayed in Landing Page");
			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(LandingPageValidation_PageObjects.skillProfileHeader));
			if(driver.findElement(LandingPageValidation_PageObjects.skillProfileHeader).isDisplayed()) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "Skill Profile Header is Displayed in Landing Page");
			}else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "Skill Profile Header is Not Displayed in Landing Page");
			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(LandingPageValidation_PageObjects.primarySkillName));
			WebElement priS = driver.findElement(LandingPageValidation_PageObjects.primarySkillName);
			String priSkillName = priS.getText();
			if(priSkill.equalsIgnoreCase(priSkillName)) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "Primary Skill Displayed in Skill Profile Section");
			}else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "Primary Skill Displayed in Skill Profile Section");
			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(LandingPageValidation_PageObjects.noSecSkill));
			WebElement noSecText = driver.findElement(LandingPageValidation_PageObjects.noSecSkill);
			String noSecSkillsActulText = noSecText.getText();
			String noSecSkillsExpectedText = "Add secondary skills to access your full potential"; 
			if(noSecText.isDisplayed() && noSecSkillsActulText.equalsIgnoreCase(noSecSkillsExpectedText)) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "User Don't Have Secondary Skills And Correct Text is Shown: " +noSecSkillsActulText);
			}else if(noSecText.isDisplayed() && !noSecSkillsActulText.equalsIgnoreCase(noSecSkillsExpectedText)){
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "User Don't Have Secondary Skills And Incorrect Text is Shown"+noSecSkillsActulText);
			}else {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "User Have Secondary Skills And Text is Not Shown To Add Secondary Skill");
			}
		}
		catch(Exception E) {
			System.err.println(E);
			LandingPageValidation_GetExtentReports.Exception(driver, LPVTest_test, E);
		}
	}
	public static void resourceValidationProd(WebDriver driver, ExtentTest LPVTest_test, ExtentTest LTVTest_testChild,
			ExtentReports LPVTest_report) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			JavascriptExecutor js = (JavascriptExecutor) driver;

			Thread.sleep(3000);

			if (driver.findElements(LandingPageValidation_PageObjects.webNavigationClose).size() != 0) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test,
						"Welcome PopUp Displayed in Landing Page");
				driver.findElement(LandingPageValidation_PageObjects.webNavigationClose).click();
			} else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test,
						"Welcome PopUp Not Displayed in Landing Page");
			}
			wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@class='nav-link px-0 mx-2'])[1]")));
			driver.findElement(By.xpath("(//a[@class='nav-link px-0 mx-2'])[1]")).click();

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[@class='nav-item'])[4]")));
			driver.findElement(By.xpath("(//li[@class='nav-item'])[4]")).click();
			js.executeScript("window.scrollBy(0,200)", "");
			LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "Resource Tab Clicked");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='filenamevalue']")));
			driver.findElement(By.xpath("//input[@name='filenamevalue']")).sendKeys("Job Aid");
			LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "Keyword Entered in Search Box");
			driver.findElement(By.xpath("(//span[@class='mycomp-icon-myc-search search-icon position-absolute'])[2]"))
			.click();
			LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "Search Icon Clicked");
			Thread.sleep(3000);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//li[@class='media col-md-6 col-lg-4 mb-4']")));
			LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "Seach Result Displayed");
			driver.findElement(By.xpath("//button[@aria-label='Clear Search']")).click();
			Thread.sleep(2000);
			LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "Clear Icon Clicked");

			driver.findElement(By.xpath("(//li[@class='nav-item'])[5]")).click();
			js.executeScript("window.scrollBy(0,200)", "");
			LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "Certifications Tab Clicked");

			driver.findElement(By.xpath("(//li[@class='nav-item'])[6]")).click();
			js.executeScript("window.scrollBy(0,200)", "");
			LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "Last Tab Clicked");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void feedbackPopUpValidation(WebDriver driver, ExtentTest LPVTest_test, ExtentTest LPVTest_testChild, ExtentReports LPVTest_report) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			/*
        	wait.until(ExpectedConditions.visibilityOfElementLocated(LandingPageValidation_PageObjects.webNavigationClose));
			if (driver.findElements(LandingPageValidation_PageObjects.webNavigationClose).size() != 0) {
				wait.until(ExpectedConditions.visibilityOfElementLocated(LandingPageValidation_PageObjects.webNavigationClose));
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test,"Welcome PopUp Displayed in Landing Page");
				driver.findElement(LandingPageValidation_PageObjects.webNavigationClose).click();
			} else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test,"Welcome PopUp Not Displayed in Landing Page");
			}*/


			wait.until(ExpectedConditions.visibilityOfElementLocated(LandingPageValidation_PageObjects.feedbcakBtn));
			WebElement feedBtn = driver.findElement(LandingPageValidation_PageObjects.feedbcakBtn);
			feedBtn.sendKeys(Keys.ARROW_UP);
			if(feedBtn.isDisplayed()) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "Feedback Button Displayed in Landing Page");
			}else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "Feedback Button Not Displayed in Landing Page");
			}
			feedBtn.click();

			wait.until(ExpectedConditions.visibilityOfElementLocated(LandingPageValidation_PageObjects.feedbackHdr));
			WebElement feedHdr = driver.findElement(LandingPageValidation_PageObjects.feedbackHdr);
			if(feedHdr.isDisplayed()) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "Feedback PopUp Opended After Clicing on Feedback Button");
			}else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "Feedback PopUp Not Opended After Clicing on Feedback Button");
			}

			String expFeeHdr = "We appreciate you taking time for the Feedback!";
			String actFeedHdr = feedHdr.getText();
			if(actFeedHdr.equalsIgnoreCase(expFeeHdr)) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "Correct Header Displayed in Feedback PopUp: "+actFeedHdr);
			}else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "Incorrect Header Displayed in Feedback PopUp: "+actFeedHdr);
			}
			wait.until(ExpectedConditions.visibilityOfElementLocated(LandingPageValidation_PageObjects.label1));
			WebElement label1 = driver.findElement(LandingPageValidation_PageObjects.label1);
			String expLabel1 = "Please select the experience you would like to rate *";
			String actLabel1 = label1.getText();
			if(expLabel1.equalsIgnoreCase(actLabel1)) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "Correct Label Displayed Above The Select Value Dropdown: "+actLabel1);
			}else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "Incorrect Label Displayed Above The Select Value Dropdown: "+actLabel1);
			}

			WebElement expDropdown = driver.findElement(LandingPageValidation_PageObjects.expDrpDown);
			if(expDropdown.isDisplayed()) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "Experience Dropdown is Displayed Below the Label");
			}else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "Experience Dropdown is Not Displayed Below the Label");
			}
			expDropdown.click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(LandingPageValidation_PageObjects.featuresList));
			WebElement expList = driver.findElement(LandingPageValidation_PageObjects.featuresList);
			if(expList.isDisplayed()) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "List of Features Displayed after Clicking on Dropdown ");
			}else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "List of Features Not Displayed after Clicking on Dropdown ");
			}
			expList.click();
			if(driver.findElement(LandingPageValidation_PageObjects.selectedFeature).isDisplayed()) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "Selected Feature Disaplyed in Dropdown");
			}else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "Selected Feature Not Disaplyed in Dropdown");
			}

			WebElement label2 = driver.findElement(LandingPageValidation_PageObjects.label2);
			String expLabel2 = "Please rate the experience in the scale of 1 to 5 *";
			String actLabel2 = label2.getText();
			if(expLabel2.equalsIgnoreCase(actLabel2)) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "Correct Label Displayed Above the Start Ratings: "+actLabel2);
			}else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "Incorrect Label Displayed Above the Start Ratings: "+actLabel2);
			}

			WebElement rating = driver.findElement(LandingPageValidation_PageObjects.starRatingAll);
			if(rating.isDisplayed()) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "Star Rating Displayed in Feedback PopUp");
			}else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "Star Rating Not Displayed in Feedback PopUp");
			}
			driver.findElement(LandingPageValidation_PageObjects.singleStar).click();

			WebElement label3 = driver.findElement(LandingPageValidation_PageObjects.label3);
			String expLabel3 = "Add Comments *";
			String actLabel3 = label3.getText();
			if(expLabel3.equalsIgnoreCase(actLabel3)) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "Correct Label Displayed Above the Feedback Textbox: "+actLabel3);
			}else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "Incorrect Label Displayed Above the Feedback Textbox: "+actLabel3);
			}

			WebElement feedTextbox = driver.findElement(LandingPageValidation_PageObjects.feedbackInput);
			if(feedTextbox.isDisplayed()) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "Textbox is Displayed in Feedback PopUp for User Input");
			}else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "Textbox is Not Displayed in Feedback PopUp for User Input");
			}
			feedTextbox.sendKeys("Testing user input for feedback textbox");

			WebElement charLimit = driver.findElement(LandingPageValidation_PageObjects.charLimit);
			js.executeScript("arguments[0].scrollIntoView();", charLimit);
			String chrLimitStr = charLimit.getText();
			if(charLimit.isDisplayed() && chrLimitStr.contains("Characters")) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "Character Limit Text is Displlayed Below the Textbox: "+chrLimitStr);
			}else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "Character Limit Text is Not Displlayed Below the Textbox: "+chrLimitStr);
			}

			WebElement submitBtn = driver.findElement(LandingPageValidation_PageObjects.submitBtn);
			if(submitBtn.isDisplayed()) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "Submit Buttton is Displayed in Feedback PopUp");
			}else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "Submit Buttton is Not Displayed in Feedback PopUp");
			}

			WebElement cancelBtn = driver.findElement(LandingPageValidation_PageObjects.submitBtn);
			if(cancelBtn.isDisplayed()) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "Cancel Buttton is Displayed in Feedback PopUp");
			}else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "Cancel Buttton is Not Displayed in Feedback PopUp");
			}

			submitBtn.click();

			wait.until(ExpectedConditions.visibilityOfElementLocated(LandingPageValidation_PageObjects.confHeader));
			wait.until(ExpectedConditions.visibilityOfElementLocated(LandingPageValidation_PageObjects.confMsg));
			WebElement confPopup = driver.findElement(LandingPageValidation_PageObjects.confHeader);
			if(confPopup.isDisplayed()) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "Confirmation PopUp Displayed Post Submitting the Feedback");
			}else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "Confirmation PopUp Not Displayed Post Submitting the Feedback");
			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(LandingPageValidation_PageObjects.confMsg));
			Thread.sleep(1000);			
			WebElement confMsg = driver.findElement(LandingPageValidation_PageObjects.confMsg);
			String expConMsg = "Thank you";
			String actConMsg = confMsg.getText();
			if(confMsg.isDisplayed() && actConMsg.contains(expConMsg))
			{
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "Correct Text is Displayed in Confirmation PopUp");
			}else 
			{
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "Inorrect Text is Displayed in Confirmation PopUp");
			}

			if(confMsg.isDisplayed()) 
			{
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "Confirmation PopUp Closed Post Clicking on Close Icon");
			}else 
			{
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "Confirmation PopUp Not Closed Post Clicking on Close Icon");
			}
			driver.findElement(LandingPageValidation_PageObjects.confCloseBtn).click();

		} catch (Exception e) {
			System.out.println(e);
			LandingPageValidation_GetExtentReports.Exception(driver, LPVTest_test, e);
		}
	}

	public static void secSkillsTabValidation(WebDriver driver, ExtentTest LPVTest_test, ExtentReports LPVTest_report) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			JavascriptExecutor js = (JavascriptExecutor) driver;

			wait.until(ExpectedConditions.visibilityOfElementLocated(LandingPageValidation_PageObjects.webNavigationClose));
			if (driver.findElements(LandingPageValidation_PageObjects.webNavigationClose).size() != 0) {
				wait.until(ExpectedConditions.visibilityOfElementLocated(LandingPageValidation_PageObjects.webNavigationClose));
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test,"Welcome PopUp Displayed in Landing Page");
				driver.findElement(LandingPageValidation_PageObjects.webNavigationClose).click();
			} else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test,"Welcome PopUp Not Displayed in Landing Page");
			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(LandingPageValidation_PageObjects.mySkillProfile));
			WebElement mySkillProf = driver.findElement(LandingPageValidation_PageObjects.mySkillProfile);
			if(mySkillProf.isDisplayed()) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "My Skill Profile Link Shown in Landing Page");
			}else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "My Skill Profile Link Not Shown in Landing Page");
			}
			mySkillProf.click();

			wait.until(ExpectedConditions.visibilityOfElementLocated(LandingPageValidation_PageObjects.secSkillTab));
			WebElement secSkillsTab = driver.findElement(LandingPageValidation_PageObjects.secSkillTab);
			if(secSkillsTab.isDisplayed()) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "Secondary Skills Tab is Displayed in My Skill Profile Page");
			}else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "Secondary Skills Tab is Not Displayed in My Skill Profile Page");
			}
			secSkillsTab.click();

			String secTabText = secSkillsTab.getText();
			if(secTabText.contains("")) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "Secondary Skills Count Disaplyed in Secondary Skills Tab");
			}else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "Secondary Skills Count Not Disaplyed in Secondary Skills Tab");
			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(LandingPageValidation_PageObjects.secSkillDesc));
			WebElement secDesc = driver.findElement(LandingPageValidation_PageObjects.secSkillDesc);
			String expDesc = "Additional skills that you leverage to deliver on the project or it could also be skills you have acquired through certifications, learning programs or prior experience.";
			String actDesc = secDesc.getText();
			if(expDesc.equalsIgnoreCase(actDesc)) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "Correct Description is Shown in Secondary Skills Tab");
			}else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "Incorrect Description is Shown in Secondary Skills Tab");
			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(LandingPageValidation_PageObjects.addSecBtn));
			WebElement addSecBtn = driver.findElement(LandingPageValidation_PageObjects.addSecBtn);
			if(addSecBtn.isDisplayed()) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "Add Skill Button is Displayed in Secondary Skills Tab");
			}else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "Add Skill Button is Not Displayed in Secondary Skills Tab");
			}

			LPVTest_test = LPVTest_report.createTest("TC_15 Secondary Skill Details");
			wait.until(ExpectedConditions.visibilityOfElementLocated(LandingPageValidation_PageObjects.skillName));
			WebElement secSkillName = driver.findElement(LandingPageValidation_PageObjects.skillName);
			String expSkillName = prop.getProperty("FirstSecSkill");
			String actSkillName = secSkillName.getText();
			if(expSkillName.equalsIgnoreCase(actSkillName)) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "Correct Secondary Skill Name Displayed in Secondary Skills Name");
			}else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "Incorrect Secondary Skill Name Displayed in Secondary Skills Name");
			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(LandingPageValidation_PageObjects.skillProf));
			WebElement prof = driver.findElement(LandingPageValidation_PageObjects.skillProf);
			String expProf = prop.getProperty("secSkillProf");
			String actProf = prof.getText();
			if(expProf.equalsIgnoreCase(actProf)) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "Correct Proficiency is Displayed for Secondary Skill");
			}else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "Inorrect Proficiency is Displayed for Secondary Skill");
			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(LandingPageValidation_PageObjects.profDesc));
			WebElement profDesc = driver.findElement(LandingPageValidation_PageObjects.profDesc);
			String expProfDesc = "";
			String actProfDesc = profDesc.getText();
			if(expProfDesc.equalsIgnoreCase(actProfDesc)) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "Correct Proficiency Description is Shown for Secondary Skill");
			}else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "Incorrect Proficiency Description is Shown for Secondary Skill");
			}

			if(driver.findElements(LandingPageValidation_PageObjects.profImg).size()!=0) {
				WebElement profImg = driver.findElement(LandingPageValidation_PageObjects.profImg);
				if(profImg.isDisplayed()) {
					LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "Proficiecny Badge is Shown for The Secodnary Skill");
				}else {
					LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "Proficiecny Badge is Not Shown for The Secodnary Skill");
				}
			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(LandingPageValidation_PageObjects.takeActions));
			WebElement takeActions = driver.findElement(LandingPageValidation_PageObjects.takeActions);
			if(takeActions.isDisplayed()) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "Take Actions Button Displayed for Secondary Skill");
			}else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "Take Actions Button Not Displayed for Secondary Skill");
			}

			LPVTest_test = LPVTest_report.createTest("TC_15 Recommended Skills Section");
			if(driver.findElements(LandingPageValidation_PageObjects.recomSkillsHeader).size()!=0) {
				wait.until(ExpectedConditions.visibilityOfElementLocated(LandingPageValidation_PageObjects.recomSkillsHeader));
				WebElement SAGHeader = driver.findElement(LandingPageValidation_PageObjects.recomSkillsHeader);
				String expHeader = "Skills for you";
				String actHeader = SAGHeader.getText();
				if(expHeader.equals(actHeader)) {
					LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "Correct Header is Displayed for Recommended Skills Section");
				}else {
					LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "Incorrect Header is Displayed for Recommended Skills Section");
				}

				WebElement recSkillName = driver.findElement(LandingPageValidation_PageObjects.recomSkillName);
				String expRecSkillName = prop.getProperty("RecSkillName");
				String actRecSkillName = recSkillName.getText();
				if(expRecSkillName.equalsIgnoreCase(actRecSkillName)) {
					LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "Correct Skill Name is Shown in Recommended Skills Section");
				}else {
					LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "Incorrect Skill Name is Shown in Recommended Skills Section");
				}

				WebElement addRecSkillBtn = driver.findElement(LandingPageValidation_PageObjects.recomAddBtn);
				if(addRecSkillBtn.isDisplayed()) {
					LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "Add Skill Button is Shown for Recommended Skills");
				}else {
					LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "Add Skill Button is Not Shown for Recommended Skills");
				}

				if(driver.findElements(LandingPageValidation_PageObjects.recomViewMoreBtn).size()!=0) {
					WebElement viewMore = driver.findElement(LandingPageValidation_PageObjects.viewMoreBtn);
					if(viewMore.isDisplayed()) {
						LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "View More Button is Displayed in Recommended Skills Section");
					}else {
						LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "View More Button is Not Displayed in Recommended Skills Section");
					}
					viewMore.click();

					wait.until(ExpectedConditions.visibilityOfElementLocated(LandingPageValidation_PageObjects.recomViewLessBtn));
					WebElement viewLess = driver.findElement(LandingPageValidation_PageObjects.recomViewLessBtn);
					if(viewLess.isDisplayed()) {
						LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "View Less Button is Displayed in Recommended Skills Section");
					}else {
						LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "View Less Button is Not Displayed in Recommended Skills Section");
					}
					viewLess.click();

					wait.until(ExpectedConditions.visibilityOfElementLocated(LandingPageValidation_PageObjects.viewMoreBtn));
					if(driver.findElement(LandingPageValidation_PageObjects.viewMoreBtn).isDisplayed()) {
						LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "View More Buttton is Displayed After Clicking on View Less");
					}else {
						LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "View More Buttton is Not Displayed After Clicking on View Less");
					}
				}else {
					LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "User has Less Number of Recommended Skills, So View More Button is Not Shown");
				}
			}else {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "User Don't have Recommended Skills, So Recommended Skills Section is Not Shown");
			}

			WebElement feedbackBtn = driver.findElement(LandingPageValidation_PageObjects.feedbcakBtn);
			if(feedbackBtn.isDisplayed()) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "Feedback Button is Displayed in Secondary Skills Tab");
			}else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "Feedback Button is Not Displayed in Secondary Skills Tab");
			}

			WebElement dipaLogo = driver.findElement(LandingPageValidation_PageObjects.dipaLogo);
			if(dipaLogo.isDisplayed()) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "DiPA Logo is Present in Secondary Skills Tab");
			}else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "DiPA Logo is Not Present in Secondary Skills Tab");
			}
		}
		catch(Exception e){
			System.out.println(e);
			LandingPageValidation_GetExtentReports.Exception(driver, LPVTest_test, e);
		}
	}

	public static void SOI_TabValidation(WebDriver driver, ExtentTest LPVTest_test, ExtentReports LPVTest_report) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			JavascriptExecutor js = (JavascriptExecutor) driver;

			wait.until(ExpectedConditions.visibilityOfElementLocated(LandingPageValidation_PageObjects.webNavigationClose));
			if (driver.findElements(LandingPageValidation_PageObjects.webNavigationClose).size() != 0) {
				wait.until(ExpectedConditions.visibilityOfElementLocated(LandingPageValidation_PageObjects.webNavigationClose));
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test,"Welcome PopUp Displayed in Landing Page");
				driver.findElement(LandingPageValidation_PageObjects.webNavigationClose).click();
			} else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test,"Welcome PopUp Not Displayed in Landing Page");
			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(LandingPageValidation_PageObjects.mySkillProfile));
			WebElement mySkillProf = driver.findElement(LandingPageValidation_PageObjects.mySkillProfile);
			if(mySkillProf.isDisplayed()) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "My Skill Profile Link Shown in Landing Page");
			}else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "My Skill Profile Link Not Shown in Landing Page");
			}
			mySkillProf.click();

			wait.until(ExpectedConditions.visibilityOfElementLocated(LandingPageValidation_PageObjects.SOITab));
			WebElement SOITab = driver.findElement(LandingPageValidation_PageObjects.SOITab);
			if(SOITab.isDisplayed()) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "SOI Tab is Present in My Skill Profile Page");
			}else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "SOI Tab is Not Present in My Skill Profile Page");
			}
			SOITab.click();

			String secTabText = SOITab.getText();
			if(secTabText.contains("")) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "SOI Skills Count Disaplyed in SOI Tab");
			}else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "SOI Skills Count Not Disaplyed in SOI Tab");
			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(LandingPageValidation_PageObjects.SOIDesc));
			WebElement SOIDesc = driver.findElement(LandingPageValidation_PageObjects.SOIDesc);
			if(SOIDesc.isDisplayed()) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "SOI Tab Opened After Clicking on SOI Tab");
			}else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "SOI Tab Not Opened After Clicking on SOI Tab");
			}
			String expSOIDesc = "Skills added by you based on your prior experience, training & aspirations. You can add these skills to your secondary skill palette only if you complete the assessment and get a minimum P1 proficiency.";
			String actSOIDesc = SOIDesc.getText();
			if(expSOIDesc.equalsIgnoreCase(actSOIDesc)) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "Correct Description is Shown in SOI Tab");
			}else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "Incorrect Description is Shown in SOI Tab");
			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(LandingPageValidation_PageObjects.SOISkillName));
			WebElement SOISkillName = driver.findElement(LandingPageValidation_PageObjects.SOISkillName);
			String expSOIName = prop.getProperty("SOI_SkillName");
			String actSOIName = SOISkillName.getText();
			if(expSOIName.equalsIgnoreCase(actSOIName)) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "Correct Skill Name is Shown in SOI Tab");
			}else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "Incorrect Skill Name is Shown in SOI Tab");
			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(LandingPageValidation_PageObjects.takeAssesText));
			WebElement takeAssessText = driver.findElement(LandingPageValidation_PageObjects.takeAssesText);
			String expAssessText = "Take assessment to add skill";
			String actAssessText = takeAssessText.getText();
			if(expAssessText.equalsIgnoreCase(actAssessText)) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "Correct Text is Displayed to Take the Assessment");
			}else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "Incorrect Text is Displayed to Take the Assessment");
			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(LandingPageValidation_PageObjects.SOIAction));
			WebElement SOIAction = driver.findElement(LandingPageValidation_PageObjects.SOIAction);
			if(SOIAction.isDisplayed()) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "Action and Status is Shown for SOI Skill");
			}else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "Action and Status is Not Shown for SOI Skill");
			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(LandingPageValidation_PageObjects.SOIDeleteIcon));
			WebElement deleteIcon = driver.findElement(LandingPageValidation_PageObjects.SOIDeleteIcon);
			if(deleteIcon.isDisplayed()) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "Delete Icon is Present in SOI Skill");
			}else {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "Delete Icon is Not Present in SOI Skill");
			}

			WebElement feedbackBtn = driver.findElement(LandingPageValidation_PageObjects.feedbcakBtn);
			if(feedbackBtn.isDisplayed()) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "Feedback Button is Displayed in Secondary Skills Tab");
			}else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "Feedback Button is Not Displayed in Secondary Skills Tab");
			}

			WebElement dipaLogo = driver.findElement(LandingPageValidation_PageObjects.dipaLogo);
			if(dipaLogo.isDisplayed()) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "DiPA Logo is Present in Secondary Skills Tab");
			}else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "DiPA Logo is Not Present in Secondary Skills Tab");
			}

		}
		catch(Exception e) {
			System.out.println(e);
			LandingPageValidation_GetExtentReports.Exception(driver, LPVTest_test, e);
		}
	}

	public static void LandingPageHeader(WebDriver driver, ExtentTest LPVTest_test,
			ExtentReports LPVTest_report) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100)); 
			driver.findElement(LandingPageValidation_PageObjects.webNavigationClose).click();
			Thread.sleep(100);
			WebElement MycompetencyHeader = driver.findElement(By.xpath(LandingPageValidation_PageObjects.Mycompetency));
			if(MycompetencyHeader.isDisplayed())
			{
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test,
						"Mycompetency Logo is present");
			}
			else
			{
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test,
						"Mycompetency Logo is not present");
			}	

			WebElement FeedbackHeader = driver
					.findElement(By.xpath(LandingPageValidation_PageObjects.Feedback));
			if(FeedbackHeader.isDisplayed())
			{
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test,
						"FeedBack is present in New Landing Page");
			}
			else
			{
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test,
						"FeedBack is not present in New Landing Page");
			}	


			WebElement AboutHeader = driver
					.findElement(By.xpath(LandingPageValidation_PageObjects.About));
			if(AboutHeader.isDisplayed())
			{
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test,
						"Resources is present in New Landing Page");
			}
			else
			{
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test,
						"Resources is not present in New Landing Page");
			}	

			WebElement SkillprofileHeader = driver
					.findElement(By.xpath(LandingPageValidation_PageObjects.SkillProfile));
			if(SkillprofileHeader.isDisplayed())
			{
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test,
						"SkillProfile is present in New Landing Page");
			}
			else
			{
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test,
						"SkillProfile is not present in New Landing Page");
			}


			WebElement SearchbuttonHeader = driver
					.findElement(By.xpath(LandingPageValidation_PageObjects.Searchbutton));
			if(SearchbuttonHeader.isDisplayed())
			{
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test,
						"HamBurger is present in New Landing Page");
			}
			else
			{
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test,
						"HamBurger is not present in New Landing Page");
			}}

		catch (Exception E) 
		{
			System.out.println(E);
			LandingPageValidation_GetExtentReports.Exception(driver, LPVTest_test, E);
		}

	}

	/****************************** Landing page footer ********************************/

	public static void LandingPageFooter(WebDriver driver, ExtentTest LPVTest_test,
			ExtentReports LPVTest_report) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
			/*JavascriptExecutor Executer = (JavascriptExecutor) driver;

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PageObjects.StaySignedIn)));
			Thread.sleep(1000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(PageObjects.StaySignedInNo)));
			driver.findElement(By.id(PageObjects.StaySignedInNo)).click();*/
			Thread.sleep(2000);

			WebElement RaiseTicketfooter = driver.findElement(By.xpath(LandingPageValidation_PageObjects.RaiseticketHyperlink));
			JavascriptExecutor Executer = (JavascriptExecutor) driver;
			Executer.executeScript("arguments[0].scrollIntoView();", RaiseTicketfooter);
			if(RaiseTicketfooter.isDisplayed())
			{
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test,
						"Click here hyperlink is present under Got Any Technical Issue");
			}
			else
			{
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test,
						"Click here hyperlink is not present under Got Any Technical Issue");
			}	

			WebElement SiteMapfooter = driver
					.findElement(By.xpath(LandingPageValidation_PageObjects.Sitemap));
			if(SiteMapfooter.isDisplayed())
			{
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test,
						"Site Map hyperlink is present in Footer");
			}
			else
			{
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test,
						"Site Map hyperlink is not present in Footer");
			}	


			WebElement TermsOfUsefooter = driver
					.findElement(By.xpath(LandingPageValidation_PageObjects.TermsOfUse));
			if(TermsOfUsefooter.isDisplayed())
			{
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test,
						"Terms of Use hyperlink is present in Footer");
			}
			else
			{
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test,
						"Terms of Use hyperlink is not present in Footer");
			}	

			WebElement PrivacyPolicyFooter = driver
					.findElement(By.xpath(LandingPageValidation_PageObjects.PrivacyPolicy));
			if(PrivacyPolicyFooter.isDisplayed())
			{
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test,
						"Data Privacy Statement hyperlink is present in Footer");
			}
			else
			{
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test,
						"Data Privacy Statement hyperlink is not present in Footer");
			}


			WebElement CookiePolicyfooter = driver
					.findElement(By.xpath(LandingPageValidation_PageObjects.CookiePolicy));
			if(CookiePolicyfooter.isDisplayed())
			{
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test,
						"CopyRight Text is present in Footer");
			}
			else
			{
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test,
						"CopyRight Text is not present in Footer");
			}}


		catch (Exception E) 
		{
			System.out.println(E);
			LandingPageValidation_GetExtentReports.Exception(driver, LPVTest_test, E);
		}

	}
	/*
	 *//*******************************Resource Document Section*******************************************************//*
	public static void MyResourcesValidation(WebDriver driver, ExtentTest LPVTest_test, ExtentReports LPVTest_report)
	{
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));	
			JavascriptExecutor js = (JavascriptExecutor) driver;

			if(driver.findElements(LandingPageValidation_PageObjects.webNavigationClose).size()!=0) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "Welcome PopUp Displayed in Landing Page");
				driver.findElement(LandingPageValidation_PageObjects.webNavigationClose).click();
			}else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "Welcome PopUp Not Displayed in Landing Page");
			}
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LandingPageValidation_PageObjects.MyResourcesButtonXpath)));
			WebElement MyResourceButton = driver.findElement(By.xpath(LandingPageValidation_PageObjects.MyResourcesButtonXpath));
			if (MyResourceButton.isDisplayed()) { 
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test,"Resource Button is present in the Homepage" );
			}
			else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test,"Resource Button is not present in the HomePage");	

			}
			MyResourceButton.click();

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LandingPageValidation_PageObjects.MyResourcessideheadingXpath)));
			WebElement MyResourcePage = driver.findElement(By.xpath(LandingPageValidation_PageObjects.MyResourcessideheadingXpath));
			js.executeScript("arguments[0].scrollIntoView();",MyResourcePage );
			if (MyResourcePage.isDisplayed()) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "Page is opened after clicking the resource button");
			}
			else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "Page is not opened after clicking the resource button");
			}
			LPVTest_test = LPVTest_report.createTest("TC01_Aboutmycompetency");	 
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LandingPageValidation_PageObjects.AboutmycompetencyfileXpath)));
			WebElement Aboutmycompetencyfile = driver.findElement(By.xpath(LandingPageValidation_PageObjects.AboutmycompetencyfileXpath));
			//Aboutmycompetencytab.click();
			//js.executeScript("arguments[0].scrollIntoView();",Aboutmycompetencyfile );
			if (Aboutmycompetencyfile.isDisplayed()) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "file is present");
			}
			else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "file is not present");
			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LandingPageValidation_PageObjects.AboutmycompetencyfileDescription1Xpath)));
			WebElement AboutmycompetencyfileDescription1 = driver.findElement(By.xpath(LandingPageValidation_PageObjects.AboutmycompetencyfileDescription1Xpath));
			if (AboutmycompetencyfileDescription1.isDisplayed()) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "fileDescription is present");
			}
			else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "fileDescription is not present");
			}
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LandingPageValidation_PageObjects.AboutmycompetencyFileDownloadbuttonXpath)));
			WebElement AboutmycompetencyFileDownloadbutton = driver.findElement(By.xpath(LandingPageValidation_PageObjects.AboutmycompetencyFileDownloadbuttonXpath));
			if (AboutmycompetencyFileDownloadbutton.isDisplayed()) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "file is downloading ");
			}
			else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "file is not downloading");
			}
			LPVTest_test = LPVTest_report.createTest("TC02_Myjourney");	
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LandingPageValidation_PageObjects.MyjourneytabXpath)));
			WebElement Myjourneytab = driver.findElement(By.xpath(LandingPageValidation_PageObjects.MyjourneytabXpath));
			// js.executeScript("arguments[0].scrollIntoView();",Myjourneytab);
			//js.executeScript("arguments[0].click();",Myjourneytab);
			Myjourneytab.click();
			if (Myjourneytab.isDisplayed()) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "Myjourney tab is opened/displayed");
			}
			else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "Myjourney tab is not opened/displayed");
			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LandingPageValidation_PageObjects.MyjourneyfilterbytextXpath)));
			WebElement Myjourneyfilterbytext = driver.findElement(By.xpath(LandingPageValidation_PageObjects.MyjourneyfilterbytextXpath));
			//js.executeScript("arguments[0].scrollIntoView();",Myjourneyfilterbytext);
			//Myjourneyfilterbytext.click();
			if (Myjourneyfilterbytext.isDisplayed()) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "filterby text is present/displayed");
			}
			else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "filterby text is not present/displayed");
			}
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LandingPageValidation_PageObjects.MyjourneyselectcategoriesXpath)));
			WebElement Myjourneyselectcategories = driver.findElement(By.xpath(LandingPageValidation_PageObjects.MyjourneyselectcategoriesXpath));

			if (Myjourneyselectcategories.isDisplayed()) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "select text is present/displayed");
			}
			else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "select text is not present/displayed");
			}
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LandingPageValidation_PageObjects.MyjourneycategoriesdropdownXpath)));
			WebElement Myjourneycategoriesdropdown = driver.findElement(By.xpath(LandingPageValidation_PageObjects.MyjourneycategoriesdropdownXpath));
			Myjourneycategoriesdropdown.click();
			if (Myjourneycategoriesdropdown.isDisplayed()) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "All categories are present/displayed");
			}
			else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "All categories are not present/displayed");
			}
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LandingPageValidation_PageObjects.MyjourneycategoriesjobaidXpath)));
			WebElement Myjourneycategoriesjobaid = driver.findElement(By.xpath(LandingPageValidation_PageObjects.MyjourneycategoriesjobaidXpath));
			Myjourneycategoriesjobaid.click();
			if (Myjourneycategoriesjobaid.isDisplayed()) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "Job aid category is selected");
			}
			else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "Job aid  category is not present/displayed");
			}
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LandingPageValidation_PageObjects.MyjourneyJobaidcategoryupfrontbelowthedropdownXpath)));
			WebElement MyjourneyJobaidcategoryupfrontbelowthedropdownXpath =driver.findElement(By.xpath(LandingPageValidation_PageObjects.MyjourneyJobaidcategoryupfrontbelowthedropdownXpath));
			MyjourneyJobaidcategoryupfrontbelowthedropdownXpath.click();
			if(MyjourneyJobaidcategoryupfrontbelowthedropdownXpath.isDisplayed()) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "My Journey Job Aid category  is showing in the upfront pattern");
			}
			else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "My Journey Job Aid category  is not showing in the upfront pattern");
			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LandingPageValidation_PageObjects.MyjourneyFileNameFY23ExpertsQ1Q2Xpath)));
		    		WebElement MyjourneyFileNameFY23ExpertsQ1Q2Xpath =driver.findElement(By.xpath(LandingPageValidation_PageObjects.MyjourneyFileNameFY23ExpertsQ1Q2Xpath));
		    		MyjourneyFileNameFY23ExpertsQ1Q2Xpath.click();
		    		if(MyjourneyFileNameFY23ExpertsQ1Q2Xpath.isDisplayed()) {
		    			LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "MyjourneyFileNameFY23ExpertsQ1Q2 file name is present");
		    		}
		    		else {
		    			LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "MyjourneyFileNameFY23ExpertsQ1Q2 file name is not  present");
		    		}
		    		String Mainpage = driver.getWindowHandle();
		    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LandingPageValidation_PageObjects.MyjourneyFileDownloadFY23ExpertsQ1Q2Xpath)));
		    		WebElement MyjourneyFileDownloadFY23ExpertsQ1Q2Xpath =driver.findElement(By.xpath(LandingPageValidation_PageObjects.MyjourneyFileDownloadFY23ExpertsQ1Q2Xpath));
		    		MyjourneyFileDownloadFY23ExpertsQ1Q2Xpath.click();
		    		if(MyjourneyFileDownloadFY23ExpertsQ1Q2Xpath.isDisplayed()) {
		    			LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "MyjourneyFileNameFY23ExpertsQ1Q2 file downaload is happened");
		    		}
		    		else {
		    			LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "MyjourneyFileNameFY23ExpertsQ1Q2 file downaload is not  happened");
		    		}
		    		Thread.sleep(5000);
		    		Set<String> AllWindow = driver.getWindowHandles();
		    		for (String Windows : AllWindow)
		    		{
		    		driver.switchTo().window(Windows);
		    		Thread.sleep(5000);

		    		}
		    		driver.close();
		    		driver.switchTo().window(Mainpage);


		    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LandingPageValidation_PageObjects.MyjourneyFileNameExecutiveAssessmentScopeXpath)));
		    		WebElement MyjourneyFileNameExecutiveAssessmentScopeXpath =driver.findElement(By.xpath(LandingPageValidation_PageObjects.MyjourneyFileNameExecutiveAssessmentScopeXpath));
		    		MyjourneyFileNameExecutiveAssessmentScopeXpath.click();
		    		if(MyjourneyFileNameExecutiveAssessmentScopeXpath.isDisplayed()) {
		    			LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "MyjourneyFileNameExecutiveAssessmentScope file name is present");
		    		}
		    		else {
		    			LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "MyjourneyFileNameExecutiveAssessmentScope file name is not present");
		    		}

		    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LandingPageValidation_PageObjects.MyjourenyFileDownloadExecutiveAssessmentScopeXpath)));
		    		WebElement MyjourenyFileDownloadExecutiveAssessmentScopeXpath =driver.findElement(By.xpath(LandingPageValidation_PageObjects.MyjourenyFileDownloadExecutiveAssessmentScopeXpath));
		    		MyjourenyFileDownloadExecutiveAssessmentScopeXpath.click();
		    		if(MyjourenyFileDownloadExecutiveAssessmentScopeXpath.isDisplayed()) {
		    			LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "MyjourneyFileNameExecutiveAssessmentScope file download is happened");
		    		}
		    		else {
		    			LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "MyjourneyFileNameExecutiveAssessmentScope file download is not happened");
		    		} 
		    		Thread.sleep(5000);
		    		Set<String> AllWindow1 = driver.getWindowHandles();
		    		for (String Windows : AllWindow1)
		    		{
		    		driver.switchTo().window(Windows);
		    		Thread.sleep(5000);

		    		}
		    		driver.close();
		    		driver.switchTo().window(Mainpage);

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LandingPageValidation_PageObjects.MyjourneysearchiconXpath)));
			WebElement MyjourneysearchiconXpath =driver.findElement(By.xpath(LandingPageValidation_PageObjects.MyjourneysearchiconXpath));


			if(MyjourneysearchiconXpath.isDisplayed()) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "My Journey Tab search icon is present");
			}
			else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "My Journey Tab search icon is not present");
			}
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LandingPageValidation_PageObjects.MyjourneyEnterfilenametosearchtextXpath)));
			WebElement MyjourneyEnterfilenametosearchtextXpath =driver.findElement(By.xpath(LandingPageValidation_PageObjects.MyjourneyEnterfilenametosearchtextXpath));
			//js.executeScript("arguments[0].scrollIntoView(); ",MyjourneyEnterfilenametosearchtextXpath);
			MyjourneyEnterfilenametosearchtextXpath.click();

			if(MyjourneyEnterfilenametosearchtextXpath.isDisplayed()) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "Myjourney Enter filename to search text is present");
			}
			else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "Myjourney Enter filename to search text is not present");
			}
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LandingPageValidation_PageObjects.MyjourneyViewmorebuttonXpath)));
			WebElement MyjourneyViewmorebutton =driver.findElement(By.xpath(LandingPageValidation_PageObjects.MyjourneyViewmorebuttonXpath));
			//js.executeScript("arguments[0].scrollIntoView(); ",MyjourneyViewmorebutton);
			MyjourneyViewmorebutton.click();

			if(MyjourneyViewmorebutton.isDisplayed()) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "My Journey View less button is present");
			}
			else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "My Journey View less button  is not present");
			}
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LandingPageValidation_PageObjects.MyjourneyViewlessbuttonXpath)));
			WebElement MyjourneyViewlessbuttonXpath =driver.findElement(By.xpath(LandingPageValidation_PageObjects.MyjourneyViewlessbuttonXpath));
			//js.executeScript("arguments[0].scrollIntoView(); ",MyjourneyViewlessbuttonXpath);
			MyjourneyViewlessbuttonXpath.click();
			if(MyjourneyViewlessbuttonXpath.isDisplayed()) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "My Journey View more button is present");
			}
			else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "My Journey View more button  is not present");
			}

			WebElement MyjourneyEnterfilenametosearchtext =driver.findElement(By.xpath(LandingPageValidation_PageObjects.MyjourneyEnterfilenametosearchtextXpath));
			MyjourneyEnterfilenametosearchtext.sendKeys("Job aid");
			MyjourneysearchiconXpath.click();
			if(driver.findElement(By.xpath(LandingPageValidation_PageObjects.MyjourneyJobAidFile)).isDisplayed()) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "keyword related files are displayed");
			}
			else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "keyword related files are not displayed");
			}
			Thread.sleep(8000);
			WebElement CrossButton =driver.findElement(By.xpath(LandingPageValidation_PageObjects.CrossButton));
			//CrossButton.sendKeys("Job aid");//

			if(CrossButton.isDisplayed()) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "search history will get cleared");
			}
			else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "search history will not  get cleared");
			}
			CrossButton.click();
			Thread.sleep(3000);
			//js.executeScript("arguments[0].click();", CrossButton);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LandingPageValidation_PageObjects.MyjourneycategoriesdropdownXpath1)));
			WebElement MyjourneycategoriesdropdownXpath1 = driver.findElement(By.xpath(LandingPageValidation_PageObjects.MyjourneycategoriesdropdownXpath1));
			MyjourneycategoriesdropdownXpath1.click();
			if (MyjourneycategoriesdropdownXpath1.isDisplayed()) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "All categories are present/displayed");
			}
			else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "All categories are not present/displayed");
			}


			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LandingPageValidation_PageObjects.MyjourneyNominationformcategoryupfrontbelowthedropdownXpath)));
			WebElement MyjourneyNominationformcategoryupfrontbelowthedropdownXpath =driver.findElement(By.xpath(LandingPageValidation_PageObjects.MyjourneyNominationformcategoryupfrontbelowthedropdownXpath));
			MyjourneyNominationformcategoryupfrontbelowthedropdownXpath.click();
			MyjourneyNominationformcategoryupfrontbelowthedropdownXpath.click();
			if(MyjourneyNominationformcategoryupfrontbelowthedropdownXpath.isDisplayed()) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "My Journey Nomination Form category  is selected in the upfront pattern");
			}
			else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "My Journey Nomination Form category  is not selected in the upfront pattern");
			}
			WebElement MyjourneyEnterfilenametosearchtextXpath1 =driver.findElement(By.xpath(LandingPageValidation_PageObjects.MyjourneyEnterfilenametosearchtextXpath));
			MyjourneyEnterfilenametosearchtextXpath1.sendKeys("java");
			MyjourneysearchiconXpath.click();
			if(MyjourneyEnterfilenametosearchtextXpath.isDisplayed()) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "No records text is displayed");
			}
			else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "No records text is not displayed");
			}
			LPVTest_test = LPVTest_report.createTest("TC03_Certifictaions");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LandingPageValidation_PageObjects.CertificationsxPath)));
			WebElement CertificationsxPath =driver.findElement(By.xpath(LandingPageValidation_PageObjects.CertificationsxPath));
			CertificationsxPath.click();		
			if(CertificationsxPath.isDisplayed()) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "CertificationsxPath tab is present");
			}
			else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "CertificationsxPath tab is not present");
			}
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LandingPageValidation_PageObjects.CertificationFilterBy)));
			WebElement CertificationFilterBy =driver.findElement(By.xpath(LandingPageValidation_PageObjects.CertificationFilterBy));
			CertificationFilterBy.click();
			System.out.println("Test0");
			if(CertificationFilterBy.isDisplayed()) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "CertificationFilterBy is present");
			}
			else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "CertificationFilterBy is not present");

			}
			System.out.println("Test1");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LandingPageValidation_PageObjects.CertificationSelect)));
			WebElement CertificationSelect =driver.findElement(By.xpath(LandingPageValidation_PageObjects.CertificationSelect));
			CertificationSelect.click();
			System.out.println("Test2");
			CertificationSelect.click();
			System.out.println("selected the category under dropdown");

			if(CertificationSelect.isDisplayed()) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "CertificationSelecttext is present");
			}
			else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "CertificationSelecttext is not present");

			}
			Thread.sleep(3000);
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(LandingPageValidation_PageObjects.CertificationSelectDropDown)));
				WebElement CertificationSelectDropDown =driver.findElement(By.xpath(LandingPageValidation_PageObjects.CertificationSelectDropDown));

				CertificationSelectDropDown.click();
				if(CertificationSelectDropDown.isDisplayed()) {
					LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "All categories are present");

				}
				else {
					LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "All categories are not present");

				}
			Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LandingPageValidation_PageObjects.CerificationCategory1)));
			WebElement CerificationCategory1 =driver.findElement(By.xpath(LandingPageValidation_PageObjects.CerificationCategory1));
			System.out.print(CerificationCategory1);
			CerificationCategory1.click();
			System.out.print("Category1 is selected");
			if(CerificationCategory1.isDisplayed()) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "CerificationCategory1 related files should show");

			}
			else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "CerificationCategory1 related files should not show");


			}
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(LandingPageValidation_PageObjects.CertificationCategory2)));
			WebElement CertificationCategory2 =driver.findElement(By.xpath(LandingPageValidation_PageObjects.CertificationCategory2));
			CertificationCategory2.click();
			if(CertificationCategory2.isDisplayed()) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "CerificationCategory2 is present");

			}
			else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "CerificationCategory2 is not present");
			}
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(LandingPageValidation_PageObjects.CertificationRoadMapLink)));
			WebElement CertificationRoadMapLink =driver.findElement(By.xpath(LandingPageValidation_PageObjects.CertificationRoadMapLink));
			CertificationRoadMapLink.click();
			if(CertificationRoadMapLink.isDisplayed()) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "CertificationRoadMapLink is present");

			}
			else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "CertificationRoadMapLink is not present");
			}
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(LandingPageValidation_PageObjects.FilenameSearchtext)));
			WebElement FilenameSearch =driver.findElement(By.xpath(LandingPageValidation_PageObjects.FilenameSearchtext));
			FilenameSearch.click();
			if(FilenameSearch.isDisplayed()) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "FilenameSearch is present");

			}
			else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "FilenameSearch is not present");
			}

			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(LandingPageValidation_PageObjects.SearchIcon)));
			WebElement SearchIcon =driver.findElement(By.xpath(LandingPageValidation_PageObjects.SearchIcon));
			SearchIcon.click();
			if(SearchIcon.isDisplayed()) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "SearchIcon is present");

			}
			else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "SearchIcon is not present");
			}
			WebElement FilenameSearchtext =driver.findElement(By.xpath(LandingPageValidation_PageObjects.FilenameSearchtext));
			FilenameSearchtext.sendKeys("industry");
			SearchIcon.click();
			if(FilenameSearch.isDisplayed()) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "keyword related files are displayed");
			}
			else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "keyword related files are not displayed");
			}
			WebElement FilenameSearchtext1 =driver.findElement(By.xpath(LandingPageValidation_PageObjects.FilenameSearchtext));
			FilenameSearchtext.sendKeys("java");
			SearchIcon.click();
			if(FilenameSearch.isDisplayed()) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "No records text is displayed");
			}
			else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "No records text is not displayed");
			}
			LPVTest_test = LPVTest_report.createTest("TC04_Skills_Specializations");

			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.linkText(LandingPageValidation_PageObjects.Skills_SpecializationsxPath)));
			WebElement Skills_SpecializationsxPath =driver.findElement(By.linkText(LandingPageValidation_PageObjects.Skills_SpecializationsxPath));
			Skills_SpecializationsxPath.click();
			if(Skills_SpecializationsxPath.isDisplayed()) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "Skills_SpecializationsxPath is present");

			}
			else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "Skills_SpecializationsxPath is not present");
			}
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(LandingPageValidation_PageObjects.Skills_SpecializationsFileName1Xpath)));
			WebElement Skills_SpecializationsFileName1Xpath =driver.findElement(By.xpath(LandingPageValidation_PageObjects.Skills_SpecializationsFileName1Xpath));
			Skills_SpecializationsFileName1Xpath.click();
			if(Skills_SpecializationsFileName1Xpath.isDisplayed()) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "Skills_SpecializationsFileName1 is present");

			}
			else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "Skills_SpecializationsFileName1 is not present");
			}
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(LandingPageValidation_PageObjects.Skills_SpecializationsFileDescription1Xpath)));
			WebElement Skills_SpecializationsFileDescription1Xpath =driver.findElement(By.xpath(LandingPageValidation_PageObjects.Skills_SpecializationsFileDescription1Xpath));
			Skills_SpecializationsFileDescription1Xpath.click();
			if(Skills_SpecializationsFileDescription1Xpath.isDisplayed()) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "Skills_SpecializationsFileDescription1 is present");

			}
			else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "Skills_SpecializationsFileDescription1 is not present");
			}
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(LandingPageValidation_PageObjects.Skills_SpecializationsFileDownload1Xpath)));
			WebElement Skills_SpecializationsFileDownload1Xpath =driver.findElement(By.xpath(LandingPageValidation_PageObjects.Skills_SpecializationsFileDownload1Xpath));
			Skills_SpecializationsFileDownload1Xpath.click();
			if(Skills_SpecializationsFileDownload1Xpath.isDisplayed()) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "Skills_SpecializationsFileDownload1Xpath is present");

			}
			else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "Skills_SpecializationsFileDownload1Xpath is not present");
			}
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(LandingPageValidation_PageObjects.Skills_SpecializationsFileName2Xpath)));
			WebElement Skills_SpecializationsFileName2Xpath =driver.findElement(By.xpath(LandingPageValidation_PageObjects.Skills_SpecializationsFileName2Xpath));
			Skills_SpecializationsFileName2Xpath.click();
			if(Skills_SpecializationsFileName2Xpath.isDisplayed()) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "Skills_SpecializationsFileName2 is present");

			}
			else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "Skills_SpecializationsFileName2 is not present");
			}
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(LandingPageValidation_PageObjects.Skills_SpecializationsFileDescription2Xpath)));
			WebElement Skills_SpecializationsFileDescription2Xpath =driver.findElement(By.xpath(LandingPageValidation_PageObjects.Skills_SpecializationsFileDescription2Xpath));
			Skills_SpecializationsFileDescription2Xpath.click();
			if(Skills_SpecializationsFileDescription2Xpath.isDisplayed()) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "Skills_SpecializationsFileDescription2 is present");

			}
			else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "Skills_SpecializationsFileDescription2 is not present");
			}
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(LandingPageValidation_PageObjects.Skills_SpecializationsFileDownload2Xpath)));
			WebElement Skills_SpecializationsFileDownload2Xpath =driver.findElement(By.xpath(LandingPageValidation_PageObjects.Skills_SpecializationsFileDownload2Xpath));
			Skills_SpecializationsFileDownload2Xpath.click();
			if(Skills_SpecializationsFileDownload2Xpath.isDisplayed()) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "Skills_SpecializationsFileDownload2 is present");

			}
			else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "Skills_SpecializationsFileDownload2 is not present");
			}
			LPVTest_report.flush();


		}
		catch(Exception b) {
			System.out.println(b);
			LandingPageValidation_GetExtentReports.Exception(driver, LPVTest_test, b);
			LPVTest_report.flush();
		}




	}
	  */
	public static void Approver_Widgets_Validation(WebDriver driver, ExtentTest LPVTest_test,
			ExtentReports LPVTest_report) 
	{
		try {

			Properties prop=PropertyfileConfig.Propertyfile();
			if(driver.findElements(LandingPageValidation_PageObjects.webNavigationClose).size()!=0) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "Welcome PopUp Displayed in Landing Page");
				driver.findElement(LandingPageValidation_PageObjects.webNavigationClose).click();
			}else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "Welcome PopUp Not Displayed in Landing Page");
			}



		}
		catch (Exception E)
		{
			getResult(E,driver, LPVTest_test);
		}



	}

	public static void Resource_validation(WebDriver driver, ExtentTest LPVTest_test, ExtentReports LPVTest_report) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement MyResourcesHomeBT = driver.findElement(By.xpath(LandingPageValidation_PageObjects.MyResourcesButton));
		if (MyResourcesHomeBT.isDisplayed()) 
		{
			LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "My Resources Hyperlink has been clicked");
			MyResourcesHomeBT.click();	
		}

		WebElement MYRTitle = driver.findElement(By.xpath(LandingPageValidation_PageObjects.MyResourcessideheadingXpath));
		if (MYRTitle.isDisplayed()) 
		{
			LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "My Resources Title is present");	
		}
		WebElement FAQSearchBox = driver.findElement(By.xpath(LandingPageValidation_PageObjects.FAQSearchBox));

		if (FAQSearchBox.isDisplayed()) 
		{
			LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "FAQ Section search Box is present");
		}
		FAQSearchBox.sendKeys("Tree"+Keys.ENTER);

		WebElement Invalidserachtext = driver.findElement(By.xpath(LandingPageValidation_PageObjects.Invalidsearch));
		if (Invalidserachtext.isDisplayed()) 
		{
			LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "InValid Search Text is present");
		}

		WebElement ViewmoreFAQ = driver.findElement(By.xpath(LandingPageValidation_PageObjects.ViewmoreFAQ));
		if (ViewmoreFAQ.isDisplayed()) 
		{
			LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "View more hyperlink under FAQ is present");	
		}

		ViewmoreFAQ.click();

		WebElement Clickhere_Q1 = driver.findElement(By.xpath(LandingPageValidation_PageObjects.ClickhereFAQ_Ques));
		if (Clickhere_Q1.isDisplayed()) 
		{
			LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "Click here hyperlink is present");
		}

		Clickhere_Q1.click();









	} 

}



/*******************************Resource Document Download Section*******************************************************/
/*public static void resource_document_download_validation(WebDriver driver, ExtentTest LPVTest_test, ExtentReports LPVTest_report)
	{
		try {
		WebDriverWait wait = new WebDriverWait(driver,20);	
		JavascriptExecutor js = (JavascriptExecutor) driver;

		if(driver.findElements(LandingPageValidation_PageObjects.webNavigationClose).size()!=0) {
			LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "Welcome PopUp Displayed in Landing Page");
			driver.findElement(LandingPageValidation_PageObjects.webNavigationClose).click();
		}else {
			LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "Welcome PopUp Not Displayed in Landing Page");
		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LandingPageValidation_PageObjects.MyResourcesButtonXpath)));
		WebElement MyResourceButton = driver.findElement(By.xpath(LandingPageValidation_PageObjects.MyResourcesButtonXpath));
		if (MyResourceButton.isDisplayed()) { 
			LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test,"Resource Button is present in the Homepage" );
		}
			else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test,"Resource Button is not present in the HomePage");	

			}
		MyResourceButton.click();
		String Mainpage = driver.getWindowHandle();
	    Thread.sleep(5000);

	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LandingPageValidation_PageObjects.AboutmycompetencyFileDownloadbuttonXpath)));
	    WebElement AboutmycompetencyFileDownloadbutton = driver.findElement(By.xpath(LandingPageValidation_PageObjects.AboutmycompetencyFileDownloadbuttonXpath));
	    if (AboutmycompetencyFileDownloadbutton.isDisplayed()) {
		 LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "file is downloading ");
	    }
	    else {
		 LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "file is not downloading");
	    }
		Set<String> AllWindow = driver.getWindowHandles();
		for (String Windows : AllWindow)
		{
		driver.switchTo().window(Windows);
		Thread.sleep(5000);

		}
		driver.close();
		driver.switchTo().window(Mainpage);

		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LandingPageValidation_PageObjects.mycompetencylogoXpath)));
		    WebElement mycompetencylogoXpath = driver.findElement(By.xpath(LandingPageValidation_PageObjects.mycompetencylogoXpath));
		    mycompetencylogoXpath.click();
		    if (mycompetencylogoXpath.isDisplayed()) {
			 LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "should navigate to new landing page ");
		    }
		    else {
			 LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "should not navigate to new landing page");
		    }
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LandingPageValidation_PageObjects.MyResourcesButtonXpath)));
			WebElement MyResourceButton1 = driver.findElement(By.xpath(LandingPageValidation_PageObjects.MyResourcesButtonXpath));
			if (MyResourceButton.isDisplayed()) { 
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test,"Resource Button is present in the Homepage" );
			}
				else {
					LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test,"Resource Button is not present in the HomePage");	

				}
			MyResourceButton.click();
		}
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LandingPageValidation_PageObjects.MyjourneytabXpath)));
		 WebElement Myjourneytab = driver.findElement(By.xpath(LandingPageValidation_PageObjects.MyjourneytabXpath));
		// js.executeScript("arguments[0].scrollIntoView();",Myjourneytab);
		 //js.executeScript("arguments[0].click();",Myjourneytab);
		 Myjourneytab.click();
		 if (Myjourneytab.isDisplayed()) {
	    	 LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "Myjourney tab is opened/displayed");
		}
		 else {
			 LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "Myjourney tab is not opened/displayed");
		   }
		 String Mainpage = driver.getWindowHandle();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LandingPageValidation_PageObjects.MyjourneyFileDownloadFY23ExpertsQ1Q2Xpath)));
			WebElement MyjourneyFileDownloadFY23ExpertsQ1Q2Xpath =driver.findElement(By.xpath(LandingPageValidation_PageObjects.MyjourneyFileDownloadFY23ExpertsQ1Q2Xpath));
			MyjourneyFileDownloadFY23ExpertsQ1Q2Xpath.click();
			if(MyjourneyFileDownloadFY23ExpertsQ1Q2Xpath.isDisplayed()) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "MyjourneyFileNameFY23ExpertsQ1Q2 file downaload is happened");
			}
			else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "MyjourneyFileNameFY23ExpertsQ1Q2 file downaload is not  happened");
			}
			Thread.sleep(5000);
			Set<String> AllWindow = driver.getWindowHandles();
			for (String Windows : AllWindow)
			{
			driver.switchTo().window(Windows);
			Thread.sleep(5000);

			}
			driver.close();
			driver.switchTo().window(Mainpage);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LandingPageValidation_PageObjects.mycompetencylogoXpath)));
		    WebElement mycompetencylogoXpath = driver.findElement(By.xpath(LandingPageValidation_PageObjects.mycompetencylogoXpath));
		    mycompetencylogoXpath.click();
		    if (mycompetencylogoXpath.isDisplayed()) {
			 LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "should navigate to new landing page ");
		    }
		    else {
			 LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "should not navigate to new landing page");
		    }
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LandingPageValidation_PageObjects.MyResourcesButtonXpath)));
			WebElement MyResourceButton1 = driver.findElement(By.xpath(LandingPageValidation_PageObjects.MyResourcesButtonXpath));
			MyResourceButton1.click();
			if (MyResourceButton1.isDisplayed()) { 
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test,"Resource Button is present in the Homepage" );
			}
				else {
					LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test,"Resource Button is not present in the HomePage");	

				}

	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LandingPageValidation_PageObjects.CertificationsxPath)));
	        WebElement CertificationsxPath =driver.findElement(By.xpath(LandingPageValidation_PageObjects.CertificationsxPath));
	        CertificationsxPath.click();		
	        if(CertificationsxPath.isDisplayed()) {
		    LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "CertificationsxPath tab is present");
	        }
	        else {
		    LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "CertificationsxPath tab is not present");
	        }
	        String Mainpage = driver.getWindowHandle();
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LandingPageValidation_PageObjects.CertificationFileDownload)));
			WebElement CertificationFileDownload =driver.findElement(By.xpath(LandingPageValidation_PageObjects.CertificationFileDownload));
			CertificationFileDownload.click();
			if(CertificationFileDownload.isDisplayed()) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "Certification file downlaoad is happened");
			}
			else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "Certification file downlaoad is not happened");
			}
			Thread.sleep(5000);
			Set<String> AllWindow = driver.getWindowHandles();
			for (String Windows : AllWindow)
			{
			driver.switchTo().window(Windows);
			Thread.sleep(5000);

			}
			driver.close();
			driver.switchTo().window(Mainpage);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LandingPageValidation_PageObjects.mycompetencylogoXpath)));
		    WebElement mycompetencylogoXpath = driver.findElement(By.xpath(LandingPageValidation_PageObjects.mycompetencylogoXpath));
		    mycompetencylogoXpath.click();
		    if (mycompetencylogoXpath.isDisplayed()) {
			 LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "should navigate to new landing page ");
		    }
		    else {
			 LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "should not navigate to new landing page");
		    }
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LandingPageValidation_PageObjects.MyResourcesButtonXpath)));
			WebElement MyResourceButton1 = driver.findElement(By.xpath(LandingPageValidation_PageObjects.MyResourcesButtonXpath));
			MyResourceButton1.click();
			if (MyResourceButton1.isDisplayed()) { 
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test,"Resource Button is present in the Homepage" );
			}
				else {
					LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test,"Resource Button is not present in the HomePage");	

				}
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(LandingPageValidation_PageObjects.Skills_SpecializationsxPath)));
			WebElement Skills_SpecializationsxPath =driver.findElement(By.xpath(LandingPageValidation_PageObjects.Skills_SpecializationsxPath));
			Skills_SpecializationsxPath.click();
			if(Skills_SpecializationsxPath.isDisplayed()) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "Skills_SpecializationsxPath is present");

			}
			else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "Skills_SpecializationsxPath is not present");
			}
			String Mainpage = driver.getWindowHandle();
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LandingPageValidation_PageObjects.Skills_SpecializationFileDownload)));
			WebElement Skills_SpecializationFileDownload =driver.findElement(By.xpath(LandingPageValidation_PageObjects.Skills_SpecializationFileDownload));
			Skills_SpecializationFileDownload.click();
			if(Skills_SpecializationFileDownload.isDisplayed()) {
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "Certification file downlaoad is happened");
			}
			else {
				LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "Certification file downlaoad is not happened");
			}
			Thread.sleep(5000);
			Set<String> AllWindow = driver.getWindowHandles();
			for (String Windows : AllWindow)
			{
			driver.switchTo().window(Windows);
			Thread.sleep(5000);

			}
			driver.close();
			driver.switchTo().window(Mainpage);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LandingPageValidation_PageObjects.mycompetencylogoXpath)));
		    WebElement mycompetencylogoXpath = driver.findElement(By.xpath(LandingPageValidation_PageObjects.mycompetencylogoXpath));
		    mycompetencylogoXpath.click();
		    if (mycompetencylogoXpath.isDisplayed()) {
			 LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test, "should navigate to new landing page ");
		    }
		    else {
			 LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test, "should not navigate to new landing page");
		    }
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LandingPageValidation_PageObjects.MyResourcesButtonXpath)));
			WebElement MyResourceButton1 = driver.findElement(By.xpath(LandingPageValidation_PageObjects.MyResourcesButtonXpath));
			MyResourceButton1.click();
			if (MyResourceButton1.isDisplayed()) { 
				LandingPageValidation_GetExtentReports.PassTest(driver, LPVTest_test,"Resource Button is present in the Homepage" );
			}
				else {
					LandingPageValidation_GetExtentReports.FailTest(driver, LPVTest_test,"Resource Button is not present in the HomePage");	

				}
	}
			catch(Exception b) {
				System.out.println(b);
				LandingPageValidation_GetExtentReports.Exception(driver, LPVTest_test, b);
				LPVTest_report.flush();
			}
			} */


