package TestCases;

import org.testng.annotations.BeforeMethod;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	
	
	public WebDriver driver;
	
	Properties prop = new Properties();
	
	@BeforeMethod
	public void setup() throws IOException
	{
		
		if(driver == null)
		{
			FileReader file = new FileReader(System.getProperty("user.dir")+"//ConfigProperty//Config.properties");
			prop.load(file);
		}
		if(prop.getProperty("browser").equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get(prop.getProperty("url"));
		}
		else if(prop.getProperty("browser").equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get(prop.getProperty("url"));
		}
	}
	
	@AfterMethod
	public void tearDown() 
	{
		driver.quit();
	}
}
