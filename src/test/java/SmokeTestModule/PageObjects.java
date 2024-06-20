package SmokeTestModule;

import org.openqa.selenium.By;

public class PageObjects 

{
	/*********Skill Card Name Objects*********************/
	public static String PrimarySkillNameXpath = "(//a[contains(@class,'skill-name')])[1]";
	public static String SecondarySkillNameXpath = "(//a[contains(@class,'skill-name')])[3]";
	public static String SkillLoadingIconXpath = "//*[@class='loader']";
	
	/*********Proficiency Objects*********************/
	public static String PrimaryProficiencyXpath = "(//span[@class='sr-only' and contains(text(), 'Current')])[1]";
	public static String SecondaryProficiencyXpath = "(//span[@class='sr-only' and contains(text(), 'Current')])[2]";
	public static String PrimarySkilLSection = "p[class*='section-title']";
	public static String SecondarySkilLSection = "p[class*='section-title'] span";

	/*********Notification Bar Objects*********************/
	public static String PlannedDownTimeXpath = "//div[contains(text(),'Planned Downtime')]";
	public static String PlannedDownTimeCloseBtnXpath = "//div[contains(@class,'acn-alert-close')]";
	
	/**********OverallAssessmentStatus Objects***************/
	public static String PrimaryOverallAssessmentStatusXpath = "(//div[contains(@class,'card-footer-inner')]/span)[1]";
	public static String SecondaryOverallAssessmentStatusXpath = "(//div[contains(@class,'card-footer-inner')]/span)[2]";
	public static String PrimaryUndoSkillStatusXpath = "(//div[contains(@class,'card-footer-inner')]/button/span)[1]";
	public static String SecondaryUndoSkillStatusXpath = "(//div[contains(@class,'card-footer-inner')]/button/span)[2]";
	public static String PrimaryInitiateButtonStatusXpath = "(//div[contains(@class,'action-item')]/div/a)[1]";
	public static String SecondaryInitiateButtonStatusXpath = "(//div[contains(@class,'action-item')]/div/a)[2]";
	
	/**********Last Assessed Status Objects***************/
	public static String PrimaryLastAssessedStatusCssSelector = "p[class*='skill-expiry']";
	public static String SecondaryLastAssessedStatusCssSelector = "p[class*='skill-expiry']";
	
	/***********Pin & Trash Objects******************/
	public static String SecondaryTrashbinStatusCssSelector = "button[class*='mycomp-icon-delete btn btn']";
	public static String CnfCheckBox = "//span[@class='custom-control-indicator']";
	public static String ProceedBtn = "//button[@class='btn btn-mycomp-primary']";
	public static String RsnForSkillDlt = "//div[@class='modal-title pull-left']";
	public static String RsnSelect = "//div[@class='ng-input']";
	public static String DeleteRsnOpt1 = "(//div[@class='ng-option'])[5]";
	public static String PrimaryChangeStatusCssSelector = "button[id*='changekill']";
	public static String SecondarySkillSwapStatusCssSelector = "button[class*='mycomp-icon-Swap btn btn']";
	public static String SecondarySkillSwapPopUpCssSelector = "div[class*='modal-header']";
	public static String SecondarySkillSwapPopUpMonthDropdownCssSelector = "div[class*='ng-select-container']";
	public static String DeletePinStatusCssSelector = "button[class*=delete]";
	public static String DeleteSkillPopupCssSelector = "div[class*=modal-content]";
	public static String DeleteSkillPopupCloseCss = "button[class*='btn btn-link'] span[class*='acn-cross deletepopup']";
	public static String SkillSwapPopupCloseCss = "button[class*='close'] span[class*='acn-cross']";
	public static String SubmitRequestButtonCss = "button[class*='btn btn-primary']";
	public static String SkillSwapPopupTextCss = "textarea[id*='other']";
	public static String SkillSwapDropDownOptionCss = "div[class*='ng-option']";
	public static String TotalExp = "//input[@name='monthexp']";
	public static String ReasoonForSkillChange = "//input[@id='skillSwapReason']";
	public static String ReasoonForSkillChangeOption1 = "(//div[@class='ng-option ng-star-inserted'])[1]";


	

	/********Login Page Variables**********************/	
	public static String UserNameInputId = "userNameInput";
	public static String PasswordInputId = "passwordInput";
	public static String SignInButtonId = "submitButton";
	
