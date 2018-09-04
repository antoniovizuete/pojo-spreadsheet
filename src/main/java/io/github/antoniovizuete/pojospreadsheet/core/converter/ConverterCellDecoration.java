package io.github.antoniovizuete.pojospreadsheet.core.converter;

import io.github.antoniovizuete.pojospreadsheet.utils.reflection.ObjectUtils;
import io.github.antoniovizuete.pojospreadsheet.core.CellStyleImpl;
import io.github.antoniovizuete.pojospreadsheet.core.SpreadsheetDecoration;
import io.github.antoniovizuete.pojospreadsheet.core.decoration.defaults.DefaultCellStyle;
import io.github.antoniovizuete.pojospreadsheet.core.decoration.defaults.DefaultFormat;
import io.github.antoniovizuete.pojospreadsheet.core.decoration.keys.CellStyleKey;
import io.github.antoniovizuete.pojospreadsheet.core.decoration.keys.ColorKey;
import io.github.antoniovizuete.pojospreadsheet.core.decoration.keys.FontKey;
import io.github.antoniovizuete.pojospreadsheet.core.model.Cell;
import io.github.antoniovizuete.pojospreadsheet.core.model.CellStyle;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * @author Antonio Vizuete
 * @since 0.1
 */
public class ConverterCellDecoration {
  private XSSFWorkbook xssfWorkbook;

  private SpreadsheetDecoration decoration;

  private ConverterColor colorConverter;

  private ConverterFont fontConverter;

  private ConverterCellStyle cellStyleConverter;

  public ConverterCellDecoration(SpreadsheetDecoration decoration) {
    this.decoration = decoration;
    this.colorConverter = new ConverterColor(decoration);
    this.fontConverter = new ConverterFont(this);
    this.cellStyleConverter = new ConverterCellStyle(this, decoration);
  }

  private Map<ColorKey, XSSFColor> colors = new HashMap<>();
  private Map<FontKey, XSSFFont> fonts = new HashMap<>();
  private Map<CellStyleKey, XSSFCellStyle> cellStyles = new HashMap<>();

  XSSFColor getXSSFColor(ColorKey c) {
    return colors.get(c);
  }

  XSSFFont getXSSFFont(FontKey f) {
    return fonts.get(f);
  }

  private XSSFCellStyle getDefaultXSSFCellStyle() {
    return cellStyles.get(DefaultCellStyle.DEFAULT_CELL_STYLE);
  }

  private XSSFCellStyle getXSSFCellStyle(CellStyleKey s) {
    return cellStyles.get(s);
  }

  public void convert(XSSFWorkbook xssfWorkbook) {
    this.xssfWorkbook = xssfWorkbook;
    convertColors();
    convertFonts();
    convertStyles();
  }

  private void convertColors() {
    Set<ColorKey> colorKeys = decoration.getColors().keySet();
    for (ColorKey colorKey : colorKeys) {
      colors.put(colorKey, colorConverter.getPoiValue(xssfWorkbook, colorKey));
    }
  }

  private void convertFonts() {
    Set<FontKey> fontKeys = decoration.getFonts().keySet();
    for (FontKey fontKey : fontKeys) {
      fonts.put(fontKey, fontConverter.getPoiValue(xssfWorkbook, decoration.getFonts().get(fontKey)));
    }
  }

  private void convertStyles() {
    Set<CellStyleKey> styleKeys = decoration.getCellStyles().keySet();
    for (CellStyleKey styleKey : styleKeys) {
      cellStyles.put(styleKey, cellStyleConverter.getPoiValue(xssfWorkbook, decoration.getCellStyles().get(styleKey)));
    }
  }


  public XSSFCellStyle mergeXSSFCellStyle(Cell cell) {
    if (cell.getCellStyle() == null && ConverterHelper.isSpecificStyleNull(cell)) {
      XSSFCellStyle defaultXSSFCellStyle = getDefaultXSSFCellStyle();
      if (Date.class.equals(cell.getValue().getClass())) {
        CellStyle defStyle = decoration.get(DefaultCellStyle.DEFAULT_CELL_STYLE);
        defStyle.setFormat(DefaultFormat.DD_MM_YYYY);
        defaultXSSFCellStyle = cellStyleConverter.getPoiValue(xssfWorkbook, defStyle);
      }
      return defaultXSSFCellStyle;
    }
    CellStyle mergedStyle = ConverterHelper.cellAsCellStyle(cell);
    CellStyle genericStyle = decoration.get(cell.getCellStyle());

    if (Objects.nonNull(cell.getValue()) && Date.class.equals(cell.getValue().getClass()) && Objects
      .isNull(mergedStyle.getFormat()) && Objects.isNull(genericStyle.getFormat())) {
      mergedStyle.setFormat(DefaultFormat.DD_MM_YYYY);
    }

    if (genericStyle != null) {
      mergedStyle = ObjectUtils.mergeObject(mergedStyle, genericStyle.cloneInstance(), CellStyleImpl.class);
    }

    if (mergedStyle.equals(genericStyle)) {
      return getXSSFCellStyle(cell.getCellStyle());
    }

    return cellStyleConverter.getPoiValue(xssfWorkbook, mergedStyle);
  }


}
