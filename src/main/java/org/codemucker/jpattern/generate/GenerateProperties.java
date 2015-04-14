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

	/**
	 * If the generated classes, methods, fields should be marked as generated. Default is true. May be overridden
	 * globally.
	 * 
	 * @return
	 */
	boolean markGenerated() default true;
	
	/**
	 * If a no arg default constructor should be generated. Default is true.
	 * @return
	 */
	boolean generateNoArgCtor() default true;
	
//	boolean generateAbstractSuperClass() default true;

	/**
	 * If false disable this generator. Useful if using templates and you wish to prevent a certain generator
	 * from running. Default is true.
	 * @return
	 */
	boolean enabled() default true;
	
	/**
	 * If true, the setter returns the pojo instance (builder pattern)
	 * @return
	 */
	boolean chainedSetters() default false;
	
	/**
	 * Setter method prefix to use. Default is 'set'
	 * 
	 * <p>Set to empty or null if just the property name should be used, as in:
	 * 
	 * <pre>setFoo(...)</pre>
	 * vs
	 * <pre>foo(..)</pre>
	 * </p>
	 * @return
	 */
	String setterPrefix() default "set";
	
	/**
	 * If true inherit super class properties. Default false
	 */
	boolean inheritParentProperties() default false;
	
	/**
	 * If true, then generate public static finalString fields of all the property names. Helpful if needing to perform reflection, fire events etc.
	 * 
	 *  <p>E.g. generate  
	 *  
	 *  <pre>
	 *  public static final PROP_FOO = "foo";
	 *  public static final PROP_BAR = "bar";
	 *  </pre>
	 *  
	 *  </p>
	 */
	boolean generateStaticPropertyNameFields() default false;
	
	/**
	 * If true then add add/remove methods for indexed properties (like lists/maps). Default is true
	 * 
	 * <p>E.g. generate  
	 *  
	 *  <pre>
	 *  public void addFoo(String foo){
	 *  	...
	 *  }
	 *  
	 *  public void removeFoo(String foo){
	 *  	...
	 *  }
	 *  </pre>
	 *  
	 *  </p>
	 * @return
	 */
	boolean generateAddRemoveMethods() default true;

	/**
	 * If false then don't generate getters for fields. Default is true
	 * @return
	 */
	boolean generateGetters() default true;
	
	/**
	 * If false then don't generate setters for fields. Default is true
	 * @return
	 */
	boolean generateSetters() default true;
	/**
	 * The fields to match. Default is empty which means all
	 */
	String fieldNames() default "";

	/**
	 * What access level to force fields to. Default is 'Default' which means leave as is
	 */
	Access fieldAccess() default Access.DEFAULT;

	/**
	 * If true then fire property change events when  properties are set. Default is false.
	 */
	boolean bindable() default false;
	
	/**
	 * If true then allow property setters to be vetoable. Default is false
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
