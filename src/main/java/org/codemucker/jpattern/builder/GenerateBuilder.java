package org.codemucker.jpattern.builder;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target(ElementType.TYPE)
public @interface GenerateBuilder {

    boolean generateNoArgCtor() default true;
    boolean generateAllArgCtor() default true;
    
    String builderClassName() default "";
    String builderMethodName() default "with";
    
    String buildMethodName() default "build";
    
    
}
