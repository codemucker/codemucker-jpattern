package org.codemucker.jpattern.generate;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target(ElementType.TYPE)
@IsGeneratorConfig(defaultGenerator="org.codemucker.jmutate.generate.bean.PropertiesGenerator")
public @interface GenerateProperties {

	boolean markGenerated() default true;
	
	boolean generateNoArgCtor() default true;
	
	boolean generateAbstractSuperClass() default true;

	boolean enabled() default true;
	
	/**
	 * If true inherit super class properties. Default false
	 */
	boolean inheritParentProperties() default false;
	
	/**
	 * If true, then generate public static finalString fields of all the property names. Helpful if needing to perform reflection, fire events etc. 
	 */
	boolean generateStaticPropertyNameFields() default false;
	
	/**
	 * If true then add add/remove methods for indexed properties (like lists/maps)
	 * @return
	 */
	boolean generateAddRemoveMethodsForIndexProperties() default true;
	
	boolean readonlyProperties() default false;
	/**
	 * The fields to match. Default is empty which means all
	 */
	String fieldNames() default "";

	/**
	 * What access level to force fields to. Default is private
	 */
	Access fieldAccess() default Access.PRIVATE;

	/**
	 * If true then fire property change events when  properties are set
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
