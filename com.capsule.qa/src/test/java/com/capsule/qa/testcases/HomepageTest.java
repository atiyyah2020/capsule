package com.capsule.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.capsule.qa.baseclass.Testbase;
import com.capsule.qa.pages.Homepage;
import com.capsule.qa.pages.LoginPage;



public class HomepageTest  extends Testbase {
	LoginPage loginpage;
	Homepage homepage;
	
	public HomepageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		intialization();
		homepage = new Homepage();
		loginpage = new LoginPage();		
		loginpage.getUserName(prop.getProperty("username"));		
		loginpage.getPassword(prop.getProperty("password"));
		homepage = loginpage.verifyLogin();	
		String strErrorpage = driver.getTitle();
		System.out.println(strErrorpage);
		if  (strErrorpage.equalsIgnoreCase("Expired page")) {		
		WebElement backbtn = driver.findElement(By.xpath("//a[text()='Return to home page']"));
		backbtn.click();
		Thread.sleep(2000);
		loginpage.getUserName(prop.getProperty("username"));		
		loginpage.getPassword(prop.getProperty("password"));
		homepage = loginpage.verifyLogin();	
		}
	}

	@Test
	public void validatehomepageTest() {
		homepage.MenuAddClick();
	}
	
	
	
	
	@AfterMethod
	public void tearDown() {
		//driver.quit();
	}
	
	
	
	
	
	
}
