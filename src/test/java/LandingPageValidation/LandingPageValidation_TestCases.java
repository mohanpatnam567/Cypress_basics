package LandingPageValidation;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import CommonMethods.DriverSetup;
import CommonMethods.LoginPage;
import CommonMethods.PropertyfileConfig;
import SmokeTestModule.SmokeTest_GetExtentReports;


public class LandingPageValidation_TestCases {

	public ExtentReports LPVTest_report;
	public ExtentTest LPVTest_test;
	public ExtentTest LTVTest_testChild;
	static Properties prop = PropertyfileConfig.Propertyfile();
	public WebDriver driver;

	@BeforeTest
	public void OverallConfiguration()
	{
		driver = DriverSetup.getDriver();
	}

	@BeforeMethod
	public void DriverConfiguration()
	{

	}

	@Test(priority=1,enabled=true)
	public void TC01_LandingPageHeaderValidation() throws InterruptedException, IOException
	{
		LandingPageValidation_GetExtentReports.GetExtentReports_StartReports("TC01_LandingPageHeaderValidation");
		LPVTest_report = LandingPageValidation_GetExtentReports.getReport();
		LPVTest_test = LPVTest_report.createTest("TC01_LandingPageHeaderValidation");

		LoginPage.LoginUser(driver,"Objective_User_Login");
		LandingPageValidation_CommonMethods.LandingPageHeader(driver, LPVTest_test, LPVTest_report);
		LPVTest_report.flush();
		System.out.println("TC01 is completed successfully");
	}

	@Test(priority=2,enabled=true)
	public void TC02_Centre_Palette_Widget1_Validation() throws InterruptedException, IOException 
	{
		LandingPageValidation_GetExtentReports.GetExtentReports_StartReports("TC02_Centre_Palette_Widget1_Validation");
		LPVTest_report = LandingPageValidation_GetExtentReports.getReport();
		LPVTest_test = LPVTest_report.createTest("TC02_Centre_Palette_Widget1_Validation");
		LandingPageValidation_CommonMethods.CentrePaletteValidation(driver, LPVTest_test, LPVTest_report);

		LPVTest_test = LPVTest_report.createTest("Widget1_Validation");
		LandingPageValidation_CommonMethods.Widget1Validation(driver, LPVTest_test, LPVTest_report);
		LPVTest_report.flush();
		System.out.println("TC02 is completed successfully");
	}

	@Test(priority=3,enabled=true)
	public void TC03_Centre_Palette_Widget2_Widget3_Validation() throws InterruptedException, IOException 
	{	

		LandingPageValidation_GetExtentReports.GetExtentReports_StartReports("TC03_Centre_Palette_Widget2_Widget3_Validation");
		LPVTest_report = LandingPageValidation_GetExtentReports.getReport();
		LPVTest_test = LPVTest_report.createTest("Centre_Palette_Widget2_Widget3_Validation");
		LandingPageValidation_CommonMethods.Widget2Validation(driver, LPVTest_test, LPVTest_report);
		LPVTest_test = LPVTest_report.createTest("Widget3_Validation");
		LandingPageValidation_CommonMethods.Widget3Validation(driver, LPVTest_test, LPVTest_report);
		LPVTest_report.flush();
		System.out.println("TC03 is completed successfully");
	}

	@Test(priority=4, enabled=true)
	public void TC04_Skill_Profile_Validation() throws InterruptedException{
		LandingPageValidation_GetExtentReports.GetExtentReports_StartReports("TC04_Skill_Profile_Validation");
		LPVTest_report = LandingPageValidation_GetExtentReports.getReport();
		LPVTest_test = LPVTest_report.createTest("Skill_Profile_Validation");
		LandingPageValidation_CommonMethods.skillProfileSectionValidation(driver, LPVTest_test, LPVTest_report);
		LPVTest_report.flush();
		System.out.println("TC04 is completed successfully");
	}

