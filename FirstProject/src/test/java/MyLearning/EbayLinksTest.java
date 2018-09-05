package MyLearning;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.EbayObjects;
import testBase.TestBase;

public class EbayLinksTest extends TestBase{
private static final Logger log = LogManager.getLogger(AmazonHomeTest.class.getName());
	
	@BeforeTest
	public void InvokeBrowser() throws IOException
	
	{
		WebDriver driver =InitialiseBrowser();
		String link = prop.getProperty("url2");
		driver.get(link);
		
	}
	
	@Test
	public void CountLinks()
	{
		String Sitemap;
		EbayObjects eb= new EbayObjects(driver);
		WebElement footer = eb.getFooter();
		int count = footer.findElements(By.tagName("a")).size();
		WebElement column = footer.findElement(By.xpath("//table[@class='gf-t']/tbody/tr/td[2]"));
		
		int colcount = column.findElements(By.tagName("a")).size();
		String EHomepage = driver.getTitle();
		log.info(driver.getTitle());
		for(int i=0;i<colcount;i++)
		{
			if(column.findElements(By.tagName("a")).get(i).getText().contains("Site map"))
			{
			column.findElements(By.tagName("a")).get(i).click();
			
			break;
			}
		}
		
		Sitemap=driver.getTitle();
		log.info(Sitemap);
		
		if(EHomepage.equals(Sitemap))
		{
			log.info("fail");
		}
		else
		{
			log.info("pass");
		}
		
		
			
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
		driver=null;
	}

}
