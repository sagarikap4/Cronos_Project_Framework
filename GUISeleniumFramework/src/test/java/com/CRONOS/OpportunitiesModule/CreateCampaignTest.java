package com.CRONOS.OpportunitiesModule;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.basetest.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectrepositoryutility.CampaignEventsPage;
import com.comcast.crm.objectrepositoryutility.CampaignInformationPage;
import com.comcast.crm.objectrepositoryutility.CampaignPage;
import com.comcast.crm.objectrepositoryutility.CreateCampaignPage;
import com.comcast.crm.objectrepositoryutility.HomePage;

@Listeners(com.comcast.crm.generic.listenerutility.ListImpClass.class)

public class CreateCampaignTest extends BaseClass {
	@Test
	public void createCampaign() throws Throwable
	{
	//UtilityClassObject uc=new UtilityClassObject();	
	HomePage hp = new HomePage(driver);
	CampaignPage cp=new CampaignPage(driver);
	CreateCampaignPage ccp=new CreateCampaignPage(driver);
	CampaignInformationPage cip=new CampaignInformationPage(driver);
	CampaignEventsPage ce=new CampaignEventsPage(driver);
	
	hp.getMoreLink().click();
	UtilityClassObject.getTest().log(Status.INFO,"Clicked on More Link");
	
	hp.getCampaignsLink().click();
	UtilityClassObject.getTest().log(Status.INFO,"Clicked on Campaign Link");
	String campaignpagetitle = driver.findElement(By.xpath("//td[@class='moduleName']")).getText();
	Assert.assertEquals(campaignpagetitle,"Campaigns");
	UtilityClassObject.getTest().log(Status.INFO,"campaign page title verified");
	
	
	cp.getCampaignicon().click();
	UtilityClassObject.getTest().log(Status.INFO,"Clicked on create new capaign Link");
	String createcampaignpagetitle = driver.findElement(By.xpath("//span[contains(text(),'Creating New Campaign')]")).getText();
	Assert.assertTrue(createcampaignpagetitle.contains("Creating New Campaign"));
	UtilityClassObject.getTest().log(Status.INFO,"create campaign page title verified");
	
	
	String campaignname = eLib.getDataFromExcel("CampaignModule",1,2)+jLib.getRandomNumber();
	ccp.getCampaignname().sendKeys(campaignname);
	UtilityClassObject.getTest().log(Status.INFO,"campaign name entered");
	ccp.getSavebutton().click();
	UtilityClassObject.getTest().log(Status.INFO,"campaign successfully created");
	
	String campaignInfopagename = driver.findElement(By.xpath("//span[text()='"+campaignname+"']")).getText();
	Assert.assertEquals(campaignname, campaignInfopagename);
	UtilityClassObject.getTest().log(Status.INFO,"Campaign name verified");
	
	String campaignInfo = driver.findElement(By.xpath("//span[contains(text(),'"+campaignname+" -  Campaign Information')]")).getText();
	Assert.assertTrue(campaignInfo.contains(campaignname));
	UtilityClassObject.getTest().log(Status.INFO,"campaign title verified");
	
	cip.getAddEvent().click();
	UtilityClassObject.getTest().log(Status.INFO,"Clicked on add event");
	String Event_Name = eLib.getDataFromExcel("CampaignModule",1,3)+jLib.getRandomNumber();
	System.out.println(Event_Name);
	ce.getEventname().sendKeys(Event_Name);
	UtilityClassObject.getTest().log(Status.INFO,"Event name entered");
	
	String event_start_date = jLib.getSystemDateYYYYDDMM();
	ce.getEventstartdate().clear();
	ce.getEventstartdate().sendKeys(event_start_date);
	UtilityClassObject.getTest().log(Status.INFO,"Event start date entered");
	
	String event_end_date = jLib.getRequriedDateYYYYDDMM(30);
	System.out.println(event_end_date);
	ce.getEventenddate().clear();
	ce.getEventenddate().sendKeys(event_end_date);
	System.out.println(event_end_date);
	UtilityClassObject.getTest().log(Status.INFO,"Event end date entered");
	
	ce.getSavebutton().click();
	UtilityClassObject.getTest().log(Status.INFO,"Event created");
	}
}
