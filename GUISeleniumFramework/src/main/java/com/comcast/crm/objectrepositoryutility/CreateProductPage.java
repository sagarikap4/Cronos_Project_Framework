package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductPage {
	/**
	 * This class contains the elements and its retrun type in the CreateProductPage
	 * @param driver
	 */

	public CreateProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="productname")
	private WebElement productname;
	
	@FindBy(xpath="//img[@src='themes/softed/images/select.gif']")
	private WebElement vendorNameLookUpImage;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement savebutton;

	public WebElement getSavebutton() {
		return savebutton;
	}

	public WebElement getProductname() {
		return productname;
	}

	public WebElement getVendorNameLookUpImage() {
		return vendorNameLookUpImage;
	}
	
	
}