	@Test(priority=5, enabled=true)
	public void TC05_Quick_Links_Validation() throws InterruptedException{
		LandingPageValidation_GetExtentReports.GetExtentReports_StartReports("TC05_Quick_Links_Validation");
		LPVTest_report = LandingPageValidation_GetExtentReports.getReport();
		LPVTest_test = LPVTest_report.createTest("Quick_Links_Validation");
		LandingPageValidation_CommonMethods.QuickLinksSectionValidation(driver, LPVTest_test, LPVTest_report);
		LPVTest_report.flush();
		System.out.println("TC05 is completed successfully");
	}

	@Test(priority=6, enabled=false)
	public void TC06_Get_to_KnowMyComp_And_SAG_Validation() throws InterruptedException{
		LandingPageValidation_GetExtentReports.GetExtentReports_StartReports("TC06_Get_to_KnowMyComp_And_SAG_Validation");
		LPVTest_report = LandingPageValidation_GetExtentReports.getReport();
		LPVTest_test = LPVTest_report.createTest("TC08_Get_to_KnowMyComp_And_SAG_Validation");
		LandingPageValidation_CommonMethods.getToKnowMyCompAndSAGValidatio(driver, LPVTest_test, LPVTest_report);
		LPVTest_report.flush();
		System.out.println("TC06 is completed successfully");
	}
	
	@Test(priority=7,enabled=true)
	public void TC07_Feedback_Popup_Validation() throws InterruptedException{
		LandingPageValidation_GetExtentReports.GetExtentReports_StartReports("TC07_Feedback_Popup_Validation");
		LPVTest_report = LandingPageValidation_GetExtentReports.getReport();
		LPVTest_test = LPVTest_report.createTest("Feedback_Popup_Validation");

		//LoginPage.LoginUser(driver, "SP_User");
		LandingPageValidation_CommonMethods.feedbackPopUpValidation(driver, LPVTest_test, LTVTest_testChild, LPVTest_report);

		LPVTest_report.flush();
		//driver.close();
		System.out.println("TC07 is completed successfully");

	}


	@Test(priority=8,enabled=true)
	public void TC08_LandingPageFooterValidation() throws InterruptedException, IOException
	{	
		SmokeTest_GetExtentReports.GetExtentReports_StartReports("TC08_LandingPageFooterValidation");
		LPVTest_report = SmokeTest_GetExtentReports.getReport();
		LPVTest_test = LPVTest_report.createTest("LandingPageFooterValidation");
		LandingPageValidation_CommonMethods.LandingPageFooter(driver, LPVTest_test, LPVTest_report);	
		LPVTest_report.flush();
		System.out.println("TC08 is completed successfully");
		driver.close();

	}
	
    @Test(priority=9,enabled=false)
	public void TC09_MyResourcesValidation() throws InterruptedException, IOException
	{	
		SmokeTest_GetExtentReports.GetExtentReports_StartReports("TC09_MyResourcesValidation");
		LPVTest_report = SmokeTest_GetExtentReports.getReport();
		LPVTest_test = LPVTest_report.createTest("LandingPageFooterValidation");
		LandingPageValidation_CommonMethods.Resource_validation(driver, LPVTest_test, LPVTest_report);	
		LPVTest_report.flush();
		System.out.println("TC09 is completed successfully");
		driver.close();
    }
	
	
	
	/*
	@Test(priority=9,enabled=false)//pending/////////////////////////////////////////
	public void TC10_Approver_Widgets_Validation() throws InterruptedException
	{
		LandingPageValidation_GetExtentReports.GetExtentReports_StartReports("TC09_Approver_Widgets_Validation");
		LPVTest_report = LandingPageValidation_GetExtentReports.getReport();
		LPVTest_test = LPVTest_report.createTest("TC09_Approver_Widgets_Validation");

		LoginPage.LoginUser(driver,"Admin_Stage_UserName");
		LandingPageValidation_CommonMethods.Approver_Widgets_Validation(driver, LPVTest_test, LPVTest_report);	
		LPVTest_report.flush();
		System.out.println("TC09 is completed successfully");
		
	}
	*/
	
