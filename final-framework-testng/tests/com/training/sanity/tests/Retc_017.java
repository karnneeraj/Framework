package com.training.sanity.tests;

import java.awt.Desktop.Action;
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
import com.training.pom.LoginPOM;
import com.training.pom.Retc_017POM;
import com.training.pom.Teststep1POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Retc_017 {
	private WebDriver driver;
	private String baseUrl;
	private Retc_017POM retc_017POM;
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
		retc_017POM = new Retc_017POM(driver); 
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
		retc_017POM.sendUserName("admin");
		retc_017POM.sendPassword("admin@123");
		//Click on Login Button
		retc_017POM.clickLoginBtn(); 
		retc_017POM.Clickpost1();
		retc_017POM.Clickaddnew3();
		Thread.sleep(1000);
		retc_017POM.Newlaunch1();
		retc_017POM.content2();
		retc_017POM.publish2();
			   	
		WebElement msg=driver.findElement(By.xpath("//*[@id=\"message\"]/p/a"));
		String text=msg.getText();
		Assert.assertEquals("View post",text);
		driver.findElement(By.linkText("View post")).click();
	}
			
	}




