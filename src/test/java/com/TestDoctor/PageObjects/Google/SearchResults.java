package com.TestDoctor.PageObjects.Google;

import org.openqa.selenium.By;

import com.TestDoctor.PageObjects.Annotation.Annotations.AndroidBy;
import com.TestDoctor.PageObjects.Annotation.Annotations.IOSBy;
import com.TestDoctor.PageObjects.Annotation.Annotations.WebBy;

public class SearchResults  {

	@IOSBy(id = "qiOS")
	@WebBy(name = "q")
	@AndroidBy(name ="qAndroid")
	public By searchField = By.name("q"); 
	
	
	@IOSBy(id = "giOS")
	@WebBy(name = "g")
	@AndroidBy(name ="gAndroid")
	public By searchResultList = By.className("g"); 
}
