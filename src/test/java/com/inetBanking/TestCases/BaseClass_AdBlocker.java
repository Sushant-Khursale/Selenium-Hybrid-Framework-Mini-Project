package com.inetBanking.TestCases;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.inetBanking.PageObjects.LoginPage;

public class BaseClass_AdBlocker {
	
	WebDriver driver;
	public String BaseURL = "https://demo.guru99.com/V4/";
	public String userid = "mngr266311";
	public String password = "YvuzYtY";
	
	@BeforeClass
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hp User\\eclipse-workspace\\inetBankingV1\\Drivers\\chromedriver.exe");
		//driver = new ChromeDriver();
		
		//Code for installing ad-blocker in the chrome browser instance opened by WebDriver
				ChromeOptions co = new ChromeOptions();
				co.addExtensions(new File("C:\\Users\\Hp User\\Downloads\\AdBlock-—-best-ad-blocker.crx"));
				DesiredCapabilities capabilities = new DesiredCapabilities();
				capabilities.setCapability(ChromeOptions.CAPABILITY, co);
				co.merge(capabilities);
				
				driver = new ChromeDriver(co);
				driver.manage().window().maximize();
				
				driver.switchTo().newWindow(WindowType.TAB);
				
				//driver.get(BaseURL);
				
		
	}
	
	@AfterClass
	public void tearDownTest() {
		driver.quit();
	}

}
