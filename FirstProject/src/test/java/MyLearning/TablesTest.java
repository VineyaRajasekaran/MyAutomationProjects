package MyLearning;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import org.testng.asserts.*;
import pageObjects.AmazonHome;
import pageObjects.CricLiveScoreObjects;
import testBase.TestBase;

public class TablesTest extends TestBase {

	private static final Logger log = LogManager.getLogger(AmazonHomeTest.class.getName());

	@BeforeTest
	public void InvokeBrowser() throws IOException

	{
		WebDriver driver = InitialiseBrowser();
		String link = prop.getProperty("url4");
		driver.get(link);

	}

	@Test()
	public void CountNoRuns() {

		CricLiveScoreObjects cs = new CricLiveScoreObjects(driver);
		WebElement table = cs.getTable1();
		int sum = 0;

		int count = table.findElements(By.cssSelector("div[class='wrap batsmen'] div:nth-child(3)")).size();
		log.info("count=" + count);
		for (int i = 0; i < count; i++) {
			String runs = table.findElements(By.cssSelector("div[class='wrap batsmen'] div:nth-child(3)")).get(i)
					.getText();
			// System.out.println(runs);
			sum = sum + Integer.parseInt(runs);

		}
		System.out.println(sum);

		String extras = cs.getExtrasChild().getText();
		String sub1= extras.substring(0, 1);
		System.out.println("sub1 "+sub1);
		int number=Integer.parseInt(sub1);
		int finalsum = sum + number;
		System.out.println("finalsum  " + finalsum);

		String Total = cs.getTotal().getText();
		String sub = Total.substring(0, 3);
		int tot =Integer.parseInt(sub);
		System.out.println("Total " + sub);
		
		Assert.assertEquals(tot, finalsum);
			
		log.debug("Runs score mathched Test Pass");
		

	}

	@AfterMethod
	public void teardown() {
		driver.close();
		driver = null;
	}

}
