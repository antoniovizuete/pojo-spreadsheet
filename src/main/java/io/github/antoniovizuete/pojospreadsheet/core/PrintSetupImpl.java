package io.github.antoniovizuete.pojospreadsheet.core;

import io.github.antoniovizuete.pojospreadsheet.core.model.CellRegion;
import io.github.antoniovizuete.pojospreadsheet.core.model.PrintSetup;
import org.apache.poi.ss.usermodel.PaperSize;
import org.apache.poi.ss.usermodel.PrintOrientation;

import java.util.Objects;


/**
 * Prototype class that represents the POI Printing set-up.
 *
 * @author Antonio Vizuete
 * @since 0.1
 */
public class PrintSetupImpl implements PrintSetup {

  private PaperSize paperSize = PaperSize.A4_PAPER;
  private PrintOrientation orientation = PrintOrientation.PORTRAIT;

  private Double marginTop;
  private Double marginRight;
  private Double marginBottom;
  private Double marginLeft;
  private Double marginFooter;
  private Double marginHeader;

  private CellRegion printArea;

  public PrintSetupImpl() {
  }

  @Override public PaperSize getPaperSize() {
    return this.paperSize;
  }

  @Override public PrintOrientation getOrientation() {
    return this.orientation;
  }

  @Override public Double getMarginTop() {
    return this.marginTop;
  }

  @Override public Double getMarginRight() {
    return this.marginRight;
  }

  @Override public Double getMarginBottom() {
    return this.marginBottom;
  }

  @Override public Double getMarginLeft() {
    return this.marginLeft;
  }

  @Override public Double getMarginFooter() {
    return this.marginFooter;
  }

  @Override public Double getMarginHeader() {
    return this.marginHeader;
  }

  @Override public CellRegion getPrintArea() {
    return this.printArea;
  }

  @Override public void setPaperSize(PaperSize paperSize) {
    this.paperSize = paperSize;
  }

  @Override public void setOrientation(PrintOrientation orientation) {
    this.orientation = orientation;
  }

  @Override public void setMarginTop(Double marginTop) {
    this.marginTop = marginTop;
  }

  @Override public void setMarginRight(Double marginRight) {
    this.marginRight = marginRight;
  }

  @Override public void setMarginBottom(Double marginBottom) {
    this.marginBottom = marginBottom;
  }

  @Override public void setMarginLeft(Double marginLeft) {
    this.marginLeft = marginLeft;
  }

  @Override public void setMarginFooter(Double marginFooter) {
    this.marginFooter = marginFooter;
  }

  @Override public void setMarginHeader(Double marginHeader) {
    this.marginHeader = marginHeader;
  }

  @Override public void setPrintArea(CellRegion printArea) {
    this.printArea = printArea;
  }

  @Override public PrintSetup paperSize(PaperSize paperSize) {
    this.paperSize = paperSize;
    return this;
  }

  @Override public PrintSetup orientation(PrintOrientation orientation) {
    this.orientation = orientation;
    return this;
  }

  @Override public PrintSetup marginTop(Double marginTop) {
    this.marginTop = marginTop;
    return this;
  }

  @Override public PrintSetup marginRight(Double marginRight) {
    this.marginRight = marginRight;
    return this;
  }

  @Override public PrintSetup marginBottom(Double marginBottom) {
    this.marginBottom = marginBottom;
    return this;
  }

  @Override public PrintSetup marginLeft(Double marginLeft) {
    this.marginLeft = marginLeft;
    return this;
  }

  @Override public PrintSetup marginFooter(Double marginFooter) {
    this.marginFooter = marginFooter;
    return this;
  }

  @Override public PrintSetup marginHeader(Double marginHeader) {
    this.marginHeader = marginHeader;
    return this;
  }

  @Override public PrintSetup printArea(CellRegion printArea) {
    this.printArea = printArea;
    return this;
  }

  @Override public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    PrintSetupImpl that = (PrintSetupImpl) o;
    return paperSize == that.paperSize && orientation == that.orientation && Objects.equals(marginTop, that.marginTop)
      && Objects.equals(marginRight, that.marginRight) && Objects.equals(marginBottom, that.marginBottom) && Objects
      .equals(marginLeft, that.marginLeft) && Objects.equals(marginFooter, that.marginFooter) && Objects
      .equals(marginHeader, that.marginHeader) && Objects.equals(printArea, that.printArea);
  }

  @Override public int hashCode() {

    return Objects
      .hash(paperSize, orientation, marginTop, marginRight, marginBottom, marginLeft, marginFooter, marginHeader,
        printArea);
  }

  public String toString() {
    return "PrintSetup(paperSize=" + this.paperSize + ", orientation=" + this.orientation + ", marginTop="
      + this.marginTop + ", marginRight=" + this.marginRight + ", marginBottom=" + this.marginBottom + ", marginLeft="
      + this.marginLeft + ", marginFooter=" + this.marginFooter + ", marginHeader=" + this.marginHeader + ", printArea="
      + this.printArea + ")";
  }
}
