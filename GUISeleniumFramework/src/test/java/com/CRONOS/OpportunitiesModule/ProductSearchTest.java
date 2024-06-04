package com.CRONOS.OpportunitiesModule;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.basetest.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;

import com.comcast.crm.objectrepositoryutility.HomePage;

import com.comcast.crm.objectrepositoryutility.ProductPage;


@Listeners(com.comcast.crm.generic.listenerutility.ListImpClass.class)
public class ProductSearchTest extends BaseClass {
	@Test
	public void ProductSearch() throws Throwable {
		
		HomePage hp = new HomePage(driver);
		ProductPage pp = new ProductPage(driver);
	
		hp.getProductsLink().click();
		UtilityClassObject.getTest().log(Status.INFO, "clicked on product link");
		String product = driver.findElement(By.xpath("(//a[text()='Products'])[2]")).getText();
		Assert.assertTrue(product.contains(product));
		UtilityClassObject.getTest().log(Status.INFO, "product page verified");

		String productquantity = eLib.getDataFromExcel("ProductModule", 4, 2).toString();
		pp.getSearchfortextfield().sendKeys(productquantity);
		UtilityClassObject.getTest().log(Status.INFO, "product quantity entered in search textfield");
		WebElement searchindropdown = pp.getSearchIndropdown();
		wLib.select(searchindropdown, 4);
		pp.getSearchnowbutton().click();
		UtilityClassObject.getTest().log(Status.INFO, "product quantity searched");
		
		Thread.sleep(2000);
		WebElement Quantity = driver.findElement(By.xpath("//td[contains(text(),'20000.000')]"));
		String actualquantity = Quantity.getText();
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		//wait.until(ExpectedConditions.visibilityOf(Quantity));

		Assert.assertTrue(productquantity.equals(actualquantity));
		UtilityClassObject.getTest().log(Status.PASS, "product quentity verified");
	}

}
