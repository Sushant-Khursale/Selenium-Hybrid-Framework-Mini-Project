package com.inetBanking.TestCases;

import org.testng.annotations.Test;

import com.inetBanking.PageObjects.LoginPage;
import com.inetBanking.PageObjects.ManagerHomePage;

import junit.framework.Assert;

public class LogoutTC extends BaseClass{
	
	@Test
	public void executeLogout() {
		
		LoginPage lp = new LoginPage(driver);
		lp.enterUserId(userid);
		lp.enterPassword(password);
		lp.clickLoginButton();
		
		ManagerHomePage mhp = new ManagerHomePage(driver);
		mhp.clickLogout();
		
		driver.switchTo().alert().accept();
		
		if(driver.getTitle().equals("Guru99 Bank Home Page"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
	}

}
