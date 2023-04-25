package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy(xpath="//input[@placeholder='Username']")private WebElement enterUserName;
	@FindBy(xpath="//input[@id='password']")private WebElement enterPassword;
    @FindBy(xpath="//input[@id='login-button']")private WebElement loginButton;
   
    public LoginPage(WebDriver driver) {
    PageFactory.initElements(driver,this);	
    }
    
    public void enterUserNameField() {
    	enterUserName.sendKeys("standard_user");
    }
    public void enterPasswordInPasswordField() {
    	enterPassword.sendKeys("secret_sauce");
    }
    public void clickOnLoginButton() {
    	loginButton.click();
    }
    
}
