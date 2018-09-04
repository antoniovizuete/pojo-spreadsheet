package io.github.antoniovizuete.pojospreadsheet.core.model;

import io.github.antoniovizuete.pojospreadsheet.utils.reflection.NotMerge;
import io.github.antoniovizuete.pojospreadsheet.core.decoration.keys.BorderKey;
import io.github.antoniovizuete.pojospreadsheet.core.decoration.keys.ColorKey;
import io.github.antoniovizuete.pojospreadsheet.core.decoration.keys.FontKey;
import io.github.antoniovizuete.pojospreadsheet.core.decoration.keys.FormatKey;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;

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

  ColorKey getBackgroundColor();

  FontKey getFont();

  HorizontalAlignment getAlign();

  VerticalAlignment getVerticalAlign();

  FormatKey getFormat();

  BorderKey getBorderTop();

  BorderKey getBorderRight();

  BorderKey getBorderBottom();

  BorderKey getBorderLeft();

  void setInstance(T instance);

  void setBackgroundColor(ColorKey backgroundColor);

  void setFont(FontKey font);

  void setAlign(HorizontalAlignment align);

  void setVerticalAlign(VerticalAlignment verticalAlign);

  void setFormat(FormatKey format);

  void setBorderTop(BorderKey borderTop);

  void setBorderRight(BorderKey borderRight);

  void setBorderBottom(BorderKey borderBottom);

  void setBorderLeft(BorderKey borderLeft);
}
