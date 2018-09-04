package io.github.antoniovizuete.pojospreadsheet.core.converter;

import io.github.antoniovizuete.pojospreadsheet.core.SpreadsheetDecoration;
import io.github.antoniovizuete.pojospreadsheet.core.decoration.defaults.DefaultFont;
import io.github.antoniovizuete.pojospreadsheet.core.model.Border;
import io.github.antoniovizuete.pojospreadsheet.core.model.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * ConverterCellStyle.
 *
 * @author Antonio Vizuete
 * @since 0.1
 */

class ConverterCellStyle implements PoiConverter<XSSFCellStyle, CellStyle> {

  private ConverterCellDecoration decorConverter;

  private SpreadsheetDecoration decoration;

  public ConverterCellStyle(ConverterCellDecoration decorConverter, SpreadsheetDecoration decoration) {
    this.decorConverter = decorConverter;
    this.decoration = decoration;
  }

  public XSSFCellStyle getPoiValue(XSSFWorkbook xssfWorkbook, CellStyle cellStyle) {
    XSSFCellStyle xssfCellStyle = xssfWorkbook.createCellStyle();
    if (cellStyle.getBackgroundColor() != null) {
      xssfCellStyle.setFillForegroundColor(decorConverter.getXSSFColor(cellStyle.getBackgroundColor()));
      //TODO: Añadir propiedad a CellStyle
      xssfCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
    }
    if (cellStyle.getFont() != null) {
      xssfCellStyle.setFont(decorConverter.getXSSFFont(cellStyle.getFont()));
    } else {
      xssfCellStyle.setFont(decorConverter.getXSSFFont(DefaultFont.DEFAULT_FONT));
    }

    if (cellStyle.getAlign() != null) {
      xssfCellStyle.setAlignment(cellStyle.getAlign());
    }

    if (cellStyle.getVerticalAlign() != null) {
      xssfCellStyle.setVerticalAlignment(cellStyle.getVerticalAlign());
    }

    if (cellStyle.getBorderTop() != null) {
      Border border = decoration.get(cellStyle.getBorderTop());
      xssfCellStyle.setBorderTop(border.getBorderStyle());
      if (border.getColor() != null) {
        xssfCellStyle.setTopBorderColor(decorConverter.getXSSFColor(border.getColor()));
      }
    }

    if (cellStyle.getBorderRight() != null) {
      Border border = decoration.get(cellStyle.getBorderRight());
      xssfCellStyle.setBorderRight(border.getBorderStyle());
      if (border.getColor() != null) {
        xssfCellStyle.setRightBorderColor(decorConverter.getXSSFColor(border.getColor()));
      }
    }

    if (cellStyle.getBorderBottom() != null) {
      Border border = decoration.get(cellStyle.getBorderBottom());
      xssfCellStyle.setBorderBottom(border.getBorderStyle());
      if (border.getColor() != null) {
        xssfCellStyle.setBottomBorderColor(decorConverter.getXSSFColor(border.getColor()));
      }
    }

    if (cellStyle.getBorderLeft() != null) {
      Border border = decoration.get(cellStyle.getBorderLeft());
      xssfCellStyle.setBorderLeft(border.getBorderStyle());
      if (border.getColor() != null) {
        xssfCellStyle.setLeftBorderColor(decorConverter.getXSSFColor(border.getColor()));
      }
    }

    if (cellStyle.getFormat() != null) {
      int iFormat =
        xssfWorkbook.getCreationHelper().createDataFormat().getFormat(decoration.get(cellStyle.getFormat()).getValue());
      xssfCellStyle.setDataFormat(iFormat);
    }

    return xssfCellStyle;
  }


}