	/*************MyCompetency Menu Objects************/
	public static String ApprovalRequestmenuCssSelector = "a[href*=approval-requests]";
	public static String SkillHistorymenuCssSelector = "a[href*=skill-history]";
	public static String HamMenuButtonCssSelector = "i[class*=acn-menu]";
	public static String ExtraAutenticationPopup = "//div[@class='form-group']//a[contains(text(),'Not now')]";
	public static String MainMenuSectionCssselector = "ul[class*=dropdown-menu-right]";
	public static String SelfServiceReportOptionXpath = "//li[contains(@class,'nav-item')]//a[contains(text(),'Self')]";
	public static String MainMenuListCssselector = "ul[class*=dropdown-menu-right] li a";
	public static String LogoutButtonCssselector = "a[href*=signout]";
	public static String AdminMenuCssselector = "ul[class*=dropdown-menu-right] li[class*=list-group]";
	public static String AdminMenuUploadCssselector = "ul[class*=dropdown-menu-right] li[class*=list-group] a[href*=upload]";
	public static String AssessmentSettingsMenuCssselector = "ul[class*=dropdown-menu-right] a[href*=assessmentconfig]";
	public static String MySkillButtonCssselector = "div[id=menu]>ul>li>a[href*=MySkills]";
	public static String SkillApprovalButtonCssselector = "a[href*=PendingSkillChangeApprovals]";
	public static String SkillApprovalPageCloseBtnCssselector = "span[class*='acn-cross deletepopup-close']";
	public static String CertiPopupCloseBtnCssselector = "div[class*='modal-footer border-0']>button";
	public static String CertiPopupCssselector = "div[id*='impNote_certification']";

	/**************Primary Skill Card Objects****************/
	public static String PrimarySkillCardXpath = "(//div[contains(@class,'primary-skill-container')])[1]";
	public static String PrimarySkillCardSectionXpath = "(//div[@class='card-block'])[1]";
	public static String ChangePrimarySkillButtonXpath = "(//span[@class='acn-edit'])[1]";
	public static String PrimarySkillSectionCss = "div[class^='primary-skill-container']";
	
	/**************Secondary Skill Card Objects****************/
	public static String SecondarySkillCardCss = "div[class*='secondary-skill-container-data']>div:nth-child(1)";
	public static String SecondarySkillCardSectionCss = "div[class*='secondary-skill-container-data']";
	public static String AddSecondarySkillCss = "button[class*='btn btn-link btn-link-custom no-transform']";
	
	/**************MySkill Page Objects****************/
	public static String ChangePrimarySkillTextBoxId = "//input[@id='searchSkill']";
	public static String SkillGridCssSelector = "div[class='row filter-section']>div";
	public static String SkillNameSectionCssSelector = "div[class='row filter-section']>div>div[class*=right]";
	public static String SkillSelectionXpath = "//a[text()='Oracle Identity Manager']";
	public static String MakePrimarySkillXpath = "//button[contains(text(),'Make primary skill')]";
	public static String AddSecondarySkillXpath = "//button[contains(text(),'Add secondary skill')]";
	public static String ProjectMonthCssSelector = "//input[@id='projectnames']";
	public static String SupervisorEmailFieldCssSelector = "input[id=supervisorMail]";
	public static String StartDateCssSelector = "button[aria-label*=Start]";
	public static String StartDatePickerCssSelector = "ngb-datepicker[class*=dropdown-menu]";
	public static String StartDateYearCssSelector = "ngb-datepicker-navigation-select>select:nth-child(2)";
	public static String StartDateSelectCssSelector = "div:nth-child(5)>div:nth-child(5)>div";
	public static String EndDateName = "endDate";
	public static String ProjectNameId = "projectname";
	public static String SkillChangeTxtCommentId = "changeReason";
	public static String SkillExperienceCommentId = "skillTotalEx";
	public static String CertificationDetailCommentId = "trainingDetails";
	public static String SkillSaveButtonCssSelector = "button[class*=btn-primary]";
	public static String SkillDialogCssSelector = "div[class*=dialog] div[class*='modal-content']";
	public static String SkillDialogOkButtonXpath = "//button[contains(text(),'OK')]";   
	public static String SkillDialogCloseButtonXpath = "//button[contains(text(),'I Understand')]"; 
	public static String SkillCommenttxtCssSelector = "div[class*=dialog] textarea";
	public static String SkillDialogConfirmButtonXpath ="//button[contains(text(),'OK')]";
	public static String AssessmentSettingsPageOptionsXpath = "//table[contains(@class,'table table-bordered')]/tbody/tr/td[2]";

	public static String SkillChangeConfirmationCss = "div[class*='ng-star-inserted'] div[class*='modal-header']";

	
	public static String SkillChangeConfirmPopUpCancelCss = "div[class*='modal-footer border'] button[class*='btn btn-primary2']";
	
