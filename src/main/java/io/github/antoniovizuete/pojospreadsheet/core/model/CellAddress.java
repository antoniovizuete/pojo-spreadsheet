package io.github.antoniovizuete.pojospreadsheet.core.model;

import io.github.antoniovizuete.pojospreadsheet.core.model.cell.adress.CellAddressBuilder;

/**
 * The interface Cell address.
 *
 * @author Antonio Vizuete
 * @since 0.1
 */
public interface CellAddress {
  /**
   * New instance cell address.
   *
   * @param col the col
   * @param row the row
   * @return the cell address
   */
  static CellAddress newInstance(int col, int row) {
    return CellAddressBuilder.builderInstance().col(col).row(row).build();
  }

  /**
   * Empty cell address.
   *
   * @return the cell address
   */
  static CellAddress empty() {
    return CellAddressBuilder.builderInstance().build();
  }

  /**
   * Of cell address.
   *
   * @param address the address
   * @return the cell address
   */
  static CellAddress of(String address) {
    return CellAddressBuilder.builderInstance().address(address).build();
  }

  /**
   * Col cell address.
   *
   * @param col the col
   * @return the cell address
   */
  CellAddress col(Integer col);

  /**
   * Col cell address.
   *
   * @param col the col
   * @return the cell address
   */
  CellAddress col(String col);

  /**
   * Row cell address.
   *
   * @param row the row
   * @return the cell address
   */
  CellAddress row(Integer row);

  /**
   * Sheet cell address.
   *
   * @param sheet the sheet
   * @return the cell address
   */
  CellAddress sheet(String sheet);

  /**
   * Gets col.
   *
   * @return the col
   */
  Integer getCol();

  /**
   * Gets row.
   *
   * @return the row
   */
  Integer getRow();

  /**
   * Gets sheet.
   *
   * @return the sheet
   */
  String getSheet();

  /**
   * Sets col.
   *
   * @param col the col
   */
  void setCol(Integer col);

  /**
   * Sets row.
   *
   * @param row the row
   */
  void setRow(Integer row);

  /**
   * Sets sheet.
   *
   * @param sheet the sheet
   */
  void setSheet(String sheet);
}
