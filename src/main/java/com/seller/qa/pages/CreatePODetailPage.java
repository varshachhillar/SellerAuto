package com.seller.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.seller.qa.base.TestBase;

public class CreatePODetailPage extends TestBase {
	
	//Page Factory - Object Repository
	@FindBy(xpath="//*[@class='h4']")
	WebElement poname;
	
	@FindBy(name="date")
	WebElement biddate;
	
	@FindBy(xpath="//div[@class='calendar second left']/div/table/tbody/*/td[@class='available today active start-date end-date']")
	WebElement bidstartdate;
	
	@FindBy(xpath="//div[@class='calendar first right']/div/table/tbody/*/td[@class='available today active start-date end-date']")
	WebElement bidenddate;
	
	@FindBy(xpath="//button[text()='Apply']")
	WebElement apply;
	
	@FindBy(name="sales_exec_name")
	WebElement saleexename;
	
	@FindBy(name="spoc")
	WebElement spoc;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement save;
	
	@FindBy(xpath="//*[@class='btn btn-default ']")
	WebElement choosefile;
	
	@FindBy(xpath="//*[@type='button' and @class='btn btn-addon btn-success']")
	WebElement upload;
	
	@FindBy(xpath="//*[text()='Mapping']")
	WebElement mapping;
	
	@FindBy(xpath="//*[text()='Refresh']")
	WebElement refresh;
	
	@FindBy(xpath="//*[text()='brand']")
	WebElement brand;
	
	@FindBy(xpath="//*[text()='category']")
	WebElement category;
	
	@FindBy(xpath="//*[text()='description1']")
	WebElement description1;
	
	@FindBy(xpath="//*[text()='brand']/../div/span/div/div/span")
	WebElement brandchoice;
	
	@FindBy(xpath="//*[text()='category']/../div/span/div/div/span")
	WebElement categorychoice;
	
	@FindBy(xpath="//*[text()='description1']/../div/span/div/div/span")
	WebElement description1choice;
	
		
	//Initializing the Page Object:
	public CreatePODetailPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Action 2017-12-05 11:00 AM
	public void fillPODetail(String spocname, String filename) throws IOException {
		
//		biddate.click();
//		bidstartdate.click();
//		bidenddate.click();
//		apply.click();
//		saleexename.sendKeys("automation");
//		spoc.sendKeys(spocname);
//		save.click();
		
		choosefile.click();
		Runtime.getRuntime().exec("C:\\Users\\User1\\Desktop\\AutoEnv\\Upload.exe");
		upload.click();
		
		do{
			refresh.click();
			}while(brand.isDisplayed());
		
		Select selectByVisibleText = new Select (categorychoice);
		selectByVisibleText.selectByVisibleText("Category file");

		
		
        }


}
