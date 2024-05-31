package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {
	WebDriver driver;
	public OrganizationPage(WebDriver driver) {            
		 this.driver = driver;
		 PageFactory.initElements(driver, this);
	 }
	/**
	  * WebElement for Create Organization Image
	  */
	 @FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	 private WebElement CreateOrganizationImage;
	 
	 public WebElement getCreateOrganizationImage()
	 {
		return CreateOrganizationImage;
	 }
	 /**
	  * WebElement for Organization Name Text field
	  */
	 @FindBy(xpath="//input[@name='accountname']")
	 private WebElement OrganizationTextfield;
	 
	 public WebElement getOrganizationTextfield()
	 {
		return OrganizationTextfield;
	 }
	 /**
	  * WebElement for create Organization save button
	  */
	 @FindBy(xpath="//input[@title='Save [Alt+S]']")
	 private WebElement CreateOrganizationSaveButton;
	 
	 public WebElement getCreateOrganizationSaveButton()
	 {
		return CreateOrganizationSaveButton;
	 }

}
