package io.github.antoniovizuete.pojospreadsheet.core.model;

/**
 * The interface Cell style.
 *
 * @author Antonio Vizuete
 * @since 0.1
 */
public interface CellStyle extends Styleable<CellStyle> {
  /**
   * Clone instance cell style.
   *
   * @return the cell style
   */
  CellStyle cloneInstance();
}
