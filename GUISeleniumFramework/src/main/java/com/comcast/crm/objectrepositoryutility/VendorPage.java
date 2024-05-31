package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorPage {
	/**
	 * This class contains the webElement and its return type of Vendor page
	 * @param driver
	 */
	
	public VendorPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement vendorlookupimage;

	public WebElement getVendorlookupimage() {
		return vendorlookupimage;
	}


}
