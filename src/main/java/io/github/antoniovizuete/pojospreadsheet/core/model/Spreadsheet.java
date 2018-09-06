package io.github.antoniovizuete.pojospreadsheet.core.model;

import io.github.antoniovizuete.pojospreadsheet.core.SpreadsheetDecoration;

import java.io.OutputStream;
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
   *
   * @deprecated To be deleted at version 1.0
   * @see Spreadsheet#performWrite()
   */
  @Deprecated
  byte[] write();

  /**
   * Converts the {@link Spreadsheet} to POI Workbook and writes it.
   *
   * @return the generic type instance
   */
  OutputStream performWrite();

}
