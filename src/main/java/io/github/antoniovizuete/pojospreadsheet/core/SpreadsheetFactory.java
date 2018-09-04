package io.github.antoniovizuete.pojospreadsheet.core;

import io.github.antoniovizuete.pojospreadsheet.core.model.Spreadsheet;
import io.github.antoniovizuete.pojospreadsheet.core.model.SpreadsheetWriter;

import java.io.File;

/**
 * The interface Spreadsheet factory.
 *
 * @author Antonio Vizuete
 * @since 0.1
 */
public interface SpreadsheetFactory {

  /**
   * Create file spreadsheet spreadsheet.
   *
   * @param file the file
   * @return the spreadsheet
   */
  static Spreadsheet createFileSpreadsheet(File file) {
    SpreadsheetWriter writer = new SpreadsheetFileWriter(file);
    return new SpreadsheetImpl(writer);
  }

  /**
   * Create file spreadsheet spreadsheet.
   *
   * @param fileName the file name
   * @return the spreadsheet
   */
  static Spreadsheet createFileSpreadsheet(String fileName) {
    SpreadsheetWriter writer = new SpreadsheetFileWriter(new File(fileName));
    return new SpreadsheetImpl(writer);
  }

  /**
   * Create file spreadsheet spreadsheet.
   *
   * @param path the path
   * @param file the file
   * @return the spreadsheet
   */
  static Spreadsheet createFileSpreadsheet(String path, String file) {
    SpreadsheetWriter writer = new SpreadsheetFileWriter(new File(path + file));
    return new SpreadsheetImpl(writer);
  }

  /**
   * Create output stream spreadsheet spreadsheet.
   *
   * @return the spreadsheet
   */
  public static Spreadsheet createOutputStreamSpreadsheet() {
    return new SpreadsheetImpl(new SpreadsheetOutputStreamWriter());
  }

  /**
   * Read from file spreadsheet.
   *
   * @param path the path
   * @return the spreadsheet
   */
  static Spreadsheet readFromFile(String path) {
    return SpreadsheetImpl.read(path);
  }
}
