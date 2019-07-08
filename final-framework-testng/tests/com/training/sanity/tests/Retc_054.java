package com.training.sanity.tests;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.Retc_018POM;
import com.training.pom.Retc_051POM;
import com.training.pom.Retc_052POM;
import com.training.pom.Retc_053POM;
import com.training.pom.Retc_054POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Retc_054 {
	private WebDriver driver;
	private String baseUrl;
	private Retc_054POM retc_054POM;
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
		retc_054POM = new Retc_054POM(driver); 
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
		//Enter User name and Password
		retc_054POM.sendUserName("admin");
		retc_054POM.sendPassword("adminuser@12345");
		//Click on Login Button
		retc_054POM.clickLoginBtn(); 
		Thread.sleep(2000);
		
		WebElement e8 = driver.findElement(By.xpath("//*[@id='wp-admin-bar-site-name']/a"));
        Actions act = new Actions(driver);
        act.contextClick(e8).build().perform();
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_DOWN);
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_DOWN);
        Thread.sleep(1000);
        robot.keyPress(KeyEvent.VK_ENTER);
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_CONTROL);
        Thread.sleep(2000);    
        robot.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(2000);
		
		/*
		Actions builder = new Actions(driver);
		WebElement e1 = driver.findElement(By.xpath("//*[@id='wp-admin-bar-site-name']/a"));
		builder.moveToElement(e1).click().build().perform();
		
		
		e1.click(); */
		// Blog click not working 
        
		/* Thread.sleep(9000);
		WebElement e2 = driver.findElement(By.xpath("//*[@id='menu-item-617']/a"));
				e2.click();  
		
		WebElement e3 = driver.findElement(By.xpath("//*[@id='post-3610']/div/a"));
		e3.click();	*/
		
	}
}



