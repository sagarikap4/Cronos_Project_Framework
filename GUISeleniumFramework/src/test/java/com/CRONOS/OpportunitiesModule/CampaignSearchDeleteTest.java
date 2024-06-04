package com.CRONOS.OpportunitiesModule;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.basetest.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
//import com.comcast.crm.objectrepositoryutility.CampaignEventsPage;
//import com.comcast.crm.objectrepositoryutility.CampaignInformationPage;
import com.comcast.crm.objectrepositoryutility.CampaignPage;
import com.comcast.crm.objectrepositoryutility.CreateCampaignPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
@Listeners(com.comcast.crm.generic.listenerutility.ListImpClass.class)
public class CampaignSearchDeleteTest extends BaseClass {
	@Test
	public void CampaignSearchDelete() throws Throwable
	{
		HomePage hp = new HomePage(driver);
		CampaignPage cp=new CampaignPage(driver);
		CreateCampaignPage ccp=new CreateCampaignPage(driver);
		//CampaignInformationPage cip=new CampaignInformationPage(driver);
		//CampaignEventsPage ce=new CampaignEventsPage(driver);
		
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
		
		driver.findElement(By.xpath("//a[text()='Campaigns']")).click();
		
		cp.getSearchtextfield().sendKeys(campaignname);
		UtilityClassObject.getTest().log(Status.INFO,"campaign name entered in search textfield");
		WebElement campaignIndropdown = driver.findElement(By.xpath("//select[@name='search_field']"));
		wLib.select(campaignIndropdown, 1);
		cp.getSearchnowbutton().click();
		UtilityClassObject.getTest().log(Status.INFO,"campaign search done");
		
		String searchcampaignname = driver.findElement(By.xpath("(//a[text()='"+campaignname+"'])[2]")).getText();
		Assert.assertEquals(campaignname, searchcampaignname);
		
		driver.findElement(By.xpath("//a[text()='del']")).click();
		wLib.switchtoAlertAndAccept(driver);
		UtilityClassObject.getTest().log(Status.INFO,"campaign deleted");
		
		cp.getSearchtextfield().sendKeys(campaignname);
		UtilityClassObject.getTest().log(Status.INFO,"campaign name entered in search textfield");
		WebElement campaigndeleteIndropdown = driver.findElement(By.xpath("//select[@name='search_field']"));
		wLib.select(campaigndeleteIndropdown, 1);
		cp.getSearchnowbutton().click();
		UtilityClassObject.getTest().log(Status.INFO,"campaign not present in the campaign list");
	}
}


