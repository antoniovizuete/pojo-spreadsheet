package io.github.antoniovizuete.pojospreadsheet.core.decoration;

import io.github.antoniovizuete.pojospreadsheet.core.decoration.keys.ColorKey;
import io.github.antoniovizuete.pojospreadsheet.core.model.Font;

import java.util.Objects;

/**
 * Prototype class that represents a POI Font.
 *
 * @author Antonio Vizuete
 * @since 0.1
 */
public class FontImpl implements Font {
  private Boolean bold = false;
  private Underline underline = Underline.NONE;
  private Boolean italic = false;
  private Short height = 11;
  private String fontName = "SansSerif";
  private Offset typeOffset = Offset.NONE;
  private ColorKey color;

  public FontImpl() {
  }

  @Override public Boolean getBold() {
    return this.bold;
  }

  @Override public Underline getUnderline() {
    return this.underline;
  }

  @Override public Boolean getItalic() {
    return this.italic;
  }

  @Override public Short getHeight() {
    return this.height;
  }

  @Override public String getFontName() {
    return this.fontName;
  }

  @Override public Offset getTypeOffset() {
    return this.typeOffset;
  }

  @Override public ColorKey getColor() {
    return this.color;
  }

  @Override public void setBold(Boolean bold) {
    this.bold = bold;
  }

  @Override public void setUnderline(Underline underline) {
    this.underline = underline;
  }

  @Override public void setItalic(Boolean italic) {
    this.italic = italic;
  }

  @Override public void setFontName(String fontName) {
    this.fontName = fontName;
  }

  @Override public void setTypeOffset(Offset typeOffset) {
    this.typeOffset = typeOffset;
  }

  @Override public void setColor(ColorKey color) {
    this.color = color;
  }

  @Override public void setHeight(Integer height) {
    this.height = height.shortValue();
  }

  @Override public Font bold(Boolean bold) {
    this.bold = bold;
    return this;
  }

  @Override public Font underline(Underline underline) {
    this.underline = underline;
    return this;
  }

  @Override public Font italic(Boolean italic) {
    this.italic = italic;
    return this;
  }

  @Override public Font height(Short height) {
    this.height = height;
    return this;
  }

  @Override public Font height(Integer height) {
    this.height = height.shortValue();
    return this;
  }

  @Override public Font fontName(String fontName) {
    this.fontName = fontName;
    return this;
  }

  @Override public Font typeOffset(Offset typeOffset) {
    this.typeOffset = typeOffset;
    return this;
  }

  @Override public Font color(ColorKey color) {
    this.color = color;
    return this;
  }

  @Override public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    FontImpl font = (FontImpl) o;
    return Objects.equals(bold, font.bold) && underline == font.underline && Objects.equals(italic, font.italic)
      && Objects.equals(height, font.height) && Objects.equals(fontName, font.fontName) && typeOffset == font.typeOffset
      && Objects.equals(color, font.color);
  }

  @Override public int hashCode() {
    return Objects.hash(bold, underline, italic, height, fontName, typeOffset, color);
  }


}
