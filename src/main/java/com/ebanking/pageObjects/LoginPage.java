package com.ebanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver) {
		// TODO Auto-generated constructor stub
		this.ldriver = rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	@FindBy(xpath="//*[@name='uid']")
	@CacheLookup
	WebElement username;
	
	@FindBy(xpath="//*[@name='password']")
	@CacheLookup
	WebElement password;
	
	@FindBy(xpath="//*[@value ='LOGIN']")
	@CacheLookup
	WebElement logonbutton ;
	
	@FindBy(xpath="//*[@value ='RESET']")
	@CacheLookup
	WebElement resetButton ;
	
	public void setUsername(String userName){
		
		username.sendKeys(userName);
		
	}
	
	public void setPassword(String passWord) {
		
		password.sendKeys(passWord);
	}
	
	public void getLogonButton() {
		
		logonbutton.click();
	}
	
	public void resetThelogin() {
		
		resetButton.click();
	}
	
	
	
}
