package MyLearning;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.AmazonHome;
import testBase.TestBase;

public class CapitalEnterTest extends TestBase {
	private static final Logger log = LogManager.getLogger(CapitalEnterTest.class.getName());

	@BeforeTest
	public void InvokeBrowser() throws IOException

	{
		WebDriver driver = InitialiseBrowser();
		String link = prop.getProperty("url");
		driver.get(link);
		log.info("browser opened");
	}

	@Test()
	public void EnterinCapital() {
		Actions a = new Actions(driver);
		AmazonHome ah = new AmazonHome(driver);
		a.moveToElement(ah.getSearchTextBox()).click().keyDown(Keys.SHIFT).sendKeys("Headphone").doubleClick().build()
				.perform();
		
		
		a.moveToElement(ah.getHelloSignIn()).contextClick().build().perform();
		String HomePageTitle =driver.getTitle();
		log.info("HomePageis  "+driver.getTitle());
		//a.moveToElement(ah.getTodayDeals()).click().build().perform();
		//log.info("Todats Deal Title is "+driver.getTitle());
		//String TodaysDealsTitle =driver.getTitle();
		//Assert.assertEquals(HomePageTitle, TodaysDealsTitle);
	
	
	}
	
	@AfterTest
	public void teardown() {
		driver.close();
		driver = null;
	}


	
}
