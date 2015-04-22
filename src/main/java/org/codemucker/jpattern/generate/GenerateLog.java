package org.codemucker.jpattern.generate;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target(ElementType.TYPE)
@IsGeneratorConfig(defaultGenerator = "org.codemucker.jmutate.generate.log.LogGenerator")
public @interface GenerateLog {

	boolean markGenerated() default true;

	boolean enabled() default true;

	/**
	 * Name of the log field. Default is 'LOG'
	 */
	String fieldName() default "LOG";

	/**
	 * If empty then use the name of the class
	 * 
	 * @return
	 */
	String topic() default "";

	/**
	 * What to do if a log statement already exists which is not marked as under
	 * this generators control
	 */
	ClashStrategy clashStrategy() default ClashStrategy.SKIP;

	/**
	 * The logger framework to use
	 * 
	 * @return
	 */
	Type logger() default Type.Log4j;

	public static enum Type {
		/**
		 * <pre>
		 * org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(..)
		 * </pre>
		 */
		CommonsLog("org.apache.commons.logging.Log",
				"org.apache.commons.logging.LogFactory.getLog", true),
		/**
		 * <pre>
		 * java.util.logging.Logger LOG = java.util.logging.Logger(..)
		 * </pre>
		 */
		JavaLog("java.util.logging.Logger", "java.util.logging.Logger", false),
		/**
		 * <pre>
		 * org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger(..)
		 * </pre>
		 */
		Log4j("org.apache.log4j.Logger", "org.apache.log4j.Logger.getLogger",true),
		/**
		 * <pre>
		 * org.apache.logging.log4j.LogManager.getLogger(..)
		 * </pre>
		 */
		Log4j2("org.apache.logging.log4j.Logger",
				"org.apache.logging.log4j.LogManager.getLogger", true),
		/**
		 * <pre>
		 * org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(..)
		 * </pre>
		 */
		Slf4j("org.slf4j.Logger", "org.slf4j.LoggerFactory.getLogger", true),
		/**
		 * <pre>
		 * org.slf4j.ext.XLogger LOG = org.slf4j.ext.XLoggerFactory.getXLogger(..)
		 * </pre>
		 */
		XSlf4j("org.slf4j.ext.XLogger", "org.slf4j.ext.XLoggerFactory.getXLogger", true);

		private final String loggerType;
		private final String loggerManager;
		private final boolean takesClass;

		private Type(String loggerType, String loggerManager, boolean takesClass) {
			this.loggerType = loggerType;
			this.loggerManager = loggerManager;
			this.takesClass = takesClass;
		}

		public String getLoggerType() {
			return loggerType;
		}

		public String getLogManagerExpression() {
			return loggerManager;
		}

		public boolean isTakesClass() {
			return takesClass;
		}
	}
}
