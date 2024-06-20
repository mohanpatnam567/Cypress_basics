package LandingPageValidation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import CommonMethods.DatabaseConnectivity;
import CommonMethods.PropertyfileConfig;

public class LandingPageValidation_DatabaseConnectivity {
	
 static Properties prop = PropertyfileConfig.Propertyfile();

 public static Connection DB_Configuration() throws ClassNotFoundException, SQLException
	{		
		Connection con = DatabaseConnectivity.DB_Configuration();
		return con;
	}
 public static void P3Plus_Skill(WebDriver driver, ExtentTest LPVTest_test , ExtentReports LPVTest_report, String Employee ,String Skill)
	{
		try 
		{	
			LPVTest_test = LPVTest_report.createTest("Adding P3+ Proficiency to Skill");
			Connection con = LandingPageValidation_DatabaseConnectivity.DB_Configuration();
			Statement stmt = (Statement) con.createStatement();
			System.out.println("P3+ Script");

			String ResourceQuery = "select * from cmm_resource where crs_enterprise_id = '"+prop.getProperty(Employee)+"'";
			System.out.println(ResourceQuery+" Query for P3+ Script");
			ResultSet resultset = stmt.executeQuery(ResourceQuery);
			while (resultset.next()) 
			{
				String ResourceID = resultset.getString("CRS_ID");
				String SkillQuery = "select * from VIW_SKILLINVENTORY_ACTIVE_SKILLS where L5_NAME ='"+prop.getProperty(Skill)+"'";
				System.out.println(SkillQuery+" Query for P3+ Script");
				ResultSet resultset2 = stmt.executeQuery(SkillQuery);
				while (resultset2.next()) 
				{
					String SkillID = resultset2.getString("L5_ID");
					System.out.println("For making the employee P3+ the skillID is "+SkillID+" and the resourceID is "+ResourceID);
					String P3PlusScript="declare @peoplekey int = "+ResourceID+"            \r\n"
							+ "declare @skillid int = "+SkillID+"              \r\n"
							+ "declare @smeid int = 1481203    \r\n"
							+ "declare @scheduleId varchar(10) = '39316dc'       \r\n"
							+ "declare @assessmentId int = 114207        \r\n"
							+ "declare @ExpertinterviewerId int = 1481205         \r\n"
							+ "                \r\n"
							+ "				\r\n"
							+ "\r\n"
							+ "set nocount on  \r\n"
							+ "begin try              \r\n"
							+ "                begin tran t\r\n"
							+ "                \r\n"
							+ "if not exists(select * from SchedulesSkills where SkillId = @skillid)               \r\n"
							+ "begin     \r\n"
							+ "                insert into SchedulesSkills\r\n"
							+ "                select @scheduleId,@skillid,1,1,getutcdate(),NULL,NULL\r\n"
							+ "end        \r\n"
							+ "                \r\n"
							+ "select * from SchedulesSkills where skillid = @skillid and version  =1         \r\n"
							+ "                \r\n"
							+ "                \r\n"
							+ "                \r\n"
							+ "if not exists(select * from ScheduleForMettl where assessmentId = @assessmentid and ScheduleId = @scheduleId)                \r\n"
							+ "begin     \r\n"
							+ "                insert into ScheduleForMettl\r\n"
							+ "                select @scheduleId,@assessmentId,'6ZbcW8pfnWkx1ydiVXsMVg==',4,GETUTCDATE(),1077169,1,@scheduleId,NULL,NULL\r\n"
							+ "                --union all\r\n"
							+ "                --select @scheduleId,@assessmentId,'6ZbcW8pfnWkx1ydiVXsMVg==',4,GETUTCDATE(),1,1,NULL,1,GETUTCDATE()\r\n"
							+ "end        \r\n"
							+ "                \r\n"
							+ "select s.* from ScheduleForMettl s inner join SchedulesSkills h on h.ScheduleId = s.ScheduleId where h.skillid = @skillid and h.version  =1             \r\n"
							+ "                \r\n"
							+ "                \r\n"
							+ "if not exists(select * from AdvanceAssessmentMethod where SkillId = @skillid)    \r\n"
							+ "begin     \r\n"
							+ "                insert into AdvanceAssessmentMethod\r\n"
							+ "                select @skillid,'Y','N','N','N','N','Y',1,GETUTCDATE(),1,GETUTCDATE()/* config advance method,default value is Endorsed Nomination Form*/\r\n"
							+ "end        \r\n"
							+ "                \r\n"
							+ "select * from AdvanceAssessmentMethod where skillid = @skillid              \r\n"
							+ "                \r\n"
							+ "                \r\n"
							+ "if not exists(select * from SkillAllowAssessment where skillid = @skillid)  \r\n"
							+ "begin     \r\n"
							+ "                INSERT INTO SkillAllowAssessment\r\n"
							+ "                select @skillid,CRL_ID,1,GETUTCDATE(),NULL from CMM_RESOURCE_LEVEL where CRL_ACTIVEYN = 'Y'\r\n"
							+ "end        \r\n"
							+ "                \r\n"
							+ "select * from SkillAllowAssessment where skillid = @skillid            \r\n"
							+ "                \r\n"
							+ "if not exists(select * from ProficiencyConfigDetail where skillid = @skillid)              \r\n"
							+ "begin     \r\n"
							+ "                insert into ProficiencyConfigDetail\r\n"
							+ "                select @skillid,5,40,50,60,65,1,GETUTCDATE()\r\n"
							+ "end        \r\n"
							+ "select * from ProficiencyConfigDetail where skillid = @skillid        \r\n"
							+ "                \r\n"
							+ "declare @registerid uniqueidentifier       \r\n"
							+ "select @registerid = id from AssessmentRegister where PeopleKey = @peoplekey and OwnerSkillId = @skillid and AssessmentId = @assessmentId \r\n"
							+ "if @registerid is null        \r\n"
							+ "                set @registerid = newid()\r\n"
							+ "                \r\n"
							+ "print @registerid              \r\n"
							+ "                \r\n"
							+ "--select * from AssessmentRegister         \r\n"
							+ "if not exists(select * from AssessmentRegister where PeopleKey = @peoplekey and OwnerSkillId = @skillid and AssessmentId = @assessmentId)              \r\n"
							+ "begin     \r\n"
							+ "                insert into AssessmentRegister\r\n"
							+ "                select @registerid,@peoplekey,@skillid,@assessmentid,1,GETUTCDATE(),1,GETUTCDATE(),1,null,null,null\r\n"
							+ "end        \r\n"
							+ "select * from AssessmentRegister where PeopleKey = @peoplekey and OwnerSkillId = @skillid     \r\n"
							+ "                \r\n"
							+ "if not exists(select * from Assessments where registerid = @registerid and ScheduleId = @scheduleId)     \r\n"
							+ "begin     \r\n"
							+ "                insert into Assessments\r\n"
							+ "                select @registerid, @scheduleId,null,1,GETUTCDATE(),null\r\n"
							+ "                union all\r\n"
							+ "                select @registerid, @scheduleId,null,2,GETUTCDATE(),null\r\n"
							+ "                union all\r\n"
							+ "                select @registerid, @scheduleId,null,3,GETUTCDATE(),null\r\n"
							+ "                union all\r\n"
							+ "                select @registerid, @scheduleId,null,4,GETUTCDATE(),null\r\n"
							+ "end        \r\n"
							+ "                \r\n"
							+ "                \r\n"
							+ "if not exists(select * from AssessmentResult where RegisterId = @registerid and SkillId = @skillid and PeopleKey = @peoplekey)    \r\n"
							+ "begin     \r\n"
							+ "                insert into AssessmentResult\r\n"
							+ "                select @registerid, @skillid, @peoplekey, 100,100,null,null,GETUTCDATE(),getutcdate(),GETUTCDATE(),null,null,null,100,0,0,100,0,0,100\r\n"
							+ "end        \r\n"
							+ "select * from AssessmentResult where registerid = @registerid   \r\n"
							+ "                \r\n"
							+ "                \r\n"
							+ "if not exists(select * from SkillProficiencyOfTalent where resourceid = @peoplekey and SKillId = @skillid and AssessmentResultId = @registerid)          \r\n"
							+ "begin     \r\n"
							+ "                insert into SkillProficiencyOfTalent\r\n"
							+ "                select newid(), @peoplekey, @skillid, 3 ,@registerid, 'Y', 1,'Calculation',GETUTCDATE(), 0, GETUTCDATE(),1,null,null,'A',GETUTCDATE(),null,null,null\r\n"
							+ "end        \r\n"
							+ "                \r\n"
							+ "select * from SkillProficiencyOfTalent where resourceid = @peoplekey   \r\n"
							+ "                \r\n"
							+ "if not exists(select * from SkillInventoryAdvancedAssessment where SkillInventoryId = @skillid)   \r\n"
							+ "begin     \r\n"
							+ "                insert into SkillInventoryAdvancedAssessment\r\n"
							+ "                select 5, @skillid, 1,1 ,GETUTCDATE(),1,getutcdate(),1\r\n"
							+ "end        \r\n"
							+ "                \r\n"
							+ "select * from SkillInventoryAdvancedAssessment where SkillInventoryId = @skillid             \r\n"
							+ "                \r\n"
							+ " \r\n"
							+ "                \r\n"
							+ "commit tran t     \r\n"
							+ "end try  \r\n"
							+ "begin catch         \r\n"
							+ "                \r\n"
							+ "                DECLARE @msg nvarchar(MAX)=ERROR_MESSAGE()    \r\n"
							+ "                PRINT @msg\r\n"
							+ "    RAISERROR (@msg,16,1)          \r\n"
							+ "                \r\n"
							+ "                rollback tran t\r\n"
							+ "end catch             \r\n"
							+ "set nocount off\r\n"
							+ " \r\n"
							+ "";
					stmt.execute(P3PlusScript);
					System.out.println("P3+ Script Has Been Run Successfully For The Employee");
					LPVTest_test.log(Status.PASS,"Employee "+ResourceID+"  Skill "+SkillID);
					LPVTest_test.log(Status.PASS,"P3+ Script Has Been Run Successfully For The Employee");
				}
			}
		}
		catch(Exception E) {
			System.out.println(E);
		}
	}

