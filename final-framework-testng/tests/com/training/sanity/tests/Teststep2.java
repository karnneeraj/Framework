package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.Teststep2POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Teststep2 {
	private WebDriver driver;
	private String baseUrl;
	private Teststep2POM loginRealestatePOM;
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
		loginRealestatePOM = new Teststep2POM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void validLoginTest() throws InterruptedException {
		//Enter User name and Password
		loginRealestatePOM.sendUserName("admin");
		loginRealestatePOM.sendPassword("admin@123");
		//Click on Login Button
		loginRealestatePOM.clickLoginBtn(); 
		loginRealestatePOM.Post1();
		loginRealestatePOM.AllPost1();		
	    
	    WebElement element = driver.findElement(By.linkText("New Launches"));
	    Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
        driver.findElement(By.linkText("Trash")).click();
        System.out.println(driver.getTitle());
                
		
	}
}



