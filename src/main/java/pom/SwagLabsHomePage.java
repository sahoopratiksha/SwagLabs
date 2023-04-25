package pom;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SwagLabsHomePage {
	@FindBy(xpath="(//div[@class='inventory_item_description'])[1]")private WebElement product;
	@FindBy(xpath="//div[@class='inventory_list']")private List<WebElement> products;
    @FindBy(xpath="(//button[text()='Add to cart'])[1]")private WebElement AaddToCart;
    @FindBy(xpath="//button[@id='react-burger-menu-btn']")private WebElement menuButton;
    @FindBy(xpath="//a[text()='Logout']")private WebElement logoutButton;
    @FindBy(xpath="//a[@class='shopping_cart_link']")private WebElement cartButton;
    
    public SwagLabsHomePage (WebDriver driver) {
    	PageFactory.initElements(driver, this);
    }
    public void clickOnAddToCart() {
    	AaddToCart.click();
    }
    public void clickOnMenuButton() {
    	menuButton.click();
    }
    public void clickOnlogout() {
    	logoutButton.click();
    }
    public void ClickOnCartButton() {
    	cartButton.click();
    }
    public void waitForCartToDisplay(WebDriver driver) {
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofMillis(3000));
		wait.until(ExpectedConditions.visibilityOf(logoutButton));
	}
    public int getNumberOfDisplayedProducts(WebDriver driver) {
	  	int size=products.size();
	  	return size;
	  	
	    }
	    public void selectProduct(int index) {
	    	products.get(index).click();
	    }
	    public String getProductName(int index) {
	    	return products.get(index).getText();
	    }

	    }

