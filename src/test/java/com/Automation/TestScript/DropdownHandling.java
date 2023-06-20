package com.Automation.TestScript;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.Automation.elementRepository.LoginLocators;
import com.Automation.genericLibrary.*;

import org.openqa.selenium.WebDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class DropdownHandling  extends BaseClass {
	@Test
	public void dropDownHandling() throws Exception {
		String expmsg="MODIFICATIONS NOT SAVED";
	driver.findElement(By.className("popup_menu_button_settings")).click();
	driver.findElement(By.xpath("//div[contains(text(),'configure actiTIME')]/..")).click();
	WebElement dropdown=driver.findElement(By.id("userGroupNamingCodeSelect"));
	wd.selectValue(dropdown,"Team");
	String msg=driver.findElement(By.id("FormModifiedTextCell")).getText();
			Reporter.log(msg);
			Assert.assertEquals(expmsg,msg);
			System.out.println("Dropdown TC is pass");

		
	}

}
