package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignPage {
	/**
	 * This class contains Campaign page elements
	 * @param driver
	 */
	 
	public CampaignPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//img[@title='Create Campaign...']")
	private WebElement campaignicon;
	
	@FindBy(name = "search_text")
	private WebElement searchtextfield;
	
	@FindBy(name = "search_field")
	private WebElement searchindropdown;
	
	@FindBy(name = "submit")
	private WebElement searchnowbutton;
	


	public WebElement getCampaignicon() {
		return campaignicon;
	}

	public WebElement getSearchtextfield() {
		return searchtextfield;
	}

	public WebElement getSerachindropdown() {
		return searchindropdown;
	}

	public WebElement getSearchnowbutton() {
		return searchnowbutton;
	}


	
	
	
	
	
	

}
