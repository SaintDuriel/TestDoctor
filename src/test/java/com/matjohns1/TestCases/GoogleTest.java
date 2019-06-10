package com.matjohns1.TestCases;

import com.matjohns1.Core.Base;
import com.matjohns1.PageObjects.Annotation.PagiumFactorum;
import com.matjohns1.PageObjects.Google.Homepage;
import com.matjohns1.PageObjects.Google.SearchResults;

import java.time.Duration;
import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import org.testng.asserts.SoftAssert;

/**
 * Created by matjohns1 on 6/5/19 1:30 PM
 */
public class GoogleTest extends Base {

	Homepage home;
	SearchResults results;
	
    @BeforeClass
    public void setupTest()
    {
        actions.getURL(super.websiteURL);
        //actions.returnDriver().manage().window().fullscreen();
        home =   new PagiumFactorum().initLocators(new Homepage(), super.devicePlatform); 
        results = new PagiumFactorum().initLocators(new SearchResults(), super.devicePlatform); 
    }

    @Test(priority = 1)
    public void enterSearchFieldText()
    {
    	actions.click(home.searchFieldAnnotated);
    }

    @Test(priority = 2)
    public void submitSearchTerm()
    {
    	actions.sendKeys(home.searchFieldAnnotated, "Automation is awesome!");
    	actions.click(home.searchButtonAnnotated);
    }

    @Test(priority = 3)
    public void verifiyOnSearchResultScreen()
    {
    	String searchTerm = actions.findElement(results.searchField, Duration.ofSeconds(5)).getAttribute("value");
    	SoftAssert sa = new SoftAssert();
    	sa.assertEquals(searchTerm, "Automation is awesome!");
    	sa.assertAll();
    	try {
    		Thread.sleep(1500);
    	} catch(Exception e) {
    		//didn't sleep well I take it
    	}
    	List<?> resultList = actions.findElements(results.searchResultList);
    	sa.assertTrue(resultList.size() > 0);
    	sa.assertAll();
    	
    }

 
}
