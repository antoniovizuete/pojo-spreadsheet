package io.github.antoniovizuete.pojospreadsheet.core;


import io.github.antoniovizuete.pojospreadsheet.core.model.SpreadsheetWriter;
import io.github.antoniovizuete.pojospreadsheet.utils.iterator.AbstractIntegerSet;
import io.github.antoniovizuete.pojospreadsheet.core.model.Sheet;
import io.github.antoniovizuete.pojospreadsheet.core.model.Spreadsheet;

import java.util.Set;


/**
 * The type Abstract spreadsheet.
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

  /**
   * Is from reader boolean.
   *
   * @return the boolean
   */
  public Boolean isFromReader() {
    return fromReader;
  }

  /**
   * Sets from reader.
   *
   * @param fromReader the from reader
   */
  public void setFromReader(Boolean fromReader) {
    this.fromReader = fromReader;
  }

  /**
   * Add sheet sheet.
   *
   * @return the sheet
   */
  public Sheet addSheet() {
    return super.add();
  }

  /**
   * Add sheet sheet.
   *
   * @param index the index
   * @return the sheet
   */
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
