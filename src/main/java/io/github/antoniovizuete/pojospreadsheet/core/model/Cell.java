package io.github.antoniovizuete.pojospreadsheet.core.model;

import io.github.antoniovizuete.pojospreadsheet.utils.iterator.IntegerIndex;
import io.github.antoniovizuete.pojospreadsheet.core.decoration.keys.CellStyleKey;
import io.github.antoniovizuete.pojospreadsheet.core.model.cell.adress.CellAddressImpl;
import org.apache.poi.ss.usermodel.CellType;

public interface Cell extends Styleable<Cell>,IntegerIndex {
  Integer getIndex();

  CellAddress getAddress();

  CellType getType();

  CellStyleKey getCellStyle();

  Object getValue();

  CellAddress getHyperlink();

  void setIndex(Integer index);

  void setType(CellType type);

  void setCellStyle(CellStyleKey cellStyle);

  void setValue(Object value);

  void setHyperlink(CellAddressImpl hyperlink);

  Cell cellStyle(CellStyleKey cellStyle);

  Cell value(Object value);

  Cell hyperlink(String hyperlink);

  Cell hyperlink(CellAddressImpl hyperlink);

  Row parentRow();

  Sheet parentSheet();

  Cell nextCell();

  Cell prevCell();

  Row nextRow();

  Row prevRow();

  Cell merge(int numCells);
}
