package com.TestDoctor.Interactions;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.TestDoctor.Interactions.ActionModule.Direction;

/**
 * Created by matjohns1 on 6/5/19 2:24 PM
 */
public class ActionAndroid<E extends MobileElement,T extends AppiumDriver> implements ActionModule<MobileElement,AndroidDriver<MobileElement>> {

    protected RemoteWebDriver driver;
    protected AndroidDriver<MobileElement> androidDriver;
    private Duration implicitWait;
    
    public ActionAndroid(AndroidDriver<MobileElement> driver) {
        this.driver = (RemoteWebDriver)driver;
        this.androidDriver =  (AndroidDriver<MobileElement>)driver;
    }

    private void logElementExceptions(By by)
    {
    	System.out.println("========================================");
    	System.err.println("Unable to Locate Element by: " + by);
    	System.out.println("========================================");
    }

    public AndroidDriver<MobileElement> returnDriver() {
        return androidDriver;
    }

    public MobileElement returnElement(By by) {
        return androidDriver.findElement(by);
    }

    public MobileElement returnElement(By by, Duration time) {
		return (MobileElement) this.waitElementPresent(by, time);
        
    }

    public MobileElement findElement(By by) {
       try {
    	   return (MobileElement) androidDriver.findElement(by);
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
        return this.findElement(by);
    }

    public Alert switchToAlert() {
        return androidDriver.switchTo().alert();
    }

    public Boolean isClickable(By by) {
        if (this.waitElementClickable(by) != null) {
        	return true; 
        } else {
        	return false; 
        }
    }

    public Boolean isClickable(By by, Duration time) {
        if(this.waitElementClickable(by, time) != null) {
        	return true;
        } else {
        	return false; 
        }
    }

    public Boolean isVisible(By by) {
    	if(this.waitElementVisible(by) != null) {
    		return true; 
    	} else {
    		return false; 
    	}
    }

    public Boolean isVisible(By by, Duration time) {
        if(this.waitElementVisible(by, time) != null) {
        	return true; 
        } else {
        	return false; 
        }
    }

    public Boolean isPresent(By by) {
        if(this.waitElementPresent(by) != null) {
        	return true; 
        } else {
        	return false; 
        }
    }

    public Boolean isPresent(By by, Duration time) {
        if(this.waitElementPresent(by, time) != null) {
        	return true;
        } else {
        	return false; 
        }
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
    	androidDriver.quit(); 
    }

    public void TeardownRefresh() {

    }

    public void getURL(String URL) {
        androidDriver.get(URL);
    }

	public FluentWait<AndroidDriver<MobileElement>> setFluentWait(Duration time) {
		return new FluentWait<AndroidDriver<MobileElement>>((AndroidDriver<MobileElement>) androidDriver).withTimeout(time); 
		
	}

	public void click(By by) {
		try {
			((MobileElement) this.waitElementClickable(by)).click(); 
		} catch (Exception e) {
			logElementExceptions(by); 
			e.printStackTrace();
		}
		
		
	}

	public void click(By by, Duration time) {
		((MobileElement) this.findElement(by, time)).click(); 
		
	}

	public void clickClickable(By by) {
		this.findClickableElement(by);
		
	}

	public void clickClickable(By by, Duration time) {
		((MobileElement) this.findClickableElement(by, time)).click();
		
	}

	public void setImplicitWait(Duration time) {
		implicitWait = time; 
		
	}

	public MobileElement waitElementPresent(By by) {
		try {
			return (MobileElement) this.setFluentWait(implicitWait).until(ExpectedConditions.presenceOfElementLocated(by));
		} catch (Exception e) {
			this.logElementExceptions(by);
			e.printStackTrace();
			return null; 
		}
		
	}

	public MobileElement waitElementVisible(By by) {
		return (MobileElement)this.setFluentWait(implicitWait).until(ExpectedConditions.visibilityOfElementLocated(by));
		
	}

	public MobileElement waitElementClickable(By by) {
		try {
			return (MobileElement)this.setFluentWait(implicitWait).until(ExpectedConditions.elementToBeClickable(by));
		} catch (Exception e) {
			this.logElementExceptions(by);
			e.printStackTrace();
			return null; 
		}
		
	}

	public MobileElement waitElementPresent(By by, Duration time) {
		try {
			return (MobileElement)this.setFluentWait(time).until(ExpectedConditions.presenceOfElementLocated(by)); 
		} catch (Exception e) {
			this.logElementExceptions(by);
			e.printStackTrace();
			return null; 
		}
		
	}

	public MobileElement waitElementVisible(By by, Duration time) {
		try {
			return (MobileElement)this.setFluentWait(time).until(ExpectedConditions.visibilityOfElementLocated(by)); 
		} catch (Exception e) {
			this.logElementExceptions(by);
			e.printStackTrace();
			return null; 
		}
		
	}

	public MobileElement waitElementClickable(By by, Duration time) {
		try { 
			return (MobileElement)this.setFluentWait(time).until(ExpectedConditions.elementToBeClickable(by));
		} catch (Exception e) {
			this.logElementExceptions(by);
			e.printStackTrace();
			return null; 
		}
		 
		
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
	public ArrayList<MobileElement> findElements(By locator) {
		// TODO Auto-generated method stub
		return null;
	}
	public ArrayList<MobileElement> findElements(By locator, Duration time) {
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
