package io.github.antoniovizuete.pojospreadsheet.core.model;

import io.github.antoniovizuete.pojospreadsheet.core.model.cell.adress.CellAddressBuilder;

public interface CellAddress {
  static CellAddress newInstance(int col, int row) {
    return CellAddressBuilder.builderInstance().col(col).row(row).build();
  }

  static CellAddress empty() {
      return CellAddressBuilder.builderInstance().build();
  }

  static CellAddress of(String address) {
      return CellAddressBuilder.builderInstance().address(address).build();
  }

  CellAddress col(Integer col);

  CellAddress col(String col);

  CellAddress row(Integer row);

  CellAddress sheet(String sheet);

  Integer getCol();

  Integer getRow();

  String getSheet();

  void setCol(Integer col);

  void setRow(Integer row);

  void setSheet(String sheet);
}
