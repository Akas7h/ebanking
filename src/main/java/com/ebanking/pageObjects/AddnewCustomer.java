package com.ebanking.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddnewCustomer {
	
	public WebDriver ndriver;

public AddnewCustomer(WebDriver rdriver) {
	// TODO Auto-generated constructor stub
	this.ndriver = rdriver ;
	PageFactory.initElements(ndriver,this);	
}

@FindBy(linkText="New Customer")
@CacheLookup
WebElement linkaddnewCustomer;

@FindBy(xpath="//*[@type='text']")
@CacheLookup
WebElement customrname;

//Need to check
@FindBy(xpath="//*[@name='rad1']")
@CacheLookup
List<WebElement>selectGender;

@FindBy(xpath="//*[@name='dob']")
@CacheLookup
WebElement dateofBirth;

@FindBy(xpath="//*[@name='addr']")
@CacheLookup
WebElement address;


@FindBy(xpath="//*[@name='city']")
@CacheLookup
WebElement city;

@FindBy(xpath="//*[@name='state']")
@CacheLookup
WebElement state;

@FindBy(xpath="//*[@name='pinno']")
@CacheLookup
WebElement pin;

@FindBy(xpath="//*[@name='telephoneno']")
@CacheLookup
WebElement mobNumber;

@FindBy(xpath="//*[@name='emailid']")
@CacheLookup
WebElement email;


@FindBy(xpath="//*[@name='password']")
@CacheLookup
WebElement password;

@FindBy(xpath="//*[@name='sub']")
@CacheLookup
WebElement buttonSubmit;


@FindBy(xpath="//*[@value='Reset']")
@CacheLookup
WebElement buttonReset;

public void clicknewCustomerlink() {
	
	linkaddnewCustomer.click();
}

public void clickResetButton() {
	
	buttonReset.click();
}

public void clickSubmitButton() {
	
	buttonSubmit.click();
}

public void addPassword(String pwd) {
	
	password.sendKeys(String.valueOf(pwd));
}

public void addEmail(String emailparam) {
	
	email.sendKeys(emailparam);
}

public void addName(String namez) {
	
	customrname.sendKeys(namez);
}


public void addMobileNo(String mobnum) {
	
	mobNumber.sendKeys(String.valueOf(mobnum));
}

public void addPin(String pinnum) {
	
	pin.sendKeys(pinnum);
}

public void addState(String stateParam) {
	
	state.sendKeys(stateParam);
}

public void addCity(String cityparam) {
	
	city.sendKeys(cityparam);
}

public void addAddress(String addrsparam) {
	
	address.sendKeys(addrsparam);
}


public void addDOB(String mm,String dd,String yy) {
	
	dateofBirth.sendKeys(mm);
	dateofBirth.sendKeys(dd);
	dateofBirth.sendKeys(yy);
	
}

public void selectGender(String gendr) {
	
	int size = selectGender.size();
	for (int i = 0; i < size; i++) {
		String val = selectGender.get(i).getAttribute("value");
		Boolean buttonSelected = selectGender.get(i).isSelected();
		String trimString = gendr.substring(0,1);
		if(val.equalsIgnoreCase(trimString) && buttonSelected==false) {
			selectGender.get(i).click();
		}
	}
	
}







}
