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
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Retc_051 {
	private WebDriver driver;
	private String baseUrl;
	private Retc_051POM retc_051POM;
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
		retc_051POM = new Retc_051POM(driver); 
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
		retc_051POM.sendUserName("admin");
		retc_051POM.sendPassword("admin@123");
		//Click on Login Button
		retc_051POM.clickLoginBtn(); 
		//Thread.sleep(2000);
		
		/* WebElement element = driver.findElement(By.xpath("//*[@id='menu-posts-property']/ul"));
		   Actions action = new Actions(driver);
           action.moveToElement(element).build().perform();
           WebElement element = driver.findElement(By.xpath("//*[@id='menu-posts-property']/ul")); */
        
		Actions builder = new Actions(driver);
		WebElement element = driver.findElement(By.xpath("//*[@id=\'menu-posts-property\']/a/div[3]"));
		builder.moveToElement(element).click().build().perform();
		WebElement element1 = driver.findElement(By.xpath("//*[@id=\'menu-posts-property\']/ul/li[2]/a"));
		element1 .click();
		WebElement element3 = driver.findElement(By.xpath("//*[@id='wpbody-content']/div[3]/ul/li[4]/a"));
		element3.click();
		
		//WebElement element4 = driver.findElement(By.xpath("//*[class='row-title' and name='Srinivas'"));
		//element4.click();
		
		WebElement element4 = driver.findElement(By.xpath("//*[contains(text(), 'Neeraj 1')]"));
		Actions action = new Actions(driver);
		action.moveToElement(element4).build().perform();
		
		//WebElement element5 = driver.findElement(By.xpath("//*[@id=\'post-3479\']/td[1]/div[2]/span[1]/a"));
		WebElement element5 = driver.findElement(By.xpath("//*[ @class='untrash']/a"));
		element5.click();
		
		WebElement msg=driver.findElement(By.xpath("//*[@id='message']/p"));
		String text=msg.getText();
		Assert.assertEquals("1 post restored from the Trash.",text);
		
		WebElement element6= driver.findElement(By.xpath("//*[ @class='wp-first-item current']/a"));
		element6.click();
		
		WebElement msg2=driver.findElement(By.linkText("Neeraj 1"));
		String text2=msg2.getText();
		Assert.assertEquals("Neeraj 1", text2);
		
		
	}
	
	}




