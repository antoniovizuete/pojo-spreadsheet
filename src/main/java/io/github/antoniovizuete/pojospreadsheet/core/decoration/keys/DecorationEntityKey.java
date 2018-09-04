package io.github.antoniovizuete.pojospreadsheet.core.decoration.keys;

/**
 * @author Antonio Vizuete
 * @since 0.1
 */
public interface DecorationEntityKey<T> {
  default T getKey() { return (T) this; }

  boolean equals(Object o);
}
