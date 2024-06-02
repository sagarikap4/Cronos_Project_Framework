package com.cronos.campaignmodule;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.generic.basetest.BaseClass;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OpportunitiesPage;
import com.comcast.crm.objectrepositoryutility.OrganizationPage;

public class CreatingOpportunitiesWithMandatoryFieldsTest extends BaseClass {

	@Test
	public void CreatingOpportunitiesWithMandatoryFieldsTest() throws Throwable {

		// fetch the data from Excel file
		WebDriverUtility wutil = new WebDriverUtility();
		// int RANDOM = jLib.getRandomNumber();
		String ORGNAME = eLib.getDataFromExcel("OpportunitiesModule", 1, 2) + jLib.getRandomNumber();
		String OPPNAME = eLib.getDataFromExcel("OpportunitiesModule", 1, 3);

		// Browser is launching
		wutil.waitForPageToLoad(driver);
		driver.manage().window().maximize();
		System.out.println("browser maximized successfully");
		// UtilityClassObject.getTest().log(Status.INFO, "browser maximized
		// successfully");
		HomePage hp = new HomePage(driver);

		hp.getOrganizationLink().click();

		// navigate to org page and enter the org name and save
		OrganizationPage op = new OrganizationPage(driver);
		op.getCreateOrganizationImage().click();
		op.getOrganizationTextfield().sendKeys(ORGNAME);
		op.getCreateOrganizationSaveButton().click();
		String actorgname = driver.findElement(By.xpath("//span[text()='" + ORGNAME + "']")).getText();
		System.out.println(actorgname);
		Assert.assertTrue(actorgname.contains(ORGNAME));

		// click on opportunities link in header tab
		hp.getOpportunitiesLink().click();
		System.out.println("opportunities page is displayed");

		// click on opportunity icon
		OpportunitiesPage opp = new OpportunitiesPage(driver);
		opp.getCreateOpportunity().click();
		System.out.println("create opportunities page is displayed");

		// enter the mandatory fields in create opportunity page
		opp.getOpportunityNameTextfield().sendKeys(OPPNAME);
		String parentid = driver.getWindowHandle();

		// switch to org child browser window
		opp.getRelatedToSelectIcon().click();
		System.out.println("switched to org child browser ");
		wutil.switchToTabOnTitle(driver, "Accounts&action");
		driver.findElement(By.id("search_txt")).sendKeys(ORGNAME);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='" + ORGNAME + "']")).click();
		System.out.println("org name is entered");

		// switch to create opp page
		driver.switchTo().window(parentid);
		System.out.println("switch to parent page");

		// click on assigned to radio button
		opp.getGroupRadioButton().click();
		System.out.println("assigned to radio button is clicked");

		// enter the close date
		String CLOSEDATE = jLib.getRequriedDateYYYYDDMM(10);
		System.out.println(CLOSEDATE);
		driver.findElement(By.id("jscal_field_closingdate")).clear();
		driver.findElement(By.id("jscal_field_closingdate")).sendKeys(CLOSEDATE);

		// click on save
		opp.getCreateOpportunitySaveButton().click();
		Thread.sleep(2000);

		// verify the headermsg
		// String actoppname =
		// driver.findElement(By.xpath("//span[contains(text(),'"+OPPNAME+"'-
		// Opportunity Information']")).getText();
		// System.out.println(actoppname);

		// verify the oppname
		String actoppname = driver.findElement(By.xpath("//span[text()='" + OPPNAME + "']")).getText();
		System.out.println(actoppname);
		Assert.assertTrue(actoppname.contains(OPPNAME));

		// verify the expeted close date
		String actclosedate = driver.findElement(By.xpath("//td[text()='" + CLOSEDATE + "']")).getText();
		System.out.println(actclosedate);
		Assert.assertTrue(actclosedate.contains(CLOSEDATE));

	}

}
