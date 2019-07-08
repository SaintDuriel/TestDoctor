package com.TestDoctor.Core;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

/**
 * Created by matjohns1 on 6/5/19 8:45 AM
 */
public class C_Capabilities extends B_Environment{
    private String deviceIdentifier;
    private String deviceName;
    private String deviceVersion;
    private String appIdentifier;
    private String appActivity;
    private String appPath;
    public String websiteURL;
    public String appiumUrl;
    



    public DesiredCapabilities dc = new DesiredCapabilities();


    @BeforeClass(alwaysRun = true)
    @Parameters({
             "devicePlatform", "deviceVersion", "deviceName", "deviceIdentifier", "appIdentifier", "appPath", "appActivity" 
            , "cloudEnvironment", "websiteURL",  "webBrowser", 
            "testType", "testEnvironment"
    })
    public void setCapabilities(@Optional String devicePlatform, @Optional String deviceVersion, @Optional String deviceName
    		, @Optional String deviceIdentifier, @Optional String appIdentifier, @Optional String appPath, @Optional String appActivity 
            , @Optional String cloudEnvironment, @Optional String websiteURL,  @Optional String webBrowser, 
            @Optional String testType, @Optional String testEnvironment)
    {
    	
    	//TODO: Get Properties from config file, and resolve deltas from XML and Config
        super.setTestType(testType);
        super.setCloudPlatform(cloudEnvironment);
        super.setTestEnvironment(testEnvironment);
        super.setDevicePlatform(devicePlatform);
        this.initializeDeviceParams(deviceIdentifier, deviceVersion, deviceName, appIdentifier, appPath, appActivity);
        super.setWebPlatform(webBrowser);
        this.setAppiumUrl();
        System.out.println("Test Type: " + super.testType.toString());
        System.out.println("Test Environment: " + super.env.toString());
        System.out.println("Cloud Execution Platform: " + super.cloudPlatform.toString());

        switch(super.testType) {

            case APP:
                System.out.println("Setting Mobile App Capabilities for platform: " + super.devicePlatform.toString());
                this.setAppTestCapabilities();
                break;
            case BROWSER:
                System.out.println("Setting Browser Capabilities for browser: " + super.webPlatform.toString());
                this.websiteURL = websiteURL;
                this.setWebTestCapabilities();
                break;
        }
        
        System.out.println("Configured Capabilities: " + dc);
    }

    private void initializeDeviceParams(String deviceIdentifier, String deviceVersion, String deviceName, String appIdentifier, String appPath, String appActivity)
    {
    	 this.deviceIdentifier = deviceIdentifier;
         this.deviceVersion = deviceVersion;
         this.deviceName = deviceName;
         this.appIdentifier = appIdentifier;
         this.appPath = appPath;
         this.appActivity = appActivity;
    }
    private void setAppiumUrl()
    {
        switch (super.cloudPlatform) {
            case LOCAL:
                this.appiumUrl = "http://127.0.0.1:4723/wd/hub";
                break;
            case BROWSERSTACK:
                this.appiumUrl = "";
                break;
            case SAUCELABS:
                this.appiumUrl = "";
                break;
            case EXPERITEST:
                this.appiumUrl = "";
                break;
            case MOBILELABS:
                this.appiumUrl = "";
                break;
        }
    }

    private void setCloudProperties()
    {
        //TODO: Add code for each Cloud environment properties such as any required OAuth Tokens or Credentials for access
    }


    private void setWebTestCapabilities() {
        dc.setCapability("noReset", true);
        dc.setCapability("newCommandTimeout", 600);
        switch (super.webPlatform) {
            case MOBILE:
                switch (super.devicePlatform) {
                    case IOS:
                        setIOSBrowserCapabilities();
                        break;
                    case ANDROID:
                        setAndroidBrowserCapabilities();
                        break;
                    case WEB:
                        break;
                }
                break;
            case SAFARI:
                setSafariCapabilities();
                break;
            case IE10:
                setIECapabilities();
                break;
            case IEEDGE:
                setEdgeCapabilities();
                break;
            case CHROME:

                setChromeCapabilities();
                break;
            case FIREFOX:
                setFirefoxCapabilities();
                break;
        }
    }

