package com.actitime.generic;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.actitime.pom.LoginPage;


public class BaseClass {
 static {
	 System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
 }
 public static WebDriver driver;
 
 @BeforeTest
 public void openBrowser() {
	 Reporter.log("Open Browser", false);
	 driver=new ChromeDriver();
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 }
 @AfterTest
 public void closeBrowser() {
	 Reporter.log("Close Browser", false);
	 driver.close();
 }
 @BeforeMethod
 public void login() throws IOException {
	 Reporter.log("Login", false);
	 fileLibrary f=new fileLibrary();
	 String url = f.getPropertyFile("URL");
	 String username=f.getPropertyFile("UN");
	 String password=f.getPropertyFile("PWD");
	 driver.get(url);
	 LoginPage l=new LoginPage(driver);
	 l.loginUser(username, password); 
	 
 }
 @AfterMethod
 public void logout() {
	 Reporter.log("Logout", false);
	 
 }
}
