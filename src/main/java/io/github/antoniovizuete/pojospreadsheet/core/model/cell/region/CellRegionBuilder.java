package io.github.antoniovizuete.pojospreadsheet.core.model.cell.region;

import io.github.antoniovizuete.pojospreadsheet.core.model.CellRegion;
import io.github.antoniovizuete.pojospreadsheet.core.model.CellAddress;
import io.github.antoniovizuete.pojospreadsheet.core.model.helpers.CellRegionHelper;

/**
 * Class that represents a region of cells into a parentSheet.
 *
 * @author Antonio Vizuete
 * @since 0.1
 */

public final class CellRegionBuilder {
  private CellAddress start;
  private CellAddress end;

  private CellRegionBuilder() { /* Private default constructor */ }

  public static CellRegionBuilder builderInstance() {
    return new CellRegionBuilder();
  }

  public CellRegion build() {
    final CellRegion cellRegion = new CellRegionImpl();
    cellRegion.setStart(start);
    cellRegion.setEnd(end);
    return cellRegion;
  }

  public CellRegionBuilder range(String range) {
    CellRegion cellRegion = CellRegionHelper.rangeToCellRegion(range);
    this.setStart(cellRegion.getStart());
    this.setEnd(cellRegion.getEnd());
    return this;
  }

  public CellRegionBuilder start(CellAddress start) {
    this.setStart(start);
    return this;
  }

  public CellRegionBuilder end(CellAddress end) {
    this.setEnd(end);
    return this;
  }

  private void setStart(CellAddress start) {
    this.start = start;
  }

  private void setEnd(CellAddress end) {
    this.end = end;
  }
}
