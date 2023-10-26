package com.ActitimeTestScript;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ActitimeGenericLibrary.BaseClass;
import com.ActitimeGenericLibrary.FileLibrary;
import com.ActitimeGenericLibrary.ListenerImplimentation;
import com.ActitimeObjectRepository.HomePage;
import com.ActitimeObjectRepository.TaskPage;
@Listeners(ListenerImplimentation.class)
public class CreateCustomer extends BaseClass {

	@Test
	public void create() throws EncryptedDocumentException, IOException {
	HomePage hp=new HomePage(driver);
	hp.getTasklnk().click();
	TaskPage tp=new TaskPage(driver);
	tp.getAddnewbtn().click();
	tp.getNewcustomer().click();
	FileLibrary f=new FileLibrary();
	String Custname = f.readDataFromExcel("Sheet1", 1, 1);
String custdesp = f.readDataFromExcel("Sheet1", 1, 2);
tp.getCustomername().sendKeys(Custname);
tp.getCustdesp().sendKeys(custdesp);
tp.getCreatecustbtn().click();
String expecteddata = Custname;
String actualdata = driver.findElement(By.xpath("(//div[.'"+Custname+"'])")).getText();
SoftAssert s=new SoftAssert();
s.assertEquals(expecteddata , actualdata);
s.assertAll();

	}	
}
