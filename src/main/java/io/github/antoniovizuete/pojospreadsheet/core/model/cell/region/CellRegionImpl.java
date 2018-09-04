package io.github.antoniovizuete.pojospreadsheet.core.model.cell.region;

import io.github.antoniovizuete.pojospreadsheet.core.model.CellRegion;
import io.github.antoniovizuete.pojospreadsheet.core.model.CellAddress;

import java.util.Objects;

/**
 * Class that represents a region of cells into a parentSheet.
 *
 * @author Antonio Vizuete
 * @since 0.1
 */
public final class CellRegionImpl implements CellRegion {
  private CellAddress start;
  private CellAddress end;

  /**
   * Instantiates a new Cell region.
   */
  CellRegionImpl() { /* Default constructor*/}

  @Override public CellRegion start(CellAddress start) {
    this.start = start;
    return this;
  }

  @Override public CellRegionImpl end(CellAddress end) {
    this.end = end;
    return this;
  }

  @Override public String toString() {
    return start.toString() + ':' + end.toString();
  }

  @Override public CellAddress getStart() {
    return this.start;
  }

  @Override public CellAddress getEnd() {
    return this.end;
  }

  @Override public void setStart(CellAddress start) {
    this.start = start;
  }

  @Override public void setEnd(CellAddress end) {
    this.end = end;
  }

  @Override public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    CellRegionImpl that = (CellRegionImpl) o;
    return Objects.equals(start, that.start) && Objects.equals(end, that.end);
  }

  @Override public int hashCode() {
    return Objects.hash(start, end);
  }
}
