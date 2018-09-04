package io.github.antoniovizuete.pojospreadsheet.core.model;

import io.github.antoniovizuete.pojospreadsheet.utils.iterator.IntegerIndex;
import io.github.antoniovizuete.pojospreadsheet.core.decoration.keys.CellStyleKey;
import io.github.antoniovizuete.pojospreadsheet.core.model.cell.adress.CellAddressImpl;
import org.apache.poi.ss.usermodel.CellType;

/**
 * The interface Cell.
 *
 * @author Antonio Vizuete
 * @since 0.1
 */
public interface Cell extends Styleable<Cell>,IntegerIndex {
  Integer getIndex();

  /**
   * Gets address.
   *
   * @return the address
   */
  CellAddress getAddress();

  /**
   * Gets type.
   *
   * @return the type
   */
  CellType getType();

  /**
   * Gets cell style.
   *
   * @return the cell style
   */
  CellStyleKey getCellStyle();

  /**
   * Gets value.
   *
   * @return the value
   */
  Object getValue();

  /**
   * Gets hyperlink.
   *
   * @return the hyperlink
   */
  CellAddress getHyperlink();

  /**
   * Sets index.
   *
   * @param index the index
   */
  void setIndex(Integer index);

  /**
   * Sets type.
   *
   * @param type the type
   */
  void setType(CellType type);

  /**
   * Sets cell style.
   *
   * @param cellStyle the cell style
   */
  void setCellStyle(CellStyleKey cellStyle);

  /**
   * Sets value.
   *
   * @param value the value
   */
  void setValue(Object value);

  /**
   * Sets hyperlink.
   *
   * @param hyperlink the hyperlink
   */
  void setHyperlink(CellAddressImpl hyperlink);

  /**
   * Cell style cell.
   *
   * @param cellStyle the cell style
   * @return the cell
   */
  Cell cellStyle(CellStyleKey cellStyle);

  /**
   * Value cell.
   *
   * @param value the value
   * @return the cell
   */
  Cell value(Object value);

  /**
   * Hyperlink cell.
   *
   * @param hyperlink the hyperlink
   * @return the cell
   */
  Cell hyperlink(String hyperlink);

  /**
   * Hyperlink cell.
   *
   * @param hyperlink the hyperlink
   * @return the cell
   */
  Cell hyperlink(CellAddressImpl hyperlink);

  /**
   * Parent row row.
   *
   * @return the row
   */
  Row parentRow();

  /**
   * Parent sheet sheet.
   *
   * @return the sheet
   */
  Sheet parentSheet();

  /**
   * Next cell cell.
   *
   * @return the cell
   */
  Cell nextCell();

  /**
   * Prev cell cell.
   *
   * @return the cell
   */
  Cell prevCell();

  /**
   * Next row row.
   *
   * @return the row
   */
  Row nextRow();

  /**
   * Prev row row.
   *
   * @return the row
   */
  Row prevRow();

  /**
   * Merge cell.
   *
   * @param numCells the num cells
   * @return the cell
   */
  Cell merge(int numCells);
}