	@Test(priority=8,enabled=false)
	public void TC08_Secondary_Skills_Verification_Highest_Prof_Skills() throws InterruptedException{
		LandingPageValidation_GetExtentReports.GetExtentReports_StartReports("TC08_Secondary_Skills_Verification_Recent_Skills_More_Than_Two_Secondary_Skills");
		LPVTest_report = LandingPageValidation_GetExtentReports.getReport();
		LPVTest_test = LPVTest_report.createTest("TC08_Secondary_Skills_Verification_Highest_Prof_Skills");


		LPVTest_test = LPVTest_report.createTest("Employee_Assessment_History_Delete");
		LandingPageValidation_DatabaseConnectivity.Skill_AssessmentHistory_Delete(driver, LPVTest_test, LPVTest_report, "SP_User", "Primary_Skill");
		LandingPageValidation_DatabaseConnectivity.Skill_AssessmentHistory_Delete(driver, LPVTest_test, LPVTest_report, "SP_User", "FirstSecSkill");
		LandingPageValidation_DatabaseConnectivity.Skill_AssessmentHistory_Delete(driver, LPVTest_test, LPVTest_report, "SP_User", "SecSecSkill");

		LPVTest_test = LPVTest_report.createTest("Employee_Existing Skill Deletion_New Skill Mapping");
		LandingPageValidation_DatabaseConnectivity.RSM_History_Delete(driver,LPVTest_test, LPVTest_report, "SP_User");
		LandingPageValidation_DatabaseConnectivity.RSMUpload_TemplateFill(driver,LPVTest_test, LPVTest_report, "SP_User", "Primary_Skill","FirstSecSkill", "SecSecSkill", "ThirdSecSkill",3);
		LoginPage.LoginUser(driver, "Admin_User_Login");
		LandingPageValidation_CommonMethods.RSM_Upload(driver, LPVTest_test, LPVTest_report);
		LandingPageValidation_CommonMethods.Logoutsite(driver, LPVTest_test, LPVTest_report);
		LPVTest_report.flush();

		LPVTest_test = LPVTest_report.createTest("Adding Some Proficiency to Skills");
		LandingPageValidation_DatabaseConnectivity.P3Plus_Skill(driver, LPVTest_test, LPVTest_report, "SP_User", "Primary_Skill");
		LandingPageValidation_DatabaseConnectivity.P3Plus_Skill(driver, LPVTest_test, LPVTest_report, "SP_User", "FirstSecSkill");
		LandingPageValidation_DatabaseConnectivity.P4Plus_Skill(driver, LPVTest_test, LPVTest_report, "SP_User", "SecSecSkill");
		LPVTest_report.flush();

		LoginPage.LoginUser(driver, "SP_User");
		LPVTest_test = LPVTest_report.createTest("Verifying Skills in Skill Profile Section");
		LandingPageValidation_CommonMethods.secSkillsValidationHigProf(driver, LPVTest_test, LPVTest_report, "Primary_Skill", "FirstSecSkill", "SecSecSkill");
		LPVTest_report.flush();
		driver.close();
	}

