package org.example.tests;

import io.appium.java_client.Setting;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.example.page.SignUpPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.time.Duration;

public class wdiotest {

	private AndroidDriver driver;

	@BeforeClass
	public void setUpClass() throws MalformedURLException {

		var options = new UiAutomator2Options();
		var appPath = Path.of(System.getProperty("user.dir"),"src/test/resources/wdio.apk").toString();

		options.setApp(appPath);
		options.setDeviceName("Pixel_3a");
		options.setAvd("Pixel_3a");
		options.setAppWaitActivity("com.wdiodemoapp.MainActivity");
		options.setCapability("appium:settings[ignoreUnimportantViews]",true);
		this.driver = new AndroidDriver(new URL("http://localhost:4724"), options);
		this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.setSetting(Setting.IGNORE_UNIMPORTANT_VIEWS,true);

	}

	@AfterClass
	public void tearDownClass(){
		this.driver.quit();
	}

	@Test
	public void testSignUp(){
		var signUpPage = new SignUpPage(driver);

		var message = signUpPage.signUp("admin@tt.com","admin@123456");

		Assert.assertEquals(message,"You successfully signed up!");
	}
}
