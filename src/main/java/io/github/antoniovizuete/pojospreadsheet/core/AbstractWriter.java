package io.github.antoniovizuete.pojospreadsheet.core;


import io.github.antoniovizuete.pojospreadsheet.core.model.SpreadsheetWriter;
import io.github.antoniovizuete.pojospreadsheet.utils.reflection.ObjectUtils;
import io.github.antoniovizuete.pojospreadsheet.core.converter.ConverterCellDecoration;
import io.github.antoniovizuete.pojospreadsheet.core.image.Image;
import io.github.antoniovizuete.pojospreadsheet.core.model.Cell;
import io.github.antoniovizuete.pojospreadsheet.core.model.Color;
import io.github.antoniovizuete.pojospreadsheet.core.model.PrintSetup;
import io.github.antoniovizuete.pojospreadsheet.core.model.Row;
import io.github.antoniovizuete.pojospreadsheet.core.model.Sheet;
import io.github.antoniovizuete.pojospreadsheet.core.model.Spreadsheet;
import io.github.antoniovizuete.pojospreadsheet.core.model.TextBox;
import org.apache.poi.common.usermodel.HyperlinkType;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.Hyperlink;
import org.apache.poi.ss.usermodel.Picture;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.util.Units;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFTextBox;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * The type Abstract spreadsheet.
 *
 * @author Antonio Vizuete
 * @since 0.1
 */
abstract class AbstractWriter implements SpreadsheetWriter {

  private static final String STANDARD_SHEET_NAME = "Sheet ";
  private static final int FIRST_PARAM = 0;
  private static final Double INCH_FACTOR = 0.039370D;

  protected Spreadsheet spreadsheet;
  protected XSSFWorkbook xssfWorkbook;

  private ConverterCellDecoration decorationConverter;

  private SpreadsheetDecoration decoration;

  private List<Integer> cellIndexesAutosize = new ArrayList<>();

  public byte[] print(Spreadsheet spreadsheet, SpreadsheetDecoration decoration) {
    this.spreadsheet = spreadsheet;
    this.decoration = decoration;
    this.decorationConverter = new ConverterCellDecoration(decoration);
    this.xssfWorkbook = new XSSFWorkbook();

    decorationConverter.convert(xssfWorkbook);
    iterateSheets();
    return write();
  }

  private void iterateSheets() {
    spreadsheet.sheets().forEach(sheet -> {
      cellIndexesAutosize.clear();
      XSSFSheet xssfSheet = createXssfSheet(sheet);

      iterateRows(sheet, xssfSheet);
      doMerge(sheet, xssfSheet);
      doFilter(sheet, xssfSheet);
      printImages(sheet, xssfSheet);
      printTextBoxes(sheet, xssfSheet);
      doAutosize(sheet, xssfSheet);
      doPrintSettings(sheet, xssfSheet);
    });
  }

  private void doPrintSettings(Sheet sheet, XSSFSheet xssfSheet) {
    if (sheet.getPrintSetup() == null) {
      return;
    }

    PrintSetup printSetup = sheet.getPrintSetup();

    xssfSheet.getPrintSetup().setPaperSize(printSetup.getPaperSize());
    xssfSheet.getPrintSetup().setOrientation(printSetup.getOrientation());

    if (printSetup.getMarginTop() != null) {
      xssfSheet.setMargin(org.apache.poi.ss.usermodel.Sheet.TopMargin, printSetup.getMarginTop() * INCH_FACTOR);
    }
    if (printSetup.getMarginRight() != null) {
      xssfSheet.setMargin(org.apache.poi.ss.usermodel.Sheet.RightMargin, printSetup.getMarginRight() * INCH_FACTOR);
    }
    if (printSetup.getMarginBottom() != null) {
      xssfSheet.setMargin(org.apache.poi.ss.usermodel.Sheet.BottomMargin, printSetup.getMarginBottom() * INCH_FACTOR);
    }
    if (printSetup.getMarginLeft() != null) {
      xssfSheet.setMargin(org.apache.poi.ss.usermodel.Sheet.LeftMargin, printSetup.getMarginLeft() * INCH_FACTOR);
    }
    if (printSetup.getMarginHeader() != null) {
      xssfSheet.setMargin(org.apache.poi.ss.usermodel.Sheet.HeaderMargin, printSetup.getMarginHeader() * INCH_FACTOR);
    }
    if (printSetup.getMarginFooter() != null) {
      xssfSheet.setMargin(org.apache.poi.ss.usermodel.Sheet.FooterMargin, printSetup.getMarginFooter() * INCH_FACTOR);
    }

    if (printSetup.getPrintArea() != null) {
      xssfWorkbook.setPrintArea(sheet.getIndex(), printSetup.getPrintArea().getStart().getCol(),
        printSetup.getPrintArea().getEnd().getCol(), printSetup.getPrintArea().getStart().getRow(),
        printSetup.getPrintArea().getEnd().getRow());
    }
  }

