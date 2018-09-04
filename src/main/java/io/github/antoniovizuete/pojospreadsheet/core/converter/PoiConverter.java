package io.github.antoniovizuete.pojospreadsheet.core.converter;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Created by avizuete on 31/05/2017.
 */
public interface PoiConverter<T, K> {
    T getPoiValue(XSSFWorkbook xssfWorkbook, K k);
}
