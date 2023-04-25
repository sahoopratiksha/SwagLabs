package test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pojo.Browser;
import pom.CartPageSwagLabs;
import pom.LoginPage;
import pom.SwagLabsHomePage;
import pom.checkoutPage;
import utility.Reports;

@Listeners(test.Listeners.class)

public class VerifyCheckOutFuntionality extends BaseTest {
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
	public void VerifyCheckoutFuntionality() {
		test =reports.createTest("VerifyCheckOutFuntionality");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameField();
		loginPage.enterPasswordInPasswordField();
		loginPage.clickOnLoginButton();
		
		SwagLabsHomePage swagLabsHomePage= new SwagLabsHomePage(driver);
		swagLabsHomePage.clickOnAddToCart();
		swagLabsHomePage.ClickOnCartButton();
		
		CartPageSwagLabs cartPageSwagLabs= new CartPageSwagLabs(driver) ;
		//cartPageSwagLabs.getCartItems();
        cartPageSwagLabs.waitForCartToDisplay(driver);
		cartPageSwagLabs.clickOnCheckout();
		checkoutPage CheckoutPage  =new checkoutPage (driver);
		CheckoutPage.enterFirstNameInNameField();
		CheckoutPage.enterLastNameInLastNameField();
		CheckoutPage.enterZipCode();
		CheckoutPage.cliclOnContinueButton();
		CheckoutPage.clickOnFinishButton();
	}

	
		

}
