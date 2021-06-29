package com.crm.comcast.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericUtils.WebDriverUtility;

public class CreateOrganisationPage extends WebDriverUtility{
	
	public CreateOrganisationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="accountname")
	private WebElement organizationName;
	
	@FindBy(name="industry")
	private WebElement industryDropdown;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;

	/**
	 * @return the organizationName
	 */
	public WebElement getOrganizationName() {
		return organizationName;
	}

	/**
	 * @return the industryDropdown
	 */
	public WebElement getIndustryDropdown() {
		return industryDropdown;
	}

	/**
	 * @return the saveButton
	 */
	public WebElement getSaveButton() {
		return saveButton;
	}
	
	public void createOrganization(String orgName, String industryType)
	{
		organizationName.sendKeys(orgName);
	    selectOption(industryDropdown, industryType);
	    saveButton.click();
	}

}
