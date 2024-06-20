package LandingPageValidation;

import org.openqa.selenium.By;

public class LandingPageValidation_PageObjects {



	/********Login Page Variables**********************/	
	public static String UserNameInputId = "userNameInput";
	public static String PasswordInputId = "passwordInput";
	public static String SignInButtonId = "submitButton";

	/********Azure Login Page Variables**********************/
	public static String EmailField = "input[type*=email]";
	public static String NextField = "input[type*=submit]";
	public static String StaySignedIn ="//div[@class='row text-title']";
	public static String StaySignedInNo = "idBtn_Back";
	public static String NewUser="//div[@id='otherTile']";


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
	static By SCLink = By.xpath("//a[contains(text(),'Change Primary Skill ')]");
	static By firstLink = By.xpath("//a[contains(text(),'Add Secondary Skill')]");
	static By secondLink = By.xpath("//a[contains(text(),'Certification Road Map Portal')]");
	static By thirdLink = By.xpath("//a[contains(text(),'Expert List FY23')]");
	static By fourthLink = By.xpath("");

	/***********Landing Page PageObjects*******************/

	public static String Carousel = "//img[@src]";
	public static String Learnmore = "//button[contains(text(),'Learn more')]";
	public static String BannerOK = "//button[contains(text(),'Got it')]";
	public static String Widget1Box = "(//div[@class='card myc-card'])[1]";
	public static String Widget1Text = "(//div[@class='card-content h-100 d-flex flex-column'])[1]";
	public static String Widget1Arrow = "(//button[@class='btn btn-primary btn-myc mt-2 mt-sm-0'])[1]";
	public static String Widget2Box = "(//div[@class='card myc-card'])[2]";
	public static String Widget2Text = "(//div[@class='card-content h-100 d-flex flex-column'])[2]";
	public static String Widget2Button = "(//button[@class='btn btn-primary btn-myc mt-2 mt-sm-0'])[2]";
	public static String Widget2ButtonText = "(//button[@class='btn btn-primary btn-myc mt-2 mt-sm-0'])[2]";
	public static String Widget3BoxText = "//h2[contains(text(),'Boost your skill journey through pre-Accenture experience!')]";
	public static String JumptoTop = "//button[contains(text(),'Jump to top')]";
	/*************** Know About MyComp and SAG Locators **************/

	static By aboutHeader = By.xpath("//div[contains(text(),'Get to know myCompetency')]");
	static By firstVidCard = By.xpath("//video[@class='w-100 rounded']");
	static By firstVidPlayBtn = By.xpath("(//video[@class='w-100 rounded'])[1]");
	static By secondVidCard = By.xpath("//h2[contains(text(),'How does')]");
	static By secondVidPlayBtn = By.xpath("//a[contains(text(),'Certification Road Map Portal')]");
	static By SAGHeader = By.xpath("//div[contains(text(),'Check out these')]");
	static By viewMoreBtn = By.xpath("(//button[@class='btn btn-myc btn-link'])[1]");
	static By noSecSkill = By.xpath("//p[@class='no-skill-msg m-0']");

	/**************HamMenu Loactors******************/
	public static String HamMenuButtonXpath="//button[@id='hamburgerdropdown']";
	public static String AdminMenuXpathSelector = "//button[contains(text(),'Admin Functions')]";
	public static String AdminMenuUploadXpathSelector = "//a[@href='new_upload.aspx']";
	public static String DropDownId = "ContentPlaceHolder1_CboUpload";
	public static String FileUploadButtonCssSelector = "input[id=ContentPlaceHolder1_UpdDetails_FileUpload]";
	public static String UploadButtonCssSelector = "input[id=ContentPlaceHolder1_UpdDetails_BtnUpload]";
	public static String ResultTableId = "ContentPlaceHolder1_UpdDetails_DtgUploadResults";
	public static String UploadErrorStatusCssSelector = "table[class*=TableBorder]>tbody>tr[class*=ItemStyle]>td";
	public static String OldHomePageLogoCssSelector = "header[id*=header] a[href*=home]";
	public static String SearchButtonId = "ContentPlaceHolder1_BtnGo";
	public static String Logoutxpath = "//a[contains(text(),'Logout')]";

