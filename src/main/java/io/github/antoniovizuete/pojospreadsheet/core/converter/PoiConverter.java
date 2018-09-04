package io.github.antoniovizuete.pojospreadsheet.core.converter;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * The interface PoiConverter.
 *
 * @param <T> the target type parameter
 * @param <K> the key type parameter
 *
 * @author Antonio Vizuete
 * @since 0.1
 */
public interface PoiConverter<T, K> {

  /**
   * Gets poi value.
   *
   * @param xssfWorkbook the xssf workbook
   * @param k            the key
   * @return the poi value
   */
  T getPoiValue(XSSFWorkbook xssfWorkbook, K k);
}
