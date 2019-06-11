package com.TestDoctor.Core;

/**
 * Created by matjohns1 on 6/5/19 8:40 AM
 */
public class A_Platform {


    public DevicePlatform devicePlatform;
    public WebPlatform webPlatform;
    public CloudPlatform cloudPlatform;
    public TestType testType;
    /**
     * Define which DevicePlatform the test will execute on
     */
    public enum DevicePlatform {
        IOS,
        ANDROID,
        WEB;
    }

    public void setDevicePlatform(String platformName)
    {
        this.devicePlatform = getDevicePlatformEnum(platformName);
    }

    public DevicePlatform getDevicePlatformEnum(String platformName)
    {
        for(DevicePlatform platform : DevicePlatform.values())
        {
            if(platformName.equalsIgnoreCase(platform.toString()))
            {
                return platform;
            }
        }
        System.err.println("Failed to determine correct DevicePlatform, returning Null");
        return null;
    }

    /**
     * Define which static WebPlatform to test on
     */
    public enum WebPlatform {
        MOBILE,
        SAFARI,
        IE10,
        IEEDGE,
        CHROME,
        FIREFOX;
    }

    public void setWebPlatform(String webPlatformName)
    {
        this.webPlatform = getWebPlatformEnum(webPlatformName);
    }

    public WebPlatform getWebPlatformEnum(String webPlatformName)
    {
        for(WebPlatform platform: WebPlatform.values())
        {
            if(webPlatformName.equalsIgnoreCase(platform.toString()))
            {
                return platform;
            }
        }
        System.err.println("Failed to determine correct DevicePlatform, returning Null");
        return null;
    }

    /**
     * Define which cloud environments will be supported by the framework
     *
     */
    public enum CloudPlatform {
        LOCAL,
        BROWSERSTACK,
        SAUCELABS,
        EXPERITEST,
        MOBILELABS;
    }

    public void setCloudPlatform(String cloudPlatformName)
    {
        this.cloudPlatform = getCloudPlatformEnum(cloudPlatformName);
    }

    public CloudPlatform getCloudPlatformEnum(String cloudPlatformName)
    {
        for(CloudPlatform platform: CloudPlatform.values())
        {
            if(cloudPlatformName.equalsIgnoreCase(platform.toString()))
            {
                return platform;
            }
        }
        System.err.println("Failed to determine correct DevicePlatform, returning Null");
        return null;
    }

    public enum TestType
    {
        APP,
        BROWSER;
    }

    public void setTestType(String testType)
    {
        this.testType = getTestTypeEnum(testType);
    }

    public TestType getTestTypeEnum(String testType)
    {
        return testType.equalsIgnoreCase("app") ? TestType.APP : TestType.BROWSER;
    }

}
