package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Retc_017POM {
	private WebDriver driver;
	
	public Retc_017POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
}
	@FindBy(id="user_login")
	private WebElement userName; 
	
	@FindBy(id="user_pass")
	private WebElement password;
		
	@FindBy(xpath="//*[@class='button border margin-top-10' and @type='submit']")
	private WebElement LoginBtn;
	
	@FindBy(xpath="//*[@id='menu-posts']/a/div[2]")
	private WebElement Clickpost;
	
	@FindBy(xpath="//*[@id=\"menu-posts\"]/ul/li[3]/a")
	private WebElement Clickaddnew2;
	
	@FindBy(id="title")
	private WebElement Newlaunch;
	
	@FindBy(id="content")
	private WebElement content1;
	
	@FindBy(name="publish")
	private WebElement publish1;
	
	
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
	    public void Clickpost1() {
			this.Clickpost.click();}
	    
	    public void Clickaddnew3(){
		    this.Clickaddnew2.click();
	      
	    }
	    public void Newlaunch1 (){
		    this.Newlaunch.sendKeys("New Launches - Neeraj");
}
	    public void content2 (){
		    this.content1.sendKeys("Test launch");  
}
	    public void publish2 (){
		    this.publish1.click();}
}
	    