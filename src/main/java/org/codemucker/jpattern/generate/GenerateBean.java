package org.codemucker.jpattern.generate;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target(ElementType.TYPE)
@GeneratorOptions(defaultGenerator="org.codemucker.jmutate.generate.bean.Generator")
public @interface GenerateBean {

	boolean markGenerated() default true;
	
	boolean generateNoArgCtor() default true;

	boolean generateAllArgCtor() default true;

	/**y
	 * If true generate a 'validate' method. This will use the hibernate
	 * validation bindings
	 * 
	 */
	boolean generateValidateMethod() default false;

	/**
	 * If true then generate a bean copy method
	 */
	boolean generateBeanCopyMethod() default false;
	
	boolean generateHashCodeAndEqualsMethod() default true;
	
	boolean generateAbstractSuperClass() default true;
	
	/**
	 * If true, then generate public static finalString fields of all the property names. Helpful if needing to perform reflection, fire events etc. 
	 */
	boolean generateStaticPropertyNameFields() default false;
	
	String abstractSuperPrefix() default "Abstract";

	boolean readonlyProperties() default false;
	/**
	 * The fields to match. Default is empty which means all
	 */
	String fieldNames() default "";

	Access fieldAccess() default Access.PRIVATE;

	/**
	 * If true then fire when  properties are set
	 */
	boolean bindable() default false;
	
	/**
	 * If true then allow property setters to be vetoable
	 */
	boolean vetoable() default false;

	/**
	 * If true properties are converted into first class citizens. That is, they are public final Property&lt;X&gt; types
	 */
	//boolean propertiesFirstClassCitizens() default false;

	/**
     * What to do if a builder method already exists which is not marked as under this generators control
     */
    ClashStrategy clashStrategy() default ClashStrategy.SKIP;
    
}
