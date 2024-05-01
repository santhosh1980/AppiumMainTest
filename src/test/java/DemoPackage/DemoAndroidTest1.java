package DemoPackage;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class DemoAndroidTest1 {
	
	WebDriver driver;

	@BeforeTest
	public void starttest() throws MalformedURLException {
		
		/*1) How to install .apk (Android mobile app) on real device through command prompt?
				Ensure environment variables are set for Android SDK, so that adb command can run from any folder
				ANDROID_HOME = C:\Users\U35035\AppData\Local\Android\Sdk
				adb kill-server
				adb start-server
				Go to apk file directory and run 
				adb install ApiDemos.apk

				Note: If "adb devices" command does not work from any folder even after set up the environment variable of Android Home, then run the same command from C:\Users\U35035\AppData\Local\Android\Sdk\platform-tools

		2) How to get app package and app activity in android?
				Open Android emulator or connect real device
				Open cmd and enter "adb devices" - should show the devices
				Open Android app in emulator or real device
				Enter "adb shell"
				Enter "dumpsys window windows | grep -E 'mCurrentFocus'" - it shows "app package" followed by "app activity"*/
		
		//Set up Desired Capabilities to Appium
		
		DesiredCapabilities cap = new DesiredCapabilities();
		
		
		
		//Browser name capability set only when you are running the test in Mobile Browser
		
		//cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		
		
		//Android mobile capabilities
		
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
		
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
		
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "SSUGF6U8QKQ48PBQ");
		
		
		
		//Package name of your Android app
		
		cap.setCapability("appPackage", "com.google.android.calculator");
		
		//Activity name of your Android app
		
		cap.setCapability("appActivity", "com.android.calculator2.Calculator");
		
		//Create a driver instance and connect to Appium server
		
		driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);

	}

	@Test(description="Multiply")
	public void Multiplication() throws Exception {
		
		//Click Number 9
		
		driver.findElement(By.id("com.google.android.calculator:id/digit_9")).click();
		
		//Click Multiplication sign
		
		driver.findElement(By.id("com.google.android.calculator:id/op_mul")).click();
		
		//Click Number 4
		
		driver.findElement(By.id("com.google.android.calculator:id/digit_4")).click();
		
		//Click Equals sign
		
		driver.findElement(By.id("com.google.android.calculator:id/eq")).click();
		
		//Verify result
		
		String res3 = driver.findElement(By.id("com.google.android.calculator:id/result_final")).getText();
		
		if (res3.equals("36")) {
			System.out.println("Multiplication Result is correct:" + res3);
		}
		
		else {
			System.out.println("Multiplication Result is wrong");
		}
		
		//Clear the result for next operation - Click 'C'
		
		driver.findElement(By.id("com.google.android.calculator:id/clr")).click();

	}
	
	@Test(description="Divide")
	public void Division() throws Exception {
		
		//Click Number 9
		
		driver.findElement(By.id("com.google.android.calculator:id/digit_9")).click();
		
		//Click Division sign
		
		driver.findElement(By.id("com.google.android.calculator:id/op_div")).click();
		
		//Click Number 4
		
		driver.findElement(By.id("com.google.android.calculator:id/digit_4")).click();
		
		//Click Equals sign
		
		driver.findElement(By.id("com.google.android.calculator:id/eq")).click();
		
		//Verify result
		
		String res4 = driver.findElement(By.id("com.google.android.calculator:id/result_final")).getText();
		
		if (res4.equals("2.25")) {
			System.out.println("Division Result is correct:" + res4);
		}
		
		else {
			System.out.println("Division Result is wrong");
		}
		
		//Clear the result for next operation - Click 'C'
		
		driver.findElement(By.id("com.google.android.calculator:id/clr")).click();

	}
	
	@Test(description="Add")
	public void Addition() throws Exception {
		
		//Click Number 9
		
		driver.findElement(By.id("com.google.android.calculator:id/digit_9")).click();
		
		//Click Add sign
		
		driver.findElement(By.id("com.google.android.calculator:id/op_add")).click();
		
		//Click Number 4
		
		driver.findElement(By.id("com.google.android.calculator:id/digit_4")).click();
		
		//Click Equals sign
		
		driver.findElement(By.id("com.google.android.calculator:id/eq")).click();
		
		//Verify result
		
		String res1 = driver.findElement(By.id("com.google.android.calculator:id/result_final")).getText();
		
		if (res1.equals("13")) {
			System.out.println("Addition Result is correct:" + res1);
		}
		
		else {
			System.out.println("Addition Result is wrong");
		}
		
		//Clear the result for next operation - Click 'C'
		
		driver.findElement(By.id("com.google.android.calculator:id/clr")).click();

	}
	
	@Test(description="Subtract")
	public void Subtraction() throws Exception {
		
		//Click Number 9
		
		driver.findElement(By.id("com.google.android.calculator:id/digit_9")).click();
		
		//Click Subtraction sign
		
		driver.findElement(By.id("com.google.android.calculator:id/op_sub")).click();
		
		//Click Number 4
		
		driver.findElement(By.id("com.google.android.calculator:id/digit_4")).click();
		
		//Click Equals sign
		
		driver.findElement(By.id("com.google.android.calculator:id/eq")).click();
		
		//Verify result
		
		String res2 = driver.findElement(By.id("com.google.android.calculator:id/result_final")).getText();
		
		if (res2.equals("5")) {
			System.out.println("Subtraction Result is correct:" + res2);
		}
		
		else {
			System.out.println("Subtraction Result is wrong");
		}
		
		//Clear the result for next operation - Click 'C'
		
		driver.findElement(By.id("com.google.android.calculator:id/clr")).click();

	}

	@AfterTest
	public void endtest() {
		
		//close the app
		
		driver.quit();
	}
}
