package CommonMethods;

 
 
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.testng.annotations.Test;



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

            WebDriverManager.chromedriver().version("107.0.5304.62").setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
            driver = new ChromeDriver(options);
        }
        else if(browser.contains("IE"))
        {
        	WebDriverManager.iedriver().setup();
            InternetExplorerOptions capabilities = new InternetExplorerOptions();
            capabilities.ignoreZoomSettings();
            capabilities.setCapability(InternetExplorerDriver.IE_SWITCHES, "-private");
            capabilities.introduceFlakinessByIgnoringSecurityDomains();
            capabilities.addCommandSwitches("-private");
            driver = new InternetExplorerDriver(capabilities);
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
        }
        else if(browser.contains("Edge"))
        {
        	System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"\\driver\\msedgedriver.exe");
        	//WebDriverManager.edgedriver().version("101.0.1210.39").setup();
        	EdgeOptions options = new EdgeOptions();
        	options.addArguments("-inprivate");
        	options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
        	//options.setExperimentalOption("useAutomationExtension", false);
            driver = new EdgeDriver(options);
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
        }
    }

    public static void SiteNavigation()
    {
        driver.get(prop.getProperty("Main_Url"));
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