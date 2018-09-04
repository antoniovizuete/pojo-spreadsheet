package io.github.antoniovizuete.pojospreadsheet.utils.reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Set;

public final class ObjectUtils {
	
	public static <T> T mergeObject(Object from, Object into, Class<T> clazz) {

		checkPreconditions(from, into, clazz);

		HashMap<String, Field> fields = MethodUtils.getFields(clazz);
		
		Set<String> keys = fields.keySet();
		for (String key : keys) {
			Method getter = fields.get(key).getGetter();
			Method setter = fields.get(key).getSetter();
			
			if(getter == null || setter == null){
				continue;
			}
			
			if(hasAnnotation(getter, NotMerge.class) ||  hasAnnotation(setter, NotMerge.class)){
				continue;
			}
			try {
				Object fromValue = getCastedValue(
						getter.invoke(from, MethodUtils.VOID_PARAMS),
						getter.getReturnType()
						);
				
				if(fromValue != null){
					setter.invoke(into, fromValue);
				}
			} catch (IllegalArgumentException e) {
				throw new IllegalStateException(e);
			} catch (IllegalAccessException e) {
				throw new IllegalStateException(e);
			} catch (InvocationTargetException e) {
				throw new IllegalStateException(e);
			}
			
		}
		
		return clazz.cast(into);
	}

	private static <T> void checkPreconditions(Object from, Object into, Class<T> clazz) {
		checkNotNull(from, into);
		checkSameClass(from, into, clazz);
	}

	private static <T> void checkSameClass(Object from, Object into, Class<T> clazz) {
		if(!from.getClass().equals(clazz) || !into.getClass().equals(clazz)){
			throw new IllegalStateException("Cannot merge objects from different class");
		}
	}

	private static void checkNotNull(Object from, Object into) {
		if(from == null || into == null){
			throw new IllegalStateException("Cannot merge null objects");
		}
	}

	private static boolean hasAnnotation(Method method, Class<? extends Annotation> annotation){
		return method != null && method.getAnnotation(annotation) != null;
	}
	
	public static <T> T getCastedValue(Object obj, Class<T> clazz){
		return clazz.cast(obj);
	}
}
