package com.thetestingacademy.tests.vwo.pageObjectModelTC;

import java.awt.desktop.ScreenSleepListener;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.thetestingacademy.base.CommonToAllTest;

import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import static com.thetestingacademy.driver.DriverManager.getDriver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.thetestingacademy.listeners.RetryAnalyzer;
import com.thetestingacademy.listeners.ScreenshotListener;
import com.thetestingacademy.utils.PropertiesReader;


@Listeners(ScreenshotListener.class)
@Test(retryAnalyzer = RetryAnalyzer.class)
public class TestVWOLogin_05_TakeScreen_Retry_Prop_Improved_POM extends CommonToAllTest {

	private static final Logger logger = LogManager.getLogger(TestVWOLogin_05_TakeScreen_Retry_Prop_Improved_POM.class);

	 @Owner("Mangesh")
	    @Description("Verify that invalid creds give error message")
	    @Test
	    public void testFail() {
		 getDriver().get(PropertiesReader.readKey("url"));
	     logger.info("Starting the Testcases Page Object Model");
	     Allure.addAttachment("Log output", "text/plain", "This is some log text");
	     Assert.assertTrue(false);
	    }

	    @Owner("Mangesh")
	    @Description("Verify that invalid creds give error message")
	    @Test
	    public void testPass() {
	    	getDriver().get(PropertiesReader.readKey("url"));
	        logger.info("Starting the Testcases Page Object Model");
	        Assert.assertTrue(true);
	    }




}
