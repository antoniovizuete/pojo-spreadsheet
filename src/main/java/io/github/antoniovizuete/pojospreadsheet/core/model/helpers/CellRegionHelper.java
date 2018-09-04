package io.github.antoniovizuete.pojospreadsheet.core.model.helpers;

import io.github.antoniovizuete.pojospreadsheet.core.model.CellAddress;
import io.github.antoniovizuete.pojospreadsheet.core.model.CellRegion;

public final class CellRegionHelper {
  private static final Integer INI_POS = 0;
  private static final Integer END_POS = 1;
  private static final String CELL_SEP = ":";

  private CellRegionHelper() { /* Not-instantiable class. */ }

  public static CellRegion rangeToCellRegion(String range) {
    if(range.indexOf(CELL_SEP) != range.lastIndexOf(CELL_SEP) ){
      throw new IllegalStateException("The range \"" + range + "\" is not valid");
    }

    if (range.contains("!")) {
      range = range.substring(range.indexOf("!"));
    }

    String[] rangeSplit = range.toUpperCase().split(CELL_SEP);

    final CellRegion cellRegion = CellRegion.empty().start(CellAddress.of(rangeSplit[INI_POS])).end(CellAddress.of(rangeSplit[END_POS]));

    sortRows(cellRegion);
    sortColumns(cellRegion);

    return cellRegion;
  }

  private static void sortColumns(CellRegion cellRegion) {
    Integer aux;
    if(cellRegion.getEnd().getCol() != null && cellRegion.getStart().getCol() != null &&
      cellRegion.getEnd().getCol() < cellRegion.getStart().getCol()) {
      aux = cellRegion.getEnd().getCol();
      cellRegion.getEnd().setCol(cellRegion.getStart().getCol());
      cellRegion.getStart().setCol(aux);
    }
  }

  private static void sortRows(CellRegion cellRegion) {
    Integer aux;
    if(cellRegion.getEnd().getRow() != null && cellRegion.getStart().getRow() != null &&
      cellRegion.getEnd().getRow() < cellRegion.getStart().getRow()) {
      aux = cellRegion.getEnd().getRow();
      cellRegion.getEnd().setRow(cellRegion.getStart().getRow());
      cellRegion.getStart().setRow(aux);
    }
  }
}
