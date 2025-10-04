package com.thetestingacademy.pages.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.thetestingacademy.base.CommonToAllPage;

public class DashboardPage_PF extends CommonToAllPage{

	WebDriver driver;
	
	public DashboardPage_PF(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
