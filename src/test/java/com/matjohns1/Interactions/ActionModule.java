package com.matjohns1.Interactions;

import com.matjohns1.Core.Base;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by matjohns1 on 6/5/19 9:53 AM
 */




public interface ActionModule<X>
{
    enum Direction
{
    UP,DOWN,LEFT,RIGHT
}

    WebDriver returnDriver();
    WebElement returnElement(By locator);
    WebElement returnElement(By locator, Duration time);
    WebElement findElement(By locator);
    WebElement findElement(By locator, Duration time);
    ArrayList<WebElement> findElements(By locator);
    ArrayList<WebElement> findElements(By locator, Duration time);
    WebElement findClickableElement(By locator);
    WebElement findClickableElement(By locator, Duration time);
    WebElement findVisibleElement(By locator);
    WebElement findVisibleElement(By locator, Duration time);
    WebElement switchToAlert(By locator);
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
    WebElement waitElementPresent(By by);
    WebElement waitElementVisible(By by);
    WebElement waitElementClickable(By by);
    WebElement waitElementPresent(By by, Duration time);
    WebElement waitElementVisible(By by, Duration time);
    WebElement waitElementClickable(By by, Duration time);
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


}
