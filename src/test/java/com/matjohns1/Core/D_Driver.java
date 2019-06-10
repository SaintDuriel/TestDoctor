package com.matjohns1.Core;

import com.matjohns1.Interactions.ActionAndroid;
import com.matjohns1.Interactions.ActionIOS;
import com.matjohns1.Interactions.ActionWeb;
import io.appium.java_client.MobileElement;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

import com.matjohns1.Interactions.ActionModule;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by matjohns1 on 6/5/19 8:47 AM
 */
public class D_Driver extends C_Capabilities{

    public ActionModule<?,?> actions = null;

    private URL serverUrl = null;

    @BeforeClass(alwaysRun = true)
    public void configureDriver() {
    	this.setServerUrl();
    	switch(super.testType)
    	{
		case APP:
			this.getMobilePlatformDriver();
			break;
		case BROWSER:
			this.getWebPlatformDriver();
			break;
		default:
			break;
    	}
    	
    	System.out.println("Configured Driver pointing to address: " + serverUrl);
    }
    public void setServerUrl() {
        try {
        	serverUrl = new URL(super.appiumUrl);
        } catch (Exception e)
        {
            e.printStackTrace();
            //Meh shouldn't happen.
        }
    }

    public void getMobilePlatformDriver()
    {
        switch(super.devicePlatform){

            case IOS:
                actions = new ActionIOS<MobileElement,IOSDriver<MobileElement>>(new IOSDriver<MobileElement>(serverUrl, super.dc));
                break;
            case ANDROID:
                actions = new ActionAndroid<MobileElement,AndroidDriver<MobileElement>>(new AndroidDriver<MobileElement>(serverUrl, super.dc)) ;
                break;
            case WEB:
                this.getWebPlatformDriver();
                break;
        }
    }

    public void getWebPlatformDriver()
    {
        switch(super.webPlatform){

            case MOBILE:
                getMobilePlatformDriver();
                break;
            case SAFARI:
                actions = new ActionWeb<WebElement,SafariDriver>(new SafariDriver());
                break;
            case IE10:
                actions = new ActionWeb<WebElement,InternetExplorerDriver>(new InternetExplorerDriver());
                break;
            case IEEDGE:
                actions = new ActionWeb<WebElement, EdgeDriver>(new EdgeDriver());
                break;
            case CHROME:
                actions = new ActionWeb<WebElement,ChromeDriver>(new ChromeDriver());
                break;
            case FIREFOX:
                actions = new ActionWeb<WebElement,FirefoxDriver>(new FirefoxDriver());
                break;
        }
        //actions.getURL(super.websiteURL);
    }
}
