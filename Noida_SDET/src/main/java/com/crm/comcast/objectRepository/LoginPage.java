package com.crm.comcast.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {            //Rule-1 : Create separate Java class for every Page in Application
	
	public LoginPage(WebDriver driver)  //Rule-4 : Create Constructor to Initialize the Element
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBys({@FindBy(name="user_name"), @FindBy(xpath="//input[@type='text']")})  //Rule-2: Go to every page in an app. & identify all elements using @findBy, @findBys & @findAll annotations & store them in specific java class in POM
	private WebElement usernameEdt;
	
	@FindBy(name="user_password")
	private WebElement passwordEdt;
	
	@FindBy(id="submitButton")
	private WebElement loginbtn;

	/**
	 * @return the usernameEdt
	 */
	public WebElement getUsernameEdt() {  //Rule-3: As per POM, Declare all element as Private & provide public getters methods to give read access to test scripts.
		return usernameEdt;
	}

	/**
	 * @return the passwordEdt
	 */
	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	/**
	 * @return the loginbtn
	 */
	public WebElement getLoginbtn() {
		return loginbtn;
	}

	/**
	 * Buisness Logic to Login
	 * @param username
	 * @param password
	 */
	public void login(String username, String password) // Rule-5: In all testscripts Utilize the element using getter(), Business method.
	{
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		loginbtn.click();
	}
	
}
