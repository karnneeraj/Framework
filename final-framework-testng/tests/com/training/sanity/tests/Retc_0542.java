package com.training.sanity.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Retc_0542 {

	    public static void main(String[] args) throws InterruptedException {
	    System.setProperty("webdriver.gecko.driver", "C:\\Users\\NEERAJKUMAR\\Desktop\\selenium\\geckodriver-v0.24.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();		
		driver.get("http://realestate.upskills.in/");
		Thread.sleep(9000);
		driver.manage().window().maximize();
		WebElement e1= driver.findElement(By.xpath("//*[@id='menu-item-617']/a"));
		e1.click();
		
		WebElement e2 = driver.findElement(By.xpath("//*[@id=\'post-3610\']/div/a"));
		e2.click();
	// Write Assert for verify message 
		
		WebElement e3 = driver.findElement(By.xpath("//*[@id='comment']"));
				e3.sendKeys("This is the test comment 6");
				
        WebElement e4 = driver.findElement(By.xpath("//*[@id=\'author\']"));
        e4.sendKeys("Neeraj Kumar 6");
        
        WebElement e5 = driver.findElement(By.xpath("//*[@id=\'email\']"));
        e5.sendKeys("abc6@gmail.com");
				
	    WebElement e6 = driver.findElement(By.xpath("//*[@id='submit']"));
	    e6.click();   
				
	 	driver.get("http://realestate.upskills.in/wp-admin/");
	 	driver.manage().window().maximize();
	 	WebElement e7 = driver.findElement(By.xpath("//*[@id=\'user_login\']"));
	 	e7.sendKeys("admin");
	 	WebElement e8 = driver.findElement(By.xpath("//*[@id='user_pass']"));
	 	e8.sendKeys("adminuser@12345");
	 	
	 	WebElement e9 = driver.findElement(By.xpath("//*[@id=\'tab1\']/form/p[3]/input"));	 	
	 	e9.click();
	 	
	 	WebElement e10 = driver.findElement(By.xpath("//*[@id=\'menu-comments\']/a/div[2]"));
	 	e10.click();
	 	
	 
	 	
	 	WebElement e11 = driver.findElement(By.xpath("//*[@id=\'comment-1795\']/td[2]/p"));
		Actions action = new Actions(driver);
		action.moveToElement(e11).build().perform();
		
		WebElement e12 = driver.findElement(By.xpath("//*[@id=\'comment-1795\']/td[2]/div[3]/span[3]/a"));
		e12.click();
				
		WebElement e13 = driver.findElement(By.xpath("//*[@id=\'replycontent\']"));
		e13.sendKeys("Reply send 2");
		
		WebElement e14 = driver.findElement(By.xpath("//*[@id=\'replybtn\']"));
		e14.click();
		
		driver.navigate().refresh();
		
		System.out.println("Testing Sucess 2");
		
	}

}
