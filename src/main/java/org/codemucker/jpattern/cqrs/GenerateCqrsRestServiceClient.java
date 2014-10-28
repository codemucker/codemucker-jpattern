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
package org.codemucker.jpattern.cqrs;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.codemucker.jpattern.DefaultGenerator;

@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target(ElementType.TYPE)
@DefaultGenerator("org.codemucker.jmutate.generate.GeneratorCqrsRestServiceClient")
public @interface GenerateCqrsRestServiceClient {

    /**
     * If enabled keep this pattern in sync with changes after the initial
     * generation. Defaults to true.
     */
    boolean keepInSync() default true;

    /**
     * Generate the asynchronous request methods. Defaults to true.
     */
    boolean generateAsync() default true;

    /**
     * Generate the synchronous request methods. Defaults to true;
     */
    boolean generateSync() default true;

    /**
     * Whether to generate a matching interface for this service.. Defaults to
     * true.
     */
    boolean generateInterface() default true;

    /**
     * If interface generation is enabled, the name of the interface. If not set
     * calculates one. Default is empty.
     */
    String serviceInterfaceName() default "";

    /**
     * The visibility of the the request conversion methods. . Defaults to
     * 'public'.
     */
    String serviceMethodVisibility() default "public";

    /**
     * If set filter the dependencies scanned for request beans
     */
    Dependency[] requestBeanDependencies() default {};

    /**
     * The packages to search in for the request beans. Defaults to search all.
     */
    String[] requestBeanPackages() default {};

    /**
     * The pattern for finding the request command/query beans
     */
    String[] requestBeanNames() default {};

    public @interface Dependency {
        String group();
        String artifact() default "";
    }
}
