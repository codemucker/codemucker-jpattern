package org.codemucker.jpattern.generate;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.codemucker.jpattern.bean.Property;

@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target(ElementType.TYPE)
@GeneratorOptions(defaultGenerator="org.codemucker.jmutate.generate.bean.BeanGenerator")
public @interface GenerateBean {

	boolean markGenerated() default true;
	/**
	 * If true, ctor property args are also marked with a {@link Property}
	 * @return
	 */
	boolean markCtorArgsAsProperties() default true;
	
	boolean generateNoArgCtor() default true;
	
	/**
	 * If true generate a constructor with all the bean properties
	 */
	boolean generateAllArgCtor() default false;
	
	boolean generateCloneMethod() default false;

	boolean generateToString() default true;
	
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
	 * If true inherit super class properties. Default false
	 * 
	 * TODO
	 */
	//TODO
	boolean inheritSuperClassProperties() default false;
	
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
