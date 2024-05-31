package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignInformationPage {
	/**
	 * This class contains Campaign Information page elements
	 * @param driver
	 */
	
	public CampaignInformationPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement verifycampaignheadermsg;
	
	@FindBy(linkText = "Add Event")
	private WebElement addevents;
	
	@FindBy(id = "mouseArea_Campaign Name")
	private WebElement verifycampaignname;

	public WebElement getVerifycampaignheadermsg() {
		return verifycampaignheadermsg;
	}


	public WebElement getAddevents() {
		return addevents;
	}

	public WebElement getVerifycampaignname() {
		return verifycampaignname;
	}

}
