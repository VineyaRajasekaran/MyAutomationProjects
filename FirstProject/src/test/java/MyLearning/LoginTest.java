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

import pageObjects.AmazonHome;
import testBase.TestBase;

public class LoginTest extends TestBase {

	private static final Logger log = LogManager.getLogger(AmazonHomeTest.class.getName());

	@BeforeTest
	public void InvokeBrowser() throws IOException

	{
		WebDriver driver = InitialiseBrowser();
		String link = prop.getProperty("url");
		driver.get(link);
		log.info("browser opened");
	}

	@Test(dataProvider = "getData")
	public void LoginVerify(String uname, String pwd) {
		AmazonHome ah = new AmazonHome(driver);
		ah.getHelloSignIn().click();
		ah.getEmail().sendKeys(uname);
		// ah.getPassword().sendKeys(pwd);
		// ah.getSubmit().click();
		ah.getContinue().click();
		ah.getPassword().sendKeys(pwd);
		ah.getSubmit().click();
		log.info(driver.getTitle());
		Actions a = new Actions(driver);
		a.moveToElement(ah.getHelloSignIn()).build().perform();
		ah.getSignout().click();

	}

	/*@BeforeClass
	public void EnterinCapital() {
		Actions a = new Actions(driver);
		AmazonHome ah = new AmazonHome(driver);
		a.moveToElement(ah.getSearchTextBox()).keyDown(Keys.SHIFT).sendKeys("Headphone").doubleClick().build()
				.perform();
	}*/

	@AfterMethod
	public void Terminate()
	{
		driver.close();
		driver=null;
	}
	
	
	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[1][2];
		// 0th row
		data[0][0] = "vineya@gmail.com";
		data[0][1] = "yohan2015";

		return data;
	}

}
