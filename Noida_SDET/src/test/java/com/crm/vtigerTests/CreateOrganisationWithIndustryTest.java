package com.crm.vtigerTests;

import java.util.concurrent.TimeUnit;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.GenericUtils.ExcelUtility;
import com.crm.GenericUtils.JSONFileUtility;
import com.crm.GenericUtils.JavaUtility;
import com.crm.GenericUtils.WebDriverUtility;
import com.crm.comcast.objectRepository.CreateOrganisationPage;
import com.crm.comcast.objectRepository.HomePage;
import com.crm.comcast.objectRepository.LoginPage;
import com.crm.comcast.objectRepository.OrganisationInformationPage;
import com.crm.comcast.objectRepository.OrganisationPage;

public class CreateOrganisationWithIndustryTest {

	@Test
	public void createOrganisationWithIndustry() throws ParseException, Throwable
	{
		WebDriverUtility wUtil=new WebDriverUtility();
		
		JSONFileUtility jUtil=new JSONFileUtility();
		String URL=jUtil.readDataFromJSON("url");
		String USERNAME=jUtil.readDataFromJSON("username");
		String PASSWORD=jUtil.readDataFromJSON("password");
		
		ExcelUtility eUtil=new ExcelUtility();
		String organisationName=eUtil.getExcelData("Sheet1", 3, 2) + JavaUtility.getRandomData();
		String indus=eUtil.getExcelData("Sheet1", 3, 3);
		
		//launch browser
		WebDriver driver=new ChromeDriver();
		wUtil.waitUntilPageLoad(driver);

		//get URL
		driver.get(URL);

		//login to the Application
		LoginPage lp=new LoginPage(driver);
		lp.login(USERNAME, PASSWORD);

		//Navigate to organizations
		wUtil.waitUntilPageLoad(driver);
		HomePage hp=new HomePage(driver);
		hp.clickOnOrganisation();
		
		//Navigate to create Organisation
		OrganisationPage orgPage=new OrganisationPage(driver);
		orgPage.clickOnCreateOrganisationImg();
		
		CreateOrganisationPage createOrgPage=new CreateOrganisationPage(driver);
		createOrgPage.createOrganization(organisationName, indus);

		//Verification
		OrganisationInformationPage orgInfoPage=new OrganisationInformationPage(driver);
		String actualOrgInfo=orgInfoPage.getOrganisationText();
		Assert.assertTrue(actualOrgInfo.contains(organisationName));
	}

}
