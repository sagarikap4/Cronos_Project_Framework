package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignEventsPage {
	/**
	 * This page contains Campaign event page
	 */

	public CampaignEventsPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
<<<<<<< HEAD
	
	
	@FindBy(xpath = "//input[@name='subject']")
	private WebElement eventname;
	
	@FindBy(name = "date_start")
	private WebElement eventstartdate;
	
	@FindBy(name = "due_date")
=======
	@FindBy(xpath = "//input[@name='subject']")
	private WebElement eventname;
	
	@FindBy(xpath = "//input[@name='date_start']")
	private WebElement eventstartdate;
	
	@FindBy(xpath = "//input[@name='due_date']")
>>>>>>> upstream/master
    private WebElement eventenddate;
	
	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[2]")
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
