package com.inetBanking.TestCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.PageObjects.AddCustomer;
import com.inetBanking.PageObjects.EditCustomer;
import com.inetBanking.PageObjects.LoginPage;
import com.inetBanking.PageObjects.ManagerHomePage;

public class EditCustomerTC extends BaseClass {
	
	@Test
	public void editCustomerDetails() throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		lp.enterUserId(userid);
		lp.enterPassword(password);
		lp.clickLoginButton();
		
		ManagerHomePage mhp = new ManagerHomePage(driver);
		mhp.editCustomer();
		
		driver.navigate().refresh();
		mhp.editCustomer();
		
		Thread.sleep(5000);
		
		EditCustomer ec = new EditCustomer(driver);
		ec.enterCustomerId("56429");
		ec.clickSubmit();
		
		//for actual editing of the information
		AddCustomer ac = new AddCustomer(driver);
		ac.clearCustCity();
		ac.enterCustCity("Bangalore");
		
		ac.clearCustMobileNo();
		ac.enterCustMobileNo("8205555555");
		
		ac.clearCustPin();
		ac.enterCustPin("811004");
		
		Thread.sleep(6000);
		
		ac.clickSubmit();
		
		driver.switchTo().alert().accept();
		
		// 2 bugs are present here: 1) In address field special characters are getting accepted. 
		//2) Same msg appears on the screen for making changes and not making any.
		
		if(driver.getTitle().equals("Guru99 Bank Edit Customer Page"))
		{
			Assert.assertTrue(true,"Edit Customer: Test case has failed");
			
		}
		
		else 
		{
			Assert.assertTrue(false,"Edit Customer: Test case has passed");
		}
	}
	

	

}
