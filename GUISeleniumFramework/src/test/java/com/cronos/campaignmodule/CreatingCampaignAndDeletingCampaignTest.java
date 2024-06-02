package com.cronos.campaignmodule;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.basetest.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.CampaignInformationPage;
import com.comcast.crm.objectrepositoryutility.CampaignPage;
import com.comcast.crm.objectrepositoryutility.CreateCampaignPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
@Listeners(com.comcast.crm.generic.listenerutility.ListImpClass.class)
public class CreatingCampaignAndDeletingCampaignTest extends BaseClass {

	@Test
	public void CreatingCampaignAndDeletingCampaignTest() throws Throwable {

		WebDriverUtility wutil = new WebDriverUtility();
		String CAMPAIGNNAME = eLib.getDataFromExcel("CampaignModule", 1, 2);
		String DROPDOWN = eLib.getDataFromExcel("CampaignModule", 2, 4);

		// click on morelink and click on campaign
		wutil.waitForPageToLoad(driver);
		driver.manage().window().maximize();
		System.out.println("browser maximized successfully");
		//UtilityClassObject.getTest().log(Status.INFO, "browser maximized successfully");
		HomePage hp = new HomePage(driver);
		hp.getMoreLink().click();
		hp.getCampaignsLink().click();
		System.out.println("campaign page displayed successfully");
		//UtilityClassObject.getTest().log(Status.INFO, "campaign page displayed successfully");

		// Click on Campaign icon in the campaign page
		CampaignPage cp = new CampaignPage(driver);
		cp.getCampaignicon().click();
		System.out.println("creating campaign page is displayed successfully");
		//UtilityClassObject.getTest().log(Status.INFO, "creating campaign page is displayed successfully");

		// Creating a campaign name and click on save
		CreateCampaignPage ccp = new CreateCampaignPage(driver);
		ccp.getCampaignname().sendKeys(CAMPAIGNNAME);
		ccp.getSavebutton().click();
		System.out.println("creating information page is displayed successfully");
		//UtilityClassObject.getTest().log(Status.INFO, "creating information page id displayed successfully");

		// verify the header msg
		CampaignInformationPage cip = new CampaignInformationPage(driver);
		String actheadermsg = cip.getVerifycampaignheadermsg().getText();
		System.out.println(actheadermsg);
		Assert.assertTrue(actheadermsg.contains(CAMPAIGNNAME));
		System.out.println("verified the header msg");
		// verify the campaign name
		String actcampaignname = cip.getVerifycampaignname().getText();
		System.out.println(actcampaignname);
		Assert.assertTrue(actcampaignname.contains(CAMPAIGNNAME));
        System.out.println("verified the campaignname");
        
        //click on campaign link in header tab
         hp.getMoreLink().click();
         hp.getCampaignsLink().click();
         System.out.println("campaign page is displayed");
         
         //enter the campaign name in textfield and search
          cp.getSearchtextfield().sendKeys(CAMPAIGNNAME);
          WebElement searchdropdown = cp.getSearchindropdown();
          wutil.select(searchdropdown,DROPDOWN);
          cp.getSearchnowbutton().click();
          System.out.println("search is done");
          
          //click on dellink
          cp.getDellink().click();
          System.out.println("click on del link");
   
          
          wutil.switchtoAlertAndAccept(driver);
          System.out.println("pop up is handled");
     
	}

}
