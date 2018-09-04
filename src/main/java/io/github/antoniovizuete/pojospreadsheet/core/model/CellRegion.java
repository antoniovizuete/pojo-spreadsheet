package io.github.antoniovizuete.pojospreadsheet.core.model;

import io.github.antoniovizuete.pojospreadsheet.core.model.cell.region.CellRegionBuilder;

/**
 * The interface Cell region.
 *
 * @author Antonio Vizuete
 * @since 0.1
 */
public interface CellRegion {
  /**
   * Empty cell region.
   *
   * @return the cell region
   */
  static CellRegion empty() {
    return CellRegionBuilder.builderInstance().build();
  }

  /**
   * New instance cell region.
   *
   * @param startCol the start col
   * @param startRow the start row
   * @param endCol   the end col
   * @param endRow   the end row
   * @return the cell region
   */
  static CellRegion newInstance(Integer startCol, Integer startRow, Integer endCol, Integer endRow) {
    return CellRegionBuilder.builderInstance().start(CellAddress.newInstance(startCol, startRow))
      .end(CellAddress.newInstance(endCol, endRow)).build();
  }

  /**
   * Of cell region.
   *
   * @param range the range
   * @return the cell region
   */
  static CellRegion of(String range) {
    return CellRegionBuilder.builderInstance().range(range).build();
  }

  /**
   * Start cell region.
   *
   * @param start the start
   * @return the cell region
   */
  CellRegion start(CellAddress start);

  /**
   * End cell region.
   *
   * @param end the end
   * @return the cell region
   */
  CellRegion end(CellAddress end);

  /**
   * Gets start.
   *
   * @return the start
   */
  CellAddress getStart();

  /**
   * Gets end.
   *
   * @return the end
   */
  CellAddress getEnd();

  /**
   * Sets start.
   *
   * @param start the start
   */
  void setStart(CellAddress start);

  /**
   * Sets end.
   *
   * @param end the end
   */
  void setEnd(CellAddress end);
}
