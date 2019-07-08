package com.training.sanity.tests;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
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
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Retc_052 {
	private WebDriver driver;
	private String baseUrl;
	private Retc_052POM retc_052POM;
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
		retc_052POM = new Retc_052POM(driver); 
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
	public void validLoginTest() throws InterruptedException {
		//Enter User name and Password
		retc_052POM.sendUserName("admin");
		retc_052POM.sendPassword("admin@123");
		//Click on Login Button
		retc_052POM.clickLoginBtn(); 
		//Thread.sleep(2000);
		
		Actions builder = new Actions(driver);
		WebElement element = driver.findElement(By.xpath("//*[@id=\'menu-posts-property\']/a/div[3]"));
		builder.moveToElement(element).click().build().perform();
		WebElement element1 = driver.findElement(By.xpath("//*[@id=\'menu-posts-property\']/ul/li[2]/a"));
		element1 .click();
		
		Actions builder1 = new Actions(driver);
		WebElement element2 = driver.findElement(By.xpath("//*[@id=\"post-3609\"]/td[1]/strong/a"));
		builder1.moveToElement(element2).build().perform();
		Thread.sleep(5000);
				
		WebElement element3 = driver.findElement(By.xpath("//*[@id='post-3609']/td[1]/div[3]/span[3]/a"));
		element3.click();
		
		// Assert for undo
		 
		// click on trash link 
		WebElement e1 = driver.findElement(By.xpath("//*[@id=\'wpbody-content\']/div[3]/ul/li[4]/a"));
		e1.click();
		Thread.sleep(2000);
		
		// Mouseover
		Actions builder3 = new Actions(driver);
		WebElement element4 = driver.findElement(By.xpath("//*[@id=\"post-3609\"]/td[1]/strong"));
		builder3.moveToElement(element4).build().perform();
		Thread.sleep(5000);
		
		//click on permanent delete
		WebElement e2 = driver.findElement(By.xpath("//*[@id=\'post-3609\']/td[1]/div[2]/span[2]/a"));
		e2.click();
		
		
	// Assert for delete permanentely 
		
		
	}
	
	}




