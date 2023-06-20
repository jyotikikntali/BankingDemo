package com.Automation.genericLibrary;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.Automation.elementRepository.LoginLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.*;

public class BaseClass {
	 public static  WebDriver driver=WebDriverManager.chromedriver().create();
	 public static WebDriver listenerdriver;
	 
		
	public static  DataUtility du=new DataUtility();
	public static JavaUtilities ju=new JavaUtilities();
	public static WebDriverUtilities wd=new WebDriverUtilities();
	
	@BeforeSuite(alwaysRun=true)
	public void Bs() {
		System.out.println("Data Connection");
	}
	@BeforeTest(alwaysRun=true)
	public void BT(){
		System.out.println("Parallel execution");
	}
	@BeforeClass(alwaysRun=true)
	public  void setUp() {
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	/*public void setUp(String br) {
		
		if(br.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			}
		else
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
			
		}*/
	
	
	@BeforeMethod(alwaysRun=true)
	public  void LoginData() throws Exception {
		
		LoginLocators ll=new LoginLocators(driver);
		driver.get(du.getDataFromProperties("URL"));
		ll.loginApp(du.getDataFromProperties("Username"),du.getDataFromProperties("Password"));
	}
	
	@AfterMethod(alwaysRun=true)
	public  void Logout() {
		driver.findElement(By.xpath("//a[@id='logoutLink']")).click();
	}
	
	@AfterClass(alwaysRun=true)
	public  void tearDown() {
		if(driver==null) {
			driver.quit();
		}
	}
	
	
}
