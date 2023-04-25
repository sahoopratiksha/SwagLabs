package test;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pojo.Browser;
import pom.CartPageSwagLabs;
import pom.LoginPage;
import pom.SwagLabsHomePage;
import utility.Reports;

@Listeners(test.Listeners.class)

public class VerifyAddToCartSwagLabs extends BaseTest {
	ExtentReports reports;
	ExtentTest test;
	
	@BeforeTest
	public void configureReports() {
		reports = Reports.createReports();
	}
	
	@BeforeMethod
	public void OpenBrowser() {
		driver =Browser.launchBrowser();
	}
	@Test
	public void addProductToCart() {
		test =reports.createTest("addProductToCart");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameField();
		loginPage.enterPasswordInPasswordField();
		loginPage.clickOnLoginButton();
		
		SwagLabsHomePage swagLabsHomePage= new SwagLabsHomePage(driver);
		swagLabsHomePage.clickOnAddToCart();
		
		CartPageSwagLabs cartPageSwagLabs= new CartPageSwagLabs(driver) ;
		//switchToChildWindow(swagLabsHomePage.getProductName(0));
		cartPageSwagLabs.getCartItems();
	}
	@Test
	public void VerifyRemoveFuntionality() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameField();
		loginPage.enterPasswordInPasswordField();
		loginPage.clickOnLoginButton();
		
		SwagLabsHomePage swagLabsHomePage= new SwagLabsHomePage(driver);
		swagLabsHomePage.clickOnAddToCart();
		
		CartPageSwagLabs cartPageSwagLabs= new CartPageSwagLabs(driver) ;
		cartPageSwagLabs.getCartItems();
		
		cartPageSwagLabs.clickOnRemoveButton();
	}
	@AfterMethod
	public void captureResults(ITestResult result) {
		if (result.getStatus() == ITestResult.SUCCESS)
		{
			test.log(Status.PASS,result.getName());
		}
		else if(result.getStatus() == ITestResult.FAILURE)
		{
			test.log(Status.FAIL,result.getName());
		}
		else if(result.getStatus() == ITestResult.SKIP)
		{
			test.log(Status.SKIP,result.getName());
		}	
	}
	@AfterTest
	public void publishReports() {
		reports.flush();
	}

}

	


