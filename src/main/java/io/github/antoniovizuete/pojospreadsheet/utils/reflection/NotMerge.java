package io.github.antoniovizuete.pojospreadsheet.utils.reflection;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * The interface Not merge.
 *
 * @author Antonio Vizuete
 * @since 0.1
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface NotMerge {

}
