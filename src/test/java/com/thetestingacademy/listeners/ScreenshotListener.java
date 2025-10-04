package com.thetestingacademy.listeners;

import org.apache.commons.io.FileUtils;
import org.apache.velocity.texen.util.FileUtil;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import io.qameta.allure.Allure;

import static com.thetestingacademy.driver.DriverManager.getDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
public class ScreenshotListener implements ITestListener {

	@Override
	public void onTestFailure(ITestResult result) {
		 // Failure Take a Screenshot and save it in the folder.
		
		Object testClass = result.getInstance();
		WebDriver driver = getDriver();
	
		String methodName = result.getName();
		
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		
		if(driver != null) {
			
			File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			 try {
	                String screenshotPath = "failure_screenshots/" + methodName + "_" +
	                        formatter.format(calendar.getTime()) + ".png";
	                FileUtils.copyFile(srcFile, new File(screenshotPath));

	                // Add screenshot link to TestNG report
	                org.testng.Reporter.log("<a href='" + screenshotPath + "'> Screenshot</a>");
	                Allure.addAttachment("Screenshot", "image/png", screenshotPath, "png");
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
		}
		
	}

	
	
}
