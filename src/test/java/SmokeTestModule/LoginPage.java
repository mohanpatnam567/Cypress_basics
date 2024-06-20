package SmokeTestModule;

import java.time.Duration;
import java.util.Properties;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import CommonMethods.PropertyfileConfig;
import SmokeTestModule.DriverSetup;

public class LoginPage {
	
	static Properties prop = PropertyfileConfig.Propertyfile();
	
	/**************Login Page Objects****************/
	public static String PasswordInputId = "i0118";
	public static String SignInButtonId = "idSIButton9";
	public static String SignInButtonProdId = "idSIButton9";
	public static String InputUserNameCssSelector = "input[name*=userName]";
	public static String InputPasswordCssSelector = "input[type*='password']";
	public static String LoginButtonCssSelector = "button[type*=submit]";  
	
	/********Azure Login Page Variables**********************/
	public static String EmailField = "input[type*=email]";
	public static String NextField = "input[type*=submit]";
	public static String StaySignedIn ="//div[2]/div/div[2]/div/div[1]";
	public static String StaySignedInNo = "idBtn_Back";
	public static String LoginHeaderPickAccount = "//div[@id='loginHeader']//div";
	public static String UseAnotherAccBtn = "//div[@id='otherTileText']";
	
	/********Authentication Login Page Variables**********************/
	public static String CallJioNumberXpath = "(//div[contains(@class,'table-cell text-left')])[2]";
	public static String CallVodafoneNumberXpath = "(//div[contains(@class,'table-cell text-left')])[3]";
	public static String TextVodafoneNumberXpath ="(//div[contains(@class,'table-cell text-left')])[1]";
	public static String AutenticationPage = "//div[@id='displayName']";
	public static String ApprovePageTitle = "//div[@id='idDiv_SAOTCC_Title']";
	public static String CallDisconnected = "//span[@id='idSpan_SAOTCC_Error_OTC']";
	public static String SignInAnotherWay = "//a[@id='signInAnotherWay']";


