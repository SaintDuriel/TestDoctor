package com.matjohns1.TestCases;

import com.matjohns1.Core.Base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.TestInstance;
import org.testng.asserts.SoftAssert;

/**
 * Created by matjohns1 on 6/5/19 1:30 PM
 */
public class GoogleTest extends Base {

    @BeforeClass
    public void setupTest()
    {
        actions.getURL(super.websiteURL);
    }

    @Test(priority = 1)
    public void enterSearchFieldText()
    {
    	actions.click(By.name("q"));
    }

    @Test(priority = 2)
    public void submitSearchTerm()
    {
    	actions.sendKeys(By.name("q"), "Automation is awesome!");
    	actions.click(By.name("btnK"));
    }

    @Test(priority = 3)
    public void verifiyOnSearchResultScreen()
    {
    	String searchTerm = actions.findElement(By.name("q"), Duration.ofSeconds(5)).getText();
    	SoftAssert sa = new SoftAssert();
    	sa.assertEquals(searchTerm, "Automation is awesome!");
    	sa.assertAll();
    	
    }

 
}
