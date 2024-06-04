package com.CRONOS.OpportunitiesModule;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.basetest.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectrepositoryutility.CreateOpportunityPOPUpPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OpportunitiesPage;
import com.comcast.crm.objectrepositoryutility.OrganizationPage;

@Listeners(com.comcast.crm.generic.listenerutility.ListImpClass.class)
public class VerifyOpportunityNameTextFieldTest extends BaseClass {
	@Test
	public void VerifyOpportunityNameTextField() throws Throwable
	{
	HomePage hp = new HomePage(driver);//homePage object
	OpportunitiesPage op=new OpportunitiesPage(driver);//OpportunitiesPage object
	OrganizationPage orgp=new OrganizationPage(driver);//OrganizationPage object
	CreateOpportunityPOPUpPage cpp=new CreateOpportunityPOPUpPage(driver);//CreateOpportunityPOPUpPage object
	
	
	hp.getOrganizationLink().click();
	UtilityClassObject.getTest().log(Status.INFO,"clicked on organization link");
	Assert.assertTrue(orgp.getorganizationTitle().getText().equals("Organizations"));
	UtilityClassObject.getTest().log(Status.INFO,"Landed on organization page");
	
	orgp.getCreateOrganizationImage().click();
	UtilityClassObject.getTest().log(Status.INFO,"clicked on create new organization link");
	//Assert.assertTrue(orgp.getCreateorgtitle().getText().contains("organization"));
	//UtilityClassObject.getTest().log(Status.INFO,"Landed on create organization page");
	
	String orgname = eLib.getDataFromExcel("OpportunitiesModule",1,2)+jLib.getRandomNumber();
	orgp.getOrganizationTextfield().sendKeys(orgname);
	UtilityClassObject.getTest().log(Status.INFO," "+orgname+ "  entered in organization text field");
	
	orgp.getCreateOrganizationSaveButton().click();
	UtilityClassObject.getTest().log(Status.INFO,"Organization created");
	
	driver.navigate().refresh();
	hp.getOpportunitiesLink().click();
	UtilityClassObject.getTest().log(Status.INFO,"clicked on opportunity link");
	Assert.assertTrue(op.getOpportunityText().getText().equals("Opportunities"));
	UtilityClassObject.getTest().log(Status.INFO,"Landed on opportunities page");

	op.getCreateOpportunity().click();
	UtilityClassObject.getTest().log(Status.INFO,"clicked on create opportunity image");
	Assert.assertTrue(op.getCreatingNewOpportunityText().getText().contains("Opport"));
	UtilityClassObject.getTest().log(Status.INFO,"Landed on create new opportunities page");
	
	String opportunityname = eLib.getDataFromExcel("OpportunitiesModule",3,2)+jLib.getRandomNumber();
	System.out.println(opportunityname);
	op.getOpportunityNameTextfield().sendKeys(opportunityname);
	
	//opportunityname.toCharArray();
	op.getRelatedToSelectIcon().click();
	
	String parentid = driver.getWindowHandle();//To get parent id
	wLib.switchToTabOnTitle(driver,"Popup_picker&form");
	UtilityClassObject.getTest().log(Status.INFO,"switch to pop up window");
	
	cpp.getSearchorgname().sendKeys(orgname);
	UtilityClassObject.getTest().log(Status.INFO," "+orgname+ " organization name entered in search text field");
	cpp.getSearchNowButton().click();
	UtilityClassObject.getTest().log(Status.INFO," "+orgname+ "  organization name searched");
	driver.findElement(By.xpath("//a[text()='"+orgname+"']")).click();
	driver.switchTo().window(parentid);
	
	op.getGroupRadioButton().click();
	UtilityClassObject.getTest().log(Status.INFO,"Group radio button clicked");
	
	String ExceptedCloseDate = jLib.getRequriedDateYYYYDDMM(10);
	System.out.println(ExceptedCloseDate);
	op.getExceptedclosedate().clear();
	op.getExceptedclosedate().sendKeys(ExceptedCloseDate);
	UtilityClassObject.getTest().log(Status.INFO,"Excepted close date"+ExceptedCloseDate+" entered");
	op.getCreateOpportunitySaveButton().click();
	UtilityClassObject.getTest().log(Status.INFO,"Opportunity "+opportunityname+" created succesfully");
	
	String oppprtunitynameInInfoPage = driver.findElement(By.xpath("//span[text()='"+opportunityname+"']")).getText();
	System.out.println(oppprtunitynameInInfoPage);
	wLib.getScrrenshot(driver, oppprtunitynameInInfoPage);
	UtilityClassObject.getTest().log(Status.FAIL,"User able to pass "+opportunityname+"while creating opportunity name");
	}
}