	/******************** Feedback PopUp Locators *******************/
	/*
	 * static By feedbcakBtn = By.xpath("//button[contains(text(),'Feedback')]");
	 * static By feedbackHdr =
	 * By.xpath("//h4[contains(text(),'Share your feedback')]"); static By
	 * feedbackClose = By.xpath("btn close acn-cross p-2"); static By label1 =
	 * By.xpath("//label[@class='custom-label']"); static By featureDrpDown =
	 * By.xpath("(//span[@class='ng-arrow-wrapper'])[1]"); static By featuresList =
	 * By.xpath("//div[@role='option']"); static By selectedFeature =
	 * By.xpath("//div[@class='ng-input']"); static By label2 =
	 * By.xpath("//div[@class='custom-label mb-2']"); static By happyOpt =
	 * By.xpath("//span[@class='feedback-icon mycomp-icon-happy-face']"); static By
	 * neutralOpt =
	 * By.xpath("//span[@class='feedback-icon mycomp-icon-nuetral-face']"); static
	 * By sadOpt = By.xpath("//span[@class='feedback-icon mycomp-icon-sad-face']");
	 * static By submitBtn = By.xpath("//button[contains(text(),'Submit')]"); static
	 * By label3 = By.xpath("//label[contains(text(),'We')]"); static By reasonHdr =
	 * By.xpath("//input[@id='sorryToHear']"); static By label4 =
	 * By.xpath("//label[contains(text(),'Tell us')]"); static By reasonDropdown =
	 * By.xpath("(//span[@class='ng-arrow-wrapper'])[2]"); static By reasonsList =
	 * By.xpath("//div[@role='option']"); static By feedbackInput =
	 * By.xpath("//textarea[@id='tellUs']"); static By charLimit =
	 * By.xpath("//span[@class='charactercss']"); static By label5 =
	 * By.xpath("//label[@for='tellUs']"); static By confHeader =
	 * By.xpath("//label[contains(text(),'Alert')]"); static By confMsg =
	 * By.xpath("//p[contains(text(),' Your feedback')]"); static By confOkBtn =
	 * By.xpath("//button[contains(text(),'Okay')]");
	 */

	/******************** New Feedback PopUp Locators *******************/
	static By feedbcakBtn = By.xpath("/html/body/div[2]/my-app/button");
	static By feedbackHdr = By.xpath("//div[contains(text(),'We appreciate')]");
	static By feedbackClose = By.xpath("//button[@class='btn close acn-cross p-2 c-modal__header-close']");
	static By label1 = By.xpath("//div[@class='selectfeatures c-modal__feedback-ratingTitle']");
	static By expDrpDown = By.xpath("//div[@class='c-team-learningplan-dropdown-toggleGroup c-feedbackdropdown']");
	static By featuresList = By.xpath("//a[@class='c-dropdown-item fbdropdown']");
	static By selectedFeature = By.xpath("//div[@class='c-team-learningplan-dropdown-toggleGroup c-feedbackdropdown']");
	static By label2 = By.xpath("//div[@class='c-modal__feedback-ratingTitle']");
	static By starRatingAll = By.xpath("//div[@class='c-feedback__toggle-wrap']");
	static By singleStar = By.xpath("//div[@class='c-feedback__toggleContainer']");
	static By submitBtn = By.xpath("//button[contains(text(),'Submit')]");
	static By cancelBtn = By.xpath("//button[contains(text(),'Cancel')]");
	static By label3 = By.xpath("//div[@class='c-modal__feedback-commentsLabel']");
	static By reasonHdr = By.xpath("//input[@id='sorryToHear']");
	static By label4 = By.xpath("//label[contains(text(),'Tell us')]");
	static By feedbackInput = By.xpath("//textarea[@class='ng-untouched ng-pristine ng-valid']");
	static By charLimit = By.xpath("//small[contains(text(),'Characters')]");
	static By confHeader = By.xpath("//div[@class='modal-content']"); 
	static By confMsg = By.xpath("//div[@class='position-relative']");
	static By confCloseBtn = By.xpath("//button[@class='btn close acn-cross p-2']");

