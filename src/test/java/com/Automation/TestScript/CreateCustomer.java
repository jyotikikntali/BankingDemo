package com.Automation.TestScript;


import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;
import org.testng.reporters.jq.Main;
import org.testng.annotations.*;

import com.Automation.genericLibrary.DataUtility;
import com.Automation.elementRepository.LoginLocators;
import com.Automation.genericLibrary.BaseClass;
import io.github.bonigarcia.wdm.WebDriverManager;


//@Listeners(com.Automation.genericLibrary.ListenerImplementation.class)
public class CreateCustomer extends BaseClass {
	@Test//(groups= {"System","Smoke"})
public void createCustomer() throws Exception {	

  int num=ju.getRandomNum(1000);
		String orgname=du.getDataFromExcelSheet("Sheet1",1,0);
		String Customername=orgname+num;  
		driver.findElement(By.id("container_tasks")).click();
		driver.findElement(By.cssSelector("div .addNewButton")).click();
		driver.findElement(By.cssSelector("div .createNewCustomer")).click();
		driver.findElement(By.xpath("//div[@class='customerNameDiv']/input")).sendKeys(Customername);
		driver.findElement(By.cssSelector("[placeholder='Enter Customer Description']")).sendKeys(du.getDataFromExcelSheet("Sheet1", 1, 1));
		WebElement wb= driver.findElement(By.xpath("//div[@class='components_button withPlusIcon']"));
		File src=wb.getScreenshotAs(OutputType.FILE);
		File trg=new File("./ScreenShots/captured.png");
		FileUtils.copyFile(src, trg);
		wb.click();
		 Thread.sleep(1000);
		/* WebDriverWait wait=new WebDriverWait(driver,25);
		 wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(".titleEditButtonContainer>.title"), Customername));*/
		String actualname= driver.findElement(By.xpath("//div[@class='titleEditButtonContainer']/div")).getText();
		SoftAssert sa=new SoftAssert();
		   sa.assertTrue(actualname.contains(orgname));
		   Reporter.log("TestCase is passed",true);
		   System.out.println("TestCase is Passed");
		sa.assertAll();
		
		
		
	}}


