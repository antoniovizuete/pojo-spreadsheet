package io.github.antoniovizuete.pojospreadsheet.core.model.cell.adress;

import io.github.antoniovizuete.pojospreadsheet.core.model.helpers.CellAddressHelper;
import io.github.antoniovizuete.pojospreadsheet.core.model.CellAddress;

/**
 * Class that represents the address of a cell.
 *
 * @author  Antonio Vizuete
 * @since   0.1
 */
public final class CellAddressImpl implements CellAddress {

    /** The cell's column. */
    private Integer col;

    /** The cell's row. */
    private Integer row;

    /** The cell's sheet. */
    private String sheet;

    protected CellAddressImpl() {
    }

    protected CellAddressImpl(final int col, final int row) {
        this.row = row;
        this.col = col;
    }


    @Override public CellAddress col(Integer col) {
        this.col = col;
        return this;
    }

    @Override public CellAddress col(String col) {
        this.col = CellAddressHelper.toNumber(col);
        return this;
    }

    @Override public CellAddress row(Integer row) {
        this.row = row;
        return this;
    }

    @Override public CellAddress sheet(String sheet) {
        this.sheet = sheet;
        return this;
    }

    @Override
    public String toString() {
        String s = "";
        s = s + (sheet == null ? "" : "'"+sheet+"'!");
        s = s + (col == null ? "" : CellAddressHelper.toName(col));
        s = s + (row == null ? "" : row);
        return s;
    }

    @Override public Integer getCol() {
        return this.col;
    }

    @Override public Integer getRow() {
        return this.row;
    }

    @Override public String getSheet() {
        return this.sheet;
    }

    @Override public void setCol(Integer col) {
        this.col = col;
    }

    @Override public void setRow(Integer row) {
        this.row = row;
    }

    @Override public void setSheet(String sheet) {
        this.sheet = sheet;
    }

    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CellAddressImpl))
            return false;
        final CellAddressImpl other = (CellAddressImpl) o;

        if (this.col == null ? other.col != null : !this.col.equals(other.col))
            return false;
        final Object this$row = this.row;
        final Object other$row = other.row;
        if (this$row == null ? other$row != null : !this$row.equals(other$row))
            return false;
        final Object this$sheet = this.sheet;
        final Object other$sheet = other.sheet;
        if (this$sheet == null ? other$sheet != null : !this$sheet.equals(other$sheet))
            return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $col = this.col;
        result = result * PRIME + ($col == null ? 43 : $col.hashCode());
        final Object $row = this.row;
        result = result * PRIME + ($row == null ? 43 : $row.hashCode());
        final Object $sheet = this.sheet;
        result = result * PRIME + ($sheet == null ? 43 : $sheet.hashCode());
        return result;
    }
}
