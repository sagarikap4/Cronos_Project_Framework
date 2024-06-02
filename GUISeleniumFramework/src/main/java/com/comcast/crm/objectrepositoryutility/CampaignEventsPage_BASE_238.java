package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CampaignEventsPage {
	/**
	 * This page contains Campaigneventpage
	 */

	
	@FindBy(xpath = "//input[@name='subject']")
	private WebElement eventname;
	
	@FindBy(xpath = "//img[@id='jscal_trigger_date_start']")
	private WebElement eventstartdate;
	
	@FindBy(xpath = "//img[@id='jscal_trigger_due_date']")
    private WebElement eventenddate;
	
	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
	private WebElement savebutton;

	
	@FindBy(name = "startfmt")
	private WebElement pmdropdown;
	
	public WebElement getPmdropdown() {
		return pmdropdown;
	}

	public WebElement getEventname() {
		return eventname;
	}

	public WebElement getEventstartdate() {
		return eventstartdate;
	}

	public WebElement getEventenddate() {
		return eventenddate;
	}

	public WebElement getSavebutton() {
		return savebutton;
	}


}
