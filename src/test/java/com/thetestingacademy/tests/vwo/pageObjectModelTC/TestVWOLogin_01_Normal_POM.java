package com.thetestingacademy.tests.vwo.pageObjectModelTC;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.thetestingacademy.pages.pageObjectModel.vwo.DashBoardPage;
import com.thetestingacademy.pages.pageObjectModel.vwo.LoginPage;
import com.thetestingacademy.utils.PropertiesReader;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.assertj.core.api.Assertions.*;

public class TestVWOLogin_01_Normal_POM  {

	// D
	// L
	// V
	
	@Owner("Mangesh")
	@Description("Verify that with invalid email, pass, error message is shown on the app.vwo.com")
	@Test
	public void test_negative_vwo_login() {
		
		// Driver Manager Code - 1 - D
        WebDriver driver = new ChromeDriver();


        // Page Class Code (POM Code) - 2 - L
        LoginPage loginPage = new LoginPage(driver);
        String error_msg = loginPage.loginToVWOLoginInvalidCreds(PropertiesReader.readKey("invalid_username"),PropertiesReader.readKey("invalid_password"));

        // Assertions - 3 - V
        assertThat(error_msg).isNotNull().isNotBlank().isNotEmpty();
        Assert.assertEquals(error_msg,PropertiesReader.readKey("error_message"));

        driver.quit();
	}
	
	@Owner("Mangesh")
	@Description("TC#2-Verify that valid creds dashboard page is loaded")
	@Test
	public void testLoginPositiveVWO() {
		
	// Driver Manager Code - 1
       WebDriver driver = new ChromeDriver();
        
     // Page Class Code (POM Code) - 2 - L
      LoginPage loginPage = new LoginPage(driver);
      loginPage.loginToVWOLoginValidCreds(PropertiesReader.readKey("username"), PropertiesReader.readKey("password"));
      
      DashBoardPage dashBoardPage = new DashBoardPage(driver);
      String usernameLoggedIn = dashBoardPage.loggedInUserName();
      
      assertThat(usernameLoggedIn).isNotBlank().isNotNull().isNotEmpty();
      
      Assert.assertEquals(usernameLoggedIn,PropertiesReader.readKey("expected_username"));
      
      driver.quit();
	}
}