	/*************Skill Guidance Startup Page Objects************/
	public static String SkillAcceleratorGuideRecommendedSectionCss = "section[class='recommended-section']";
	public static String SkillAcceleratorGuideHeadingCss = "h2[class*='section-title section-title']";
	public static String SAGDescriptionCss = "div[class*='section-sub-title section-sub']";
	public static String RecommendedSkillinSAGCss = "section[class='recommended-section']>div[class='row']";
	public static String RecommendedSkillPaginationCss = "div[class*='recommended-skill-pagination']";
	public static String SAGAddtoSecondaryBtnCss = "div[class*='action-btns d-flex']>button>a";
	public static String SAGFeedBackSectionCss = "div[class*='action-btns d-flex']>div";
	public static String SAGTrendGraphButtonCss = "button[class*='graph-btn acn-graph']";
	public static String SAGTrendGraphPopUpCss = "div[class*='modal-content']";
	public static String DemandTrendYearlyCss = "div[class*='d-flex mb-4']>button:nth-child(1)";
	public static String DemandTrendQuaterlyCss = "div[class*='d-flex mb-4']>button:nth-child(2)";
	public static String DemandTrendMonthlyCss = "div[class*='d-flex mb-4']>button:nth-child(3)";
	public static String DemandTrendLineGraphCss = "div[class*='graph-container']";
	public static String DemandTrendCloseBtnCss = "span[class*='acn-cross']";
	public static String NoSAGSkill = "//p[@class='recommended-skill-modal-text']";
	
	/**************MySkill Page Objects(Supervisor)****************/
	public static String ApprovalRequestsCssSelector = "li[class*='nav-item']>a[href*=approval-requests]";
	public static String PendingSkillChangeTableCssSelector = "div[class*=visible]";
	public static String PendingSkillChangeRowCssSelector = "datatable-scroller[class*=datatable-scroll]>datatable-row-wrapper";
	public static String SkillChangeInstructionPopupCssSelector = "div[id*=importantnotes]";
	public static String SkillChangeInstructionPopupCloseBtnCssSelector = "div[class*='modal-footer border']>button";
	
	public static String PendingSkillChangeHeading = "h1[class*=approval-head]";
	public static String EmployeeNameCssSelector = "div[class*=user-details]>div>a";
	public static String SkillCheckBoxCssSelector = "div[role*=gridcell]>span>span>span[class*=checkbox-unchecked]";
	public static String SkillTextCommentCssSelector = "textarea[id*=usercomments]";
	public static String SkillApproveButtonCssSelector = "button[class='btn btn-primary']";
	public static String SkillRejectButtonCssSelector = "button[class='btn btn-primary2 mr-3']";
	public static String UserImageId = "imgId";
	public static String ApproalRequestDetailPageHeaderCssSelector = "div[class*=request-details-header]";
	public static String ApproalRequestDetailPageUserNameCssSelector = "div[class*=request-details-header] h2";
	public static String ApproalRequestDetailPageRequestsummaryCssSelector = "div[class*=request-summary]";
	public static String ApproalRequestDetailPageUserummaryCssSelector = "div[class*=user-summary]";
	public static String ApproalRequestDetailPageBackCssSelector = "a[class*=back-to-home]";
	
	/*****************Mettl Page Objects*************************/
	public static String AssessmentCssSelector = "input[id*=assessment]";
	public static String StartAssessmentButtonCssSelector = "button[class*=assessmentBtn]";
	public static String StartAssessmentNextButtonCssSelector = "button[type*=button]";
	public static String AssessmentStartButtonCssSelector = "button[class='btn btn-primary _start-test ng-isolate-scope']";
	public static String AssessmentTestAnswerXpath1 = "(//input[@type='checkbox'])[1]";
	public static String AssessmentTestAnswerXpath2 = "(//input[@type='checkbox'])[2]";
	public static String FinishAssessmentbuttonCssSelector = "div[class='inline test-header pull-left']>button[type*=button]";
	public static String FinishAssessmentConirmationDialogCssSelector = "div[class*=modal] div[class*=content]";
	public static String FinishAssessmentOKButtonCssSelector = "div[class*=modal] button:nth-child(2)";
	
	public static String TakeSampleAssessmentBtnXpath = "//a[contains(@class,'sub-action-item')]";
	public static String SamplePageInstructionXpath = "//h1[contains(@class,'guidliness-title')]";
	public static String IAcceptCheckBoxXpath = "//span[contains(@class,'custom-control-indicator')]";
	public static String StartAssessmentBtnXpath = "(//button[contains(@class,'btn btn-primary')])";

