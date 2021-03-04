package com.capsule.qa.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.capsule.qa.baseclass.Testbase;
import com.capsule.qa.pages.Homepage;
import com.capsule.qa.pages.LoginPage;



public class LoginPageTest extends Testbase {
	LoginPage loginpage;
	Homepage homepage;
	
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		intialization();
		loginpage = new LoginPage();
	}
	
	
	@Test
	public void VerifyLoginPageTest() throws InterruptedException {
		loginpage.getUserName(prop.getProperty("username"));		
		loginpage.getPassword(prop.getProperty("password"));
		String logintitle = loginpage.getLoginPageTitle();		
		assertEquals(logintitle, "zeetab CRM");
		Boolean blnImg = loginpage.verifyCapsuleImage();
		assertTrue(blnImg);		
		homepage = loginpage.verifyLogin();	
		Thread.sleep(2000);
		String strErrorpage = driver.getTitle();
		System.out.println(strErrorpage);
		if  (strErrorpage.equalsIgnoreCase("Expired page")) {
		System.out.println("-----");
		WebElement backbtn = driver.findElement(By.xpath("//a[text()='Return to home page']"));
		backbtn.click();
		Thread.sleep(2000);
		loginpage.getUserName(prop.getProperty("username"));		
		loginpage.getPassword(prop.getProperty("password"));
		homepage = loginpage.verifyLogin();	
		}
	}
	
	@AfterMethod
	public void tearDown() {
		if (driver!=null) {
		//driver.quit();
	}
	}
	

}
