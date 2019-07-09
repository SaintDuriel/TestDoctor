package com.TestDoctor.Core;

import java.io.FileInputStream;
import java.util.Properties;


public class PropertyConfigs {

	
	private Properties testConfig; 
	
	
	public String hostPlatform; 
	public String webBrowser; 
	public String browserResolution; 
	
	
	public String deviceName;
	public String deviceVersion; 
	public String deviceIdentifier;
	public String devicePlatform;
	public String appIdentifier;
	public String appPath;
	public String appActivity; 
	public String realDevice; 
	public String cloudEnvironment; 
	public String testEnvironment; 
	
	public String websiteURL;
	public String testType;
	
	
	/**
	 *  * Constructor method to resolve the delta's between XML and Properties file. 
	 * Any XML Variables that are null or blank will use the Properties file. 
	 * XML will Override anything provided in the property file by default. 
	 * 
	 * @param hostPlatformXML
	 * @param webBrowserXML
	 * @param deviceNameXML
	 * @param deviceVersionXML
	 * @param deviceIdentifierXML
	 * @param devicePlatformXML
	 * @param appIdentifierXML
	 * @param appPathXML
	 * @param appActivityXML
	 * @param realDeviceXML
	 * @param cloudEnvironmentXML
	 * @param testEnvironmentXML
	 * @param websiteURLXML
	 * @param testTypeXML
	 */
	public PropertyConfigs(String hostPlatformXML, String  webBrowserXML,  String  deviceNameXML, String  deviceVersionXML , String  deviceIdentifierXML
	, String  devicePlatformXML, String  appIdentifierXML, String  appPathXML, String  appActivityXML , String  realDeviceXML , String  cloudEnvironmentXML , String  testEnvironmentXML 	
	, String websiteURLXML, String testTypeXML) {
		getConfigProperties(); 
		
		realDevice = resolveDelta(realDeviceXML, "realDevice"); 
		deviceIdentifier = resolveDelta(deviceIdentifierXML, "deviceIdentifier"); 
		devicePlatform = resolveDelta(devicePlatformXML, "devicePlatform");
		deviceVersion = resolveDelta(deviceVersionXML ,"deviceVersion"); 
		deviceName = resolveDelta(deviceNameXML, "deviceName");
		appIdentifier = resolveDelta(appIdentifierXML, "appIdentifier");
		appPath = resolveDelta(appPathXML, "appPath"); 
		appActivity = resolveDelta(appActivityXML, "appActivity"); 
		
		cloudEnvironment = resolveDelta(cloudEnvironmentXML, "cloudEnvironment"); 
		
		
		websiteURL = resolveDelta(websiteURLXML, "websiteURL"); 
		webBrowser = resolveDelta(webBrowserXML, "webBrowser"); 
		testType = resolveDelta(testTypeXML, "testType"); 
		testEnvironment = resolveDelta(testEnvironmentXML,"testEnvironment"); 
	}
	
	
	private void getConfigProperties() {
		testConfig = loadPropertyFile("config.properties");
	}
	
	private Properties loadPropertyFile(String fileName) {
		Properties returnVal = new Properties(); 
		try { 
			FileInputStream fs = new FileInputStream(getLocalPath() +"/src/resources/Properties/" +fileName); 
			returnVal.load(fs);
		} catch (Exception e) {
			System.err.println("Failed to load file " + fileName);
			e.printStackTrace();
		}
		return returnVal; 
	}
	
	private String resolveDelta(String valueXML, String valueConfig) {
		String returnVal = (valueXML != null) ? valueXML : testConfig.getProperty(valueConfig).toString();
		return  returnVal; 
	}
	
	private String getLocalPath() {
		return System.getProperty("user.dir"); 
	}
}
