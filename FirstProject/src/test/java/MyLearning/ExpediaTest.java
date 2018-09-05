package MyLearning;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.CalendarObjects;
import testBase.TestBase;

public class ExpediaTest extends TestBase{
private static final Logger log = LogManager.getLogger(AmazonHomeTest.class.getName());
	
	@BeforeTest
	public void InvokeBrowser() throws IOException
	
	{
		WebDriver driver =InitialiseBrowser();
		String link = prop.getProperty("url3");
		driver.get(link);
		
	}
	
	@Test
	public void CalendarTest()
	
	{
		CalendarObjects c= new CalendarObjects(driver);
		c.getFromDate().click();
		
		System.out.println(c.getMonths().getText());
		
		while(!(c.getMonths().getText().contains("Jun")))
		{	
			
			c.getNextButton().click();
		}
		
		
		int count = driver.findElements(By.cssSelector(".datepicker-cal-date")).size();
		for(int i=0;i<count;i++)
		{
			String text =driver.findElements(By.cssSelector(".datepicker-cal-date")).get(i).getText();
			String digit = extractDigits(text);
			
			if(digit.equalsIgnoreCase("10"))
			{
				System.out.println("click date");
				driver.findElements(By.cssSelector(".datepicker-cal-date")).get(i).click();
				break;
			}
		}
		
		
		c.getToDate().click();
		
		
		for(int i=0;i<count;i++)
		{
			String text1 =driver.findElements(By.cssSelector(".datepicker-cal-date")).get(i).getText();
			String digit1 = extractDigits(text1);
			
			if(digit1.equalsIgnoreCase("28"))
			{
				driver.findElements(By.cssSelector(".datepicker-cal-date")).get(i).click();
				break;
			}
		}
		
		
		
		
		
	}
	
	@AfterTest
	public void Terminate()
	{
		driver.close();
		driver=null;
	}
	


	public static  String extractDigits(String src) {
	    StringBuilder builder = new StringBuilder();
	    for (int i = 0; i < src.length(); i++) {
	        char c = src.charAt(i);
	        if (Character.isDigit(c)) {
	            builder.append(c);
	        }
	    }
	    return builder.toString();
	}
	

}
