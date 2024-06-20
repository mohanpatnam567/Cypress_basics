package CommonMethods;

import java.io.File;
import java.util.List;
import java.util.Properties;
import org.testng.annotations.Test;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

@Test
public class ExcelHandling
{
	static Properties prop = PropertyfileConfig.Propertyfile();

	public static void ExcelWriteRSMUpload(String PersonalNumber) 
	{
		String Path = System.getProperty("user.dir")+"\\TestData\\Objective_Assessment\\Resource_Skill_Mapping.xls";
		try 
		{
			Workbook existingWorkbook = Workbook.getWorkbook(new File(Path));
			WritableWorkbook workbookCopy = Workbook.createWorkbook(new File(Path), existingWorkbook);
			WritableSheet Sheet = workbookCopy.getSheet("Resource_Skill_Mapping");
			Label label = new Label(0, 1, PersonalNumber);
			Label label1 = new Label(0, 2, PersonalNumber);
			Sheet.addCell(label);
			Sheet.addCell(label1);
			workbookCopy.write();
			workbookCopy.close();
			existingWorkbook.close();

		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}                 
	}

	public static void Objective_RSMUpload(String PersonnelNo,String Skill_NAME,String SpecialityName_Primary,String SkillCapability_Primary,String SkillCategory_Primary,String SkillType_Primary,String Skill_NAME_Sec,
			String SpecialityName_Sec,String SkillCapability_Sec,String SkillCategory_Sec,String SkillType_Sec,String RSMTemplate) 
	{
		String Path = System.getProperty("user.dir")+"\\TestData\\Objective_Assessment\\"+RSMTemplate+".xls";
		try 
		{
			Workbook existingWorkbook = Workbook.getWorkbook(new File(Path));
			WritableWorkbook workbookCopy = Workbook.createWorkbook(new File(Path), existingWorkbook);
			WritableSheet Sheet = workbookCopy.getSheet("Resource_Skill_Mapping");

			Label label = new Label(0, 1, PersonnelNo);
			Label label1 = new Label(1, 1, "P");
			Label label2 = new Label(2, 1, Skill_NAME);
			Label label3 = new Label(3, 1, SpecialityName_Primary);
			Label label4 = new Label(4, 1, SkillCapability_Primary);
			Label label5 = new Label(5, 1, SkillCategory_Primary);
			Label label6 = new Label(6, 1, SkillType_Primary);

			Label label7 = new Label(0, 2, PersonnelNo);
			Label label8 = new Label(1, 2, "E");
			Label label9 = new Label(2, 2, Skill_NAME_Sec);
			Label label10 = new Label(3, 2, SpecialityName_Sec);
			Label label11 = new Label(4, 2, SkillCapability_Sec);
			Label label12 = new Label(5, 2, SkillCategory_Sec);
			Label label13 = new Label(6, 2, SkillType_Sec);

			Sheet.addCell(label);
			Sheet.addCell(label1);
			Sheet.addCell(label2);
			Sheet.addCell(label3);
			Sheet.addCell(label4);
			Sheet.addCell(label5);
			Sheet.addCell(label6);
			Sheet.addCell(label7);
			Sheet.addCell(label8);
			Sheet.addCell(label9);
			Sheet.addCell(label10);
			Sheet.addCell(label11);
			Sheet.addCell(label12);
			Sheet.addCell(label13);

			workbookCopy.write();
			workbookCopy.close();
			existingWorkbook.close();
			System.out.println("RSM template filled");
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}                 
	}

	public static void Objective_RSMUpload(String PersonnelNo,String Skill_NAME,String SpecialityName_Primary,String SkillCapability_Primary,String SkillCategory_Primary,String SkillType_Primary,String Skill_NAME_Sec,
			String SpecialityName_Sec,String SkillCapability_Sec,String SkillCategory_Sec,String SkillType_Sec) 
	{
		String Path = System.getProperty("user.dir")+"\\TestData\\Objective_Assessment\\Resource_Skill_Mapping.xls";
		try 
		{
			Workbook existingWorkbook = Workbook.getWorkbook(new File(Path));
			WritableWorkbook workbookCopy = Workbook.createWorkbook(new File(Path), existingWorkbook);
			WritableSheet Sheet = workbookCopy.getSheet("Resource_Skill_Mapping");

			Label label = new Label(0, 1, PersonnelNo);
			Label label1 = new Label(1, 1, "P");
			Label label2 = new Label(2, 1, Skill_NAME);
			Label label3 = new Label(3, 1, SpecialityName_Primary);
			Label label4 = new Label(4, 1, SkillCapability_Primary);
			Label label5 = new Label(5, 1, SkillCategory_Primary);
			Label label6 = new Label(6, 1, SkillType_Primary);

			Label label7 = new Label(0, 2, PersonnelNo);
			Label label8 = new Label(1, 2, "E");
			Label label9 = new Label(2, 2, Skill_NAME_Sec);
			Label label10 = new Label(3, 2, SpecialityName_Sec);
			Label label11 = new Label(4, 2, SkillCapability_Sec);
			Label label12 = new Label(5, 2, SkillCategory_Sec);
			Label label13 = new Label(6, 2, SkillType_Sec);

			Sheet.addCell(label);
			Sheet.addCell(label1);
			Sheet.addCell(label2);
			Sheet.addCell(label3);
			Sheet.addCell(label4);
			Sheet.addCell(label5);
			Sheet.addCell(label6);
			Sheet.addCell(label7);
			Sheet.addCell(label8);
			Sheet.addCell(label9);
			Sheet.addCell(label10);
			Sheet.addCell(label11);
			Sheet.addCell(label12);
			Sheet.addCell(label13);

			workbookCopy.write();
			workbookCopy.close();
			existingWorkbook.close();
			System.out.println("RSM template filled");
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}                 
	}

	public static void CertificationApproverUpload_TwoEntry(String Approver_EID, String Certification_Name1, String Certification_Name2, String Add_Remove )

	{

		String Path = System.getProperty("user.dir")+"\\TestData\\Expert_Assessment\\Certification_Approver_Upload.xls";

		try

		{
			String CertificationName01 = prop.getProperty(Certification_Name1);
			String CertificationName02 = prop.getProperty(Certification_Name2);
			String ApproverEID = prop.getProperty(Approver_EID);
			String AddRemove = prop.getProperty(Add_Remove);
			Workbook existingWorkbook = Workbook.getWorkbook(new File(Path));

			WritableWorkbook workbookCopy = Workbook.createWorkbook(new File(Path), existingWorkbook);

			WritableSheet Sheet = workbookCopy.getSheet("Sheet1");

			Label label = new Label(0, 1, CertificationName01);

			Label label1 = new Label(1, 1, ApproverEID);

			Label label2 = new Label(2, 1, AddRemove);

			Label label3 = new Label(0, 2, CertificationName02);

			Label label4 = new Label(1, 2, ApproverEID);

			Label label5 = new Label(2, 2, AddRemove);

			Sheet.addCell(label);

			Sheet.addCell(label1);

			Sheet.addCell(label2);

			Sheet.addCell(label3);

			Sheet.addCell(label4);

			Sheet.addCell(label5);

			workbookCopy.write();

			workbookCopy.close();

			existingWorkbook.close();

			System.out.println("6");

		}

		catch (Exception e)

		{

			e.printStackTrace();

		}                

	}



	public static void Expert_ExcelWriteRSMUpload(String PersonalNumber,String ResourceSkillName,String ResourceSpecialityName,
			String SkillCapability,String SkillCategory ,String SkillType, String ResourceSkillName_Secondary,
			String ResourceSpecialityName_Sec, String SkillCapability_Sec, String SkillCategory_Sec, String SkillType_Sec) 
	{
		String Path = System.getProperty("user.dir")+"\\TestData\\Expert_Assessment\\Resource_Skill_Mapping.xls";
		try 
		{
			Workbook existingWorkbook = Workbook.getWorkbook(new File(Path));
			WritableWorkbook workbookCopy = Workbook.createWorkbook(new File(Path), existingWorkbook);
			WritableSheet Sheet = workbookCopy.getSheet("Resource_Skill_Mapping");

			Label label = new Label(0, 1, PersonalNumber);
			Label label1 = new Label(1, 1, "P");
			Label label2 = new Label(2, 1, ResourceSkillName);
			Label label3 = new Label(3, 1, ResourceSpecialityName);
			Label label4 = new Label(4, 1, SkillCapability);
			Label label5 = new Label(5, 1, SkillCategory);
			Label label6 = new Label(6, 1, SkillType);
			System.out.println(11111);
			Label label7 = new Label(0, 2,PersonalNumber );
			Label label8 = new Label(1, 2, "E");
			Label label9 = new Label(2, 2, ResourceSkillName_Secondary);
			Label label10 = new Label(3, 2, ResourceSpecialityName_Sec);
			Label label11 = new Label(4, 2, SkillCapability_Sec);
			Label label12 = new Label(5, 2, SkillCategory_Sec);
			Label label13 = new Label(6, 2, SkillType_Sec);
			System.out.println(12222);
			Sheet.addCell(label);
			Sheet.addCell(label1);
			Sheet.addCell(label2);
			Sheet.addCell(label3);
			Sheet.addCell(label4);
			Sheet.addCell(label5);
			Sheet.addCell(label6);
			Sheet.addCell(label7);
			Sheet.addCell(label8);
			Sheet.addCell(label9);
			Sheet.addCell(label10);
			Sheet.addCell(label11);
			Sheet.addCell(label12);
			Sheet.addCell(label13);
			workbookCopy.write();
			workbookCopy.close();
			existingWorkbook.close();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}                 
	}

	public static void Primary_ExcelWriteQuestionnaire(String Schedule_ID, String Assessment_ID) 
	{
		String Path =  System.getProperty("user.dir")+"\\TestData\\Objective_Assessment\\QuestionnaireAvailableStatus_Upload.xls";
		try 
		{
			Workbook existingWorkbook = Workbook.getWorkbook(new File(Path));
			WritableWorkbook workbookCopy = Workbook.createWorkbook(new File(Path), existingWorkbook);
			WritableSheet Sheet = workbookCopy.getSheet("Qnre Status Details");
			Label label = new Label(1, 1, Schedule_ID);
			Label label1 = new Label(2, 1, Assessment_ID);
			Sheet.addCell(label);
			Sheet.addCell(label1);
			workbookCopy.write();
			workbookCopy.close();
			existingWorkbook.close();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}                 
	}

	public static void Secondary_ExcelWriteQuestionnaire(String Schedule_ID, String Assessment_ID) 
	{
		String Path = System.getProperty("user.dir")+"\\TestData\\Objective_Assessment\\QuestionnaireAvailableStatus_Upload.xls";
		try 
		{
			Workbook existingWorkbook = Workbook.getWorkbook(new File(Path));
			WritableWorkbook workbookCopy = Workbook.createWorkbook(new File(Path), existingWorkbook);
			WritableSheet Sheet = workbookCopy.getSheet("Qnre Status Details");
			Label label2 = new Label(1, 2, Schedule_ID);
			Label label3 = new Label(2, 2, Assessment_ID);
			Sheet.addCell(label2);
			Sheet.addCell(label3);
			workbookCopy.write();
			workbookCopy.close();
			existingWorkbook.close();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}                 
	}

	public static void SecondarySkillMapping_RSMUpload(String L1_NAME, String L2_NAME, String L3_NAME, String L4_NAME, String L5_NAME) 
	{
		String Path = System.getProperty("user.dir")+"\\TestData\\Objective_Assessment\\Resource_Skill_Mapping.xls";
		try 
		{
			Workbook existingWorkbook = Workbook.getWorkbook(new File(Path));
			WritableWorkbook workbookCopy = Workbook.createWorkbook(new File(Path), existingWorkbook);
			WritableSheet Sheet = workbookCopy.getSheet("Resource_Skill_Mapping");
			Label label = new Label(2, 2, L5_NAME);
			Label label1 = new Label(3, 2, L4_NAME);
			Label label2 = new Label(4, 2, L3_NAME);
			Label label3 = new Label(5, 2, L2_NAME);
			Label label4 = new Label(6, 2, L1_NAME);
			Sheet.addCell(label);
			Sheet.addCell(label1);
			Sheet.addCell(label2);
			Sheet.addCell(label3);
			Sheet.addCell(label4);
			workbookCopy.write();
			workbookCopy.close();
			existingWorkbook.close();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}                 
	}

	public static void PrimaryAllowtoTakeAssessment_Upload(String L1_NAME, String L2_NAME, String L3_NAME, String L4_NAME, String L5_NAME) 
	{
		String Path = System.getProperty("user.dir")+"\\TestData\\Objective_Assessment\\SkillList_AllowtoTakeAssessment_Upload.xls";
		try 
		{
			Workbook existingWorkbook = Workbook.getWorkbook(new File(Path));
			WritableWorkbook workbookCopy = Workbook.createWorkbook(new File(Path), existingWorkbook);
			WritableSheet Sheet = workbookCopy.getSheet("Assessment Status Details");
			Label label = new Label(0, 1, L1_NAME);
			Label label1 = new Label(1, 1, L2_NAME);
			Label label2 = new Label(2, 1, L3_NAME);
			Label label3 = new Label(3, 1, L4_NAME);
			Label label4 = new Label(4, 1, L5_NAME);
			Sheet.addCell(label);
			Sheet.addCell(label1);
			Sheet.addCell(label2);
			Sheet.addCell(label3);
			Sheet.addCell(label4);
			workbookCopy.write();
			workbookCopy.close();
			existingWorkbook.close();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}                 
	}

	public static void SecondaryAllowtoTakeAssessment_Upload(String L1_NAME, String L2_NAME, String L3_NAME, String L4_NAME, String L5_NAME) 
	{
		String Path = System.getProperty("user.dir")+"\\TestData\\Objective_Assessment\\SkillList_AllowtoTakeAssessment_Upload.xls";
		try 
		{
			Workbook existingWorkbook = Workbook.getWorkbook(new File(Path));
			WritableWorkbook workbookCopy = Workbook.createWorkbook(new File(Path), existingWorkbook);
			WritableSheet Sheet = workbookCopy.getSheet("Assessment Status Details");
			Label label = new Label(0, 2, L1_NAME);
			Label label1 = new Label(1, 2, L2_NAME);
			Label label2 = new Label(2, 2, L3_NAME);
			Label label3 = new Label(3, 2, L4_NAME);
			Label label4 = new Label(4, 2, L5_NAME);
			Sheet.addCell(label);
			Sheet.addCell(label1);
			Sheet.addCell(label2);
			Sheet.addCell(label3);
			Sheet.addCell(label4);
			workbookCopy.write();
			workbookCopy.close();
			existingWorkbook.close();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}                 
	}

	public static void PrimarySkillID_QuestionnaireUpload(String L5_ID) 
	{
		String Path = System.getProperty("user.dir")+"\\TestData\\Objective_Assessment\\QuestionnaireAvailableStatus_Upload.xls";
		try 
		{
			Workbook existingWorkbook = Workbook.getWorkbook(new File(Path));
			WritableWorkbook workbookCopy = Workbook.createWorkbook(new File(Path), existingWorkbook);
			WritableSheet Sheet = workbookCopy.getSheet("Qnre Status Details");
			Label label = new Label(0, 1, L5_ID);
			Sheet.addCell(label);
			workbookCopy.write();
			workbookCopy.close();
			existingWorkbook.close();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}                 
	}

	public static void SecondarySkillID_QuestionnaireUpload(String L5_ID) 
	{
		String Path = System.getProperty("user.dir")+"\\TestData\\Objective_Assessment\\QuestionnaireAvailableStatus_Upload.xls";
		try 
		{
			Workbook existingWorkbook = Workbook.getWorkbook(new File(Path));
			WritableWorkbook workbookCopy = Workbook.createWorkbook(new File(Path), existingWorkbook);
			WritableSheet Sheet = workbookCopy.getSheet("Qnre Status Details");
			Label label = new Label(0, 2, L5_ID);
			Sheet.addCell(label);
			workbookCopy.write();
			workbookCopy.close();
			existingWorkbook.close();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}                 
	}

