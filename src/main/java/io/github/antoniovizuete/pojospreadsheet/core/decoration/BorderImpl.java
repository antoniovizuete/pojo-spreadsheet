package io.github.antoniovizuete.pojospreadsheet.core.decoration;


import io.github.antoniovizuete.pojospreadsheet.core.decoration.keys.ColorKey;
import io.github.antoniovizuete.pojospreadsheet.core.model.Border;
import org.apache.poi.ss.usermodel.BorderStyle;

/**
 * Prototype class that represents a POI Border.
 *
 * @author Antonio Vizuete
 * @since 0.1
 */
public class BorderImpl implements Border {

  private BorderStyle borderStyle;
  private ColorKey color;

  public BorderImpl() { /* Default constructor. */ }

  public BorderImpl(BorderStyle borderStyle, ColorKey color) {
    this.borderStyle = borderStyle;
    this.color = color;
  }

  @Override public Border borderStyle(BorderStyle borderStyle) {
    this.borderStyle = borderStyle;
    return this;
  }

  @Override public Border color(ColorKey color) {
    this.color = color;
    return this;
  }

  @Override public BorderStyle getBorderStyle() {
    return this.borderStyle;
  }

  @Override public void setBorderStyle(BorderStyle borderStyle) {
    this.borderStyle = borderStyle;
  }

  @Override public ColorKey getColor() {
    return this.color;
  }

  @Override public void setColor(ColorKey color) {
    this.color = color;
  }
}
