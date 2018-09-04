package io.github.antoniovizuete.pojospreadsheet.core.model;

import org.apache.poi.ss.usermodel.PaperSize;
import org.apache.poi.ss.usermodel.PrintOrientation;

public interface PrintSetup {
  PaperSize getPaperSize();

  PrintOrientation getOrientation();

  Double getMarginTop();

  Double getMarginRight();

  Double getMarginBottom();

  Double getMarginLeft();

  Double getMarginFooter();

  Double getMarginHeader();

  CellRegion getPrintArea();

  void setPaperSize(PaperSize paperSize);

  void setOrientation(PrintOrientation orientation);

  void setMarginTop(Double marginTop);

  void setMarginRight(Double marginRight);

  void setMarginBottom(Double marginBottom);

  void setMarginLeft(Double marginLeft);

  void setMarginFooter(Double marginFooter);

  void setMarginHeader(Double marginHeader);

  void setPrintArea(CellRegion printArea);

  PrintSetup paperSize(PaperSize paperSize);

  PrintSetup orientation(PrintOrientation orientation);

  PrintSetup marginTop(Double marginTop);

  PrintSetup marginRight(Double marginRight);

  PrintSetup marginBottom(Double marginBottom);

  PrintSetup marginLeft(Double marginLeft);

  PrintSetup marginFooter(Double marginFooter);

  PrintSetup marginHeader(Double marginHeader);

  PrintSetup printArea(CellRegion printArea);
}
