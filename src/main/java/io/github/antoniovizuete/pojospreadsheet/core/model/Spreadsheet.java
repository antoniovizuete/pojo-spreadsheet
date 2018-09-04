package io.github.antoniovizuete.pojospreadsheet.core.model;

import io.github.antoniovizuete.pojospreadsheet.core.SpreadsheetDecoration;

import java.util.Set;

public interface Spreadsheet {
  Set<Sheet> sheets();

  Sheet newSheet();

  SpreadsheetDecoration getDecoration();

  byte[] write();

}
