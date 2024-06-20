package LandingPageValidation;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import CommonMethods.PropertyfileConfig;




public class LandingPageValidation_ExcelHandling {
	static Properties prop = PropertyfileConfig.Propertyfile();	


	public static void RSMUpload(String PersonnelNo,String priSkill, String secSkill1, String secSkill2, String secSkill3, int secSkillCount) 
	{ 
		String Path = System.getProperty("user.dir")+"\\TestData\\Master Assessment\\Resource_Skill_Mapping.xlsx";
		try
		{
			File file=new File(Path);
			FileInputStream fis = new FileInputStream(file);
			XSSFWorkbook wb1 = new XSSFWorkbook(fis);
			XSSFSheet sh = wb1.getSheet("Resource_Skill_Mapping");

			if(secSkillCount>1) {
				sh.getRow(1).createCell(0).setCellValue(PersonnelNo);
				sh.getRow(1).createCell(1).setCellValue("P");
				sh.getRow(1).createCell(2).setCellValue(priSkill);
				sh.getRow(1).createCell(3).setCellValue("Add");

				sh.getRow(2).createCell(0).setCellValue(PersonnelNo);
				sh.getRow(2).createCell(1).setCellValue("E");
				sh.getRow(2).createCell(2).setCellValue(secSkill1);
				sh.getRow(2).createCell(3).setCellValue("Add");

				sh.getRow(3).createCell(0).setCellValue(PersonnelNo);
				sh.getRow(3).createCell(1).setCellValue("E");
				sh.getRow(3).createCell(2).setCellValue(secSkill2);
				sh.getRow(3).createCell(3).setCellValue("Add");

				sh.getRow(4).createCell(0).setCellValue(PersonnelNo);
				sh.getRow(4).createCell(1).setCellValue("E");
				sh.getRow(4).createCell(2).setCellValue(secSkill3);
				sh.getRow(4).createCell(3).setCellValue("Add");
			}else if (secSkillCount==1){

				sh.getRow(1).createCell(0).setCellValue(PersonnelNo);
				sh.getRow(1).createCell(1).setCellValue("P");
				sh.getRow(1).createCell(2).setCellValue(priSkill);
				sh.getRow(1).createCell(3).setCellValue("Add");

				sh.getRow(2).createCell(0).setCellValue(PersonnelNo);
				sh.getRow(2).createCell(1).setCellValue("E");
				sh.getRow(2).createCell(2).setCellValue(secSkill1);
				sh.getRow(2).createCell(3).setCellValue("Add");

				sh.getRow(3).createCell(0).setCellValue("");
				sh.getRow(3).createCell(1).setCellValue("");
				sh.getRow(3).createCell(2).setCellValue("");
				sh.getRow(3).createCell(3).setCellValue("");

				sh.getRow(4).createCell(0).setCellValue("");
				sh.getRow(4).createCell(1).setCellValue("");
				sh.getRow(4).createCell(2).setCellValue("");
				sh.getRow(4).createCell(3).setCellValue("");
			}
			else {
				sh.getRow(1).createCell(0).setCellValue(PersonnelNo);
				sh.getRow(1).createCell(1).setCellValue("P");
				sh.getRow(1).createCell(2).setCellValue(priSkill);
				sh.getRow(1).createCell(3).setCellValue("Add");

				sh.getRow(2).createCell(0).setCellValue("");
				sh.getRow(2).createCell(1).setCellValue("");
				sh.getRow(2).createCell(2).setCellValue("");
				sh.getRow(2).createCell(3).setCellValue("");

				sh.getRow(3).createCell(0).setCellValue("");
				sh.getRow(3).createCell(1).setCellValue("");
				sh.getRow(3).createCell(2).setCellValue("");
				sh.getRow(3).createCell(3).setCellValue("");

				sh.getRow(4).createCell(0).setCellValue("");
				sh.getRow(4).createCell(1).setCellValue("");
				sh.getRow(4).createCell(2).setCellValue("");
				sh.getRow(4).createCell(3).setCellValue("");
			}

			FileOutputStream fos = new FileOutputStream(Path);
			wb1.write(fos);
			wb1.close();

			System.out.println("Values saved in RSM Template");
		}

		catch (Exception e) 
		{
			e.printStackTrace();
		}                 
	}
}