	public static void PrimarySkill_SMEAllocationUpload(String Assessee_Personnel_No, String Assessee_EID, String Assessor_Personnel_No, String Assessor_EID, String Skill_ID) 
	{
		String Path = System.getProperty("user.dir")+"\\TestData\\Expert_Assessment\\SMEAllocation_Upload.xls";
		try 
		{
			Workbook existingWorkbook = Workbook.getWorkbook(new File(Path));
			WritableWorkbook workbookCopy = Workbook.createWorkbook(new File(Path), existingWorkbook);
			WritableSheet Sheet = workbookCopy.getSheet("Sheet1");
			Label label = new Label(0, 1, Assessee_Personnel_No);
			Label label1 = new Label(1, 1, Assessee_EID);
			Label label2 = new Label(2, 1, Assessor_Personnel_No);
			Label label3 = new Label(3, 1, Assessor_EID);
			Label label4 = new Label(4, 1, Skill_ID);
			Sheet.addCell(label);
			Sheet.addCell(label1);
			Sheet.addCell(label2);
			Sheet.addCell(label3);
			Sheet.addCell(label4);
			workbookCopy.write();
			workbookCopy.close();
			existingWorkbook.close();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}                 
	}

	public static void SecondarySkill_SMEAllocationUpload(String Assessee_Personnel_No, String Assessee_EID, String Assessor_Personnel_No, String Assessor_EID, String Skill_ID) 
	{
		String Path = System.getProperty("user.dir")+"\\TestData\\Expert_Assessment\\SMEAllocation_Upload.xls";
		try 
		{
			Workbook existingWorkbook = Workbook.getWorkbook(new File(Path));
			WritableWorkbook workbookCopy = Workbook.createWorkbook(new File(Path), existingWorkbook);
			WritableSheet Sheet = workbookCopy.getSheet("Sheet1");
			Label label = new Label(0, 2, Assessee_Personnel_No);
			Label label1 = new Label(1, 2, Assessee_EID);
			Label label2 = new Label(2, 2, Assessor_Personnel_No);
			Label label3 = new Label(3, 2, Assessor_EID);
			Label label4 = new Label(4, 2, Skill_ID);
			Sheet.addCell(label);
			Sheet.addCell(label1);
			Sheet.addCell(label2);
			Sheet.addCell(label3);
			Sheet.addCell(label4);
			workbookCopy.write();
			workbookCopy.close();
			existingWorkbook.close();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}                 
	}
	public static void SMEAllocationUpload(String Assessee_Personnel_No, String Assessee_EID, String Assessor_Personnel_No, String Assessor_EID, String Skill_ID) 
	{
		String Path = System.getProperty("user.dir")+"\\TestData\\Expert_Assessment\\SMEAllocation_Upload.xls";
		try 
		{
			Workbook existingWorkbook = Workbook.getWorkbook(new File(Path));
			WritableWorkbook workbookCopy = Workbook.createWorkbook(new File(Path), existingWorkbook);
			WritableSheet Sheet = workbookCopy.getSheet("Sheet1");
			Label label = new Label(0, 1, Assessee_Personnel_No);
			Label label1 = new Label(1, 1, Assessee_EID);
			Label label2 = new Label(2, 1, Assessor_Personnel_No);
			Label label3 = new Label(3, 1, Assessor_EID);
			Label label4 = new Label(4, 1, Skill_ID);
			Sheet.addCell(label);
			Sheet.addCell(label1);
			Sheet.addCell(label2);
			Sheet.addCell(label3);
			Sheet.addCell(label4);
			workbookCopy.write();
			workbookCopy.close();
			existingWorkbook.close();
			System.out.println("6");
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}                 
	}


	public static void SMEAllocation_Upload(String Assessee_Personnel_No, String Assessee_EID, String Assessor_Personnel_No, String Assessor_EID, String Skill_ID, String Add_Remove)

	{

		String Path = System.getProperty("user.dir")+"\\TestData\\Expert_Assessment\\SMEAllocation_Upload.xls";

		try

		{

			Workbook existingWorkbook = Workbook.getWorkbook(new File(Path));

			WritableWorkbook workbookCopy = Workbook.createWorkbook(new File(Path), existingWorkbook);

			WritableSheet Sheet = workbookCopy.getSheet("Sheet1");

			Label label = new Label(0, 1, Assessee_Personnel_No);

			Label label1 = new Label(1, 1, Assessee_EID);

			Label label2 = new Label(2, 1, Assessor_Personnel_No);

			Label label3 = new Label(3, 1, Assessor_EID);

			Label label4 = new Label(4, 1, Skill_ID);

			Label label5 = new Label(5, 1, Add_Remove);

			Sheet.addCell(label);

			Sheet.addCell(label1);

			Sheet.addCell(label2);

			Sheet.addCell(label3);

			Sheet.addCell(label4);

			Sheet.addCell(label5);

			workbookCopy.write();

			workbookCopy.close();

			existingWorkbook.close();

			System.out.println("6");

		}

		catch (Exception e)

		{

			e.printStackTrace();

		}                

	}

	public static void ExpertAssessmentMethod_Upload_HandsOnNoCertification(String Skill_ID) 
	{
		String Path = System.getProperty("user.dir")+"\\TestData\\Expert_Assessment\\ExpertAssessmentMethod_Upload.xls";
		try 
		{
			Workbook existingWorkbook = Workbook.getWorkbook(new File(Path));
			WritableWorkbook workbookCopy = Workbook.createWorkbook(new File(Path), existingWorkbook);
			WritableSheet Sheet = workbookCopy.getSheet("Sheet1");
			Label label = new Label(0, 1, Skill_ID);
			Label label1 = new Label(1, 1, "Y");
			Label label2 = new Label(2, 1, "N");
			Label label3 = new Label(3, 1, "Y");
			Label label4 = new Label(4, 1, "N");
			Label label5 = new Label(5, 1, "N");
			Label label6 = new Label(6, 1, "N");
			Sheet.addCell(label);
			Sheet.addCell(label1);
			Sheet.addCell(label2);
			Sheet.addCell(label3);
			Sheet.addCell(label4);
			Sheet.addCell(label5);
			Sheet.addCell(label6);
			workbookCopy.write();
			workbookCopy.close();
			existingWorkbook.close();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}                 
	}



	public static void SkillExpertAssessmentScheduleLink_Upload_HandsOn(String Skill_ID) 
	{
		String Path = System.getProperty("user.dir")+"\\TestData\\Expert_Assessment\\SkillExpertAssessmentScheduleLink_Upload.xls";
		try 
		{
			Workbook existingWorkbook = Workbook.getWorkbook(new File(Path));
			WritableWorkbook workbookCopy = Workbook.createWorkbook(new File(Path), existingWorkbook);
			WritableSheet Sheet = workbookCopy.getSheet("Sheet1");
			Label label = new Label(0, 1, Skill_ID);
			Label label1 = new Label(1, 1, "Hands-on");
			Label label2 = new Label(2, 1, "https://mycompetencyopsstaging.accenture.com/Scheduling/HomePageSchedule.aspx");

			Sheet.addCell(label);
			Sheet.addCell(label1);
			Sheet.addCell(label2);

			workbookCopy.write();
			workbookCopy.close();
			existingWorkbook.close();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}                 
	}
	public static void SkillExpertAssessmentScheduleLink_Upload_CaseStudy(String Skill_ID) 
	{
		String Path = System.getProperty("user.dir")+"\\TestData\\Expert_Assessment\\SkillExpertAssessmentScheduleLink_Upload.xls";
		try 
		{
			Workbook existingWorkbook = Workbook.getWorkbook(new File(Path));
			WritableWorkbook workbookCopy = Workbook.createWorkbook(new File(Path), existingWorkbook);
			WritableSheet Sheet = workbookCopy.getSheet("Sheet1");
			Label label = new Label(0, 1, Skill_ID);
			Label label1 = new Label(1, 1, "Case Study");
			Label label2 = new Label(2, 1, "https://mycompetencyopsstaging.accenture.com/Scheduling/HomePageSchedule.aspx");

			Sheet.addCell(label);
			Sheet.addCell(label1);
			Sheet.addCell(label2);

			workbookCopy.write();
			workbookCopy.close();
			existingWorkbook.close();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}                 
	}

	public static void ExpertAssessmentMethod_Upload_CaseStudyNoCertification(String Skill_ID) 
	{
		String Path = System.getProperty("user.dir")+"\\TestData\\Expert_Assessment\\ExpertAssessmentMethod_Upload.xls";
		try 
		{
			Workbook existingWorkbook = Workbook.getWorkbook(new File(Path));
			WritableWorkbook workbookCopy = Workbook.createWorkbook(new File(Path), existingWorkbook);
			WritableSheet Sheet = workbookCopy.getSheet("Sheet1");
			Label label = new Label(0, 1, Skill_ID);
			Label label1 = new Label(1, 1, "Y");
			Label label2 = new Label(2, 1, "N");
			Label label3 = new Label(3, 1, "N");
			Label label4 = new Label(4, 1, "Y");
			Label label5 = new Label(5, 1, "N");
			Label label6 = new Label(6, 1, "N");
			Sheet.addCell(label);
			Sheet.addCell(label1);
			Sheet.addCell(label2);
			Sheet.addCell(label3);
			Sheet.addCell(label4);
			Sheet.addCell(label5);
			Sheet.addCell(label6);
			workbookCopy.write();
			workbookCopy.close();
			existingWorkbook.close();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}                 
	}
	public static void WorkdaySkillExaminerReport_Upload(String EmployeePersonnelNo, String EnterpriseID, String Skill_ID, String Proficiency) 
	{
		String Path = System.getProperty("user.dir")+"\\TestData\\Expert_Assessment\\WorkdaySkillExaminerReport_Upload.xls";
		try 
		{
			Workbook existingWorkbook = Workbook.getWorkbook(new File(Path));
			WritableWorkbook workbookCopy = Workbook.createWorkbook(new File(Path), existingWorkbook);
			WritableSheet Sheet = workbookCopy.getSheet("Skill Examinar Report Upload");
			Label label = new Label(2, 1, EmployeePersonnelNo);
			Label label1 = new Label(3, 1, EnterpriseID);
			Label label2 = new Label(4, 1, Skill_ID);
			Label label3 = new Label(5, 1, "10/27/2019");

			Sheet.addCell(label);
			Sheet.addCell(label1);
			Sheet.addCell(label2);
			Sheet.addCell(label3);

			if (Proficiency.equals("p3"))
			{
				Label label4 = new Label(6, 1, "60");
				Sheet.addCell(label4);
			}

			else if (Proficiency.equals("p4"))
			{
				Label label4 = new Label(6, 1, "80");
				Sheet.addCell(label4);
			}

			else if (Proficiency.equals("p4+"))
			{
				Label label4 = new Label(6, 1, "90");
				Sheet.addCell(label4);
			}
			workbookCopy.write();
			workbookCopy.close();
			existingWorkbook.close();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}                 
	}
	public static void ExpertAssessment_AlternateCertification_Upload(String Enterprise_Id, String Skill_Id, String Certification_Name, 
			String Certification_CompletionDate,String Validity, String Add_Remove)
	{

		String Path = System.getProperty("user.dir")+"\\TestData\\Expert_Assessment\\AlternateMethod_ExpertAssessment_Upload.xls";

		try

		{
			Workbook existingWorkbook = Workbook.getWorkbook(new File(Path));

			WritableWorkbook workbookCopy = Workbook.createWorkbook(new File(Path), existingWorkbook);

			WritableSheet Sheet = workbookCopy.getSheet("Sheet1");

			Label label = new Label(0, 1, Enterprise_Id);
			Label label1 = new Label(1, 1, Skill_Id);
			Label label2 = new Label(2, 1, Certification_Name);
			Label label3 = new Label(3, 1, Certification_CompletionDate);
			Label label4 = new Label(4, 1, Validity);
			Label label5 = new Label(5, 1, Add_Remove);

			Sheet.addCell(label);
			Sheet.addCell(label1);
			Sheet.addCell(label2);
			Sheet.addCell(label3);
			Sheet.addCell(label4);
			Sheet.addCell(label5);

			workbookCopy.write();
			workbookCopy.close();
			existingWorkbook.close();


		}

		catch (Exception e)

		{

			e.printStackTrace();

		}                

	}  
	public static void ExpertAssessmentMethod_Upload_CaseStudyWithCertification(String Skill_ID) 
	{
		String Path = System.getProperty("user.dir")+"\\TestData\\Expert_Assessment\\ExpertAssessmentMethod_Upload.xls";
		try 
		{
			Workbook existingWorkbook = Workbook.getWorkbook(new File(Path));
			WritableWorkbook workbookCopy = Workbook.createWorkbook(new File(Path), existingWorkbook);
			WritableSheet Sheet = workbookCopy.getSheet("Sheet1");
			Label label = new Label(0, 1, Skill_ID);
			Label label1 = new Label(1, 1, "Y");
			Label label2 = new Label(2, 1, "N");
			Label label3 = new Label(3, 1, "N");
			Label label4 = new Label(4, 1, "Y");
			Label label5 = new Label(5, 1, "Y");
			Label label6 = new Label(6, 1, "N");
			Sheet.addCell(label);
			Sheet.addCell(label1);
			Sheet.addCell(label2);
			Sheet.addCell(label3);
			Sheet.addCell(label4);
			Sheet.addCell(label5);
			Sheet.addCell(label6);
			workbookCopy.write();
			workbookCopy.close();
			existingWorkbook.close();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}                 
	}
	public static void ExpertAssessmentMethod_Upload_HandsonWithCertification(String Skill_ID) 
	{
		String Path = System.getProperty("user.dir")+"\\TestData\\Expert_Assessment\\ExpertAssessmentMethod_Upload.xls";
		try 
		{
			Workbook existingWorkbook = Workbook.getWorkbook(new File(Path));
			WritableWorkbook workbookCopy = Workbook.createWorkbook(new File(Path), existingWorkbook);
			WritableSheet Sheet = workbookCopy.getSheet("Sheet1");
			Label label = new Label(0, 1, Skill_ID);
			Label label1 = new Label(1, 1, "Y");
			Label label2 = new Label(2, 1, "N");
			Label label3 = new Label(3, 1, "Y");
			Label label4 = new Label(4, 1, "N");
			Label label5 = new Label(5, 1, "Y");
			Label label6 = new Label(6, 1, "N");
			Sheet.addCell(label);
			Sheet.addCell(label1);
			Sheet.addCell(label2);
			Sheet.addCell(label3);
			Sheet.addCell(label4);
			Sheet.addCell(label5);
			Sheet.addCell(label6);
			workbookCopy.write();
			workbookCopy.close();
			existingWorkbook.close();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}                 
	}
	public static void CertificationApproverUpload_OneEntry(String Certification_Name1, String Approver_EID, String Add_Remove )

	{

		String Path = System.getProperty("user.dir")+"\\TestData\\Expert_Assessment\\Certification_Approver_Upload.xls";

		try

		{
			String CertificationName01 = prop.getProperty(Certification_Name1);
			String ApproverEID = prop.getProperty(Approver_EID);
			String AddRemove = prop.getProperty(Add_Remove);

			Workbook existingWorkbook = Workbook.getWorkbook(new File(Path));

			WritableWorkbook workbookCopy = Workbook.createWorkbook(new File(Path), existingWorkbook);

			WritableSheet Sheet = workbookCopy.getSheet("Sheet1");

			Label label = new Label(0, 1, CertificationName01);

			Label label1 = new Label(1, 1, ApproverEID);

			Label label2 = new Label(2, 1, AddRemove);

			Sheet.addCell(label);

			Sheet.addCell(label1);

			Sheet.addCell(label2);

			workbookCopy.write();

			workbookCopy.close();

			existingWorkbook.close();


		}

		catch (Exception e)

		{

			e.printStackTrace();

		}                

	}
	public static void CertificationApproverUpload(String Approver_EID, String Certification_Name1, String Certification_Name2, String Add_Remove )

