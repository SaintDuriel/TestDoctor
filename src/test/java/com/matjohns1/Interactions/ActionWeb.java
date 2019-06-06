package com.matjohns1.Interactions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by matjohns1 on 6/5/19 2:24 PM
 */
public class ActionWeb<X> implements ActionModule<X> {
    protected WebDriver driver;
    private Duration implicitWait = Duration.ofSeconds(5); 

    
    private void logElementExceptions(By by)
    {
    	System.out.println("========================================");
    	System.err.println("Unable to Locate Element by: " + by);
    	System.out.println("========================================");
    }
    public ActionWeb(WebDriver driver)
    {
        this.driver = driver;
    }

    public WebDriver returnDriver() {
        return driver;
    }

    public WebElement returnElement(By by) {
        return driver.findElement(by);
    }

    public WebElement returnElement(By by, Duration time) {
		return null;
        
    }

    public WebElement findElement(By by) {
       try {
    	   return driver.findElement(by);
       } catch (Exception e) {
    	   this.logElementExceptions(by);
    	   e.printStackTrace();
    	   return null; 
       }
    	
    }

    public WebElement findElement(By by, Duration time) {
    	try {
     	   return this.setFluentWait(time).until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (Exception e) {
     	   this.logElementExceptions(by);
     	   e.printStackTrace();
     	   return null; 
        }
    }

    public WebElement findClickableElement(By by) {
        return waitElementClickable(by);
    }

    public WebElement findClickableElement(By by, Duration time) {
        return waitElementClickable(by, time);
    }

    public WebElement findVisibleElement(By by) {
        return waitElementVisible(by);
    }

    public WebElement findVisibleElement(By by, Duration time) {
    	return waitElementVisible(by, time);
    }

    public WebElement switchToAlert(By by) {
        return null;
    }

    public Alert switchToAlert() {
        return driver.switchTo().alert();
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
    	driver.quit(); 
    }

    public void TeardownRefresh() {

    }

    public void getURL(String URL) {
        driver.get(URL);
    }

	public Wait<WebDriver> setFluentWait(Duration time) {
		return new FluentWait<WebDriver>(driver).withTimeout(time); 
		
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
			this.findClickableElement(by, time).click(); 
		} catch (Exception e) {
			logElementExceptions(by); 
			e.printStackTrace();
		}
		
		
	}

	public void setImplicitWait(Duration time) {
		implicitWait = time; 
		
	}

	public WebElement waitElementPresent(By by) {
		return this.setFluentWait(implicitWait).until(ExpectedConditions.presenceOfElementLocated(by));
	}

	public WebElement waitElementVisible(By by) {
		return this.setFluentWait(implicitWait).until(ExpectedConditions.visibilityOfElementLocated(by));
		
	}

	public WebElement waitElementClickable(By by) {
		return this.setFluentWait(implicitWait).until(ExpectedConditions.elementToBeClickable(by));
		
	}

	public WebElement waitElementPresent(By by, Duration time) {
		return this.setFluentWait(time).until(ExpectedConditions.presenceOfElementLocated(by)); 
		
	}

	public WebElement waitElementVisible(By by, Duration time) {
		return this.setFluentWait(time).until(ExpectedConditions.visibilityOfElementLocated(by)); 
		
	}

	public WebElement waitElementClickable(By by, Duration time) {
		return this.setFluentWait(time).until(ExpectedConditions.elementToBeClickable(by)); 
		
	}
	public void sendKeys(By by, String text) {
		try {
			this.findElement(by).sendKeys(text);
		} catch(Exception e)
		{
			this.logElementExceptions(by);
			e.printStackTrace();
		}
		
	}
	public void sendKeys(By by, Duration time, String text) {
		// TODO Auto-generated method stub
		
	}
	public ArrayList<WebElement> findElements(By locator) {
		// TODO Auto-generated method stub
		return null;
	}
	public ArrayList<WebElement> findElements(By locator, Duration time) {
		// TODO Auto-generated method stub
		return null;
	}
}
