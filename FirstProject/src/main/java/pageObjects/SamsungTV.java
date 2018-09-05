package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SamsungTV {
	
	public WebDriver driver;
	
	
	public SamsungTV(WebDriver driver)
	{
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(xpath="//h2[text()='Samsung UN40H5003 40-Inch 1080p LED TV (2014 Model)']")
	WebElement myTV;
	
	public WebElement getMyTV()
	{
		return myTV;
	}
	

}