	public static void LoginUser(WebDriver driver,String User) throws InterruptedException
	{
		try 
		{
			if (driver.findElements(By.xpath(UseAnotherAccBtn)).size()!=0) 
			{
				driver.findElement(By.xpath(UseAnotherAccBtn)).click();
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(EmailField)));
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

				driver.findElement(By.cssSelector(EmailField)).sendKeys(prop.getProperty(User)+"@ds.dev.accenture.com");
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(NextField)));

				driver.findElement(By.cssSelector(NextField)).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(InputPasswordCssSelector)));
				driver.findElement(By.cssSelector(InputPasswordCssSelector)).sendKeys(prop.getProperty("Password"));
				driver.findElement(By.id(SignInButtonId)).click();
				
			} 
			else 
			{
				DriverSetup.ProdNavigation();
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(EmailField)));
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

				driver.findElement(By.cssSelector(EmailField)).sendKeys(prop.getProperty(User)+"@ds.dev.accenture.com");
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(NextField)));

				driver.findElement(By.cssSelector(NextField)).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(InputPasswordCssSelector)));
				driver.findElement(By.cssSelector(InputPasswordCssSelector)).sendKeys(prop.getProperty("Password"));
				driver.findElement(By.id(SignInButtonId)).click();

				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(StaySignedInNo)));
				driver.findElement(By.id(StaySignedInNo)).click();
			}
		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}
	}
	
	public static void LoginUserStage(WebDriver driver,String User) throws InterruptedException
	{
		try 
		{	
			if (driver.findElements(By.xpath(UseAnotherAccBtn)).size()!=0) 
			{
				driver.findElement(By.xpath(UseAnotherAccBtn)).click();
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(EmailField)));
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(500));

				driver.findElement(By.cssSelector(EmailField)).sendKeys(prop.getProperty(User)+"@ds.dev.accenture.com");
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(NextField)));

				driver.findElement(By.cssSelector(NextField)).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(InputPasswordCssSelector)));
				driver.findElement(By.cssSelector(InputPasswordCssSelector)).sendKeys(prop.getProperty("Password"));
				driver.findElement(By.id(SignInButtonId)).click();
				
			} 
			else 
			{
				DriverSetup.SiteNavigation();
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(500));
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(EmailField)));
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(500));

				driver.findElement(By.cssSelector(EmailField)).sendKeys(prop.getProperty(User)+"@ds.dev.accenture.com");
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(NextField)));

				driver.findElement(By.cssSelector(NextField)).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(InputPasswordCssSelector)));
				driver.findElement(By.cssSelector(InputPasswordCssSelector)).sendKeys(prop.getProperty("Password"));
				driver.findElement(By.id(SignInButtonId)).click();

				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(StaySignedInNo)));
				driver.findElement(By.id(StaySignedInNo)).click();
			}
		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}
	}
	
	public static void UserLogin_Prod(WebDriver driver)
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(EmailField)));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

			driver.findElement(By.cssSelector(EmailField)).sendKeys("preeti.rajarajan@accenture.com");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(NextField)));

			driver.findElement(By.cssSelector(NextField)).click();
			/*wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(InputPasswordCssSelector)));
			driver.findElement(By.cssSelector(InputPasswordCssSelector)).sendKeys("IamBeautiful@2023");
			driver.findElement(By.id(SignInButtonProdId)).click();*/
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(AutenticationPage)));
			WebElement JioNumber = driver.findElement(By.xpath(CallJioNumberXpath));
			executor.executeScript("arguments[0].click();", JioNumber);
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ApprovePageTitle)));
			System.out.println("Please attend the call in the mobile phone");
			
			try
			{
				if (driver.findElements(By.xpath(PageObjects.ExtraAutenticationPopup)).size()!=0)
				{
					WebElement Notnow = driver.findElement(By.xpath(PageObjects.ExtraAutenticationPopup));
					executor.executeScript("arguments[0].click();", Notnow);
				}
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PageObjects.HamMenuButtonCssSelector)));
				
				if (driver.findElements(By.xpath(PageObjects.PlannedDownTimeXpath)).size()!=0)
				{
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PageObjects.PlannedDownTimeCloseBtnXpath)));
					WebElement CloseBtn = driver.findElement(By.xpath(PageObjects.PlannedDownTimeCloseBtnXpath));
					executor.executeScript("arguments[0].click();", CloseBtn);
				}
			}
			catch (Exception e)
			{
				if (driver.findElements(By.xpath(CallDisconnected)).size() == 0)
				{
					System.out.println("Employee Logged In Successfully");
				}
				else
				{
					WebElement AnotherWay = driver.findElement(By.xpath(SignInAnotherWay));
					executor.executeScript("arguments[0].click();", AnotherWay);
					
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(AutenticationPage)));
					
					WebElement VodafoneNumber = driver.findElement(By.xpath(CallVodafoneNumberXpath));
					executor.executeScript("arguments[0].click();", VodafoneNumber);
				}
				
				try
				{
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PageObjects.HamMenuButtonCssSelector)));
				}
				catch (Exception e2)
				{}
				
				if (driver.findElements(By.xpath(PageObjects.PlannedDownTimeXpath)).size()!=0)
				{
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PageObjects.PlannedDownTimeCloseBtnXpath)));
					WebElement CloseBtn = driver.findElement(By.xpath(PageObjects.PlannedDownTimeCloseBtnXpath));
					executor.executeScript("arguments[0].click();", CloseBtn);
				}
			}
			
			
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}
	
	public static void AdminLogin_Prod(WebDriver driver)
	{
		driver.findElement(By.id(PageObjects.UserNameInputId)).sendKeys("arun.anthony.reethal");
		System.out.println("Please Enter the Login Password Code & Press Enter:");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		@SuppressWarnings("resource")
		Scanner scan1 = new Scanner(System.in);
		String input1 = scan1.nextLine();
		driver.findElement(By.id(PageObjects.PasswordInputId)).sendKeys(input1);
		driver.findElement(By.id(PageObjects.SignInButtonId)).click();
		SkillValidations.SymantecVerification(driver);
}
	
	public static void ProjectSupervisorLogin_Prod(WebDriver driver)
	{
		driver.findElement(By.id(PageObjects.UserNameInputId)).sendKeys("arun.anthony.reethal");
		System.out.println("Please Enter the Login Password Code & Press Enter:");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		@SuppressWarnings("resource")
		Scanner scan1 = new Scanner(System.in);
		String input1 = scan1.nextLine();

		driver.findElement(By.id(PageObjects.PasswordInputId)).sendKeys(input1);
		driver.findElement(By.id(PageObjects.SignInButtonId)).click();
		SkillValidations.SymantecVerification(driver);
	}
	
	public static void SupervisorLogin_Prod(WebDriver driver)
	{
		driver.findElement(By.id(PageObjects.UserNameInputId)).sendKeys("arun.anthony.reethal");
		System.out.println("Please Enter the Login Password Code & Press Enter:");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		@SuppressWarnings("resource")
		Scanner scan1 = new Scanner(System.in);
		String input1 = scan1.nextLine();

		driver.findElement(By.id(PageObjects.PasswordInputId)).sendKeys(input1);
		driver.findElement(By.id(PageObjects.SignInButtonId)).click();
		SkillValidations.SymantecVerification(driver);
	}

	public static void Applicationlogout(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PageObjects.HamMenuButtonCssSelector)));
		driver.findElement(By.cssSelector(PageObjects.HamMenuButtonCssSelector)).click();
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PageObjects.LogoutButtonCssselector)));
		driver.findElement(By.cssSelector(PageObjects.LogoutButtonCssselector)).click();
	}

}

