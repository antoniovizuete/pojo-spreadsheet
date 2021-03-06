package io.github.antoniovizuete.pojospreadsheet.core.model;

import io.github.antoniovizuete.pojospreadsheet.utils.reflection.NotMerge;
import io.github.antoniovizuete.pojospreadsheet.core.decoration.keys.BorderKey;
import io.github.antoniovizuete.pojospreadsheet.core.decoration.keys.ColorKey;
import io.github.antoniovizuete.pojospreadsheet.core.decoration.keys.FontKey;
import io.github.antoniovizuete.pojospreadsheet.core.decoration.keys.FormatKey;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;

/**
 * The interface Styleable.
 *
 * @param <T> the type parameter
 * @author Antonio Vizuete
 * @since 0.1
 */
public interface Styleable<T> {
  /**
   * Sets the background color and return the current instance.
   *
   * @param color the color
   * @return the instance
   */
  T backgroundColor(ColorKey color);

  /**
   * Sets the font and return the current instance.
   *
   * @param font the font
   * @return the instance
   */
  T font(FontKey font);

  /**
   * Sets the align and return the current instance.
   *
   * @param align the align
   * @return the instance
   */
  T align(HorizontalAlignment align);

  /**
   * Sets the vertical align and return the current instance.
   *
   * @param verticalAlign the vertical align
   * @return the instance
   */
  T verticalAlign(VerticalAlignment verticalAlign);

  /**
   * Sets the format and return the current instance.
   *
   * @param format the format
   * @return the instance
   */
  T format(FormatKey format);

  /**
   * Sets the border top and return the current instance.
   *
   * @param borderTop the border top
   * @return the instance
   */
  T borderTop(BorderKey borderTop);

  /**
   * Sets the border right and return the current instance.
   *
   * @param borderRight the border right
   * @return the instance
   */
  T borderRight(BorderKey borderRight);

  /**
   * Sets the border bottom and return the current instance.
   *
   * @param borderBottom the border bottom
   * @return the instance
   */
  T borderBottom(BorderKey borderBottom);

  /**
   * Sets the border left and return the current instance.
   *
   * @param borderLeft the border left
   * @return the instance
   */
  T borderLeft(BorderKey borderLeft);

  /**
   * Sets the borders and return the current instance.
   *
   * @param border the border
   * @return the instance
   */
  @NotMerge T borders(BorderKey border);

  /**
   * Sets the borders and return the current instance.
   *
   * @param border  the border
   * @param border2 the border 2
   * @return the instance
   */
  T borders(BorderKey border, BorderKey border2);

  /**
   * Sets the borders and return the current instance.
   *
   * @param border  the border
   * @param border2 the border 2
   * @param border3 the border 3
   * @return the instance
   */
  T borders(BorderKey border, BorderKey border2, BorderKey border3);

  /**
   * Sets the borders and return the current instance.
   *
   * @param border  the border
   * @param border2 the border 2
   * @param border3 the border 3
   * @param border4 the border 4
   * @return the instance
   */
  T borders(BorderKey border, BorderKey border2, BorderKey border3, BorderKey border4);

  /**
   * Gets background color.
   *
   * @return the background color
   */
  ColorKey getBackgroundColor();

  /**
   * Gets font.
   *
   * @return the font
   */
  FontKey getFont();

  /**
   * Gets align.
   *
   * @return the align
   */
  HorizontalAlignment getAlign();

  /**
   * Gets vertical align.
   *
   * @return the vertical align
   */
  VerticalAlignment getVerticalAlign();

  /**
   * Gets format.
   *
   * @return the format
   */
  FormatKey getFormat();

  /**
   * Gets border top.
   *
   * @return the border top
   */
  BorderKey getBorderTop();

  /**
   * Gets border right.
   *
   * @return the border right
   */
  BorderKey getBorderRight();

  /**
   * Gets border bottom.
   *
   * @return the border bottom
   */
  BorderKey getBorderBottom();

  /**
   * Gets border left.
   *
   * @return the border left
   */
  BorderKey getBorderLeft();

  /**
   * Sets instance.
   *
   * @param instance the instance
   */
  void setInstance(T instance);

  /**
   * Sets background color.
   *
   * @param backgroundColor the background color
   */
  void setBackgroundColor(ColorKey backgroundColor);

  /**
   * Sets font.
   *
   * @param font the font
   */
  void setFont(FontKey font);

  /**
   * Sets align.
   *
   * @param align the align
   */
  void setAlign(HorizontalAlignment align);

  /**
   * Sets vertical align.
   *
   * @param verticalAlign the vertical align
   */
  void setVerticalAlign(VerticalAlignment verticalAlign);

  /**
   * Sets format.
   *
   * @param format the format
   */
  void setFormat(FormatKey format);

  /**
   * Sets border top.
   *
   * @param borderTop the border top
   */
  void setBorderTop(BorderKey borderTop);

  /**
   * Sets border right.
   *
   * @param borderRight the border right
   */
  void setBorderRight(BorderKey borderRight);

  /**
   * Sets border bottom.
   *
   * @param borderBottom the border bottom
   */
  void setBorderBottom(BorderKey borderBottom);

  /**
   * Sets border left.
   *
   * @param borderLeft the border left
   */
  void setBorderLeft(BorderKey borderLeft);
}
