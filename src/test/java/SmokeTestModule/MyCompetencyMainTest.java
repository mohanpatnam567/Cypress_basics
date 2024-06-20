package SmokeTestModule;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import LandingPageValidation.LandingPageValidation_CommonMethods;
import SmokeTestModule.DriverSetup;

public class MyCompetencyMainTest {


	static WebDriver driver;
	static String Browser = "Chrome";
	static ExtentReports SmokeTest_report;
	static ExtentTest SmokeTest_test;

	public static void TestCase_ID_01()
	{	
		try
		{
			String TestCaseID = "TestCase_ID_01";
			SmokeTest_GetExtentReports.GetExtentReports_StartReports("TestCase_ID_01");
			SmokeTest_report = SmokeTest_GetExtentReports.getReport();
			SmokeTest_test = SmokeTest_report.createTest("HomePage Validation");

			SkillValidations.HomePageValidation(driver, Browser, TestCaseID, SmokeTest_test);
			SmokeTest_test = SmokeTest_report.createTest("Footer and Feedback Validation in myCompetency");

			SkillValidations.FooterAndFeedBackValidation(driver, TestCaseID, TestCaseID, SmokeTest_test);
			SmokeTest_test = SmokeTest_report.createTest("AboutSection in myCompetency");

			SkillValidations.LearnAboutMyCompetencyCheck(driver, Browser, TestCaseID, SmokeTest_test);
			SmokeTest_test = SmokeTest_report.createTest("Skill Accelerator Guide in HomePage");

			SkillValidations.SkillAcceleratorGuidance_HomePage_Validation(driver, Browser, TestCaseID, SmokeTest_test);
			SmokeTest_report.flush();
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, e.getMessage());
		}
	}

	public static void TestCase_ID_02()
	{	
		try
		{
			String TestCaseID = "TestCase_ID_02";
			SmokeTest_GetExtentReports.GetExtentReports_StartReports("TestCase_ID_02");
			SmokeTest_report = SmokeTest_GetExtentReports.getReport();
			SmokeTest_test = SmokeTest_report.createTest("Admin Menu Availability Validation");
			SkillValidations.AdminMenuAvailabiltyValidation(driver, Browser, TestCaseID, SmokeTest_test);
			SmokeTest_report.flush();
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, e.getMessage());
		}
	}

	public static void TestCase_ID_03()
	{	
		try
		{
			String TestCaseID = "TestCase_ID_03";
			SmokeTest_GetExtentReports.GetExtentReports_StartReports("TestCase_ID_03");
			SmokeTest_report = SmokeTest_GetExtentReports.getReport();

			SmokeTest_test = SmokeTest_report.createTest("Primary Skill Home and Journey Validation");
			SkillValidations.PrimarySkillCardCheck(driver, Browser, TestCaseID, SmokeTest_test);
			SmokeTest_test = SmokeTest_report.createTest("Secondary Skill Home and Journey Validation");
			SkillValidations.SecondarySkillCardCheck(driver, Browser, TestCaseID, SmokeTest_test);

			SmokeTest_report.flush();
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, e.getMessage());
		}
	}

	public static void TestCase_ID_04()
	{	
		try
		{
			String TestCaseID = "TestCase_ID_04";
			SmokeTest_GetExtentReports.GetExtentReports_StartReports("TestCase_ID_04");
			SmokeTest_report = SmokeTest_GetExtentReports.getReport();

			SmokeTest_test = SmokeTest_report.createTest("Admin Menu Validations");
			SkillValidations.AdminMenuValidation(driver, Browser, TestCaseID, SmokeTest_test);
			SmokeTest_report.flush();
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, e.getMessage());
		}
	}

	public static void TestCase_ID_05()
	{	
		try
		{
			String TestCaseID = "TestCase_ID_05";
			SmokeTest_GetExtentReports.GetExtentReports_StartReports("TestCase_ID_05");
			SmokeTest_report = SmokeTest_GetExtentReports.getReport();

			SmokeTest_test = SmokeTest_report.createTest("Upload Page Navigation");
			SkillValidations.UploadPageNavigation(driver, Browser, TestCaseID, SmokeTest_test);
			SmokeTest_report.flush();
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, e.getMessage());
		}
	}

	public static void TestCase_ID_06()
	{	
		try
		{
			String TestCaseID = "TestCase_ID_06";
			SmokeTest_GetExtentReports.GetExtentReports_StartReports("TestCase_ID_06");
			SmokeTest_report = SmokeTest_GetExtentReports.getReport();

			SmokeTest_test = SmokeTest_report.createTest("Assessment Settings Page Validation");
			SkillValidations.AssessmentsettingspageValidation(driver, Browser, TestCaseID, SmokeTest_test);
			SmokeTest_report.flush();
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, e.getMessage());
		}
	}

	public static void TestCase_ID_07()
	{	
		try
		{
			String TestCaseID = "TestCase_ID_07";
			SmokeTest_GetExtentReports.GetExtentReports_StartReports("TestCase_ID_07");
			SmokeTest_report = SmokeTest_GetExtentReports.getReport();

			SmokeTest_test = SmokeTest_report.createTest("My Skill History Page Validation");
			SkillValidations.MySkillHistoryPageValidation(driver, Browser, TestCaseID, SmokeTest_test);
			SmokeTest_report.flush();
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, e.getMessage());
		}
	}

	public static void TestCase_ID_08()
	{	
		try
		{
			String TestCaseID = "TestCase_ID_08";
			SmokeTest_GetExtentReports.GetExtentReports_StartReports("TestCase_ID_08");
			SmokeTest_report = SmokeTest_GetExtentReports.getReport();

			SmokeTest_test = SmokeTest_report.createTest("Primary Skill Card Validation for Employee");
			SkillChange.PrimarySkillCardValidation(driver, Browser, TestCaseID, SmokeTest_test);

			SmokeTest_test = SmokeTest_report.createTest("Secondary Skill Card Validation for Employee");
			SkillChange.SecondarySkillCardValidation(driver, Browser, TestCaseID, SmokeTest_test);

			SmokeTest_report.flush();
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, e.getMessage());
		}
	}

	public static void Production_TestCase_ID_08()
	{	
		try
		{
			String TestCaseID = "Production_TestCase_ID_08";
			SmokeTest_GetExtentReports.GetExtentReports_StartReports("Production_TestCase_ID_08");
			SmokeTest_report = SmokeTest_GetExtentReports.getReport();

			SmokeTest_test = SmokeTest_report.createTest("Home Page Validation");
			SkillValidations.HomePageValidation(driver, Browser, TestCaseID, SmokeTest_test);

			SmokeTest_test = SmokeTest_report.createTest("Learn About myCompetency Section");
			SkillValidations.LearnAboutMyCompetencyCheck(driver, Browser, TestCaseID, SmokeTest_test);
			SkillValidations.AskDIPAClick(driver, Browser, TestCaseID);

			SmokeTest_test = SmokeTest_report.createTest("Primary Skill Card Validation for Employee");
			SkillChange.PrimarySkillCardValidation(driver, Browser, TestCaseID, SmokeTest_test);

			SmokeTest_test = SmokeTest_report.createTest("Secondary Skill Card Validation for Employee");
			SkillChange.SecondarySkillCardValidation(driver, Browser, TestCaseID, SmokeTest_test);

			SmokeTest_report.flush();
			SkillValidations.SupervisorNameClick(driver, Browser, TestCaseID);
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, e.getMessage());
		}
	}

	public static void TestCase_ID_09()
	{	
		try
		{
			String TestCaseID = "TestCase_ID_09";
			SmokeTest_GetExtentReports.GetExtentReports_StartReports("TestCase_ID_09");
			SmokeTest_report = SmokeTest_GetExtentReports.getReport();
			SmokeTest_test = SmokeTest_report.createTest("Home Page Validation");
			SkillValidations.HomePageValidation(driver, Browser, TestCaseID, SmokeTest_test);
			System.out.println("Home Page Validation done");

			SmokeTest_test = SmokeTest_report.createTest("Skill Accelerator Guide in HomePage");
			SkillValidations.SkillAcceleratorGuidance_HomePage_Validation(driver, Browser, TestCaseID, SmokeTest_test);
			System.out.println("Skill Accelerator Guide in HomePage done");

			SmokeTest_test = SmokeTest_report.createTest("Footer and Feedback Validation in myCompetency");
			SkillValidations.FooterAndFeedBackValidation(driver, TestCaseID, TestCaseID, SmokeTest_test);
			System.out.println("Footer and Feedback Validation in myCompetency done");

			SmokeTest_test = SmokeTest_report.createTest("Footer Links Validation in myCompetency");
			SkillValidations.FooterLinksValidation(driver, TestCaseID, TestCaseID, SmokeTest_test);

			SmokeTest_test = SmokeTest_report.createTest("AboutSection in myCompetency");
			SkillValidations.LearnAboutMyCompetencyCheck(driver, Browser, TestCaseID, SmokeTest_test);
			System.out.println("About Section in myCompetency done");

			SmokeTest_test = SmokeTest_report.createTest("Primary Skill Home and Journey Validation");
			SkillValidations.PrimarySkillCardCheck(driver, Browser, TestCaseID, SmokeTest_test);
			System.out.println("Primary Skill Home and Journey Validation done");

			SmokeTest_test = SmokeTest_report.createTest("Secondary Skill Home and Journey Validation");
			SkillValidations.SecondarySkillCardCheck(driver, Browser, TestCaseID, SmokeTest_test);
			System.out.println("Secondary Skill Home and Journey Validation done");

			SmokeTest_report.flush();
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, e.getMessage());
		}
	}


	public static void TestCase_ID_10()
	{	
		try
		{
			String TestCaseID = "TestCase_ID_10";
			SmokeTest_GetExtentReports.GetExtentReports_StartReports("TestCase_ID_10");
			SmokeTest_report = SmokeTest_GetExtentReports.getReport();

			SmokeTest_test = SmokeTest_report.createTest("Mettl Assessment Page");
			SkillValidations.MettlPageAssessment(driver, Browser, TestCaseID, SmokeTest_test);
			System.out.println("Mettl Assessment Page checking is done");

			SmokeTest_test = SmokeTest_report.createTest("Take Sample Assessment");
			SkillValidations.MettlSampleAssessment(driver, TestCaseID, TestCaseID, SmokeTest_test);
			System.out.println("Take Sample Assessment is done");

			SmokeTest_report.flush();
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, e.getMessage());
		}
	}

	public static void TestCase_ID_11()
	{	
		try
		{
			String TestCaseID = "TestCase_ID_11";
			SmokeTest_GetExtentReports.GetExtentReports_StartReports("TestCase_ID_11");
			SmokeTest_report = SmokeTest_GetExtentReports.getReport();

			SmokeTest_test = SmokeTest_report.createTest("Primary Skill Search in myCompetency");
			SkillChange.PrimarySkillSearch(driver, Browser, TestCaseID, SmokeTest_test);
			System.out.println("Primary Skill Search in myCompetency checking is done");
			driver.navigate().back();

			SmokeTest_test = SmokeTest_report.createTest("Secondary Skill Search in myCompetency");
			SkillChange.SecondarySkillSearch(driver, Browser, TestCaseID, SmokeTest_test);
			System.out.println("Secondary skill Search in myCompetency checking is done");
			driver.navigate().back();

			SmokeTest_report.flush();
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, e.getMessage());
		}
	}

	public static void TestCase_ID_12(String Environment)
	{	
		try
		{
			String TestCaseID = "TestCase_ID_12";
			SmokeTest_GetExtentReports.GetExtentReports_StartReports("TestCase_ID_12");
			SmokeTest_report = SmokeTest_GetExtentReports.getReport();

			SmokeTest_test = SmokeTest_report.createTest("Primary Skill Change Validation in myCompetency");
			SkillChange.ChangePrimarySkillValidations(driver, Browser, TestCaseID, SmokeTest_test,Environment);
			System.out.println("Primary Skill Change Validation in myCompetency is done");
			SmokeTest_report.flush();
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, e.getMessage());
		}
	}

	public static void Production_TestCase_ID_12()
	{	
		try
		{
			String TestCaseID = "TestCase_ID_12";
			SmokeTest_GetExtentReports.GetExtentReports_StartReports("TestCase_ID_12");
			SmokeTest_report = SmokeTest_GetExtentReports.getReport();

			SmokeTest_test = SmokeTest_report.createTest("Primary Skill Change Validation in myCompetency");
			SkillChange.ChangePrimarySkillValidations(driver, Browser, TestCaseID, SmokeTest_test,"Prod");
			SmokeTest_report.flush();
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, e.getMessage());
		}
	}

	public static void TestCase_ID_15()
	{
		try
		{
			String TestCaseID = "TestCase_ID_15";
			SmokeTest_GetExtentReports.GetExtentReports_StartReports("TestCase_ID_15");
			SmokeTest_report = SmokeTest_GetExtentReports.getReport();

			SmokeTest_test = SmokeTest_report.createTest("Add Secondary Skill Validation in myCompetency");
			SkillChange.AddSecondarySkillValidations(driver, Browser, TestCaseID, SmokeTest_test, "Stage");
			SmokeTest_report.flush();
		}
		catch (Exception e)
		{
			System.out.println(e);
			SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, e.getMessage());
		}
	}

	public static void Production_TestCase_ID_16()
	{	
		try
		{
			String TestCaseID = "Production_TestCase_ID_16";
			SmokeTest_GetExtentReports.GetExtentReports_StartReports("Production_TestCase_ID_16");
			SmokeTest_report = SmokeTest_GetExtentReports.getReport();

			SmokeTest_test = SmokeTest_report.createTest("Add Secondary Skill Page in myCompetency");
			SkillChange.AddSecondarySkillValidations(driver, Browser, TestCaseID, SmokeTest_test, "Prod");
			System.out.println("Add Secondary Skill Page in myCompetency is done");
			SmokeTest_report.flush();
		}
		catch (Exception e)
		{
			System.out.println(e);
			SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, e.getMessage());
		}
	}

	public static void TestCase_ID_17()
	{	
		try
		{
			String TestCaseID = "TestCase_ID_17";
			SmokeTest_GetExtentReports.GetExtentReports_StartReports("TestCase_ID_17");
			SmokeTest_report = SmokeTest_GetExtentReports.getReport();

			SmokeTest_test = SmokeTest_report.createTest("Delete Skill Button and Swap Button in myCompetency");
			SkillValidations.DeleteSkillAndSwapIcon(driver, Browser, TestCaseID, SmokeTest_test);
			System.out.println("Delete Skill Button and Swap Button in myCompetency checking is done");
			SmokeTest_report.flush();
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, e.getMessage());
		}
	}

	public static void TestCase_ID_18()
	{	
		try
		{
			SmokeTest_GetExtentReports.GetExtentReports_StartReports("TestCase_ID_18");
			SmokeTest_report = SmokeTest_GetExtentReports.getReport();

			SmokeTest_test = SmokeTest_report.createTest("Skills of Interest Tab in myCompetency");
			SkillValidations.SkillsOfInterestTabValidation(driver, Browser, SmokeTest_test);
			System.out.println("Skills of Interest Tab in myCompetency checking is done");
			SmokeTest_report.flush();
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, e.getMessage());
		}
	}

	//*************************Menu Sorting - ADMIN LOGIN**********************//

	public static void TC_19_MenuSortingAdmin() throws InterruptedException
	{
		try
		{
			SmokeTest_GetExtentReports.GetExtentReports_StartReports("TC_19_MenuSortingAdmin");
			SmokeTest_report = SmokeTest_GetExtentReports.getReport();
			SmokeTest_test = SmokeTest_report.createTest("Menu Sorting flow");

			/************************ Configuration *****************************/

			Thread.sleep(1000);
			SkillChange.MenuSorting(driver, SmokeTest_test, SmokeTest_report);
			//ExpertModule_CommonMethods.Logoutsite(driver, SkillChangeTest_test, SkillChangeTest_report);
			driver.close();				
			SmokeTest_report.flush();
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, e.getMessage());
		}
	}

	//*************************Menu Sorting - Employee LOGIN**********************//

	public static void TC_20_MenuSortingEmployee() throws InterruptedException
	{
		try
		{
			SmokeTest_GetExtentReports.GetExtentReports_StartReports("TC_20_MenuSortingEmployee");
			SmokeTest_report = SmokeTest_GetExtentReports.getReport();
			SmokeTest_test = SmokeTest_report.createTest("Menu Sorting flow");

			/************************ Configuration *****************************/

			Thread.sleep(1000);
			SkillChange.MenuSortingEmployee(driver, SmokeTest_test, SmokeTest_report);
			//ExpertModule_CommonMethods.Logoutsite(driver, SkillChangeTest_test, SkillChangeTest_report);
			driver.close();				
			SmokeTest_report.flush();
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, e.getMessage());
		}
	}
	
	//*************************New Landing Page-Validation**********************//

	public static void TestCase_ID_21() throws InterruptedException
	{
		try
		{
			SmokeTest_GetExtentReports.GetExtentReports_StartReports("TC_21_NewLandingPageValidation");
			SmokeTest_report = SmokeTest_GetExtentReports.getReport();
			SmokeTest_test = SmokeTest_report.createTest("New Landing Header Validation");

			/************************ Configuration *****************************/

			Thread.sleep(1000);
			SkillValidations.LandingPageHeader(driver, SmokeTest_test, SmokeTest_report);
			/*ExpertModule_CommonMethods.Logoutsite(driver, SkillChangeTest_test, SkillChangeTest_report);
			driver.close();	*/			
			SmokeTest_report.flush();
			
			/*SkillValidations.LandingPageFooter(driver, SmokeTest_test, SmokeTest_report);
			ExpertModule_CommonMethods.Logoutsite(driver, SkillChangeTest_test, SkillChangeTest_report);
			driver.close();				
			SmokeTest_report.flush();*/
			
			
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, e.getMessage());
		}
	}
	
	public static void TestCase_ID_22() throws InterruptedException
	{
		try
		{
			SmokeTest_GetExtentReports.GetExtentReports_StartReports("TC_22_SkillProfile_QuickLinksValidation");
			SmokeTest_report = SmokeTest_GetExtentReports.getReport();
			SmokeTest_test = SmokeTest_report.createTest("TC_22_SkillProfile_QuickLinks Validation");

			/************************ Configuration *****************************/

			Thread.sleep(1000);
			SkillValidations.skillProfileSectionValidation(driver, SmokeTest_test, SmokeTest_report);
			/*ExpertModule_CommonMethods.Logoutsite(driver, SkillChangeTest_test, SkillChangeTest_report);
			driver.close();	*/			
			SmokeTest_report.flush();
			
			SkillValidations.QuickLinksSectionValidation(driver, SmokeTest_test, SmokeTest_report);
			/*ExpertModule_CommonMethods.Logoutsite(driver, SkillChangeTest_test, SkillChangeTest_report);
			driver.close();	*/			
			SmokeTest_report.flush();		
			
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, e.getMessage());
		}
	}
	
	public static void TestCase_ID_25() throws InterruptedException
	{
		try
		{
			SmokeTest_GetExtentReports.GetExtentReports_StartReports("TC_25_Get_to_KnowMyComp_And_SAG_Validation");
			SmokeTest_report = SmokeTest_GetExtentReports.getReport();
			SmokeTest_test = SmokeTest_report.createTest("TC_25_Get_to_KnowMyComp_And_SAG_Validation Validation");

			/************************ Configuration *****************************/

			Thread.sleep(1000);
			SkillValidations.getToKnowMyCompAndSAGValidation(driver, SmokeTest_test, SmokeTest_report);
			/*ExpertModule_CommonMethods.Logoutsite(driver, SkillChangeTest_test, SkillChangeTest_report);
			driver.close();	*/			
			SmokeTest_report.flush();	
			driver.close();
			
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, e.getMessage());
		}
	}

	public static void TestCase_ID_23() throws InterruptedException
	{
		try
		{
			SmokeTest_GetExtentReports.GetExtentReports_StartReports("TC_23_Centre_Palette_Widget1_Validation");
			SmokeTest_report = SmokeTest_GetExtentReports.getReport();
			SmokeTest_test = SmokeTest_report.createTest("TC_23_Centre_Palette_Widget1_Validation");

			/************************ Configuration *****************************/

			Thread.sleep(50);
			SkillValidations.CentrePaletteValidation(driver, SmokeTest_test, SmokeTest_report);
			/*ExpertModule_CommonMethods.Logoutsite(driver, SkillChangeTest_test, SkillChangeTest_report);
			driver.close();	*/			
			SmokeTest_report.flush();	
			Thread.sleep(1000);
			SkillValidations.Widget1Validation(driver, SmokeTest_test, SmokeTest_report);
			/*ExpertModule_CommonMethods.Logoutsite(driver, SkillChangeTest_test, SkillChangeTest_report);
			driver.close();	*/			
			SmokeTest_report.flush();	
			
			
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, e.getMessage());
		}
	}
	
	public static void TestCase_ID_24() throws InterruptedException
	{
		try
		{
			SmokeTest_GetExtentReports.GetExtentReports_StartReports("TC_24_Centre_Palette_Widget2_Widget3_Validation");
			SmokeTest_report = SmokeTest_GetExtentReports.getReport();
			SmokeTest_test = SmokeTest_report.createTest("TC_24_Centre_Palette_Widget2_Widget3_Validation");

			/************************ Configuration *****************************/

			Thread.sleep(1000);
			SkillValidations.Widget2Validation(driver, SmokeTest_test, SmokeTest_report);
			/*ExpertModule_CommonMethods.Logoutsite(driver, SkillChangeTest_test, SkillChangeTest_report);
			driver.close();	*/			
			SmokeTest_report.flush();	
			Thread.sleep(1000);
			SkillValidations.Widget3Validation(driver, SmokeTest_test, SmokeTest_report);
			/*ExpertModule_CommonMethods.Logoutsite(driver, SkillChangeTest_test, SkillChangeTest_report);
			driver.close();	*/			
			SmokeTest_report.flush();
			
	//		SkillValidations.feedbackPopUpValidation(driver, SmokeTest_test, SmokeTest_report);
			
			SkillValidations.LandingPageFooter(driver, SmokeTest_test, SmokeTest_report);
			
			//driver.close();				
			SmokeTest_report.flush();
			
			
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, e.getMessage());
		}
	}





	public static void Self_Service_Report_Download()
	{
		try
		{
			String TestCaseID = "Self_Service_Report_Download";
			SmokeTest_GetExtentReports.GetExtentReports_StartReports("Self_Service_Report_Download");
			SmokeTest_report = SmokeTest_GetExtentReports.getReport();

			SmokeTest_test = SmokeTest_report.createTest("Self_Service_Report_1_Download");
			SkillValidations.SelfServiceReportDownloadValidations(driver, Browser, TestCaseID, SmokeTest_test,"SME Allocation Pending Report");

			SmokeTest_test = SmokeTest_report.createTest("Self_Service_Report_2_Download");
			SkillValidations.SelfServiceReportDownloadAnotherReport(driver, Browser, TestCaseID, SmokeTest_test,"Master Interviewer Allocation Pending Report");

			SmokeTest_test = SmokeTest_report.createTest("Self_Service_Report_3_Download");
			SkillValidations.SelfServiceReportDownloadAnotherReport(driver, Browser, TestCaseID, SmokeTest_test,"Industry MD Evaluation Pending Report");

			SmokeTest_report.flush();
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, e.getMessage());
		}
	}

	public static void SmokeTestAutomation_Admin_Prod()
	{
		try
		{
			/******Driver & Browser Invoke********/
			driver = DriverSetup.getDriver();
			DriverSetup.ProdNavigation();
			driver.getCurrentUrl();

			/***********Admin Login_Production***************/
			LoginPage.UserLogin_Prod(driver);
			TestCase_ID_01();
			TestCase_ID_02();
			//			TestCase_ID_03();
			//			TestCase_ID_04();
			TestCase_ID_05();
			TestCase_ID_06();
			TestCase_ID_07();
			driver.quit();
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, e.getMessage());
		}
	}

	public static void SmokeTestAutomation_User_Prod() throws InterruptedException
	{
		try
		{
			/******Driver & Browser Invoke********/
			driver = DriverSetup.getDriver();
			DriverSetup.ProdNavigation();

			/***********User Login_Production***************/
			LoginPage.UserLogin_Prod(driver);

			TestCase_ID_21(); 
			System.out.println("TC 21 is completed");
			TestCase_ID_22(); 
			System.out.println("TC 22 is completed");
			TestCase_ID_23(); 
			System.out.println("TC 23 is completed");
			TestCase_ID_24(); 
			System.out.println("TC 24 is completed");
			//TestCase_ID_25(); 
			//System.out.println("TC 25 is completed");


			//			TestCase_ID_10();
			//			TestCase_ID_11();
			//			TestCase_ID_12("Prod");
			//			Production_TestCase_ID_16();
			//			TestCase_ID_17();
			driver.quit();
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, e.getMessage());
		}
	}

	public static void SmokeTestAutomation_Admin_Stage()
	{
		try
		{
			/******Driver & Browser Invoke********/
			driver = DriverSetup.getDriver();

			/***********Admin Login***************/
			LoginPage.LoginUserStage(driver,"Admin_User_Login");
			//			Self_Service_Report_Download();
			/*TestCase_ID_01();
			TestCase_ID_02();
			TestCase_ID_03();
			//			TestCase_ID_04();
			TestCase_ID_05();
			TestCase_ID_06();
			TestCase_ID_07();
			TestCase_ID_08();*/

			TC_19_MenuSortingAdmin();
			driver.quit();
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, e.getMessage());
		}
	}

	public static void SmokeTestAutomation_User_Stage()
	{
		try
		{
			/******Driver & Browser Invoke********/
			driver = DriverSetup.getDriver();

			/***********User Login***************/
			LoginPage.LoginUserStage(driver,"Master_User_Login");

			TestCase_ID_21(); 
			System.out.println("TC 21 is completed");
			TestCase_ID_22(); 
			System.out.println("TC 22 is completed");
			TestCase_ID_23(); /*Centrepalette,W1*/
			System.out.println("TC 23 is completed");
			TestCase_ID_24(); /*W2,W3,footer*/
			System.out.println("TC 24 is completed");
			//TestCase_ID_25(); /*Sag*/
			//System.out.println("TC 25 is completed");
			/*TestCase_ID_09(); 
			System.out.println("TC 09 is completed"); 
			TestCase_ID_10();
			System.out.println("TC 10 is completed"); 
			TestCase_ID_11();
			System.out.println("TC 11 is completed"); 
			TestCase_ID_12("Prod");
			System.out.println("TC 12 is completed"); 
			Production_TestCase_ID_16();
			System.out.println("TC 16 is completed");
			 
			TestCase_ID_17(); 
			System.out.println("TC 17 is completed");
			TC_20_MenuSortingEmployee();*/


			driver.quit();
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, e.getMessage());
		}
	} 

	@Test
	public void MainMethod() throws InterruptedException 
	{
		try
		{
			ExcelReadWrite ExcelCreate = new ExcelReadWrite();
			ExcelCreate.CreateExcel();

			/*********TestCase Execution**********/
			//	SmokeTestAutomation_Admin_Stage();
			//SmokeTestAutomation_User_Stage();
			//			SmokeTestAutomation_Admin_Prod();
			SmokeTestAutomation_User_Prod();
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, e.getMessage());
		}
	}

}
