package com.ovo.app.OVOLogin;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageObject.ConfirmPage;
import pageObject.LoginPage;
import pageObject.PermissionPage;
import pageObject.SecurityCodePage;

public class App extends base
{
    public static void main( String[] args ) throws IOException
    {
    	AndroidDriver<AndroidElement> driver = Capabilities("ApkName");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		GeneralParameter general = new GeneralParameter();
		
		// izin akses
		PermissionPage permissionPage = new PermissionPage(driver);
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
    }
}
