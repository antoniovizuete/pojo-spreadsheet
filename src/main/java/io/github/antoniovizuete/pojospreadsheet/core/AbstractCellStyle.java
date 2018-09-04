package io.github.antoniovizuete.pojospreadsheet.core;


import io.github.antoniovizuete.pojospreadsheet.utils.reflection.NotMerge;
import io.github.antoniovizuete.pojospreadsheet.core.decoration.keys.BorderKey;
import io.github.antoniovizuete.pojospreadsheet.core.decoration.keys.ColorKey;
import io.github.antoniovizuete.pojospreadsheet.core.decoration.keys.FontKey;
import io.github.antoniovizuete.pojospreadsheet.core.decoration.keys.FormatKey;
import io.github.antoniovizuete.pojospreadsheet.core.model.Styleable;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;

/**
 * Abstraction of cell style.
 *
 * @param <T> the type parameter
 * @author Antonio Vizuete
 * @since 0.1
 */
abstract class AbstractCellStyle<T extends Styleable> implements Styleable<T> {

  /** The Instance. */
  private T instance;

  /** The Background color. */
  private ColorKey backgroundColor;

  /** The Font. */
  private FontKey font;

  /** The Align. */
  private HorizontalAlignment align;

  /** The Vertical align. */
  private VerticalAlignment verticalAlign;

  /** The Format. */
  private FormatKey format;

  /** The Border top. */
  private BorderKey borderTop;

  /** The Border right. */
  private BorderKey borderRight;

  /** The Border bottom. */
  private BorderKey borderBottom;

  /** The Border left. */
  private BorderKey borderLeft;

  @Override public T backgroundColor(ColorKey color) {
    this.backgroundColor = color;
    return instance;
  }

  @Override public T font(FontKey font) {
    this.font = font;
    return instance;
  }

  @Override public T align(HorizontalAlignment align) {
    this.align = align;
    return instance;
  }

  @Override public T verticalAlign(VerticalAlignment verticalAlign) {
    this.verticalAlign = verticalAlign;
    return instance;
  }

  @Override public T format(FormatKey format) {
    this.format = format;
    return instance;
  }

  @Override public T borderTop(BorderKey borderTop) {
    this.borderTop = borderTop;
    return instance;
  }

  @Override public T borderRight(BorderKey borderRight) {
    this.borderRight = borderRight;
    return instance;
  }

  @Override public T borderBottom(BorderKey borderBottom) {
    this.borderBottom = borderBottom;
    return instance;
  }

  @Override public T borderLeft(BorderKey borderLeft) {
    this.borderLeft = borderLeft;
    return instance;
  }

  @Override @NotMerge
  public T borders(BorderKey border) {
    this.borderTop = border;
    this.borderRight = border;
    this.borderBottom = border;
    this.borderLeft = border;
    return instance;
  }

  @Override public T borders(BorderKey border, BorderKey border2) {
    this.borderTop = border;
    this.borderRight = border2;
    this.borderBottom = border;
    this.borderLeft = border2;
    return instance;
  }

  @Override public T borders(BorderKey border, BorderKey border2, BorderKey border3) {
    this.borderTop = border;
    this.borderRight = border2;
    this.borderBottom = border3;
    this.borderLeft = border2;
    return instance;
  }

  @Override public T borders(BorderKey border, BorderKey border2, BorderKey border3, BorderKey border4) {
    this.borderTop = border;
    this.borderRight = border2;
    this.borderBottom = border3;
    this.borderLeft = border4;
    return instance;
  }


  @Override public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;

    AbstractCellStyle<?> that = (AbstractCellStyle<?>) o;

    if (backgroundColor != null ? !backgroundColor.equals(that.backgroundColor) : that.backgroundColor != null)
      return false;
    if (font != null ? !font.equals(that.font) : that.font != null)
      return false;
    if (align != that.align)
      return false;
    if (verticalAlign != that.verticalAlign)
      return false;
    if (format != null ? !format.equals(that.format) : that.format != null)
      return false;
    if (borderTop != null ? !borderTop.equals(that.borderTop) : that.borderTop != null)
      return false;
    if (borderRight != null ? !borderRight.equals(that.borderRight) : that.borderRight != null)
      return false;
    if (borderBottom != null ? !borderBottom.equals(that.borderBottom) : that.borderBottom != null)
      return false;
    return borderLeft != null ? borderLeft.equals(that.borderLeft) : that.borderLeft == null;

  }

  @Override public int hashCode() {
    int result = instance.hashCode();
    result = 31 * result + (backgroundColor != null ? backgroundColor.hashCode() : 0);
    result = 31 * result + (font != null ? font.hashCode() : 0);
    result = 31 * result + (align != null ? align.hashCode() : 0);
    result = 31 * result + (verticalAlign != null ? verticalAlign.hashCode() : 0);
    result = 31 * result + (format != null ? format.hashCode() : 0);
    result = 31 * result + (borderTop != null ? borderTop.hashCode() : 0);
    result = 31 * result + (borderRight != null ? borderRight.hashCode() : 0);
    result = 31 * result + (borderBottom != null ? borderBottom.hashCode() : 0);
    result = 31 * result + (borderLeft != null ? borderLeft.hashCode() : 0);
    return result;
  }

  @Override public ColorKey getBackgroundColor() {
    return this.backgroundColor;
  }

  @Override public FontKey getFont() {
    return this.font;
  }

  @Override public HorizontalAlignment getAlign() {
    return this.align;
  }

  @Override public VerticalAlignment getVerticalAlign() {
    return this.verticalAlign;
  }

  @Override public FormatKey getFormat() {
    return this.format;
  }

  @Override public BorderKey getBorderTop() {
    return this.borderTop;
  }

  @Override public BorderKey getBorderRight() {
    return this.borderRight;
  }

  @Override public BorderKey getBorderBottom() {
    return this.borderBottom;
  }

  @Override public BorderKey getBorderLeft() {
    return this.borderLeft;
  }

  @Override public void setInstance(T instance) {
    this.instance = instance;
  }

  @Override public void setBackgroundColor(ColorKey backgroundColor) {
    this.backgroundColor = backgroundColor;
  }

  @Override public void setFont(FontKey font) {
    this.font = font;
  }

  @Override public void setAlign(HorizontalAlignment align) {
    this.align = align;
  }

  @Override public void setVerticalAlign(VerticalAlignment verticalAlign) {
    this.verticalAlign = verticalAlign;
  }

  @Override public void setFormat(FormatKey format) {
    this.format = format;
  }

  @Override public void setBorderTop(BorderKey borderTop) {
    this.borderTop = borderTop;
  }

  @Override public void setBorderRight(BorderKey borderRight) {
    this.borderRight = borderRight;
  }

  @Override public void setBorderBottom(BorderKey borderBottom) {
    this.borderBottom = borderBottom;
  }

  @Override public void setBorderLeft(BorderKey borderLeft) {
    this.borderLeft = borderLeft;
  }
}
