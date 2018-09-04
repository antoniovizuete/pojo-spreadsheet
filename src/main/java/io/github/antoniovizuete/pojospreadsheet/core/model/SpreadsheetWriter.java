package io.github.antoniovizuete.pojospreadsheet.core.model;

import io.github.antoniovizuete.pojospreadsheet.core.SpreadsheetDecoration;

/**
 * The interface Spreadsheet writer.
 *
 * @author Antonio Vizuete
 * @since 0.1
 */
public interface SpreadsheetWriter {
  /**
   * Print byte [ ].
   *
   * @param spreadsheet the spreadsheet
   * @param decoration  the decoration
   * @return the byte [ ]
   */
  byte[] print(Spreadsheet spreadsheet, SpreadsheetDecoration decoration);

  /**
   * Write byte [ ].
   *
   * @return the byte [ ]
   */
  byte[] write();
}