  private void doAutosize(Sheet sheet, XSSFSheet xssfSheet) {
    if (sheet.getAutoSize() == null || !sheet.getAutoSize()) {
      return;
    }
    cellIndexesAutosize.sort(Comparator.naturalOrder());
    cellIndexesAutosize.forEach(cellKey -> xssfSheet.autoSizeColumn(cellKey, true));
  }

  private void doFilter(Sheet sheet, XSSFSheet xssfSheet) {
    if (sheet.getFilterRange() == null) {
      return;
    }
    xssfSheet.setAutoFilter(CellRangeAddress.valueOf(sheet.getFilterRange().toString()));
  }

  private void doMerge(Sheet sheet, XSSFSheet xssfSheet) {
    if (sheet.getMergedCells() == null || sheet.getMergedCells().size() == 0) {
      return;
    }
    Set<String> keySet = sheet.getMergedCells().keySet();
    for (String key : keySet) {
      xssfSheet.addMergedRegion(CellRangeAddress.valueOf(sheet.getMergedCells().get(key).toString()));
    }
  }

  private XSSFSheet createXssfSheet(Sheet sheet) {
    String sheetName = sheet.getName();
    if (sheetName == null) {
      sheetName = STANDARD_SHEET_NAME + sheet.getIndex();
    }
    return xssfWorkbook.createSheet(sheetName);
  }

  private void iterateRows(Sheet sheet, XSSFSheet xssfSheet) {
    sheet.rows().forEach(row -> iterateCells(row, createXssfRow(row, xssfSheet)));
  }

  private XSSFRow createXssfRow(Row row, XSSFSheet xssfSheet) {
    return xssfSheet.createRow(row.getIndex() - 1);
  }

  private void iterateCells(Row row, XSSFRow xssfRow) {
    row.cells().forEach(cell -> {
      XSSFCell xssfCell = createXssfCell(cell, xssfRow);
      setCellValue(xssfCell, cell.getValue());
      setXSSFCellStyle(cell, xssfCell);

      if (cell.getHyperlink() != null) {
        Hyperlink hyperlink = xssfWorkbook.getCreationHelper().createHyperlink(HyperlinkType.DOCUMENT);
        hyperlink.setAddress(cell.getHyperlink().toString());
        xssfCell.setHyperlink(hyperlink);
      }

      if (!cellIndexesAutosize.contains(xssfCell.getColumnIndex())) {
        cellIndexesAutosize.add(xssfCell.getColumnIndex());
      }
    });
  }

  private XSSFCell createXssfCell(Cell cell, XSSFRow xssfRow) {
    return xssfRow.createCell(cell.getIndex() - 1);
  }

  private void setCellValue(org.apache.poi.ss.usermodel.Cell cell, Object object) {
    if (object == null) {
      return;
    }
    object = preventNumeric(object);
    List<Method> methods = Stream.of(cell.getClass().getDeclaredMethods()).filter(method -> "setCellValue".equals(method.getName())).collect(Collectors.toList());

    try {
      Class<?> clazz = object.getClass();
      Class<?> type = isNumeric(clazz) ? (Class<?>) clazz.getField("TYPE").get(null) : clazz;

      for (Method method : methods) {
        Class<?> paramType = method.getParameterTypes()[FIRST_PARAM];
        if (paramType.isAssignableFrom(type)) {
          if (paramType.equals(RichTextString.class)) {
            method.invoke(cell, (RichTextString) object);
          } else if (paramType.equals(double.class)) {
            method.invoke(cell, object);
          } else {
            method.invoke(cell, ObjectUtils.getCastedValue(object, type));
          }
          if (clazz.equals(Double.class) || clazz.equals(double.class) || clazz.equals(Date.class) || clazz
            .equals(Calendar.class)) {
            cell.setCellType(CellType.NUMERIC);

          }
        }

      }
    } catch (IllegalAccessException|NoSuchFieldException|InvocationTargetException e) {
      throw new IllegalStateException(e);
    }

  }

  private Object preventNumeric(Object object) {
    if (object == null) {
      return null;
    }
    Class<?> clazz = object.getClass();
    if (clazz.equals(Integer.class) || clazz.equals(int.class)) {
      return (double) (new Integer((Integer) object)).doubleValue();
    } else if (clazz.equals(Short.class) || clazz.equals(short.class)) {
      return (double) (new Short((Short) object)).doubleValue();
    } else if (clazz.equals(Long.class) || clazz.equals(long.class)) {
      return (double) (new Long((Long) object)).doubleValue();
    } else if (clazz.equals(Float.class) || clazz.equals(float.class)) {
      return (double) (new Float((Float) object)).doubleValue();
    } else if (clazz.equals(Double.class)) {
      return (double) new Double((Double) object);
    } else if (clazz.equals(BigDecimal.class)) {
      return (double) ((BigDecimal) object).doubleValue();
    }
    return object;
  }

