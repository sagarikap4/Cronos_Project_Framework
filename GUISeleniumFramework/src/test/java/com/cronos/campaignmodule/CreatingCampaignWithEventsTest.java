
package com.cronos.campaignmodule;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.basetest.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.CampaignEventsPage;
import com.comcast.crm.objectrepositoryutility.CampaignInformationPage;
import com.comcast.crm.objectrepositoryutility.CampaignPage;
import com.comcast.crm.objectrepositoryutility.CreateCampaignPage;
import com.comcast.crm.objectrepositoryutility.HomePage;

@Listeners(com.comcast.crm.generic.listenerutility.ListImpClass.class)
public class CreatingCampaignWithEventsTest extends BaseClass {

	@Test
	public void CreatingCampaignWithEventsTest() throws Throwable {

		WebDriverUtility wutil = new WebDriverUtility();

		String CAMPAIGNNAME = eLib.getDataFromExcel("CampaignModule", 1, 2);
		String EVENTNAME = eLib.getDataFromExcel("CampaignModule", 1, 3);
		String TIME = eLib.getDataFromExcel("CampaignModule", 1, 4);

		// click on morelink and click on campaign
		wutil.waitForPageToLoad(driver);
		driver.manage().window().maximize();
		UtilityClassObject.getTest().log(Status.INFO, "browser maximized successfully");
		HomePage hp = new HomePage(driver);
		hp.getMoreLink().click();
		hp.getCampaignsLink().click();
		UtilityClassObject.getTest().log(Status.INFO, "campaign page displayed successfully");

		// Click on Campaign icon in the campaign page
		CampaignPage cp = new CampaignPage(driver);
		cp.getCampaignicon().click();
		UtilityClassObject.getTest().log(Status.INFO, "creating campaign page is displayed successfully");

		// Creating a campaign name and click on save
		CreateCampaignPage ccp = new CreateCampaignPage(driver);
		ccp.getCampaignname().sendKeys(CAMPAIGNNAME);
		ccp.getSavebutton().click();
		UtilityClassObject.getTest().log(Status.INFO, "creating information page id displayed successfully");

		// verify the header msg
		CampaignInformationPage cip = new CampaignInformationPage(driver);
		String actheadermsg = cip.getVerifycampaignheadermsg().getText();
		System.out.println(actheadermsg);
		Assert.assertTrue(actheadermsg.contains(CAMPAIGNNAME));

		// verify the campaign name
		String actcampaignname = cip.getVerifycampaignname().getText();
		System.out.println(actcampaignname);
		Assert.assertTrue(actcampaignname.contains(CAMPAIGNNAME));

		// click on events link
		cip.getAddevents().click();
		UtilityClassObject.getTest().log(Status.INFO, "creating events page is displayed successfully");

		// Creating a events in creatingevent page
		CampaignEventsPage cep = new CampaignEventsPage(driver);
		WebElement event = cep.getEventname();
		event.sendKeys(EVENTNAME);
		event.sendKeys(Keys.PAGE_DOWN);

		// Set the start date and end date
		// WebElement timedropdown = cep.getPmdropdown();
		// wutil.select(timedropdown, TIME);

		// enter the start date
		String STARTDATE = jLib.getRequriedDateYYYYDDMM(3);
		System.out.println(STARTDATE);
		cep.getEventstartdate().clear();
		cep.getEventstartdate().sendKeys(STARTDATE);
		UtilityClassObject.getTest().log(Status.PASS, "start date is displayed");

		// enter the end date
		String ENDDATE = jLib.getRequriedDateYYYYDDMM(30);
		System.out.println(ENDDATE);
		cep.getEventenddate().clear();
		cep.getEventenddate().sendKeys(ENDDATE);
		UtilityClassObject.getTest().log(Status.PASS, "end date is displayed");

		// click on save button
		cep.getSavebutton().click();
		UtilityClassObject.getTest().log(Status.PASS, "events is saved");
		// System.out.println("events is saved");

	}

}
