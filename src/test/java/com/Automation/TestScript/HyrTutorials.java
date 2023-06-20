package com.Automation.TestScript;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HyrTutorials {
	public static void main(String[] args) throws Exception {
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--disable-notifications--");
		driver=new ChromeDriver(opt);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
	   driver.get("https://www.hyrtutorials.com/");
	   Actions act=new Actions(driver);
	   act.moveToElement(driver.findElement(By.xpath("//a[.='Selenium Practice']"))).perform();
	  driver.findElement(By.xpath("//a[.='Frames Practice']")).click();
	  Thread.sleep(30);
	 Alert alt= driver.switchTo().alert();
	 alt.dismiss();
	 
	  
	  

	    

	        

	      /*  JavascriptExecutor js=(JavascriptExecutor)driver;

	        js.executeScript("window.scrollBy(0,300);"," ");

	       driver.findElement(By.id("name")).sendKeys("First frame");

	      

	        driver.switchTo().frame(driver.findElement(By.id("frm1")));

	       JavascriptExecutor js1=(JavascriptExecutor)driver;

	           js1.executeScript("window.scrollBy(0,500);"," ");

	        driver.findElement(By.id("course")).click();*/
		
	}

}
