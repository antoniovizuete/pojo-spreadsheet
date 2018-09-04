package io.github.antoniovizuete.pojospreadsheet.core.model;

import io.github.antoniovizuete.pojospreadsheet.utils.iterator.IntegerIndex;

import java.util.Set;

/**
 * The interface Row.
 *
 * @author Antonio Vizuete
 * @since 0.1
 */
public interface Row extends IntegerIndex {
  /**
   * Cells set.
   *
   * @return the set
   */
  Set<Cell> cells();

  /**
   * Parent sheet sheet.
   *
   * @return the sheet
   */
  Sheet parentSheet();

  /**
   * Next row row.
   *
   * @return the row
   */
  Row nextRow();

  /**
   * Prev row row.
   *
   * @return the row
   */
  Row prevRow();

  /**
   * Merge row.
   *
   * @param address  the address
   * @param numCells the num cells
   * @return the row
   */
  Row merge(String address, int numCells);

  /**
   * Merge row.
   *
   * @param index    the index
   * @param numCells the num cells
   * @return the row
   */
  Row merge(Integer index, int numCells);

  /**
   * Merge row.
   *
   * @param cell     the cell
   * @param numCells the num cells
   * @return the row
   */
  Row merge(Cell cell, int numCells);

  /**
   * Cell cell.
   *
   * @return the cell
   */
  Cell cell();

  /**
   * Cell cell.
   *
   * @param index the index
   * @return the cell
   */
  Cell cell(Integer index);

  /**
   * Cell cell.
   *
   * @param column the column
   * @return the cell
   */
  Cell cell(String column);
}
