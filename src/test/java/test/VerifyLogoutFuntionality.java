package test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pojo.Browser;
import pom.LoginPage;
import pom.SwagLabsHomePage;
import utility.Reports;

public class VerifyLogoutFuntionality extends BaseTest{
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
	public void CustomerIsAbleToLogout() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameField();
		loginPage.enterPasswordInPasswordField();
		loginPage.clickOnLoginButton();
		
		SwagLabsHomePage swagLabsHomePage= new SwagLabsHomePage(driver);
		swagLabsHomePage.clickOnMenuButton();
		//Thread.sleep(2000);
		swagLabsHomePage.waitForCartToDisplay(driver);
		swagLabsHomePage.clickOnlogout();
		//switchToWindow(swagLabsHomePage.clickOnLogOutButton(driver));
		
}
}