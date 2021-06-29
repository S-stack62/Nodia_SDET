package com.crm.comcast.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericUtils.WebDriverUtility;

public class HomePage extends WebDriverUtility{
	
	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Organizations")
	private WebElement organizationLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminstativeIMG;
	
	@FindBy(linkText="Sign Out")
	private WebElement signOutLink;

	/**
	 * @return the organizationLink
	 */
	public WebElement getOrganizationLink() {
		return organizationLink;
	}

	/**
	 * @return the contactLink
	 */
	public WebElement getContactLink() {
		return adminstativeIMG;
	}

	/**
	 * @return the signOutLink
	 */
	public WebElement getSignOutLink() {
		return signOutLink;
	}
	
	public void clickOnOrganisation()
	{
		organizationLink.click();
	}
	
	public void signOut()
	{
		mouseOver(driver, adminstativeIMG);
		signOutLink.click();
	}

}
