package com.Automation.genericLibrary;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtilities {
	public String getMsgFromAlert(WebDriver driver) {
		Alert alt=driver.switchTo().alert();
		String msg=alt.getText();
		return msg;
	}
	public void getFinalPermission(WebDriver driver) {
		Alert alt=driver.switchTo().alert();
		alt.accept();
	}

	public void selectValue(WebElement wb,String option) {
		Select s=new Select(wb);
		s.selectByVisibleText(option);
		}
}
