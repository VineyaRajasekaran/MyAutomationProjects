package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EbayObjects {
	public WebDriver driver;
	
	public EbayObjects(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="glbfooter")
	WebElement Footer;
	
	public WebElement getFooter()
	{
		return Footer;
	}
	
	
	@FindBy(xpath="//table[@class='gf-t']/tbody/tr/td[2]")
	WebElement SellColumn;
	
	public WebElement getSellColumn()
	{
		return SellColumn;
	}
}
