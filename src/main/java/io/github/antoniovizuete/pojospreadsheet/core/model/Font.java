package io.github.antoniovizuete.pojospreadsheet.core.model;

import io.github.antoniovizuete.pojospreadsheet.core.converter.PoiValue;
import io.github.antoniovizuete.pojospreadsheet.core.decoration.keys.ColorKey;

public interface Font {
  Boolean getBold();

  Underline getUnderline();

  Boolean getItalic();

  Short getHeight();

  String getFontName();

  Offset getTypeOffset();

  ColorKey getColor();

  void setBold(Boolean bold);

  void setUnderline(Underline underline);

  void setItalic(Boolean italic);

  void setFontName(String fontName);

  void setTypeOffset(Offset typeOffset);

  void setColor(ColorKey color);

  void setHeight(Integer height);

  Font bold(Boolean bold);

  Font underline(Underline underline);

  Font italic(Boolean italic);

  Font height(Short height);

  Font height(Integer height);

  Font fontName(String fontName);

  Font typeOffset(Offset typeOffset);

  Font color(ColorKey color);

  public enum BoldWeight implements PoiValue<Short> {
    NORMAL((short) 0x190), BOLD((short) 0x2bc);
    short value;

    BoldWeight(short value) {
      this.value = value;
    }

    public Short getPoiValue() {
      return this.value;
    }
  }


  public enum Offset implements PoiValue<Short> {
    NONE, SUPER, SUB;

    public Short getPoiValue() {
      return (short) this.ordinal();
    }
  }


  public enum Underline implements PoiValue<Byte> {
    NONE, SINGLE, DOUBLE;

    public Byte getPoiValue() {
      return (byte) this.ordinal();
    }
  }
}
