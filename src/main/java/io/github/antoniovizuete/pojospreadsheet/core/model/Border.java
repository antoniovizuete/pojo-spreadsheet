package io.github.antoniovizuete.pojospreadsheet.core.model;

import io.github.antoniovizuete.pojospreadsheet.core.decoration.keys.ColorKey;
import org.apache.poi.ss.usermodel.BorderStyle;

/**
 * The interface Border.
 *
 * @author Antonio Vizuete
 * @since 0.1
 */
public interface Border {
  /**
   * Border style border.
   *
   * @param borderStyle the border style
   * @return the border
   */
  Border borderStyle(BorderStyle borderStyle);

  /**
   * Color border.
   *
   * @param color the color
   * @return the border
   */
  Border color(ColorKey color);

  /**
   * Gets border style.
   *
   * @return the border style
   */
  BorderStyle getBorderStyle();

  /**
   * Sets border style.
   *
   * @param borderStyle the border style
   */
  void setBorderStyle(BorderStyle borderStyle);

  /**
   * Gets color.
   *
   * @return the color
   */
  ColorKey getColor();

  /**
   * Sets color.
   *
   * @param color the color
   */
  void setColor(ColorKey color);
}
