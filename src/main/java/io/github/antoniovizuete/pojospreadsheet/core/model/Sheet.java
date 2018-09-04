package io.github.antoniovizuete.pojospreadsheet.core.model;

import io.github.antoniovizuete.pojospreadsheet.utils.iterator.IntegerIndex;
import io.github.antoniovizuete.pojospreadsheet.core.RowImpl;
import io.github.antoniovizuete.pojospreadsheet.core.image.Image;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The interface Sheet.
 *
 * @author Antonio Vizuete
 * @since 0.1
 */
public interface Sheet extends IntegerIndex {
  /**
   * Sets index.
   *
   * @param index the index
   */
  void setIndex(Integer index);

  /**
   * Gets auto size.
   *
   * @return the auto size
   */
  Boolean getAutoSize();

  /**
   * Sets auto size.
   *
   * @param autoSize the auto size
   */
  void setAutoSize(Boolean autoSize);

  /**
   * Gets print setup.
   *
   * @return the print setup
   */
  PrintSetup getPrintSetup();

  /**
   * Sets print setup.
   *
   * @param printSetup the print setup
   */
  void setPrintSetup(PrintSetup printSetup);

  /**
   * Gets filter range.
   *
   * @return the filter range
   */
  CellRegion getFilterRange();

  /**
   * Sets filter range.
   *
   * @param filterRange the filter range
   */
  void setFilterRange(CellRegion filterRange);

  /**
   * Gets name.
   *
   * @return the name
   */
  String getName();

  /**
   * Sets name.
   *
   * @param name the name
   */
  void setName(String name);

  /**
   * Gets alias.
   *
   * @return the alias
   */
  String getAlias();

  /**
   * Sets alias.
   *
   * @param alias the alias
   */
  void setAlias(String alias);

  /**
   * Gets images.
   *
   * @return the images
   */
  List<Image> getImages();

  /**
   * Sets images.
   *
   * @param images the images
   */
  void setImages(List<Image> images);

  /**
   * Gets text boxes.
   *
   * @return the text boxes
   */
  List<TextBox> getTextBoxes();

  /**
   * Sets text boxes.
   *
   * @param textBoxes the text boxes
   */
  void setTextBoxes(List<TextBox> textBoxes);

  /**
   * Gets merged cells.
   *
   * @return the merged cells
   */
  Map<String, CellRegion> getMergedCells();

  /**
   * Sets merged cells.
   *
   * @param mergedCells the merged cells
   */
  void setMergedCells(Map<String, CellRegion> mergedCells);

  /**
   * Rows set.
   *
   * @return the set
   */
  Set<Row> rows();

  /**
   * Create item row.
   *
   * @param index the index
   * @return the row
   */
  Row createItem(Integer index);

  /**
   * Row row.
   *
   * @return the row
   */
  Row row();

  /**
   * Row row.
   *
   * @param index the index
   * @return the row
   */
  Row row(Integer index);

  /**
   * Name sheet.
   *
   * @param name the name
   * @return the sheet
   */
  Sheet name(String name);

  /**
   * Alias sheet.
   *
   * @param alias the alias
   * @return the sheet
   */
  @Deprecated Sheet alias(String alias);

  /**
   * Auto size sheet.
   *
   * @param autoSize the auto size
   * @return the sheet
   */
  Sheet autoSize(Boolean autoSize);

  /**
   * Filter region sheet.
   *
   * @param region the region
   * @return the sheet
   */
  Sheet filterRegion(CellRegion region);

  /**
   * Add image sheet.
   *
   * @param image the image
   * @return the sheet
   */
  Sheet addImage(Image image);

  /**
   * Add image sheet.
   *
   * @param address      the address
   * @param resourcePath the resource path
   * @return the sheet
   */
  Sheet addImage(CellAddress address, String resourcePath);

  /**
   * Create text box sheet.
   *
   * @param textBox the text box
   * @return the sheet
   */
  Sheet createTextBox(TextBox textBox);

  /**
   * Create text box sheet.
   *
   * @param region  the region
   * @param content the content
   * @return the sheet
   */
  Sheet createTextBox(CellRegion region, String content);

  /**
   * Merge cell sheet.
   *
   * @param rowIndex    the row index
   * @param columnIndex the column index
   * @param numCells    the num cells
   * @return the sheet
   */
  Sheet mergeCell(int rowIndex, int columnIndex, int numCells);

  /**
   * Merge cell sheet.
   *
   * @param row      the row
   * @param cell     the cell
   * @param numCells the num cells
   * @return the sheet
   */
  Sheet mergeCell(RowImpl row, Cell cell, int numCells);

  /**
   * Merge row sheet.
   *
   * @param rowIndex    the row index
   * @param columnIndex the column index
   * @param numCells    the num cells
   * @return the sheet
   */
  Sheet mergeRow(int rowIndex, int columnIndex, int numCells);

  /**
   * Merge row sheet.
   *
   * @param row      the row
   * @param cell     the cell
   * @param numCells the num cells
   * @return the sheet
   */
  Sheet mergeRow(RowImpl row, Cell cell, int numCells);

  /**
   * Merge region sheet.
   *
   * @param region the region
   * @return the sheet
   */
  Sheet mergeRegion(String region);

  /**
   * Merge region sheet.
   *
   * @param region the region
   * @return the sheet
   */
  Sheet mergeRegion(CellRegion region);
}
