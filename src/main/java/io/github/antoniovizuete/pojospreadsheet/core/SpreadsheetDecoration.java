package io.github.antoniovizuete.pojospreadsheet.core;

import io.github.antoniovizuete.pojospreadsheet.core.decoration.FontImpl;
import io.github.antoniovizuete.pojospreadsheet.core.decoration.FormatImpl;
import io.github.antoniovizuete.pojospreadsheet.core.decoration.defaults.DefaultCellStyle;
import io.github.antoniovizuete.pojospreadsheet.core.decoration.defaults.DefaultFont;
import io.github.antoniovizuete.pojospreadsheet.core.decoration.defaults.DefaultFormat;
import io.github.antoniovizuete.pojospreadsheet.core.decoration.keys.BorderKey;
import io.github.antoniovizuete.pojospreadsheet.core.decoration.keys.CellStyleKey;
import io.github.antoniovizuete.pojospreadsheet.core.decoration.keys.ColorKey;
import io.github.antoniovizuete.pojospreadsheet.core.decoration.keys.FontKey;
import io.github.antoniovizuete.pojospreadsheet.core.decoration.keys.FormatKey;
import io.github.antoniovizuete.pojospreadsheet.core.model.Border;
import io.github.antoniovizuete.pojospreadsheet.core.model.CellStyle;
import io.github.antoniovizuete.pojospreadsheet.core.model.Color;
import io.github.antoniovizuete.pojospreadsheet.core.model.Font;
import io.github.antoniovizuete.pojospreadsheet.core.model.Format;

import java.util.HashMap;
import java.util.Map;

/**
 * The type SpreadsheetDecoration.
 *
 * @author Antonio Vizuete
 * @since 0.1
 */
public final class SpreadsheetDecoration {

  private Map<ColorKey, Color> colors;

  private Map<FontKey, Font> fonts;

  private Map<CellStyleKey, CellStyle> cellStyles;

  private Map<FormatKey, Format> formats;

  private Map<BorderKey, Border> borders;

  public SpreadsheetDecoration() {
    colors = configureColors();
    fonts = configureFonts();
    cellStyles = configureStyles();
    formats = configureFormats();
    borders = configureBorders();
  }

  public Color get(ColorKey k) {
    return colors.get(k);
  }

  public Font get(FontKey k) {
    return fonts.get(k);
  }

  public Format get(FormatKey k) {
    return formats.get(k);
  }

  public Border get(BorderKey k) {
    return borders.get(k);
  }

  public CellStyle get(CellStyleKey k) {
    return cellStyles.get(k);
  }

  public boolean exists(ColorKey c) {
    return colors.containsKey(c);
  }

  public boolean exists(FontKey f) {
    return fonts.containsKey(f);
  }

  public boolean exists(FormatKey f) {
    return formats.containsKey(f);
  }

  public boolean exists(BorderKey b) {
    return borders.containsKey(b);
  }

  public boolean exists(CellStyleKey s) {
    return cellStyles.containsKey(s);
  }

  public void add(ColorKey c, Color color) {
    colors.put(c, color);
  }

  public void add(FontKey f, Font font) {
    fonts.put(f, font);
  }

  public void add(FormatKey f, Format format) {
    formats.put(f, format);
  }

  public void add(BorderKey b, Border border) {
    borders.put(b, border);
  }

  public void add(CellStyleKey s, CellStyle cellStyle) {
    cellStyles.put(s, cellStyle);
  }

  public void remove(ColorKey c) {
    colors.remove(c);
  }

  public void remove(FontKey f) {
    fonts.remove(f);
  }

  public void remove(FormatKey f) {
    formats.remove(f);
  }

  public void remove(BorderKey b) {
    borders.remove(b);
  }

  public void remove(CellStyleKey s) {
    cellStyles.remove(s);
  }

  public Map<ColorKey, Color> getColors() {
    return this.colors;
  }

  public Map<FontKey, Font> getFonts() {
    return this.fonts;
  }

  public Map<CellStyleKey, CellStyle> getCellStyles() {
    return this.cellStyles;
  }

  public Map<FormatKey, Format> getFormats() {
    return this.formats;
  }

  public Map<BorderKey, Border> getBorders() {
    return this.borders;
  }

  private Map<ColorKey, Color> configureColors() {
    return new HashMap<>();
  }

  private Map<FontKey, Font> configureFonts() {
    Map<FontKey, Font> map = new HashMap<>();
    map.put(DefaultFont.DEFAULT_FONT, new FontImpl());
    return map;

  }

  private Map<CellStyleKey, CellStyle> configureStyles() {
    Map<CellStyleKey, CellStyle> map = new HashMap<>();
    map.put(DefaultCellStyle.DEFAULT_CELL_STYLE, new CellStyleImpl().font(DefaultFont.DEFAULT_FONT));
    return map;
  }

  private Map<FormatKey, Format> configureFormats() {
    Map<FormatKey, Format> map = new HashMap<>();
    map.put(DefaultFormat.DD_MM_YYYY, new FormatImpl("dd/MM/yyyy"));
    return map;
  }

  private Map<BorderKey, Border> configureBorders() { return new HashMap<>(); }
}
