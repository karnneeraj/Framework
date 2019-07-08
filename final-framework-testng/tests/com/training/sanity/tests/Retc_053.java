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
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Retc_053 {
	private WebDriver driver;
	private String baseUrl;
	private Retc_053POM retc_053POM;
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
		retc_053POM = new Retc_053POM(driver); 
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
		retc_053POM.sendUserName("admin");
		retc_053POM.sendPassword("adminuser@12345");
		//Click on Login Button
		retc_053POM.clickLoginBtn(); 
		//Thread.sleep(2000);
		
		Actions builder = new Actions(driver);
		WebElement e1 = driver.findElement(By.xpath("//*[@id=\'menu-posts-property\']/a/div[3]"));
		builder.moveToElement(e1).click().build().perform();
		WebElement e2 = driver.findElement(By.xpath("//*[@id=\'menu-posts-property\']/ul/li[2]/a"));
		e2 .click();
		
		Actions builder1 = new Actions(driver);
		WebElement e3 = driver.findElement(By.xpath("//*[@id=\"post-3613\"]/td[1]/strong/a"));
		builder1.moveToElement(e3).build().perform();
		Thread.sleep(5000);
					
		WebElement e4 = driver.findElement(By.xpath("//*[@id='post-3613']/td[1]/div[3]/span[3]/a"));
		e4.click();
		
		// Assert for undo
		 
		// click on trash link 
		WebElement e5 = driver.findElement(By.xpath("//*[@id=\"wpbody-content\"]/div[3]/ul/li[5]/a"));
		e5.click();
		Thread.sleep(2000);
		
		// Mouseover
		Actions builder3 = new Actions(driver);
		WebElement e6 = driver.findElement(By.xpath("//*[@id=\'post-3613\']/td[1]/strong"));
		builder3.moveToElement(e6).build().perform();
		
		Thread.sleep(5000);
		
		WebElement e7 = driver.findElement(By.xpath("//*[@id='post-3613']/td[1]/div[2]/span[1]/a"));
		e7.click();
		
		 //Assert for port restore message 
		
		
		//Right click on Properties and open in new tab 
		
		/*WebElement e8 = driver.findElement(By.xpath("//*[contains(text(), 'Properties')]"));
        Actions act = new Actions(driver);
        act.contextClick(e8).build().perform();*/
        
		WebElement e8 = driver.findElement(By.xpath("//*[@id='menu-posts-property']/a/div[3]"));
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
       
        
		// Search for added property  - not working 
        
        Actions builder4 = new Actions(driver);
		WebElement e10 = driver.findElement(By.xpath("//*[@id='post-3613']/td[1]/strong/a"));
		builder4.moveToElement(e10).build().perform();
		Thread.sleep(5000);
		
		WebElement e11 = driver.findElement(By.xpath("//*[@id='post-3613']/td[1]/div[3]/span[4]/a"));
		e11.click();
		
		////*[@id="titlebar"]/div/div/div/div[1]/h2/text()
		
		//String text=e9.getAttribute("aria-label");
		//Assert.assertEquals("testcase53", text); 
		
		
		
	}
	
	}




