package io.github.antoniovizuete.pojospreadsheet.core.model;

import io.github.antoniovizuete.pojospreadsheet.core.SpreadsheetDecoration;

import java.io.OutputStream;

/**
 * The interface Spreadsheet writer.
 *
 * @author Antonio Vizuete
 * @since 0.1
 */
public interface SpreadsheetWriter<T extends OutputStream> {


  /**
   * Write byte [ ].
   *
   * @return the byte [ ]
   *
   * @deprecated To be deleted at version 1.0
   * @see SpreadsheetWriter#performWrite()
   */
  @Deprecated
  byte[] write();

  /**
   * Writes the Spreadsheet and returns the OutputStream.
   * @return the OutputStream
   */
  <T extends OutputStream> T performWrite();
}
