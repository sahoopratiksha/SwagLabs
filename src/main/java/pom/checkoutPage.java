package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class checkoutPage {
	
	@FindBy(xpath="//input[@id='first-name']")private WebElement namefield;
	@FindBy(xpath="//input[@id='last-name']")private WebElement lastname;
	@FindBy(xpath="//input[@id='postal-code']")private WebElement zipCode;
	@FindBy(xpath="//input[@id='continue']")private WebElement continueButton;
	@FindBy(xpath="//button[@id='cancel']")private WebElement cancel;
	@FindBy(xpath="//button[@id='finish']")private WebElement finish;

	public checkoutPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void enterFirstNameInNameField() {
		namefield.sendKeys("pratiksha");
	}
	public void enterLastNameInLastNameField() {
		lastname.sendKeys("sahoo");
	}
	public void enterZipCode() {
		zipCode.sendKeys("1234");
	}
	public void cliclOnContinueButton() {
		continueButton.click();
	}
	public void clickOnCancelButton() {
		cancel.click();
	}
	public void clickOnFinishButton() {
		finish.click();
	}
}
