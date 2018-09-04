package io.github.antoniovizuete.pojospreadsheet.core.model;

import io.github.antoniovizuete.pojospreadsheet.core.decoration.keys.BorderKey;
import io.github.antoniovizuete.pojospreadsheet.core.decoration.keys.ColorKey;
import org.apache.poi.xssf.usermodel.TextAutofit;

public interface TextBox {
  CellRegion getPosition();

  String getValue();

  BorderKey getBorderStyle();

  TextAutofit getAutofit();

  ColorKey getTextColor();

  void setPosition(CellRegion position);

  void setValue(String value);

  void setBorderStyle(BorderKey borderStyle);

  void setAutofit(TextAutofit autofit);

  void setTextColor(ColorKey textColor);

  TextBox location(CellRegion position);

  TextBox value(String value);

  TextBox borderStyle(BorderKey borderStyle);

  TextBox autofit(TextAutofit autofit);

  TextBox textColor(ColorKey textColor);
}