    private void setChromeCapabilities()
    {
    	String filePathToDriver = getSystemPathToDriver("chromedriver"); 
        System.out.println("Setting ChromeDriver Path to: " +filePathToDriver);
        System.setProperty("webdriver.chrome.driver", filePathToDriver);
    }

    private void setFirefoxCapabilities()
    {
    	String filePathToDriver = getSystemPathToDriver("geckodriver"); 
        System.out.println("Setting GeckoDriver Path to: " +filePathToDriver);
        System.setProperty("webdriver.gecko.driver", filePathToDriver);
    }

    private void setEdgeCapabilities()
    {
        System.setProperty("webdriver.chrome.driver", "SomePath/To/ChromeDriver");
    }

    private void setSafariCapabilities()
    {
        System.setProperty("webdriver.chrome.driver", "SomePath/To/ChromeDriver");
    }

    private void setIECapabilities()
    {
        System.setProperty("webdriver.chrome.driver", "SomePath/To/ChromeDriver");
    }


    private void setAppTestCapabilities(){

        dc.setCapability(MobileCapabilityType.NO_RESET, true);
        dc.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 600);

        switch (super.devicePlatform) {
            case IOS:
                setIOSCapabilities();
                break;
            case ANDROID:
                setAndroidCapabilities();
                break;
            case WEB:
                setWebTestCapabilities();
                break;
        }

    }

    private void setIOSBrowserCapabilities() {
        dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
        dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
        dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, this.deviceVersion);
        dc.setCapability(MobileCapabilityType.DEVICE_NAME, this.deviceName);
        dc.setCapability(MobileCapabilityType.UDID, this.deviceIdentifier);
        //dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.apple.mobilesafari");
        dc.setCapability(IOSMobileCapabilityType.BROWSER_NAME, "Safari");
    }



    private void setIOSCapabilities() {
        dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
        dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
        dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, this.deviceVersion);
        dc.setCapability(MobileCapabilityType.DEVICE_NAME, this.deviceName);
        dc.setCapability(MobileCapabilityType.UDID, this.deviceIdentifier);
        if(this.appPath!= null)
        {
            dc.setCapability("app", this.appPath);
        } else {
            dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, this.appIdentifier);
        }
    }

    private void setAndroidCapabilities() {
        dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, this.deviceVersion);
        dc.setCapability(MobileCapabilityType.DEVICE_NAME, this.deviceName);
        dc.setCapability(MobileCapabilityType.UDID, this.deviceIdentifier);
        

        if(this.appPath!= null)
        {
            dc.setCapability("app", this.appPath);
        } else {
            dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, this.appIdentifier);
            dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, this.appActivity);
        }
    }

    private void setAndroidBrowserCapabilities() {
        dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, this.deviceVersion);
        dc.setCapability(MobileCapabilityType.DEVICE_NAME, this.deviceName);
        dc.setCapability(MobileCapabilityType.UDID, this.deviceIdentifier);
        dc.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
        dc.setCapability("chromedriverExecutableDir", getSystemPathToDriver(""));
        dc.setCapability("chromedriverChromeMappingFile", getSystemPathToResources()+"chromeDriverMappingFile.json");
    }
    
    private String getSystemPathToDriver(String driverName) 
    {
    	if(getLocalPath().contains(":")) { //We are on Windows Machine, Use Window Driver Folder and include .exe extension
    		return getLocalPath() +"/src/resources/Drivers/WinDrivers/"+driverName+".exe";
    	} else {
    		return getLocalPath() +"/src/resources/Drivers/MacDrivers/" + driverName; 
    	}
    }
    
    private String getSystemPathToResources() 
    {
    	return getLocalPath() +"/src/resources/";
    }
    
    private String getLocalPath() 
    {
    	return System.getProperty("user.dir"); 
    	
    }

}
