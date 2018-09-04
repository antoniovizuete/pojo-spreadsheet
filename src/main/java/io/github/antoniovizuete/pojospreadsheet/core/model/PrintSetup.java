package io.github.antoniovizuete.pojospreadsheet.core.model;

import org.apache.poi.ss.usermodel.PaperSize;
import org.apache.poi.ss.usermodel.PrintOrientation;

/**
 * The interface Print setup.
 *
 * @author Antonio Vizuete
 * @since 0.1
 */
public interface PrintSetup {
  /**
   * Gets paper size.
   *
   * @return the paper size
   */
  PaperSize getPaperSize();

  /**
   * Gets orientation.
   *
   * @return the orientation
   */
  PrintOrientation getOrientation();

  /**
   * Gets margin top.
   *
   * @return the margin top
   */
  Double getMarginTop();

  /**
   * Gets margin right.
   *
   * @return the margin right
   */
  Double getMarginRight();

  /**
   * Gets margin bottom.
   *
   * @return the margin bottom
   */
  Double getMarginBottom();

  /**
   * Gets margin left.
   *
   * @return the margin left
   */
  Double getMarginLeft();

  /**
   * Gets margin footer.
   *
   * @return the margin footer
   */
  Double getMarginFooter();

  /**
   * Gets margin header.
   *
   * @return the margin header
   */
  Double getMarginHeader();

  /**
   * Gets print area.
   *
   * @return the print area
   */
  CellRegion getPrintArea();

  /**
   * Sets paper size.
   *
   * @param paperSize the paper size
   */
  void setPaperSize(PaperSize paperSize);

  /**
   * Sets orientation.
   *
   * @param orientation the orientation
   */
  void setOrientation(PrintOrientation orientation);

  /**
   * Sets margin top.
   *
   * @param marginTop the margin top
   */
  void setMarginTop(Double marginTop);

  /**
   * Sets margin right.
   *
   * @param marginRight the margin right
   */
  void setMarginRight(Double marginRight);

  /**
   * Sets margin bottom.
   *
   * @param marginBottom the margin bottom
   */
  void setMarginBottom(Double marginBottom);

  /**
   * Sets margin left.
   *
   * @param marginLeft the margin left
   */
  void setMarginLeft(Double marginLeft);

  /**
   * Sets margin footer.
   *
   * @param marginFooter the margin footer
   */
  void setMarginFooter(Double marginFooter);

  /**
   * Sets margin header.
   *
   * @param marginHeader the margin header
   */
  void setMarginHeader(Double marginHeader);

  /**
   * Sets print area.
   *
   * @param printArea the print area
   */
  void setPrintArea(CellRegion printArea);

  /**
   * Paper size print setup.
   *
   * @param paperSize the paper size
   * @return the print setup
   */
  PrintSetup paperSize(PaperSize paperSize);

  /**
   * Orientation print setup.
   *
   * @param orientation the orientation
   * @return the print setup
   */
  PrintSetup orientation(PrintOrientation orientation);

  /**
   * Margin top print setup.
   *
   * @param marginTop the margin top
   * @return the print setup
   */
  PrintSetup marginTop(Double marginTop);

  /**
   * Margin right print setup.
   *
   * @param marginRight the margin right
   * @return the print setup
   */
  PrintSetup marginRight(Double marginRight);

  /**
   * Margin bottom print setup.
   *
   * @param marginBottom the margin bottom
   * @return the print setup
   */
  PrintSetup marginBottom(Double marginBottom);

  /**
   * Margin left print setup.
   *
   * @param marginLeft the margin left
   * @return the print setup
   */
  PrintSetup marginLeft(Double marginLeft);

  /**
   * Margin footer print setup.
   *
   * @param marginFooter the margin footer
   * @return the print setup
   */
  PrintSetup marginFooter(Double marginFooter);

  /**
   * Margin header print setup.
   *
   * @param marginHeader the margin header
   * @return the print setup
   */
  PrintSetup marginHeader(Double marginHeader);

  /**
   * Print area print setup.
   *
   * @param printArea the print area
   * @return the print setup
   */
  PrintSetup printArea(CellRegion printArea);
}
