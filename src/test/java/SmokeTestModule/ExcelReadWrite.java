package SmokeTestModule;

import java.io.File;
import java.io.IOException;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class ExcelReadWrite {
	
	 public void CreateExcel() 
     {
         String path = System.getProperty("user.dir")+"\\TestData\\SmokeTest\\TestOutput.xls";
         try 
         {
			WritableWorkbook workbook = Workbook.createWorkbook(new File(path));
		    WritableSheet sheet = workbook.createSheet("TestCases", 0);
                     
            Label TestcaseId = new Label(0, 0, "TestCaseId");
            Label Browsers = new Label(1, 0, "Browser");
            Label Title = new Label(2, 0, "Title");
            Label ExpectedResult = new Label(3, 0, "ExpectedResult");
            Label ActualResult = new Label(4, 0, "ActualResult");
            Label TestStatus = new Label(5, 0, "TestStatus");

         
            sheet.addCell(TestcaseId);
            sheet.addCell(Browsers);
            sheet.addCell(Title);
            sheet.addCell(ExpectedResult);
            sheet.addCell(ActualResult);
            sheet.addCell(TestStatus);

            
            workbook.write();
            workbook.close();
         } 
         catch (Exception e) 
         {
			e.printStackTrace();
		 }                 

     }
	

	 
	 public void WriteExcel(String TestcaseID, String Browser, String Title, String ExpectedResult, String ActualResult, String TestStatus) 
     {
         String path = System.getProperty("user.dir")+"\\TestData\\SmokeTest\\TestOutput.xls";
         try 
         {
        	 Workbook existingWorkbook = Workbook.getWorkbook(new File(path));
           	 WritableWorkbook workbookCopy = Workbook.createWorkbook(new File(path), existingWorkbook);
        	 WritableSheet Sheet = workbookCopy.getSheet("TestCases");
        	 int size = Sheet.getRows(); 
           	
             Label TestcaseId = new Label(0, size, TestcaseID);
             Label Browsers = new Label(1, size, Browser);
             Label TitleId = new Label(2, size, Title);
             Label ExpectedResults = new Label(3, size, ExpectedResult);
             Label ActualResults = new Label(4, size, ActualResult);
             Label TestStatuss = new Label(5, size, TestStatus);
             
        	 Sheet.addCell(TestcaseId);
             Sheet.addCell(Browsers);
             Sheet.addCell(TitleId);
             Sheet.addCell(ExpectedResults);
             Sheet.addCell(ActualResults);
             Sheet.addCell(TestStatuss);
             
             workbookCopy.write();
             workbookCopy.close();
             existingWorkbook.close();
     
         }
         catch (Exception e) 
         {
			e.printStackTrace();
		 }                 
     }
	 
	 public void ReadExcel(String TestcaseID, String Browser, String ExpectedResult, String ActualResult, String TestStatus) 
     {
         String path = "C:\\Selenium\\TestData\\matrix.xls";
         try 
         {
        	 Workbook existingWorkbook = Workbook.getWorkbook(new File(path));
           	 WritableWorkbook workbookCopy = Workbook.createWorkbook(new File(path), existingWorkbook);
        	 WritableSheet Sheet = workbookCopy.getSheet("Obj_Skill Test");
        	 int size = Sheet.getRows(); 
           	
             Label TestcaseId = new Label(0, size, TestcaseID);
             Label Browsers = new Label(1, size, Browser);
             Label ExpectedResults = new Label(2, size, ExpectedResult);
             Label ActualResults = new Label(3, size, ActualResult);
             Label TestStatuss = new Label(4, size, TestStatus);
             
        	 Sheet.addCell(TestcaseId);
             Sheet.addCell(Browsers);
             Sheet.addCell(ExpectedResults);
             Sheet.addCell(ActualResults);
             Sheet.addCell(TestStatuss);
             
             workbookCopy.write();
             workbookCopy.close();
             existingWorkbook.close();
     
         }
         catch (Exception e) 
         {
			e.printStackTrace();
		 }                 
     }
	 

     
}

