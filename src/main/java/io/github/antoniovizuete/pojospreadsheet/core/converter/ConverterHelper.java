package io.github.antoniovizuete.pojospreadsheet.core.converter;

import io.github.antoniovizuete.pojospreadsheet.core.model.Cell;
import io.github.antoniovizuete.pojospreadsheet.core.model.CellStyle;
import io.github.antoniovizuete.pojospreadsheet.core.CellStyleImpl;

/**
 * Helper to convert cells.
 *
 * @author Antonio Vizuete
 * @since 0.1
 */
public interface ConverterHelper {

  /**
   * Checks if all {@link CellStyle} properties of a {@link Cell} are null
   *
   * @param cell the cell to be checked
   * @return true, if all are not null, else false
   */
  static boolean isSpecificStyleNull(Cell cell) {
    return cell.getAlign() == null && cell.getBackgroundColor() == null && cell.getBorderBottom() == null
      && cell.getBorderLeft() == null && cell.getBorderRight() == null && cell.getBorderTop() == null
      && cell.getFormat() == null && cell.getFont() == null;
  }

  /**
   * Converts a {@link Cell} into {@link CellStyle}
   * @param cell the cell to be converted
   * @return the cell style
   */
  static CellStyle cellAsCellStyle(Cell cell) {
    CellStyle c = new CellStyleImpl();
    c.backgroundColor(cell.getBackgroundColor()).font(cell.getFont()).align(cell.getAlign())
      .verticalAlign(cell.getVerticalAlign()).format(cell.getFormat()).borderTop(cell.getBorderTop())
      .borderRight(cell.getBorderRight()).borderBottom(cell.getBorderBottom()).borderLeft(cell.getBorderLeft());
    return c;
  }
}
