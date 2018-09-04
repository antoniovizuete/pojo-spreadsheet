package io.github.antoniovizuete.pojospreadsheet.core.model;

import io.github.antoniovizuete.pojospreadsheet.utils.iterator.IntegerIndex;
import io.github.antoniovizuete.pojospreadsheet.core.RowImpl;
import io.github.antoniovizuete.pojospreadsheet.core.image.Image;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface Sheet extends IntegerIndex {
  void setIndex(Integer index);

  Boolean getAutoSize();

  void setAutoSize(Boolean autoSize);

  PrintSetup getPrintSetup();

  void setPrintSetup(PrintSetup printSetup);

  CellRegion getFilterRange();

  void setFilterRange(CellRegion filterRange);

  String getName();

  void setName(String name);

  String getAlias();

  void setAlias(String alias);

  List<Image> getImages();

  void setImages(List<Image> images);

  List<TextBox> getTextBoxes();

  void setTextBoxes(List<TextBox> textBoxes);

  Map<String, CellRegion> getMergedCells();

  void setMergedCells(Map<String, CellRegion> mergedCells);

  Set<Row> rows();

  Row createItem(Integer index);

  Row row();

  Row row(Integer index);

  Sheet name(String name);

  @Deprecated Sheet alias(String alias);

  Sheet autoSize(Boolean autoSize);

  Sheet filterRegion(CellRegion region);

  Sheet addImage(Image image);

  Sheet addImage(CellAddress address, String resourcePath);

  Sheet createTextBox(TextBox textBox);

  Sheet createTextBox(CellRegion region, String content);

  Sheet mergeCell(int rowIndex, int columnIndex, int numCells);

  Sheet mergeCell(RowImpl row, Cell cell, int numCells);

  Sheet mergeRow(int rowIndex, int columnIndex, int numCells);

  Sheet mergeRow(RowImpl row, Cell cell, int numCells);

  Sheet mergeRegion(String region);

  Sheet mergeRegion(CellRegion region);
}
