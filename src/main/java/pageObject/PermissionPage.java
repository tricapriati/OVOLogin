package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PermissionPage {

	public PermissionPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "//android.widget.Button[@text='SETUJU']")
	public WebElement btnSetuju;

	@AndroidFindBy(id = "ovo.id:id/btn_negative")
	public WebElement btnBatal;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='KEMBALI']")
	public WebElement btnKembali;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='Allow']")
	public WebElement btnAllow;

}
