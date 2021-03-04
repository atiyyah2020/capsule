package com.capsule.qa.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.capsule.qa.baseclass.Testbase;

public class Homepage extends Testbase {

	public Homepage() {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath ="//div[@id='select-box-el-32']//span[contains(text(),'Add')]")
	WebElement menuAddClick;
		
	@FindBy(xpath ="//a[@class ='ember-view menu-select__option' and contains(text(),'Person')]")
	WebElement menupersonClick;
	
	@FindBy(xpath ="//div[@id='ember42-form-control']//div")
	List<WebElement> personTitile;
	
	@FindBy(id="ember44-form-control")
	WebElement txtfirstname;
	
	@FindBy(id="ember45-form-control")
	WebElement txtlastname;
	
	@FindBy(id="ember46-form-control")
	WebElement txtjobtitle;
	
	@FindBy(id="select-box-el-49")
	WebElement txtjobtitlea;
	
	@FindBy(id="select-box-el-51")
	WebElement txttags;
	
	@FindBy(xpath ="//input[@class='form-input-text party-form-phone-number']")
	WebElement txtphonenumber;
	
	@FindBy(xpath ="//input[@class='form-input-text party-form-email-address']")
	WebElement txtemailid;
	
	@FindBy(xpath ="//div[@class='select-box single-select chunky']//div[contains(text(),'Work')]")
	WebElement btnemailWorktype;
	
	@FindBy(xpath ="//div[@id='select-box-el-448']/div]")
	WebElement btnemailWorkOpts;
	
	@FindBy(xpath ="//button[@class='repeater__add button button--bare' and normalize-space()='+ Add address']")
	WebElement addressClick;
	
	@FindBy(xpath ="//textarea[@class='form-input-text party-form-address-street']")
	WebElement txtaddress;
	
	
	
		
	public void MenuAddClick() {
		menuAddClick.click();
		Actions action = new Actions(driver);
		action.moveToElement(menupersonClick).build().perform();
		menupersonClick.click();
	}
	
	
	
}
