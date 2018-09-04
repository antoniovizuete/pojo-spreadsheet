package io.github.antoniovizuete.pojospreadsheet.core;


import io.github.antoniovizuete.pojospreadsheet.core.model.SpreadsheetWriter;
import io.github.antoniovizuete.pojospreadsheet.utils.iterator.AbstractIntegerSet;
import io.github.antoniovizuete.pojospreadsheet.core.model.Sheet;
import io.github.antoniovizuete.pojospreadsheet.core.model.Spreadsheet;

import java.util.Set;

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
public class AbstractSpreadsheet extends AbstractIntegerSet<Sheet> implements Spreadsheet {

  private SpreadsheetWriter writer;
  private SpreadsheetDecoration decoration = new SpreadsheetDecoration();

  private Boolean fromReader = false;


  protected AbstractSpreadsheet(SpreadsheetWriter writer) {
    this.writer = writer;
  }

  public Set<Sheet> sheets() {
    return set;
  }

  public Sheet createItem(Integer index) {
    return new SheetImpl(index);
  }

  public Boolean isFromReader() {
    return fromReader;
  }

  public void setFromReader(Boolean fromReader) {
    this.fromReader = fromReader;
  }

  public Sheet addSheet() {
    return super.add();
  }

  public Sheet addSheet(Integer index) {
    return super.add(index);
  }

  /**
   * Returns a new {@link SheetImpl} instance.
   *
   * @return a new {@link SheetImpl} instance.
   */
  public Sheet newSheet() {
    return this.addSheet();
  }

  /**
   * Returns the {@link SpreadsheetDecoration} object.
   *
   * @return the {@link SpreadsheetDecoration} object.
   */
  public SpreadsheetDecoration getDecoration() {
    return decoration;
  }

  /**
   * Writes the Excel Workbook.
   *
   * @return the current instance.
   */
  public byte[] write() {
    return writer.print(this, decoration);
  }

  /**
   * Reads the indicated Excel Workbook.
   *
   * <p><b>NOTE:</b> Currently, the Spreadsheet-Reader only reads the content of cells.</p>
   *
   * @param path of the file
   * @return the current instance.
   */
  public static Spreadsheet read(String path) {
    return new Reader().readWorkbook(path);
  }

}
