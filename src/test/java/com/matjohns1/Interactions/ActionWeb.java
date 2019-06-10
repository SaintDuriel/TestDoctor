package com.matjohns1.Interactions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;


/**
 * Created by matjohns1 on 6/5/19 2:24 PM
 */
public class ActionWeb<E extends WebElement ,T extends WebDriver> implements ActionModule<WebElement,RemoteWebDriver> {
    protected RemoteWebDriver driver;
    protected RemoteWebDriver webDriver; 
    private Duration implicitWait = Duration.ofSeconds(5); 

    
    private void logElementExceptions(By by)
    {
    	System.out.println("========================================");
    	System.err.println("Unable to Locate Element by: " + by);
    	System.out.println("========================================");
    }


    public ActionWeb(T safariDriver) {
		this.driver = (RemoteWebDriver) safariDriver; 
		this.webDriver = (RemoteWebDriver) driver; 
	}
    
	
	public RemoteWebDriver returnDriver() {
        return driver;
    }

    public RemoteWebElement returnElement(By by) {
        return (RemoteWebElement) webDriver.findElement(by);
    }

    public RemoteWebElement returnElement(By by, Duration time) {
		return null;
        
    }

    public RemoteWebElement findElement(By by) {
       try {
    	   return (RemoteWebElement) webDriver.findElement(by);
       } catch (Exception e) {
    	   this.logElementExceptions(by);
    	   e.printStackTrace();
    	   return null; 
       }
    	
    }

    public RemoteWebElement findElement(By by, Duration time) {
    	try {
     	   return (RemoteWebElement) this.setFluentWait(time).until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (Exception e) {
     	   this.logElementExceptions(by);
     	   e.printStackTrace();
     	   return null; 
        }
    }

    public RemoteWebElement findClickableElement(By by) {
        return waitElementClickable(by);
    }

    public RemoteWebElement findClickableElement(By by, Duration time) {
        return waitElementClickable(by, time);
    }

    public RemoteWebElement findVisibleElement(By by) {
        return waitElementVisible(by);
    }

    public RemoteWebElement findVisibleElement(By by, Duration time) {
    	return waitElementVisible(by, time);
    }

    public RemoteWebElement switchToAlert(By by) {
        return null;
    }

    public Alert switchToAlert() {
        return webDriver.switchTo().alert();
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
    	webDriver.quit(); 
    }

    public void TeardownRefresh() {

    }

    public void getURL(String URL) {
        webDriver.get(URL);
    }

	public FluentWait<WebDriver> setFluentWait(Duration time) {
		return new FluentWait<WebDriver>(webDriver).withTimeout(time); 
		
	}

	public void click(By by) {
		try {
			((WebElement) this.waitElementClickable(by)).click(); 
		} catch (Exception e) {
			logElementExceptions(by); 
			e.printStackTrace();
		}
		
		
	}

	public void click(By by, Duration time) {
		// TODO Auto-generated method stub
		
	}

	public void clickClickable(By by) {
		try {
			this.findClickableElement(by).click(); 
		} catch (Exception e) {
			logElementExceptions(by); 
			e.printStackTrace();
		}
		
	}

	public void clickClickable(By by, Duration time) {
		try {
			((WebElement) this.findClickableElement(by, time)).click(); 
		} catch (Exception e) {
			logElementExceptions(by); 
			e.printStackTrace();
		}
		
		
	}

	public void setImplicitWait(Duration time) {
		implicitWait = time; 
		
	}

	public RemoteWebElement waitElementPresent(By by) {
		return (RemoteWebElement) this.setFluentWait(implicitWait).until(ExpectedConditions.presenceOfElementLocated(by));
	}

	public RemoteWebElement waitElementVisible(By by) {
		return (RemoteWebElement)this.setFluentWait(implicitWait).until(ExpectedConditions.visibilityOfElementLocated(by));
		
	}

	public RemoteWebElement waitElementClickable(By by) {
		return (RemoteWebElement) this.setFluentWait(implicitWait).until(ExpectedConditions.elementToBeClickable(by));
		
	}

	public RemoteWebElement waitElementPresent(By by, Duration time) {
		return (RemoteWebElement)this.setFluentWait(time).until(ExpectedConditions.presenceOfElementLocated(by)); 
		
	}

	public RemoteWebElement waitElementVisible(By by, Duration time) {
		return (RemoteWebElement)this.setFluentWait(time).until(ExpectedConditions.visibilityOfElementLocated(by)); 
		
	}

	public RemoteWebElement waitElementClickable(By by, Duration time) {
		return (RemoteWebElement)this.setFluentWait(time).until(ExpectedConditions.elementToBeClickable(by)); 
		
	}
	public void sendKeys(By by, String text) {
		try {
			((WebElement) this.findElement(by)).sendKeys(text);
		} catch(Exception e)
		{
			this.logElementExceptions(by);
			e.printStackTrace();
		}
		
	}
	public void sendKeys(By by, Duration time, String text) {
		// TODO Auto-generated method stub
		
	}
	public List<WebElement> findElements(By locator) {
		return this.webDriver.findElements(locator);
		
	}
	public List<WebElement> findElements(By locator, Duration time) {
		// TODO Auto-generated method stub
		return null;
	}


	public void wait(int time) {
		// TODO Auto-generated method stub
		
	}


	public void wait(Duration time) {
		// TODO Auto-generated method stub
		
	}
	
public String getText(By by) {
		return findElement(by).getText(); 
	}
}
