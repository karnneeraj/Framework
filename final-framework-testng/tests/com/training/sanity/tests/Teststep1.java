package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.Teststep1POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Teststep1 {
	private WebDriver driver;
	private String baseUrl;
	private Teststep1POM loginRealestatePOM;
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
		loginRealestatePOM = new Teststep1POM(driver); 
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
		loginRealestatePOM.sendUserName("admin");
		loginRealestatePOM.sendPassword("admin@123");
		//Click on Login Button
		loginRealestatePOM.clickLoginBtn(); 
		
		loginRealestatePOM.Clickpost1();
		Thread.sleep(1000);
		
		loginRealestatePOM.ClickAllpost1();
		loginRealestatePOM.Clickaddnew1();
		Thread.sleep(1000);
		
		loginRealestatePOM.Categories1();
		Thread.sleep(1000);
		
		loginRealestatePOM.Tags1();
	
		screenShot.captureScreenShot("First");
	}
}



