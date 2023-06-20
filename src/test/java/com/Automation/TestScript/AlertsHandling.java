package com.Automation.TestScript;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.chrome.ChromeDriver;

import com.Automation.elementRepository.LoginLocators;
import com.Automation.genericLibrary.*;


import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertsHandling extends BaseClass {
	@Test//(groups={"System"})
	public void alertHandling() throws Exception {	
      driver.findElement(By.xpath("//div[@class='menuTable']/div[2]")).click();
	driver.findElement(By.xpath("//li[@id='popup_menu_item_2']")).click();
	driver.findElement(By.xpath("//span[text()='Create Type of Work']")).click();
	driver.findElement(By.id("name")).sendKeys(du.getDataFromExcelSheet("Sheet1", 0, 1));
	 driver.findElement(By.xpath("//td[@id='ButtonPane']/input[2]")).click();
	 String msg1= wd.getMsgFromAlert(driver);
	  wd.getFinalPermission(driver);
	  String msg2="Are you sure you want to cancel the Type of Work creation?";
	  SoftAssert sa=new SoftAssert();
	  sa.assertEquals(msg1,msg2);
	  sa.assertAll();
	    Reporter.log(msg1, true);
	    
		
	}}


