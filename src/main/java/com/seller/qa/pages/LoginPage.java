package com.seller.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.seller.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//Page Factory - Object Repository
	@FindBy(name="email")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//button[contains(text(),\"Log in\")]")
	WebElement loginbtn;
	
	@FindBy(xpath="//*[contains(@href, '#/app/all-organisations')]")
	WebElement vendororganisation;
	
	//Initializing the Page Object:
	public LoginPage() {
		System.out.println("login page consuctor");
		PageFactory.initElements(driver, this);
	}
	
	//Action:
	public String validateLoginPageTitle(){
		System.out.println("login pagevalidate title method");
		return driver.getTitle();
	}
	
	public HomePage login(String un, String pwd) {
		System.out.println("login page login method");
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginbtn.click();
		wait.until(ExpectedConditions.visibilityOf(vendororganisation)); //ExplictWait
		
		return new HomePage();
		
	}
	
	
	
			

}
