package com.training.sanity.tests;


import static org.testng.Assert.assertTrue;

import java.awt.AWTException;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.Retc_076POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Retc_076 {
	private WebDriver driver;
	private String baseUrl;
	private Retc_076POM retc_076POM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		retc_076POM = new Retc_076POM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		// driver.quit();
	}
	@Test
	public void validLoginTest() throws InterruptedException, AWTException {
		retc_076POM.sendUserName("admin");
		retc_076POM.sendPassword("adminuser@12345");
		retc_076POM.clickLoginBtn(); 
		Thread.sleep(2000);
		
		//click on user link 
		WebElement e1= driver.findElement(By.xpath("//*[@id=\'menu-users\']/a/div[2]"));
		e1.click();
     
		// click on Add new 
		
	   WebElement e2 = driver.findElement(By.xpath("//*[@class='page-title-action']"));
	   e2.click();
		
	   WebElement e3 = driver.findElement(By.xpath("//*[@name='user_login']"));
	   e3.sendKeys("Neeraj");
	   
	   WebElement e4 = driver.findElement(By.xpath("//*[@name='email']"));
	   e4.sendKeys("Test@gmail.com");
	   
	   WebElement e5 = driver.findElement(By.xpath("//*[@name='first_name']"));
	   e5.sendKeys("Neeraj");
	   
	   WebElement e6 = driver.findElement(By.xpath("//*[@name='last_name']"));
	   e6.sendKeys("Kumar");
	   
	   WebElement e7 = driver.findElement(By.xpath("//*[@name='url']"));
	   e7.sendKeys("www.neeraj.com");
	   
	   WebElement e8 = driver.findElement(By.xpath("//*[@id='createuser']/table/tbody/tr[6]/td/button"));
	   e8.click();
	   
	   //WebElement e9 = driver.findElement(By.xpath("//*[@id='pass1-text']"));
	   //e9.sendKeys("test123@12345666666");
	   
	   
	   //select role 
	   Select e10 = new Select(driver.findElement(By.xpath("//*[@name='role']")));
	   Thread.sleep(8000);
	   e10.getOptions();
	   Thread.sleep(8000);
	   e10.selectByVisibleText("Agent");
	     
	  //Add new user
	   
	   WebElement e11 = driver.findElement(By.xpath("//*[@id='createusersub']"));
	   e11.click();
	   
	    String sValue = "Neeraj";
	   
	   	Assert.assertEquals("Neeraj", sValue);
	   
	   	System.out.println("Test Passed");
	   
	   
	   
	} 
}



