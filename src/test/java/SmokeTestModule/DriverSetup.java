
package SmokeTestModule;



import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;



import CommonMethods.PropertyfileConfig;
import io.github.bonigarcia.wdm.WebDriverManager;

@Test
public class DriverSetup {

	public static WebDriver driver;
	public static Properties prop = PropertyfileConfig.Propertyfile();
	

	public static void BrowserSelection()
	{
		String browser = prop.getProperty("Browser");
		if(browser.contains("Chrome"))
		{
			WebDriverManager.chromedriver().version("109.0.5414.74").setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			driver = new ChromeDriver(options);
		}
		else if(browser.contains("IE"))
		{
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
		}
		else if(browser.contains("Edge"))
		{
			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"\\driver\\msedgedriver.exe");
			EdgeOptions options = new EdgeOptions();
			options.addArguments("-inprivate");
			driver = new EdgeDriver(options);
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();  
		}
	}

	public static void SiteNavigation()
	{
		driver.get(prop.getProperty("Main_Url"));
	}

	public static void ProdNavigation()
	{
		driver.get("https://mycompetency.accenture.com");
	}

	public static void MettlSiteNavigation()
	{
		driver.get(prop.getProperty("Mettl_Url"));
	}

	public static WebDriver getDriver() 
	{
		DriverSetup.BrowserSelection();
		return driver;
	}



}