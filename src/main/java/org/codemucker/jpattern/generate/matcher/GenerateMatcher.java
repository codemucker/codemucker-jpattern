/*
 * Copyright 2011 Bert van Brakel
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
package org.codemucker.jpattern.generate.matcher;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.codemucker.jpattern.generate.ClashStrategy;
import org.codemucker.jpattern.generate.IsGeneratorConfig;

/**
 * Convert a type into a matcher
 */
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target(ElementType.TYPE)
@IsGeneratorConfig(defaultGenerator="org.codemucker.jmutate.generate.matcher.MatcherGenerator")
public @interface GenerateMatcher {

    /**
     * If false keep this pattern in sync with changes after the initial
     * generation. Defaults to false.
     */
    boolean oneTimeOnly() default false;
    
	boolean enabled() default true;

	boolean inheritParentProperties() default true;

    boolean markGenerated() default true;
    
    /**
     * The class to extend the matchers from. Default is empty to use the default. Must extend {@link org.codemucker.jmatch.PropertyMatcher} or have the same method
     * signatures and type declaration
     */
    Class<?> matcherBaseClass() default Object.class;

    /**
     * The matcher prefix to add to the class found. Default is empty to use the auto generated one (which either prepends 'A' or 'An')
     */
    String matcherPrefix() default "";

    /**
     * The static builder create methods to add. The 'with' as in 'AFoo.with()...' is always added. This provides additional methods to add. By default add nothing more.
     * @return
     */
    String[] builderMethodNames() default {};

    /**
     * The class to generate a matcher for
     * @return
     */
    Class<?> generateFor();
 
    /**
     * Property names to generate matchers for. Default empty which means all
     * @return
     */
    String fieldNames() default "";
    
    ClashStrategy clashStrategy() default ClashStrategy.SKIP;
    
}
