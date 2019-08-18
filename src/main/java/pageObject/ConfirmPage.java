package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ConfirmPage {

	public ConfirmPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id =  "ovo.id:id/cancel_button")	
	public WebElement btnCancel;

	/*
	 * viewpager:
	 * ovo.id:id/vp_onboarding / androidx.viewpager.widget.ViewPager
	 * 
	 * ovo.id:id/fingerprint_icon / android.widget.ImageView
	 * ovo.id:id/fingerprint_status / android.widget.TextView / Touch sensor
	 * 
	 */
}
