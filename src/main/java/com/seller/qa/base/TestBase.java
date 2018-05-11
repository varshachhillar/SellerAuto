package com.seller.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.seller.qa.util.TestUtil;


public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static WebDriverWait wait;
	public int RESPONSE_STATUS_CODE_200 = 200;
	public int RESPONSE_STATUS_CODE_500 = 500;
	public int RESPONSE_STATUS_CODE_401 = 401;

	


	public TestBase() {
		System.out.println("test base consuctor");

		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\User1\\eclipse-workspace\\javaenv\\MavenAuto\\src\\main\\java\\com\\seller\\"
					+ "qa\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void initialization() {
		String browserName = prop.getProperty("browser");
		System.out.println("Test Base initialize method");

		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\User1\\Desktop\\AutoEnv\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		} 
		else if(browserName.equals("FF")) {
			System.setProperty("webdriver.gecko.driver","C:\\Users\\User1\\Desktop\\AutoEnv\\geckodriver-v0.19.1-win32\\geckodriver.exe");
			driver = new FirefoxDriver();
			}
	
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICT_WAIT, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver,30);
		
		driver.get(prop.getProperty("url"));
	}
	
	
	
	
	
	
}
