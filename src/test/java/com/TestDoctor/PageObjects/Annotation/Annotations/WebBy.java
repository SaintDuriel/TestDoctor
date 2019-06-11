package com.TestDoctor.PageObjects.Annotation.Annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.TYPE})
public @interface WebBy {
	String className() default ""; 
	String css() default ""; 
	String id() default ""; 
	String name() default ""; 
	String xpath() default "";
	String accessibilityId() default "";
}
