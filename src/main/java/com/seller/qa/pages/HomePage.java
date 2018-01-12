package com.seller.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.seller.qa.base.TestBase;

public class HomePage extends TestBase{
	
	//Page Factory - Object Repository
	@FindBy(xpath= "//li[@class='dropdown']/a/span[2]")
	WebElement username;
	
	@FindBy(xpath="//*[contains(@href, '#/app/po-list/')]")
	WebElement polist;
	
	@FindBy(xpath = "//*[contains(text(),'Client Order Date')]")
	WebElement codate;
	
	
	//Initializing the Page Object:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	//Action:
		public String validateHomePageTitle(){
			return driver.getTitle();
		}
		
		public POList clickPOList() {
			polist.click();
			wait.until(ExpectedConditions.visibilityOf(codate));
			return new POList();
		}
		
		public String ValidateUsername() {
			return username.getText();
		}
	
	
	
	
	
	
	
	

}
	