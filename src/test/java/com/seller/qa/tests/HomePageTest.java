package com.seller.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.seller.qa.base.TestBase;
import com.seller.qa.pages.HomePage;
import com.seller.qa.pages.LoginPage;
import com.seller.qa.pages.POList;

public class HomePageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	POList polist;
	
	
	public HomePageTest() {
		super(); // will call parent class constructor
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginpage = new LoginPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test
	public void homePageTitleTest() {
		String title = homepage.validateHomePageTitle();
		Assert.assertEquals(title, "Seller Hub Industrybuying");
	} 
	
	@Test
	public void verifyUsernameTest() {
		String user = homepage.ValidateUsername();
		Assert.assertEquals(user,"him@ib.com");
	}
	

	@AfterMethod
	public void teardown() {
		driver.quit();		
	}
	
}
