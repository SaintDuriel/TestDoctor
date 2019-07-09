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
    private PropertyConfigs pConfig; 
	private String deviceIdentifier;
    private String deviceName;
    private String deviceVersion;
    private String appIdentifier;
    private String appActivity;
    private String appPath;
    public String websiteURL;
    public String serverURL;
    



    public DesiredCapabilities dc = new DesiredCapabilities();


    @BeforeClass(alwaysRun = true)
    @Parameters({
             "devicePlatform", "deviceVersion", "deviceName", "deviceIdentifier", "appIdentifier", "appPath", "appActivity" 
            , "cloudEnvironment", "websiteURL",  "webBrowser", 
            "testType", "testEnvironment", "realDevice"
    })
    public void setCapabilities(@Optional String devicePlatform, @Optional String deviceVersion, @Optional String deviceName
    		, @Optional String deviceIdentifier, @Optional String appIdentifier, @Optional String appPath, @Optional String appActivity 
            , @Optional String cloudEnvironment, @Optional String websiteURL,  @Optional String webBrowser, 
            @Optional String testType, @Optional String testEnvironment, @Optional String realDevice)
    {
    	pConfig = new PropertyConfigs( devicePlatform,   webBrowser,    deviceName,   deviceVersion ,   deviceIdentifier
    			,   devicePlatform,   appIdentifier,   appPath,   appActivity ,   realDevice ,   cloudEnvironment ,   testEnvironment 	
    			,  websiteURL,  testType);
        super.setTestType(pConfig.testType);
        super.setCloudPlatform(pConfig.cloudEnvironment);
        super.setTestEnvironment(pConfig.testEnvironment);
        super.setDevicePlatform(pConfig.devicePlatform);
        this.initializeDeviceParams(pConfig.deviceIdentifier, pConfig.deviceVersion, pConfig.deviceName, pConfig.appIdentifier, pConfig.appPath, pConfig.appActivity);
        super.setWebPlatform(pConfig.webBrowser);
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
                this.websiteURL = pConfig.websiteURL;
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
                this.serverURL = "http://127.0.0.1:4723/wd/hub";
                break;
            case BROWSERSTACK:
                this.serverURL = CloudPlatform.BROWSERSTACK.getBrowserStackURL();
                break;
        }
    }

    private void setCloudProperties()
    {
        //TODO: Add code for each Cloud environment properties such as any required OAuth Tokens or Credentials for access
    	
    	switch(this.cloudPlatform ) {
		case BROWSERSTACK:
			break;
		case LOCAL:
			break;			
		default:
			break;
    	
    	}
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
    	if(super.cloudPlatform == CloudPlatform.BROWSERSTACK) {
    		dc.setCapability("browser", "Chrome");
    	    dc.setCapability("browser_version", "62.0");
    	    dc.setCapability("os", "Windows");
    	    dc.setCapability("os_version", "10");
    	    dc.setCapability("resolution", "1024x768");
    	    dc.setCapability("acceptSslCerts", "true");
    	} else {
    		String filePathToDriver = getSystemPathToDriver("chromedriver"); 
            System.out.println("Setting ChromeDriver Path to: " +filePathToDriver);
            System.setProperty("webdriver.chrome.driver", filePathToDriver);
    	}
    	
    }

    private void setFirefoxCapabilities()
    {
    	if(super.cloudPlatform == CloudPlatform.BROWSERSTACK) {
    		dc.setCapability("browser", "Chrome");
    	    dc.setCapability("browser_version", "62.0");
    	    dc.setCapability("os", "Windows");
    	    dc.setCapability("os_version", "10");
    	    dc.setCapability("resolution", "1024x768");
    	    dc.setCapability("acceptSslCerts", "true");
    	} else {
    		String filePathToDriver = getSystemPathToDriver("geckodriver"); 
            System.out.println("Setting GeckoDriver Path to: " +filePathToDriver);
            System.setProperty("webdriver.gecko.driver", filePathToDriver);
    	}
    	
    }

    private void setEdgeCapabilities()
    {
    	if(super.cloudPlatform == CloudPlatform.BROWSERSTACK) {
    		dc.setCapability("browser", "Chrome");
    	    dc.setCapability("browser_version", "62.0");
    	    dc.setCapability("os", "Windows");
    	    dc.setCapability("os_version", "10");
    	    dc.setCapability("resolution", "1024x768");
    	    dc.setCapability("acceptSslCerts", "true");
    	} else {
    		System.setProperty("webdriver.chrome.driver", getSystemPathToDriver("edgedriver"));
    	}
        
    }

    private void setSafariCapabilities()
    {
    	if(super.cloudPlatform == CloudPlatform.BROWSERSTACK) {
    		dc.setCapability("browser", "Safari");
    	    dc.setCapability("browser_version", "62.0");
    	    dc.setCapability("os", "Windows");
    	    dc.setCapability("os_version", "10");
    	    dc.setCapability("resolution", "1024x768");
    	    dc.setCapability("acceptSslCerts", "true");
    		
    	} else {
    		System.setProperty("webdriver.chrome.driver", getSystemPathToDriver("safaridriver"));
    	}
        
    }

    private void setIECapabilities()
    {
    	if(super.cloudPlatform == CloudPlatform.BROWSERSTACK) {
    		dc.setCapability("browser", "Chrome");
    	    dc.setCapability("browser_version", "62.0");
    	    dc.setCapability("os", "Windows");
    	    dc.setCapability("os_version", "10");
    	    dc.setCapability("resolution", "1024x768");
    	    dc.setCapability("acceptSslCerts", "true");
    	} else {
    		System.setProperty("webdriver.chrome.driver", getSystemPathToDriver("iedriver"));
    	}
        	
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
            default:
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
		String OS = System.getProperty("os.name");
		System.out.println("Looks like your running on: " + System.getProperty("os.name"));
		if(OS.toLowerCase().contains("win")) { //We are on Windows Machine, Use Window Driver Folder and include .exe extension
			
			System.out.println("Getting a Windows " + driverName);
			
			return getSystemPathToResources() + "Drivers/WinDrivers/"+ driverName+".exe";
		} else if(OS.toLowerCase().contains("mac")){
			
			System.out.println("Getting a Mac " + driverName);
			
			return getSystemPathToResources() + "Drivers/MacDrivers/"+ driverName; 
		} else if(OS.toLowerCase().contains("nix") 
				|| OS.toLowerCase().contains("nux") 
				|| OS.toLowerCase().contains("aix")) {
			
			System.out.println("Getting a *Nix " + driverName);
			
			return getSystemPathToResources() + "Drivers/Nix/" + driverName; 
		} else {
			
			System.out.println(OS + " is not a valid Operating System for this Automation Framework. Serving up Windows Driver");
			
			return getSystemPathToResources() + "Drivers//WinDrivers/"+ driverName+".exe";
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
