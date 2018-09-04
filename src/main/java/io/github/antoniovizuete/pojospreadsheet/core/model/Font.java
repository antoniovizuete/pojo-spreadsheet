package io.github.antoniovizuete.pojospreadsheet.core.model;

import io.github.antoniovizuete.pojospreadsheet.core.converter.PoiValue;
import io.github.antoniovizuete.pojospreadsheet.core.decoration.keys.ColorKey;

/**
 * The interface Font.
 *
 * @author Antonio Vizuete
 * @since 0.1
 */
public interface Font {
  /**
   * Gets bold.
   *
   * @return the bold
   */
  Boolean getBold();

  /**
   * Gets underline.
   *
   * @return the underline
   */
  Underline getUnderline();

  /**
   * Gets italic.
   *
   * @return the italic
   */
  Boolean getItalic();

  /**
   * Gets height.
   *
   * @return the height
   */
  Short getHeight();

  /**
   * Gets font name.
   *
   * @return the font name
   */
  String getFontName();

  /**
   * Gets type offset.
   *
   * @return the type offset
   */
  Offset getTypeOffset();

  /**
   * Gets color.
   *
   * @return the color
   */
  ColorKey getColor();

  /**
   * Sets bold.
   *
   * @param bold the bold
   */
  void setBold(Boolean bold);

  /**
   * Sets underline.
   *
   * @param underline the underline
   */
  void setUnderline(Underline underline);

  /**
   * Sets italic.
   *
   * @param italic the italic
   */
  void setItalic(Boolean italic);

  /**
   * Sets font name.
   *
   * @param fontName the font name
   */
  void setFontName(String fontName);

  /**
   * Sets type offset.
   *
   * @param typeOffset the type offset
   */
  void setTypeOffset(Offset typeOffset);

  /**
   * Sets color.
   *
   * @param color the color
   */
  void setColor(ColorKey color);

  /**
   * Sets height.
   *
   * @param height the height
   */
  void setHeight(Integer height);

  /**
   * Bold font.
   *
   * @param bold the bold
   * @return the font
   */
  Font bold(Boolean bold);

  /**
   * Underline font.
   *
   * @param underline the underline
   * @return the font
   */
  Font underline(Underline underline);

  /**
   * Italic font.
   *
   * @param italic the italic
   * @return the font
   */
  Font italic(Boolean italic);

  /**
   * Height font.
   *
   * @param height the height
   * @return the font
   */
  Font height(Short height);

  /**
   * Height font.
   *
   * @param height the height
   * @return the font
   */
  Font height(Integer height);

  /**
   * Font name font.
   *
   * @param fontName the font name
   * @return the font
   */
  Font fontName(String fontName);

  /**
   * Type offset font.
   *
   * @param typeOffset the type offset
   * @return the font
   */
  Font typeOffset(Offset typeOffset);

  /**
   * Color font.
   *
   * @param color the color
   * @return the font
   */
  Font color(ColorKey color);

  /**
   * The enum Bold weight.
   */
  public enum BoldWeight implements PoiValue<Short> {
    /**
     * Normal bold weight.
     */
    NORMAL((short) 0x190), /**
     * Bold bold weight.
     */
    BOLD((short) 0x2bc);
    /**
     * The Value.
     */
    short value;

    BoldWeight(short value) {
      this.value = value;
    }

    public Short getPoiValue() {
      return this.value;
    }
  }


  /**
   * The enum Offset.
   */
  public enum Offset implements PoiValue<Short> {
    /**
     * None offset.
     */
    NONE, /**
     * Super offset.
     */
    SUPER, /**
     * Sub offset.
     */
    SUB;

    public Short getPoiValue() {
      return (short) this.ordinal();
    }
  }


  /**
   * The enum Underline.
   */
  public enum Underline implements PoiValue<Byte> {
    /**
     * None underline.
     */
    NONE, /**
     * Single underline.
     */
    SINGLE, /**
     * Double underline.
     */
    DOUBLE;

    public Byte getPoiValue() {
      return (byte) this.ordinal();
    }
  }
}
