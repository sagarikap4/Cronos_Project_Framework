package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	/**
	 * This class contains the product page webElements and its return type
	 * @param driver
	 */

	public ProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement productlookupimage;
	
	@FindBy(name="search_text")
	private WebElement searchfortextfield;
	
	@FindBy(xpath="(//select[@name='search_field'])[1]")
	private WebElement searchIndropdown;
	
	@FindBy(xpath="(//input[@value=' Search Now '])[1]")
	private WebElement searchnowbutton;

	public WebElement getSearchfortextfield() {
		return searchfortextfield;
	}

	public WebElement getSearchIndropdown() {
		return searchIndropdown;
	}

	public WebElement getSearchnowbutton() {
		return searchnowbutton;
	}

	public WebElement getProductlookupimage() {
		return productlookupimage;
	}
	
	
}
