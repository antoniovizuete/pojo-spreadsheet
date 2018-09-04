package io.github.antoniovizuete.pojospreadsheet.core.model;

import io.github.antoniovizuete.pojospreadsheet.core.decoration.keys.ColorKey;
import org.apache.poi.ss.usermodel.BorderStyle;

public interface Border {
  Border borderStyle(BorderStyle borderStyle);

  Border color(ColorKey color);

  BorderStyle getBorderStyle();

  void setBorderStyle(BorderStyle borderStyle);

  ColorKey getColor();

  void setColor(ColorKey color);
}