	public static String MettlPageStartNextBtnXpath = "(//button[contains(@class,'btn btn-primary')])[1]";
	public static String MettlPageStartTestBtnXpath = "(//button[contains(@class,'btn btn-primary')])[1]";
	public static String MettlPageQuestionSectionXpath = "(//div[contains(@id,'section-pane')])";
	public static String MettlPageQ1Option1BtnXpath = "(//input[contains(@name,'response0')])[1]";
	public static String MettlPageQ2Option1BtnXpath = "(//input[contains(@name,'response1')])[1]";
	public static String MettlPageQ31Option1BtnXpath = "(//input[contains(@name,'response2')])[1]";
	public static String MettlPageQ4Option1BtnXpath = "(//input[contains(@name,'response3')])[1]";
	public static String MettlPageQ5Option1BtnXpath = "(//input[contains(@name,'response4')])[1]";
	public static String MettlPageQuestion2BtnXpath = "//a[@aria-label='Question 2']";
	public static String MettlPageQuestion3BtnXpath = "//a[@aria-label='Question 3']";
	public static String MettlPageQuestion4BtnXpath = "//a[@aria-label='Question 4']";
	public static String MettlPageQuestion5BtnXpath = "//a[@aria-label='Question 5']";
	public static String MettlPageNextBtnXpath = "(//button[contains(@class,'btn btn-primary')])[1]";
	public static String MettlPageFinishBtnCss = "div[class*='modal-footer text'] button[data-name*='Yes, Finish']";
	public static String MettlPageFinishTestButton = "//div[contains(@class,'inline test-header pull')]//button[contains(@class,'btn btn-default') and contains(text(),'Finish Test')]";
	public static String FinishTestPopupTitleXpath = "//div[@class='modal-header']";
	public static String FinishTestPopUpFinishBtnXpath = "(//button[@class='btn btn-default'])[2]";
	public static String ThankYouFeedBackXpath = "//span[@class='completiontest_text']";

	
	/*****************Upload Page Objects*************************/
	public static String DropDownId = "ContentPlaceHolder1_CboUpload";
	public static String SearchButtonId = "ContentPlaceHolder1_BtnGo";
	public static String TableId = "ContentPlaceHolder1_TblUpload";
	public static String FileUploadButtonId = "ContentPlaceHolder1_UpdDetails_FileUpload";
	public static String UploadButtonId = "ContentPlaceHolder1_UpdDetails_BtnUpload";
	public static String ResultTableId = "ContentPlaceHolder1_UpdDetails_DtgUploadResults";
	public static String UploadOptionsCss = "select#ContentPlaceHolder1_CboUpload option";
	public static String UploadErrorStatusCssSelector = "table[class*=TableBorder]>tbody>tr[class*=ItemStyle]>td";
	public static String UploadErrorCssSelector = "table[class*=TableBorder]>tbody>tr[class*=ItemStyle]>td:nth-child(9)";
	
	/*****************Home Page Objects*************************/
	public static String HomePageLogoCssSelector = "a[class*='navbar-brand mr-auto']";
	public static String OldHomePageLogoCssSelector = "header[id*=header] a[href*=home]";
	public static String HomePageLogoCssInSSReportPage = "a[class*='header-title']";
	public static String ProfileSectionCssSelector = "div[class*=profile-info]";
	public static String SupervisorXpath = "//span[contains(text(),'Your supervisor')]";
	public static String CarouselCssSelector = "div[class*='modal-header border-0']";
	public static String CarouselclosebuttonCssSelector = "a[class*='nav-link display']";
	public static String HomePageCarouselCssSelector = "a[class*='nav-link display']";
	public static String KnowMyCompTabInAbt = "a[id*='ngb-tab-2']";
	public static String HowItWorkTabInAbt = "a[id*='ngb-tab-3']";
	public static String CertRoadMap = "a[id*='ngb-tab-4']";
	public static String OtherResourceTabInAbt = "a[id*='ngb-tab-5']";
	
	public static String CloseButtoninAbotPopup = "span[class*='acn-cross']";
	public static String LearnAboutMyCompetencyButtonCssSelector = "button[class*='nav-link mr-4']";
	public static String SupervisorNameClickCssSelector = "a[title*='Update Supervisor']";
	public static String DIPAImageCssSelector = "img[class*=chat-background]";
	
	/*****************Skill Journey Page Objects*************************/
	public static String SkillJourneyPageTitleCssSelector = "div[class*='banner-div d-flex']";
	public static String SkillJourneyPageRatingCssSelector = "div[class*=rating-star]";
	public static String SkillJourneyPageAssessmentStatusCssSelector = "div[class*=skill-qualification]";
	public static String SkillJourneyPageSkillSummaryCssSelector = "div[class*=skill-summary]";
	public static String SkillLoadingIconInJourney = "i[class*='fa fa-spinner']";
	public static String LearningRoadMap = "a[class*='btn btn-link text']";
	public static String LearningRoadMapPage = "ul[class*='nav nav-pills justify']";
	public static String LearningRoadMapSection = "div[class*='road-map-container']";
	public static String LearningRoadMapProficiency = "h3[class*='page-title mb']";
	public static String LearningRoadMapProficiencyP1Xpath = "//h3[@class='page-title mb-1' and contains(text(),'P1')]";
	public static String LearningRoadMapProficiencyP2Xpath = "//h3[@class='page-title mb-1' and contains(text(),'P2')]";
	public static String LearningRoadMapProficiencyP5Xpath = "//h3[@class='page-title mb-1' and contains(text(),'P5')]";
	public static String LearningRoadMapProficiencyP2 = "a[id*='tab-selectbyid2']";
	public static String LearningRoadMapProficiencyP3 = "a[id*='tab-selectbyid3']";
	public static String LearningRoadMapProficiencyP5 = "a[id*='tab-selectbyid5']";

