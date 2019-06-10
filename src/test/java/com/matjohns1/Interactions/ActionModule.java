package com.matjohns1.Interactions;

import com.matjohns1.Core.Base;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * Created by matjohns1 on 6/5/19 9:53 AM
 */




public interface ActionModule<E extends WebElement,T extends RemoteWebDriver>
{ 
	enum Direction
	{
		UP,DOWN,LEFT,RIGHT
	}

    T returnDriver();
    E returnElement(By locator);
    E returnElement(By locator, Duration time);
    E findElement(By locator);
    E findElement(By locator, Duration time);
    List<E> findElements(By locator);
    List<E> findElements(By locator, Duration time);
    E findClickableElement(By locator);
    E findClickableElement(By locator, Duration time);
    E findVisibleElement(By locator);
    E findVisibleElement(By locator, Duration time);
    E switchToAlert(By locator);
    Alert switchToAlert();
    Boolean isClickable(By locator);
    Boolean isClickable(By locator, Duration time);
    Boolean isVisible(By locator);
    Boolean isVisible(By locator, Duration time);
    Boolean isPresent(By locator);
    Boolean isPresent(By locator, Duration time);
    Wait setFluentWait(Duration time);
    void sendKeys(By by, String text); 
    void sendKeys(By by, Duration time, String text); 
    void click(By by);
    void click(By by, Duration time); 
    void clickClickable(By by); 
    void clickClickable(By by, Duration time);
    void setImplicitWait(Duration time);
    void wait(int time); 
    void wait(Duration time); 
    E waitElementPresent(By by);
    E waitElementVisible(By by);
    E waitElementClickable(By by);
    E waitElementPresent(By by, Duration time);
    E waitElementVisible(By by, Duration time);
    E waitElementClickable(By by, Duration time);
    void swipeByDirection(Direction direction);
    void scrollUpAndDownTillVisible(By locator, int retryCount);
    void scrollUpTillVisible(By locator, int retryCount);
    void scrollDownTillVisible(By Locator, int retryCount);
    void swipeUp();
    void swipeDown();
    void swipeLeft();
    void swipeRight();
    void swipeOnElementWithDirection(By locator, Direction direction);
    void hideKeyboard();
    void displayKeyboard();
    void Teardown();
    void TeardownRefresh();
    void getURL(String URL);
    String getText(By by); 


}
