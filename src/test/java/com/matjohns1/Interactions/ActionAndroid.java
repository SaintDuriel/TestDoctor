package com.matjohns1.Interactions;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;

/**
 * Created by matjohns1 on 6/5/19 2:24 PM
 */
public class ActionAndroid<X> implements ActionModule<X> {

    protected WebDriver driver;
    protected AndroidDriver<MobileElement> androidDriver;

    public ActionAndroid(WebDriver driver) {
        this.driver = driver;
        this.androidDriver = (AndroidDriver<MobileElement>) driver;
    }


    public AndroidDriver<MobileElement> returnDriver() {
        return androidDriver;
    }

    public WebElement returnElement(By locator) {
        return null;
    }

    public WebElement returnElement(By locator, int time, Boolean useMilliSeconds) {
        return null;
    }

    public WebElement findElement(By locator) {
        return null;
    }

    public WebElement findElement(By locator, int time, Boolean useMilliSeconds) {
        return null;
    }

    public WebElement findClickableElement(By locator) {
        return null;
    }

    public WebElement findClickableElement(By locator, int time, Boolean useMilliSeconds) {
        return null;
    }

    public WebElement findVisibleElement(By locator) {
        return null;
    }

    public WebElement findVisibleElement(By locator, int time, Boolean useMilliSeconds) {
        return null;
    }

    public WebElement switchToAlert(By locator) {
        return null;
    }

    public Alert switchToAlert() {
        return null;
    }

    public Boolean isClickable(By locator) {
        return null;
    }

    public Boolean isClickable(By locator, int time, Boolean useMilliSeconds) {
        return null;
    }

    public Boolean isVisible(By locator) {
        return null;
    }

    public Boolean isVisible(By locator, int time, Boolean useMilliSeconds) {
        return null;
    }

    public Boolean isPresent(By locator) {
        return null;
    }

    public Boolean isPresent(By locator, int time, Boolean useMilliSeconds) {
        return null;
    }

    public void waitElementPresent() {

    }

    public void waitElementVisible() {

    }

    public void waitElementClickable() {

    }

    public void swipeByDirection(Direction direction) {

    }

    public void scrollUpAndDownTillVisible(By locator, int retryCount) {

    }

    public void scrollUpTillVisible(By locator, int retryCount) {

    }

    public void scrollDownTillVisible(By Locator, int retryCount) {

    }

    public void swipeUp() {

    }

    public void swipeDown() {

    }

    public void swipeLeft() {

    }

    public void swipeRight() {

    }

    public void swipeOnElementWithDirection(By locator, Direction direction) {

    }

    public void hideKeyboard() {

    }

    public void displayKeyboard() {

    }

    public void Teardown() {

    }

    public void TeardownRefresh() {

    }

    public void getURL(String URL) {
        androidDriver.get(URL);
    }


	public WebElement returnElement(By locator, Duration time) {
		// TODO Auto-generated method stub
		return null;
	}


	public WebElement findElement(By locator, Duration time) {
		// TODO Auto-generated method stub
		return null;
	}


	public ArrayList<WebElement> findElements(By locator) {
		// TODO Auto-generated method stub
		return null;
	}


	public ArrayList<WebElement> findElements(By locator, Duration time) {
		// TODO Auto-generated method stub
		return null;
	}


	public WebElement findClickableElement(By locator, Duration time) {
		// TODO Auto-generated method stub
		return null;
	}


	public WebElement findVisibleElement(By locator, Duration time) {
		// TODO Auto-generated method stub
		return null;
	}


	public Boolean isClickable(By locator, Duration time) {
		// TODO Auto-generated method stub
		return null;
	}


	public Boolean isVisible(By locator, Duration time) {
		// TODO Auto-generated method stub
		return null;
	}


	public Boolean isPresent(By locator, Duration time) {
		// TODO Auto-generated method stub
		return null;
	}


	public Wait setFluentWait(Duration time) {
		// TODO Auto-generated method stub
		return null;
	}


	public void sendKeys(By by, String text) {
		// TODO Auto-generated method stub
		
	}


	public void sendKeys(By by, Duration time, String text) {
		// TODO Auto-generated method stub
		
	}


	public void click(By by) {
		// TODO Auto-generated method stub
		
	}


	public void click(By by, Duration time) {
		// TODO Auto-generated method stub
		
	}


	public void clickClickable(By by) {
		// TODO Auto-generated method stub
		
	}


	public void clickClickable(By by, Duration time) {
		// TODO Auto-generated method stub
		
	}


	public void setImplicitWait(Duration time) {
		// TODO Auto-generated method stub
		
	}


	public WebElement waitElementPresent(By by) {
		// TODO Auto-generated method stub
		return null;
	}


	public WebElement waitElementVisible(By by) {
		// TODO Auto-generated method stub
		return null;
	}


	public WebElement waitElementClickable(By by) {
		// TODO Auto-generated method stub
		return null;
	}


	public WebElement waitElementPresent(By by, Duration time) {
		// TODO Auto-generated method stub
		return null;
	}


	public WebElement waitElementVisible(By by, Duration time) {
		// TODO Auto-generated method stub
		return null;
	}


	public WebElement waitElementClickable(By by, Duration time) {
		// TODO Auto-generated method stub
		return null;
	}
}
