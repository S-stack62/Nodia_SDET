package com.crm.vtigerTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.crm.GenericUtils.ExcelUtility;
import com.crm.GenericUtils.JavaUtility;
import com.crm.GenericUtils.PropertyUtility;
import com.crm.GenericUtils.WebDriverUtility;

public class CreateOrganisationTest {
	
	@Test
	public void createOrganisationTest() throws Throwable
	{
		WebDriverUtility wUtil=new WebDriverUtility();
		
		PropertyUtility pUtil=new PropertyUtility();
		String URL=pUtil.getPropertyKeyValue("url");
		String USERNAME=pUtil.getPropertyKeyValue("username");
		String PASSWORD=pUtil.getPropertyKeyValue("password");
		
		ExcelUtility eUtil=new ExcelUtility();
		String orgName=eUtil.getExcelData("Sheet1", "TC_02", "IndustryType");
		//Launch the browser
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		wUtil.waitUntilPageLoad(driver);
		
		//Get URL
		driver.get(URL);
		
		//Login into the application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//Navigate to Organisation
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Organizations")).click();
		
		//Create Organisation
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(orgName+JavaUtility.getRandomData());
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	}

}
