package com.inetBanking.TestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.inetBanking.PageObjects.LoginPage;

public class LoginPageTC extends BaseClass {
	
	@Test
	public void executeLoginFunctionality() throws IOException {
		LoginPage loginclass = new LoginPage(driver);
		
		driver.manage().window().maximize();	
		logger.info("URL is opened and window is maximized");
		
		loginclass.enterUserId(userid);
		loginclass.enterPassword(password);
		loginclass.clickLoginButton();
		
		String title = driver.getTitle();
		String exptitle = "Guru99 Bank Manager HomePage1";
		
		
		if(title.equals(exptitle)){
			Assert.assertTrue(true,"The test case has passed");
			
		}
		else {
			takeScreenShot(driver,"executeLoginFunctionality");
			Assert.assertTrue(false,"The test case has failed miserably.");
		}
		
		
//		SoftAssert sassert = new SoftAssert(); // Soft assertion 
//		sassert.assertEquals(title, exptitle);
		//sassert.assertAll();// This method call is expected for the soft assertion to throw the error otherwise the execution proceeds without any error 
		
		System.out.println("After the soft assertion");
		
		
		logger.debug("Debug message");
		logger.fatal("Fatal message");
		logger.error("Error message");
		logger.warn("Warn message");
		
	}

}
