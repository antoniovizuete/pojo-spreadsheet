package io.github.antoniovizuete.pojospreadsheet.core;

import io.github.antoniovizuete.pojospreadsheet.core.model.Row;
import io.github.antoniovizuete.pojospreadsheet.core.model.Sheet;
import io.github.antoniovizuete.pojospreadsheet.core.model.Spreadsheet;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author Antonio Vizuete
 * @since 0.1
 */
class Reader {

  public Spreadsheet readWorkbook(String path) {
    final File file = new File(path);
    if(!file.exists()) {
      throw new IllegalStateException( "File \"" + path + "\" doesn't exist.");
    }

    final Spreadsheet spreadsheet = SpreadsheetFactory.createFileSpreadsheet(file.getAbsolutePath(), file.getName());
    try (
      FileInputStream fis = new FileInputStream(file);
      org.apache.poi.ss.usermodel.Workbook workbook = WorkbookFactory.create(fis)
    ) {
      workbook.sheetIterator().forEachRemaining(poiSheet -> {
        final Sheet sheet = spreadsheet.newSheet().name(poiSheet.getSheetName());
        poiSheet.iterator().forEachRemaining(poiRow -> {
          final Row row = sheet.row(poiRow.getRowNum() + 1);
          poiRow.iterator().forEachRemaining(poiCell -> {
            Object value = getProperValue(poiCell);
            row.cell(poiCell.getColumnIndex() + 1).value(value);
          });
        });
      });

      ((AbstractSpreadsheet)spreadsheet).setFromReader(true);
    } catch (IOException|EncryptedDocumentException|InvalidFormatException e) {
      throw new IllegalStateException(e);
    }
    return spreadsheet;
  }

  private Object getProperValue(Cell poiCell) {
    Object value;
    switch (poiCell.getCellTypeEnum()) {
      case STRING:
        value = poiCell.getStringCellValue();
        break;
      case NUMERIC:
        value = getDateOrNumeric(poiCell);
        break;
      case FORMULA:
        value = getFormulaValue(poiCell);
        break;
      default:
        value = null;
        break;
    }
    return value;
  }


  private Object getFormulaValue(org.apache.poi.ss.usermodel.Cell cell) {
    Object value = null;
    switch (cell.getCachedFormulaResultTypeEnum()) {
      case NUMERIC:
        value = getDateOrNumeric(cell);
        break;
      case STRING:
        value = cell.getStringCellValue();
        break;
      default:

        break;
    }
    return value;
  }


  private Object getDateOrNumeric(org.apache.poi.ss.usermodel.Cell cell) {
    Object value;
    if (DateUtil.isCellDateFormatted(cell)) {
      value = DateUtil.getJavaDate(cell.getNumericCellValue());
    } else {
      value = cell.getNumericCellValue();
    }
    return value;
  }
}
