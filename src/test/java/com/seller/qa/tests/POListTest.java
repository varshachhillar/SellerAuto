package com.seller.qa.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.seller.qa.base.TestBase;
import com.seller.qa.pages.HomePage;
import com.seller.qa.pages.LoginPage;
import com.seller.qa.pages.POList;

public class POListTest extends TestBase {
	
	
	LoginPage loginpage;
	HomePage homepage;
	POList polist;
	
	
	public POListTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginpage = new LoginPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		polist = homepage.clickPOList();
	}
	
//	@Test
//	public void verifyPOPageName() {
//		String name = polist.validatePOPageName();
//		Assert.assertEquals(name, "PO List");
//	}
	
	@Test
	public void createPOTest() {
		polist.createNewPO(prop.getProperty("poname"),prop.getProperty("client"));
	}

	
	@AfterMethod
	public void teardown() {
		driver.quit();		
	}
	

}
