package ai.ds.testBase;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



import ai.ds.pageLayer.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	public static WebDriver driver;
	public static Logger logger;
	
	
	public LoginPage login;
	
	
	@BeforeClass
	public void start()
	{
		logger = Logger.getLogger("DalalStreet Framework");
		PropertyConfigurator.configure("Log4j.properties");
		logger.info("Framework execution started");
	}
	
	@AfterClass
	public void end()
	{
		logger.info("Framework execution ended");
	}

	@BeforeMethod
	public void setUp() throws InterruptedException
	{
		String br = "CHROME";
		
		if(br.equalsIgnoreCase("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(br.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(br.equalsIgnoreCase("Edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else 
		{
			System.out.println("Browser name is not proper");
		}
		
		driver.get("https://www.apps.dalalstreet.ai/login");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		logger.info("Browser lauches "+br);
		logger.info("maximize, provided implicitly wait");
		
		
		//------------ Login to application--------
		login = new LoginPage();
		login.enterEmailID();
		login.enterPassword();
		login.clickOnLoginButton();
		Thread.sleep(4000);
		
		logger.info("Logged into application");
		
	}
		
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
		logger.info("Browser closed");
	}

}
