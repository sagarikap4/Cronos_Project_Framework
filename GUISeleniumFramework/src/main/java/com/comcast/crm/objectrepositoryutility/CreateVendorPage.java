package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateVendorPage {
	
	/**
	 * This class contains the webElement and its retrun type of Create Vendor page
	 * @param driver
	 */

	public CreateVendorPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="vendorname")
	private WebElement vendortextfield;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement savebutton;

	public WebElement getVendortextfield() {
		return vendortextfield;
	}

	public WebElement getSavebutton() {
		return savebutton;
	}
}