	/*********************** Secondary skills tab Locators ********************/
	static By mySkillProfile = By.xpath("");
	static By secSkillTab = By.xpath("");
	static By secSkillDesc = By.xpath("");
	static By addSecBtn = By.xpath("");
	static By skillName = By.xpath("");
	static By skillProf = By.xpath("");
	static By profDesc = By.xpath("");
	static By profImg = By.xpath("");
	static By takeActions = By.xpath("");
	static By execLogo = By.xpath("");
	static By execText = By.xpath("");
	static By recomSkillsHeader = By.xpath("");
	static By recomSkillName = By.xpath("");
	static By recomAddBtn = By.xpath("");
	static By recomViewMoreBtn = By.xpath("");
	static By recomViewLessBtn = By.xpath("");
	static By dipaLogo = By.xpath("//span[@class='hover-text']");

	/********************** SOI Locators ************************/
	static By SOITab = By.xpath("");
	static By SOIDesc = By.xpath("");
	static By SOISkillName = By.xpath("");
	static By takeAssesText = By.xpath("");
	static By SOIAction = By.xpath("");
	static By SOIDeleteIcon = By.xpath("");

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

	/*************Approver Widgets ************************************/
	
	public static String ApproverW1Box= "(//h2[@class='card-title mb-0 flex-grow-1'])[1]" ;
	public static String ApproverW1Button = "(//button[@class='btn btn-primary btn-myc mt-2 mt-sm-0'])[1]";
	public static String ApproverW2Box= "(//h2[@class='card-title mb-0 flex-grow-1'])[2]" ;
	public static String ApproverW2Button = "(//button[@class='btn btn-primary btn-myc mt-2 mt-sm-0'])[2]";
	

