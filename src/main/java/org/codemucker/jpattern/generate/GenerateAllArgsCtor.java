package org.codemucker.jpattern.generate;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target(ElementType.TYPE)
@IsGeneratorConfig(defaultGenerator="org.codemucker.jmutate.generate.bean.AllArgsConstructorGenerator")
public @interface GenerateAllArgsCtor {

	boolean markGenerated() default true;

	boolean enabled() default true;

	/**
	 * If true inherit super class properties. Default false
	 */
	boolean inheritParentProperties() default false;

	/**
	 * The fields to match. Default is empty which means all
	 */
	String fieldNames() default "";

	/**
     * What to do if a builder method already exists which is not marked as under this generators control
     */
    ClashStrategy clashStrategy() default ClashStrategy.SKIP;
    
}
