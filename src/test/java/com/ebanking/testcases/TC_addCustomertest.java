package com.ebanking.testcases;

import java.io.IOException;

import org.apache.logging.log4j.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ebanking.pageObjects.AddnewCustomer;
import com.ebanking.pageObjects.LoginPage;
import com.ebanking.utilities.RandomeNumb;

import resources.base;


public class TC_addCustomertest extends base{
	
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());
	
	@Parameters("browser")
	@BeforeTest
	public void setUp(String browserParam) throws IOException {
		log.info("Driver need to initialize");
		driver = initializeDriver(browserParam);		
		log.trace("Driver initialized");
		
		
		//xdriver.manage().deleteAllCookies();
		
	}
	
	@Test
	public void addNewCustomer() throws Exception {
        LoginPage lp = new LoginPage(driver);
		
		lp.setUsername(userName);
		lp.setPassword(password);
		lp.getLogonButton();
		log.info("Button clicked");
		
		AddnewCustomer addNewCustomer = new AddnewCustomer(driver);
		log.info("New Customer link is clicked");
		addNewCustomer.clicknewCustomerlink();
		Thread.sleep(5000);
		
		addNewCustomer.selectGender("Female");		
		addNewCustomer.addName("Akash");
		addNewCustomer.addAddress("Belathur kadugodi");
		addNewCustomer.addCity("Bangalore");
		addNewCustomer.addDOB("08","05","1991");
		String email=RandomeNumb.randomEmailString();
		addNewCustomer.addEmail(email);	
		String password=RandomeNumb.randomPassword();
		addNewCustomer.addPassword(password);
		addNewCustomer.addMobileNo("8795461321");
		addNewCustomer.addPin("560067");
		addNewCustomer.addState("KRNATAKA");
		log.info("Datas are filled insode the fields");
		Thread.sleep(2000);
		addNewCustomer.clickSubmitButton();
		Thread.sleep(2000);
		boolean isDisplayedText = driver.findElement(By.xpath("//*[contains(text(),'Successfully!!!')]")).isDisplayed();
		
		if(isDisplayedText) {
			
			 Assert.assertTrue(true, "Successfully navigated to the page");
			 log.info("Add Customer data tests are passed");
		}else {
			Assert.assertFalse(true, "Not in the correct page");
		}
		
	}
	
		
	@AfterTest
	public void tearDown() {
		
		driver.close();
		 log.info("Browser is closed");
	}
	
	

}