	public static void P4Plus_Skill(WebDriver driver, ExtentTest LPVTest_test , ExtentReports LPVTest_report, String Employee ,String Skill)
	{
		try 
		{	
			LPVTest_test = LPVTest_report.createTest("Employee Master Eligible Using_P4+ Script");
			Connection con = LandingPageValidation_DatabaseConnectivity.DB_Configuration();
			Statement stmt = (Statement) con.createStatement();
			System.out.println("P3+ Script");

			String ResourceQuery = "select * from cmm_resource where crs_enterprise_id = '"+prop.getProperty(Employee)+"'";
			System.out.println(ResourceQuery+" Query for P3+ Script");
			ResultSet resultset = stmt.executeQuery(ResourceQuery);
			while (resultset.next()) 
			{
				String ResourceID = resultset.getString("CRS_ID");
				String SkillQuery = "select * from VIW_SKILLINVENTORY_ACTIVE_SKILLS where L5_NAME ='"+prop.getProperty(Skill)+"'";
				System.out.println(SkillQuery+" Query for P3+ Script");
				ResultSet resultset2 = stmt.executeQuery(SkillQuery);
				while (resultset2.next()) 
				{
					String SkillID = resultset2.getString("L5_ID");
					System.out.println("For making the employee P4+ the skillID is "+SkillID+" and the resourceID is "+ResourceID);
					String P4PlusScript="declare @peoplekey int = "+ResourceID+"\n"
							+ "declare @skillid int = "+SkillID+"\n"
							+ "declare @smeid int = 1481203       \r\n"
							+ "declare @scheduleId varchar(10) = '39316dc'     \r\n"
							+ "declare @assessmentId int = 114207 \r\n"
							+ "declare @ExpertinterviewerId int = 1481205      \r\n"
							+ "declare @QuestionnaireID uniqueidentifier = 'C700E39D-B7C3-4A55-9B99-C6136FDD9E00'\r\n"
							+ "declare @ExpertQuestionnaireID uniqueidentifier = 'C700E39D-B7C3-4A55-9B99-C6136FDD9E00'\r\n"
							+ "    --(18923,31848,39399)\r\n"
							+ "--2147411\r\n"
							+ "--2901155\r\n"
							+ "set nocount on       \r\n"
							+ "       \r\n"
							+ "if not exists(select * from SchedulesSkills where SkillId = @skillid)      \r\n"
							+ "begin  \r\n"
							+ "       insert into SchedulesSkills\r\n"
							+ "       select @scheduleId,@skillid,1,1,getutcdate(),NULL,NULL\r\n"
							+ "end    \r\n"
							+ "       \r\n"
							+ "select * from SchedulesSkills where skillid = @skillid and version  =1     \r\n"
							+ "       \r\n"
							+ "       \r\n"
							+ "       \r\n"
							+ "if not exists(select * from ScheduleForMettl where assessmentId = @assessmentid and ScheduleId = @scheduleId)  \r\n"
							+ "begin  \r\n"
							+ "       insert into ScheduleForMettl\r\n"
							+ "       select @scheduleId,@assessmentId,'6ZbcW8pfnWkx1ydiVXsMVg==',4,GETUTCDATE(),1077169,1,@scheduleId,NULL,NULL\r\n"
							+ "       union all\r\n"
							+ "       select @scheduleId,@assessmentId,'6ZbcW8pfnWkx1ydiVXsMVg==',4,GETUTCDATE(),1,1,NULL,1,GETUTCDATE()\r\n"
							+ "end    \r\n"
							+ "       \r\n"
							+ "select s.* from ScheduleForMettl s inner join SchedulesSkills h on h.ScheduleId = s.ScheduleId where h.skillid = @skillid and h.version  =1   \r\n"
							+ "       \r\n"
							+ "       \r\n"
							+ "if not exists(select * from AdvanceAssessmentMethod where SkillId = @skillid)     \r\n"
							+ "begin  \r\n"
							+ "       insert into AdvanceAssessmentMethod\r\n"
							+ "       select @skillid,'Y','N','N','N','N','Y',1,GETUTCDATE(),1,GETUTCDATE()\r\n"
							+ "end    \r\n"
							+ "       \r\n"
							+ "select * from AdvanceAssessmentMethod where skillid = @skillid       \r\n"
							+ "       \r\n"
							+ "       \r\n"
							+ "if not exists(select * from SkillAllowAssessment where skillid = @skillid) \r\n"
							+ "begin  \r\n"
							+ "       INSERT INTO SkillAllowAssessment\r\n"
							+ "       select @skillid,CRL_ID,1,GETUTCDATE(),null from CMM_RESOURCE_LEVEL where CRL_ACTIVEYN = 'Y'\r\n"
							+ "end    \r\n"
							+ "       \r\n"
							+ "select * from SkillAllowAssessment where skillid = @skillid   \r\n"
							+ "       \r\n"
							+ "if not exists(select * from ProficiencyConfigDetail where skillid = @skillid)     \r\n"
							+ "begin  \r\n"
							+ "       insert into ProficiencyConfigDetail\r\n"
							+ "       select @skillid,5,40,50,60,65,1,GETUTCDATE()\r\n"
							+ "end    \r\n"
							+ "select * from ProficiencyConfigDetail where skillid = @skillid       \r\n"
							+ "       \r\n"
							+ "declare @registerid uniqueidentifier     \r\n"
							+ "select @registerid = id from AssessmentRegister where PeopleKey = @peoplekey and OwnerSkillId = @skillid and AssessmentId = @assessmentId \r\n"
							+ "if @registerid is null     \r\n"
							+ "       set @registerid = newid()\r\n"
							+ "       \r\n"
							+ "print @registerid    \r\n"
							+ "       \r\n"
							+ "--select * from AssessmentRegister \r\n"
							+ "if not exists(select * from AssessmentRegister where PeopleKey = @peoplekey and OwnerSkillId = @skillid and AssessmentId = @assessmentId)      \r\n"
							+ "begin  \r\n"
							+ "       insert into AssessmentRegister\r\n"
							+ "       select @registerid,@peoplekey,@skillid,@assessmentid,1,GETUTCDATE(),1,GETUTCDATE(),1,null,null,null\r\n"
							+ "end    \r\n"
							+ "select * from AssessmentRegister where PeopleKey = @peoplekey and OwnerSkillId = @skillid \r\n"
							+ "       \r\n"
							+ "if not exists(select * from Assessments where registerid = @registerid and ScheduleId = @scheduleId)       \r\n"
							+ "begin  \r\n"
							+ "       insert into Assessments\r\n"
							+ "       select @registerid, @scheduleId,null,1,GETUTCDATE(),null\r\n"
							+ "       union all\r\n"
							+ "       select @registerid, @scheduleId,null,2,GETUTCDATE(),null\r\n"
							+ "       union all\r\n"
							+ "       select @registerid, @scheduleId,null,3,GETUTCDATE(),null\r\n"
							+ "       union all\r\n"
							+ "       select @registerid, @scheduleId,null,4,GETUTCDATE(),null\r\n"
							+ "end    \r\n"
							+ "       \r\n"
							+ "       \r\n"
							+ "if not exists(select * from AssessmentResult where RegisterId = @registerid and SkillId = @skillid and PeopleKey = @peoplekey) \r\n"
							+ "begin  \r\n"
							+ "       insert into AssessmentResult\r\n"
							+ "       select @registerid, @skillid, @peoplekey, 100,100,null,null,GETUTCDATE(),getutcdate(),GETUTCDATE(),null,null,null,100,0,0,100,0,0,100\r\n"
							+ "end    \r\n"
							+ "select * from AssessmentResult where registerid = @registerid \r\n"
							+ " Declare @talID uniqueidentifier\r\n"
							+ " SET @talID= newid()      \r\n"
							+ "       \r\n"
							+ "if not exists(select * from SkillProficiencyOfTalent where resourceid = @peoplekey and SKillId = @skillid and AssessmentResultId = @registerid)  \r\n"
							+ "begin  \r\n"
							+ "       insert into SkillProficiencyOfTalent\r\n"
							+ "       select @talID, @peoplekey, @skillid, 3 ,@registerid, 'Y', 1,'Calculation',GETUTCDATE(), 0, GETUTCDATE(),1,null,null,'A',GETUTCDATE(),null,null,null\r\n"
							+ "end    \r\n"
							+ "       \r\n"
							+ "select * from SkillProficiencyOfTalent where resourceid = @peoplekey \r\n"
							+ "       \r\n"
							+ "if not exists(select * from SkillInventoryAdvancedAssessment where SkillInventoryId = @skillid) \r\n"
							+ "begin  \r\n"
							+ "       insert into SkillInventoryAdvancedAssessment\r\n"
							+ "       select 5, @skillid, 1,1 ,GETUTCDATE(),1,getutcdate(),1\r\n"
							+ "end    \r\n"
							+ "       \r\n"
							+ "select * from SkillInventoryAdvancedAssessment where SkillInventoryId = @skillid  \r\n"
							+ "       \r\n"
							+ "--select * from AdvanceAssessmentRegister \r\n"
							+ "       \r\n"
							+ "if not exists(select * from AdvanceAssessmentRegister where PeopleKey = @peoplekey and SkillId = @skillid)     \r\n"
							+ "begin  \r\n"
							+ "       insert into AdvanceAssessmentRegister \r\n"
							+ "       select newid(),@peoplekey,@skillid,@talID,1,GETUTCDATE(),1,GETUTCDATE(),1,0,null,null\r\n"
							+ "end    \r\n"
							+ "declare @advanceregisterId as uniqueidentifier\r\n"
							+ "select @advanceregisterId = Id from AdvanceAssessmentRegister where PeopleKey = @peoplekey and SkillId = @skillid   and IsActive = 1\r\n"
							+ "\r\n"
							+ "create table #tempAdvanceAssessmentMethod \r\n"
							+ "(\r\n"
							+ "       SkillId int,\r\n"
							+ "       SkillTest int,\r\n"
							+ "       Certification int,\r\n"
							+ "       HandsOn int,\r\n"
							+ "       CaseStudy int,\r\n"
							+ "       AdvancedAssessment int,\r\n"
							+ "       Interview int\r\n"
							+ ")\r\n"
							+ "\r\n"
							+ "insert into #tempAdvanceAssessmentMethod select SkillId,\r\n"
							+ "case when  SkillTest = 'Y' then 1 else 0 end,\r\n"
							+ "case when  CaseStudy = 'Y' then 2 else 0 end,\r\n"
							+ "case when  HandsOn = 'Y' then 4 else 0 end,\r\n"
							+ "case when  Interview = 'Y' then 8 else 0 end,\r\n"
							+ "case when  Certification = 'Y' then 16 else 0 end,\r\n"
							+ "case when  AdvancedAssessment = 'Y' then 32 else 0 end\r\n"
							+ "from AdvanceAssessmentMethod \r\n"
							+ "\r\n"
							+ "update aar set AdvanceMethod = taar.SkillTest|taar.CaseStudy|taar.HandsOn|taar.Interview|taar.Certification|taar.AdvancedAssessment\r\n"
							+ "from AdvanceAssessmentRegister aar inner join #tempAdvanceAssessmentMethod taar on aar.SkillId = taar.SkillId\r\n"
							+ "\r\n"
							+ "drop table #tempAdvanceAssessmentMethod  \r\n"
							+ "       \r\n"
							+ "\r\n"
							+ "if not exists (select top 1 * from NominationFormQuestionnaire where SkillInventoryId= @skillid and isP4process=0)       /*congig P3 process QuestionnaireId in advance*/\r\n"
							+ "begin\r\n"
							+ "INSERT INTO NominationFormQuestionnaire VALUES (@QuestionnaireID,@skillid,5,null,1,1,getutcdate(),null,null,0)\r\n"
							+ "end\r\n"
							+ "\r\n"
							+ "--select * from NominationFormResults    \r\n"
							+ "declare @QuestinnaireId int      \r\n"
							+ "select top 1 @QuestinnaireId = id from NominationFormQuestionnaire where SkillInventoryId= @skillid and isP4process=0    /*congig P3 process QuestionnaireId in advance*/\r\n"
							+ "print @QuestinnaireId\r\n"
							+ "       \r\n"
							+ "if not exists(select * from NominationFormResults where peoplekey= @peoplekey and SkillId = @skillid and isP4process=0)   \r\n"
							+ "begin  \r\n"
							+ "       insert into NominationFormResults \r\n"
							+ "       select @peoplekey,@skillid,@QuestinnaireId,1,1,100,NULL,1,1,GETUTCDATE(),1,GETUTCDATE(),0,NULL,@advanceregisterId,null,null,null\r\n"
							+ "end    \r\n"
							+ "select * from NominationFormResults where peoplekey= @peoplekey and SkillId = @skillid and isP4process=0\r\n"
							+ "       \r\n"
							+ "--select * from SmeEmployeeMapping \r\n"
							+ "       \r\n"
							+ "if not exists(select * from SmeEmployeeMapping where ResourceId= @peoplekey and SkillId = @skillid)       \r\n"
							+ "begin  \r\n"
							+ "       insert into SmeEmployeeMapping \r\n"
							+ "       select @peoplekey,@smeid,@skillid,NULL,1,GETUTCDATE(),1,GETUTCDATE(),@advanceregisterId\r\n"
							+ "end    \r\n"
							+ "select * from SmeEmployeeMapping where ResourceId= @peoplekey and SkillId = @skillid     \r\n"
							+ "\r\n"
							+ "--select * from NominationFormReviewCutOffScore\r\n"
							+ "if not exists(select * from NominationFormReviewCutOffScore where skillid = @skillid )   \r\n"
							+ "begin  \r\n"
							+ "       insert into NominationFormReviewCutOffScore\r\n"
							+ "       select @skillid,70,90,1,GETUTCDATE(),1,GETUTCDATE()\r\n"
							+ "end    \r\n"
							+ "select * from NominationFormReviewCutOffScore where skillid=@skillid \r\n"
							+ "       \r\n"
							+ "--select * from NominationFormReviewResults     \r\n"
							+ "declare @NominationFormResultsId int     \r\n"
							+ "select @NominationFormResultsId = id from NominationFormResults where PeopleKey = @peoplekey and SkillId = @skillid and isP4process=0     \r\n"
							+ "       \r\n"
							+ "if not exists(select * from NominationFormReviewResults where Resourceid= @peoplekey and SkillId = @skillid and isP4Process=0) \r\n"
							+ "begin  \r\n"
							+ "       insert into NominationFormReviewResults \r\n"
							+ "       select @peoplekey,@smeid,@skillid,'Primary',@NominationFormResultsId,1,2,90,NULL,1,0,1,GETUTCDATE(),1,GETUTCDATE(),NULL,0,0,NULL,null,null,null,null\r\n"
							+ "end    \r\n"
							+ "select * from NominationFormReviewResults where ResourceId= @peoplekey and SkillId = @skillid and isP4process=0        \r\n"
							+ "       \r\n"
							+ "--select * from TalentSkillProficiency   \r\n"
							+ "declare @Id uniqueidentifier=newid()     \r\n"
							+ "       \r\n"
							+ "if not exists(select * from TalentSkillProficiency where resourceid = @peoplekey and SKillId = @skillid and AssessmentCategory=2) \r\n"
							+ "begin  \r\n"
							+ "       insert into TalentSkillProficiency \r\n"
							+ "       select newid(),@peoplekey, @skillid, 5,0 ,'- if total score is < 70(p3 score), then P2 proficiency - if total score is >=70 and < 90(p3+ score), then P3 proficiency - if total score is >= 90 then P3+ (Qualilfied for P4 evaluation)',2,GETUTCDATE(),1,GETUTCDATE(),1,@advanceregisterId,null,'A',null,null\r\n"
							+ "end    \r\n"
							+ "select * from TalentSkillProficiency where resourceid = @peoplekey and SKillId = @skillid \r\n"
							+ "       \r\n"
							+ "--select * from TalentProficiencyScore   \r\n"
							+ "declare @TalentProficiencyId uniqueidentifier   \r\n"
							+ "select @TalentProficiencyId = id from TalentSkillProficiency where resourceid = @peoplekey and SKillId = @skillid   \r\n"
							+ "       \r\n"
							+ "if not exists(select * from TalentProficiencyScore where TalentProficiencyId= @Id )      \r\n"
							+ "begin  \r\n"
							+ "       insert into TalentProficiencyScore\r\n"
							+ "       select @TalentProficiencyId,8,1,@NominationFormResultsId\r\n"
							+ "end    \r\n"
							+ "select * from TalentProficiencyScore where TalentProficiencyId = @id \r\n"
							+ "       \r\n"
							+ "if not exists(select * from SkillInventoryExpertAssessment where SkillInventoryId=@skillid )    \r\n"
							+ "begin  \r\n"
							+ "    insert into SkillInventoryExpertAssessment \r\n"
							+ "    select 5,@skillid,1,1,GETUTCDATE(),1,GETUTCDATE(),1       \r\n"
							+ "end    \r\n"
							+ "       \r\n"
							+ "select * from SkillInventoryExpertAssessment where SkillInventoryId=@skillid\r\n"
							+ "\r\n"
							+ "if not exists (select top 1 * from NominationFormQuestionnaire where SkillInventoryId= @skillid and isP4process=1)       /*congig P3 process QuestionnaireId in advance*/\r\n"
							+ "begin\r\n"
							+ "INSERT INTO NominationFormQuestionnaire VALUES (@ExpertQuestionnaireID,@skillid,5,null,1,1,getutcdate(),null,null,1)\r\n"
							+ "end\r\n"
							+ "\r\n"
							+ "--select * from NominationFormResults    \r\n"
							+ "declare @ExpertQuestinnaireId int \r\n"
							+ "select top 1 @ExpertQuestinnaireId = id from NominationFormQuestionnaire where SkillInventoryId= @skillid and isP4process=1 /*congig P3 process QuestionnaireId in advance*/\r\n"
							+ "print @ExpertQuestinnaireId\r\n"
							+ "\r\n"
							+ "       \r\n"
							+ "if not exists(select * from NominationFormResults where peoplekey= @peoplekey and SkillId = @skillid and isP4process=1)   \r\n"
							+ "begin  \r\n"
							+ "       insert into NominationFormResults \r\n"
							+ "       select @peoplekey,@skillid,@ExpertQuestinnaireId,null,null,100,NULL,1,1,GETUTCDATE(),1,GETUTCDATE(),1,NULL,@advanceregisterId,null,null,null\r\n"
							+ "end    \r\n"
							+ "select * from NominationFormResults where peoplekey= @peoplekey and SkillId = @skillid and isP4process=1\r\n"
							+ "\r\n"
							+ "/*\r\n"
							+ "select * from ExpertInterviewerEmpMapping     \r\n"
							+ "\r\n"
							+ "if not exists(select * from ExpertInterviewerEmpMapping where ResourceId= @peoplekey and SkillId = @skillid )    \r\n"
							+ "begin  \r\n"
							+ "       insert into ExpertInterviewerEmpMapping \r\n"
							+ "       select @peoplekey,@ExpertinterviewerId,@skillid,NULL,1,GETUTCDATE(),1,GETUTCDATE()\r\n"
							+ "end    \r\n"
							+ "select * from ExpertInterviewerEmpMapping where ResourceId= @peoplekey and SkillId = @skillid\r\n"
							+ "\r\n"
							+ "\r\n"
							+ "select * from NominationFormReviewResults     \r\n"
							+ "declare @EXNominationFormResultsId int   \r\n"
							+ "select @EXNominationFormResultsId = id from NominationFormResults where PeopleKey = @peoplekey and SkillId = @skillid and isP4process=1\r\n"
							+ "       \r\n"
							+ "if not exists(select * from NominationFormReviewResults where Resourceid= @peoplekey and SkillId = @skillid and IsP4Process=1) \r\n"
							+ "begin  \r\n"
							+ "       insert into NominationFormReviewResults \r\n"
							+ "       select @peoplekey,@smeid,@skillid,'Primary',@EXNominationFormResultsId,1,null,20,NULL,1,0,1,GETUTCDATE(),1,GETUTCDATE(),NULL,1,1,NULL\r\n"
							+ "end    \r\n"
							+ "select * from NominationFormReviewResults where ResourceId= @peoplekey and SkillId = @skillid and isP4process=1*/\r\n"
							+ "\r\n"
							+ "set nocount off      \r\n"
							+ "";
					stmt.execute(P4PlusScript);
					System.out.println("P4+ Script Has Been Run Successfully For The Employee");
					LPVTest_test.log(Status.PASS,"Employee "+ResourceID+"  Skill "+SkillID);
					LPVTest_test.log(Status.PASS,"P4+ Script Has Been Run Successfully For The Employee");
				}
			}
		}
		catch(Exception E) {
			System.out.println(E);
		}
	}

