package io.github.antoniovizuete.pojospreadsheet.core.image;

import io.github.antoniovizuete.pojospreadsheet.core.model.CellAddress;

/**
 * Abstract implementation of the {@link Image} interface.
 *
 * @author Antonio Vizuete
 * @since 0.1
 */
abstract class AbstractImage implements Image {
    private CellAddress cellAddress = CellAddress.empty();
    private Type type = Image.Type.JPEG;

	public AbstractImage() {}

	public AbstractImage (CellAddress cellAddress) {
	    this.cellAddress = cellAddress;
    }
	
	public AbstractImage(CellAddress cellAddress, Type type) {
        this.cellAddress = cellAddress;
	    this.type = type;
	}

    public Image address(CellAddress cellAddress) {
        this.cellAddress = cellAddress;
        return this;
    }

    public Image type(Type type) {
        this.type = type;
        return this;
    }

    public CellAddress getCellAddress() {
        return cellAddress;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