	/*****************Learning path Objects*************************/
	public static String ViewLearningPathLinkXpath = "(//div[contains(@class,'skill-card')]//span[contains(@class,'learning-path')])[4]";
	public static String LearningPathPageCssSelector = "div[class*=learning-path] span[class*=sub-head-title]";
	public static String LearningPathPageDropDownCssSelector = "span[id*=container]";
	public static String FilterCssSelector = "div[class*=filter-top]";
	public static String SkillCourseDetailsCssSelector = "div[class*=skill-course]";
	public static String ViewCourseDetailButtonXpath = "//button[contains(text(),'View Course Details')]";
	
	/********************Assessment Page Objects*************************/
	public static String AssessmentPageTitleCssSelector = "div[class*=main] div[class*=container] h2";
	public static String AssessmentPageMainTableCssSelector = "div[class*=main] div[class*=container] table";
	public static String AssessmentPageAccordionCssSelector = "div[class*=accordionPanel] div[class*=reset]";
	public static String AssessmentPageFirstAccordionCssSelector = "div[class*=accordionPanel] div[class*=reset] div";
	public static String AssessmentPageUpdateButtonCssSelector = "div[class*=btn-row] button:nth-child(1)";
	public static String AssessmentPageResetButtonCssSelector = "div[class*=btn-row] button:nth-child(2)";
		
	/********************My Skill History Page Objects*************************/
	public static String SkillHistoryTitleCssSelector = "h1[class*=approval-head]";
	public static String AllSkillTabCssSelector = "a[id*=ngb-tab-0]";
	public static String PrimarySkillTabCssSelector = "a[id*=ngb-tab-1]";
	public static String SecondarySkillTabCssSelector = "a[id*=ngb-tab-2]";
	public static String SkillGridXpath = "//datatable-body[@role='rowgroup']";
	public static String RecordCountDropDownCssSelector = "div[class*=ng-select-container]";
	public static String PaginationContentCssSelector = "ul[class*=pagination]";
	
	/********************Add Secondary Skill Objects*************************/
	public static String AddSecondarySkillCssSelector = "button[class*='btn btn-link btn-link-custom no-transform']";
	
	/********************Skill Search Page Objects*************************/
	public static String SkillSearchPageFilterCssSelector = "div[class*=float-left]";
	public static String SkillSearchFilterListCssSelector = "ul[class*=list-group]";
	public static String SkillSearchFilterNameCssSelector = "ul[class*=list-group]>li>a";
	public static String SkillSearchResultCssSelector = "div[class*='search-results-container']";
	public static String SkillSearchResultNameCssSelector = "div[class*='search-results-container'] a[class*='d-inline-block']";
	public static String SkillSearchResultLocationCssSelector = "span[class*=skill-technology] p";
	public static String SkillSearchResultTitleCssSelector = "p[class*='result-found-label']";
	public static String SkillSearchResultPageinationSelector = "ul[class*=pagination]";
	public static String TopicsCoveredCss = "button[class*='topics-covered btn']";
	public static String TopicsCoveredPopUpCss = "div[class*='modal-content']";
	public static String TopicsCoveredCloseBtnCss = "div[class*='modal-footer border'] button[class*='btn btn-primary']";
	
	/********************How It Works Page Objects*************************/
	public static String SearchFieldCssSelector = "div[class*=sub-head-section]";
	public static String SearchResultCssSelector = "table[class*=table]";
	
	/********************DIPA Page Objects*************************/
	public static String DIPAPopupCssSelector = "div[class*=carousel-container-modal] div[id*=tutorialModel]";
	public static String DIPAPopupCloseButtonCssSelector = "div[id*=tutorialModel] button[class*=acc-close]";
	public static String DIPAHomepageLogoCssSelector = "img[src*=DIPABrand]";
	