	/***************************Resource-section document******************************/
	public static String mycompiconclosexpath="//span[@class='mycomp-icon-close']";
	public static String MyResourcesButton="(//a[@class='nav-link px-0 mx-2'])[1]";
	public static String MyResourcessideheadingXpath="//h1[@class='page-title']";
	public static String FAQSearchBox = "//div[@class='search-input faq-search position-relative d-inline-block']";
	public static String Invalidsearch = "(//div[@class='text-center pt-4'])[1]";
	public static String ViewmoreFAQ = "//button[@class='btn btn-myc btn-link graphik-medium']";
	public static String ClickhereFAQ_Ques="(//div[@class='click-here onhover'])[1]";
	public static String AboutmycompetencytabXpath="//a[@id='ngb-nav-5']";
	public static String AboutmycompetencyfileXpath="//a[@title='Download File for Job Aid - myCompetency Helpdesk']";
	public static String AboutmycompetencyfileDescription1Xpath="//p[@class='doc-description']";
	public static String AboutmycompetencyFileDownloadbuttonXpath="//span[@class='file-size pl-2']";
	public static String AboutmycompetencyPPTXfileXpath="//div[@class='file-extension mr-3 text-uppercase d-flex align-items-center justify-content-center pptx']";
	public static String feedbackbuttonXpath="//button[@class='revamp-theme site-feedback']";
	public static String MyjourneytabXpath="(//li[@class='nav-item'])[4]";
	public static String MyjourneyfilterbytextXpath="//label[@id='sortBy']";
	public static String MyjourneyselectcategoriesXpath="//div[@class='category-selection']";
	public static String MyjourneysearchiconXpath="(//span[@class='mycomp-icon-myc-search search-icon position-absolute'])[2]";
	public static String MyjourneyEnterfilenametosearchtextXpath="//input[@id='keyInputJW']";
	public static String MyjourneyViewmorebuttonXpath="//button[@class='btn btn-myc btn-link graphik-medium']";
	public static String MyjourneyViewlessbuttonXpath="//button[@class='btn btn-myc btn-link graphik-medium']";
	public static String MyjourneycategoriesdropdownXpath="//span[@class='ng-arrow-wrapper']";
	public static String MyjourneycategoriesdropdownXpath1="//span[@class='ng-arrow-wrapper']";
	public static String MyjourneycategoriesjobaidXpath="(//span[@id='itemlabel-6'])";   
	public static String MyjourneyJobaidcategoryupfrontbelowthedropdownXpath="//span[contains(text(), 'Job Aid ')]";
	public static String CrossButton="//button[@aria-label='Clear Search']";
	public static String MyjourneyJobAidFile="(//div[@class='pb-2 doc-name'])[1]";
	public static String MyjourneyNominationformcategoryupfrontbelowthedropdownXpath="//span[@title='Nomination Form']"; 
	public static String MyjourneyFileNameFY23ExpertsQ1Q2Xpath="//a[@title='Download File for FY23 Experts (Q1 & Q2)']";
	public static String MyjourneyFileDownloadFY23ExpertsQ1Q2Xpath="(//span[@class='file-size pl-2'])[2]";
	public static String MyjourneyFileNameExecutiveAssessmentScopeXpath="//a[@title='Download File for Executive Assessment Scope']";
	public static String MyjourenyFileDownloadExecutiveAssessmentScopeXpath="(//span[@class='file-size pl-2'])[9]";
	public static String CertificationsxPath="(//li[@class='nav-item'])[5]";
	public static String CertificationFilterBy="//label[@class='mb-0 mr-2 pt-2 text-nowrap']";
	public static String CertificationSelect="//div[@class='ng-option' and @id='ad2db80f445a-0']";//"//div[@class='ng-input']//input[@type='text']";
	//public static String CertificationSelectDropDown="//div[@class='ng-input']";
	public static String CertificationFileDownload="(//button[@class='btn btn-link mycomp-icon-download p-0 download-icon'])[1]";
	public static String CerificationCategory1="//div[@class='ng-option ng-option-marked']//span[@title='Industry powers']";
	public static String CertificationCategory2="//span[@title='Cloud elevate']";
	public static String CertificationRoadMapLink="//div[@class='py-4 my-3 cert-roadmap-link']";
	public static String FilenameSearchtext="(//input[@class='form-control ng-untouched ng-pristine ng-valid'])[2]";
	public static String SearchIcon="(//span[@class='mycomp-icon-myc-search search-icon position-absolute'])[2]";
	public static String Skills_SpecializationsxPath="Skills & Specialization";
	public static String Skills_SpecializationsFileName1Xpath="//a[@title='Download File for Specialization Catalog']";
	public static String Skills_SpecializationsFileDescription1Xpath="(//p[@class='doc-description'])[1]";
	public static String Skills_SpecializationsFileDownload1Xpath="(//span[@class='file-size pl-2'])[1]";
	public static String Skills_SpecializationFileDownload="(//button[@class='btn btn-link mycomp-icon-download p-0 download-icon'])[1]";
	public static String Skills_SpecializationsFileName2Xpath="//a[@title='Download File for Reason for unconventional skill change']";
	public static String Skills_SpecializationsFileDescription2Xpath="(//p[@class='doc-description'])[2]";
	public static String Skills_SpecializationsFileDownload2Xpath="(//span[@class='file-size pl-2'])[2]";
	public static String mycompetencylogoXpath="//a[@class='navbar-brand mr-auto px-4 ml-4']";

}
