package de.ralleytn.simple.json;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Marks a JSON attribute for serialization.
 * @author Ralph Niemitz/RalleYTN(ralph.niemitz@gmx.de)
 * @version 1.0.0
 * @since 1.0.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface JSONAttribute {

	/**
	 * @return the name of the attribute
	 * @since 1.0.0
	 */
	public String name();
	
	/**
	 * {@link Type#GETTER} is used for serializing an object. If it is used on a method, it is not allowed to have any parameters!
	 * {@link Type#SETTER} is used for deserializing an object. If it is used on a method, it can only have one parameter!
	 * If this {@linkplain Annotation} is used on a field, it has to be accessible!
	 * @return the attribute type
	 * @since 1.0.0
	 */
	public Type[] type() default {Type.GETTER, Type.SETTER};
	
	/**
	 * 
	 * @author Ralph Niemitz/RalleYTN(ralph.niemitz@gmx.de)
	 * @version 1.0.0
	 * @since 1.0.0
	 */
	public static enum Type {
		
		/**
		 * 
		 * @since 1.0.0
		 */
		GETTER,
		
		/**
		 * 
		 * @since 1.0.0
		 */
		SETTER;
	}
}