	/********************Symantec Popup Objects*************************/
	public static String SymantecPopupCssSelector = "div[class*=symc2]";
	public static String SecurityCodeCssSelector = "div[id*=vipRightPanel] a";
	public static String SecurityCode_SMSId = "vipSend";
	public static String UseSecurityCodeCss = "a[id='skip']";
	public static String ConfirmIdentiyCss = "div#vipDialogIdentityText";
	public static String OtpInputCss = "input#otpInput";
	public static String ContinueBtnCss = "input#vipSubmitOTP";
	public static String SymentecCodeResendCss = "a[id='resend']";
	public static String SymentecDevice = "div[class='vipMoNameCenter']";
	public static String SecurityCodeContinueButtonId = "vipSubmitOTP";
	public static String SecurityCodeInputFieldId = "otpInput";
	public static String RememberDeviceCss = "div[id='vipDialogRememberTitleText']";
	public static String SkipBtn = "input[id='vipSkipBtn']";
	public static String RememberBtn = "input[id='vipNext']";
	public static String HomepageBannerCss = "div[class*='banner-div']";
	public static String AccentureAccountFieldCssSelector = "div[tabindex='2'] span[class*=indentNonCollapsible]";
	
	/********************Delete Skill Objects*************************/
	public static String DeleteSkillCommentCssSelector = "textarea[class*=ng]";
	public static String OKButtonXpath = "//button[contains(text(),'Okay')]";
	public static String CloseButtonXpath = "//button[contains(@class,'btn btn-mycomp-secondary') and text()='Cancel']";

	/********************Self Service Report Objects*************************/
	public static String SelfServiceMainPageTitleCss = "div[class *= 'home-title']";
	public static String ReportDownloadXpath = "//div[@class = 'card']//footer[contains(text(),'Report down')]";
	public static String SearchBoxDropdownCss = "label[class *= 'ui-dropdown-label']";
	public static String ExecuteButtonXpath = "(//button[@class= 'btn btn-primary'])[1]";
	public static String RefreshButtonXpath = "(//button[@class= 'btn btn-primary'])[2]";
	public static String myCompHomepageLinkCss = "a[class *= 'header-title']";
	public static String SelfSeriveResultsXpath = "(//ul[contains(@class,'report-list')])[1]";
	public static String SelfSeriveResultsFirstRowXpath = "(//li[contains(@class,'report-list')])[2]";
	public static String SelfSeriveResultsFirstRowReportNameXpath = "(//li[contains(@class,'report-list')])[2]//div//span[@class='ng-star-inserted']";
	public static String SelfSeriveResultsFirstRowReportStatusXpath = "((//li[contains(@class,'report-list')])[2]//div)[5]";
	public static String SelfSeriveResultsFirstRowReportRunByXpath = "((//li[contains(@class,'report-list')])[2]//div)[3]";
	public static String SelfSeriveResultsFirstRowReportDateXpath = "((//li[contains(@class,'report-list')])[2]//div)[4]";
	public static String SelfSeriveResultsFirstRowReportDownloadXpath = "(//li[contains(@class,'report-list')])[2]//div//span[contains(@class,'fa fa-download')]";
	public static String SelfSeriveResultsFirstRowRunStatusXpath = "(//li[contains(@class,'report-list')])[2]//div[5]";
	public static String SelfSeriveAllReportXpath = "//div//span[@class='ng-star-inserted']";
	public static String SelfSeriveSearchBoxXpath = "//input[contains(@class,'ui-dropdown-filter')]";
	public static String SelfSeriveDropDownOptionsXpath = "//li[contains(@class,'dropdown-item')]//span[contains(@class,'ng-star-inserted')]";
	public static String SelfSeriveDropdownFirstOptionXpath = "//li[contains(@class,'ui-dropdown-item')]";

	/********************Feedback and Footer Objects*************************/
	public static String FooterCssSelector = "footer[class*='position-absolute']";
	public static String DipaHomePageCssSelector = "a[class*='floating-dipa']";
	public static String TechnicalIssueCssSelector = "div[class*='technical-issue']";
	public static String QueriesCssSelector = "div[class*='queries d-inline']";
	public static String TechnicalIssueXpathLink = "//div[contains(@class,'technical-issue')]//p//a";
	public static String FooterLinkCssSelector = "div[class*='footer-links']>a";
	public static String SiteMapXpath = "(//div[contains(@class,'footer-links')]//a)[1]";
	public static String SiteMapPageTitle = "//h1[contains(text(),'SiteMap')]";
	public static String TermOfUseXpath = "(//div[contains(@class,'footer-links')]//a)[2]";
	public static String TermOfUseCloseXpath = "//button[@class='btn btn-primary' and text()='CLOSE']";
	public static String DataPrivacyXpath = "(//div[contains(@class,'footer-links')]//a)[3]";

