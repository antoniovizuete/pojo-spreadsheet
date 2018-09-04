package io.github.antoniovizuete.pojospreadsheet.core.decoration.keys;

/**
 * The interface Decoration entity key.
 *
 * @param <T> the type parameter
 * @author Antonio Vizuete
 * @since 0.1
 */
public interface DecorationEntityKey<T> {
  /**
   * Gets key.
   *
   * @return the key
   */
  default T getKey() { return (T) this; }

  boolean equals(Object o);
}
