package io.github.antoniovizuete.pojospreadsheet.core;

import io.github.antoniovizuete.pojospreadsheet.utils.iterator.AbstractIntegerSet;
import io.github.antoniovizuete.pojospreadsheet.utils.iterator.IntegerIndex;
import io.github.antoniovizuete.pojospreadsheet.core.model.Cell;
import io.github.antoniovizuete.pojospreadsheet.core.model.Row;
import io.github.antoniovizuete.pojospreadsheet.core.model.Sheet;
import io.github.antoniovizuete.pojospreadsheet.core.model.helpers.CellAddressHelper;

import java.util.Set;

/**
 * Prototype class that represents a POI Row.
 *
 * <p>{@code Row} class is a child of {@link SheetImpl}</p>
 *
 * <p>Has a collection of {@link CellImpl}.
 * </p>
 *
 * @author Antonio Vizuete
 * @since 0.1
 */
public class RowImpl extends AbstractIntegerSet<Cell> implements IntegerIndex, Row {

  private Sheet sheet;

  private Integer index;

  public RowImpl(Sheet sheet, Integer index) {
    this.sheet = sheet;
    this.index = index;
  }

  @Override public Set<Cell> cells() { return set; }

  @Override public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;

    RowImpl cells = (RowImpl) o;

    return index.equals(cells.index);

  }

  @Override public int hashCode() {
    return index.hashCode();
  }

  /**
   * Internal purpose method.
   *
   * <p>Returns a new instance of a {@link CellImpl} placed
   * into indicated column (index).</p>
   *
   * @param index of the column where the new {@link CellImpl} will be placed.
   * @return a new instance of {@link CellImpl}.
   */
  public Cell createItem(Integer index) {
    return new CellImpl(this, index);
  }

  /**
   * Returns the {@link SheetImpl} where the {@code Cell} is located.
   *
   * @return the {@link SheetImpl} where the {@code Cell} is located.
   */
  @Override public Sheet parentSheet() {
    return sheet;
  }

  /**
   * Returns the next sibling {@code Row}.
   *
   * @return the next sibling {@code Row}.
   */
  @Override public Row nextRow() {
    return this.parentSheet().row();
  }

  /**
   * Returns the previous sibling {@code Row}.
   *
   * @return the previous sibling {@code Row}.
   * @throws IllegalStateException (optional) if you try to get
   *                               the previous {@code Row} when you are located
   *                               at the first {@code Row} of the {@link SheetImpl}.
   */
  @Override public Row prevRow() {
    int newIndex = index - 1;
    if (newIndex < 1) {
      throw new IllegalStateException(
        "The previous row can not be selected. The execution thread is processing the first row of the current parentSheet.");
    }
    return this.parentSheet().row(newIndex);
  }

  /**
   * Merges the indicated cells.
   *
   * @param address  of the first cell.
   * @param numCells number of cells to be merged (to the right)
   * @return the current instance.
   */
  @Override public Row merge(String address, int numCells) {
    return merge(CellAddressHelper.toNumber(address), numCells);
  }

  /**
   * Merges the indicated cells.
   *
   * @param index    column of the first cell.
   * @param numCells number of cells to be merged (to the right)
   * @return the current instance.
   */
  @Override public Row merge(Integer index, int numCells) {
    return merge(add(index), numCells);
  }

  /**
   * Merges the indicated cells.
   *
   * @param cell     instance ({@link CellImpl}).
   * @param numCells number of cells to be merged (to the right)
   * @return the current instance.
   */
  @Override public Row merge(Cell cell, int numCells) {
    this.parentSheet().mergeRow(this, cell, numCells);
    return this;
  }

  /**
   * Returns new {@link CellImpl} instance.
   *
   * @return new {@link CellImpl} instance.
   */
  @Override public Cell cell() {
    return super.add();
  }

  /**
   * Returns the {@link CellImpl} located into indicated index column.
   *
   * <p>If not exist the referenced cell, the method returns to a
   * new cell instance placed there.</p>
   *
   * @param index column of cell.
   * @return {@link CellImpl}
   */
  @Override public Cell cell(Integer index) {
    return super.add(index);
  }

  /**
   * Returns the {@link CellImpl} located into indicated column.
   *
   * <p>If not exist the referenced cell, the method returns to a
   * new cell instance placed there.</p>
   *
   * @param column name.
   * @return {@link CellImpl}
   */
  @Override public Cell cell(String column) {
    return super.add(CellAddressHelper.toNumber(column));
  }

  public Integer getIndex() {
    return this.index;
  }
}
