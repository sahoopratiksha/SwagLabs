package test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pojo.Browser;
import pom.LoginPage;
import utility.Reports;

public class VerifyTheLoginFuntionality extends BaseTest{
	
	ExtentReports reports;
	ExtentTest test;
	
	@BeforeTest
	public void configureReports() {
		reports = Reports.createReports();
	}
	
	@BeforeMethod
	public void OpenBrowser() {
		driver=Browser.launchBrowser();	
	}
	@Test
	public void CustomerIsAbleToLogin() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameField();
		loginPage.enterPasswordInPasswordField();
		loginPage.clickOnLoginButton();
		Assert.assertEquals(driver.getTitle(),"Swag Labs");
	}

}
