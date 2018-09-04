package io.github.antoniovizuete.pojospreadsheet.core;

import io.github.antoniovizuete.pojospreadsheet.utils.iterator.AbstractIntegerSet;
import io.github.antoniovizuete.pojospreadsheet.core.image.Image;
import io.github.antoniovizuete.pojospreadsheet.core.image.ImageInputStream;
import io.github.antoniovizuete.pojospreadsheet.core.model.Cell;
import io.github.antoniovizuete.pojospreadsheet.core.model.CellAddress;
import io.github.antoniovizuete.pojospreadsheet.core.model.CellRegion;
import io.github.antoniovizuete.pojospreadsheet.core.model.PrintSetup;
import io.github.antoniovizuete.pojospreadsheet.core.model.Row;
import io.github.antoniovizuete.pojospreadsheet.core.model.Sheet;
import io.github.antoniovizuete.pojospreadsheet.core.model.TextBox;
import io.github.antoniovizuete.pojospreadsheet.core.model.cell.region.CellRegionImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Prototype class that represents a POI Sheet.
 *
 * <p>Has a collection of {@link RowImpl}.</p>
 * <p>Has a collection of {@link Image}.</p>
 * <p>Has a collection of {@link TextBoxImpl}.</p>
 *
 * @author Antonio Vizuete
 * @since 0.1
 */
public class SheetImpl extends AbstractIntegerSet<Row> implements Sheet {

  private Boolean autoSize = true;

  private PrintSetup printSetup = new PrintSetupImpl();

  private Integer index;

  private List<Image> images;

  private List<TextBox> textBoxes;

  private Map<String, CellRegion> mergedCells = new HashMap<>();

  private CellRegion filterRange;

  private String name;

  private String alias;

  public SheetImpl(Integer index) {
    this.index = index;
  }

  public Integer getIndex() {
    return this.index;
  }

  @Override public void setIndex(Integer index) {
    this.index = index;
  }

  @Override public Boolean getAutoSize() {
    return this.autoSize;
  }

  @Override public void setAutoSize(Boolean autoSize) {
    this.autoSize = autoSize;
  }

  @Override public PrintSetup getPrintSetup() {
    return this.printSetup;
  }

  @Override public void setPrintSetup(PrintSetup printSetup) {
    this.printSetup = printSetup;
  }

  @Override public CellRegion getFilterRange() {
    return this.filterRange;
  }

  @Override public void setFilterRange(CellRegion filterRange) {
    this.filterRange = filterRange;
  }

  @Override public String getName() {
    return this.name;
  }

  @Override public void setName(String name) {
    this.name = name;
  }

  @Override public String getAlias() {
    return this.alias;
  }

  @Override public void setAlias(String alias) {
    this.alias = alias;
  }

  @Override public List<Image> getImages() {
    return this.images;
  }

  @Override public void setImages(List<Image> images) {
    this.images = images;
  }

  @Override public List<TextBox> getTextBoxes() {
    return this.textBoxes;
  }

  @Override public void setTextBoxes(List<TextBox> textBoxes) {
    this.textBoxes = textBoxes;
  }

  @Override public Map<String, CellRegion> getMergedCells() {
    return this.mergedCells;
  }

  @Override public void setMergedCells(Map<String, CellRegion> mergedCells) {
    this.mergedCells = mergedCells;
  }


  @Override public Set<Row> rows() {
    return set;
  }

  /**
   * Internal purpose method.
   *
   * <p>Returns a new instance of a {@link RowImpl} placed
   * into indicated row index.</p>
   *
   * @param index where the new {@link RowImpl} will be placed.
   * @return a new instance of {@link RowImpl}.
   */
  @Override public Row createItem(Integer index) {
    return new RowImpl(this, index);
  }

  /**
   * Returns new {@link RowImpl} instance.
   *
   * @return new {@link RowImpl} instance.
   */
  @Override public Row row() {
    return super.add();
  }

  /**
   * Returns the {@link RowImpl} located into indicated index.
   *
   * <p>If not exist the referenced row, the method returns to a
   * new row instance placed there.</p>
   *
   * @param index of row.
   * @return {@link RowImpl}
   */
  @Override public Row row(Integer index) {
    return super.add(index);
  }

  /**
   * Sets the sheet's name.
   *
   * @param name of the sheet.
   * @return the current instance.
   */
  @Override public Sheet name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Sets the sheet's alias.
   *
   * <p><b>NOTE:</b> Method inherited from older versions.</p>
   *
   * @param alias of the sheet.
   * @return the current instance.
   */
  @Override @Deprecated public Sheet alias(String alias) {
    this.alias = alias;
    return this;
  }

