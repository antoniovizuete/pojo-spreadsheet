package io.github.antoniovizuete.pojospreadsheet.core.decoration.defaults;

import io.github.antoniovizuete.pojospreadsheet.core.decoration.keys.CellStyleKey;

/**
 * Default CellStyle key.
 * @author  Antonio Vizuete
 * @since   0.1
 */
public enum DefaultCellStyle implements CellStyleKey {
    DEFAULT_CELL_STYLE;

    @Override public CellStyleKey getKey() {
        return this;
    }
}
