package io.github.antoniovizuete.pojospreadsheet.core.model.cell.adress;

import io.github.antoniovizuete.pojospreadsheet.core.model.helpers.CellAddressHelper;
import io.github.antoniovizuete.pojospreadsheet.core.model.CellAddress;

import java.util.Optional;

public final class CellAddressBuilder {
  private Integer col;

  private Integer row;

  private String sheet;


  private CellAddressBuilder() { /* Private default constructor */ }

  public static CellAddressBuilder builderInstance() {
    return new CellAddressBuilder();
  }

  public CellAddress build() {
    final CellAddress cellAddress = new CellAddressImpl();
    cellAddress.setSheet(sheet);
    cellAddress.setCol(col);
    cellAddress.setRow(row);
    return cellAddress;
  }

  public CellAddressBuilder address(String address) {
    Optional.ofNullable(CellAddressHelper.extractSheetName(address)).ifPresent(this::setSheet);
    this.setCol(CellAddressHelper.extractColumn(address));
    this.setRow(CellAddressHelper.extractRow(address));
    return this;
  }

  public CellAddressBuilder col(Integer col) {
    this.setCol(col);
    return this;
  }

  public CellAddressBuilder row(Integer row) {
    this.setRow(row);
    return this;
  }

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
