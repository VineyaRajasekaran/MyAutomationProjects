package MyLearning;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.AmazonHome;
import testBase.TestBase;

public class WindowHandles extends TestBase{
	private static final Logger log = LogManager.getLogger(WindowHandles.class.getName());

	@BeforeTest
	public void InvokeBrowser() throws IOException

	{
		WebDriver driver = InitialiseBrowser();
		String link = prop.getProperty("url1");
		driver.get(link);
		log.info("browser opened");
	}

	@Test()
	public void GoogleWindow() {
		//driver.findElement(By.xpath(//a[@href='hl=en')).click();
		driver.findElement(By.xpath("//a[contains(text(),'Help')]")).click();
		Set<String> ids = driver.getWindowHandles();
		Iterator<String> i=  ids.iterator();
		String parent = i.next();
		String child = i.next();
		String titleParent= driver.getTitle();
		log.info("parent is" +titleParent);
		driver.switchTo().window(child);
		String childtitle= driver.getTitle();
		driver.close();
		log.info("child is" +childtitle);
		driver.switchTo().window(parent);
		String parentswitch= driver.getTitle();
		log.info("parent after switching is" +parentswitch);
		
		
		
	}
	
	
	
	@AfterTest
	public void teardown() {
		driver.close();
		driver = null;
	}


	
}
