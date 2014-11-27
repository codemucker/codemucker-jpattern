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
package org.codemucker.jpattern;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * Marks a class as having been generated. This usually indicates the class
 * should not be modified by hand
 */
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target({ElementType.TYPE,ElementType.METHOD,ElementType.FIELD,ElementType.CONSTRUCTOR})
public @interface IsGenerated {

	/**
	 * The sha1 hash of the generated item. Used to detect if the item has been structurally been modified
	 * or needs updating
	 * .
	 * Hash should be generated from the AST tree, ignoring spaces, formatting
	 */
	String sha1() default "";
	
	/**
	 * Name of the generator used
	 */
	String generator();
	
	/**
	 * Version of the generator
	 */
	String version() default "";    
}
