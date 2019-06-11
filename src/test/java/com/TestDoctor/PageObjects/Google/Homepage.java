package com.TestDoctor.PageObjects.Google;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import com.TestDoctor.PageObjects.Annotation.Annotations.AndroidBy;
import com.TestDoctor.PageObjects.Annotation.Annotations.IOSBy;
import com.TestDoctor.PageObjects.Annotation.Annotations.WebBy;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSBy;

public class Homepage {

	@IOSBy(name="qiOS")
	@WebBy(name = "q")
	@AndroidBy(name = "qAndroid")
	public By searchFieldAnnotated; 
	
	@IOSBy(id = "btnKiOS")
	@WebBy(name = "btnK")
	@AndroidBy(name ="btnKAndroid")
	public By searchButtonAnnotated; 
	

	public By searchField = By.name("q");
	
	public By searchButton = By.name("btnK");

	
}
