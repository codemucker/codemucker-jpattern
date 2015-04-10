/*
 * Copyright 2014 Bert van Brakel
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
@IsGeneratorConfig(defaultGenerator="org.codemucker.jmutate.generate.builder.BuilderGenerator")
public @interface GenerateBuilder {

    /**
     * If enabled keep this pattern in sync with changes after the initial
     * generation. Defaults to true.
     */
    boolean keepInSync() default true;
    
	boolean enabled() default true;

    boolean markGenerated() default true;
    /**
	 * If true, ctor property args are also marked with a {@link Property}
	 * @return
	 */
	boolean markCtorArgsAsProperties() default true;
	
    /**
     * The fields to match. Default is empty which means all
     */
    String fieldNames() default "";

    /**
     * What to do if a builder method already exists which is not marked as under this generators control
     */
    ClashStrategy clashStrategy() default ClashStrategy.SKIP;
    
    /**
     * If set to anything other than Object.class, then use the given target class to generate the builder for.
     */
    Class<?> forClass() default Object.class;
    
    /**
     * The static builder create methods to add. The 'with' as in 'AFoo.with()...' is added by default if empty. If set only these methods are used.
     * 
     * @return
     */
    String[] builderCreateMethodNames() default { "with" };

    String builderClassName() default "";
    
    String buildMethodName() default "build";
    
    public static enum Inherit {
    	PROPERTIES,BUILDER,BUILDER_ELSE_PROPERTIES,NONE,AUTO;
    }
    /**
     * If true generate the static builder create method 'with()' (or custom names if set via {@link #builderCreateMethodNames()}
     * 
     * Default is true
     */
    boolean generateStaticBuilderCreateMethod() default true;
    
    /**
     * If true create a static 'with()' on the builder (useful if super beans already have 'with' ctor methods)
     * @return
     */
    boolean generateStaticBuilderCreateMethodOnBuilder() default true;
	
    /**
	 * If true then add add/remove methods for indexed properties (like lists/maps)
	 * @return
	 */
	boolean generateAddRemoveMethodsForIndexProperties() default true;
	
	/**
	 * If true generate a from(bean) method on the builder
	 * 
	 * Default true
	 */
	boolean generateCreateFromBean() default true;
	
	public boolean inheritSuperBeanBuilder() default false;
	public boolean inheritParentProperties() default true;
	
	/**
	 * If true, then allow sub class builders. All build methods will return a TSelf instead of the builder concrete class
	 * @return
	 */
	public boolean supportSubclassing() default false;
	
	/**
	 * If true then the builder will cache properties before creating the bean. Else sets
	 * on bean directly.
	 * 
	 * Default is true
	 */
    boolean collectProperties() default true;
}
