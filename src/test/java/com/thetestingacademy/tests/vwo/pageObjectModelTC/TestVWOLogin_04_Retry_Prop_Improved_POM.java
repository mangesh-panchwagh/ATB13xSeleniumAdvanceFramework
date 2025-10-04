package com.thetestingacademy.tests.vwo.pageObjectModelTC;

import static org.assertj.core.api.Assertions.assertThat;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.thetestingacademy.base.CommonToAllTest;
import com.thetestingacademy.driver.DriverManager;
import com.thetestingacademy.listeners.RetryAnalyzer;
import com.thetestingacademy.pages.pageObjectModel.vwo.improved_POM.DashBoardPage;
import com.thetestingacademy.pages.pageObjectModel.vwo.improved_POM.LoginPage;
import com.thetestingacademy.utils.PropertiesReader;
import com.thetestingacademy.utils.TakeScreenShot;

import static com.thetestingacademy.driver.DriverManager.getDriver;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;

@Test(retryAnalyzer = RetryAnalyzer.class)
public class TestVWOLogin_04_Retry_Prop_Improved_POM extends CommonToAllTest {

	//  D
    // L
    // V
	

    private static final Logger logger = LogManager.getLogger(TestVWOLogin_04_Retry_Prop_Improved_POM.class);

    @Owner("Mangesh")
    @Description("Verify that invalid creds give error message")
    @Test
    public void testFail() {
    	
    	 getDriver().get(PropertiesReader.readKey("url"));
    	 logger.info("Starting the Testcases Page Object Model");
//       Allure.addAttachment("Log output", "text/plain", "This is some log text");
    	 Assert.assertTrue(false);
    }
    
    @Owner("Mangesh")
    @Description("Verify that invalid creds give error message")
    @Test
    public void testPass() {
    	
    	getDriver().get(PropertiesReader.readKey("url"));
         logger.info("Starting the Testcases Page Object Model");
         new TakeScreenShot().takeScreenshot("testPass_1");
         Assert.assertTrue(true);
    	
    }
}
