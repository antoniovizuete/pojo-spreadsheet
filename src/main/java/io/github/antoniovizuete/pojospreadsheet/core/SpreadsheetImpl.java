package io.github.antoniovizuete.pojospreadsheet.core;


import io.github.antoniovizuete.pojospreadsheet.core.model.Spreadsheet;
import io.github.antoniovizuete.pojospreadsheet.core.model.SpreadsheetWriter;

/**
 * The type Spreadsheet.
 *
 * @author Antonio Vizuete
 * @since 0.1
 */
public final class SpreadsheetImpl extends AbstractSpreadsheet implements Spreadsheet {

  SpreadsheetImpl(SpreadsheetWriter writer) {
    super(writer);
  }
}
