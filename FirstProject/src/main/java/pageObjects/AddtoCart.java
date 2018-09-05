package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddtoCart {
	
public WebDriver driver;
	
	
	public AddtoCart(WebDriver driver)
	{
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(xpath="//input[@id='add-to-wishlist-button-submit']")
	WebElement addCart;
	
	public WebElement getAddToCart()
	{
		return addCart;
	}
	
	//button[@id='siAddCoverage-announce']
	 
	@FindBy(xpath="//button[@id='siAddCoverage-announce']")
	WebElement Add;
	
	public WebElement getAdd()
	{
		return Add;
	}
	
	@FindBy(id="siNoCoverage-announce")
	WebElement NoThanks;
	
	public WebElement getNoThanks()
	{
		return NoThanks;
	}
	
	
	
	@FindBy(id="hlb-ptc-btn-native")
	WebElement ProceedCheckout;
	
	public WebElement getProceedCheckouts()
	{
		return ProceedCheckout;
	}
	
	
	

	@FindBy(id="createAccountSubmit")
	WebElement createAccount;
	
	public WebElement getCreateAccount()
	{
		return createAccount;
	}
	
	
	
	@FindBy(id="ap_customer_name")
	WebElement customerName;
	
	public WebElement getCustomerName()
	{
		return customerName;
	}
	 

}
