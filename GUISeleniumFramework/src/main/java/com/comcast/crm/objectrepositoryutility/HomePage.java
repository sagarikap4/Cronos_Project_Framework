package com.comcast.crm.objectrepositoryutility;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

/**
 * 
 * @author Deepak
 * 
 * Contains Login page elements & business lib like login()
 *
 */  
public class HomePage extends WebDriverUtility{                             
                           
	WebDriver driver;
	 public HomePage(WebDriver driver) {            
		 this.driver = driver;
		 PageFactory.initElements(driver, this);
	 }
	 /**
	  * WebElement for Calendar link
	  */
	 @FindBy(xpath="//a[text()='Calendar']")
	 private WebElement calendar;
	 
	 public WebElement getCalendarLink()
	 {
		return calendar;
	 }
	 /**
	  * WebElement for Organization link
	  */
	 @FindBy(xpath="//a[text()='Organizations']")
	 private WebElement Organization;
	
	 public WebElement getOrganizationLink()
	 {
		return Organization;	
	 }
	 /**
	  * WebElement for Opportunities link
	  */
	 @FindBy(xpath="//a[text()='Opportunities']")
	 private WebElement Opportunities;
	
	 public WebElement getOpportunitiesLink()
	 {
		return Opportunities;
	 }
	 /**
	  * WebElement for Products link
	  */
	 @FindBy(xpath="//a[text()='Products']")
	 private WebElement Products;
	
	 public WebElement getProductsLink()
	 {
		return Products;
	 }
	 /**
	  * WebElement for More link
	  */
	 @FindBy(xpath="//a[text()='More']")
	 private WebElement More;
	
	 public WebElement getMoreLink()
	 {
		return More;
	 }
	 /**
	  * WebElement for Vendors link
	  */
	 @FindBy(xpath="//a[text()='Vendors']")
	 private WebElement Vendors;
	
	 public WebElement getVendorsLink()
	 {
		return Vendors;
	 }
	 /**
	  * WebElement for Campaigns link
	  */
	 @FindBy(xpath="//a[text()='Campaigns']")
	 private WebElement Campaigns;
	 
	 public WebElement getCampaignsLink()
	 {
		return Campaigns;
	 }
	 /**
	  * WebElement for AdministratorImage
	  */
	 @FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	 private WebElement  AdministratorImage;
	 
	 public WebElement getAdministratorImage()
	 {
		return AdministratorImage;
	 }
	 /**
	  * WebElement for Sign out
	  */
	 @FindBy(xpath="//a[text()='Sign Out']")
	 private WebElement  SignOut;
	 
	 public WebElement getSignOut()
	 {
		return SignOut;
	 }
}

	

	
	

