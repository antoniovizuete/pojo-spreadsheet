package io.github.antoniovizuete.pojospreadsheet.core;

import io.github.antoniovizuete.pojospreadsheet.core.model.Spreadsheet;
import io.github.antoniovizuete.pojospreadsheet.core.model.SpreadsheetWriter;

import java.io.File;

public class SpreadsheetFactory {

  public static Spreadsheet createFileSpreadsheet(File file) {
    SpreadsheetWriter writer = new SpreadsheetFileWriter(file);
    return new SpreadsheetImpl(writer);
  }

  public static Spreadsheet createFileSpreadsheet(String fileName) {
    SpreadsheetWriter writer = new SpreadsheetFileWriter(new File(fileName));
    return new SpreadsheetImpl(writer);
  }

  public static Spreadsheet createFileSpreadsheet(String path, String file) {
    SpreadsheetWriter writer = new SpreadsheetFileWriter(new File(path + file));
    return new SpreadsheetImpl(writer);
  }

  public static Spreadsheet createOutputStreamSpreadsheet() {
    return new SpreadsheetImpl(new SpreadsheetOutputStreamWriter());
  }

  public static Spreadsheet readFromFile(String path) {
    return SpreadsheetImpl.read(path);
  }
}
