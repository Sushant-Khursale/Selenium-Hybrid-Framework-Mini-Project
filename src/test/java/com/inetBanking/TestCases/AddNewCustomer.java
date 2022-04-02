package com.inetBanking.TestCases;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import com.inetBanking.PageObjects.LoginPage;
import com.inetBanking.PageObjects.ManagerHomePage;

import junit.framework.Assert;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import com.inetBanking.PageObjects.*;


public class AddNewCustomer extends BaseClass {
	
	@Test
	public void addNewCustomer() throws InterruptedException, IOException {
		
		LoginPage lp = new LoginPage(driver);
		lp.enterUserId(userid);
		lp.enterPassword(password);
		lp.clickLoginButton();
		
		ManagerHomePage mhp = new ManagerHomePage(driver);
		mhp.addNewCustomer();
		
		Thread.sleep(5000);
		
		driver.navigate().refresh();
		mhp.addNewCustomer();
		
		Thread.sleep(2000);
		
		AddCustomer ac = new AddCustomer(driver);
		ac.enterCustName("Manoj Nagarkar");
		ac.enterCustGender();
		ac.enterCustDob("25", "04", "1995");
		ac.enterCustAddr("Ambad Dist Jalna");
		ac.enterCustCity("Ambad");
		ac.enterCustState("MH");
		ac.enterCustPin("431001");
		ac.enterCustMobileNo("8208006106");
		
		String email = generateEmailId()+"@domain.com";// Generating new cust email id each time, as duplicates are not allowed
		ac.enterCustEmailId(email);
		ac.enterCustPassword("12345678");
		ac.clickSubmit();
		
		try {
			driver.switchTo().alert().accept();
			takeScreenShot(driver,"addNewCustomer");
			Assert.assertTrue(false);	
		}
		catch(Exception e)
		{
			Assert.assertTrue(true);	
		}
		
		/*boolean chkRegistered =driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(chkRegistered==true) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
			
		}*/
			
	}
	
	public String generateEmailId()
	{
		RandomStringUtils rsu = new RandomStringUtils();
		String email = rsu.randomAlphanumeric(8);
		return email;
	}

}
