package com.thetestingacademy.pages.pageObjectModel.vwo.normal_POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.thetestingacademy.utils.PropertiesReader;
import com.thetestingacademy.utils.WaitHelpers;

public class LoginPage {

	WebDriver driver;

	// Page Class
	// Step 0 - Param Constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// Step 1 - Page Locators (Attributes)

	private By username = By.id("login-username");
	private By password = By.id("login-password");
	private By signButton = By.id("js-login-btn");
	private By error_message = By.id("js-notification-box-msg");

	// Step 2 - Page Actions (Behavior)

	public String loginToVWOLoginInvalidCreds(String user, String pwd) {
		//driver.get("https://app.vwo.com");
		driver.get(PropertiesReader.readKey("url"));
		driver.findElement(username).sendKeys(user);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(signButton).click();

		WaitHelpers.checkVisibility(driver, error_message);

		String error_message_text = driver.findElement(error_message).getText();
		return error_message_text;
	}

	public void loginToVWOLoginValidCreds(String user, String pwd) {

		driver.get(PropertiesReader.readKey("url"));
		driver.findElement(username).sendKeys(user);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(signButton).click();

		// Wait - Thread sleep
		WaitHelpers.waitJVM(5000);
	}
}
