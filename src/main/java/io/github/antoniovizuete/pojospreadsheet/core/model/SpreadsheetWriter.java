package io.github.antoniovizuete.pojospreadsheet.core.model;

import io.github.antoniovizuete.pojospreadsheet.core.SpreadsheetDecoration;

public interface SpreadsheetWriter {
  byte[] print(Spreadsheet spreadsheet, SpreadsheetDecoration decoration);
  byte[] write();
}
