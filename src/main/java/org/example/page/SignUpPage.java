package org.example.page;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static io.appium.java_client.AppiumBy.*;

public class SignUpPage {

	private AndroidDriver driver;
	private WebDriverWait wait;

		private By loginBtn = accessibilityId("Login");
		private By signUpTab = accessibilityId("button-sign-up-container");
		private By email = accessibilityId("input-email");
		private By password = accessibilityId("input-password");
		private By confirmPassword = accessibilityId("input-repeat-password");
		private By signUpBtn = accessibilityId("button-SIGN UP");
		private By message = id("android:id/message");
		private By okButton = id("android:id/button1");


		public SignUpPage(AndroidDriver driver){
			this.driver = driver;
			this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		}

		public String signUp(String userName, String password){

			this.wait.until(ExpectedConditions.elementToBeClickable(loginBtn)).click();
			this.wait.until(ExpectedConditions.elementToBeClickable(signUpTab)).click();
			this.wait.until(ExpectedConditions.elementToBeClickable(email)).sendKeys(userName);
			this.wait.until(ExpectedConditions.elementToBeClickable(this.password)).sendKeys(password);
			this.wait.until(ExpectedConditions.elementToBeClickable(this.confirmPassword)).sendKeys(password);
			this.wait.until(ExpectedConditions.elementToBeClickable(signUpBtn)).click();
			var message =	this.wait.until(ExpectedConditions.elementToBeClickable(this.message)).getText();

			this.wait.until(ExpectedConditions.elementToBeClickable(okButton)).click();

			return message;
		}


}
