package org.codemucker.jpattern.bean;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target(ElementType.TYPE)
public @interface GenerateBean {

    boolean generateNoArgCtor() default true;
    boolean generateAllArgCtor() default true;
    
}
