package com.ovo.app.OVOLogin;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class base {

	public static AppiumDriverLocalService service;
	public static AndroidDriver<AndroidElement> driver;
	
	public AppiumDriverLocalService serviceServer() {
		boolean flag = checkIfServerIsRunning(4723);
		if (!flag) {
			service = AppiumDriverLocalService.buildDefaultService();
			service.start();
		} 
		return service;
	}

	public static boolean checkIfServerIsRunning(int port) {
		
		boolean isServerRunning = false;
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(port);
			serverSocket.close();
		} catch (IOException e) {
			// TODO: handle exception
			isServerRunning = true;
		} finally {
			serverSocket = null;
		}
		return isServerRunning;
	}

	public void killAllNodesBase() throws IOException, InterruptedException {
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Thread.sleep(3000);
	}
	
	public static AndroidDriver<AndroidElement> Capabilities(String apkName) throws IOException {
		// TODO Auto-generated method stub

		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\ovo\\app\\OVOLogin\\global.properties");
		Properties prop = new Properties();
		prop.load(file);
				
		File f = new File("src");
		File fs = new File(f, (String) prop.get(apkName));
		
		DesiredCapabilities cap = new DesiredCapabilities();		
		String device = (String) prop.get("Device");		
				
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, device);
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2"); //new step
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 14);
		cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
		
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		return driver;				
	}
	
}
