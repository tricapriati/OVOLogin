package com.ovo.app.OVOLogin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
	
	public WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

//    @BeforeClass
//    public void classLevelSetup() {
//        driver = new ChromeDriver();
//    }

//    @AfterClass
//    public void teardown() {
//        driver.quit();
//    }
}
