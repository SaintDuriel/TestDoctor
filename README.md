# TestDoctor
Web and Mobile Test Automation framework for Browser and App testing

Currently parameters are only supported when entered via TestNG.xml file. 

DISCLAIMER: This framework is for educational purposes only. Not intended for Enterprise or Production validation. Currently under active development to incorporate new features, and to complete the actions. 

Requirements: 
JDK 1.8+
Appium Server
Appium GUI
Modern IDE with TestNG Integration
Maven 

For IOS Device Testing: 
XCode
Apple Developer Account

For Android Device Testing: 
ADB
Android Studio 

Included: 
Current Versions (As of 6/6/2019) of popular browser drivers
ChromeDriver, GeckoDriver, IEDriver, EdgeDriver
SafarDriver not included as Safari Automation is handled via builtin support. 

TestNG XML Parameters: 

***devicePlatform*** : VALUES: IOS, ANDROID, WEB
This parameter controls the device to execute on. 
IOS will try and launch an IOS device. Real or Simulated
Android will try and launch an Android device. Real or Simulated
Web will try and launch a brwoser as defined in the 'webBrowser' parameter

***deviceVersion*** : Required when trying to run on an IOS or Android device. 
 
***deviceName*** : Required when trying to run on an IOS or Android device
 
***deviceIdentifier*** : UDID of the real device under test, used for both Android and IOS devices

***appIdentifier*** : BundleID or AppPackage for app to test. NOTE: Application must already be installed. Used by IOS and Android.

***appPath*** : Path to .zip, .apk or .ipa file to be sideloaded on the device under test. Only required if going to side load the application.

***appActivity*** : The App Activity to launch on Android devices.

***cloudEnvironment*** : VALUES: Local, Browserstack, Saucelabs, Experitest, MobileLabs.
The Cloud platform to execute tests on. Can be expanded to add whichever cloud services are required. Currently only Local is configured, but can be expanded to include any cloud service as long as the supporting code for interacting with those environments is done. 

***websiteURL*** : For Browser based tests the URL of the Website to test. 

***webBrowser*** : VALUES: Mobile, Safari, IE10, IEEdge, Chrome, Firefox
Define the browser type for the test to execute upon. 
 
***testType*** :  VALUES: App, Browser
Controls whether the test is an App test or a Browser test

***testEnvironment*** : VALUES: Dev, Int, QA, UAT, Stage Prod
Defines the test environment. This sets a value available to the test scripts in order to control which URL's may be accessed. Would need to implement a method handler to return the correct URL for which environment.  


***Test Script creation***: 
1. Create a new class file within the TestCases folder. This class should extend from the Base class in the CORE folder. 
2. Once extended from Base there will be an "actions" object that is your driver interface for finding and interacting with elements. Please refer to the ActionModule class in the 'Interactions" folder to understand the methods available. Each method has a platform specific implementation for IOS, Android and Web. 
3. Annotate your test methods with the appropriate TestNG annotations for @Test, @BeforeClass, @AfterClass, @AfterMethod etc....
4. Define a TestNG.xml file with the appropriate parameters defined as Above for the test type you want to execute. Sample XML as Follows: 

Running on a Local Browser - Chrome
```
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
<suite name="Framework Test" verbose="1" parallel="false">
   	<parameter name="testType" value="BROWSER" />
        <parameter name="devicePlatform" value="Web" />
        <parameter name="testEnvironment" value="PROD" />
        <parameter name="cloudEnvironment" value="Local"/>
        <parameter name="webBrowser" value="chrome" />
        <parameter name="websiteURL" value="https://www.google.com" />
   
    <test name="Browser Test - Chrome - Google.com">
        
        <classes>
            <class name="com.matjohns1.TestCases.GoogleTest"/>
        </classes>
    </test>
</suite>
```


Running a Browser test on a Local iOS Device
```
<suite name="Framework Test" verbose="1" parallel="false">
    <test name="Device Test - iOS - Google.com">
        <parameter name="testType" value="BROWSER" />
        <parameter name="testEnvironment" value="PROD" />
        <parameter name="deviceName" value="iPhone XS Max" />
        <parameter name="deviceVersion" value="12.3.1" />
        <parameter name="deviceIdentifier" value="00008020-101D2DACEF04002E" />
        <parameter name="devicePlatform" value="IOS" />
        <parameter name="cloudEnvironment" value="Local"/>
        <parameter name="webBrowser" value="MOBILE" />
        <parameter name="websiteURL" value="https://www.google.com" />
        <classes>
            <class name="com.matjohns1.TestCases.GoogleTest"/>
        </classes>
    </test>
</suite>
```

Running an App Test on a Local IOS Device
```
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
<suite name="Framework Test" verbose="1" parallel="false">
    <test name="Device Test - iOS - Test App">
        <parameter name="testType" value="App" />
        <parameter name="testEnvironment" value="PROD" />
        <parameter name="deviceName" value="iPhone XS Max" />
        <parameter name="deviceVersion" value="12.3.1" />
        <parameter name="deviceIdentifier" value="00008020-101D2DACEF04002E" />
        <parameter name="devicePlatform" value="IOS" />
        <parameter name="cloudEnvironment" value="Local"/>
        <parameter name="appIdentifier" value="com.matjohns1.TestApp" />
        <classes>
            <class name="com.matjohns1.TestCases.GoogleTest"/>
        </classes>
    </test>
</suite>
```
