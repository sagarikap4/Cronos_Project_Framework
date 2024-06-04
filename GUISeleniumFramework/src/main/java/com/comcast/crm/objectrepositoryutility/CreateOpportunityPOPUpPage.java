package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOpportunityPOPUpPage {
	
	public CreateOpportunityPOPUpPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//input[@name='search_text']")
	private WebElement Searchorgname;
	
	public WebElement getSearchorgname() {
		return Searchorgname;
	}
	
	
	@FindBy(xpath = "//input[@name='search']")
	private WebElement SearchNowButton;

	public WebElement getSearchNowButton() {
		return SearchNowButton;
	}

	
}
