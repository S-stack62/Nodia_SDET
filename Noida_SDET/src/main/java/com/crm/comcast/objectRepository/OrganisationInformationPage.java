package com.crm.comcast.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationInformationPage {
	
	public OrganisationInformationPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement organisationInfo;

	/**
	 * @return the organisationInfo
	 */
	public WebElement getOrganisationInfo() {
		return organisationInfo;
	}
	
	public String getOrganisationText()
	{
		return organisationInfo.getText();
	}

}
