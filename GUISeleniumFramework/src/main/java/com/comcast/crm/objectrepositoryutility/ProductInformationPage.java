package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInformationPage {
	/**
	 * This class Contains the WebElement and its return type of ProductInformation page
	 * @param driver
	 */
	
	public ProductInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@class='lvtHeaderText']")
	private WebElement productinformationpage;

	public WebElement getProductinformationpage() {
		return productinformationpage;
	}

}
