package io.github.antoniovizuete.pojospreadsheet.core.model;

import io.github.antoniovizuete.pojospreadsheet.core.model.cell.region.CellRegionBuilder;

public interface CellRegion {
  static CellRegion empty() { return CellRegionBuilder.builderInstance().build(); }
  static CellRegion newInstance(Integer startCol, Integer startRow, Integer endCol, Integer endRow) {
    return CellRegionBuilder.builderInstance()
              .start(CellAddress.newInstance(startCol, startRow))
              .end(CellAddress.newInstance(endCol, endRow))
      .build();
  }

  static CellRegion of(String range) {
      return CellRegionBuilder.builderInstance().range(range).build();
  }

  CellRegion start(CellAddress start);

  CellRegion end(CellAddress end);

  CellAddress getStart();

  CellAddress getEnd();

  void setStart(CellAddress start);

  void setEnd(CellAddress end);
}
