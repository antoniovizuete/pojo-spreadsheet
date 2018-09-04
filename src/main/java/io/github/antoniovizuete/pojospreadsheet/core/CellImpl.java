package io.github.antoniovizuete.pojospreadsheet.core;

import io.github.antoniovizuete.pojospreadsheet.core.converter.ConverterHelper;
import io.github.antoniovizuete.pojospreadsheet.core.decoration.keys.CellStyleKey;
import io.github.antoniovizuete.pojospreadsheet.core.model.Cell;
import io.github.antoniovizuete.pojospreadsheet.core.model.CellAddress;
import io.github.antoniovizuete.pojospreadsheet.core.model.CellStyle;
import io.github.antoniovizuete.pojospreadsheet.core.model.Row;
import io.github.antoniovizuete.pojospreadsheet.core.model.Sheet;
import io.github.antoniovizuete.pojospreadsheet.core.model.cell.adress.CellAddressImpl;
import io.github.antoniovizuete.pojospreadsheet.core.model.helpers.CellAddressHelper;
import org.apache.poi.ss.usermodel.CellType;

/**
 * Prototype class that represents a POI Cell.
 *
 * <p>{@code Cell} class is a child of {@link RowImpl}</p>
 *
 * <p>In order to customize the cell style of each cell, a cell has
 * the same methods that {@code CellStyle}. More formally, {@code Cell}
 * inherits from {@link AbstractCellStyle}.
 * </p>
 *
 * @author Antonio Vizuete
 * @since 0.1
 */
public class CellImpl extends AbstractCellStyle<Cell> implements Cell {

  private Integer index;

  private CellAddress address = CellAddress.empty();

  private CellType type = CellType.STRING;

  private CellStyleKey cellStyle;

  private RowImpl row;

  private Object value;

  private CellAddress hyperlink;

  public CellImpl(RowImpl row, Integer col) {
    super();
    this.row = row;
    this.index = col;
    this.address.col(col).row(row.getIndex()).sheet(row.parentSheet().getName());
    this.setInstance(this);
  }

  public CellImpl(RowImpl row, String col) {
    super();
    this.row = row;
    this.index = CellAddressHelper.toNumber(col);
    this.address.col(col).row(row.getIndex()).sheet(row.parentSheet().getName());
    this.setInstance(this);
  }


  @Override public Integer getIndex() {
    return this.index;
  }

  @Override public CellAddress getAddress() {
    return this.address;
  }

  @Override public CellType getType() {
    return this.type;
  }

  @Override public CellStyleKey getCellStyle() {
    return this.cellStyle;
  }

  @Override public Object getValue() {
    return this.value;
  }

  @Override public CellAddress getHyperlink() {
    return this.hyperlink;
  }

  @Override public void setIndex(Integer index) {
    this.index = index;
  }

  @Override public void setType(CellType type) {
    this.type = type;
  }

  @Override public void setCellStyle(CellStyleKey cellStyle) {
    this.cellStyle = cellStyle;
  }

  @Override public void setValue(Object value) {
    this.value = value;
  }

  @Override public void setHyperlink(CellAddressImpl hyperlink) {
    this.hyperlink = hyperlink;
  }

  public void setAddress(CellAddress address) {
    this.address = address;
  }

  /**
   * Sets the style.
   *
   * <p><b>NOTE:</b> Before use this method, you must declare and create the
   * styles through {@link SpreadsheetDecoration} class.</p>
   *
   * @param cellStyle to be set to the cell.
   * @return the current instance.
   */
  @Override public Cell cellStyle(CellStyleKey cellStyle) {
    this.cellStyle = cellStyle;
    return this;
  }

  /**
   * Sets the content of the cell.
   *
   * <p>Has a smart class selector. You can pass a {@code String},
   * {@code Number} or {@code Date} object and it selects the proper
   * POI value type.</p>
   *
   * @param value {@link String}, {@link Number} or {@link java.util.Date}
   * @return the current instance.
   */
  @Override public Cell value(Object value) {
    this.value = value;
    return this;
  }

  /**
   * Sets an internal link to the indicated cell.
   *
   * @param hyperlink Excel address format string (p.e. "Sheet1!A1").
   * @return the current instance.
   */
  @Override public Cell hyperlink(String hyperlink) {
    this.hyperlink = CellAddress.of(hyperlink);
    return this;
  }

  /**
   * Sets an internal link to the indicated cell.
   *
   * @param hyperlink to the {@link CellAddressImpl}.
   * @return the current instance.
   */
  @Override public Cell hyperlink(CellAddressImpl hyperlink) {
    this.hyperlink = hyperlink;
    return this;
  }

  /**
   * Returns the {@link RowImpl} where the {@code Cell} is located.
   *
   * @return the {@link RowImpl} where the {@code Cell} is located.
   */
  @Override public Row parentRow() {
    return this.row;
  }

  /**
   * Returns the {@link SheetImpl} where the {@code Cell} is located.
   *
   * @return the {@link SheetImpl} where the {@code Cell} is located.
   */
  @Override public Sheet parentSheet() {
    return this.row.parentSheet();
  }

  /**
   * Returns the next sibling {@code Cell}.
   *
   * @return the next sibling {@code Cell}.
   */
  @Override public Cell nextCell() {
    return this.row.cell();
  }

  /**
   * Returns the previous sibling {@code Cell}.
   *
   * @return the previous sibling {@code Cell}.
   * @throws IllegalStateException (optional) if you try get
   *                               the previous {@code Cell} when you are located
   *                               at the first {@code Cell} of the {@link RowImpl}.
   */
  @Override public Cell prevCell() {
    int newIndex = index - 1;
    if (newIndex < 1) {
      throw new IllegalStateException(
        "The previous cell can not be selected. The execution thread is processing the first cell of the current row.");
    }
    return this.row.cell(newIndex);
  }

  /**
   * Returns the next sibling {@link RowImpl}.
   *
   * @return the next sibling {@link RowImpl}.
   */
  @Override public Row nextRow() {
    return this.parentRow().nextRow();
  }

  /**
   * Returns the previous sibling {@link RowImpl}.
   *
   * @return the previous sibling {@link RowImpl}.
   * @throws IllegalStateException (optional) if you try get
   *                               the previous {@link RowImpl} when you are located
   *                               at the first {@link RowImpl} of the {@link SheetImpl}.
   */
  @Override public Row prevRow() {
    return this.parentRow().prevRow();
  }

  /**
   * Merges the indicated number of {@code Cells}.
   *
   * <p><b>NOTE:</b> the merged cells are located at the parent
   * row of the current cell instance.</p>
   *
   * @param numCells number of cells to be merged.
   * @return the current instance.
   */
  @Override public Cell merge(int numCells) {
    this.parentRow().parentSheet().mergeCell(row, this, numCells);
    return this;
  }

  public String toString() {
    return "Cell(super=" + super.toString() + ", address=" + this.getAddress() + ", type=" + this.getType()
      + ", cellStyle=" + this.getCellStyle() + ", row=" + this.row + ", value=" + this.getValue() + ", hyperlink="
      + this.getHyperlink() + ")";
  }

  @Override public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;

    CellImpl cell = (CellImpl) o;

    return index.equals(cell.index);

  }

  @Override public int hashCode() {
    return index.hashCode();
  }

  protected CellStyle asCellStyle() {
    return ConverterHelper.cellAsCellStyle(this);
  }


  protected boolean isSpecificStyleNull() {
    return ConverterHelper.isSpecificStyleNull(this);

  }
}
