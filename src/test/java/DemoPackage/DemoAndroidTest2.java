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

public class DemoAndroidTest2 {
	
	WebDriver driver;

	@BeforeTest
	public void starttest() throws MalformedURLException {
		
		String driverpath = "C:\\Users\\U35035\\eclipse-workspace\\chromedriver_win32\\chromedriver.exe";
		
		//Set up Desired Capabilities to Appium
		
		DesiredCapabilities cap = new DesiredCapabilities();
		
		cap.setCapability("chromedriverExecutable", driverpath);
		
		//Browser name capability set only when you are running the test in Mobile Browser
		
		cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		
		
		//Android mobile capabilities
		
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
		
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1.0");
		
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "ZY322KKVTS");
		
		
		
		//Create a driver instance and connect to Appium server
		
		driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);

	}

	@Test(description="AppiumProfessionalTest")
	public void AppiumProTest() throws Exception {
		
		System.out.println("I am inside AppiumPro test1");
		
		//Access the URL
		
		driver.get("http://appiumpro.com/contact");
		
		//Fill in email in the Email address field
		
		driver.findElement(By.id("contactEmail")).sendKeys("goo@goo.com");
		
		//Fill in the comment in the message field
		
		driver.findElement(By.id("contactText")).sendKeys("I would like to know more about Appium testing");
		
		//Click Send button
		
//		String Sendbuttonxpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View[2]/android.widget.Button";
//		
//		driver.findElement(By.xpath(Sendbuttonxpath)).click();
//		
//		
//		
//		//Validate error message
//		
//		String Expectedtext = "Your message could not be sent due to an error. The error message was: You must fill out the Captcha box";
//		
//		String errormessagexpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View[3]/android.widget.TextView";
//		
//		String Actualtext = driver.findElement(By.xpath(errormessagexpath)).getText();
//		
//		if(Expectedtext.contains(Actualtext)) {
//			System.out.println("Validation text match");
//		}
//		else {
//			System.out.println("Validation text does not match");
//		}
		
		
		
	}
	
	

	@AfterTest
	public void endtest() {
		
		//close the app
		
		driver.quit();
	}
}
