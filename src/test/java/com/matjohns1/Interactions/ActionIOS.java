package com.matjohns1.Interactions;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

import java.lang.reflect.Type;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.matjohns1.Interactions.ActionModule.Direction;

/**
 * Created by matjohns1 on 6/5/19 2:24 PM
 */
public class ActionIOS<E extends MobileElement, T extends AppiumDriver> implements ActionModule<MobileElement,IOSDriver> {

	
    protected RemoteWebDriver driver;
    protected IOSDriver<MobileElement> iosdriver; 
    
    Duration implicitWait;

    public ActionIOS(IOSDriver<MobileElement> iosDriver2) {
        this.driver = iosDriver2;
        this.iosdriver = iosDriver2;
    }
    
    private void logElementExceptions(By by)
    {
    	System.out.println("========================================");
    	System.err.println("Unable to Locate Element by: " + by);
    	System.out.println("========================================");
    }

    public IOSDriver<MobileElement> returnDriver() {
        return this.iosdriver;
    }

    public MobileElement returnElement(By by) {
        return iosdriver.findElement(by);
    }

    public MobileElement returnElement(By by, Duration time) {
		return null;
        
    }

    public MobileElement findElement(By by) {
       try {
    	   return (MobileElement) iosdriver.findElement(by);
       } catch (Exception e) {
    	   this.logElementExceptions(by);
    	   e.printStackTrace();
    	   return null; 
       }
    	
    }

    public MobileElement findElement(By by, Duration time) {
    	try {
     	   return (MobileElement) this.setFluentWait(time).until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (Exception e) {
     	   this.logElementExceptions(by);
     	   e.printStackTrace();
     	   return null; 
        }
    }

    public MobileElement findClickableElement(By by) {
        return waitElementClickable(by);
    }

    public MobileElement findClickableElement(By by, Duration time) {
        return waitElementClickable(by, time);
    }

    public MobileElement findVisibleElement(By by) {
        return waitElementVisible(by);
    }

    public MobileElement findVisibleElement(By by, Duration time) {
    	return waitElementVisible(by, time);
    }

    public MobileElement switchToAlert(By by) {
        return null;
    }

    public Alert switchToAlert() {
        return iosdriver.switchTo().alert();
    }

    public Boolean isClickable(By by) {
        return null;
    }

    public Boolean isClickable(By by, Duration time) {
        return null;
    }

    public Boolean isVisible(By by) {
        return null;
    }

    public Boolean isVisible(By by, Duration time) {
        return null;
    }

    public Boolean isPresent(By by) {
        return null;
    }

    public Boolean isPresent(By by, Duration time) {
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

    public void scrollUpAndDownTillVisible(By by, int retryCount) {

    }

    public void scrollUpTillVisible(By by, int retryCount) {

    }

    public void scrollDownTillVisible(By by, int retryCount) {

    }

    public void swipeUp() {

    }

    public void swipeDown() {

    }

    public void swipeLeft() {

    }

    public void swipeRight() {

    }

    public void swipeOnElementWithDirection(By by, Direction direction) {

    }

    public void hideKeyboard() {

    }

    public void displayKeyboard() {

    }

    public void Teardown() {
    	iosdriver.quit(); 
    }

    public void TeardownRefresh() {

    }

    public void getURL(String URL) {
        iosdriver.get(URL);
    }

	public Wait<IOSDriver<MobileElement>> setFluentWait(Duration time) {
		return new FluentWait<IOSDriver<MobileElement>>(iosdriver).withTimeout(time); 
		
	}

	public void click(By by) {
		try {
			this.waitElementClickable(by).click();
		} catch (Exception e) {
			logElementExceptions(by); 
			e.printStackTrace();
		}
		
		
	}

	public void click(By by, Duration time) {
		// TODO Auto-generated method stub
		
	}

	public void clickClickable(By by) {
		// TODO Auto-generated method stub
		
	}

	public void clickClickable(By by, Duration time) {
		try {
			((MobileElement) this.findClickableElement(by, time)).click(); 
		} catch (Exception e) {
			logElementExceptions(by); 
			e.printStackTrace();
		}
		
		
	}

	public void setImplicitWait(Duration time) {
		implicitWait = time; 
		
	}

	public MobileElement waitElementPresent(By by) {
		return (MobileElement) this.setFluentWait(implicitWait).until(ExpectedConditions.presenceOfElementLocated(by));
	}

	public MobileElement waitElementVisible(By by) {
		return (MobileElement)this.setFluentWait(implicitWait).until(ExpectedConditions.visibilityOfElementLocated(by));
		
	}

	public MobileElement waitElementClickable(By by) {
		return (MobileElement) this.setFluentWait(implicitWait).until(ExpectedConditions.elementToBeClickable(by));
		
	}

	public MobileElement waitElementPresent(By by, Duration time) {
		return (MobileElement)this.setFluentWait(time).until(ExpectedConditions.presenceOfElementLocated(by)); 
		
	}

	public MobileElement waitElementVisible(By by, Duration time) {
		return (MobileElement)this.setFluentWait(time).until(ExpectedConditions.visibilityOfElementLocated(by)); 
		
	}

	public MobileElement waitElementClickable(By by, Duration time) {
		return (MobileElement)this.setFluentWait(time).until(ExpectedConditions.elementToBeClickable(by)); 
		
	}
	public void sendKeys(By by, String text) {
		try {
			((MobileElement) this.findElement(by)).sendKeys(text);
		} catch(Exception e)
		{
			this.logElementExceptions(by);
			e.printStackTrace();
		}
		
	}
	public void sendKeys(By by, Duration time, String text) {
		// TODO Auto-generated method stub
		
	}
	public List<MobileElement> findElements(By locator) {
		// TODO Auto-generated method stub
		return iosdriver.findElements(locator); 
	}
	public List<MobileElement> findElements(By locator, Duration time) {
		// TODO Auto-generated method stub
		return null;
	}

	public void wait(int time) {
		try { 
			driver.wait((long) time); 
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}

	public void wait(Duration time) {
		// TODO Auto-generated method stub
		
	}
	
public String getText(By by) {
		
		return findElement(by).getText(); 
		
	}
}
