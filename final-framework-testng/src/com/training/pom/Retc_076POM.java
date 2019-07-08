package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Retc_076POM {
	private WebDriver driver;
	
	public Retc_076POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
}
	@FindBy(id="user_login")
	private WebElement userName; 
	
	@FindBy(id="user_pass")
	private WebElement password;
	
	
	@FindBy(xpath="//*[@class='button border margin-top-10' and @type='submit']")
	private WebElement LoginBtn;
	
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	    public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	    }
	    public void clickLoginBtn() {
		this.LoginBtn.click(); 
	    }
	   

		
}