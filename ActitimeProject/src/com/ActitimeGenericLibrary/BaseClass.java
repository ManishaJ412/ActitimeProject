package com.ActitimeGenericLibrary;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.ActitimeObjectRepository.HomePage;
import com.ActitimeObjectRepository.LoginPage;

public class BaseClass {
public static WebDriver driver;
FileLibrary f=new FileLibrary();
	@BeforeSuite
	public void databaseconnection() {
	Reporter.log("database connected",true);
	
}
@BeforeClass
	public void launchbrowser() throws IOException {
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	String URL = f.readDataFromProperty("url");
	driver.get(URL);
	
}

@BeforeMethod
public void login() throws IOException {
LoginPage lp = new LoginPage(driver);
	String un = f.readDataFromProperty("un");
	String pw = f.readDataFromProperty("pw");
	lp.getUntbx().sendKeys(un);
	lp.getPwtbx().sendKeys(pw);
	lp.getLgbtn().click();
	}

@AfterMethod
public void logout() {
	HomePage hp=new HomePage(driver);
	hp.getLgoutlnk().click();

Reporter.log("logged out successfully",true);
}

@AfterClass
public void closebrowser() {
driver.close();
Reporter.log("browser closed successfully",true);
}


@AfterSuite
public void databasedisconnected() {
Reporter.log("databasedisconnected successfully",true);
}
}





	