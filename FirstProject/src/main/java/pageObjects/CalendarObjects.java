package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalendarObjects {
	
	public WebDriver driver;
	public CalendarObjects(WebDriver driver)
	{
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(id="package-departing-hp-package")
	WebElement FromDate;
	
	public WebElement getFromDate()
	{
		return FromDate;
	}
	
	
	@FindBy(id="package-returning-hp-package")
	WebElement ToDate;
	
	public WebElement getToDate()
	{
		return ToDate;
	}
	
	@FindBy(css=".datepicker-cal-date")
	WebElement dates;
	
	public WebElement getDates()
	{
		return dates;
	}
	
	
	
	@FindBy(css=".datepicker-cal-month-header")
	WebElement months;
	
	public WebElement getMonths()
	{
		return months;
	}
	
	
	
	@FindBy(xpath="//button[@class='datepicker-paging datepicker-next btn-paging btn-secondary next']")
	WebElement NextButton;
	
	public WebElement getNextButton()
	{
		return NextButton;
	}
	
	
	

}
