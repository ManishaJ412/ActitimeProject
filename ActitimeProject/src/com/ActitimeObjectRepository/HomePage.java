package com.ActitimeObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
//Declaration
	@FindBy(xpath = "//div[.='Tasks']")
	private WebElement tasklnk;
	
	@FindBy(xpath = "//div[.='Reports']")
	private WebElement reportslnk;
	
	@FindBy(xpath = "//div[.='Users']")
	private WebElement userlnk;
	
	@FindBy(id = "logoutLink")
	private WebElement lgoutlnk;
	
	//initionlization
	public HomePage(WebDriver driver) {
		PageFactory.initElements( driver,this);
		}
//utilization
	public WebElement getTasklnk() {
		return tasklnk;
	}

	public WebElement getReportslnk() {
		return reportslnk;
	}

	public WebElement getUserlnk() {
		return userlnk;
	}

	public WebElement getLgoutlnk() {
		return lgoutlnk;
	}
}




