package SmokeTestModule;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

public class SkillApproval {
	
	static ExcelReadWrite ExcelObj = new ExcelReadWrite();
	
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
	

}
