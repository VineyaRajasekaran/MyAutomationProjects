package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CricLiveScoreObjects {
	
	public WebDriver driver;
			
	public CricLiveScoreObjects(WebDriver driver)
	{
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="article[class='sub-module scorecard']")
	WebElement Table1;
	
	public WebElement getTable1()
	{
		return Table1;
	}
	
	
	
	@FindBy(xpath="//div[@class='cell']/following-sibling::div[1]")
	WebElement ExtrasChild;
	
	public WebElement getExtrasChild()
	{
		return ExtrasChild;
	}
	
	
	
	@FindBy(xpath="//div[text()='TOTAL']/following-sibling::div")
	WebElement Total;
	
	public WebElement getTotal()
	{
		return Total;
	}

}