	public static String myCompCopyRightsCssSelector = "div[class*='justify-content-between'] div[class*='mt-3 mt-md-0']";
	public static String FeedbackHomeCssSelector = "button[class*='site-feedback']";
	public static String FeedbackPopUpCssSelector = "div[class*='modal-dialog'] div[class*='modal-content']";
	public static String FeedbackDropDownCssSelector = "div[class*='ng-value-container']";
	public static String FeedbackDropDownFirstOptionCssSelector = "div[class*='ng-option ng-option-marked']";
	public static String FeedbackDropDownAllOptionCssSelector = "div[role*='option']";

	public static String FeedbackCloseBtnCssSelector = "span[class*='acn-cross']";
	public static String FeedbackEmojiCssSelector = "div[class*='feedback-emoji']";
	public static String FeedbackHappyEmojiCssSelector = "input[class*='input happy']";
	public static String FeedbackSubmitCssSelector = "button[class*='btn-mycomp-primary']";
	public static String FeedbackSubmitStageCssSelector = "button[class*='btn-mycomp-primary']";

	public static String FeedbackAlertCssSelector = "div[class*='modal-dialog'] div[class*='modal-content']";
	public static String FeedbackAlertOkCssSelector = "button[class*='btn btn-primary']";
	
	/***********************SOI Tab Objects***************************/
	public static String SOITab = "//a[@id='tab-selectbyid2']";
	public static String SOISkillsPresentTxt = "//p[@class='section-sub-title wid-600 pb-4']";
	public static String SOISkillsNotTxt = "//div[@class='fs20 aliCenter SOIskillempty']";
	public static String SOISkillAction = "//a[contains(text(),'INITIATE ASSESSMENT')]";
	public static String SOISkillActionText = "//span[@class='sub-action-item d-block']";
	public static String SOISkillDeleteBtn = "//button[@class='mycomp-icon-delete btn btn-link btn-link-custom p-0 icon-disable']";
	public static String SOISkillsHeader = "(//div[@class='secondary-skill-container-heading'])[2]";
	
