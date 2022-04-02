package com.inetBanking.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	By userid = By.name("uid");
	By password = By.name("password");
	By login_button = By.name("btnLogin");
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver1) {
		this.driver = driver1;
		
	}
	
	public void enterUserId(String txt) {
		driver.findElement(userid).sendKeys(txt);
	}
	
	public void enterPassword(String txt) {
		driver.findElement(password).sendKeys(txt);
	}
	
	public void clickLoginButton() {
		driver.findElement(login_button).click();
	}
	
	
	

}
