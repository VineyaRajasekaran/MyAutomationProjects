package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	
	public static WebDriver driver;
	public Properties prop;
	
	public WebDriver InitialiseBrowser() throws IOException
	{
		 prop = new Properties();
		 FileInputStream fis = new FileInputStream("C:\\Users\\dinav\\FirstProject\\src\\main\\java\\resources\\data.properties");
		 prop.load(fis);
		String browsername =  prop.getProperty("browser");
		if(browsername.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\dinav\\Downloads\\chromedriver_win32_Version2.35\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browsername.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\dinav\\Downloads\\geckodriver-v0.19.1-win64_extract\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		return driver;
	}
	
	public void getScreenshotNow(String result) throws IOException
	{
		System.out.println("result is "+result);
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Users\\dinav\\"+result+"screenshot.png"));
	}

}
