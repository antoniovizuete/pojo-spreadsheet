package io.github.antoniovizuete.pojospreadsheet.core;


import io.github.antoniovizuete.pojospreadsheet.core.model.Spreadsheet;
import io.github.antoniovizuete.pojospreadsheet.core.model.SpreadsheetWriter;

/**
 * This class is the main EXA-Spreadsheet class. It must be instantiated
 * through "SpreadsheetBuilder#getBuilder()".
 *
 * <p>EXA-Spreadsheet wraps Apache POI 3.14 up. In order to make more
 * simply the develops related with POI.</p>
 *
 * @author Antonio Vizuete
 * @since 0.1
 */
public final class SpreadsheetImpl extends AbstractSpreadsheet implements Spreadsheet {

  SpreadsheetImpl(SpreadsheetWriter writer) {
    super(writer);
  }
}