  /**
   * Sets auto-size flag.
   *
   * <p>If true (default value) the columns auto-fit to
   * the maximum width.</p>
   *
   * @param autoSize flag
   * @return the current instance.
   */
  @Override public Sheet autoSize(Boolean autoSize) {
    this.autoSize = autoSize;
    return this;
  }

  /**
   * Sets the filter on indicated region.
   *
   * @param region where the filter will be set
   * @return the current instance.
   */
  @Override public Sheet filterRegion(CellRegion region) {
    this.filterRange = region;
    return this;
  }

  /**
   * Adds the passed {@link Image} to the sheet.
   *
   * @param image
   * @return the current instance.
   */
  @Override public Sheet addImage(Image image) {
    if (images == null) {
      images = new ArrayList<>();
    }
    images.add(image);
    return this;
  }

  /**
   * Creates an {@link Image} from the resourcePath and places it at
   * the indicated address.
   *
   * @param address      will be placed the image.
   * @param resourcePath where the image file is located.
   * @return the current instance.
   */
  @Override public Sheet addImage(CellAddress address, String resourcePath) {
    return addImage(new ImageInputStream(resourcePath, address));
  }

  /**
   * Adds the passed {@link TextBoxImpl} to the sheet.
   *
   * @param textBox
   * @return the current instance.
   */
  @Override public Sheet createTextBox(TextBox textBox) {
    if (textBoxes == null) {
      textBoxes = new ArrayList<>();
    }

    textBoxes.add(textBox);
    return this;
  }

  /**
   * Creates an {@link TextBoxImpl} places it into the indicated region
   * and sets its value.
   *
   * @param region  will be placed the TextBox.
   * @param content of TextBox.
   * @return the current instance.
   */
  @Override public Sheet createTextBox(CellRegion region, String content) {
    return createTextBox(new TextBoxImpl(region, content));
  }

  /**
   * Merges the indicated cells.
   *
   * @param rowIndex
   * @param columnIndex
   * @param numCells
   * @return the current instance.
   */
  @Override public Sheet mergeCell(int rowIndex, int columnIndex, int numCells) {
    CellRegion cellRegion = CellRegion.newInstance(columnIndex, rowIndex, columnIndex + --numCells, rowIndex);
    addMergedRegion(cellRegion);
    return this;
  }

  /**
   * Merges the indicated cells.
   *
   * @param row
   * @param cell
   * @param numCells
   * @return the current instance.
   */
  @Override public Sheet mergeCell(RowImpl row, Cell cell, int numCells) {
    CellRegion cellRegion =
      CellRegion.newInstance(cell.getIndex(), row.getIndex(), cell.getIndex() + --numCells, row.getIndex());
    addMergedRegion(cellRegion);
    return this;
  }

  /**
   * Merges the indicated rows.
   *
   * @param rowIndex
   * @param columnIndex
   * @param numCells
   * @return the current instance.
   */
  @Override public Sheet mergeRow(int rowIndex, int columnIndex, int numCells) {
    CellRegion cellRegion = CellRegion.newInstance(columnIndex, rowIndex, columnIndex, rowIndex + --numCells);
    addMergedRegion(cellRegion);
    return this;
  }

  /**
   * Merges the indicated rows.
   *
   * @param row
   * @param cell
   * @param numCells
   * @return the current instance.
   */
  @Override public Sheet mergeRow(RowImpl row, Cell cell, int numCells) {
    CellRegion cellRegion =
      CellRegion.newInstance(cell.getIndex(), row.getIndex(), cell.getIndex(), row.getIndex() + numCells);
    addMergedRegion(cellRegion);
    return this;
  }

  /**
   * Merges the indicated {@link CellRegionImpl}
   *
   * @param region Excel format String.
   * @return the current instance.
   */
  @Override public Sheet mergeRegion(String region) {
    return mergeRegion(CellRegion.of(region));
  }

  /**
   * Merges the indicated {@link CellRegionImpl}
   *
   * @param region
   * @return the current instance.
   */
  @Override public Sheet mergeRegion(CellRegion region) {
    addMergedRegion(region);
    return this;
  }


  private void addMergedRegion(CellRegion cellRegion) {
    mergedCells.put(cellRegion.toString(), cellRegion);
  }

}
