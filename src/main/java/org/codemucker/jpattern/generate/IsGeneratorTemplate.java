package org.codemucker.jpattern.generate;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Marking an annotation with this marks it as being a template
 * for generation. So any class/method/param marked with your custom template annotation
 * will inherit the templates generator annotations
 * 
 * <p>The template annotation source can be in the same project as the sources being 
 * generated as it will be compiled as part of the generation process</p>
 * 
 * <p>NOTE: REMEMBER to mark your annotation as having retention runtime!</p>
 * E.g
 * 
 * <p>
 * <pre>
 * &amp;IsGeneratorTemplate
 * 
 * &amp;GenerateBean(fieldAccess=FieldAccess.PUBLIC)
 * &amp;GenerateBuilder()
 * 
 * &amp;Retention(RetentionPolicy.RUNTIME)
 * public &amp;interface GenerateMyThing { //custom template annotation
 * 
 * }
 * 
 * &amp;GenerateMyThing //this will inherit all the &amp;GenerateBean and &amp;GenerateBuilder settings from the template
 * public class MyBean {
 * 	
 * }
 * 
 * </pre>
 * 
 * This allows a complex or highly custom generation pattern to be be defined in one place instead of copying
 * it all over your codebase. Be careful though not to go overboard and make things more confusing!
 * <p>
 * 
 */
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target({ElementType.ANNOTATION_TYPE})
public @interface IsGeneratorTemplate {
}
