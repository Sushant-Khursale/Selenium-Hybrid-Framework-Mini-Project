package com.inetBanking.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddCustomer {
	
	WebDriver driver;
	
	By cust_name = By.xpath("/html[1]/body[1]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[4]/td[2]/input[1]");
	By cust_gender = By.xpath("//input[@value='m']");
	By cust_dob = By.id("dob");
	By cust_addr = By.xpath("//textarea[@name=\"addr\"]");
	By cust_city = By.xpath("//input[@name=\"city\"]");
	By cust_state = By.xpath("//input[@name=\"state\"]");
	By cust_pin = By.xpath("//input[@name=\"pinno\"]");
	By cust_mobileno = By.xpath("//input[@name=\"telephoneno\"]");
	By cust_emailid = By.xpath("//input[@name=\"emailid\"]");
	By cust_password = By.xpath("//input[@name=\"password\"]");
	By submit_button = By.xpath("//input[@value=\"Submit\"]");
	
	public AddCustomer(WebDriver driver) {
		this.driver=driver;
		
	}
	
	
	public void enterCustName(String txt) {
		driver.findElement(cust_name).sendKeys(txt);
	}
	
	
	public void enterCustGender() {
		driver.findElement(cust_gender).click();
	}
	
	
	public void enterCustDob(String dd, String mm, String yyyy) {
		driver.findElement(cust_dob).sendKeys(dd);
		driver.findElement(cust_dob).sendKeys(mm);
		driver.findElement(cust_dob).sendKeys(yyyy);
		
	}
	
	
	
	public void enterCustAddr(String txt) {
		driver.findElement(cust_addr).sendKeys(txt);
	}
	
	//for editing the customer details
	public void clearCustAddr() {
		driver.findElement(cust_addr).clear();
	}
	
	public void enterCustCity(String txt) {
		driver.findElement(cust_city).sendKeys(txt);
	}
	
	//for editing the customer details
		public void clearCustCity() {
			driver.findElement(cust_city).clear();
		}
	
	public void enterCustState(String txt) {
		driver.findElement(cust_state).sendKeys(txt);
	}
	
	//for editing the customer details
			public void clearCustState() {
				driver.findElement(cust_state).clear();
			}
	
	public void enterCustPin(String txt) {
		driver.findElement(cust_pin).sendKeys(txt);
	}
	
	//for editing the customer details
	public void clearCustPin() {
		driver.findElement(cust_pin).clear();
	}
	
	public void enterCustMobileNo(String txt) {
		driver.findElement(cust_mobileno).sendKeys(txt);
	}
	
	//for editing the customer details
		public void clearCustMobileNo() {
			driver.findElement(cust_mobileno).clear();
		}
	
	public void enterCustEmailId(String txt) {
		driver.findElement(cust_emailid).sendKeys(txt);
	}
	
	//for editing the customer details
		public void clearCustEmailId() {
			driver.findElement(cust_emailid).clear();
		}
	
	public void enterCustPassword(String txt) {
		driver.findElement(cust_password).sendKeys(txt);
	}
	
	
	public void clickSubmit() {
		driver.findElement(submit_button).click();
	}
	
	
	

}
