
package CommonMethods;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;


@Test
public class DatabaseConnectivity {

	static Properties prop = PropertyfileConfig.Propertyfile();

	public static Connection DB_Configuration() throws ClassNotFoundException, SQLException
	{		

		String Environment = prop.getProperty("Main_Url");
		Connection con;
		if (Environment.contains("https://mycompetency-web.ciostage.accenture.com/")) 
		{   //New Stage
			String Server = "2113-mi-stg-mycompetency-03.7d33ecfb3a7b.database.windows.net";
			String DatabaseName = "2113_AbacuCompeAssesManagSyste_Stg";
			String url = "jdbc:sqlserver://"+Server+":1433;databaseName="+DatabaseName+";";
			String dbClass = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
			System.out.println(url);
			Class.forName(dbClass);
			String user = "2113_STAGE_SQL_VendrReq_Micro";
			String pass = "LjYGvz9sycNaI8c3";
			con = DriverManager.getConnection(url,user,pass);
		}
		else if (Environment.contains("https://mycompetency-dev.container.accenture.com")) 
		{   //Dev Stage
			String Server = "2113-mi-dev-mycompetency-01.4158f24f78a1.database.windows.net";
			String DatabaseName = "2113_MycomIdc_Dev";
			String url = "jdbc:sqlserver://"+Server+":1433;databaseName="+DatabaseName+";";
			String dbClass = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
			System.out.println(url);
			Class.forName(dbClass);
			String user = "2113_Dev_MI_Container_INI";
			String pass = "MECAL=bJVE69-h9w";
			con = DriverManager.getConnection(url,user,pass);

		}
		else if (Environment.contains("https://mycompetency-web1.ciostage.accenture.com/#/home")) 
		{   //Old Stage
			String Server = "2113-mi-stg-mycompetency-03.7d33ecfb3a7b.database.windows.net";
			String DatabaseName = "2113_AbacuCompeAssesManagSyste_Stg";
			String url = "jdbc:sqlserver://"+Server+":1433;databaseName="+DatabaseName+";";
			String dbClass = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
			System.out.println(url);
			Class.forName(dbClass);
			String user = "2113_STAGE_SQL_VendrReq_Micro";
			String pass = "LjYGvz9sycNaI8c3";
			con = DriverManager.getConnection(url,user,pass);
		}
		else 
		{
			//Pilot Stage
			String Server = "2113-mi-stg-mycompetency-01.7d33ecfb3a7b.database.windows.net";
			String DatabaseName = "2113_myComIDC_Pilot";
			String url = "jdbc:sqlserver://"+Server+":1433;databaseName="+DatabaseName+";";
			String dbClass = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
			System.out.println(url);
			Class.forName(dbClass);
			String user = "2113_MI_INI";
			String pass = "Positive@100";
			con = DriverManager.getConnection(url,user,pass);
		}
		return con;
	}

	
}

