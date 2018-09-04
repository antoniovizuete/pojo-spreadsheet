package io.github.antoniovizuete.pojospreadsheet.core.model.cell.adress;

import io.github.antoniovizuete.pojospreadsheet.core.model.helpers.CellAddressHelper;
import io.github.antoniovizuete.pojospreadsheet.core.model.CellAddress;

import java.util.Objects;

/**
 * Class that represents the address of a cell.
 *
 * @author Antonio Vizuete
 * @since 0.1
 */
public final class CellAddressImpl implements CellAddress {

  /**
   * The cell's column.
   */
  private Integer col;

  /**
   * The cell's row.
   */
  private Integer row;

  /**
   * The cell's sheet.
   */
  private String sheet;

  protected CellAddressImpl() {
  }

  protected CellAddressImpl(final int col, final int row) {
    this.row = row;
    this.col = col;
  }


  @Override public CellAddress col(Integer col) {
    this.col = col;
    return this;
  }

  @Override public CellAddress col(String col) {
    this.col = CellAddressHelper.toNumber(col);
    return this;
  }

  @Override public CellAddress row(Integer row) {
    this.row = row;
    return this;
  }

  @Override public CellAddress sheet(String sheet) {
    this.sheet = sheet;
    return this;
  }

  @Override public String toString() {
    String s = "";
    s = s + (sheet == null ? "" : "'" + sheet + "'!");
    s = s + (col == null ? "" : CellAddressHelper.toName(col));
    s = s + (row == null ? "" : row);
    return s;
  }

  @Override public Integer getCol() {
    return this.col;
  }

  @Override public Integer getRow() {
    return this.row;
  }

  @Override public String getSheet() {
    return this.sheet;
  }

  @Override public void setCol(Integer col) {
    this.col = col;
  }

  @Override public void setRow(Integer row) {
    this.row = row;
  }

  @Override public void setSheet(String sheet) {
    this.sheet = sheet;
  }

  @Override public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    CellAddressImpl that = (CellAddressImpl) o;
    return Objects.equals(col, that.col) && Objects.equals(row, that.row) && Objects.equals(sheet, that.sheet);
  }

  @Override public int hashCode() {
    return Objects.hash(col, row, sheet);
  }
}
