package io.github.antoniovizuete.pojospreadsheet.core.converter;

import io.github.antoniovizuete.pojospreadsheet.core.SpreadsheetDecoration;
import io.github.antoniovizuete.pojospreadsheet.core.decoration.keys.ColorKey;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author Antonio Vizuete
 * @since 0.1
 */
class ConverterColor implements PoiConverter<XSSFColor, ColorKey> {

  private SpreadsheetDecoration decoration;

  public ConverterColor(SpreadsheetDecoration decoration) {
    this.decoration = decoration;
  }

  public XSSFColor getPoiValue(XSSFWorkbook xssfWorkbook, ColorKey key) {
    return new XSSFColor(decoration.get(key).toAwtColor());
  }
}
