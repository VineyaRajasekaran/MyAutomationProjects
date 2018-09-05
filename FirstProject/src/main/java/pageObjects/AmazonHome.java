package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonHome {
	public WebDriver driver;
	
	public AmazonHome(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="twotabsearchtextbox")
	WebElement SearchText;
	
	@FindBy(id="searchDropdownBox")
	WebElement All;
	

	@FindBy(xpath="//input[@value='Go']")
	WebElement Search;
	
	public WebElement getSearchTextBox()
	{
		return SearchText;
	}
	
	public WebElement getSearchSubmit()
	{
		return Search;
	}
	
	public WebElement getAll()
	{
		return All;
	}
	
	
	@FindBy(id="nav-link-accountList")
	WebElement HelloSignIn;
	
	public WebElement getHelloSignIn()
	{
		return HelloSignIn;
	}
	
	
	
	@FindBy(xpath="//span[@class='nav-action-inner']")
	WebElement SignIn;
	
	public WebElement getSignIn()
	{
		return SignIn;
	}
	
	
	
	@FindBy(id="ap_email")
	WebElement Email;
	
	public WebElement getEmail()
	{
		return Email;
	}
	
	
	
	@FindBy(id="ap_password")
	WebElement Pass;
	
	public WebElement getPassword()
	{
		return Pass;
	}
	
	@FindBy(id="signInSubmit")
	WebElement Submit;
	
	public WebElement getSubmit()
	{
		return Submit;
	}
	
	
	@FindBy(id="continue")
	WebElement Continue;
	
	public WebElement getContinue()
	{
		return Continue;
	}
	
	
	@FindBy(xpath="//span[text()='Sign Out']")
	WebElement SignOut;
	
	public WebElement getSignout()
	{
		return SignOut;
	}
	
	@FindBy(linkText="Today's Deals")
WebElement TodayDeals;
	
	public WebElement getTodayDeals()
	{
		return TodayDeals;
	}
	
}
