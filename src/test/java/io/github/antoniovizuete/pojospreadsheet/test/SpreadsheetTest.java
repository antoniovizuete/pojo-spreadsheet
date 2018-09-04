package io.github.antoniovizuete.pojospreadsheet.test;

import io.github.antoniovizuete.pojospreadsheet.core.SpreadsheetFactory;
import io.github.antoniovizuete.pojospreadsheet.core.model.Row;
import io.github.antoniovizuete.pojospreadsheet.core.model.Sheet;
import io.github.antoniovizuete.pojospreadsheet.core.model.Spreadsheet;
import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

public class SpreadsheetTest {

  private static final String FILENAME = "test.xlsx";

  @Test
  public void spreadsheetTest() {
    // Arrange
    Spreadsheet spreadsheet = SpreadsheetFactory.createFileSpreadsheet(FILENAME);
    spreadsheet.newSheet().name("Hoja 1").row().cell().value("1C1R").nextCell().value("2C1R")
      .nextRow().cell().value("1C2R").nextCell().value("2C2R");

    // Act
    spreadsheet.write();
    Spreadsheet spreadsheetRead = SpreadsheetFactory.readFromFile(FILENAME);

    // Arrange
    Assert.assertEquals("Not expected sheet count", spreadsheet.sheets().size(), spreadsheetRead.sheets().size());
    spreadsheet.sheets().forEach(originalSheet -> {
      Optional<Sheet> sheetRead = spreadsheetRead.sheets().stream().filter(s -> originalSheet.getName().equals(s.getName())).findFirst();
      Assert.assertTrue("No sheet found", sheetRead.isPresent());
      Assert.assertEquals("Not expected row count", originalSheet.rows().size(), sheetRead.get().rows().size());
      originalSheet.rows().forEach(originalRow ->{
        Optional<Row> rowRead = sheetRead.get().rows().stream().filter(r -> originalRow.getIndex().equals(r.getIndex())).findFirst();
        Assert.assertTrue("No row found", rowRead.isPresent());
        Assert.assertEquals("Not expected row count", originalRow.cells().size(), rowRead.get().cells().size());
      });
    });
  }

}
