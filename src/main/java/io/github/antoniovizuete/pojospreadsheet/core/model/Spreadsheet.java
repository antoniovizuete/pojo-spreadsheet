package io.github.antoniovizuete.pojospreadsheet.core.model;

import io.github.antoniovizuete.pojospreadsheet.core.SpreadsheetDecoration;

import java.util.Set;

/**
 * The interface Spreadsheet.
 *
 * @author Antonio Vizuete
 * @since 0.1
 */
public interface Spreadsheet {
  /**
   * Sheets set.
   *
   * @return the set
   */
  Set<Sheet> sheets();

  /**
   * New sheet sheet.
   *
   * @return the sheet
   */
  Sheet newSheet();

  /**
   * Gets decoration.
   *
   * @return the decoration
   */
  SpreadsheetDecoration getDecoration();

  /**
   * Write byte [ ].
   *
   * @return the byte [ ]
   */
  byte[] write();

}
