package pom;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class  CartPageSwagLabs{
	
	@FindBy(xpath="//div[@class='cart_item']")private List<WebElement> cartItems;
    @FindBy(xpath="//button[@id='remove-sauce-labs-backpack']")private WebElement removeButton;
    @FindBy(xpath="//button[@id='checkout']")private WebElement checkoutButton;
    @FindBy(xpath="//button[@id='continue-shopping']")private WebElement continueShoppingButton;
    
	public  CartPageSwagLabs(WebDriver driver) {
		PageFactory.initElements(driver,this);	
		}
	
	public int getCartItems() { 
		int size=cartItems.size();
		return size;
	}
	public void clickOnRemoveButton() {
		removeButton.click();
	}
	public void clickOnCheckout() {
		checkoutButton.click();
	}
	public void clickOnContinueShoppingButton() {
		continueShoppingButton.click();
	}
	public void waitForCartToDisplay(WebDriver driver) {
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofMillis(3000));
		wait.until(ExpectedConditions.visibilityOf(checkoutButton));
	}
 } 

