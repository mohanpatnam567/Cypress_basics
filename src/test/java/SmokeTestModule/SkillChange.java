package SmokeTestModule;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import SmokeTestModule.DriverSetup;

public class SkillChange {

	static ExcelReadWrite ExcelObj = new ExcelReadWrite();

	public static void AddSecondarySkillValidations(WebDriver driver, String Browser, String TestCaseID, ExtentTest SmokeTest_test, String Envi)
	{
		SecondarySkillSearch(driver, Browser, TestCaseID, SmokeTest_test);
		MySkillSelection(driver, SmokeTest_test, Envi);
	}	

	public static void ChangePrimarySkillValidations(WebDriver driver, String Browser, String TestCaseID, ExtentTest SmokeTest_test, String Envi)
	{
		PrimarySkillSearch(driver, Browser, TestCaseID, SmokeTest_test);
		MySkillSelection(driver, SmokeTest_test, Envi);
	}	

	public static void ChangeSecondarySkillValidations(WebDriver driver, String Browser, String TestCaseID, ExtentTest SmokeTest_test, String Envi)
	{
		SecondarySkillSearch(driver, Browser, TestCaseID, SmokeTest_test);
		MySkillSelection(driver, SmokeTest_test, Envi);
	}	

	public static void PrimarySkillCardValidation(WebDriver driver, String Browser, String TestCaseID, ExtentTest SmokeTest_test)
	{
		String Title = "HomePage Validation";
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PageObjects.PrimarySkillCardXpath)));
		WebElement PrimarySkillCard = driver.findElement(By.xpath(PageObjects.PrimarySkillCardXpath));

		if (PrimarySkillCard.isDisplayed())
		{
			SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Primary Skill Card is Displayed Correctly");
			ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: Primary SkillCard should be displayed", "The Actual Result is: Primary SkillCard is displayed", "Pass");
		}
		else
		{
			SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Primary Skill Card is NOT Displayed Correctly");
			ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: Primary SkillCard should be displayed", "The Actual Result is: Primary SkillCard is not displayed", "Fail");
		}
	}

	public static void SecondarySkillCardValidation(WebDriver driver, String Browser, String TestCaseID, ExtentTest SmokeTest_test)
	{
		String Title = "HomePage Validation";
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PageObjects.SecondarySkillNameXpath)));
		WebElement SecondarySkillCard = driver.findElement(By.xpath(PageObjects.SecondarySkillNameXpath));

		if (SecondarySkillCard.isDisplayed())
		{
			SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Secondary Skill Card is Displayed for the Employee");
			ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: Secondary SkillCard should be displayed", "The Actual Result is: Secondary SkillCard is displayed", "Pass");
		}
		else
		{
			SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Secondary Skill Card is NOT Displayed for the Employee");
			ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: Secondary SkillCard should be displayed", "The Actual Result is: Secondary SkillCard is not displayed", "Fail");
		}

	}

	public static void PrimarySkillSearch(WebDriver driver, String Browser, String TestCaseID, ExtentTest SmokeTest_test)
	{
		String Title = "Primary Skill Search Validation";
		try
		{
			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PageObjects.PrimarySkillCardXpath)));
			String SkillName = driver.findElement(By.xpath(PageObjects.PrimarySkillNameXpath)).getText();
			
			WebElement PrimarySkill = driver.findElement(By.cssSelector(PageObjects.PrimaryChangeStatusCssSelector));
			executor.executeScript("arguments[0].scrollIntoView(true);", PrimarySkill);
			Thread.sleep(5000);
			
			if (driver.findElements(By.cssSelector(PageObjects.PrimaryChangeStatusCssSelector)).size()!=0)
			{
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Primary Skill Change Icon Is Displayed for the Employee");
				WebElement element = driver.findElement(By.cssSelector(PageObjects.PrimaryChangeStatusCssSelector));
				executor.executeScript("arguments[0].click();", element);
			}
			else
			{
				SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Primary Skill Change Icon Is NOT Displayed for the Employee");
			}
			
			try
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PageObjects.ChangePrimarySkillTextBoxId)));
			}
			catch (Exception e)
			{
				System.out.println(e);
			}
			
			WebElement SkillSearchBox = driver.findElement(By.xpath(PageObjects.ChangePrimarySkillTextBoxId));

			if(SkillSearchBox.isDisplayed())
			{
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Skill Search Box is Displayed for the Employee");
				ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: Skill Search Box should be displayed", "The Actual Result is:" +SkillSearchBox.isDisplayed(), "Pass");

				if(SkillName.contains("Java"))
				{
					
					driver.findElement(By.xpath(PageObjects.ChangePrimarySkillTextBoxId)).sendKeys("SAP for Chemicals Supply Chain Planning & Collaboration");
				} 
				else
				{
					driver.findElement(By.xpath(PageObjects.ChangePrimarySkillTextBoxId)).sendKeys("Microsoft FED Angular");
				}
				driver.findElement(By.xpath(PageObjects.ChangePrimarySkillTextBoxId)).sendKeys(Keys.ENTER);

				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PageObjects.SkillSearchResultCssSelector)));
				WebElement SkillSearchList = driver.findElement(By.cssSelector(PageObjects.SkillSearchResultTitleCssSelector));
				if(SkillSearchList.isDisplayed())
				{
					SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Skill Search List is Displayed For the Employee");
					ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: Skill Search List should be displayed", "The Actual Result is:" +SkillSearchList.isDisplayed(), "Pass");
				}
				else
				{
					SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Skill Search List is NOT Displayed For the Employee");
					ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: Skill Search List should be displayed", "The Actual Result is: Skill Search List is not displayed", "Fail"); 
				}

				WebElement SkillPaginationContent = driver.findElement(By.cssSelector(PageObjects.SkillSearchResultPageinationSelector));
				if(SkillPaginationContent.isDisplayed())
				{
					SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Skill Search Pagination is Displayed For the Employee");
					ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: Skill Pagination Content should be displayed", "The Actual Result is:" +SkillPaginationContent.isDisplayed(), "Pass");
				}
				else
				{
					SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Skill Search Pagination is NOT Displayed For the Employee");
					ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: Skill Pagination Content should be displayed", "The Actual Result is: Skill Pagination Content is not displayed", "Fail"); 
				}

				WebElement SkillResult = driver.findElement(By.cssSelector(PageObjects.SkillSearchResultCssSelector));
				List<WebElement> SkillResultName = driver.findElements(By.cssSelector(PageObjects.SkillSearchResultNameCssSelector));
				if(SkillResult.isDisplayed())
				{
					ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: Skill Search Result should be displayed", "The Actual Result is:" +SkillResult.isDisplayed(), "Pass");
					SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Skill Search Result is Displayed for the Employee");
					for(int i=1; i<=SkillResultName.size(); i++)
					{
						String Name = SkillResultName.get(i-1).getText();
						ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: Skill Search Box should be displayed", "The Actual Result is:" +Name, "Pass");
					}
				}
				else
				{
					SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Skill Search Result is NOT Displayed for the Employee");
					ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: Skill Search Result should be displayed", "The Actual Result is:" +SkillResult.isDisplayed(), "Fail");
				}

				List<WebElement> AllTopicCovered = driver.findElements(By.cssSelector(PageObjects.TopicsCoveredCss));
				for (WebElement TopicCovered : AllTopicCovered)
				{
					WebElement element1 = TopicCovered;
					executor.executeScript("arguments[0].click();", element1);

					try
					{
						wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PageObjects.TopicsCoveredPopUpCss)));
					}
					catch (Exception e)
					{}

					if (driver.findElements((By.cssSelector(PageObjects.TopicsCoveredPopUpCss))).size() != 0)
					{
						try
						{
							wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(PageObjects.SkillLoadingIconXpath)));
						}
						catch (Exception e)
						{}
						SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Topics Covered PopUp is Displayed for the Skill");
					}
					else
					{
						SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Topics Covered PopUp is NOT Displayed for the Skill");
					}
					WebElement CloseBtn = driver.findElement(By.cssSelector(PageObjects.TopicsCoveredCloseBtnCss));
					executor.executeScript("arguments[0].click();", CloseBtn);
				}
			}
		}
		catch(Exception E)
		{
			SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, E.getMessage());
			ExcelObj.WriteExcel(TestCaseID, Browser, "Exception", "The Page should navigate to respective Page", "Exception Ocurred: "+E, "Fail");
		}

	}	

	public static void SecondarySkillSearch(WebDriver driver, String Browser, String TestCaseID, ExtentTest SmokeTest_test)
	{
		String Title = "Secondary Skill Search Validation";
		try
		{
			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PageObjects.SecondarySkillNameXpath)));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			try
			{
				wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(PageObjects.SkillLoadingIconXpath)));
			}
			catch (Exception e)
			{}
			
			WebElement SecondarySkillTitle = driver.findElement(By.cssSelector(PageObjects.PrimarySkilLSection));
			executor.executeScript("window.scrollBy(0,20)", "");
			
			String SkillName = driver.findElement(By.xpath(PageObjects.SecondarySkillNameXpath)).getText();
			WebElement element = driver.findElement(By.cssSelector(PageObjects.AddSecondarySkillCss));
			
			executor.executeScript("arguments[0].click();", element);

			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PageObjects.ChangePrimarySkillTextBoxId)));
			WebElement SkillSearchBox = driver.findElement(By.xpath(PageObjects.ChangePrimarySkillTextBoxId));

			if(SkillSearchBox.isDisplayed())
			{
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Skill Search Box is Displayed for the Employee");
				ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: Skill Search Box should be displayed", "The Actual Result is:" +SkillSearchBox.isDisplayed(), "Pass");

				if(SkillName.contains("Java"))
				{
					driver.findElement(By.xpath(PageObjects.ChangePrimarySkillTextBoxId)).sendKeys("SAP for Chemicals Supply Chain Planning & Collaboration");
				} 
				else
				{
					driver.findElement(By.xpath(PageObjects.ChangePrimarySkillTextBoxId)).sendKeys("Microsoft FED Angular");
				}
				driver.findElement(By.xpath(PageObjects.ChangePrimarySkillTextBoxId)).sendKeys(Keys.ENTER);

				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PageObjects.SkillSearchResultCssSelector)));
				WebElement SkillSearchList = driver.findElement(By.cssSelector(PageObjects.SkillSearchResultTitleCssSelector));
				if(SkillSearchList.isDisplayed())
				{
					SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Skill Search List is Displayed For the Employee");
					ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: Skill Search List should be displayed", "The Actual Result is:" +SkillSearchList.isDisplayed(), "Pass");
				}
				else
				{
					SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Skill Search List is NOT Displayed For the Employee");
					ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: Skill Search List should be displayed", "The Actual Result is: Skill Search List is not displayed", "Fail"); 
				}

				WebElement SkillPaginationContent = driver.findElement(By.cssSelector(PageObjects.SkillSearchResultPageinationSelector));
				if(SkillPaginationContent.isDisplayed())
				{
					SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Skill Search Pagination is Displayed For the Employee");
					ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: Skill Pagination Content should be displayed", "The Actual Result is:" +SkillPaginationContent.isDisplayed(), "Pass");
				}
				else
				{
					SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Skill Search Pagination is NOT Displayed For the Employee");
					ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: Skill Pagination Content should be displayed", "The Actual Result is: Skill Pagination Content is not displayed", "Fail"); 
				}

				WebElement SkillResult = driver.findElement(By.cssSelector(PageObjects.SkillSearchResultCssSelector));
				List<WebElement> SkillResultName = driver.findElements(By.cssSelector(PageObjects.SkillSearchResultNameCssSelector));
				if(SkillResult.isDisplayed())
				{
					ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: Skill Search Result should be displayed", "The Actual Result is:" +SkillResult.isDisplayed(), "Pass");
					SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Skill Search Result is Displayed for the Employee");
					for(int i=1; i<=SkillResultName.size(); i++)
					{
						String Name = SkillResultName.get(i-1).getText();
						ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: Skill Search Box should be displayed", "The Actual Result is:" +Name, "Pass");
					}
				}
				else
				{
					SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Skill Search Result is NOT Displayed for the Employee");
					ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: Skill Search Result should be displayed", "The Actual Result is:" +SkillResult.isDisplayed(), "Fail");
				}

				List<WebElement> AllTopicCovered = driver.findElements(By.cssSelector(PageObjects.TopicsCoveredCss));
				for (WebElement TopicCovered : AllTopicCovered)
				{
					WebElement element1 = TopicCovered;
					executor.executeScript("arguments[0].click();", element1);

					try
					{
						wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PageObjects.TopicsCoveredPopUpCss)));
					}
					catch (Exception e)
					{}

					if (driver.findElements((By.cssSelector(PageObjects.TopicsCoveredPopUpCss))).size() != 0)
					{
						try
						{
							wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(PageObjects.SkillLoadingIconXpath)));
						}
						catch (Exception e)
						{}
						SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Topics Covered PopUp is Displayed for the Skill");
					}
					else
					{
						SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Topics Covered PopUp is NOT Displayed for the Skill");
					}
					WebElement CloseBtn = driver.findElement(By.cssSelector(PageObjects.TopicsCoveredCloseBtnCss));
					executor.executeScript("arguments[0].click();", CloseBtn);
				}
			}
		}
		catch(Exception E)
		{
			SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, E.getMessage());
			ExcelObj.WriteExcel(TestCaseID, Browser, "Exception", "The Page should navigate to respective Page", "Exception Ocurred: "+E, "Fail");
		}
	}

	public void AddSecondarySkillSearch(WebDriver driver, String Browser, String TestCaseID)
	{
		String Title = "Add Secondary Skill";
		try
		{
			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PageObjects.ChangePrimarySkillTextBoxId)));
			WebElement SkillSearchBox = driver.findElement(By.xpath(PageObjects.ChangePrimarySkillTextBoxId));

			if(SkillSearchBox.isDisplayed())
			{
				ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: Skill Search Box should be displayed", "The Actual Result is:" +SkillSearchBox.isDisplayed(), "Pass");
				driver.findElement(By.xpath(PageObjects.ChangePrimarySkillTextBoxId)).sendKeys("Oracle Identity Manager");
			}
		}
		catch(Exception E)
		{
			ExcelObj.WriteExcel(TestCaseID, Browser, "Exception", "The Page should navigate to respective Page", "Exception Ocurred: "+E, "Fail");
		}
		driver.findElement(By.xpath(PageObjects.ChangePrimarySkillTextBoxId)).sendKeys(Keys.ENTER);
	}

	public static void MySkillSelection(WebDriver driver, ExtentTest SmokeTest_test, String Environment)
	{	
		try
		{
			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));		
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PageObjects.SkillSearchResultCssSelector)));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			
			if (driver.findElements(By.xpath(PageObjects.MakePrimarySkillXpath)).size()!=0)
			{
				WebElement PrimaryBtn = driver.findElement(By.xpath(PageObjects.MakePrimarySkillXpath));
				executor.executeScript("arguments[0].click();", PrimaryBtn);
			}
			else
			{
				WebElement SecondaryBtn = driver.findElement(By.xpath(PageObjects.AddSecondarySkillXpath));
				executor.executeScript("arguments[0].click();", SecondaryBtn);
			}
			
			try
			{
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PageObjects.SkillDialogCssSelector)));
				if (driver.findElements(By.cssSelector(PageObjects.SkillDialogCssSelector)).size()!=0)
				{
					SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Skill Change Instructions PopUp is Displayed for the Employee");
				}
				else
				{
					SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Skill Change Instructions PopUp is NOT Displayed for the Employee");
				}
				driver.findElement(By.xpath(PageObjects.SkillDialogCloseButtonXpath)).click();
			}
			catch(Exception E)
			{
				System.out.println(E);
			}

			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PageObjects.ProjectMonthCssSelector)));
			if (driver.findElements(By.xpath(PageObjects.ProjectMonthCssSelector)).size()!=0)
			{
				executor.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(PageObjects.ProjectMonthCssSelector)));
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Project Name Dropdown is Displayed for Skill Change");
				//WebElement ProjName = driver.findElement(By.xpath(PageObjects.ProjectMonthCssSelector));
				//ProjName.sendKeys("CIO MyCompetency");
			}
			else
			{
				SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Project Name Dropdown is NOT Displayed for Skill Change");
			}

			/*
			 * wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
			 * PageObjects.SupervisorEmailFieldCssSelector))); if
			 * (driver.findElements(By.cssSelector(PageObjects.
			 * SupervisorEmailFieldCssSelector)).size()!=0) {
			 * executor.executeScript("arguments[0].scrollIntoView(true);",
			 * driver.findElement(By.cssSelector(PageObjects.SupervisorEmailFieldCssSelector
			 * ))); SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test,
			 * "Supervisor Email Field is Displayed inside Skill Change Page"); if
			 * (Environment.contains("Prod")) {
			 * driver.findElement(By.cssSelector(PageObjects.SupervisorEmailFieldCssSelector
			 * )).sendKeys("vidya.a.subramanian@accenture.com"); } else {
			 * driver.findElement(By.cssSelector(PageObjects.SupervisorEmailFieldCssSelector
			 * )).sendKeys("T02113MyComp0001@accenture.com"); } } else {
			 * SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test,
			 * "Supervisor Email Field is NOT Displayed inside Skill Change Page"); }
			 */
			
			if (Environment.contains("Prod"))
			{
				DriverSetup.ProdNavigation();
			}
			else
			{
				DriverSetup.SiteNavigation();
			}
			
		}
		catch(Exception E)
		{
			System.out.println(E);
		}
	}
	
	
	public static void SkillApprovalPageNaviagtion(WebDriver driver, String Browser, String TestCaseID, ExtentTest SmokeTest_test)
	{
		String Title = "Skill Change Approval Validation";
		try
		{
			if (driver.findElements(By.cssSelector(PageObjects.ApprovalRequestsCssSelector)).size()!=0)
			{
				SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Skill Change Approval Option is Available for the Employee");
				WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PageObjects.ApprovalRequestsCssSelector)));
				WebElement element = driver.findElement(By.cssSelector(PageObjects.ApprovalRequestsCssSelector));
				JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();", element);
					
				try
				{
					wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PageObjects.SkillChangeInstructionPopupCssSelector)));
				}
				catch (Exception e)
				{}
				
				if (driver.findElements(By.cssSelector(PageObjects.SkillChangeInstructionPopupCssSelector)).size()!=0)
				{
					SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Skill Change Instructions PopUp is Displayed");
					if (driver.findElements(By.cssSelector(PageObjects.SkillChangeInstructionPopupCloseBtnCssSelector)).size()!=0)
					{
						SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Skill Change Instructions PopUp Close Button is Displayed");
						WebElement PopUpCloseBtn = driver.findElement(By.cssSelector(PageObjects.SkillChangeInstructionPopupCloseBtnCssSelector));
						executor.executeScript("arguments[0].click();", PopUpCloseBtn);
						wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PageObjects.PendingSkillChangeHeading)));
					}
					else
					{
						SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Skill Change Instructions PopUp Close Button is NOT Displayed");
					}
				}
				else
				{
					SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Skill Change Instructions PopUp is NOT Displayed");
				}
				
				if (driver.findElements(By.cssSelector(PageObjects.PendingSkillChangeTableCssSelector)).size()!=0)
				{
					SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Skill Change Approval data are Displayed for Approver");
					
					List<WebElement> col = driver.findElements(By.cssSelector(PageObjects.PendingSkillChangeRowCssSelector));
					for(WebElement Skill: col)
					{
						List<WebElement> Employees = driver.findElements(By.cssSelector(PageObjects.EmployeeNameCssSelector));
						for (WebElement Employee : Employees)
						{
							try
							{
								SmokeTest_GetExtentReports.PassTestWithoutScreenshot(driver, SmokeTest_test, "Employees in the Approver Bucket are : "+Employee.getText());
								System.out.println(Employee.getText());
							}
							catch (Exception e)
							{
								System.out.println(e);
							}
						}
						
						
						if (driver.findElements(By.cssSelector(PageObjects.EmployeeNameCssSelector)).size()!=0)
						{
							WebElement UserLink = Skill.findElement(By.cssSelector(PageObjects.EmployeeNameCssSelector));
							executor.executeScript("arguments[0].click();", UserLink);
							
							wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PageObjects.ApproalRequestDetailPageHeaderCssSelector)));
							WebElement ApproalRequestDetailPageHeader = driver.findElement(By.cssSelector(PageObjects.ApproalRequestDetailPageHeaderCssSelector));
							if(ApproalRequestDetailPageHeader.isDisplayed())
							{
								SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Skill Change Approval Requests Details Page");
								String UserName = driver.findElement(By.cssSelector(PageObjects.ApproalRequestDetailPageUserNameCssSelector)).getText();
								System.out.println(UserName);
								
								SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "User Info header Displayed "+UserName);
								ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: User Info header should be displayed", "The Actual Result is:" +ApproalRequestDetailPageHeader.isDisplayed(), "Pass");
								ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: UserName should be displayed", "The Actual Result is:" +UserName, "Pass");
							
								WebElement RequestSummary = driver.findElement(By.cssSelector(PageObjects.ApproalRequestDetailPageRequestsummaryCssSelector));
								WebElement UserSummary = driver.findElement(By.cssSelector(PageObjects.ApproalRequestDetailPageUserummaryCssSelector));
								
								if(RequestSummary.isDisplayed())
								{
									SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Request Summary is displayed in the Approval Details Page");
									ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: Request Summary should be displayed", "The Actual Result is:" +RequestSummary.isDisplayed(), "Pass");
								}
								else
								{
									SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Request Summary is NOT displayed in the Approval Details Page");
									ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: Request Summary should be displayed", "The Actual Result is:" +RequestSummary.isDisplayed(), "Fail");	
								}
								
								if(UserSummary.isDisplayed())
								{
									SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "User Summary is displayed in the Approval Details Page");
									ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: User Summary should be displayed", "The Actual Result is:" +UserSummary.isDisplayed(), "Pass");
								}
								else
								{
									SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "User Summary is NOT displayed in the Approval Details Page");
									ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: User Summary should be displayed", "The Actual Result is:" +UserSummary.isDisplayed(), "Fail");
								}

								if (driver.findElements(By.cssSelector(PageObjects.SkillTextCommentCssSelector)).size()!=0)
								{
									SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Skill Approval Requests Details Page Comments Section is Displayed");
									driver.findElement(By.cssSelector(PageObjects.SkillTextCommentCssSelector)).sendKeys("Testing");
								}
								else
								{
									SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Skill Approval Requests Details Page Comments Section is NOT Displayed");
								}
								
								if (driver.findElements(By.cssSelector(PageObjects.SkillApproveButtonCssSelector)).size()!=0)
								{
									SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Skill Approval Details Page Approve Button is Displayed");
									Thread.sleep(3000);
								}
								else
								{
									SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Skill Approval Details Page Approve Button is NOT Displayed");
								}
								
								if (driver.findElements(By.cssSelector(PageObjects.SkillRejectButtonCssSelector)).size()!=0)
								{
									SmokeTest_GetExtentReports.PassTestWithoutScreenshot(driver, SmokeTest_test, "Skill Approval Details Page Reject Button is Displayed");
									Thread.sleep(3000);
								}
								else
								{
									SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Skill Approval Details Page Reject Button is NOT Displayed");
								}
								WebElement ApproveBtn = driver.findElement(By.cssSelector(PageObjects.SkillApproveButtonCssSelector));
								executor.executeScript("arguments[0].click();", ApproveBtn);
								Thread.sleep(3000);
								try
								{
									wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PageObjects.SkillDialogCssSelector)));
								}
								catch (Exception e)
								{}
								
								if (driver.findElements(By.cssSelector(PageObjects.SkillDialogCssSelector)).size()!=0)
								{
									SmokeTest_GetExtentReports.PassTest(driver, SmokeTest_test, "Alert Popup is Displayed when the Approver Click the Approve Button");
								}
								else
								{
									SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Alert Popup is NOT Displayed when the Approver Click the Approve Button");
								}
								driver.findElement(By.cssSelector(PageObjects.SkillChangeConfirmPopUpCancelCss)).click();
								Thread.sleep(3000);
								
								driver.findElement(By.cssSelector(PageObjects.HomePageLogoCssSelector)).click();
							}
							else
							{
								SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Skill Change Approval Requests Details Page is NOT Displayed");
								ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: User Info header should be displayed", "The Actual Result is:" +ApproalRequestDetailPageHeader.isDisplayed(), "Fail");
								driver.findElement(By.cssSelector(PageObjects.SkillChangeConfirmPopUpCancelCss)).click();
							}
							break;
						}
					
					}
				}
				else
				{
					SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Skill Change Approval data are NOT Displayed");
				}
				driver.navigate().back();
			}
			else
			{
				SmokeTest_GetExtentReports.FailTest(driver, SmokeTest_test, "Skill Change Approval Option is NOT Available for the Employee");
			}
		}
		catch(Exception E)
		{
			ExcelObj.WriteExcel(TestCaseID, Browser, Title, "The Expected Result is: Approval should be sucessfully done", "The Actual Result is:" +E, "Fail");

		}
	}

	//************** MENU SORTING - ADMIN LOGIN****************************//

	public static void MenuSorting(WebDriver driver, ExtentTest SkillChangeTest_test,
			ExtentReports SkillChangeTest_report) {
		System.out.println("Menu Sorting Admin Login");
		try {
			System.out.println("ENTERED_Try_Block");
	 Thread.sleep(5000);
			/*WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
			JavascriptExecutor js = (JavascriptExecutor) driver;*/
	      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.cssSelector(PageObjects.HamMenuButtonCssSelector)));
		WebElement element = driver
				.findElement(By.cssSelector(PageObjects.HamMenuButtonCssSelector));
		js.executeScript("arguments[0].click();", element);
		Thread.sleep(5000);
		if (element.isDisplayed()) {
			SmokeTest_GetExtentReports.PassTest(driver, SkillChangeTest_test,
					"Clicked on Hamburger Icon");
		} else {
			SmokeTest_GetExtentReports.FailTest(driver, SkillChangeTest_test,
					"Humburger Icon is not displayed");
		}			
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(PageObjects.EmployeeFunctions)));
		WebElement Employeefunctions = driver.findElement(By.xpath(PageObjects.EmployeeFunctions));
		js.executeScript("arguments[0].click();", Employeefunctions);
		Thread.sleep(5000);
		if (Employeefunctions.isDisplayed()) {
			SmokeTest_GetExtentReports.PassTest(driver, SkillChangeTest_test,
					"List under employee functions is displayed");
		} else {
			SmokeTest_GetExtentReports.FailTest(driver, SkillChangeTest_test,
					"List under employee functions is not displayed");
		}		
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(PageObjects.PendingActions)));
		WebElement Pendingactions = driver.findElement(By.xpath(PageObjects.PendingActions));
		js.executeScript("arguments[0].click();", Pendingactions);
		Thread.sleep(5000);
		if (Pendingactions.isDisplayed()) {
			SmokeTest_GetExtentReports.PassTest(driver, SkillChangeTest_test,
					"List under pending actions is displayed");
		} else {
			SmokeTest_GetExtentReports.FailTest(driver, SkillChangeTest_test,
					"List under pending actions is not displayed");
		}	
		Thread.sleep(1000);
		//List<WebElement> optionList = driver.findElements(By.xpath(PageObjects.PendingActions));
		//js.executeScript("arguments[0].scrollIntoView(true);", optionList.get(9) );
		Actions dragger = new Actions(driver);
	    // drag downwards        
		int numberOfPixelsToDragTheScrollbarDown = 1;
		WebElement ReviewPendingContribution = driver.findElement(By.xpath(PageObjects.ReviewPendingContribution));
	    dragger.moveToElement(ReviewPendingContribution).moveByOffset(0, numberOfPixelsToDragTheScrollbarDown).build().perform();
	    
	    if (ReviewPendingContribution.isDisplayed()) {
			SmokeTest_GetExtentReports.PassTest(driver, SkillChangeTest_test,
					"Scroll to last list on the menu under pending actions");
		} else {
			SmokeTest_GetExtentReports.FailTest(driver, SkillChangeTest_test,
					"Does not Scroll to last list on the menu under pending actions");
		}	
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(PageObjects.AdminFunctions)));
		WebElement Adminfunctions = driver.findElement(By.xpath(PageObjects.AdminFunctions));
	    dragger.moveToElement(Adminfunctions).moveByOffset(0, numberOfPixelsToDragTheScrollbarDown).build().perform();

		js.executeScript("arguments[0].click();", Adminfunctions);
		Thread.sleep(5000);
		if (Adminfunctions.isDisplayed()) {
			SmokeTest_GetExtentReports.PassTest(driver, SkillChangeTest_test,
					"List under Admin Functions is displayed");
		} else {
			SmokeTest_GetExtentReports.FailTest(driver, SkillChangeTest_test,
					"List under Admin Functions is not displayed");
		}	
		Thread.sleep(1000);
	//List<WebElement> OptionList = driver.findElements(By.xpath(PageObjects.AdminFunctions));
		//js.executeScript("arguments[0].scrollIntoView(true);", OptionList.get(1) );
		
		WebElement ReopenSMeEvaluationForm = driver.findElement(By.xpath(PageObjects.ReopenSMEEvaluationForm));
	    dragger.moveToElement(ReopenSMeEvaluationForm).moveByOffset(0, numberOfPixelsToDragTheScrollbarDown).build().perform();
	    
	    if (ReopenSMeEvaluationForm.isDisplayed()) {
			SmokeTest_GetExtentReports.PassTest(driver, SkillChangeTest_test,
					"Scroll to the middle of the menu under Admin Functions");
		} else {
			SmokeTest_GetExtentReports.FailTest(driver, SkillChangeTest_test,
					"Does not scroll to the middle of the menu under Admin Functions");
		}	
	    Thread.sleep(1000);
	    WebElement upload = driver.findElement(By.xpath(PageObjects.upload));
	    dragger.moveToElement(upload).moveByOffset(0, numberOfPixelsToDragTheScrollbarDown).build().perform();
	    
	    if (upload.isDisplayed()) {
			SmokeTest_GetExtentReports.PassTest(driver, SkillChangeTest_test,
					"Scroll to the middle of the menu under Admin Functions");
		} else {
			SmokeTest_GetExtentReports.FailTest(driver, SkillChangeTest_test,
					"Does not scroll to the middle of the menu under Admin Functions");
		}	
		Thread.sleep(1000);
		WebElement Browse = driver.findElement(By.xpath(PageObjects.BrowseSingleSkillInventory));
	    dragger.moveToElement(Browse).moveByOffset(0, numberOfPixelsToDragTheScrollbarDown).build().perform();
	    
	    if (Browse.isDisplayed()) {
			SmokeTest_GetExtentReports.PassTest(driver, SkillChangeTest_test,
					"Scroll to the middle of the menu under Admin Functions");
		} else {
			SmokeTest_GetExtentReports.FailTest(driver, SkillChangeTest_test,
					"Does not scroll to the middle of the menu under Admin Functions");
		}	
	    Thread.sleep(1000);
	    WebElement skillreversal = driver.findElement(By.xpath(PageObjects.SkillChangeReversal));
	    dragger.moveToElement(skillreversal).moveByOffset(0, numberOfPixelsToDragTheScrollbarDown).build().perform();
	    
	    if (skillreversal.isDisplayed()) {
			SmokeTest_GetExtentReports.PassTest(driver, SkillChangeTest_test,
					"Scroll to the last of the menu under Admin Functions");
		} else {
			SmokeTest_GetExtentReports.FailTest(driver, SkillChangeTest_test,
					"Does not scroll to the last of the menu under Admin Functions");
		}	
	    Thread.sleep(1000);
	    WebElement LOGout = driver.findElement(By.xpath(PageObjects.LOGOUT));
	    dragger.moveToElement(LOGout).moveByOffset(0, numberOfPixelsToDragTheScrollbarDown).build().perform();
	    
	    if (LOGout.isDisplayed()) {
			SmokeTest_GetExtentReports.PassTest(driver, SkillChangeTest_test,
					"Scroll to the last menu of hamburger icon");
		} else {
			SmokeTest_GetExtentReports.FailTest(driver, SkillChangeTest_test,
					"Does not scroll to the last menu of hamburger icon");
		}	
	    Thread.sleep(1000);
		}
		catch (Exception e) {
			SmokeTest_GetExtentReports.getResult(e, driver, SkillChangeTest_test);
		}
	}		

	    //**************************** MENU Sorting - EMPLOYEE LOGIN****************//

	public static void MenuSortingEmployee(WebDriver driver, ExtentTest SkillChangeTest_test,
			ExtentReports SkillChangeTest_report) {
		System.out.println("Menu Sorting Employee Login");
		try {
			System.out.println("ENTERED_Try_Block");
	 Thread.sleep(5000);
			/*WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
			JavascriptExecutor js = (JavascriptExecutor) driver;*/
	      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.cssSelector(PageObjects.HamMenuButtonCssSelector)));
		WebElement element = driver
				.findElement(By.cssSelector(PageObjects.HamMenuButtonCssSelector));
		js.executeScript("arguments[0].click();", element);
		Thread.sleep(5000);
		if (element.isDisplayed()) {
			SmokeTest_GetExtentReports.PassTest(driver, SkillChangeTest_test, "Click on the HamMenuButton");		
		} else {
			SmokeTest_GetExtentReports.FailTest(driver, SkillChangeTest_test,
					"Humburger Icon is not displayed");
		}			
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(PageObjects.EmployeeFunctions)));
		WebElement Employeefunctions = driver.findElement(By.xpath(PageObjects.EmployeeFunctions));
		js.executeScript("arguments[0].click();", Employeefunctions);
		Thread.sleep(5000);
		if (Employeefunctions.isDisplayed()) {
			SmokeTest_GetExtentReports.PassTest(driver, SkillChangeTest_test,
					"List under employee functions is displayed");
		} else {
			SmokeTest_GetExtentReports.FailTest(driver, SkillChangeTest_test,
					"List under employee functions is not displayed");
		}		
		Thread.sleep(1000);
		Actions dragger = new Actions(driver);
	    // drag downwards        
		int numberOfPixelsToDragTheScrollbarDown = 1;
		WebElement LOGOut = driver.findElement(By.xpath(PageObjects.LOGOUT));
	    dragger.moveToElement(LOGOut).moveByOffset(0, numberOfPixelsToDragTheScrollbarDown).build().perform();
	    
	    if (LOGOut.isDisplayed()) {
	    	SmokeTest_GetExtentReports.PassTest(driver, SkillChangeTest_test,
					"Scroll to the last menu of hamburger icon");
		} else {
			SmokeTest_GetExtentReports.FailTest(driver, SkillChangeTest_test,
					"Does not scroll to the last menu of hamburger icon");
		}	
	    Thread.sleep(1000);
		}
		catch (Exception e) {
			SmokeTest_GetExtentReports.getResult(e, driver, SkillChangeTest_test);
		}
	}		

	}

