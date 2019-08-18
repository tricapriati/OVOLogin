package com.ovo.app.OVOLogin;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.qameta.allure.Attachment;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import pageObject.ConfirmPage;
import pageObject.LoginPage;
import pageObject.PermissionPage;
import pageObject.SecurityCodePage;

public class LoginFlowTest extends base {

	@BeforeTest
	public void killAllNodes() throws IOException, InterruptedException {
		killAllNodesBase();
	}
	
	@Test
	public void loginFlow() throws IOException {

		serviceServer().start();
		
		try {
			// TODO Auto-generated method stub
			AndroidDriver<AndroidElement> driver = Capabilities("ApkName");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			GeneralParameter general = new GeneralParameter();
			// izin akses
			PermissionPage permissionPage = new PermissionPage(driver);
//			takeScreenshot();
			permissionPage.btnBatal.click();
			permissionPage.btnKembali.click();
			permissionPage.btnSetuju.click();
			permissionPage.btnAllow.click();
			
			// Login page
			LoginPage loginPage = new LoginPage(driver);
			loginPage.account.sendKeys(general.getNoTelpon());
			loginPage.btnSignIn.click();
			
			// Security Code Page
			SecurityCodePage codePage = new SecurityCodePage(driver);
			codePage.pin.sendKeys(general.getPin());
			
			// Confirm fingerprint
			ConfirmPage confirmPage = new ConfirmPage(driver);
			confirmPage.btnCancel.click();
		} catch(Exception e) {
			System.out.println("eror login: "+e.getMessage());
		}

		serviceServer().stop();
	}

	@Attachment(value = "Web Page Screenshot", type = "image/png")
	public byte[] takeScreenshot() {
			// Take a screenshot as byte array and return
			return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		}	
	
//	public static void getScreenhoot(String name) throws IOException {
//		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//		FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") +"\\report\\"+ name +".png"));
//	}
}
