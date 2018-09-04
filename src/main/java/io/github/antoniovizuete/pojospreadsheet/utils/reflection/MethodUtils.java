package io.github.antoniovizuete.pojospreadsheet.utils.reflection;

import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * The type Method utils.
 *
 * @author Antonio Vizuete
 * @since 0.1
 */
public final class MethodUtils {

  /**
   * The constant VOID_PARAMS.
   */
  public static final Object[] VOID_PARAMS = new Object[] {};

  /**
   * Is getter boolean.
   *
   * @param method the method
   * @return the boolean
   */
  public static boolean isGetter(Method method) {
    if (!method.getName().startsWith("get"))
      return false;
    if (method.getParameterTypes().length != 0)
      return false;
    if (void.class.equals(method.getReturnType()))
      return false;
    return true;
  }

  /**
   * Is setter boolean.
   *
   * @param method the method
   * @return the boolean
   */
  public static boolean isSetter(Method method) {
    if (!method.getName().startsWith("set"))
      return false;
    if (method.getParameterTypes().length != 1)
      return false;
    return true;
  }

  /**
   * Is getter or setter boolean.
   *
   * @param method the method
   * @return the boolean
   */
  public static boolean isGetterOrSetter(Method method) {
    return isGetter(method) || isSetter(method);
  }

  /**
   * Gets fields.
   *
   * @param clazz the clazz
   * @return the fields
   */
  public static HashMap<String, Field> getFields(Class<?> clazz) {
    HashMap<String, Field> fields = new HashMap<String, Field>();
    if (clazz == null || Object.class.equals(clazz)) {
      return fields;
    }
    fields.putAll(getFields(clazz.getSuperclass()));

    Method[] methods = clazz.getDeclaredMethods();
    for (Method method : methods) {
      if (isGetterOrSetter(method)) {
        Field field;
        String name = method.getName().substring(3, method.getName().length()).toLowerCase();

        if (fields.containsKey(name)) {
          field = fields.get(name);
        } else {
          field = new Field(name);
        }

        field.setMethod(method);
        fields.put(name, field);
      }
    }
    return fields;
  }

}