           /********************Menu Sorting***************/
public static String EmployeeFunctions="//*[contains(text(),' Employee Functions ')]";
public static String PendingActions="//*[contains(text(),' Pending Actions ')]";
public static String AdminFunctions="//*[contains(text(),' Admin Functions ')]";
public static String ReviewPendingContribution="//*[contains(text(),' Review Pending Contribution ')]";
public static String ReopenSMEEvaluationForm="//*[contains(text(),'Reopen SME Evaluation Form')]";
public static String upload="(//*[contains(text(),'Upload')])[1]";
public static String BrowseSingleSkillInventory="//*[contains(text(),'Browse Single Skill Inventory')]";
public static String SkillChangeReversal="//*[contains(text(),'Skill Change Reversal')]";
public static String LOGOUT="//*[contains(text(),'Log Out')]";
public static String BackToHome = "//a[@class='acn-angle-left back-arrow position-absolute']";


/********Azure Login Page Variables**********************/
public static String EmailField = "input[type*=email]";
public static String NextField = "input[type*=submit]";
public static String StaySignedIn ="//div[@class='row text-title']";
public static String StaySignedInNo = "idBtn_Back";
public static String NewUser="//div[@id='otherTile']";


/*************LandingPage header**************/
public static String Mycompetency = "//*[contains(text(),' myCompetency ')][1]";
public static String Feedback = "//button[@class='revamp-theme site-feedback']";
public static String About = "/html/body/div[2]/my-app/app-myc-header/header/div[1]/nav/div[1]/ul/li[1]/a";
public static String SkillProfile = "//a[contains(text(),'Skill Profile')]";
public static String Searchbutton = "//button[@class='dropdown-toggle hamburger-menu border-0']";

/*************LandingPage footer**************/
public static String RaiseticketHyperlink = "//a[@href='https://support.accenture.com/support_portal/?id=iframe_catalog_request&sys_id=c9856641139a6600380ddbf18144b05f']";
public static String Sitemap = "//a[contains(text(),'Sitemap')]";
public static String TermsOfUse = "//a[contains(text(),'Terms of Use')]";
public static String PrivacyPolicy = "//a[contains(text(),'Data privacy Statement')]";
public static String CookiePolicy = "//div[contains(text(),' Copyright 2023 Accenture. All rights reserved. ')]";


/************* Skill Profile Locators ***************/
static By webNavigationClose = By.xpath("//span[@class='mycomp-icon-close']");
static By userIcon=By.xpath("//span[@class='mycomp-icon-myc-user']");
static By skillProfileHeader = By.xpath("//h1[contains(text(),'My Skill Profile')]");
//static By plusIcon = By.xpath("//button[@class='btn btn-primary btn-myc rounded-circle ml-auto']");
static By primarySkillTag = By.xpath("//span[contains(text(),'Primary Skill')]");
static By primarySkillName = By.xpath("(//a[@class='skill-name'])[1]");
static By primaryProf = By.xpath("//div[@class='btn-action btn-myc d-inline-block mt-2']");
static By secSkillName1 = By.xpath("(//a[@class='skill-name'])[2]");
static By secSkillProf1 = By.xpath("(//div[@class='btn-action btn-myc d-inline-block mt-3'])[1]");
static By secSkillName2 = By.xpath("(//a[@class='skill-name'])[3]");
static By secSkillProf2 = By.xpath("(//div[@class='btn-action btn-myc d-inline-block mt-3'])[2]");
static By skillCountText = By.xpath("//p[@class='m-0 skill-count']");
static By seeAllSkills = By.xpath("//a[@class='btn-link graphik-medium']");
static By profFullStarSec1 =By.xpath("(//div[@class='card-body'])[3]//span[@class='icon pr-2 rating myc-tooltip mycomp-icon-myc-star']");
static By profHalfStarSec1 = By.xpath("(//div[@class='card-body'])[3]//span[@class='icon pr-2 rating myc-tooltip mycomp-icon-myc-star-o halfStar']");
static By profFullStarSec2 =By.xpath("(//div[@class='card-body'])[4]//span[@class='icon pr-2 rating myc-tooltip mycomp-icon-myc-star']");
static By profHalfStarSec2 = By.xpath("(//div[@class='card-body'])[4]//span[@class='icon pr-2 rating myc-tooltip mycomp-icon-myc-star-o halfStar']");

/**************** Quick Links Locators ***************/
static By quickLinksHeader = By.xpath("//h2[contains(text(),'Quick Links ')]");
static By iButtonQuickLinks = By.xpath("//span[@class='mycomp-icon-myc-info mx-2']");
static By SCLink = By.xpath("//a[contains(text(),'Change Primary Skill')]");
static By firstLink = By.xpath("//a[contains(text(),'Add Secondary Skill')]");
static By secondLink = By.xpath("//a[contains(text(),'Certification Road Map Portal')]");
static By thirdLink = By.xpath("//a[contains(text(),'Expert List FY23')]");
static By fourthLink = By.xpath("");

/*************** Know About MyComp and SAG Locators **************/

static By aboutHeader = By.xpath("//div[contains(text(),'Get to know myCompetency')]");
static By firstVidCard = By.xpath("//video[@class='w-100 rounded']");
static By firstVidPlayBtn = By.xpath("(//video[@class='w-100 rounded'])[1]");
static By secondVidCard = By.xpath("/html/body/div[2]/my-app/app-landing/div/main/div[1]/div[2]/div[7]/div[2]/div[2]/app-cards/div/div/div/video");
static By secondVidPlayBtn = By.xpath("//a[contains(text(),'Certification Road Map Portal')]");
static By SAGHeader = By.xpath("//div[contains(text(),'Review and add these recommendations to your skill profile')]");
static By viewMoreBtn = By.cssSelector("//button[@class='btn btn-myc btn-link btn-link-lg graphik-semi-bold p-0 text-decoration-none']");
static By noSecSkill = By.xpath("//p[@class='no-skill-msg m-0']");



/***********Landing Page PageObjects*******************/

public static String Carousel = "//img[@src]";
public static String Learnmore = "//button[contains(text(),'Learn more')]";
public static String BannerOK = "//button[contains(text(),'Got it')]";
public static String Widget1Box = "/html/body/div[2]/my-app/app-landing/div/main/div[1]/div[2]/div[3]/app-cards/div";
public static String Widget1Text = "//div[@class='list-items d-flex flex-wrap flex-md-nowrap justify-content-between align-items-center']";
public static String Widget1Arrow = "//div/button[@class='btn btn-primary btn-myc mt-2 mt-sm-0']";
public static String Widget2Box = "//div[@class='mb-4 shadow-effect']//div[@style='background: rgb(216, 242, 253);']";
public static String Widget2Text = "//div[@class='mb-4 shadow-effect']//div[@style='background: rgb(216, 242, 253);']//h2[@style='color: rgb(89, 34, 246);']";
public static String Widget2Button = "//div[@class='mb-4 shadow-effect']//div[@style='background: rgb(216, 242, 253);']//button[@class='btn btn-primary btn-myc mt-2 mt-sm-0']";
public static String Widget2ButtonText = "//div[@class='mb-4 shadow-effect']//div[@style='background: rgb(216, 242, 253);']//button[@class='btn btn-primary btn-myc mt-2 mt-sm-0']//span[@class='ml-2']";
public static String Widget3BoxText = "//h2[contains(text(),'Boost your skill journey through pre-Accenture experience!')]";
public static String JumptoTop = "//button[contains(text(),'Jump to top')]";


}
