package MyLearning;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.AddtoCart;
import pageObjects.AmazonHome;
import pageObjects.SamsungTV;
import testBase.TestBase;



public class AmazonHomeTest extends TestBase {
	
	private static final Logger log = LogManager.getLogger(AmazonHomeTest.class.getName());
	
	@BeforeTest
	public void InvokeBrowser() throws IOException
	
	{
		WebDriver driver =InitialiseBrowser();
		String link = prop.getProperty("url");
		driver.get(link);
		
	}
	
	@Test
	public void EnterSearchItem()
	{
		AmazonHome ah = new AmazonHome(driver);
		ah.getSearchTextBox().sendKeys("Samsung 40 inch TV");
		ah.getSearchSubmit().click();
		System.out.println(driver.getTitle());
		SamsungTV stv= new SamsungTV(driver);
		WebDriverWait wait = new WebDriverWait(driver, 3000L);
		wait.until(ExpectedConditions.elementToBeClickable(stv.getMyTV())).click();;
		AddtoCart ac= new AddtoCart(driver);
		wait.until(ExpectedConditions.elementToBeClickable(ac.getAddToCart())).click();
//	wait.until(ExpectedConditions.elementToBeClickable(ac.getNoThanks())).click();
		//ac.getNoThanks().click();
		//wait.until(ExpectedConditions.elementToBeClickable(ac.getAdd())).click();
		
		//ac.getProceedCheckouts().click();
		
	}
	
	@AfterMethod
	public void Terminate()
	{
		driver.close();
		driver=null;
	}
	
	

}
