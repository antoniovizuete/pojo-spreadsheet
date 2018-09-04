package io.github.antoniovizuete.pojospreadsheet.utils.reflection;

import java.lang.reflect.Method;

/**
 * The type Field.
 *
 * @author Antonio Vizuete
 * @since 0.1
 */
public class Field {

  private String name;
  private Method getter;
  private Method setter;

  /**
   * Instantiates a new Field.
   *
   * @param name the name
   */
  public Field(String name) {
    this.name = name;
  }

  /**
   * Gets name.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Sets name.
   *
   * @param name the name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Set method.
   *
   * @param method the method
   */
  public void setMethod(Method method) {
    if (MethodUtils.isGetter(method)) {
      setGetter(method);
    }

    if (MethodUtils.isSetter(method)) {
      setSetter(method);
    }
  }

  /**
   * Gets getter.
   *
   * @return the getter
   */
  public Method getGetter() {
    return getter;
  }

  /**
   * Sets getter.
   *
   * @param getter the getter
   */
  public void setGetter(Method getter) {
    this.getter = getter;
  }

  /**
   * Gets setter.
   *
   * @return the setter
   */
  public Method getSetter() {
    return setter;
  }

  /**
   * Sets setter.
   *
   * @param setter the setter
   */
  public void setSetter(Method setter) {
    this.setter = setter;
  }


}
