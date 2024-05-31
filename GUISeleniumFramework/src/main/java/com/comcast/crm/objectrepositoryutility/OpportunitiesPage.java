package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class OpportunitiesPage extends WebDriverUtility {
	
	WebDriver driver;
	public OpportunitiesPage(WebDriver driver) {            
		 this.driver = driver;
		 PageFactory.initElements(driver, this);
	 }
	/**
	  * WebElement for CreateOpportunity image
	  */
	 @FindBy(xpath="//img[@title='Create Opportunity...']")
	 private WebElement CreateOpportunity;
	 
	 public WebElement getCreateOpportunity()
	 {
		return CreateOpportunity;
	 }
	 /**
	  * WebElement for Opportunity Name textfield
	  */
	 @FindBy(xpath="//input[@name='potentialname']")
	 private WebElement OpportunityNameTextfield;
	 
	 public WebElement getOpportunityNameTextfield()
	 {
		return OpportunityNameTextfield;
	 }
	 /**
	  * WebElement Group Radio Button
	  */
     @FindBy(xpath="//input[@value='T']")
     private WebElement GroupRadioButton;
     
     public WebElement getGroupRadioButton()
	 {
		return GroupRadioButton;
	 }
     /**
      * WebElement Related To Select Icon
      */
     @FindBy(xpath="//img[@src='themes/softed/images/select.gif']")
     private WebElement RelatedToSelectIcon;
     
     public WebElement getRelatedToSelectIcon()
	 {
		return RelatedToSelectIcon;
	 }
     /**
      * WebElement Calendar icon
      */
     @FindBy(xpath="//img[@id='jscal_trigger_closingdate']")
     private WebElement CalendarIcon;
     
     public WebElement getCalendarIcon()
	 {
		return CalendarIcon;
	 }
     /**
      * WebElement Create Opportunity page Save Button
      */
     @FindBy(xpath="//input[@title='Save [Alt+S]']")
     private WebElement CreateOpportunitySaveButton;
     
     public WebElement getCreateOpportunitySaveButton()
	 {
		return CreateOpportunitySaveButton;
	 }
}
