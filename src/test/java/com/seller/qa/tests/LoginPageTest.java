package com.seller.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.seller.qa.base.TestBase;
import com.seller.qa.pages.HomePage;
import com.seller.qa.pages.LoginPage;



public class LoginPageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	
	public LoginPageTest() {
		super(); // will call parent class constructor
		System.out.println("login page test consuctor");
	}
	
	@BeforeMethod
	public void setup() {
		System.out.println("login page test before method setup");
		initialization();
		loginpage = new LoginPage();
		
	}
	
	@Test(priority=2)
	public void loginPageTitleTest() {
		System.out.println("login page test loginpage title test method");
		String title = loginpage.validateLoginPageTitle();
		Assert.assertEquals(title, "Industrybuying Seller Hub");
	}
	
	@Test(priority=1)
	public void loginTest() {
		System.out.println("login page test login test method");
		homepage = loginpage.login(prop.getProperty("username"),prop.getProperty("password"));

	}
	
	@AfterMethod
	public void teardown() {
		System.out.println("login page test after method tear down");
		driver.quit();
	}
	
	
	
	
	

}
