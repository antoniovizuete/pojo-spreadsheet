package io.github.antoniovizuete.pojospreadsheet.core;

import io.github.antoniovizuete.pojospreadsheet.core.decoration.keys.BorderKey;
import io.github.antoniovizuete.pojospreadsheet.core.decoration.keys.ColorKey;
import io.github.antoniovizuete.pojospreadsheet.core.model.CellRegion;
import io.github.antoniovizuete.pojospreadsheet.core.model.TextBox;
import org.apache.poi.xssf.usermodel.TextAutofit;

/**
 * Prototype class that represents a POI TextBox.
 *
 * @author Antonio Vizuete
 * @since 0.1
 */
public class TextBoxImpl implements TextBox {

  private CellRegion position;
  private String value;
  private BorderKey borderStyle;
  private TextAutofit autofit;
  private ColorKey textColor;

  public TextBoxImpl(CellRegion position, String value) {
    this.position = position;
    this.value = value;
  }

  @Override public CellRegion getPosition() {
    return this.position;
  }

  @Override public String getValue() {
    return this.value;
  }

  @Override public BorderKey getBorderStyle() {
    return this.borderStyle;
  }

  @Override public TextAutofit getAutofit() {
    return this.autofit;
  }

  @Override public ColorKey getTextColor() {
    return this.textColor;
  }

  @Override public void setPosition(CellRegion position) {
    this.position = position;
  }

  @Override public void setValue(String value) {
    this.value = value;
  }

  @Override public void setBorderStyle(BorderKey borderStyle) {
    this.borderStyle = borderStyle;
  }

  @Override public void setAutofit(TextAutofit autofit) {
    this.autofit = autofit;
  }

  @Override public void setTextColor(ColorKey textColor) {
    this.textColor = textColor;
  }

  @Override public TextBox location(CellRegion position) {
    this.position = position;
    return this;
  }

  @Override public TextBox value(String value) {
    this.value = value;
    return this;
  }

  @Override public TextBox borderStyle(BorderKey borderStyle) {
    this.borderStyle = borderStyle;
    return this;
  }

  @Override public TextBox autofit(TextAutofit autofit) {
    this.autofit = autofit;
    return this;
  }

  @Override public TextBox textColor(ColorKey textColor) {
    this.textColor = textColor;
    return this;
  }

  public String toString() {
    return "TextBox(position=" + this.position + ", value=" + this.value + ", borderStyle=" + this.borderStyle
      + ", autofit=" + this.autofit + ", textColor=" + this.textColor + ")";
  }
}