	{

		String Path = System.getProperty("user.dir")+"\\TestData\\Expert_Assessment\\Certification_Approver_Upload.xls";

		try

		{
			String CertificationName01 = prop.getProperty(Certification_Name1);
			String CertificationName02 = prop.getProperty(Certification_Name2);
			String ApproverEID = prop.getProperty(Approver_EID);
			String AddRemove = prop.getProperty(Add_Remove);
			Workbook existingWorkbook = Workbook.getWorkbook(new File(Path));

			WritableWorkbook workbookCopy = Workbook.createWorkbook(new File(Path), existingWorkbook);

			WritableSheet Sheet = workbookCopy.getSheet("Sheet1");

			Label label = new Label(0, 1, CertificationName01);

			Label label1 = new Label(1, 1, ApproverEID);

			Label label2 = new Label(2, 1, AddRemove);

			Label label3 = new Label(0, 2, CertificationName02);

			Label label4 = new Label(1, 2, ApproverEID);

			Label label5 = new Label(2, 2, AddRemove);

			Sheet.addCell(label);

			Sheet.addCell(label1);

			Sheet.addCell(label2);

			Sheet.addCell(label3);

			Sheet.addCell(label4);

			Sheet.addCell(label5);

			workbookCopy.write();

			workbookCopy.close();

			existingWorkbook.close();

			System.out.println("6");

		}

		catch (Exception e)

		{

			e.printStackTrace();

		}                

	}

	public static void CertificationApproverUpload(String Approver_EID, String Certification_Name, String Add_Remove)

	{

		String Path = System.getProperty("user.dir")
				+ "\\TestData\\Expert_Assessment\\Certification_Approver_Upload.xls";

		try

		{
			String CertificationName = prop.getProperty(Certification_Name);
			String ApproverEID = prop.getProperty(Approver_EID);
			String AddRemove = prop.getProperty(Add_Remove);
			Workbook existingWorkbook = Workbook.getWorkbook(new File(Path));

			WritableWorkbook workbookCopy = Workbook.createWorkbook(new File(Path), existingWorkbook);

			WritableSheet Sheet = workbookCopy.getSheet("Sheet1");

			Label label = new Label(0, 1, CertificationName);

			Label label1 = new Label(1, 1, ApproverEID);

			Label label2 = new Label(2, 1, AddRemove);

			Sheet.addCell(label);

			Sheet.addCell(label1);

			Sheet.addCell(label2);

			workbookCopy.write();

			workbookCopy.close();

			existingWorkbook.close();

			System.out.println("6");

		}

		catch (Exception e)

		{

			e.printStackTrace();

		}

	}

	public static void ExpertArchivalRecurringTwoDaysOnceEmail_ActualResult(String RecipientEmp,String subjectTxt,String Content) 
	{
		String Path = System.getProperty("user.dir")+"\\TestData\\RecurringMailTwoDaysOnceForArchivalActualResult.xls";
		try 
		{
			Workbook existingWorkbook = Workbook.getWorkbook(new File(Path));
			WritableWorkbook workbookCopy = Workbook.createWorkbook(new File(Path), existingWorkbook);
			WritableSheet Sheet = workbookCopy.getSheet("Sheet1");

			Label label = new Label(0, 1, "ATC.myCompetency@accenture.com");
			Label label1 = new Label(1, 1, RecipientEmp);
			Label label2 = new Label(2, 1, subjectTxt);
			Label label3 = new Label(3, 1, Content);


			Sheet.addCell(label);
			Sheet.addCell(label1);
			Sheet.addCell(label2);
			Sheet.addCell(label3);


			workbookCopy.write();
			workbookCopy.close();
			existingWorkbook.close();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}                 
	}

	public static void ExpertArchivalRecurringTwoDaysOnceEmail_ExpectedResult(String FROM,String CTMC_SUBJECT,String Content1) 
	{
		String Path = System.getProperty("user.dir")+"\\TestData\\RecurringMailTwoDaysOnceForArchivalExpectedResult.xls";
		try 
		{
			Workbook existingWorkbook = Workbook.getWorkbook(new File(Path));
			WritableWorkbook workbookCopy = Workbook.createWorkbook(new File(Path), existingWorkbook);
			WritableSheet Sheet = workbookCopy.getSheet("Sheet1");


			Label label = new Label(0, 1, FROM);
			Label label1 = new Label(1, 1, CTMC_SUBJECT);
			Label label2 = new Label(2, 1, Content1);


			Sheet.addCell(label);
			Sheet.addCell(label1);
			Sheet.addCell(label2);


			workbookCopy.write();
			workbookCopy.close();
			existingWorkbook.close();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}                 
	}

