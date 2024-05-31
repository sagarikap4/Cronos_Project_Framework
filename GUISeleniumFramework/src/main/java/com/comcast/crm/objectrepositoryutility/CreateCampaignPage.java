package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaignPage {
	/**
	 * This class contains Create Campaign page elements
	 * @param driver
	 */
	
	public CreateCampaignPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name = "campaignname")
	private WebElement campaignname;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement savebutton;

	public WebElement getSavebutton() {
		return savebutton;
	}

	public WebElement getCampaignname() {
		return campaignname;
	}


	

}