	@Test(priority=9,enabled=false)
	public void TC09_Secondary_Skills_Verification_Recently_Added_Skills() throws InterruptedException{
		LandingPageValidation_GetExtentReports.GetExtentReports_StartReports("TC09_Secondary_Skills_Verification_Recently_Added_Skills");
		LPVTest_report = LandingPageValidation_GetExtentReports.getReport();
		LPVTest_test = LPVTest_report.createTest("TC09_Secondary_Skills_Verification_Recently_Added_Skills");


		LPVTest_test = LPVTest_report.createTest("Employee_Assessment_History_Delete");
		LandingPageValidation_DatabaseConnectivity.Skill_AssessmentHistory_Delete(driver, LPVTest_test, LPVTest_report, "SP_User", "Primary_Skill");
		LandingPageValidation_DatabaseConnectivity.Skill_AssessmentHistory_Delete(driver, LPVTest_test, LPVTest_report, "SP_User", "FirstSecSkill");
		LandingPageValidation_DatabaseConnectivity.Skill_AssessmentHistory_Delete(driver, LPVTest_test, LPVTest_report, "SP_User", "SecSecSkill");

		LPVTest_test = LPVTest_report.createTest("Employee_Existing Skill Deletion_New Skill Mapping");
		LandingPageValidation_DatabaseConnectivity.RSM_History_Delete(driver,LPVTest_test, LPVTest_report, "SP_User");
		LandingPageValidation_DatabaseConnectivity.RSMUpload_TemplateFill(driver,LPVTest_test, LPVTest_report, "SP_User", "Primary_Skill","FirstSecSkill", "SecSecSkill", "ThirdSecSkill" ,3);
		LoginPage.LoginUser(driver, "Admin_User_Login");
		LandingPageValidation_CommonMethods.RSM_Upload(driver, LPVTest_test, LPVTest_report);
		LandingPageValidation_CommonMethods.Logoutsite(driver, LPVTest_test, LPVTest_report);
		LPVTest_report.flush();

		LoginPage.LoginUser(driver, "SP_User");
		LPVTest_test = LPVTest_report.createTest("Verifying Skills in Skill Profile Section");
		LandingPageValidation_CommonMethods.secSkillsValidationRecentlyAdded(driver, LPVTest_test, LPVTest_report, "Primary_Skill", "ThirdSecSkill", "SecSecSkill");
		LPVTest_report.flush();
		driver.close();
	}


	@Test(priority=10,enabled=false)
	public void TC10Secondary_Skills_Verification_One_With_Prof_One_With_Recently_Added_Skills() throws InterruptedException{
		LandingPageValidation_GetExtentReports.GetExtentReports_StartReports("TC10_Secondary_Skills_Verification_One_With_Prof_One_With_Recently_Added_Skills");
		LPVTest_report = LandingPageValidation_GetExtentReports.getReport();
		LPVTest_test = LPVTest_report.createTest("TC10_Secondary_Skills_Verification_One_With_Prof_One_With_Recently_Added_Skills");


		LPVTest_test = LPVTest_report.createTest("Employee_Assessment_History_Delete");
		LandingPageValidation_DatabaseConnectivity.Skill_AssessmentHistory_Delete(driver, LPVTest_test, LPVTest_report, "SP_User", "Primary_Skill");
		LandingPageValidation_DatabaseConnectivity.Skill_AssessmentHistory_Delete(driver, LPVTest_test, LPVTest_report, "SP_User", "FirstSecSkill");
		LandingPageValidation_DatabaseConnectivity.Skill_AssessmentHistory_Delete(driver, LPVTest_test, LPVTest_report, "SP_User", "SecSecSkill");

		LPVTest_test = LPVTest_report.createTest("Employee_Existing Skill Deletion_New Skill Mapping");
		LandingPageValidation_DatabaseConnectivity.RSM_History_Delete(driver,LPVTest_test, LPVTest_report, "SP_User");
		LandingPageValidation_DatabaseConnectivity.RSMUpload_TemplateFill(driver,LPVTest_test, LPVTest_report, "SP_User", "Primary_Skill","FirstSecSkill", "SecSecSkill", "ThirdSecSkill",3);
		LoginPage.LoginUser(driver, "Admin_User_Login");
		LandingPageValidation_CommonMethods.RSM_Upload(driver, LPVTest_test, LPVTest_report);
		LandingPageValidation_CommonMethods.Logoutsite(driver, LPVTest_test, LPVTest_report);
		LPVTest_report.flush();

		LPVTest_test = LPVTest_report.createTest("Adding Some Proficiency to Skills");
		//LandingPageValidation_DatabaseConnectivity.P3Plus_Skill(driver, LPVTest_test, LPVTest_report, "SP_User", "Primary_Skill");
		LandingPageValidation_DatabaseConnectivity.P3Plus_Skill(driver, LPVTest_test, LPVTest_report, "SP_User", "FirstSecSkill");


		LoginPage.LoginUser(driver, "SP_User");
		LPVTest_test = LPVTest_report.createTest("Verifying Skills in Skill Profile Section");
		LandingPageValidation_CommonMethods.secSkillsValidationRecentlyAdded(driver, LPVTest_test, LPVTest_report, "Primary_Skill", "FirstSecSkill", "ThirdSecSkill");
		LPVTest_report.flush();
		driver.close();
	}

