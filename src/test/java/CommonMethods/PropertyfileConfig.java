package CommonMethods;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.testng.annotations.Test;

@Test
public class PropertyfileConfig 
{
	public static Properties Propertyfile() 
	{
		Properties prop = new Properties();
		try
		{
			File file = new File(System.getProperty("user.dir")+"\\Properties.properties");
			FileInputStream fileInput = null;
			fileInput = new FileInputStream(file);
			prop.load(fileInput);
		}
		catch(IOException  E)
		{
			System.out.println(E);		
		}
		return prop;
	}

}
