package CommonMethods;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class LoginPage extends DriverSetup {

	/**************Login Page Objects****************/
	public static String PasswordInputId = "i0118";
	public static String SignInButtonId = "idSIButton9";
	public static String InputUserNameCssSelector = "input[name*=userName]";
	public static String InputPasswordCssSelector = "input[type*='password']";
	public static String LoginButtonCssSelector = "button[type*=submit]";  
	public static String OTPField1xpath = "(//div//input[contains(@class,'otp-val text-center')])[1]";
	public static String OTPField2xpath = "(//div//input[contains(@class,'otp-val text-center')])[2]";
	public static String OTPField3xpath = "(//div//input[contains(@class,'otp-val text-center')])[3]";
	public static String OTPField4xpath = "(//div//input[contains(@class,'otp-val text-center')])[4]";
	public static String OTPField5xpath = "(//div//input[contains(@class,'otp-val text-center')])[5]";
	public static String OTPField6xpath = "(//div//input[contains(@class,'otp-val text-center')])[6]";
	public static String MettlOTPpageSubmitBtn = "//div//button[@class='btn btn-blue']";

	/********Azure Login Page Variables**********************/
	public static String EmailField = "input[type*=email]";
	public static String NextField = "input[type*=submit]";
	public static String StaySignedIn ="//div[2]/div/div[2]/div/div[1]";
	public static String StaySignedInNo = "idBtn_Back";
	public static String LoginHeaderPickAccount = "//div[@id='loginHeader']//div";
	public static String UseAnotherAccBtn = "//div[@id='otherTileText']";

	public static void LoginUser(WebDriver driver,String User) throws InterruptedException
	{
		try 
		{	
			if (driver.findElements(By.xpath(UseAnotherAccBtn)).size()!=0) 
			{
				driver.findElement(By.xpath(UseAnotherAccBtn)).click();
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(500));
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

	public static void MettlLogin_Stage(WebDriver driver) throws InterruptedException
	{

		try {

			driver.findElement(By.cssSelector(InputUserNameCssSelector)).sendKeys(prop.getProperty("Mettl_UserName"));
			driver.findElement(By.cssSelector(InputPasswordCssSelector)).sendKeys(prop.getProperty("Mettl_Password"));
			driver.findElement(By.cssSelector(LoginButtonCssSelector)).click();

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
			if (driver.findElements(By.xpath(OTPField1xpath)).size()!=0) 
			{
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("Kindly Enter the Mettl OTP ");
				String FullOTP = br.readLine();

				if (FullOTP.length() == 6) 
				{
					int IntFullOTP = Integer.valueOf(FullOTP);
					int OTPFieldSix  =  IntFullOTP % 10;
					int OTPFieldFive =  ( IntFullOTP - OTPFieldSix ) % 100 / 10;
					int OTPFieldFour  =  ( IntFullOTP - OTPFieldSix - OTPFieldFive ) % 1000 / 100;
					int OTPFieldThree =  ( IntFullOTP - OTPFieldSix - OTPFieldFive - OTPFieldFour ) % 10000 / 1000;
					int OTPFieldTwo =  ( IntFullOTP - OTPFieldSix - OTPFieldFive - OTPFieldFour - OTPFieldThree ) % 100000 / 10000;
					int OTPFieldOne =  ( IntFullOTP - OTPFieldSix - OTPFieldFive - OTPFieldFour - OTPFieldThree ) % 1000000 / 100000;

					System.out.println("OTP Entered By The User:"+IntFullOTP);

					WebElement OTPField1 = driver.findElement(By.xpath(OTPField1xpath));
					OTPField1.sendKeys(Integer.toString(OTPFieldOne));

					WebElement OTPField2 = driver.findElement(By.xpath(OTPField2xpath));
					OTPField2.sendKeys(Integer.toString(OTPFieldTwo));

					WebElement OTPField3 = driver.findElement(By.xpath(OTPField3xpath));
					OTPField3.sendKeys(Integer.toString(OTPFieldThree));

					WebElement OTPField4 = driver.findElement(By.xpath(OTPField4xpath));
					OTPField4.sendKeys(Integer.toString(OTPFieldFour));

					WebElement OTPField5 = driver.findElement(By.xpath(OTPField5xpath));
					OTPField5.sendKeys(Integer.toString(OTPFieldFive));

					WebElement OTPField6 = driver.findElement(By.xpath(OTPField6xpath));
					OTPField6.sendKeys(Integer.toString(OTPFieldSix));

					WebElement SubmitOTPbtn = driver.findElement(By.xpath(MettlOTPpageSubmitBtn));
					SubmitOTPbtn.click();
				} 
				else 
				{
					System.out.println("Please enter the OTP in 6 Digits");
				}
			}
			else 
			{
				System.out.println("OTP is not asked for Mettl");
			}
		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}

	}

}

