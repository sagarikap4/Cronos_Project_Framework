package com.CRONOS.OpportunitiesModule;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.basetest.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OpportunitiesPage;
import com.comcast.crm.objectrepositoryutility.OrganizationPage;
@Listeners(com.comcast.crm.generic.listenerutility.ListImpClass.class)
public class CreateOppertunityWithORGandGroupTest extends BaseClass {
	@Test
	public void CreateOppertunityWithORGandGroup() throws Throwable
	{
		HomePage hp = new HomePage(driver);
		OrganizationPage orgp=new OrganizationPage(driver);
		
		hp.getOrganizationLink().click();
		UtilityClassObject.getTest().log(Status.INFO,"clicked on organization link");
		
		orgp.getCreateOrganizationImage().click();
		UtilityClassObject.getTest().log(Status.INFO,"clicked on create new organization link");
		//orgname=eLib.getDataFromExcel("OpportunitiesModule",1,3)+jLib.getRandomNumber();
		//orgp.getOrganizationTextfield().sendKeys(null);
		
		
		
		hp.getOpportunitiesLink().click();
		UtilityClassObject.getTest().log(Status.INFO,"clicked on opportunity link");
		
		OpportunitiesPage op=new OpportunitiesPage(driver);
		op.getCreateOpportunity().click();
		UtilityClassObject.getTest().log(Status.INFO,"clicked on create opportunity image");
		
		String opportunityname = eLib.getDataFromExcel("OpportunitiesModule",1,3)+jLib.getRandomNumber();
		op.getOpportunityNameTextfield().sendKeys( opportunityname);
		UtilityClassObject.getTest().log(Status.INFO,"opportunity name entered");
		op.getRelatedToSelectIcon().click();
	}

}
