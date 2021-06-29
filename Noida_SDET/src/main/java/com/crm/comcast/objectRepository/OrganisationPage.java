package com.crm.comcast.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationPage {
	
	public OrganisationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement createOrganisationLink;

	/**
	 * @return the createOrganisationLink
	 */
	public WebElement getCreateOrganisationLink() {
		return createOrganisationLink;
	}
	
	public void clickOnCreateOrganisationImg()
	{
		createOrganisationLink.click();
	}

}
