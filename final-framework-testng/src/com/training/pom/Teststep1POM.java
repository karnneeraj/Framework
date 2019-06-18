package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Teststep1POM {
	private WebDriver driver;
	
	public Teststep1POM(WebDriver driver) {
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
	
	@FindBy(xpath="//*[@id=\"menu-posts\"]/ul/li[2]/a")
	private WebElement ClickAllpost;
	
	@FindBy(xpath="//*[@id=\"menu-posts\"]/ul/li[3]/a")
	private WebElement Clickaddnew;
	
	@FindBy(xpath="//*[@id=\"menu-posts\"]/ul/li[4]/a")
	private WebElement Categories;
	
	@FindBy(xpath="//*[@id=\"menu-posts\"]/ul/li[5]/a")
	private WebElement Tags;
	
	

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
		this.Clickpost.click();
        }
	    public void ClickAllpost1(){
		this.ClickAllpost.click();
         }
	    public void Clickaddnew1(){
	    this.Clickaddnew.click();
}
	    public void Categories1()	{
	     this.Categories.click();
}
	     public void Tags1(){
	     this.Tags.click();
}
}