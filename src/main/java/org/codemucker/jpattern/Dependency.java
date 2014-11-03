package org.codemucker.jpattern;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Used in generator annotations to define a dependency of some sort 
 */
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target(ElementType.ANNOTATION_TYPE)
public @interface Dependency {
    String group();
    String artifact() default "";
}