package com.inetBanking.TestCases;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.inetBanking.PageObjects.LoginPage;
import com.inetBanking.PageObjects.ManagerHomePage;
import com.inetBanking.PageObjects.NewAccount;

import junit.framework.Assert;

public class NewAccountTC extends BaseClass {
	
	@Test
	public void createNewBankAccount() {
		
		LoginPage lp = new LoginPage(driver);
		lp.enterUserId(userid);
		lp.enterPassword(password);
		lp.clickLoginButton();
		
		ManagerHomePage mhp = new ManagerHomePage(driver);
		mhp.addNewAccount();
		
		driver.navigate().refresh();
		
		mhp.addNewAccount();
		
		NewAccount na= new NewAccount(driver);
		na.enterCustId("31965");
		WebElement accountType = na.selAccountType();
		
		Select sel = new Select(accountType);
		sel.selectByVisibleText("Current");
		
		na.enterInitialDeposit("40000");
		
		na.clickSubmit();
		
		if(driver.getPageSource().contains("Account Generated Successfully!!!")==true) {
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
	}

}
