package com.ebanking.testcases;

import java.io.IOException;

import org.apache.logging.log4j.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ebanking.pageObjects.LoginPage;
import com.ebanking.utilities.StoringCookie;

import resources.base;




public class TC_loginTest_001 extends base {

	public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());
	//how to send different browser from testng xml
	@Parameters("browser")
	@BeforeTest
	public void setUp(String browserParam) throws IOException {
		log.info("Driver need to initialize");
		driver = initializeDriver(browserParam);		
		log.info("Driver initialized");
		//xdriver.manage().window().maximize();
		//xdriver.manage().deleteAllCookies();
		
	}
	
	
	
	
	@Test
	public void loginTest() {
		
		//xdriver.get(url);
		log.info("LoginPage instance is created");
		LoginPage lp = new LoginPage(driver);
		
		lp.setUsername(userName);
		lp.setPassword(password);
		lp.getLogonButton();
		log.info("Button clicked");
		
		StoringCookie.getCookie(driver);
		//Assert.assertTrue(true);
		WebDriverWait wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Guru99 Bank']")));
		
				
		if(driver.getTitle().contains("Bank Manager")) {
			
			Assert.assertTrue(true);
			log.info("Successfully validated test cases");
		}else {
			Assert.assertTrue(false);
		}
	}
	

	
	
	
	
	
	
	
	@AfterTest
	public void tearDown() {
		
		driver.close();
		log.info("Driver is closed");
	}
	
	
	
}