	@Test(priority=11,enabled=false)
	public void TC11_Secondary_Skills_Verification_When_One_Secondary_Skill() throws InterruptedException{
		LandingPageValidation_GetExtentReports.GetExtentReports_StartReports("TC11_Secondary_Skills_Verification_When_One_Secondary_Skill");
		LPVTest_report = LandingPageValidation_GetExtentReports.getReport();
		LPVTest_test = LPVTest_report.createTest("TC11_Secondary_Skills_Verification_When_One_Secondary_Skill");


		LPVTest_test = LPVTest_report.createTest("Employee_Assessment_History_Delete");
		LandingPageValidation_DatabaseConnectivity.Skill_AssessmentHistory_Delete(driver, LPVTest_test, LPVTest_report, "SP_User", "Primary_Skill");
		LandingPageValidation_DatabaseConnectivity.Skill_AssessmentHistory_Delete(driver, LPVTest_test, LPVTest_report, "SP_User", "FirstSecSkill");
		LandingPageValidation_DatabaseConnectivity.Skill_AssessmentHistory_Delete(driver, LPVTest_test, LPVTest_report, "SP_User", "SecSecSkill");

		LPVTest_test = LPVTest_report.createTest("Employee_Existing Skill Deletion_New Skill Mapping");
		LandingPageValidation_DatabaseConnectivity.RSM_History_Delete(driver,LPVTest_test, LPVTest_report, "SP_User");
		LandingPageValidation_DatabaseConnectivity.RSMUpload_TemplateFill(driver,LPVTest_test, LPVTest_report, "SP_User", "Primary_Skill","FirstSecSkill", "SecSecSkill", "ThirdSecSkill", 1);
		LoginPage.LoginUser(driver, "Admin_User_Login");
		LandingPageValidation_CommonMethods.RSM_Upload(driver, LPVTest_test, LPVTest_report);
		LandingPageValidation_CommonMethods.Logoutsite(driver, LPVTest_test, LPVTest_report);
		LPVTest_report.flush();

		LoginPage.LoginUser(driver, "SP_User");
		LPVTest_test = LPVTest_report.createTest("Verifying Skills in Skill Profile Section");
		LandingPageValidation_CommonMethods.secSkillsValidationRecentlyAdded(driver, LPVTest_test, LPVTest_report, "Primary_Skill", "FirstSecSkill", "SecSecSkill");
		LPVTest_report.flush();
		driver.close();
	}