	public static void RSM_History_Delete(WebDriver driver, ExtentTest LPVTest_test , ExtentReports LPVTest_report, String Employee)
	{
		try{	

			Connection con = LandingPageValidation_DatabaseConnectivity.DB_Configuration();

			Statement stmt = (Statement) con.createStatement();

			System.out.println("RSM HISTORY DELETE");

			String AssesseInfoQuery = "select * from cmm_resource where CRS_ENTERPRISE_ID= '"+prop.getProperty(Employee)+"'";
			System.out.println(AssesseInfoQuery);
			ResultSet resultSet= stmt.executeQuery(AssesseInfoQuery);
			while(resultSet.next())
			{
				String ResourceId = resultSet.getString("CRS_ID");
				System.out.println("Employee Resource id  "+ResourceId);

				String DeleteQuery1 = "Delete from CMM_UNCONVENTIONAL_SKILL_CHANGE where CUSC_CRS_ID  in ("+ResourceId+")";
				String DeleteQuery2 = "Delete from Cmm_resource_skills_mapping where CRSS_RS_ID  in ("+ResourceId+")";
				String DeleteQuery3 = "Delete from CMM_SKILLCHANGEREQUEST  where CSCR_CRS_ID  in ("+ResourceId+")";
				System.out.println(DeleteQuery1);
				System.out.println(DeleteQuery2);
				System.out.println(DeleteQuery3);
				stmt.addBatch(DeleteQuery1);
				stmt.addBatch(DeleteQuery2);
				stmt.addBatch(DeleteQuery3);
				stmt.executeBatch();	
				LPVTest_test.log(Status.PASS,"Existing resource skill mapping has been deleted");
				System.out.println("RSM histroy deleted");
			}
			con.close();	

		}
		catch(Exception E)
		{
			System.out.println(E);
			LandingPageValidation_GetExtentReports.Exception(driver, LPVTest_test, E);
		}
	}

