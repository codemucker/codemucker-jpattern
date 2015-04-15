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

@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target(ElementType.TYPE)
@IsGeneratorConfig(defaultGenerator="org.codemucker.jmutate.generate.matcher.ManyMatchersGenerator")
public @interface GenerateManyMatchers {

    /**
     * If enabled keep this pattern in sync with changes after the initial
     * generation. Defaults to true.
     */
    boolean keepInSync() default true;
    
	boolean enabled() default true;

	boolean inheritParentProperties() default true;

    boolean markGenerated() default true;
    /**
     * The package to generate the matchers in. If empty use the same package as the pojo one
     */
    String generateToPackage() default "";
    
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
    String[] staticBuilderMethodNames() default {};

    /**
     * If expression set filter the dependencies scanned for pojos. Default is empty meaning all dependencies.
     * 
     * <p>Format is groupId:artifactId:classifier:extension where any part can be empty/* (the same), or the last ones omitted.
     * </p>
     * 
     * <p>E.g.
     * 
     * <ul>
     * 	<li>mycompany:myartifact:sources:jar
     * 	<li>mycompany::sources:jar
     * 	<li>mycompany:myartifact
     * 	<li>mycompany:*:*:jar
     *  <li>mycompany:*
     *  <li>mycompany
     *  <li>(mycompany:myartifact || othercompany:*) && !(*:*:sources)
     *  
     * </ul>
     * </p>
     * 
     * @see {@link org.codemucker.jmatch.expression.ExpressionParser} and {@link org.codemucker.jfind.matcher.ARoot#dependenciesExpression}
     */
    String pojoDependencies() default "";

    /**
     * The expression for matching the types found. Matches the no arg builder method names on  {@link org.codemucker.jmutate.ast.matcher.AJType}
     * 
     * @see {@link org.codemucker.jmatch.expression.ExpressionParser} and {@link org.codemucker.jmutate.ast.matcher.AJType}
     * @return
     */
    String pojoTypes() default "PublicConcreteClass";
    
    /**
     * Proeperty names to generate matchers for. Default empty which means all
     * @return
     */
    String fieldNames() default "";
    
    /**
     * The expression for matching the pojos. By default matches everything (in the packages and dependencies set to be scanned) except for system classes. Logical ant expression pattern matching.
     *
     *<p>E.g.
     * 
     * <ul>
     * 	<li>(com.acme.* || com.other.model.*) && !(*Abstract* || *Base*)
     * </ul>
     * 
     * @see {@link org.codemucker.jmatch.expression.ExpressionParser} and {@link org.codemucker.jmatch.AString.matchingAnyAntPattern}
     */
    String pojoNames() default "!(java.* || javax.* || *Abstract*)";
    
    /**
     * If true also scan source files (not just compiled dependencies). Default is true.
     */
    boolean scanSources() default true;
    
    /**
     * If true also scan binary dependencies for pojos to generate matchers for. Default is true.
     */
    boolean scanDependencies() default true;
    
    boolean debugShowMatches() default false;
    boolean debugShowIgnores() default false;
    
    ClashStrategy clashStrategy() default ClashStrategy.SKIP;
    
}
