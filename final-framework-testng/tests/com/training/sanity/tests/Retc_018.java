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
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Retc_018 {
	private WebDriver driver;
	private String baseUrl;
	private Retc_018POM retc_018POM;
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
		retc_018POM = new Retc_018POM(driver); 
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
		retc_018POM.sendUserName("admin");
		retc_018POM.sendPassword("admin@123");
		//Click on Login Button
		retc_018POM.clickLoginBtn(); 
		Thread.sleep(2000);
		retc_018POM.Clickpost1();
		retc_018POM.Categories2();
		retc_018POM.CatregoryDes3();
		retc_018POM.Slug1();
		retc_018POM.tagdesc1();
		retc_018POM.Submit2();
		
		  
	}
			
	}