	public static void PrimarySkillMapping_RSMUpload(String PersonnelNo, String L1_NAME, String L2_NAME, String L3_NAME, String L4_NAME, String L5_NAME) 
	{
		String Path = System.getProperty("user.dir")+"\\TestData\\Skill_Change\\Resource_Skill_Mapping.xls";
		try 
		{
			Workbook existingWorkbook = Workbook.getWorkbook(new File(Path));
			WritableWorkbook workbookCopy = Workbook.createWorkbook(new File(Path), existingWorkbook);
			WritableSheet Sheet = workbookCopy.getSheet("Resource_Skill_Mapping");

			Label label = new Label(0, 1, PersonnelNo);
			Label label1 = new Label(1, 1, "P");
			Label label2 = new Label(2, 1, L5_NAME);
			Label label3 = new Label(3, 1, L4_NAME);
			Label label4 = new Label(4, 1, L3_NAME);
			Label label5 = new Label(5, 1, L2_NAME);
			Label label6 = new Label(6, 1, L1_NAME);

			Sheet.addCell(label);
			Sheet.addCell(label1);
			Sheet.addCell(label2);
			Sheet.addCell(label3);
			Sheet.addCell(label4);
			workbookCopy.write();
			workbookCopy.close();
			existingWorkbook.close();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	public static void PrimarySkillMapping_RSMUpload( String L1_NAME, String L2_NAME, String L3_NAME, String L4_NAME, String L5_NAME) 
	{
		String Path = System.getProperty("user.dir")+"\\TestData\\Skill_Change\\Resource_Skill_Mapping.xls";
		try 
		{
			Workbook existingWorkbook = Workbook.getWorkbook(new File(Path));
			WritableWorkbook workbookCopy = Workbook.createWorkbook(new File(Path), existingWorkbook);
			WritableSheet Sheet = workbookCopy.getSheet("Resource_Skill_Mapping");


			Label label1 = new Label(1, 1, "P");
			Label label2 = new Label(2, 1, L5_NAME);
			Label label3 = new Label(3, 1, L4_NAME);
			Label label4 = new Label(4, 1, L3_NAME);
			Label label5 = new Label(5, 1, L2_NAME);
			Label label6 = new Label(6, 1, L1_NAME);


			Sheet.addCell(label1);
			Sheet.addCell(label2);
			Sheet.addCell(label3);
			Sheet.addCell(label4);
			workbookCopy.write();
			workbookCopy.close();
			existingWorkbook.close();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	public static void SkillChange_RSMUpload(String PersonnelNo,String Skill_NAME,String SpecialityName_Primary,String SkillCapability_Primary,String SkillCategory_Primary,String SkillType_Primary,String Skill_NAME_Sec,String SpecialityName_Sec,String SkillCapability_Sec,String SkillCategory_Sec,String SkillType_Sec) 
	{
		String Path = System.getProperty("user.dir")+"\\TestData\\Skill_Change\\Resource_Skill_Mapping.xls";
		try 
		{
			Workbook existingWorkbook = Workbook.getWorkbook(new File(Path));
			WritableWorkbook workbookCopy = Workbook.createWorkbook(new File(Path), existingWorkbook);
			WritableSheet Sheet = workbookCopy.getSheet("Resource_Skill_Mapping");

			Label label = new Label(0, 1, PersonnelNo);
			Label label1 = new Label(1, 1, "P");
			Label label2 = new Label(2, 1, Skill_NAME);
			Label label3 = new Label(3, 1, SpecialityName_Primary);
			Label label4 = new Label(4, 1, SkillCapability_Primary);
			Label label5 = new Label(5, 1, SkillCategory_Primary);
			Label label6 = new Label(6, 1, SkillType_Primary);

			Label label7 = new Label(0, 2, PersonnelNo);
			Label label8 = new Label(1, 2, "E");
			Label label9 = new Label(2, 2, Skill_NAME_Sec);
			Label label10 = new Label(3, 2, SpecialityName_Sec);
			Label label11 = new Label(4, 2, SkillCapability_Sec);
			Label label12 = new Label(5, 2, SkillCategory_Sec);
			Label label13 = new Label(6, 2, SkillType_Sec);

			Sheet.addCell(label);
			Sheet.addCell(label1);
			Sheet.addCell(label2);
			Sheet.addCell(label3);
			Sheet.addCell(label4);
			Sheet.addCell(label5);
			Sheet.addCell(label6);
			Sheet.addCell(label7);
			Sheet.addCell(label8);
			Sheet.addCell(label9);
			Sheet.addCell(label10);
			Sheet.addCell(label11);
			Sheet.addCell(label12);
			Sheet.addCell(label13);

			workbookCopy.write();
			workbookCopy.close();
			existingWorkbook.close();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}                 
	}
	public static void Master_RSMUpload(String PersonnelNo,String Skill_NAME,String SpecialityName_Primary,String SkillCapability_Primary,String SkillCategory_Primary,String SkillType_Primary,String Skill_NAME_Sec,String SpecialityName_Sec,String SkillCapability_Sec,String SkillCategory_Sec,String SkillType_Sec) 
	{
		String Path = System.getProperty("user.dir")+"\\TestData\\MasterAssessment\\Resource_Skill_Mapping.xls";
		try 
		{
			Workbook existingWorkbook = Workbook.getWorkbook(new File(Path));
			WritableWorkbook workbookCopy = Workbook.createWorkbook(new File(Path), existingWorkbook);
			WritableSheet Sheet = workbookCopy.getSheet("Resource_Skill_Mapping");

			Label label = new Label(0, 1, PersonnelNo);
			Label label1 = new Label(1, 1, "P");
			Label label2 = new Label(2, 1, Skill_NAME);
			Label label3 = new Label(3, 1, SpecialityName_Primary);
			Label label4 = new Label(4, 1, SkillCapability_Primary);
			Label label5 = new Label(5, 1, SkillCategory_Primary);
			Label label6 = new Label(6, 1, SkillType_Primary);

			Label label7 = new Label(0, 2, PersonnelNo);
			Label label8 = new Label(1, 2, "E");
			Label label9 = new Label(2, 2, Skill_NAME_Sec);
			Label label10 = new Label(3, 2, SpecialityName_Sec);
			Label label11 = new Label(4, 2, SkillCapability_Sec);
			Label label12 = new Label(5, 2, SkillCategory_Sec);
			Label label13 = new Label(6, 2, SkillType_Sec);

			Sheet.addCell(label);
			Sheet.addCell(label1);
			Sheet.addCell(label2);
			Sheet.addCell(label3);
			Sheet.addCell(label4);
			Sheet.addCell(label5);
			Sheet.addCell(label6);
			// Sheet.addCell(label7);
			// Sheet.addCell(label8);
			// Sheet.addCell(label9);
			//Sheet.addCell(label10);
			// Sheet.addCell(label11);
			//Sheet.addCell(label12);
			//Sheet.addCell(label13);

			workbookCopy.write();
			workbookCopy.close();
			existingWorkbook.close();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}                 
	}

	public static void EmailAutomation_Upload(String RecipientEmp,String subjectTxt,String Content) 
	{
		String Path = System.getProperty("user.dir")+"\\TestData\\ActualMail.xls";
		try 
		{
			Workbook existingWorkbook = Workbook.getWorkbook(new File(Path));
			WritableWorkbook workbookCopy = Workbook.createWorkbook(new File(Path), existingWorkbook);
			WritableSheet Sheet = workbookCopy.getSheet("Sheet1");

			Label label = new Label(0, 1, "ATC.myCompetency@accenture.com");
			Label label1 = new Label(1, 1, RecipientEmp);
			Label label2 = new Label(2, 1, subjectTxt);
			Label label3 = new Label(3, 1, Content);


			Sheet.addCell(label);
			Sheet.addCell(label1);
			Sheet.addCell(label2);
			Sheet.addCell(label3);


			workbookCopy.write();
			workbookCopy.close();
			existingWorkbook.close();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}                 
	}

	public static void EmailAutomation_Uploadd(String FROM,String CTMC_SUBJECT,String Content1) 
	{
		String Path = System.getProperty("user.dir")+"\\TestData\\ExpectedMail.xls";
		try 
		{
			Workbook existingWorkbook = Workbook.getWorkbook(new File(Path));
			WritableWorkbook workbookCopy = Workbook.createWorkbook(new File(Path), existingWorkbook);
			WritableSheet Sheet = workbookCopy.getSheet("Sheet1");


			Label label = new Label(0, 1, FROM);
			Label label1 = new Label(1, 1, CTMC_SUBJECT);
			Label label2 = new Label(2, 1, Content1);


			Sheet.addCell(label);
			Sheet.addCell(label1);
			Sheet.addCell(label2);


			workbookCopy.write();
			workbookCopy.close();
			existingWorkbook.close();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}                 
	}
	/********************Skill Change Request Notification Email To Employee before 15days*******************/

	public static void SkillChangeRequestAutoExpiryEmail_ActualResult(String RecipientEmp,String subjectTxt,String Content) 
	{
		String Path = System.getProperty("user.dir")+"\\TestData\\SkillChangeRequestAutoExpiryActualResult.xls";
		try 
		{
			Workbook existingWorkbook = Workbook.getWorkbook(new File(Path));
			WritableWorkbook workbookCopy = Workbook.createWorkbook(new File(Path), existingWorkbook);
			WritableSheet Sheet = workbookCopy.getSheet("Sheet1");

			Label label = new Label(0, 1, "ATC.myCompetency@accenture.com");
			Label label1 = new Label(1, 1, RecipientEmp);
			Label label2 = new Label(2, 1, subjectTxt);
			Label label3 = new Label(3, 1, Content);


			Sheet.addCell(label);
			Sheet.addCell(label1);
			Sheet.addCell(label2);
			Sheet.addCell(label3);


			workbookCopy.write();
			workbookCopy.close();
			existingWorkbook.close();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}                 
	}

	public static void SkillChangeRequestAutoExpiryEmail_ExpectedResult(String FROM,String CTMC_SUBJECT,String Content1) 
	{
		String Path = System.getProperty("user.dir")+"\\TestData\\SkillChangeRequestAutoExpiryExpectedResult.xls";
		try 
		{
			Workbook existingWorkbook = Workbook.getWorkbook(new File(Path));
			WritableWorkbook workbookCopy = Workbook.createWorkbook(new File(Path), existingWorkbook);
			WritableSheet Sheet = workbookCopy.getSheet("Sheet1");


			Label label = new Label(0, 1, FROM);
			Label label1 = new Label(1, 1, CTMC_SUBJECT);
			Label label2 = new Label(2, 1, Content1);


			Sheet.addCell(label);
			Sheet.addCell(label1);
			Sheet.addCell(label2);


			workbookCopy.write();
			workbookCopy.close();
			existingWorkbook.close();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}                 
	}


	public static void MasterArchivalNotificationEmail_ActualResult(String RecipientEmp,String subjectTxt,String Content) 
	{
		String Path = System.getProperty("user.dir")+"\\TestData\\NotificationMailForArchivalActualResult.xls";
		try 
		{
			Workbook existingWorkbook = Workbook.getWorkbook(new File(Path));
			WritableWorkbook workbookCopy = Workbook.createWorkbook(new File(Path), existingWorkbook);
			WritableSheet Sheet = workbookCopy.getSheet("Sheet1");

			Label label = new Label(0, 1, "ATC.myCompetency@accenture.com");
			Label label1 = new Label(1, 1, RecipientEmp);
			Label label2 = new Label(2, 1, subjectTxt);
			Label label3 = new Label(3, 1, Content);


			Sheet.addCell(label);
			Sheet.addCell(label1);
			Sheet.addCell(label2);
			Sheet.addCell(label3);


			workbookCopy.write();
			workbookCopy.close();
			existingWorkbook.close();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}                 
	}

	public static void MasterArchivalNotificationEmail_ExpectedResult(String FROM,String CTMC_SUBJECT,String Content1) 
	{
		String Path = System.getProperty("user.dir")+"\\TestData\\NotificationMailForArchivalExpectedResult.xls";
		try 
		{
			Workbook existingWorkbook = Workbook.getWorkbook(new File(Path));
			WritableWorkbook workbookCopy = Workbook.createWorkbook(new File(Path), existingWorkbook);
			WritableSheet Sheet = workbookCopy.getSheet("Sheet1");


			Label label = new Label(0, 1, FROM);
			Label label1 = new Label(1, 1, CTMC_SUBJECT);
			Label label2 = new Label(2, 1, Content1);


			Sheet.addCell(label);
			Sheet.addCell(label1);
			Sheet.addCell(label2);


			workbookCopy.write();
			workbookCopy.close();
			existingWorkbook.close();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}                 
	}

	public static void MasterArchivalRecurringEmail_ActualResult(String RecipientEmp,String subjectTxt,String Content) 
	{
		String Path = System.getProperty("user.dir")+"\\TestData\\RecurringMailForArchivalActualResult.xls";
		try 
		{
			Workbook existingWorkbook = Workbook.getWorkbook(new File(Path));
			WritableWorkbook workbookCopy = Workbook.createWorkbook(new File(Path), existingWorkbook);
			WritableSheet Sheet = workbookCopy.getSheet("Sheet1");

			Label label = new Label(0, 1, "ATC.myCompetency@accenture.com");
			Label label1 = new Label(1, 1, RecipientEmp);
			Label label2 = new Label(2, 1, subjectTxt);
			Label label3 = new Label(3, 1, Content);


			Sheet.addCell(label);
			Sheet.addCell(label1);
			Sheet.addCell(label2);
			Sheet.addCell(label3);


			workbookCopy.write();
			workbookCopy.close();
			existingWorkbook.close();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}                 
	}

	public static void MasterArchivalRecurringEmail_ExpectedResult(String FROM,String CTMC_SUBJECT,String Content1) 
	{
		String Path = System.getProperty("user.dir")+"\\TestData\\RecurringMailForArchivalExpectedResult.xls";
		try 
		{
			Workbook existingWorkbook = Workbook.getWorkbook(new File(Path));
			WritableWorkbook workbookCopy = Workbook.createWorkbook(new File(Path), existingWorkbook);
			WritableSheet Sheet = workbookCopy.getSheet("Sheet1");


			Label label = new Label(0, 1, FROM);
			Label label1 = new Label(1, 1, CTMC_SUBJECT);
			Label label2 = new Label(2, 1, Content1);


			Sheet.addCell(label);
			Sheet.addCell(label1);
			Sheet.addCell(label2);


			workbookCopy.write();
			workbookCopy.close();
			existingWorkbook.close();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}                 
	}

	public static void MasterArchivalRecurringTwoDaysOnceEmail_ActualResult(String RecipientEmp,String subjectTxt,String Content) 
	{
		String Path = System.getProperty("user.dir")+"\\TestData\\RecurringMailTwoDaysOnceForArchivalActualResult.xls";
		try 
		{
			Workbook existingWorkbook = Workbook.getWorkbook(new File(Path));
			WritableWorkbook workbookCopy = Workbook.createWorkbook(new File(Path), existingWorkbook);
			WritableSheet Sheet = workbookCopy.getSheet("Sheet1");

			Label label = new Label(0, 1, "ATC.myCompetency@accenture.com");
			Label label1 = new Label(1, 1, RecipientEmp);
			Label label2 = new Label(2, 1, subjectTxt);
			Label label3 = new Label(3, 1, Content);


			Sheet.addCell(label);
			Sheet.addCell(label1);
			Sheet.addCell(label2);
			Sheet.addCell(label3);


			workbookCopy.write();
			workbookCopy.close();
			existingWorkbook.close();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}                 
	}

	public static void MasterArchivalRecurringTwoDaysOnceEmail_ExpectedResult(String FROM,String CTMC_SUBJECT,String Content1) 
	{
		String Path = System.getProperty("user.dir")+"\\TestData\\RecurringMailTwoDaysOnceForArchivalExpectedResult.xls";
		try 
		{
			Workbook existingWorkbook = Workbook.getWorkbook(new File(Path));
			WritableWorkbook workbookCopy = Workbook.createWorkbook(new File(Path), existingWorkbook);
			WritableSheet Sheet = workbookCopy.getSheet("Sheet1");


			Label label = new Label(0, 1, FROM);
			Label label1 = new Label(1, 1, CTMC_SUBJECT);
			Label label2 = new Label(2, 1, Content1);


			Sheet.addCell(label);
			Sheet.addCell(label1);
			Sheet.addCell(label2);


			workbookCopy.write();
			workbookCopy.close();
			existingWorkbook.close();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}                 
	}


	public static void Master_Interviewer_Allocation_Upload(String PersonnelNo, String UserEnterpriseId,
			String MasterPersonnelNo, String MasterEnterpriseId, String SkillType_Primary, String SkillCategory_Primary,
			String SkillCapability_Primary, String SpecialityName_Primary, String Skill_NAME) {
		String Path = System.getProperty("user.dir") + "\\TestData\\MasterAssessment\\Master_Interviewer_Allocation.xls";
		try {
			Workbook existingWorkbook = Workbook.getWorkbook(new File(Path));
			WritableWorkbook workbookCopy = Workbook.createWorkbook(new File(Path), existingWorkbook);
			WritableSheet Sheet = workbookCopy.getSheet("Master_Interviewer_Allocation");

			Label label = new Label(0, 1, PersonnelNo);
			Label label1 = new Label(1, 1, UserEnterpriseId);
			Label label2 = new Label(2, 1, MasterPersonnelNo);
			Label label3 = new Label(3, 1, MasterEnterpriseId);
			Label label4 = new Label(4, 1, SkillType_Primary);
			Label label5 = new Label(5, 1, SkillCategory_Primary);
			Label label6 = new Label(6, 1, SkillCapability_Primary);
			Label label7 = new Label(7, 1, SpecialityName_Primary);
			Label label8 = new Label(8, 1, Skill_NAME);
			Label label9 = new Label(9, 1, "A");

			Sheet.addCell(label);
			Sheet.addCell(label1);
			Sheet.addCell(label2);
			Sheet.addCell(label3);
			Sheet.addCell(label4);
			Sheet.addCell(label5);
			Sheet.addCell(label6);
			Sheet.addCell(label7);
			Sheet.addCell(label8);
			Sheet.addCell(label9);

			workbookCopy.write();
			workbookCopy.close();
			existingWorkbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void SupervisorAllocationUpload(String Resource_Personnel_No, String Supervisor_Personnel_No, String Supervisor_Flag_Update) 
	{
		String Path = System.getProperty("user.dir")+"\\TestData\\Skill_Change\\SupervisorDetails.xls";
		System.out.println("path"+Path);
		try 
		{

			Workbook existingWorkbook = Workbook.getWorkbook(new File(Path));
			WritableWorkbook workbookCopy = Workbook.createWorkbook(new File(Path), existingWorkbook);
			WritableSheet Sheet = workbookCopy.getSheet("SupervisorDetails");
			Label label = new Label(0, 1, Resource_Personnel_No);
			Label label1 = new Label(1, 1, Supervisor_Personnel_No);
			Label label2 = new Label(2, 1, Supervisor_Flag_Update);

			Sheet.addCell(label);
			Sheet.addCell(label1);
			Sheet.addCell(label2);

			workbookCopy.write();
			workbookCopy.close();
			existingWorkbook.close();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}                 
	}

	public static void DUMaster_Allocation_Upload(String DU_Personnel_No, String DU_EID, String HR_Personnel_No) 
	{
		String Path = System.getProperty("user.dir")+"\\SkillChange\\DUMaster.xls";
		System.out.println("path"+Path);
		try 
		{

			Workbook existingWorkbook = Workbook.getWorkbook(new File(Path));
			WritableWorkbook workbookCopy = Workbook.createWorkbook(new File(Path), existingWorkbook);
			WritableSheet Sheet = workbookCopy.getSheet("DUMaster");
			Label label = new Label(0, 1, DU_Personnel_No);
			Label label1 = new Label(1, 1, DU_EID);
			Label label2 = new Label(2, 1, HR_Personnel_No);

			Sheet.addCell(label);
			Sheet.addCell(label1);
			Sheet.addCell(label2);

			workbookCopy.write();
			workbookCopy.close();
			existingWorkbook.close();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}                 
	}


	public static void SKSLA_Allocation_Upload(String Employee_EID,String Employee_Personnel_No, String Skill,String Specialityy,String SkillCapability,String SkillCategory,String SkillType) 
	{
		String Path = System.getProperty("user.dir")+"\\TestData\\Skill_Change\\SkillLevelSkillChangeApprover_Upload.xls";
		System.out.println("path"+Path);
		try 
		{

			Workbook existingWorkbook = Workbook.getWorkbook(new File(Path));
			WritableWorkbook workbookCopy = Workbook.createWorkbook(new File(Path), existingWorkbook);
			WritableSheet Sheet = workbookCopy.getSheet("Sheet1");
			Label label = new Label(0, 1, Employee_Personnel_No);
			Label label1 = new Label(1, 1, Employee_EID);
			Label label2 = new Label(2, 1, Skill);
			Label label3 = new Label(3, 1, Specialityy);
			Label label4 = new Label(4, 1, SkillCapability);
			Label label5 = new Label(5, 1, SkillCategory);
			Label label6 = new Label(6, 1, SkillType);
			Label label7 = new Label(7, 1, "A");

			Sheet.addCell(label);
			Sheet.addCell(label1);
			Sheet.addCell(label2);
			Sheet.addCell(label3);
			Sheet.addCell(label4);
			Sheet.addCell(label5);
			Sheet.addCell(label6);
			Sheet.addCell(label7);

			workbookCopy.write();
			workbookCopy.close();
			existingWorkbook.close();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}                 
	}


	public static void SKSLA_SecondarySkill_Allocation_Upload(String Employee_EID,String Employee_Personnel_No, String Skill,String Specialityy,String SkillCapability,String SkillCategory,String SkillType) 
	{
		String Path = System.getProperty("user.dir")+"\\TestData\\Skill_Change\\SkillLevelSkillChangeApprover_Upload.xls";
		System.out.println("path"+Path);
		try 
		{

			Workbook existingWorkbook = Workbook.getWorkbook(new File(Path));
			WritableWorkbook workbookCopy = Workbook.createWorkbook(new File(Path), existingWorkbook);
			WritableSheet Sheet = workbookCopy.getSheet("Sheet1");
			Label label = new Label(0, 1, Employee_Personnel_No);
			Label label1 = new Label(1, 1, Employee_EID);
			Label label2 = new Label(2, 1, Skill);
			Label label3 = new Label(3, 1, Specialityy);
			Label label4 = new Label(4, 1, SkillCapability);
			Label label5 = new Label(5, 1, SkillCategory);
			Label label6 = new Label(6, 1, SkillType);
			Label label7 = new Label(7, 1, "A");

			Sheet.addCell(label);
			Sheet.addCell(label1);
			Sheet.addCell(label2);
			Sheet.addCell(label3);
			Sheet.addCell(label4);
			Sheet.addCell(label5);
			Sheet.addCell(label6);
			Sheet.addCell(label7);

			workbookCopy.write();
			workbookCopy.close();
			existingWorkbook.close();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}                 
	}

	public static void BusinessGroupLead_Upload_Upload_Dual(String Employee_EID,String Employee_Personnel_No, String Skill,String Specialityy,String SkillCapability,String SkillCategory,String SkillType,
			String Employee_EID2,String Employee_Personnel_No2, String AccepSkill,String AccepSpecialityy,String AccepSkillCapability,String AccepSkillCategory,String AccepSkillType, String BusinessGroupLeadTemplate) 
	{
		String Path = System.getProperty("user.dir")+"\\TestData\\Skill_Change\\"+BusinessGroupLeadTemplate+".xls";
		System.out.println("path"+Path);
		try 
		{

			Workbook existingWorkbook = Workbook.getWorkbook(new File(Path));
			WritableWorkbook workbookCopy = Workbook.createWorkbook(new File(Path), existingWorkbook);
			WritableSheet Sheet = workbookCopy.getSheet("Sheet1");
			Label label = new Label(0, 1, Employee_Personnel_No);
			Label label1 = new Label(1, 1, Employee_EID);
			Label label2 = new Label(2, 1, Skill);
			Label label3 = new Label(3, 1, Specialityy);
			Label label4 = new Label(4, 1, SkillCapability);
			Label label5 = new Label(5, 1, SkillCategory);
			Label label6 = new Label(6, 1, SkillType);
			Label label7 = new Label(7, 1, "A");

			Label label8 = new Label(0, 2, Employee_Personnel_No2);
			Label label9 = new Label(1, 2, Employee_EID2);
			Label label10 = new Label(2, 2, AccepSkill);
			Label label11 = new Label(3, 2, AccepSpecialityy);
			Label label12 = new Label(4, 2, AccepSkillCapability);
			Label label13 = new Label(5, 2, AccepSkillCategory);
			Label label14 = new Label(6, 2, AccepSkillType);
			Label label15 = new Label(7, 2, "A");

			Sheet.addCell(label);
			Sheet.addCell(label1);
			Sheet.addCell(label2);
			Sheet.addCell(label3);
			Sheet.addCell(label4);
			Sheet.addCell(label5);
			Sheet.addCell(label6);
			Sheet.addCell(label7);
			Sheet.addCell(label8);
			Sheet.addCell(label9);
			Sheet.addCell(label10);
			Sheet.addCell(label11);
			Sheet.addCell(label12);
			Sheet.addCell(label13);
			Sheet.addCell(label14);
			Sheet.addCell(label15);

			workbookCopy.write();
			workbookCopy.close();
			existingWorkbook.close();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}                 
	}
	
	public static void BusinessGroupLead_Upload_Upload(String Employee_EID,String Employee_Personnel_No, String Skill,String Specialityy,String SkillCapability,String SkillCategory,String SkillType,
			String BusinessGroupLeadTemplate) 
	{
		String Path = System.getProperty("user.dir")+"\\TestData\\Skill_Change\\"+BusinessGroupLeadTemplate+".xls";
		System.out.println("path"+Path);
		try 
		{

			Workbook existingWorkbook = Workbook.getWorkbook(new File(Path));
			WritableWorkbook workbookCopy = Workbook.createWorkbook(new File(Path), existingWorkbook);
			WritableSheet Sheet = workbookCopy.getSheet("Sheet1");
			Label label = new Label(0, 1, Employee_Personnel_No);
			Label label1 = new Label(1, 1, Employee_EID);
			Label label2 = new Label(2, 1, Skill);
			Label label3 = new Label(3, 1, Specialityy);
			Label label4 = new Label(4, 1, SkillCapability);
			Label label5 = new Label(5, 1, SkillCategory);
			Label label6 = new Label(6, 1, SkillType);
			Label label7 = new Label(7, 1, "A");

			Sheet.addCell(label);
			Sheet.addCell(label1);
			Sheet.addCell(label2);
			Sheet.addCell(label3);
			Sheet.addCell(label4);
			Sheet.addCell(label5);
			Sheet.addCell(label6);
			Sheet.addCell(label7);

			workbookCopy.write();
			workbookCopy.close();
			existingWorkbook.close();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}                 
	}
	
	public static void SKSLA_Allocation_Upload_Dual(String Employee_EID,String Employee_Personnel_No, String Skill,String Specialityy,String SkillCapability,String SkillCategory,String SkillType,
			String Employee_EID2,String Employee_Personnel_No2, String AccepSkill,String AccepSpecialityy,String AccepSkillCapability,String AccepSkillCategory,String AccepSkillType, String SkslaTemplate) 
	{
		String Path = System.getProperty("user.dir")+"\\TestData\\Skill_Change\\"+SkslaTemplate+".xls";
		System.out.println("path"+Path);
		try 
		{

			Workbook existingWorkbook = Workbook.getWorkbook(new File(Path));
			WritableWorkbook workbookCopy = Workbook.createWorkbook(new File(Path), existingWorkbook);
			WritableSheet Sheet = workbookCopy.getSheet("Sheet1");
			Label label = new Label(0, 1, Employee_Personnel_No);
			Label label1 = new Label(1, 1, Employee_EID);
			Label label2 = new Label(2, 1, Skill);
			Label label3 = new Label(3, 1, Specialityy);
			Label label4 = new Label(4, 1, SkillCapability);
			Label label5 = new Label(5, 1, SkillCategory);
			Label label6 = new Label(6, 1, SkillType);
			Label label7 = new Label(7, 1, "A");

			Label label8 = new Label(0, 2, Employee_Personnel_No2);
			Label label9 = new Label(1, 2, Employee_EID2);
			Label label10 = new Label(2, 2, AccepSkill);
			Label label11 = new Label(3, 2, AccepSpecialityy);
			Label label12 = new Label(4, 2, AccepSkillCapability);
			Label label13 = new Label(5, 2, AccepSkillCategory);
			Label label14 = new Label(6, 2, AccepSkillType);
			Label label15 = new Label(7, 2, "A");

			Sheet.addCell(label);
			Sheet.addCell(label1);
			Sheet.addCell(label2);
			Sheet.addCell(label3);
			Sheet.addCell(label4);
			Sheet.addCell(label5);
			Sheet.addCell(label6);
			Sheet.addCell(label7);
			Sheet.addCell(label8);
			Sheet.addCell(label9);
			Sheet.addCell(label10);
			Sheet.addCell(label11);
			Sheet.addCell(label12);
			Sheet.addCell(label13);
			Sheet.addCell(label14);
			Sheet.addCell(label15);

			workbookCopy.write();
			workbookCopy.close();
			existingWorkbook.close();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}                 
	}

	


	public static void CapabilityLead_Allocation_Upload(String SkillCapability,String SkillCategory,String SkillType,String CL_Personnel_No) 
	{
		String Path = System.getProperty("user.dir")+"\\TestData\\Skill_Change\\CAPABILITYLEADDETAILS.xls";
		System.out.println("path"+Path);
		try 
		{

			Workbook existingWorkbook = Workbook.getWorkbook(new File(Path));
			WritableWorkbook workbookCopy = Workbook.createWorkbook(new File(Path), existingWorkbook);
			WritableSheet Sheet = workbookCopy.getSheet("Capability Details");
			Label label = new Label(0, 1, SkillCapability);
			Label label1 = new Label(1, 1, SkillCategory);
			Label label2 = new Label(2, 1, SkillType);
			Label label3 = new Label(3, 1, CL_Personnel_No);
			Label label4 = new Label(4, 1, "Y");

			Sheet.addCell(label);
			Sheet.addCell(label1);
			Sheet.addCell(label2);
			Sheet.addCell(label3);
			Sheet.addCell(label4);

			workbookCopy.write();
			workbookCopy.close();
			existingWorkbook.close();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}                 
	}

	public static void CapabilityLead_SecondarySkill_Allocation_Upload(String SkillCapability,String SkillCategory,String SkillType,String CL_Personnel_No) 
	{
		String Path = System.getProperty("user.dir")+"\\TestData\\Skill_Change\\CAPABILITYLEADDETAILS.xls";
		System.out.println("path"+Path);
		try 
		{

			Workbook existingWorkbook = Workbook.getWorkbook(new File(Path));
			WritableWorkbook workbookCopy = Workbook.createWorkbook(new File(Path), existingWorkbook);
			WritableSheet Sheet = workbookCopy.getSheet("Capability Details");
			Label label = new Label(0, 1, SkillCapability);
			Label label1 = new Label(1, 1, SkillCategory);
			Label label2 = new Label(2, 1, SkillType);
			Label label3 = new Label(3, 1, CL_Personnel_No);
			Label label4 = new Label(4, 1, "Y");

			Sheet.addCell(label);
			Sheet.addCell(label1);
			Sheet.addCell(label2);
			Sheet.addCell(label3);
			Sheet.addCell(label4);

			workbookCopy.write();
			workbookCopy.close();
			existingWorkbook.close();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}                 
	}



	//     	public static void Resource_Skill_Mapping(String PersonnelNo, String L1_NAME, String L2_NAME, String L3_NAME, String L4_NAME, String L5_NAME) 
	//     	{
	//     	String Path = System.getProperty("user.dir")+"\\TestData\\Objective_Assessment\\Resource_Skill_Mapping.xls";
	//     	  try 
	//     	  {
	//     	    	Workbook existingWorkbook = Workbook.getWorkbook(new File(Path));
	//     	        WritableWorkbook workbookCopy = Workbook.createWorkbook(new File(Path), existingWorkbook);
	//     	     	WritableSheet Sheet = workbookCopy.getSheet("Resource_Skill_Mapping");
	//     	       	Label label = new Label(2, 1, P_L5_NAME);
	//     	       	Label label1 = new Label(3, 1,P_L4_NAME);
	//     	       	Label label2 = new Label(4, 1,P_L3_NAME);
	//     	       	Label label3 = new Label(5, 1,P_L2_NAME);
	//     	       	Label label4 = new Label(6, 1,P_L1_NAME);
	//     	    	Label label = new Label(2, 2,S_L5_NAME);
	//     	       	Label label1 = new Label(3, 2,S_L4_NAME);
	//     	       	Label label2 = new Label(4, 2,S_L3_NAME);
	//     	       	Label label3 = new Label(5, 2,S_L2_NAME);
	//     	       	Label label4 = new Label(6, 2,S_L1_NAME);
	//     	        Sheet.addCell(label);
	//     	        Sheet.addCell(label1);
	//     	        Sheet.addCell(label2);
	//     	        Sheet.addCell(label3);
	//     	        Sheet.addCell(label4);
	//     	        Sheet.addCell(label);
	//     	        Sheet.addCell(label1);
	//     	        Sheet.addCell(label2);
	//     	        Sheet.addCell(label3);
	//     	        Sheet.addCell(label4);
	//     	        
	//     	        workbookCopy.write();
	//     	        workbookCopy.close();
	//     	        existingWorkbook.close();
	//     	      }
	//           catch (Exception e) 
	//           {
	//         	  e.printStackTrace();
	//           }                 
	//     	}



	public static void Resource_Skill_Mapping_Primary(String PersonnelNo, String L1_NAME, String L2_NAME, String L3_NAME, String L4_NAME, String L5_NAME) 
	{
		String Path = System.getProperty("user.dir")+"\\TestData\\Objective_Assessment\\Resource_Skill_Mapping.xls";
		try 
		{
			Workbook existingWorkbook = Workbook.getWorkbook(new File(Path));
			WritableWorkbook workbookCopy = Workbook.createWorkbook(new File(Path), existingWorkbook);
			WritableSheet Sheet = workbookCopy.getSheet("Resource_Skill_Mapping");
			Label label = new Label(2, 1, L5_NAME);
			Label label1 = new Label(3, 1,L4_NAME);
			Label label2 = new Label(4, 1,L3_NAME);
			Label label3 = new Label(5, 1,L2_NAME);
			Label label4 = new Label(6, 1,L1_NAME);

			Sheet.addCell(label);
			Sheet.addCell(label1);
			Sheet.addCell(label2);
			Sheet.addCell(label3);
			Sheet.addCell(label4);


			workbookCopy.write();
			workbookCopy.close();
			existingWorkbook.close();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}                 
	}

	public static void Executive_RSMUpload(String PersonnelNo,String Skill_NAME,String SpecialityName_Primary,String SkillCapability_Primary,String SkillCategory_Primary,String SkillType_Primary,String Skill_NAME_Sec,String SpecialityName_Sec,String SkillCapability_Sec,String SkillCategory_Sec,String SkillType_Sec) 
	{
		String Path = System.getProperty("user.dir")+"\\TestData\\Executive_Assessment\\Resource_Skill_Mapping.xls";
		try 
		{
			Workbook existingWorkbook = Workbook.getWorkbook(new File(Path));
			WritableWorkbook workbookCopy = Workbook.createWorkbook(new File(Path), existingWorkbook);
			WritableSheet Sheet = workbookCopy.getSheet("Resource_Skill_Mapping");

			Label label = new Label(0, 1, PersonnelNo);
			Label label1 = new Label(1, 1, "P");
			Label label2 = new Label(2, 1, Skill_NAME);
			Label label3 = new Label(3, 1, SpecialityName_Primary);
			Label label4 = new Label(4, 1, SkillCapability_Primary);
			Label label5 = new Label(5, 1, SkillCategory_Primary);
			Label label6 = new Label(6, 1, SkillType_Primary);

			Label label7 = new Label(0, 2, PersonnelNo);
			Label label8 = new Label(1, 2, "E");
			Label label9 = new Label(2, 2, Skill_NAME_Sec);
			Label label10 = new Label(3, 2, SpecialityName_Sec);
			Label label11 = new Label(4, 2, SkillCapability_Sec);
			Label label12 = new Label(5, 2, SkillCategory_Sec);
			Label label13 = new Label(6, 2, SkillType_Sec);

			Sheet.addCell(label);
			Sheet.addCell(label1);
			Sheet.addCell(label2);
			Sheet.addCell(label3);
			Sheet.addCell(label4);
			Sheet.addCell(label5);
			Sheet.addCell(label6);
			Sheet.addCell(label7);
			Sheet.addCell(label8);
			Sheet.addCell(label9);
			Sheet.addCell(label10);
			Sheet.addCell(label11);
			Sheet.addCell(label12);
			Sheet.addCell(label13);

			workbookCopy.write();
			workbookCopy.close();
			existingWorkbook.close();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}                 
	}

	public static void BA_RSMUpload(String PersonnelNo,String Skill_NAME,String SpecialityName_Primary,String SkillCapability_Primary,String SkillCategory_Primary,String SkillType_Primary,String Skill_NAME_Sec,String SpecialityName_Sec,String SkillCapability_Sec,String SkillCategory_Sec,String SkillType_Sec,String TemplateName) 
	{
		String Path = System.getProperty("user.dir")+"\\TestData\\BAModule_TestData\\"+TemplateName+".xls";
		try 
		{
			Workbook existingWorkbook = Workbook.getWorkbook(new File(Path));
			WritableWorkbook workbookCopy = Workbook.createWorkbook(new File(Path), existingWorkbook);
			WritableSheet Sheet = workbookCopy.getSheet("Resource_Skill_Mapping");

			Label label = new Label(0, 1, PersonnelNo);
			Label label1 = new Label(1, 1, "P");
			Label label2 = new Label(2, 1, Skill_NAME);
			Label label3 = new Label(3, 1, SpecialityName_Primary);
			Label label4 = new Label(4, 1, SkillCapability_Primary);
			Label label5 = new Label(5, 1, SkillCategory_Primary);
			Label label6 = new Label(6, 1, SkillType_Primary);

			Label label7 = new Label(0, 2, PersonnelNo);
			Label label8 = new Label(1, 2, "E");
			Label label9 = new Label(2, 2, Skill_NAME_Sec);
			Label label10 = new Label(3, 2, SpecialityName_Sec);
			Label label11 = new Label(4, 2, SkillCapability_Sec);
			Label label12 = new Label(5, 2, SkillCategory_Sec);
			Label label13 = new Label(6, 2, SkillType_Sec);

			Sheet.addCell(label);
			Sheet.addCell(label1);
			Sheet.addCell(label2);
			Sheet.addCell(label3);
			Sheet.addCell(label4);
			Sheet.addCell(label5);
			Sheet.addCell(label6);
			Sheet.addCell(label7);
			Sheet.addCell(label8);
			Sheet.addCell(label9);
			Sheet.addCell(label10);
			Sheet.addCell(label11);
			Sheet.addCell(label12);
			Sheet.addCell(label13);

			workbookCopy.write();
			workbookCopy.close();
			existingWorkbook.close();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}                 
	}

	public static void Executive_Objective_Scores_Upload(String People_Key_Exec ,String Enterprise_ID_Exec ,String SkillID_Exec ,String Proficiency) 
	{
		String Path = System.getProperty("user.dir")+"\\TestData\\Executive_Assessment\\Executive_Assessment_Score_Upload.xls";
		try 
		{
			Workbook existingWorkbook = Workbook.getWorkbook(new File(Path));
			WritableWorkbook workbookCopy = Workbook.createWorkbook(new File(Path), existingWorkbook);
			WritableSheet Sheet = workbookCopy.getSheet("Sheet_1");

			Label label = new Label(0, 1, People_Key_Exec);
			Label label1 = new Label(1, 1, Enterprise_ID_Exec);
			Label label2 = new Label(2, 1, SkillID_Exec);
			Label label3 = new Label(3, 1, "Completed");
			Label label4 = new Label(4, 1, "04/08/2020");
			Label label5 = new Label(5, 1, Proficiency);

			if (Proficiency.equals("P3+"))
			{
				System.out.println("Going To Make Expert Eligible");
				Label label6 = new Label(6, 1, "No");
				Sheet.addCell(label6);
			}
			else
			{
				System.out.println("Not Eligible For Expert Assessment");
				Label label6 = new Label(6, 1, "N/A");
				Sheet.addCell(label6);
			}

			Label label7 = new Label(7, 1, "N/A");
			Label label8 = new Label(8, 1, "N/A");
			Label label9 = new Label(9, 1, "N/A");
			Label label10 = new Label(10, 1, "10");
			Label label11 = new Label(11, 1, "10");
			Label label12 = new Label(12, 1, "10");
			Label label13 = new Label(13, 1, "10");
			Label label14 = new Label(14, 1, "20");
			Label label15 = new Label(15, 1, "N/A");
			Label label16 = new Label(16, 1, "N/A");
			Label label17 = new Label(17, 1, "N/A");
			Label label18 = new Label(18, 1, "N/A");
			Label label19 = new Label(19, 1, "N/A");
			Label label20 = new Label(20, 1, "A");

			Sheet.addCell(label);
			Sheet.addCell(label1);
			Sheet.addCell(label2);
			Sheet.addCell(label3);
			Sheet.addCell(label4);
			Sheet.addCell(label5);
			Sheet.addCell(label7);
			Sheet.addCell(label8);
			Sheet.addCell(label9);
			Sheet.addCell(label10);
			Sheet.addCell(label11);
			Sheet.addCell(label12);
			Sheet.addCell(label13);
			Sheet.addCell(label14);
			Sheet.addCell(label15);
			Sheet.addCell(label16);
			Sheet.addCell(label17);
			Sheet.addCell(label18);
			Sheet.addCell(label19);
			Sheet.addCell(label20);

			workbookCopy.write();
			workbookCopy.close();
			existingWorkbook.close();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}                 
	}

	public static void Executive_Objective_Scores_Upload_NoShow(String People_Key_Exec ,String Enterprise_ID_Exec ,String SkillID_Exec) 
	{
		String Path = System.getProperty("user.dir")+"\\TestData\\Executive_Assessment\\Executive_Assessment_Score_Upload.xls";
		try 
		{
			Workbook existingWorkbook = Workbook.getWorkbook(new File(Path));
			WritableWorkbook workbookCopy = Workbook.createWorkbook(new File(Path), existingWorkbook);
			WritableSheet Sheet = workbookCopy.getSheet("Sheet_1");

			Label label = new Label(0, 1, People_Key_Exec);
			Label label1 = new Label(1, 1, Enterprise_ID_Exec);
			Label label2 = new Label(2, 1, SkillID_Exec);
			Label label3 = new Label(3, 1, "No Show");
			Label label4 = new Label(4, 1, "N/A");
			Label label5 = new Label(5, 1, "N/A");
			Label label6 = new Label(6, 1, "N/A");
			Label label7 = new Label(7, 1, "N/A");
			Label label8 = new Label(8, 1, "N/A");
			Label label9 = new Label(9, 1, "N/A");
			Label label10 = new Label(10, 1, "N/A");
			Label label11 = new Label(11, 1, "N/A");
			Label label12 = new Label(12, 1, "N/A");
			Label label13 = new Label(13, 1, "N/A");
			Label label14 = new Label(14, 1, "N/A");
			Label label15 = new Label(15, 1, "N/A");
			Label label16 = new Label(16, 1, "N/A");
			Label label17 = new Label(17, 1, "N/A");
			Label label18 = new Label(18, 1, "N/A");
			Label label19 = new Label(19, 1, "N/A");
			Label label20 = new Label(20, 1, "A");

			Sheet.addCell(label);
			Sheet.addCell(label1);
			Sheet.addCell(label2);
			Sheet.addCell(label3);
			Sheet.addCell(label4);
			Sheet.addCell(label5);
			Sheet.addCell(label6);
			Sheet.addCell(label7);
			Sheet.addCell(label8);
			Sheet.addCell(label9);
			Sheet.addCell(label10);
			Sheet.addCell(label11);
			Sheet.addCell(label12);
			Sheet.addCell(label13);
			Sheet.addCell(label14);
			Sheet.addCell(label15);
			Sheet.addCell(label16);
			Sheet.addCell(label17);
			Sheet.addCell(label18);
			Sheet.addCell(label19);
			Sheet.addCell(label20);

			workbookCopy.write();
			workbookCopy.close();
			existingWorkbook.close();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}                 
	}

	public static void Executive_Objective_Scores_Upload_Cancelled(String People_Key_Exec ,String Enterprise_ID_Exec ,String SkillID_Exec) 
	{
		String Path = System.getProperty("user.dir")+"\\TestData\\Executive_Assessment\\Executive_Assessment_Score_Upload.xls";
		try 
		{
			Workbook existingWorkbook = Workbook.getWorkbook(new File(Path));
			WritableWorkbook workbookCopy = Workbook.createWorkbook(new File(Path), existingWorkbook);
			WritableSheet Sheet = workbookCopy.getSheet("Sheet_1");

			Label label = new Label(0, 1, People_Key_Exec);
			Label label1 = new Label(1, 1, Enterprise_ID_Exec);
			Label label2 = new Label(2, 1, SkillID_Exec);
			Label label3 = new Label(3, 1, "Cancelled");
			Label label4 = new Label(4, 1, "N/A");
			Label label5 = new Label(5, 1, "N/A");
			Label label6 = new Label(6, 1, "N/A");
			Label label7 = new Label(7, 1, "N/A");
			Label label8 = new Label(8, 1, "N/A");
			Label label9 = new Label(9, 1, "N/A");
			Label label10 = new Label(10, 1, "N/A");
			Label label11 = new Label(11, 1, "N/A");
			Label label12 = new Label(12, 1, "N/A");
			Label label13 = new Label(13, 1, "N/A");
			Label label14 = new Label(14, 1, "N/A");
			Label label15 = new Label(15, 1, "N/A");
			Label label16 = new Label(16, 1, "N/A");
			Label label17 = new Label(17, 1, "N/A");
			Label label18 = new Label(18, 1, "N/A");
			Label label19 = new Label(19, 1, "N/A");
			Label label20 = new Label(20, 1, "A");

			Sheet.addCell(label);
			Sheet.addCell(label1);
			Sheet.addCell(label2);
			Sheet.addCell(label3);
			Sheet.addCell(label4);
			Sheet.addCell(label5);
			Sheet.addCell(label6);
			Sheet.addCell(label7);
			Sheet.addCell(label8);
			Sheet.addCell(label9);
			Sheet.addCell(label10);
			Sheet.addCell(label11);
			Sheet.addCell(label12);
			Sheet.addCell(label13);
			Sheet.addCell(label14);
			Sheet.addCell(label15);
			Sheet.addCell(label16);
			Sheet.addCell(label17);
			Sheet.addCell(label18);
			Sheet.addCell(label19);
			Sheet.addCell(label20);

			workbookCopy.write();
			workbookCopy.close();
			existingWorkbook.close();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}                 
	}


	public static void Executive_Expert_Continued_Scores_Upload(String People_Key_Exec ,String Enterprise_ID_Exec ,String SkillID_Exec ,String Expert_Assessment_Type) 
	{
		String Path = System.getProperty("user.dir")+"\\TestData\\Executive_Assessment\\Executive_Assessment_Score_Upload.xls";
		try 
		{
			Workbook existingWorkbook = Workbook.getWorkbook(new File(Path));
			WritableWorkbook workbookCopy = Workbook.createWorkbook(new File(Path), existingWorkbook);
			WritableSheet Sheet = workbookCopy.getSheet("Sheet_1");

			Label label = new Label(0, 1, People_Key_Exec);
			Label label1 = new Label(1, 1, Enterprise_ID_Exec);
			Label label2 = new Label(2, 1, SkillID_Exec);
			Label label3 = new Label(3, 1, "Completed");
			Label label4 = new Label(4, 1, "04/08/2020");
			Label label5 = new Label(5, 1, "P3+");
			Label label6 = new Label(6, 1, "Yes");
			Label label7 = new Label(7, 1, "Completed");
			Label label9 = new Label(9, 1, "04/08/2020");
			Label label10 = new Label(10, 1, "10");
			Label label11 = new Label(11, 1, "10");
			Label label12 = new Label(12, 1, "10");
			Label label13 = new Label(13, 1, "10");
			Label label14 = new Label(14, 1, "20");
			Label label20 = new Label(20, 1, "A");

			if (Expert_Assessment_Type.equals("Obj_CaseStudy"))
			{
				System.out.println("Going to Execute If Statement");
				Label label8 = new Label(8, 1, Expert_Assessment_Type);
				Label label15 = new Label(15, 1, "10");
				Label label16 = new Label(16, 1, "10");
				Label label17 = new Label(17, 1, "10");
				Label label18 = new Label(18, 1, "10");
				Label label19 = new Label(19, 1, "20");
				Sheet.addCell(label8);
				Sheet.addCell(label15);
				Sheet.addCell(label16);
				Sheet.addCell(label17);
				Sheet.addCell(label18);
				Sheet.addCell(label19);
				Sheet.addCell(label20);

			}

			else
			{
				System.out.println("Going to Execute Else Statement");
				Label label8 = new Label(8, 1, Expert_Assessment_Type);
				Label label15 = new Label(15, 1, "N/A");
				Label label16 = new Label(16, 1, "N/A");
				Label label17 = new Label(17, 1, "N/A");
				Label label18 = new Label(18, 1, "N/A");
				Label label19 = new Label(19, 1, "N/A");
				Sheet.addCell(label8);
				Sheet.addCell(label15);
				Sheet.addCell(label16);
				Sheet.addCell(label17);
				Sheet.addCell(label18);
				Sheet.addCell(label19);
				Sheet.addCell(label20);
			}
			System.out.println("Inserting Records in Table");

			Sheet.addCell(label);
			Sheet.addCell(label1);
			Sheet.addCell(label2);
			Sheet.addCell(label3);
			Sheet.addCell(label4);
			Sheet.addCell(label5);
			Sheet.addCell(label6);
			Sheet.addCell(label7);
			Sheet.addCell(label9);
			Sheet.addCell(label10);
			Sheet.addCell(label11);
			Sheet.addCell(label12);
			Sheet.addCell(label13);
			Sheet.addCell(label14);


			workbookCopy.write();
			workbookCopy.close();
			existingWorkbook.close();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}                 
	}	

	public static void Executive_Expert_Not_Continued_Scores_Upload(String People_Key_Exec ,String Enterprise_ID_Exec ,String SkillID_Exec ,String Expert_Assessment_Type) 
	{
		String Path = System.getProperty("user.dir")+"\\TestData\\Executive_Assessment\\Executive_Assessment_Score_Upload.xls";
		try 
		{
			Workbook existingWorkbook = Workbook.getWorkbook(new File(Path));
			WritableWorkbook workbookCopy = Workbook.createWorkbook(new File(Path), existingWorkbook);
			WritableSheet Sheet = workbookCopy.getSheet("Sheet_1");

			Label label = new Label(0, 1, People_Key_Exec);
			Label label1 = new Label(1, 1, Enterprise_ID_Exec);
			Label label2 = new Label(2, 1, SkillID_Exec);
			Label label3 = new Label(3, 1, "N/A");
			Label label4 = new Label(4, 1, "N/A");
			Label label5 = new Label(5, 1, "N/A");
			Label label6 = new Label(6, 1, "N/A");
			Label label7 = new Label(7, 1, "Completed");
			Label label9 = new Label(9, 1, "04/08/2020");
			Label label10 = new Label(10, 1, "N/A");
			Label label11 = new Label(11, 1, "N/A");
			Label label12 = new Label(12, 1, "N/A");
			Label label13 = new Label(13, 1, "N/A");
			Label label14 = new Label(14, 1, "N/A");
			Label label20 = new Label(20, 1, "A");

			if (Expert_Assessment_Type.equals("Obj_CaseStudy"))
			{
				System.out.println("Going to Execute If Statement");
				Label label8 = new Label(8, 1, Expert_Assessment_Type);
				Label label15 = new Label(15, 1, "10");
				Label label16 = new Label(16, 1, "10");
				Label label17 = new Label(17, 1, "10");
				Label label18 = new Label(18, 1, "10");
				Label label19 = new Label(19, 1, "20");
				Sheet.addCell(label8);
				Sheet.addCell(label15);
				Sheet.addCell(label16);
				Sheet.addCell(label17);
				Sheet.addCell(label18);
				Sheet.addCell(label19);
				Sheet.addCell(label20);

			}

			else if (Expert_Assessment_Type.equals("Sub_CaseStudy"))
			{
				System.out.println("Going to Execute Else Statement");
				Label label8 = new Label(8, 1, Expert_Assessment_Type);
				Label label15 = new Label(15, 1, "N/A");
				Label label16 = new Label(16, 1, "N/A");
				Label label17 = new Label(17, 1, "N/A");
				Label label18 = new Label(18, 1, "N/A");
				Label label19 = new Label(19, 1, "N/A");
				Sheet.addCell(label8);
				Sheet.addCell(label15);
				Sheet.addCell(label16);
				Sheet.addCell(label17);
				Sheet.addCell(label18);
				Sheet.addCell(label19);
				Sheet.addCell(label20);
			}
			System.out.println("Inserting Records in Table");

			Sheet.addCell(label);
			Sheet.addCell(label1);
			Sheet.addCell(label2);
			Sheet.addCell(label3);
			Sheet.addCell(label4);
			Sheet.addCell(label5);
			Sheet.addCell(label6);
			Sheet.addCell(label7);
			Sheet.addCell(label9);
			Sheet.addCell(label10);
			Sheet.addCell(label11);
			Sheet.addCell(label12);
			Sheet.addCell(label13);
			Sheet.addCell(label14);


			workbookCopy.write();
			workbookCopy.close();
			existingWorkbook.close();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}                 
	}	

	public static void Executive_Expert_Not_Continued_No_Show_Upload(String People_Key_Exec ,String Enterprise_ID_Exec ,String SkillID_Exec ,String Expert_Assessment_Type) 
	{
		String Path = System.getProperty("user.dir")+"\\TestData\\Executive_Assessment\\Executive_Assessment_Score_Upload.xls";
		try 
		{
			Workbook existingWorkbook = Workbook.getWorkbook(new File(Path));
			WritableWorkbook workbookCopy = Workbook.createWorkbook(new File(Path), existingWorkbook);
			WritableSheet Sheet = workbookCopy.getSheet("Sheet_1");

			Label label = new Label(0, 1, People_Key_Exec);
			Label label1 = new Label(1, 1, Enterprise_ID_Exec);
			Label label2 = new Label(2, 1, SkillID_Exec);
			Label label3 = new Label(3, 1, "N/A");
			Label label4 = new Label(4, 1, "N/A");
			Label label5 = new Label(5, 1, "N/A");
			Label label6 = new Label(6, 1, "N/A");
			Label label7 = new Label(7, 1, "No Show");
			Label label9 = new Label(9, 1, "04/08/2020");
			Label label10 = new Label(10, 1, "N/A");
			Label label11 = new Label(11, 1, "N/A");
			Label label12 = new Label(12, 1, "N/A");
			Label label13 = new Label(13, 1, "N/A");
			Label label14 = new Label(14, 1, "N/A");
			Label label20 = new Label(20, 1, "A");

			if (Expert_Assessment_Type.equals("Obj_CaseStudy"))
			{
				System.out.println("Going to Execute If Statement of objective casestudy");
				Label label8 = new Label(8, 1, Expert_Assessment_Type);
				Label label15 = new Label(15, 1, "N/A");
				Label label16 = new Label(16, 1, "N/A");
				Label label17 = new Label(17, 1, "N/A");
				Label label18 = new Label(18, 1, "N/A");
				Label label19 = new Label(19, 1, "N/A");
				Sheet.addCell(label8);
				Sheet.addCell(label15);
				Sheet.addCell(label16);
				Sheet.addCell(label17);
				Sheet.addCell(label18);
				Sheet.addCell(label19);
				Sheet.addCell(label20);

			}

			else if (Expert_Assessment_Type.equals("Sub_CaseStudy"))
			{
				System.out.println("Going to Execute Else Statement");
				Label label8 = new Label(8, 1, Expert_Assessment_Type);
				Label label15 = new Label(15, 1, "N/A");
				Label label16 = new Label(16, 1, "N/A");
				Label label17 = new Label(17, 1, "N/A");
				Label label18 = new Label(18, 1, "N/A");
				Label label19 = new Label(19, 1, "N/A");
				Sheet.addCell(label8);
				Sheet.addCell(label15);
				Sheet.addCell(label16);
				Sheet.addCell(label17);
				Sheet.addCell(label18);
				Sheet.addCell(label19);
				Sheet.addCell(label20);
			}
			System.out.println("Inserting Records in Table");

			Sheet.addCell(label);
			Sheet.addCell(label1);
			Sheet.addCell(label2);
			Sheet.addCell(label3);
			Sheet.addCell(label4);
			Sheet.addCell(label5);
			Sheet.addCell(label6);
			Sheet.addCell(label7);
			Sheet.addCell(label9);
			Sheet.addCell(label10);
			Sheet.addCell(label11);
			Sheet.addCell(label12);
			Sheet.addCell(label13);
			Sheet.addCell(label14);


			workbookCopy.write();
			workbookCopy.close();
			existingWorkbook.close();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}                 
	}

	public static void Executive_Expert_Not_Continued_Cancelled_Upload(String People_Key_Exec ,String Enterprise_ID_Exec ,String SkillID_Exec ,String Expert_Assessment_Type) 
	{
		String Path = System.getProperty("user.dir")+"\\TestData\\Executive_Assessment\\Executive_Assessment_Score_Upload.xls";
		try 
		{
			Workbook existingWorkbook = Workbook.getWorkbook(new File(Path));
			WritableWorkbook workbookCopy = Workbook.createWorkbook(new File(Path), existingWorkbook);
			WritableSheet Sheet = workbookCopy.getSheet("Sheet_1");

			Label label = new Label(0, 1, People_Key_Exec);
			Label label1 = new Label(1, 1, Enterprise_ID_Exec);
			Label label2 = new Label(2, 1, SkillID_Exec);
			Label label3 = new Label(3, 1, "N/A");
			Label label4 = new Label(4, 1, "N/A");
			Label label5 = new Label(5, 1, "N/A");
			Label label6 = new Label(6, 1, "N/A");
			Label label7 = new Label(7, 1, "Cancelled");
			Label label9 = new Label(9, 1, "04/08/2020");
			Label label10 = new Label(10, 1, "N/A");
			Label label11 = new Label(11, 1, "N/A");
			Label label12 = new Label(12, 1, "N/A");
			Label label13 = new Label(13, 1, "N/A");
			Label label14 = new Label(14, 1, "N/A");
			Label label20 = new Label(20, 1, "A");

			if (Expert_Assessment_Type.equals("Obj_CaseStudy"))
			{
				System.out.println("Going to Execute If Statement of objective casestudy");
				Label label8 = new Label(8, 1, Expert_Assessment_Type);
				Label label15 = new Label(15, 1, "N/A");
				Label label16 = new Label(16, 1, "N/A");
				Label label17 = new Label(17, 1, "N/A");
				Label label18 = new Label(18, 1, "N/A");
				Label label19 = new Label(19, 1, "N/A");
				Sheet.addCell(label8);
				Sheet.addCell(label15);
				Sheet.addCell(label16);
				Sheet.addCell(label17);
				Sheet.addCell(label18);
				Sheet.addCell(label19);
				Sheet.addCell(label20);

			}

			else if (Expert_Assessment_Type.equals("Sub_CaseStudy"))
			{
				System.out.println("Going to Execute Else Statement");
				Label label8 = new Label(8, 1, Expert_Assessment_Type);
				Label label15 = new Label(15, 1, "N/A");
				Label label16 = new Label(16, 1, "N/A");
				Label label17 = new Label(17, 1, "N/A");
				Label label18 = new Label(18, 1, "N/A");
				Label label19 = new Label(19, 1, "N/A");
				Sheet.addCell(label8);
				Sheet.addCell(label15);
				Sheet.addCell(label16);
				Sheet.addCell(label17);
				Sheet.addCell(label18);
				Sheet.addCell(label19);
				Sheet.addCell(label20);
			}
			System.out.println("Inserting Records in Table");

			Sheet.addCell(label);
			Sheet.addCell(label1);
			Sheet.addCell(label2);
			Sheet.addCell(label3);
			Sheet.addCell(label4);
			Sheet.addCell(label5);
			Sheet.addCell(label6);
			Sheet.addCell(label7);
			Sheet.addCell(label9);
			Sheet.addCell(label10);
			Sheet.addCell(label11);
			Sheet.addCell(label12);
			Sheet.addCell(label13);
			Sheet.addCell(label14);


			workbookCopy.write();
			workbookCopy.close();
			existingWorkbook.close();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}                 
	}

	public static void EmployeeContributionAtrributesUpload(String Employee_EID, String SkillID)

	{    String Path = System.getProperty("user.dir")+"\\TestData\\Expert_Assessment\\Employee_Contribution_Attributes_Upload.xls";

	try
	{
		Workbook existingWorkbook = Workbook.getWorkbook(new File(Path));
		WritableWorkbook workbookCopy = Workbook.createWorkbook(new File(Path), existingWorkbook);
		WritableSheet Sheet = workbookCopy.getSheet("Sheet1");


		Label label = new Label(0, 1, Employee_EID);
		Label label1 = new Label(1, 1, SkillID);
		Label label2 = new Label(2, 1, "Skill Based");
		Label label3 = new Label(3, 1, "29");
		Label label4 = new Label(4, 1, "9");
		Label label5 = new Label(5, 1, "4");
		Label label6 = new Label(6, 1, "A");

		Sheet.addCell(label);
		Sheet.addCell(label1);
		Sheet.addCell(label2);
		Sheet.addCell(label3);
		Sheet.addCell(label4);
		Sheet.addCell(label5);
		Sheet.addCell(label6);

		workbookCopy.write();
		workbookCopy.close();
		existingWorkbook.close();
	}

	catch (Exception e)



	{
		e.printStackTrace();



	}        


	}

	public static void ExpertAssessment_AlternateCertification_DeliverySkillsUpload(String Enterprise_Id, String Skill_Id, String Certification_Name01,String Certification_Name02, 
			String Certification_CompletionDate,String Validity, String Add_Remove)
	{
		String Path = System.getProperty("user.dir")+"\\TestData\\Expert_Assessment\\AlternateMethod_DeliverySkills_Upload.xls";

		try
		{
			Workbook existingWorkbook = Workbook.getWorkbook(new File(Path));
			WritableWorkbook workbookCopy = Workbook.createWorkbook(new File(Path), existingWorkbook);
			WritableSheet Sheet = workbookCopy.getSheet("Sheet1");

			Label label = new Label(0, 1, Enterprise_Id);
			Label label1 = new Label(1, 1, Skill_Id);
			Label label2 = new Label(2, 1, Certification_Name01);
			Label label3 = new Label(3, 1, Certification_CompletionDate);
			Label label4 = new Label(4, 1, Validity);
			Label label5 = new Label(5, 1, Add_Remove);
			System.out.println("Row 1 Details are entered");
			Label label7 = new Label(0, 2,Enterprise_Id );
			Label label8 = new Label(1, 2, Skill_Id);
			Label label9 = new Label(2, 2, Certification_Name02);
			Label label10 = new Label(3, 2, Certification_CompletionDate);
			Label label11 = new Label(4, 2, Validity);
			Label label12 = new Label(5, 2, Add_Remove);

			System.out.println("Row 2 Details are entered");

			Sheet.addCell(label);
			Sheet.addCell(label1);
			Sheet.addCell(label2);
			Sheet.addCell(label3);
			Sheet.addCell(label4);
			Sheet.addCell(label5);
			Sheet.addCell(label7);
			Sheet.addCell(label8);
			Sheet.addCell(label9);
			Sheet.addCell(label10);
			Sheet.addCell(label11);
			Sheet.addCell(label12);

			workbookCopy.write();
			workbookCopy.close();
			existingWorkbook.close();
			System.out.println("Alternate Certification_Upload-Excel sheet is updated");



		}
		catch (Exception e)
		{
			e.printStackTrace();
		}                
	}
	public static void CloudCertificationUploadExcel(String Employee_EID, String SkillID, String CloudSkillName , String CloudCertName , String CloudCertID)
	{    
		String Path = System.getProperty("user.dir")+"\\TestData\\Expert_Assessment\\CloudCertificationStatusUpload.xls";
		try
		{
			Workbook existingWorkbook = Workbook.getWorkbook(new File(Path));
			WritableWorkbook workbookCopy = Workbook.createWorkbook(new File(Path), existingWorkbook);
			WritableSheet Sheet = workbookCopy.getSheet("Sheet1");


			Label label = new Label(0, 1, Employee_EID);
			Label label1 = new Label(1, 1, SkillID);
			Label label2 = new Label(2, 1, CloudSkillName);
			Label label3 = new Label(3, 1, CloudCertID);
			Label label4 = new Label(4, 1, CloudCertName);
			Label label5 = new Label(5, 1, "01/01/2020");
			Label label6 = new Label(6, 1, "A");

			Sheet.addCell(label);
			Sheet.addCell(label1);
			Sheet.addCell(label2);
			Sheet.addCell(label3);
			Sheet.addCell(label4);
			Sheet.addCell(label5);
			Sheet.addCell(label6);

			workbookCopy.write();
			workbookCopy.close();
			existingWorkbook.close();

			System.out.println("Excel Template With Cloud Details Are Filled");
		}   
		catch (Exception e)

		{
			e.printStackTrace();
		}        
	}

	public static void CloudCertificationDualUploadExcel(String Employee_EID, String SkillIDA, String CloudSkillNameA , String CloudCertNameA , String CloudCertIDA,
			String SkillIDB, String CloudSkillNameB , String CloudCertNameB , String CloudCertIDB)
	{    
		String Path = System.getProperty("user.dir")+"\\TestData\\Expert_Assessment\\CloudCertificationStatusUpload.xls";
		try
		{
			Workbook existingWorkbook = Workbook.getWorkbook(new File(Path));
			WritableWorkbook workbookCopy = Workbook.createWorkbook(new File(Path), existingWorkbook);
			WritableSheet Sheet = workbookCopy.getSheet("Sheet1");


			Label label = new Label(0, 1, Employee_EID);
			Label label1 = new Label(1, 1, SkillIDA);
			Label label2 = new Label(2, 1, CloudSkillNameA);
			Label label3 = new Label(3, 1, CloudCertIDA);
			Label label4 = new Label(4, 1, CloudCertNameA);
			Label label5 = new Label(5, 1, "01/01/2020");
			Label label6 = new Label(6, 1, "A");

			Label label7 = new Label(0, 2, Employee_EID);
			Label label8 = new Label(1, 2, SkillIDB);
			Label label9 = new Label(2, 2, CloudSkillNameB);
			Label label10 = new Label(3, 2, CloudCertIDB);
			Label label11 = new Label(4, 2, CloudCertNameB);
			Label label12 = new Label(5, 2, "01/01/2020");
			Label label13 = new Label(6, 2, "A");

			Sheet.addCell(label);
			Sheet.addCell(label1);
			Sheet.addCell(label2);
			Sheet.addCell(label3);
			Sheet.addCell(label4);
			Sheet.addCell(label5);
			Sheet.addCell(label6);

			Sheet.addCell(label7);
			Sheet.addCell(label8);
			Sheet.addCell(label9);
			Sheet.addCell(label10);
			Sheet.addCell(label11);
			Sheet.addCell(label12);
			Sheet.addCell(label13);

			workbookCopy.write();
			workbookCopy.close();
			existingWorkbook.close();

			System.out.println("Excel Template With Cloud Details Are Filled");
		}   
		catch (Exception e)

		{
			e.printStackTrace();
		}        
	}

	public static void CloudCertificationRemovalUploadExcel(String Employee_EID, String SkillID, String CloudSkillName , String CloudCertName , String CloudCertID)
	{    
		String Path = System.getProperty("user.dir")+"\\TestData\\Expert_Assessment\\CloudCertificationStatusUpload.xls";
		try
		{
			Workbook existingWorkbook = Workbook.getWorkbook(new File(Path));
			WritableWorkbook workbookCopy = Workbook.createWorkbook(new File(Path), existingWorkbook);
			WritableSheet Sheet = workbookCopy.getSheet("Sheet1");

			Label label6 = new Label(6, 1, "R");

			Sheet.addCell(label6);

			workbookCopy.write();
			workbookCopy.close();
			existingWorkbook.close();

			System.out.println("Excel Template With Cloud Details Are Filled");
		}   
		catch (Exception e)

		{
			e.printStackTrace();
		}        
	}

	public static void ExpertAssessment_AlternateAssessmentCertification_Upload(String Enterprise_Id, String Skill_Id, String Certification_Name, 
			String Certification_CompletionDate)
	{

		String Path = System.getProperty("user.dir")+"\\TestData\\Executive_Assessment\\Alternate_Expert_Assessment_Upload.xls";

		try

		{
			Workbook existingWorkbook = Workbook.getWorkbook(new File(Path));
			WritableWorkbook workbookCopy = Workbook.createWorkbook(new File(Path), existingWorkbook);
			WritableSheet Sheet = workbookCopy.getSheet("Sheet1");

			Label label = new Label(0, 1, Enterprise_Id);
			Label label1 = new Label(1, 1, Skill_Id);
			Label label2 = new Label(2, 1, Certification_Name);
			Label label3 = new Label(3, 1, Certification_CompletionDate);
			Label label4 = new Label(4, 1, "500");
			Label label5 = new Label(5, 1, "A");

			Sheet.addCell(label);
			Sheet.addCell(label1);
			Sheet.addCell(label2);
			Sheet.addCell(label3);
			Sheet.addCell(label4);
			Sheet.addCell(label5);

			workbookCopy.write();
			workbookCopy.close();
			existingWorkbook.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}                
	} 

	public static void Mettl_Objective_Questionnaire_Template(String Schedule_ID, String Assessment_ID, String SkillID, String QTemplate) 
	{
		String Path =  System.getProperty("user.dir")+"\\TestData\\Objective_Assessment\\"+QTemplate+".xls";
		try 
		{
			Workbook existingWorkbook = Workbook.getWorkbook(new File(Path));
			WritableWorkbook workbookCopy = Workbook.createWorkbook(new File(Path), existingWorkbook);
			WritableSheet Sheet = workbookCopy.getSheet("Sheet_1");
			String AccountID = prop.getProperty("Mettl_Account_ID");

			Label label0 = new Label(0, 1, SkillID);
			Label label1 = new Label(1, 1, Schedule_ID);
			Label label2 = new Label(2, 1, Assessment_ID);
			Label label3 = new Label(3, 1, AccountID);
			Label label4 = new Label(4, 1, "Active");

			Sheet.addCell(label0);
			Sheet.addCell(label1);
			Sheet.addCell(label2);
			Sheet.addCell(label3);
			Sheet.addCell(label4);

			workbookCopy.write();
			workbookCopy.close();
			existingWorkbook.close();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}                 
	}


	public static void Mettl_Objective_Questionnaire_Template(String Schedule_ID, String Assessment_ID, String SkillID) 
	{
		String Path =  System.getProperty("user.dir")+"\\TestData\\BAModule_TestData\\QuestionnaireAvailableStatus_Upload.xls";
		try 
		{
			Workbook existingWorkbook = Workbook.getWorkbook(new File(Path));
			WritableWorkbook workbookCopy = Workbook.createWorkbook(new File(Path), existingWorkbook);
			WritableSheet Sheet = workbookCopy.getSheet("Sheet_1");
			String AccountID = prop.getProperty("Mettl_Account_ID");

			Label label0 = new Label(0, 1, SkillID);
			Label label1 = new Label(1, 1, Schedule_ID);
			Label label2 = new Label(2, 1, Assessment_ID);
			Label label3 = new Label(3, 1, AccountID);
			Label label4 = new Label(4, 1, "Active");

			Sheet.addCell(label0);
			Sheet.addCell(label1);
			Sheet.addCell(label2);
			Sheet.addCell(label3);
			Sheet.addCell(label4);

			workbookCopy.write();
			workbookCopy.close();
			existingWorkbook.close();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}                 
	}

	public static void Mettl_Objective_Exec_Questionnaire_Template(String Schedule_ID, String Assessment_ID, String SkillID) 

	{
		String Path =  System.getProperty("user.dir")+"\\TestData\\Executive_Assessment\\QuestionnaireAvailableStatus_Upload.xls";
		try 
		{
			Workbook existingWorkbook = Workbook.getWorkbook(new File(Path));
			WritableWorkbook workbookCopy = Workbook.createWorkbook(new File(Path), existingWorkbook);
			WritableSheet Sheet = workbookCopy.getSheet("Sheet_1");
			String AccountID = prop.getProperty("Mettl_Account_ID");

			Label label0 = new Label(0, 1, SkillID);
			Label label1 = new Label(1, 1, Schedule_ID);
			Label label2 = new Label(2, 1, Assessment_ID);
			Label label3 = new Label(3, 1, AccountID);
			Label label4 = new Label(4, 1, "Active");

			Sheet.addCell(label0);
			Sheet.addCell(label1);
			Sheet.addCell(label2);
			Sheet.addCell(label3);
			Sheet.addCell(label4);

			workbookCopy.write();
			workbookCopy.close();
			existingWorkbook.close();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}                 
	}

	public static void Mettl_BA_Objective_Questionnaire_Template(String Schedule_ID, String Assessment_ID, String SkillID) 
	{
		String Path =  System.getProperty("user.dir")+"\\TestData\\BAModule_TestData\\QuestionnaireAvailableStatus_Upload.xls";
		try 
		{
			Workbook existingWorkbook = Workbook.getWorkbook(new File(Path));
			WritableWorkbook workbookCopy = Workbook.createWorkbook(new File(Path), existingWorkbook);
			WritableSheet Sheet = workbookCopy.getSheet("Sheet_1");
			String AccountID = prop.getProperty("Mettl_Account_ID");

			Label label0 = new Label(0, 1, SkillID);
			Label label1 = new Label(1, 1, Schedule_ID);
			Label label2 = new Label(2, 1, Assessment_ID);
			Label label3 = new Label(3, 1, AccountID);
			Label label4 = new Label(4, 1, "Active");

			Sheet.addCell(label0);
			Sheet.addCell(label1);
			Sheet.addCell(label2);
			Sheet.addCell(label3);
			Sheet.addCell(label4);

			workbookCopy.write();
			workbookCopy.close();
			existingWorkbook.close();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}                 
	}


	public static void BA_Certification_Approver_Upload(String Approver_EID,
			String CertificationName1,String CertificationName2,String CertificationName3,String CertificationName4)

	{      String Path = System.getProperty("user.dir")+"\\TestData\\BAModule_TestData\\Certification_Approver_Upload.xls";
	try 
	{
		Workbook existingWorkbook = Workbook.getWorkbook(new File(Path));
		WritableWorkbook workbookCopy = Workbook.createWorkbook(new File(Path), existingWorkbook);
		WritableSheet Sheet = workbookCopy.getSheet("Sheet1");



		Label label  = new Label(0, 1,CertificationName1);
		Label label1 = new Label(1, 1,Approver_EID);
		Label label2 = new Label(2, 1,"A");

		Label label3 = new Label(0, 2,CertificationName2);
		Label label4 = new Label(1, 2,Approver_EID);
		Label label5 = new Label(2, 2,"A");


		Label label6 = new Label(0, 3,CertificationName3);
		Label label7 = new Label(1, 3,Approver_EID);
		Label label8 = new Label(2, 3,"A");

		Label label9  = new Label(0, 4,CertificationName4);
		Label label10 = new Label(1, 4,Approver_EID);
		Label label11 = new Label(2, 4,"A");
		Sheet.addCell(label);
		Sheet.addCell(label1);
		Sheet.addCell(label2);
		Sheet.addCell(label3);
		Sheet.addCell(label4);
		Sheet.addCell(label5);
		Sheet.addCell(label6);
		Sheet.addCell(label7);
		Sheet.addCell(label8);
		Sheet.addCell(label9);
		Sheet.addCell(label10);
		Sheet.addCell(label11);



		workbookCopy.write();
		workbookCopy.close();
		existingWorkbook.close();


	}      catch (Exception e)
	{
		e.printStackTrace();
	}  

	}





	public static void Executive_MettlQuestionnaireUpload(String PrimarySkillID,String SecondarySkillID) 
	{
		String Path = System.getProperty("user.dir")+"\\TestData\\Executive_Assessment\\QuestionnaireAvailableStatus_Upload.xls";
		try 
		{
			Workbook existingWorkbook = Workbook.getWorkbook(new File(Path));
			WritableWorkbook workbookCopy = Workbook.createWorkbook(new File(Path), existingWorkbook);
			WritableSheet Sheet = workbookCopy.getSheet("Resource_Skill_Mapping");



			Label label = new Label(0, 1, PrimarySkillID);
			Label label1 = new Label(3, 1, "99");
			Label label2 = new Label(3, 1, "A");

			Label label3 = new Label(0, 2, SecondarySkillID);
			Label label4 = new Label(3, 2, "99");
			Label label5 = new Label(3, 2, "A");

			Sheet.addCell(label);
			Sheet.addCell(label1);
			Sheet.addCell(label2);
			Sheet.addCell(label3);
			Sheet.addCell(label4);
			Sheet.addCell(label5);

			workbookCopy.write();
			workbookCopy.close();
			existingWorkbook.close();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}                 
	}

	public static void Executive_AllowToTakeAssessment_Upload
	(String Skill_NAME_Primary,String SpecialityName_Primary,String SkillCapability_Primary,String SkillCategory_Primary,String SkillType_Primary,
			String Skill_NAME_Sec,String SpecialityName_Sec,String SkillCapability_Sec,String SkillCategory_Sec,String SkillType_Sec) 
	{
		String Path = System.getProperty("user.dir")+"\\TestData\\Objective_Assessment\\SkillList_AllowtoTakeAssessment_Upload.xls";
		try 
		{
			Workbook existingWorkbook = Workbook.getWorkbook(new File(Path));
			WritableWorkbook workbookCopy = Workbook.createWorkbook(new File(Path), existingWorkbook);
			WritableSheet Sheet = workbookCopy.getSheet("Assessment Status Details");



			Label label =  new Label(0, 1, SkillType_Primary);
			Label label1 = new Label(1, 1, SkillCategory_Primary);
			Label label2 = new Label(2, 1, SkillCapability_Primary);
			Label label3 = new Label(3, 1, SpecialityName_Primary);
			Label label4 = new Label(4, 1, Skill_NAME_Primary);			
			Label label5 = new Label(5, 1, "All");
			Label label6 = new Label(6, 1, "Yes");


			Label label9 =  new Label(0, 2, SkillType_Sec);
			Label label10 = new Label(1, 2, SkillCategory_Sec);
			Label label11 = new Label(2, 2, SkillCapability_Sec);
			Label label12 = new Label(3, 2, SpecialityName_Sec);
			Label label13 = new Label(4, 2, Skill_NAME_Sec);
			Label label14 = new Label(5, 2, "All");
			Label label15 = new Label(6, 2, "Yes");

			Sheet.addCell(label);
			Sheet.addCell(label1);
			Sheet.addCell(label2);
			Sheet.addCell(label3);
			Sheet.addCell(label4);
			Sheet.addCell(label5);
			Sheet.addCell(label6);
			Sheet.addCell(label9);
			Sheet.addCell(label10);
			Sheet.addCell(label11);
			Sheet.addCell(label12);
			Sheet.addCell(label13);
			Sheet.addCell(label14);
			Sheet.addCell(label15);

			workbookCopy.write();
			workbookCopy.close();
			existingWorkbook.close();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}                 
	}

	public static void BA_AllowToTakeAssessment_Upload
	(String Skill_NAME_Primary,String SpecialityName_Primary,String SkillCapability_Primary,String SkillCategory_Primary,String SkillType_Primary,
			String Skill_NAME_Sec,String SpecialityName_Sec,String SkillCapability_Sec,String SkillCategory_Sec,String SkillType_Sec) 
	{
		String Path = System.getProperty("user.dir")+"\\TestData\\BAModule_TestData\\SkillList_AllowtoTakeAssessment_Upload.xls";
		try 
		{
			Workbook existingWorkbook = Workbook.getWorkbook(new File(Path));
			WritableWorkbook workbookCopy = Workbook.createWorkbook(new File(Path), existingWorkbook);
			WritableSheet Sheet = workbookCopy.getSheet("Assessment Status Details");



			Label label =  new Label(0, 1, SkillType_Primary);
			Label label1 = new Label(1, 1, SkillCategory_Primary);
			Label label2 = new Label(2, 1, SkillCapability_Primary);
			Label label3 = new Label(3, 1, SpecialityName_Primary);
			Label label4 = new Label(4, 1, Skill_NAME_Primary);			
			Label label5 = new Label(5, 1, "All");
			Label label6 = new Label(6, 1, "Yes");


			Label label9 =  new Label(0, 2, SkillType_Sec);
			Label label10 = new Label(1, 2, SkillCategory_Sec);
			Label label11 = new Label(2, 2, SkillCapability_Sec);
			Label label12 = new Label(3, 2, SpecialityName_Sec);
			Label label13 = new Label(4, 2, Skill_NAME_Sec);
			Label label14 = new Label(5, 2, "All");
			Label label15 = new Label(6, 2, "Yes");

			Sheet.addCell(label);
			Sheet.addCell(label1);
			Sheet.addCell(label2);
			Sheet.addCell(label3);
			Sheet.addCell(label4);
			Sheet.addCell(label5);
			Sheet.addCell(label6);
			Sheet.addCell(label9);
			Sheet.addCell(label10);
			Sheet.addCell(label11);
			Sheet.addCell(label12);
			Sheet.addCell(label13);
			Sheet.addCell(label14);
			Sheet.addCell(label15);

			workbookCopy.write();
			workbookCopy.close();
			existingWorkbook.close();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}                 
	}

	public static void BA_Mandate_Completion_Status_Upload(String Employee_EID,String Skill_Id_Primary)
	{	
		String Path = System.getProperty("user.dir")+"\\TestData\\BAModule_TestData\\BA_Mandate_Completion_Status_Upload.xls";
		try
		{	
			Workbook existingWorkbook = Workbook.getWorkbook(new File(Path));
			WritableWorkbook workbookCopy = Workbook.createWorkbook(new File(Path), existingWorkbook);
			WritableSheet Sheet = workbookCopy.getSheet("Sheet1");
			Label label = new Label(0, 1,Employee_EID );
			Label label1 = new Label(1, 1,Skill_Id_Primary);
			Label label2 = new Label(2, 1,"Yes");
			Sheet.addCell(label);
			Sheet.addCell(label1);
			Sheet.addCell(label2);
			workbookCopy.write();
			workbookCopy.close();
			existingWorkbook.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}                
	}
	
	public static void BA_Supervisor_Status_Upload(String SupervisorPersonal,List<String> EmployeePNo)
	{	
		String Path = System.getProperty("user.dir")+"\\TestData\\BAModule_TestData\\SupervisorDetails.xls";
		try
		{	
			Workbook existingWorkbook = Workbook.getWorkbook(new File(Path));
			WritableWorkbook workbookCopy = Workbook.createWorkbook(new File(Path), existingWorkbook);
			WritableSheet Sheet = workbookCopy.getSheet("SupervisorDetails");
			Label label = new Label(0, 1,EmployeePNo.get(0));
			Label label1 = new Label(1, 1,SupervisorPersonal);
			Label label2 = new Label(2, 1,"N");
			
			Label label3 = new Label(0, 2,EmployeePNo.get(1));
			Label label4 = new Label(1, 2,SupervisorPersonal);
			Label label5 = new Label(2, 2,"N");
			
			Label label6 = new Label(0, 3,EmployeePNo.get(2));
			Label label7 = new Label(1, 3,SupervisorPersonal);
			Label label8 = new Label(2, 3,"N");
			
			Label label9 = new Label(0, 4,EmployeePNo.get(3));
			Label label10 = new Label(1, 4,SupervisorPersonal);
			Label label11 = new Label(2, 4,"N");
			
			Sheet.addCell(label);
			Sheet.addCell(label1);
			Sheet.addCell(label2);
			Sheet.addCell(label3);
			Sheet.addCell(label4);
			Sheet.addCell(label5);
			Sheet.addCell(label6);
			Sheet.addCell(label7);
			Sheet.addCell(label8);
			Sheet.addCell(label9);
			Sheet.addCell(label10);
			Sheet.addCell(label11);
			
			workbookCopy.write();
			workbookCopy.close();
			existingWorkbook.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}                
	}

	public static void BA_Mandate_Completion_Status_Upload(String Employee_EID)
	{	
		String Path = System.getProperty("user.dir")+"\\TestData\\BAModule_TestData\\BA_Mandate_Completion_Status_Upload.xls";
		try
		{	
			String EmployeeID = prop.getProperty(Employee_EID);
			Workbook existingWorkbook = Workbook.getWorkbook(new File(Path));
			WritableWorkbook workbookCopy = Workbook.createWorkbook(new File(Path), existingWorkbook);
			WritableSheet Sheet = workbookCopy.getSheet("Sheet1");
			Label label = new Label(0, 1,EmployeeID);
			Sheet.addCell(label);
			workbookCopy.write();
			workbookCopy.close();
			existingWorkbook.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}                
	}

	public static void Mettl_Objective_sampleassessment_Template(String Schedule_ID, String Assessment_ID, String SkillID) 

	{

		String Path =  System.getProperty("user.dir")+"\\TestData\\Objective_Assessment\\Sample_Assessment_Questionnaire_Upload.xls";

		try 

		{


			Workbook existingWorkbook = Workbook.getWorkbook(new File(Path));

			WritableWorkbook workbookCopy = Workbook.createWorkbook(new File(Path), existingWorkbook);

			WritableSheet Sheet = workbookCopy.getSheet("Sheet1");

			String AccountID = prop.getProperty("Mettl_Account_ID");



			Label label0 = new Label(0, 1, SkillID);

			Label label1 = new Label(1, 1, Schedule_ID);

			Label label2 = new Label(2, 1, Assessment_ID);

			Label label3 = new Label(3, 1, AccountID);

			Label label4 = new Label(4, 1, "Yes");

			Label label5 = new Label(5, 1, "Active");



			Sheet.addCell(label0);

			Sheet.addCell(label1);

			Sheet.addCell(label2);

			Sheet.addCell(label3);

			Sheet.addCell(label4);

			Sheet.addCell(label5);


			workbookCopy.write();

			workbookCopy.close();

			existingWorkbook.close();
			System.out.println("Sample assessment template filled");
		}

		catch (Exception e) 

		{

			e.printStackTrace();

		}                 

	}

	public static void Mettl_Objective_Questionnaire_Template_SameQ(String Schedule_ID, String Assessment_ID,String PrimarySkillID, String SecondarySkillID, String QTemplate) 

	{

		String Path =  System.getProperty("user.dir")+"\\TestData\\Objective_Assessment\\"+QTemplate+".xls";

		try 

		{

			Workbook existingWorkbook = Workbook.getWorkbook(new File(Path));

			WritableWorkbook workbookCopy = Workbook.createWorkbook(new File(Path), existingWorkbook);

			WritableSheet Sheet = workbookCopy.getSheet("Sheet_1");

			String AccountID = prop.getProperty("Mettl_Account_ID");

			System.out.println("Same Q-Questionary template  ");

			Label label0 = new Label(0, 1, PrimarySkillID);

			Label label1 = new Label(1, 1, Schedule_ID);

			Label label2 = new Label(2, 1, Assessment_ID);

			Label label3 = new Label(3, 1, AccountID);

			Label label4 = new Label(4, 1, "Active");

			Label label5 = new Label(0, 2, SecondarySkillID);

			Label label6 = new Label(1, 2, Schedule_ID);

			Label label7 = new Label(2, 2, Assessment_ID);

			Label label8 = new Label(3, 2, AccountID);

			Label label9 = new Label(4, 2, "Active");



			Sheet.addCell(label0);

			Sheet.addCell(label1);

			Sheet.addCell(label2);

			Sheet.addCell(label3);

			Sheet.addCell(label4);

			Sheet.addCell(label5);

			Sheet.addCell(label6);

			Sheet.addCell(label7);

			Sheet.addCell(label8);

			Sheet.addCell(label9);



			workbookCopy.write();

			workbookCopy.close();

			existingWorkbook.close();
			System.out.println("Same Q-Questionary template filled ");
		}

		catch (Exception e) 

		{

			e.printStackTrace();

		}                 

	}


public static void AdhocSecondary_Upload(String Enterprise_ID,String SkillID,String SkillName, String CompletionDate)
{
String Path = System.getProperty("user.dir")+"\\TestData\\AdhocSecondary_Upload.xls";
try
{
Workbook existingWorkbook = Workbook.getWorkbook(new File(Path));
WritableWorkbook workbookCopy = Workbook.createWorkbook(new File(Path), existingWorkbook);
WritableSheet Sheet = workbookCopy.getSheet("Sheet1");



Label label = new Label(0, 1,Enterprise_ID );
Label label1 = new Label(1, 1, SkillID);
Label label2 = new Label(2, 1, SkillName);
Label label3 = new Label(3, 1, "LCT");
Label label4 = new Label(4, 1, CompletionDate);




Sheet.addCell(label);
Sheet.addCell(label1);
Sheet.addCell(label2);
Sheet.addCell(label3);
Sheet.addCell(label4);

workbookCopy.write();
workbookCopy.close();
existingWorkbook.close();

}
catch (Exception e) 
{
	  e.printStackTrace();
}     }         


public static void BulkSchedule_For_Expert_Upload(String User_EID, String Skill_ID, String Over_write) 
{
String Path = System.getProperty("user.dir")+"\\TestData\\Expert_Assessment\\Bulk_Scheduling_for_Expert_Assessment.xls";
  try 
  
  {     
	  System.out.println('3');
	    Workbook existingWorkbook = Workbook.getWorkbook(new File(Path));
        WritableWorkbook workbookCopy = Workbook.createWorkbook(new File(Path), existingWorkbook);
     	WritableSheet Sheet = workbookCopy.getSheet("Sheet1");
       	Label label =  new Label(0, 1, User_EID);
       	Label label1 = new Label(1, 1, Skill_ID);
       	Label label2 = new Label(2, 1, "Skill Based");
       	Label label3 = new Label(3, 1,"Class Room");
     	Label label4 = new Label(4, 1,"Bangalore");
    	Label label5=  new Label(5, 1,"12/30/2021");
    	Label label6 = new Label(6, 1,"12:00:00");
    	Label label7 = new Label(7, 1,"13:50:00");
    	Label label8 = new Label(8, 1,"BDC8A.03.16");
       	Label label9 = new Label(9, 1, Over_write);
        Sheet.addCell(label);
        Sheet.addCell(label1);
        Sheet.addCell(label2);
        Sheet.addCell(label3);
        Sheet.addCell(label4);
        Sheet.addCell(label5);
        Sheet.addCell(label6);
        Sheet.addCell(label7);
        Sheet.addCell(label8);
        Sheet.addCell(label9);
      
        workbookCopy.write();
        workbookCopy.close();
        existingWorkbook.close();
        System.out.println("4");
      }
  catch (Exception e) 
  {
	  e.printStackTrace();
  }              

}

	
}

