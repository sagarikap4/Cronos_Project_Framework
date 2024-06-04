package com.CRONOS.OpportunitiesModule;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.basetest.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectrepositoryutility.CreateProductPage;
import com.comcast.crm.objectrepositoryutility.CreateVendorPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.ProductInformationPage;
import com.comcast.crm.objectrepositoryutility.ProductPage;
import com.comcast.crm.objectrepositoryutility.VendorPage;
@Listeners(com.comcast.crm.generic.listenerutility.ListImpClass.class)
public class CreateProductWithVendorTest extends BaseClass {
	@Test
	public void CreateProductWithVendor() throws Throwable
	{
		HomePage hp = new HomePage(driver);
		VendorPage vp=new VendorPage(driver);
		CreateVendorPage cvp=new CreateVendorPage(driver);
		ProductPage pp=new ProductPage (driver);
		ProductInformationPage pip=new ProductInformationPage(driver);
		CreateProductPage cpp=new CreateProductPage(driver);
		
		
		hp.getMoreLink().click();
		UtilityClassObject.getTest().log(Status.INFO,"Clicked on More Link");
		
		hp.getVendorsLink().click();
		UtilityClassObject.getTest().log(Status.INFO,"Clicked on Vendor Link");
		String vendor = driver.findElement(By.xpath("(//a[text()='Vendors'])[3]")).getText();
		Assert.assertTrue(vendor.contains("Vendors"));
		UtilityClassObject.getTest().log(Status.INFO,"Vendor page title verified");
		
		vp.getVendorlookupimage().click();
		UtilityClassObject.getTest().log(Status.INFO,"Clicked on create new Vendor image");
		String createvendor = driver.findElement(By.xpath("//span[contains(text(),'Creating')]")).getText();
		System.out.println(createvendor);
		Assert.assertTrue(createvendor.contains("Creating"));
		UtilityClassObject.getTest().log(Status.INFO,"create new Vendor title page verified");
		
		String vendorname = eLib.getDataFromExcel("ProductModule",1,2)+jLib.getRandomNumber();
		cvp.getVendortextfield().sendKeys(vendorname);
		cvp.getSavebutton().click();
		UtilityClassObject.getTest().log(Status.INFO,"vendor created successfully");
		
		String vendornameinfopage = driver.findElement(By.xpath("//span[text()='"+vendorname+"']")).getText();
		Assert.assertEquals(vendornameinfopage, vendorname);
		UtilityClassObject.getTest().log(Status.INFO,"vendor name verified in vendor info page");
		
		driver.navigate().refresh();
		
		hp.getProductsLink().click();
		UtilityClassObject.getTest().log(Status.INFO,"clicked on product link");
		String product = driver.findElement(By.xpath("(//a[text()='Products'])[2]")).getText();
		Assert.assertTrue(product.contains(product));
		UtilityClassObject.getTest().log(Status.INFO,"product page verified");
		
		pp.getProductlookupimage().click();
		UtilityClassObject.getTest().log(Status.INFO,"clicked on create product image");
		String createproduct =pip.getProductinformationpage().getText();
		Assert.assertTrue(createproduct.contains(createproduct));
		UtilityClassObject.getTest().log(Status.INFO,"create new product page verified");
		
		String productname = eLib.getDataFromExcel("ProductModule",1,3)+jLib.getRandomNumber();
		cpp.getProductname().sendKeys(productname);
		cpp.getVendorNameLookUpImage().click();
		
		String parentid = driver.getWindowHandle();
		wLib.switchToTabOnTitle(driver, "Vendors&action");
		
		driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(vendorname);
		driver.findElement(By.xpath("//input[@name='search']")).click();
		driver.findElement(By.xpath("//a[text()='"+vendorname+"']")).click();
		UtilityClassObject.getTest().log(Status.INFO,"clicked on vender name in search vendor name page");
		
		driver.switchTo().window(parentid);
		
		cpp.getSavebutton().click();
		UtilityClassObject.getTest().log(Status.INFO,"clicked on saved button");
		
		
		String productnameInInfoPage = pip.getProductinformationpage().getText();
		Assert.assertTrue(productnameInInfoPage.contains(productnameInInfoPage));
		UtilityClassObject.getTest().log(Status.INFO,"Product information page verified");
		
		
		
	}

}
