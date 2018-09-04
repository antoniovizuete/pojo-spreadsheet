package io.github.antoniovizuete.pojospreadsheet.core;

import io.github.antoniovizuete.pojospreadsheet.core.model.CellStyle;

/**
 * Prototype class that represents a POI CellStyle.
 *
 * @author Antonio Vizuete
 * @since 0.1
 */
public class CellStyleImpl extends AbstractCellStyle<CellStyle> implements CellStyle {

  public CellStyleImpl() {
    super();
    this.setInstance(this);
  }


  @Override public CellStyle cloneInstance() {
    return new CellStyleImpl().align(this.getAlign()).backgroundColor(this.getBackgroundColor())
      .borderTop(this.getBorderTop()).borderRight(this.getBorderRight()).borderBottom(this.getBorderBottom())
      .borderLeft(this.getBorderLeft()).font(this.getFont()).format(this.getFormat())
      .verticalAlign(this.getVerticalAlign());
  }

  @Override public boolean equals(Object o) {
    return super.equals(o);
  }

  @Override public int hashCode() {
    return super.hashCode();
  }
}
