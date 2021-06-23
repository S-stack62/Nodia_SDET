package com.crm.vtigerTests;

import java.util.concurrent.TimeUnit;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.crm.GenericUtils.ExcelUtility;
import com.crm.GenericUtils.JSONFileUtility;
import com.crm.GenericUtils.JavaUtility;
import com.crm.GenericUtils.WebDriverUtility;

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
		String indus=eUtil.getExcelData("Sheet1", "TC_02", "IndustryType");
		
		//launch browser
		WebDriver driver=new ChromeDriver();
		wUtil.waitUntilPageLoad(driver);

		//get URL
		driver.get(URL);

		//login to the Application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();

		//Navigate to organizations
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Organizations")).click();

		//Navigate to create Organisation
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys("techM"+JavaUtility.getRandomData());

		WebElement industry=driver.findElement(By.name("industry"));
		wUtil.selectOption(industry, indus);

		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	}

}
