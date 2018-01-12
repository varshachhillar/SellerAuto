package com.seller.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.seller.qa.base.TestBase;

public class POList extends TestBase {
	
	//Page Factory - Object Repository
		@FindBy(xpath="//b[contains(text(),'PO List')]")
		WebElement pagename;
		
		@FindBy(xpath = "//*[contains(text(),'New PO')]//parent::button")
		WebElement newpo;
		
		@FindBy(xpath="//*[contains(text(),'Create New PO')]")
		WebElement createpo;
		
		@FindBy(id="input_0")
		WebElement poname;
		
		@FindBy(xpath="//select[@name='client']")
		WebElement client;
		
		@FindBy(xpath="//button/span[contains(text(),'Create')]")
		WebElement create;
		
		@FindBy(xpath="//*[contains(text(),'PO Detail')]")
		WebElement podetail;
		
	//Initializing the Page Object:
		public POList() {
			PageFactory.initElements(driver, this);
		}
		
	//Action:
		public String validatePOPageName(){
			return pagename.getText();
		}
		
		public CreatePODetailPage createNewPO(String name, String clientname) {
//			newpo.click();
//			Assert.assertEquals(createpo.getText(), "Create New PO");			
//			poname.sendKeys(name);
//			client.click();
//			Select select = new Select (client);
//			select.selectByVisibleText(clientname);
//			create.click();
			driver.navigate().to("http://seller.qa4.industrybuying.com/seller/#/app/po-detail/365");
			wait.until(ExpectedConditions.visibilityOf(podetail));
			return new CreatePODetailPage();

		} 
	

}
