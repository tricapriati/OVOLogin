package com.ovo.app.OVOLogin;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import io.qameta.allure.Attachment;

public class TestListeners extends base implements ITestListener {

	public static String getTestMethodName(ITestResult iTestResult) {
		return iTestResult.getMethod().getConstructorOrMethod().getName();
	}
	
	@Attachment (value = "Page screenshoot", type = "image/png")
	public byte[] saveScreenshootPNG(WebDriver driver) {
		return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
	}

	@Attachment (value = "{0}", type = "text/plain")
	public static String saveTextLang(String message) {
		return message;
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("I am in onTestStart method: " + getTestMethodName(result) + " success");
		
		Object testClass = result.getInstance();
//		WebDriver driver = ((BaseTest) testClass).getDriver();
//		System.out.println("sukses hasil nya apaa: "+ ((BaseTest) testClass).getDriver());
		// allure screenshot and saveTestLog
//		if(driver instanceof WebDriver) {
//			System.out.println("Screenshot captured for test case: " + getTestMethodName(result));
//			saveScreenshootPNG(driver);
//		}
//		// save log allure
//		saveTextLang(getTestMethodName(result) + " success and screenshot taken!");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
//		System.out.println("I am in onTestFailure method: " + getTestMethodName(result) + " failed");
//		
//		Object testClass = result.getInstance();
//		WebDriver driver = ((BaseTest) testClass).getDriver();
//		System.out.println("gagal hasil nya apaa: "+ ((BaseTest) testClass).getDriver());
//		
//		// allure screenshot and saveTestLog
//		if(driver instanceof WebDriver) {
//			System.out.println("Screenshot captured for test case: " + getTestMethodName(result));
//			saveScreenshootPNG(driver);
//		}
//		// save log allure
//		saveTextLang(getTestMethodName(result) + " failed and screenshot taken!");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
