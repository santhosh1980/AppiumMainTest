package DemoPackage;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class DemoAndroidTest3 {
	
	WebDriver driver;

	@BeforeTest
	public void starttest() throws MalformedURLException {
		
		/*1) How to install .apk (Android mobile app) on real device through command prompt?
				Ensure environment variables are set for Android SDK, so that adb command can run from any folder
				ANDROID_HOME = C:\Users\U35035\AppData\Local\Android\Sdk
				abd kill-server
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
		
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1.0");
		
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "ZY322KKVTS");
		
		
		
		//Package name of your Android app - API Demos
		
		cap.setCapability("appPackage", "io.appium.android.apis");
		
		//Activity name of your Android app - API Demos
		
		cap.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
		
		//Create a driver instance and connect to Appium server
		
		//driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		
		driver = new AppiumDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		
		System.out.println("App started");

	}

	/*@Test(priority=0, description="Text/LogTextBox")
	public void LogTextBox() throws Exception {
		
		//Click Menu 'Text'
		
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Text\"]")).click();
		
		//Click Menu item 'Text/LogTextBox'
		
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"LogTextBox\"]")).click();
		
		//Click Menu item 'Text/LogTextBox/Add'
		
		driver.findElement(By.id("io.appium.android.apis:id/add")).click();
		
		Thread.sleep(3000);
		
		//Text message
		
		String message = driver.findElement(By.id("io.appium.android.apis:id/text")).getText();
		
		if (message.contains("This is a test")) {
			System.out.println("Test message match");
		}
		else {
			System.out.println("Test message not match");
		}
		
		
		
		//Click Menu item 'Text/LogTextBox/Do Nothing'
		
		driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Do nothing\"]")).click();
	}
	
	@Test(priority=1, description="Text/Linkify")
	public void Linkify() throws Exception {
		
		//Click back button
		
		driver.navigate().back();
		
				
		//Click Menu item 'Text/Linkify'
		
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Linkify\"]")).click();
		
		Thread.sleep(3000);
		
		//Text message
		
		String expectedtxt1message = "text1: Various kinds of data that will be auto-linked. "
				+ "In this text are some things that are actionable. "
				+ "For instance, you can click on http://www.google.com and it will launch the web browser. "
				+ "You can click on google.com too. "
				+ "If you click on (415) 555-1212 it should dial the phone. "
				+ "Or just write foobar@example.com for an e-mail link. "
				+ "If you have a URI like http://www.example.com/lala/foobar@example.com you should get the full link not the e-mail address. "
				+ "Or you can put a location like 1600 Amphitheatre Parkway, Mountain View, CA 94043. "
				+ "To summarize: https://www.google.com, or 650-253-0000, somebody@example.com, or 9606 North MoPac Expressway, Suite 400, Austin, TX 78759.";
		
		String actualtxt1message = driver.findElement(By.id("io.appium.android.apis:id/text1")).getText();
		
		if (actualtxt1message.contains(expectedtxt1message)) {
			System.out.println("Text1 match");
		}
		else {
			System.out.println("Text1 not match");
		}
		
		
	}*/
	
	@Test(priority=3, description="Preference/Default values")
	public void PreferenceValues() throws Exception {
		
		//Click Menu 'Preference'
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Preference\"]")).click();
		
		
		
		//Click Menu item 'Preference/4.Default values'
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"4. Default values\"]")).click();
		
		
		
		//Menu item 'Preference/4.Default values/Checkbox preference'
		
		MobileElement chkboxelement = (MobileElement)driver.findElement(By.id("android:id/checkbox"));
		
		//Validate checkbox is enabled or not
		
		if (chkboxelement.isDisplayed() && chkboxelement.isEnabled()) {
			chkboxelement.click();
			Thread.sleep(3000);
			
			if(chkboxelement.isSelected()) {
				System.out.println("Preference checkbox is selected");
			}
			else {
				System.out.println("Preference checkbox is Unselected");
			}
		}
		else {
			System.out.println("Preference checkbox is either not displayed/enabled");
		}
		
		Thread.sleep(3000);
		
		
		
		
		
		//Menu item 'Preference/4.Default values/Edit text preference'
		
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.RelativeLayout")).click();
		
		//Check the default value in the textbox
		
		String defvaluetext = driver.findElement(By.id("android:id/edit")).getText();
		
		if (defvaluetext.equals("Default value")){
			System.out.println("Default Textbox value is: "+ defvaluetext);
			System.out.println("Default value test pass");
		}
		else {
			System.out.println("Default value test fail");
		}
		
		Thread.sleep(3000);
		
		//Clear the default value
		
		driver.findElement(By.id("android:id/edit")).clear();
		
		//Enter favourite animal in the textbox
		
		String amendvaluetext="Parrot";
		
		driver.findElement(By.id("android:id/edit")).sendKeys(amendvaluetext);
		
		Thread.sleep(3000);
		
		//Click ok button
		
		driver.findElement(By.id("android:id/button1")).click();
		
		//Menu item 'Preference/4.Default values/Edit text preference'
		
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.RelativeLayout")).click();
				
		//Check the amend value in the textbox
		
		String extractamendvaluetext = driver.findElement(By.id("android:id/edit")).getText();
				
				if (extractamendvaluetext.equals(amendvaluetext)){
					System.out.println("Amended Textbox value is: "+ extractamendvaluetext);
					System.out.println("Amend value test pass");
				}
				else {
					System.out.println("Amend value test fail");
				}
		//Click Cancel button
		
		driver.findElement(By.id("android:id/button2")).click();
		
		
		
		//Click list preference
		
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[3]/android.widget.RelativeLayout")).click();
		
		Thread.sleep(3000);
		
		//Extract Apha option text and compare
		
		String alphatext = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[1]")).getText();
		
		if(alphatext.equals("Alpha Option 01")) {
			System.out.println("Alpha text match and it is: "+alphatext);
		}
		else
		{
			System.out.println("Alpha text NOT match and it is: "+alphatext);
		}
		
		//Click Alpha option
		
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[1]")).click();
				
		
		
		//Click list preference
		
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[3]/android.widget.RelativeLayout")).click();
		
		Thread.sleep(3000);
			
		//Extract Beta option text and compare
				
		String betatext = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[2]")).getText();
				
		if(betatext.equals("Beta Option 02")) {
			System.out.println("Beta text match and it is: "+betatext);
		}
		else
		{
			System.out.println("Beta text NOT match and it is: "+betatext);
		}
		
		//Click Beta option
		
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[2]")).click();
					
		
		
		//Click list preference
		
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[3]/android.widget.RelativeLayout")).click();
						
		Thread.sleep(3000);
		
		//Extract Charlie option text and compare
						
		String charlietext = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[3]")).getText();
						
		if(charlietext.equals("Charlie Option 03")) {
			System.out.println("Charlie text match and it is: "+charlietext);
		}
		else
		{
			System.out.println("Charlie text NOT match and it is: "+charlietext);
		}
		
		//Click Charlie option
		
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[3]")).click();
					
	}
	

	@AfterTest
	public void endtest() {
		
		//close the app
		
		driver.quit();
	}
}
