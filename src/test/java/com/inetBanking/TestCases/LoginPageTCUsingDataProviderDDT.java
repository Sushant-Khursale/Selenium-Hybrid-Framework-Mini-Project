package com.inetBanking.TestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.PageObjects.LoginPage;
import com.inetBanking.PageObjects.ManagerHomePage;
import com.inetBanking.Utilities.XLUtils;

import junit.framework.Assert;

public class LoginPageTCUsingDataProviderDDT extends BaseClass {
	
	@Test(dataProvider="LoginData")
	public void executeLoginDDT(String user, String pwd) {
		
		LoginPage loginclass = new LoginPage(driver);
		
		loginclass.enterUserId(user);
		loginclass.enterPassword(pwd);
		loginclass.clickLoginButton();
		
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();
			Assert.assertTrue(false);
			driver.switchTo().defaultContent();// makes the driver switch to the login page again
		}
		else
		{
			Assert.assertTrue(true);
			ManagerHomePage mhp = new ManagerHomePage(driver);
			mhp.clickLogout();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
	}
	
	public boolean isAlertPresent() {
		try
		{
			driver.switchTo().alert();
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
		
		
	}
	
	@DataProvider(name="LoginData")
	public String[][] getDataFromExcel() throws IOException{
		XLUtils accessXL = new XLUtils("./src/test/java/com/inetBanking/TestData/TestData_inetBankingV1.xlsx","Sheet1");
		int rowCount = accessXL.getRowCount();
		int colCount = accessXL.getColumnCount();
		String[][] logindata = new String[rowCount-1][colCount];
		
		for(int i=1;i<=rowCount-1;i++) {
			for(int j=0;j<colCount;j++) {
				
				logindata[i-1][j]= (String) accessXL.getData(i, j);
				
			}
		}
		
		return logindata;
		
		
	}

}
