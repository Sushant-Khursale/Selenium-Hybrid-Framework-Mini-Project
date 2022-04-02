package com.inetBanking.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewAccount {
	WebDriver driver;
	By custId = By.name("cusid");
	By selectAccount = By.name("selaccount");
	By initialDeposit = By.name("inideposit");
	By submitButton = By.xpath("//input[@name=\"button2\"]");
	
	public NewAccount(WebDriver driver) {
		this.driver= driver;
			
	}
	
	public void enterCustId(String txt) {
		driver.findElement(custId).sendKeys(txt);
	}
	
	public void enterInitialDeposit(String txt) {
		driver.findElement(initialDeposit).sendKeys(txt);
	}
	
	public WebElement selAccountType() {
		WebElement accountType = driver.findElement(selectAccount);
		return accountType;
	}
	
	public void clickSubmit() {
		driver.findElement(submitButton).click();
	}

}