  private boolean isNumeric(Class<?> clazz) {
    return clazz.equals(Integer.class) || clazz.equals(int.class) || clazz.equals(Short.class) || clazz
      .equals(short.class) || clazz.equals(Long.class) || clazz.equals(long.class) || clazz.equals(Float.class) || clazz
      .equals(float.class) || clazz.equals(Double.class) || clazz.equals(double.class) || clazz
      .equals(BigDecimal.class);
  }

  private void setXSSFCellStyle(Cell cell, XSSFCell xssfCell) {
    XSSFCellStyle xssfCellStyle = decorationConverter.mergeXSSFCellStyle(cell);
    if (xssfCellStyle != null) {
      xssfCell.setCellStyle(xssfCellStyle);
    }

  }


  private void printImages(Sheet sheet, XSSFSheet xssfSheet) {
    if (sheet.getImages() == null) {
      return;
    }
    for (Image image : sheet.getImages()) {
      printImage(xssfSheet, image);
    }
  }

  private void printImage(XSSFSheet xssfSheet, Image image) {
    int imageIndex;
    try {
      imageIndex = xssfWorkbook.addPicture(image.getResource(), image.getType().getPoiValue());
    } catch (IOException e) {
      throw new IllegalArgumentException(e);
    }

    Drawing draw = xssfSheet.createDrawingPatriarch();
    ClientAnchor anchor = xssfWorkbook.getCreationHelper().createClientAnchor();
    anchor.setRow1(image.getCellAddress().getRow() - 1);
    anchor.setCol1(image.getCellAddress().getCol() - 1);

    anchor.setDx1(2 * Units.EMU_PER_PIXEL);
    anchor.setDy1(2 * Units.EMU_PER_PIXEL);

    Picture picture = draw.createPicture(anchor, imageIndex);
    picture.resize();

  }

  private void printTextBoxes(Sheet sheet, XSSFSheet xssfSheet) {
    if (sheet.getTextBoxes() == null) {
      return;
    }

    for (TextBox textBox : sheet.getTextBoxes()) {
      printTextBox(xssfSheet, textBox);
    }
  }

  private void printTextBox(XSSFSheet xssfSheet, TextBox textBox) {
    XSSFDrawing draw = xssfSheet.createDrawingPatriarch();
    ClientAnchor anchor = xssfWorkbook.getCreationHelper().createClientAnchor();
    anchor.setDx1(Units.EMU_PER_PIXEL - 1);
    anchor.setDy1(Units.EMU_PER_PIXEL - 1);
    anchor.setDx2(Units.EMU_PER_PIXEL - 1);
    anchor.setDy2(Units.EMU_PER_PIXEL - 1);
    anchor.setCol1(textBox.getPosition().getStart().getCol() - 1);
    anchor.setRow1(textBox.getPosition().getStart().getRow() - 1);
    anchor.setCol2(textBox.getPosition().getEnd().getCol());
    anchor.setRow2(textBox.getPosition().getEnd().getRow());

    XSSFTextBox tb = draw.createTextbox((XSSFClientAnchor) anchor);

    if (textBox.getBorderStyle() != null) {
      Color color = decoration.get(decoration.get(textBox.getBorderStyle()).getColor());
      tb.setLineStyleColor(color.getRed(), color.getGreen(), color.getBlue());
      tb.setLineStyle(decoration.get(textBox.getBorderStyle()).getBorderStyle().ordinal()-1);
      Double width;
      switch (decoration.get(textBox.getBorderStyle()).getBorderStyle()) {
        case THIN:
        case THICK:
        case HAIR:
          width = 1D;
          break;
        case MEDIUM:
        case MEDIUM_DASH_DOT:
        case MEDIUM_DASHED:
          width = 2D;
          break;
        case DOUBLE:
          width = 3D;
          break;
        default:
          width = 0D;
          break;
      }
      tb.setLineWidth(width);
    }
    if (textBox.getAutofit() != null) {
      tb.setTextAutofit(textBox.getAutofit());
    }
    if (textBox.getTextColor() != null) {
      Color color = decoration.get(textBox.getTextColor());
      tb.setFillColor(color.getRed(), color.getGreen(), color.getBlue());
    }
    tb.setText(textBox.getValue());

  }

}
