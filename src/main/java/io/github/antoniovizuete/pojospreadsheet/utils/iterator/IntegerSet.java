package io.github.antoniovizuete.pojospreadsheet.utils.iterator;


/**
 * The interface Integer set.
 *
 * @param <T> the type parameter
 * @author Antonio Vizuete
 * @since 0.1
 */
public interface IntegerSet<T extends IntegerIndex> {
  /**
   * Add t.
   *
   * @param index the index
   * @return the t
   */
  T add(Integer index);

  /**
   * Add t.
   *
   * @return the t
   */
  T add();

  /**
   * Get t.
   *
   * @param index the index
   * @return the t
   */
  T get(Integer index);

  /**
   * Gets max index.
   *
   * @return the max index
   */
  Integer getMaxIndex();

  /**
   * Create item t.
   *
   * @param index the index
   * @return the t
   */
  T createItem(Integer index);
}
