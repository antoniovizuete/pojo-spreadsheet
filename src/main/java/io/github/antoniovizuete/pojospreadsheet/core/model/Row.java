package io.github.antoniovizuete.pojospreadsheet.core.model;

import io.github.antoniovizuete.pojospreadsheet.utils.iterator.IntegerIndex;

import java.util.Set;

public interface Row extends IntegerIndex {
  Set<Cell> cells();

  Sheet parentSheet();

  Row nextRow();

  Row prevRow();

  Row merge(String address, int numCells);

  Row merge(Integer index, int numCells);

  Row merge(Cell cell, int numCells);

  Cell cell();

  Cell cell(Integer index);

  Cell cell(String column);
}
