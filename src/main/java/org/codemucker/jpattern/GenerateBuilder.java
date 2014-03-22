package org.codemucker.jpattern;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface GenerateBuilder {

	boolean ctor() default true;
	String name() default "";
}