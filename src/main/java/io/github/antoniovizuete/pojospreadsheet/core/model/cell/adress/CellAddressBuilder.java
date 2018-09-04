package io.github.antoniovizuete.pojospreadsheet.core.model.cell.adress;

import io.github.antoniovizuete.pojospreadsheet.core.model.helpers.CellAddressHelper;
import io.github.antoniovizuete.pojospreadsheet.core.model.CellAddress;

import java.util.Optional;

/**
 * The type Cell address builder.
 *
 * @author Antonio Vizuete
 * @since 0.1
 */
public final class CellAddressBuilder {
  private Integer col;

  private Integer row;

  private String sheet;


  private CellAddressBuilder() { /* Private default constructor */ }

  /**
   * Builder instance cell address builder.
   *
   * @return the cell address builder
   */
  public static CellAddressBuilder builderInstance() {
    return new CellAddressBuilder();
  }

  /**
   * Build cell address.
   *
   * @return the cell address
   */
  public CellAddress build() {
    final CellAddress cellAddress = new CellAddressImpl();
    cellAddress.setSheet(sheet);
    cellAddress.setCol(col);
    cellAddress.setRow(row);
    return cellAddress;
  }

  /**
   * Address cell address builder.
   *
   * @param address the address
   * @return the cell address builder
   */
  public CellAddressBuilder address(String address) {
    Optional.ofNullable(CellAddressHelper.extractSheetName(address)).ifPresent(this::setSheet);
    this.setCol(CellAddressHelper.extractColumn(address));
    this.setRow(CellAddressHelper.extractRow(address));
    return this;
  }

  /**
   * Col cell address builder.
   *
   * @param col the col
   * @return the cell address builder
   */
  public CellAddressBuilder col(Integer col) {
    this.setCol(col);
    return this;
  }

  /**
   * Row cell address builder.
   *
   * @param row the row
   * @return the cell address builder
   */
  public CellAddressBuilder row(Integer row) {
    this.setRow(row);
    return this;
  }

  /**
   * Sheet cell address builder.
   *
   * @param sheet the sheet
   * @return the cell address builder
   */
  public CellAddressBuilder sheet(String sheet) {
    this.setSheet(sheet);
    return this;
  }

  private void setCol(Integer col) {
    this.col = col;
  }

  private void setRow(Integer row) {
    this.row = row;
  }

  private void setSheet(String sheet) {
    this.sheet = sheet;
  }
}