	@Test(priority=12,enabled=false)
	public void TC12_Secondary_Skills_Verification_No_Secondary_Skills() throws InterruptedException{
		LandingPageValidation_GetExtentReports.GetExtentReports_StartReports("TC12_Secondary_Skills_Verification_No_Secondary_Skills");
		LPVTest_report = LandingPageValidation_GetExtentReports.getReport();
		LPVTest_test = LPVTest_report.createTest("TC12_Secondary_Skills_Verification_No_Secondary_Skills");


		LPVTest_test = LPVTest_report.createTest("Secondary_Skills_Verification_No_Secondary_Skills");
		LandingPageValidation_DatabaseConnectivity.Skill_AssessmentHistory_Delete(driver, LPVTest_test, LPVTest_report, "SP_User", "Primary_Skill");
		LandingPageValidation_DatabaseConnectivity.Skill_AssessmentHistory_Delete(driver, LPVTest_test, LPVTest_report, "SP_User", "FirstSecSkill");
		LandingPageValidation_DatabaseConnectivity.Skill_AssessmentHistory_Delete(driver, LPVTest_test, LPVTest_report, "SP_User", "SecSecSkill");

		LPVTest_test = LPVTest_report.createTest("Employee_Existing Skill Deletion_New Skill Mapping");
		LandingPageValidation_DatabaseConnectivity.RSM_History_Delete(driver,LPVTest_test, LPVTest_report, "SP_User");
		LandingPageValidation_DatabaseConnectivity.RSMUpload_TemplateFill(driver,LPVTest_test, LPVTest_report, "SP_User", "Primary_Skill","FirstSecSkill", "SecSecSkill", "ThirdSecSkill", 0);
		LoginPage.LoginUser(driver, "Admin_User_Login");
		LandingPageValidation_CommonMethods.RSM_Upload(driver, LPVTest_test, LPVTest_report);
		LandingPageValidation_CommonMethods.Logoutsite(driver, LPVTest_test, LPVTest_report);
		LPVTest_report.flush();

		LPVTest_test = LPVTest_report.createTest("Adding Some Proficiency to Skills");
		LandingPageValidation_DatabaseConnectivity.P3Plus_Skill(driver, LPVTest_test, LPVTest_report, "SP_User", "Primary_Skill");
		LandingPageValidation_DatabaseConnectivity.P3Plus_Skill(driver, LPVTest_test, LPVTest_report, "SP_User", "FirstSecSkill");

		LoginPage.LoginUser(driver, "SP_User");
		LPVTest_test = LPVTest_report.createTest("Verifying Skills in Skill Profile Section");
		LandingPageValidation_CommonMethods.secSkillsValidationNoSecSkills(driver, LPVTest_test, LPVTest_report, "Primary_Skill");
		LPVTest_report.flush();
		driver.close();
	}

/*	@Test(priority=14, enabled=false)
	public void TC14_ResourceTab_validation() throws InterruptedException
	{
		LandingPageValidation_GetExtentReports.GetExtentReports_StartReports("TC14_ResourceTab_validation");
		LPVTest_report = LandingPageValidation_GetExtentReports.getReport();
		LPVTest_test = LPVTest_report.createTest("ResourceTab_validation");

		driver=DriverSetup.getDriver();
		LoginPage.LoginUser(driver, "Master_User_Login");
		LandingPageValidation_CommonMethods.Resource_validation(driver, LPVTest_test, LPVTest_report);
		//LandingPageValidation_CommonMethods.CertificationsTab_Validation(driver, LPVTest_test, LPVTest_report);
		LPVTest_report.flush();
		driver.close();
	}
*/

	@Test(priority=13,enabled=false)
	public void TC13_Secondary_Skills_Tab_Validation() throws InterruptedException{
		LandingPageValidation_GetExtentReports.GetExtentReports_StartReports("TC_15_Secondary_Skills_Tab_Validation");
		LPVTest_report = LandingPageValidation_GetExtentReports.getReport();
		LPVTest_test = LPVTest_report.createTest("TC_15_Secondary_Skills_Tab_Validation");

		LoginPage.LoginUser(driver, "SP_User");
		LandingPageValidation_CommonMethods.secSkillsTabValidation(driver, LPVTest_test, LPVTest_report);

		LPVTest_report.flush();
		driver.close();
	}

	@Test(enabled=false, priority=7)
	public void TC_16_SOI_Tab_Validation() throws InterruptedException{
		LandingPageValidation_GetExtentReports.GetExtentReports_StartReports("TC_16_SOI_Tab_Validation");
		LPVTest_report = LandingPageValidation_GetExtentReports.getReport();
		LPVTest_test = LPVTest_report.createTest("TC_16_SOI_Tab_Validation");

		LoginPage.LoginUser(driver, "SP_User");
		LandingPageValidation_CommonMethods.SOI_TabValidation(driver, LPVTest_test, LPVTest_report);

		LPVTest_report.flush();
		driver.close();
	}

	@Test(enabled=false, priority=6)
	public void TC_Resource_Validation() throws InterruptedException{
		LandingPageValidation_GetExtentReports.GetExtentReports_StartReports("TC_15_Resource_Validation");
		LPVTest_report = LandingPageValidation_GetExtentReports.getReport();
		LPVTest_test = LPVTest_report.createTest("TC_15_Resource_Validation");

		LoginPage.LoginUser(driver, "SP_User");
		Thread.sleep(5000);

		LPVTest_report.flush();
		driver.close();

	}


}