	public static void Skill_AssessmentHistory_Delete(WebDriver driver, ExtentTest LPVTest_test , ExtentReports LPVTest_report, String Employee, String Skill)
	{
		try
		{
			Connection con = LandingPageValidation_DatabaseConnectivity.DB_Configuration();
			System.out.println("ASSESSMENT HISTORY DELETE");
			
			Statement stmt = (Statement) con.createStatement();
			Statement stmt1 = (Statement) con.createStatement();
			Statement stmt2 = (Statement) con.createStatement();
			Statement stmt3 = (Statement) con.createStatement();
			Statement stmt4 = (Statement) con.createStatement();
			Statement stmt5 = (Statement) con.createStatement();
			Statement stmt6 = (Statement) con.createStatement();


			String GetPrimarySkillIDQueryy = "select * from VIW_SKILLINVENTORY_ACTIVE_SKILLS WHERE L5_NAME = '"+prop.getProperty(Skill)+"'";
			System.out.println(GetPrimarySkillIDQueryy);
			ResultSet resultSet= stmt.executeQuery(GetPrimarySkillIDQueryy);

			String GetResourceIDQueryy = "select * from cmm_resource where CRS_ENTERPRISE_ID='"+prop.getProperty(Employee)+"'";
			System.out.println(GetResourceIDQueryy);
			while(resultSet.next())
			{
				String PrimarySkillId = resultSet.getString("L5_id");
				System.out.print("SkillId =" +PrimarySkillId);		
				ResultSet resultSet1= stmt1.executeQuery(GetResourceIDQueryy);
				if(resultSet1.next()==true)
				{
					String ResourceId = resultSet1.getString("CRS_ID");
					System.out.println("peopleKey="+ResourceId);		
					String DeleteQuery = "delete from AdvanceAssessmentRegisterMethod where PeopleKey ="+ResourceId+" and SkillId="+PrimarySkillId+"";
					String DeleteQuery1 = "delete from AdvanceScheduleForSchedulingTool where ResourceId ="+ResourceId+" and SkillId="+PrimarySkillId+"";
					String DeleteQuery2 = "delete from RegisterIdMapping where PeopleKey ="+ResourceId+" and SkillId="+PrimarySkillId+"";
					String DeleteQuery3 = "delete from Evaluationform where ResourceId ="+ResourceId+" and SkillId="+PrimarySkillId+"";
					String DeleteQuery4 = "delete from CompletionStatus where ResourceId ="+ResourceId+" and SkillId="+PrimarySkillId+"";
					String DeleteQuery5 = "delete from SmeEmployeeMapping where ResourceId ="+ResourceId+" and SkillId="+PrimarySkillId+"";
					String DeleteQuery6 = "delete from SkillProficiencyOfTalent where ResourceId ="+ResourceId+" and SkillId="+PrimarySkillId+"";
					String DeleteQuery7 = "delete from AdvanceAssessmentRegister where PeopleKey  ="+ResourceId+" and SkillId="+PrimarySkillId+"";
					String DeleteQuery19 ="Delete from CMM_Certification_EmployeeUpload_DisplayDetails  where Resource_id in ("+ResourceId+") and Skill_id="+PrimarySkillId+"";
					String DeleteQuery20 ="delete from  EmployeeContribution_Upload where PeopleKey in ("+ResourceId+") and SkillID = "+PrimarySkillId+"";
					String DeleteQuery21 ="delete from CMM_EXEC_ASSESSMENT_DETAILS where Peoplekey in ("+ResourceId+") and SkillID = "+PrimarySkillId+"";
					String DeleteQuery22 ="delete from ContributionFormResults where peoplekey in ("+ResourceId+") and SkillID = "+PrimarySkillId+"";
					String DeleteQuery23 ="delete from ContributionFormAttachments where peoplekey in ("+ResourceId+") and SkillID = "+PrimarySkillId+"";
					String DeleteQuery24 ="delete from cmm_employee_certification  where CEC_RESOURCE_ID in ("+ResourceId+") and CEC_SKILL_ID = "+PrimarySkillId+"";
					String DeleteQuery25 ="delete from advanceassessmentregistermethod where PeopleKey in ("+ResourceId+") and SkillID = "+PrimarySkillId+"";
					String DeleteQuery26 ="delete from CMM_BYPASS_EMPLOYEE_CERTIFICATION_DETAILS where PeopleKey in ("+ResourceId+") and SkillID = "+PrimarySkillId+"";
					String DeleteQuery27 = "delete from certificationproficiencyoftalent where ResourceId ="+ResourceId+" and SkillId="+PrimarySkillId+"";

					System.out.println(DeleteQuery);
					System.out.println(DeleteQuery1);
					System.out.println(DeleteQuery2);
					System.out.println(DeleteQuery3);
					System.out.println(DeleteQuery4);
					System.out.println(DeleteQuery5);
					System.out.println(DeleteQuery6);
					System.out.println(DeleteQuery7);
					System.out.println(DeleteQuery19);
					System.out.println(DeleteQuery20);
					System.out.println(DeleteQuery21);
					System.out.println(DeleteQuery22);
					System.out.println(DeleteQuery23);
					System.out.println(DeleteQuery24);
					System.out.println(DeleteQuery25);
					System.out.println(DeleteQuery26);
					System.out.println(DeleteQuery27);

					stmt1.addBatch(DeleteQuery);
					stmt1.addBatch(DeleteQuery1);
					stmt1.addBatch(DeleteQuery2);
					stmt1.addBatch(DeleteQuery3);
					stmt1.addBatch(DeleteQuery4);
					stmt1.addBatch(DeleteQuery5);
					stmt1.addBatch(DeleteQuery6);
					stmt1.addBatch(DeleteQuery7);
					stmt1.addBatch(DeleteQuery19);
					stmt1.addBatch(DeleteQuery20);
					stmt1.addBatch(DeleteQuery21);
					stmt1.addBatch(DeleteQuery22);
					stmt1.addBatch(DeleteQuery23);
					stmt1.addBatch(DeleteQuery24);
					stmt1.addBatch(DeleteQuery25);
					stmt1.addBatch(DeleteQuery26);
					stmt1.addBatch(DeleteQuery27);
					stmt1.executeBatch();
					LPVTest_test.log(Status.PASS,"Existing Assessment details for the skill has been deleted");
					String GetSkillProficiency = "select * from TalentSkillProficiency where resourceid="+ResourceId+" and skillid="+PrimarySkillId+"";
					System.out.println(GetSkillProficiency);
					System.out.println("Hi");
					ResultSet resultSet2= stmt2.executeQuery(GetSkillProficiency);
					if(resultSet2.next()==true)
					{
						String AssessmentResultId = resultSet2.getString("Id");
						System.out.println(AssessmentResultId);
						String DeleteQuery8 = "delete from TalentProficiencyScore where TalentProficiencyId='"+AssessmentResultId+"'";
						String DeleteQuery9 = "delete from TalentSkillProficiency where resourceid = "+ResourceId+" and skillid="+PrimarySkillId+"";
						System.out.println(DeleteQuery8);
						System.out.println(DeleteQuery9);
						stmt2.addBatch(DeleteQuery8);
						stmt2.addBatch(DeleteQuery9);
						stmt2.executeBatch();

					}
					LPVTest_test.log(Status.PASS,"Existing Proficiency details for the skill has been deleted");
					String GetRegisterIDQueryy = "select * from AssessmentRegister where Peoplekey = "+ResourceId+" and OwnerSkillId="+PrimarySkillId+"";
					System.out.println(GetRegisterIDQueryy);

					ResultSet resultSet3= stmt3.executeQuery(GetRegisterIDQueryy);
					if(resultSet3.next()==true)
					{
						String AssessmentRegisterId = resultSet3.getString("Id");
						System.out.println("AssessmentRegisterId=" + AssessmentRegisterId);

						String DeleteQuery10 = "delete from Assessments where Registerid='"+AssessmentRegisterId+"'";
						System.out.println(DeleteQuery10);

						String DeleteQuery11 = "delete from AssessmentRegister where PeopleKey = "+ResourceId+" and OwnerSkillId="+PrimarySkillId+"";
						System.out.println(DeleteQuery11);

						stmt3.addBatch(DeleteQuery10);
						stmt3.addBatch(DeleteQuery11);
						stmt3.executeBatch();
					}
					LPVTest_test.log(Status.PASS,"Existing Registration details for the skill has been deleted");
					String GetNominationResultIdQuery = "select * from NominationFormResults where PeopleKey = "+ResourceId+" and SkillId="+PrimarySkillId+"";
					System.out.println(GetNominationResultIdQuery);
					ResultSet resultSet4= stmt4.executeQuery(GetNominationResultIdQuery);
					if(resultSet4.next()==true)
					{
						String ResultId = resultSet4.getString("Id");
						System.out.println(ResultId);
						String DeleteQuery12 = "delete from NominationFormResultsDetails where NominationFormResultsId='"+ResultId+"'";
						String DeleteQuery13 = "delete from NominationFormResults where PeopleKey = "+ResourceId+" and SkillId="+PrimarySkillId+"";

						System.out.println(DeleteQuery12);
						System.out.println(DeleteQuery13);

						stmt4.addBatch(DeleteQuery12);
						stmt4.addBatch(DeleteQuery13);
						stmt4.executeBatch();
					}


					String GetNominationReviewDetailsQuery = "select * from NominationFormReviewResults where ResourceId = "+ResourceId+" and SkillId="+PrimarySkillId+"";
					System.out.println(GetNominationReviewDetailsQuery);

					ResultSet resultSet6 = stmt6.executeQuery(GetNominationReviewDetailsQuery);
					if(resultSet6.next()==true)
					{
						String ReviewDetailsId = resultSet6.getString("Id");
						String NominationFormResultsId = resultSet6.getString("NominationFormResultsId");
						System.out.println(ReviewDetailsId);

						String DeleteQuery14 = "delete from NominationFormReviewResultsDetails where NominationFormReviewResultsId = "+ReviewDetailsId+"";	
						String DeleteQuery15 = "delete from NominationFormReviewResults where ResourceId = "+ResourceId+" and SkillId="+PrimarySkillId+"";
						String DeleteQuery16 = "delete from ExpertInterviewApprovalRequest where Interviewreviewresultid = '"+NominationFormResultsId+"'";
						String DeleteQuery17 = "delete from ExpertInterviewApproval where Interviewreviewresultid = '"+NominationFormResultsId+"'";
						String DeleteQuery18 = "delete from ExpertInterviewerEmpMapping where Resourceid = "+ResourceId+" and SkillId="+PrimarySkillId+"";
						System.out.println(DeleteQuery14);
						System.out.println(DeleteQuery15);
						System.out.println(DeleteQuery16);
						System.out.println(DeleteQuery17);
						System.out.println(DeleteQuery18);
						stmt5.addBatch(DeleteQuery14);
						stmt5.addBatch(DeleteQuery15);
						stmt5.addBatch(DeleteQuery16);
						stmt5.addBatch(DeleteQuery17);
						stmt5.addBatch(DeleteQuery18);
						stmt5.executeBatch();
					}
				}
			}
			LPVTest_test.log(Status.PASS,"Existing Nomination Form details for the skill has been deleted");
			con.close();
			LPVTest_report.flush();
		}
		catch(Exception E)
		{
			System.out.println(E);
			LandingPageValidation_GetExtentReports.Exception(driver, LPVTest_test, E);
		}
	}
	
