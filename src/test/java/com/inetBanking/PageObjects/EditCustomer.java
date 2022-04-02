package com.inetBanking.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EditCustomer {
	
	WebDriver driver;
	By custId = By.name("cusid");
	By submitButton = By.name("AccSubmit");
	By resetButton = By.xpath("//input[@type=\"reset\"]");
	
	public EditCustomer(WebDriver driver) {
		this.driver= driver;
	}
	
	
	public void enterCustomerId(String id) {
		driver.findElement(custId).sendKeys(id);
	}
	
	public void clickSubmit() {
		driver.findElement(submitButton).click();
	}
	
	public void clickReset() {
		driver.findElement(resetButton).click();
	}
	
	

}
