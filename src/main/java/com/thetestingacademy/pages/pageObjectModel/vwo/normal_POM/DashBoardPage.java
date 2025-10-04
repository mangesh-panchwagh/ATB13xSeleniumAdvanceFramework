package com.thetestingacademy.pages.pageObjectModel.vwo.normal_POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.thetestingacademy.utils.PropertiesReader;
import com.thetestingacademy.utils.WaitHelpers;

public class DashBoardPage {

	WebDriver driver;
	
	// Page Class
	// Step 0 - Param Constructor
	public DashBoardPage(WebDriver driver) {
		this.driver = driver;
	}
	
	// Step 1 - Page Locators (Attributes)
	private By userNameOnDashboard = By.xpath("//h6");
	
	
	// Step 2 - Page Actions (Behavior)
	public String loggedInUserName() {
		WaitHelpers.waitJVM(5000);
		//driver.get("https://app.vwo.com/#/dashboard");
		driver.get(PropertiesReader.readKey("dashboard_url"));
		return driver.findElement(userNameOnDashboard).getText();
	}
}
