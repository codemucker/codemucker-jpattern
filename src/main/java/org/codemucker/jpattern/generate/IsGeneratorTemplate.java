package org.codemucker.jpattern.generate;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Marking an annotation with this marks it as being a generation template. So any 
 * other class/method/param marked with your template will inherit all the generator 
 * annotations on your template
 * 
 * <p>The template source can be in the same project as the sources being 
 * generated, or external</p>
 * 
 * <p>NOTE: REMEMBER to mark your annotation as having retention runtime!</p>
 * E.g
 * 
 * <p>
 * <pre>
 * &#64;IsGeneratorTemplate
 * 
 * &#64;GenerateProperties(fieldAccess=FieldAccess.PUBLIC)
 * &#64;GenerateBuilder()
 * 
 * &#64;Retention(RetentionPolicy.RUNTIME)
 * public &#64;interface GenerateMyThing { //custom template annotation
 * 
 * }
 * 
 * //this will inherit all the &amp;GenerateProperties and &amp;GenerateBuilder settings from the template
 * &#64;GenerateMyThing 
 * public class MyBean {
 * 	
 * }
 * 
 * //Override a template settings
 * &#64;GenerateMyThing 
 * &#64;GenerateProperties(fieldNames="!(setX*)")
 * public class MyBean2 {
 * 	
 * }
 * </pre>
 * 
 * This allows a complex or highly custom generation pattern to be be defined in one place instead of copying
 * it all over your codebase. Be careful though not to go overboard and make things more confusing!
 * 
 * <p>
 * 
 */
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target({ElementType.ANNOTATION_TYPE})
public @interface IsGeneratorTemplate {
}
