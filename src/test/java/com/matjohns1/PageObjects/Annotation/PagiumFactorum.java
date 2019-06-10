package com.matjohns1.PageObjects.Annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

import org.openqa.selenium.By;
import org.openqa.selenium.support.AbstractFindByBuilder;
import org.openqa.selenium.support.ByIdOrName;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactoryFinder;
import org.openqa.selenium.support.pagefactory.Annotations;
import org.openqa.selenium.support.pagefactory.FieldDecorator;

import com.matjohns1.Core.A_Platform.DevicePlatform;

import com.matjohns1.PageObjects.Annotation.Annotations.AndroidBy;
import com.matjohns1.PageObjects.Annotation.Annotations.IOSBy;
import com.matjohns1.PageObjects.Annotation.Annotations.WebBy;



public class PagiumFactorum {
	public <T> T initLocators(T page, DevicePlatform platform) 
	{
		switch (platform)
		{
		case ANDROID:
			System.out.println("Initializing Android Locators");
			findAndroidAnnotatedFields(page, AndroidBy.class); 
			break;
		case IOS:
			System.out.println("Initializing IOS Locators");
			findiOSAnnotatedFields(page, IOSBy.class); 
			break;
		case WEB:
			System.out.println("Initializing Web Locators");
			findWebAnnotatedFields(page, WebBy.class); 
			break;
		default:
			break;
		
		}
		return page; 
	}

	protected void findiOSAnnotatedFields(Object page, Class<IOSBy> findBy) 
	{
System.out.println("For Page Object : " + page.getClass().getName());
		
		Field[] delcaredFields = page.getClass().getDeclaredFields();
		System.out.println("Captured the following Field Count: " + delcaredFields.length); 
		for(Field field : delcaredFields) {
			IOSBy byAnno = field.getAnnotation(findBy); 
			System.out.println("Configuring Variable : " + field.getName());
			if(byAnno != null) {
				try {
					field.set(page, buildByFromShortFindBy(byAnno));
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					try {
						System.out.println("Configured By Locator to: " + field.get(page));
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}
			
		}
	}
	
	protected void findAndroidAnnotatedFields(Object page, Class<AndroidBy> findBy) 
	{
		System.out.println("For Page Object : " + page.getClass().getName());
		
		Field[] delcaredFields = page.getClass().getDeclaredFields();
		System.out.println("Captured the following Field Count: " + delcaredFields.length); 
		for(Field field : delcaredFields) {
			AndroidBy byAnno = field.getAnnotation(findBy); 
			System.out.println("Configuring Variable : " + field.getName());
			if(byAnno != null) {
				try {
					field.set(page, buildByFromShortFindBy(byAnno));
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					try {
						System.out.println("Configured By Locator to: " + field.get(page));
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}
			
		}
	}
	
	protected void findWebAnnotatedFields(Object page, Class<WebBy> findBy) 
	{
		System.out.println("For Page Object : " + page.getClass().getName());
		
		Field[] delcaredFields = page.getClass().getDeclaredFields();
		System.out.println("Captured the following Field Count: " + delcaredFields.length); 
		for(Field field : delcaredFields) {
			WebBy byAnno = field.getAnnotation(findBy); 
			System.out.println("Configuring Variable : " + field.getName());
			if(byAnno != null) {
				try {
					field.set(page, buildByFromShortFindBy(byAnno));
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					try {
						System.out.println("Configured By Locator to: " + field.get(page));
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}
			
		}
	}

	protected By buildByFromShortFindBy(IOSBy findBy)
	{
		if (!"".equals(findBy.className())) {
			return By.className(findBy.className());
		}

		if (!"".equals(findBy.accessibilityId())) {
			return By.id(findBy.accessibilityId());
		}

		if (!"".equals(findBy.id())) {
			return By.id(findBy.id());
		}

		if (!"".equals(findBy.name())) {
			return By.name(findBy.name());
		}

		if (!"".equals(findBy.xpath())) {
			return By.xpath(findBy.xpath());
		}
		return null;
		
	}
	
	protected By buildByFromShortFindBy(AndroidBy findBy)
	{
		if (!"".equals(findBy.className())) {
			return By.className(findBy.className());
		}

		if (!"".equals(findBy.css())) {
			return By.cssSelector(findBy.css());
		}

		if (!"".equals(findBy.id())) {
			return By.id(findBy.id());
		}


		if (!"".equals(findBy.name())) {
			return By.name(findBy.name());
		}

		if (!"".equals(findBy.xpath())) {
			return By.xpath(findBy.xpath());
		}
		return null;
		
	}
	
	protected By buildByFromShortFindBy(WebBy findBy) {
		if (!"".equals(findBy.className())) {
			return By.className(findBy.className());
		}

		if (!"".equals(findBy.css())) {
			return By.cssSelector(findBy.css());
		}

		if (!"".equals(findBy.id())) {
			return By.id(findBy.id());
		}

		if (!"".equals(findBy.name())) {
			return By.name(findBy.name());
		}

		if (!"".equals(findBy.xpath())) {
			return By.xpath(findBy.xpath());
		}

		// Fall through
		return null;
	}

}
