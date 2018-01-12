package com.seller.qa.tests;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.seller.qa.base.TestBase;
import com.seller.qa.pages.CreatePODetailPage;
import com.seller.qa.pages.HomePage;
import com.seller.qa.pages.LoginPage;
import com.seller.qa.pages.POList;

public class CreatePODetailTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	POList polist;
	CreatePODetailPage createpodetailpage;
		
	public CreatePODetailTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginpage = new LoginPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		polist = homepage.clickPOList();
		createpodetailpage = polist.createNewPO(prop.getProperty("poname"),prop.getProperty("client"));
		
	}
	
	@Test
	public void fillcorrectpodetail() throws IOException {
		createpodetailpage.fillPODetail(prop.getProperty("spoc"),prop.getProperty("filename"));
	}
	

	
	@AfterMethod
	public void teardown() {
		driver.quit();		
	}

}
