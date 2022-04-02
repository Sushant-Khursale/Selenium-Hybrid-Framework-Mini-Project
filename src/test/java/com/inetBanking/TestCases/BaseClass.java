package com.inetBanking.TestCases;

import java.io.File;
import java.io.IOException;

import com.inetBanking.Utilities.*;
import java.time.Duration;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetBanking.PageObjects.LoginPage;

public class BaseClass {

	ReadConfig rc = new ReadConfig();

	WebDriver driver;
	Logger logger;

	public String BaseURL = rc.getURL();
	public String userid = rc.getUsername();
	public String password = rc.getPassword();

	@BeforeClass
	@Parameters("browser")
	public void setUp(String br) throws InterruptedException {
		
		if(br.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", rc.getChromepath());
			driver = new ChromeDriver();
			
		}
		else if(br.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", rc.getFirefoxpath());
			driver = new FirefoxDriver();
		}
		
		driver.get(rc.getURL());
		driver.manage().window().maximize();
		
		logger = LogManager.getLogger(BaseClass.class.getName());
	}

	@AfterClass
	public void tearDownTest() {
		driver.quit();
	}
	
	public void takeScreenShot(WebDriver driver,String testCaseName) throws IOException {
		//convert webdriver object to TakesScreenshot
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		
		//create image using getScreenshotAs method
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		
		//move file to destination
		File destFile = new File(System.getProperty("user.dir")+"/Screenshots/"+testCaseName+".png");
		
		//copy the file at destination
		FileUtils.copyFile(SrcFile, destFile);
		
	}

}
