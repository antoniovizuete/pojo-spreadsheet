package io.github.antoniovizuete.pojospreadsheet.core.converter;

import io.github.antoniovizuete.pojospreadsheet.core.model.Font;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Antonio Vizuete
 * @since 0.1
 */
class ConverterFont implements PoiConverter<XSSFFont, Font> {

    private ConverterCellDecoration decorConverter;

    public ConverterFont(ConverterCellDecoration decorConverter) {
        this.decorConverter = decorConverter;
    }

    public XSSFFont getPoiValue(XSSFWorkbook xssfWorkbook, Font font){
        XSSFFont xssfFont = xssfWorkbook.createFont();
        xssfFont.setFontName(font.getFontName());
        if(font.getColor() != null){
            xssfFont.setColor(decorConverter.getXSSFColor(font.getColor()));
        }
        if(font.getHeight() != null){
            xssfFont.setFontHeightInPoints(font.getHeight());
        }
        if(font.getTypeOffset() != null ){
            xssfFont.setTypeOffset(font.getTypeOffset().getPoiValue());
        }

        if(font.getBold() != null){
            xssfFont.setBold(font.getBold());
            if(font.getBold()) {
                xssfFont.setBold(true);
            }
        }

        if(font.getUnderline() != null){
            xssfFont.setUnderline(font.getUnderline().getPoiValue());
        }

        if(font.getItalic() != null){
            xssfFont.setItalic(font.getItalic());
        }

        return xssfFont;
    }
}
