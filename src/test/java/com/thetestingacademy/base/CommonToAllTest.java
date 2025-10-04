package com.thetestingacademy.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.thetestingacademy.driver.DriverManager;

public class CommonToAllTest {

	@BeforeMethod
	public void setup() {
		
		DriverManager.init();
	}
	
	@AfterMethod
	public void tearDoen() {
		
		DriverManager.down();
	}
}
