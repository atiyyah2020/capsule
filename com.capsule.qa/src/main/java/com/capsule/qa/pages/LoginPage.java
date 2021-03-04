package com.capsule.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.capsule.qa.baseclass.Testbase;

public class LoginPage extends Testbase {
	
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='login:usernameDecorate:username']")
	WebElement username;
	
	@FindBy(xpath="//input[@id='login:passwordDecorate:password']")
	WebElement password;
	
	@FindBy(xpath="//input[@id='login:login']")
	WebElement btnLogin;
	
	@FindBy(xpath="//img[@alt='Capsule']")
	WebElement imgCapsule;
	
	
	
	public void getUserName(String UM) {
		//username.clear();
		username.sendKeys(UM);
	}
	
	public void getPassword(String PWD) {
		//password.clear();
		password.sendKeys(PWD);		
		
	}
	
	public String getLoginPageTitle() {
		return driver.getTitle();		
	}
	
	public boolean verifyCapsuleImage() {
		Boolean imgoption = imgCapsule.isDisplayed();
		return imgoption;
			
	}
	
	public Homepage verifyLogin() {		
		 btnLogin.click();		
		 return new Homepage();
	}
	
	
}
