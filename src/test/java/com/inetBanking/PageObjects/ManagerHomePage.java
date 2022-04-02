package com.inetBanking.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ManagerHomePage {
	
	WebDriver driver;
	
//	By addnewcustomer = By.linkText("New Customer");
	
	By addnewcustomer = By.xpath("//a[normalize-space()='New Customer']");
	By deletecustomer = By.cssSelector("a[href=\"DeleteCustomerInput.php\"]");
	By editcustomer = By.linkText("Edit Customer");
	By newAccount = By.xpath("//a[@href=\"addAccount.php\"]");
	
	By logout = By.linkText("Log out");
	
	public ManagerHomePage(WebDriver driver) {
		this.driver = driver;	
	}
	
	public void addNewCustomer() {
		driver.findElement(addnewcustomer).click();
	}
	
	public void editCustomer() {
		driver.findElement(editcustomer).click();
	}
	
	public void deleteCustomer() {
		driver.findElement(deletecustomer).click();
	}
	
	public void addNewAccount() {
		driver.findElement(newAccount).click();
	}
	
	public void clickLogout() {
		driver.findElement(logout).click();
	}
	
	
	

}