	public static void RSMUpload_TemplateFill(WebDriver driver, ExtentTest LPVTest_test , ExtentReports LPVTest_report, String User, String PriSkill, String SecSkill1, String SecSkill2, String SecSkill3, int secSkillCount)
	{
		try
		{
			Connection con = LandingPageValidation_DatabaseConnectivity.DB_Configuration();

			System.out.println("**********************************************************************************************************");
			System.out.println("\n");
			System.out.println("RSM UPLOAD");
			System.out.println("\n");

			String priQuery = "SELECT * FROM VIW_SKILLINVENTORY_ACTIVE_SKILLS WHERE L5_Name ='"+prop.getProperty(PriSkill)+"'";
			String secQuery1 = "SELECT * FROM VIW_SKILLINVENTORY_ACTIVE_SKILLS WHERE L5_Name ='"+prop.getProperty(SecSkill1)+"'";
			String secQuery2 = "SELECT * FROM VIW_SKILLINVENTORY_ACTIVE_SKILLS WHERE L5_Name ='"+prop.getProperty(SecSkill2)+"'";
			String secQuery3 = "SELECT * FROM VIW_SKILLINVENTORY_ACTIVE_SKILLS WHERE L5_Name ='"+prop.getProperty(SecSkill3)+"'";
			

			System.out.println(priQuery);
			System.out.println(secQuery1);
			System.out.println(secQuery2);
			System.out.println(secQuery3);

			Statement stmt = (Statement) con.createStatement();
			Statement stmt1 = (Statement) con.createStatement();
			Statement stmt2 = (Statement) con.createStatement();
			Statement stmt3 = (Statement) con.createStatement();
			Statement stmt4 = (Statement) con.createStatement();

			ResultSet resultSet= stmt.executeQuery(priQuery);
			ResultSet resultSet1= stmt1.executeQuery(secQuery1);
			ResultSet resultSet2= stmt2.executeQuery(secQuery2);
			ResultSet resultSet3= stmt3.executeQuery(secQuery3);

			

			
			String EmpQuery = "select * from cmm_resource where CRS_ENTERPRISE_ID='"+prop.getProperty(User)+"'";
			System.out.println(EmpQuery);
			ResultSet resultSet4= stmt4.executeQuery(EmpQuery);

			while (resultSet.next() && resultSet1.next() && resultSet2.next() && resultSet3.next() && resultSet4.next())
			{
				String priSkill = resultSet.getString("L5_NAME");
				String secSkill1 = resultSet1.getString("L5_NAME");
				String secSkill2 = resultSet2.getString("L5_NAME");
				String secSkill3 = resultSet3.getString("L5_NAME");

						
				String PersonnelNo = resultSet4.getString("CRS_PERSONNEL_NO");
				System.out.println(priSkill);
				System.out.println(secSkill1);
				System.out.println(secSkill2);
				System.out.println(secSkill3);

				System.out.println(PersonnelNo);

				LandingPageValidation_ExcelHandling.RSMUpload(PersonnelNo,priSkill, secSkill1, secSkill2, secSkill3, 1);
				LPVTest_test.log(Status.PASS,"RSM Template Filled Successfully");
			}
			con.close(); 
		}
		catch(Exception E)
		{
			System.out.println(E);
			LandingPageValidation_GetExtentReports.Exception(driver, LPVTest_test, E);
		}
	}

}
