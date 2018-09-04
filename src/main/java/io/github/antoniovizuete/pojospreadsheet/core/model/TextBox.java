package io.github.antoniovizuete.pojospreadsheet.core.model;

import io.github.antoniovizuete.pojospreadsheet.core.decoration.keys.BorderKey;
import io.github.antoniovizuete.pojospreadsheet.core.decoration.keys.ColorKey;
import org.apache.poi.xssf.usermodel.TextAutofit;

/**
 * The interface Text box.
 *
 * @author Antonio Vizuete
 * @since 0.1
 */
public interface TextBox {
  /**
   * Gets position.
   *
   * @return the position
   */
  CellRegion getPosition();

  /**
   * Gets value.
   *
   * @return the value
   */
  String getValue();

  /**
   * Gets border style.
   *
   * @return the border style
   */
  BorderKey getBorderStyle();

  /**
   * Gets autofit.
   *
   * @return the autofit
   */
  TextAutofit getAutofit();

  /**
   * Gets text color.
   *
   * @return the text color
   */
  ColorKey getTextColor();

  /**
   * Sets position.
   *
   * @param position the position
   */
  void setPosition(CellRegion position);

  /**
   * Sets value.
   *
   * @param value the value
   */
  void setValue(String value);

  /**
   * Sets border style.
   *
   * @param borderStyle the border style
   */
  void setBorderStyle(BorderKey borderStyle);

  /**
   * Sets autofit.
   *
   * @param autofit the autofit
   */
  void setAutofit(TextAutofit autofit);

  /**
   * Sets text color.
   *
   * @param textColor the text color
   */
  void setTextColor(ColorKey textColor);

  /**
   * Location text box.
   *
   * @param position the position
   * @return the text box
   */
  TextBox location(CellRegion position);

  /**
   * Value text box.
   *
   * @param value the value
   * @return the text box
   */
  TextBox value(String value);

  /**
   * Border style text box.
   *
   * @param borderStyle the border style
   * @return the text box
   */
  TextBox borderStyle(BorderKey borderStyle);

  /**
   * Autofit text box.
   *
   * @param autofit the autofit
   * @return the text box
   */
  TextBox autofit(TextAutofit autofit);

  /**
   * Text color text box.
   *
   * @param textColor the text color
   * @return the text box
   */
  TextBox textColor(ColorKey textColor);
}
