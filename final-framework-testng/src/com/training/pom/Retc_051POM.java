package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Retc_051POM {
	private WebDriver driver;
	
	public Retc_051POM(WebDriver driver) {
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
	
	@FindBy(xpath="//*[@id=\"menu-posts\"]/ul/li[4]/a")
	private WebElement Categories;
	
	@FindBy(id="tag-name")
	private WebElement CatregoryDes;
	
	@FindBy(id="tag-slug")
	private WebElement Slug;
	
	@FindBy(id="tag-description")
	private WebElement tagdesc;
	
	@FindBy(xpath="//*[@id=\"submit\"]")
	private WebElement Submit1;
	
	@FindBy(xpath="//*[@id=\"menu-posts-property\"]/ul")
	private WebElement Mouseh;
	
	
	
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
		
}