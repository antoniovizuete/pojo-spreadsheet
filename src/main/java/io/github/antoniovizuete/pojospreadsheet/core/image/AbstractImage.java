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
  private ImageType type = ImageType.JPEG;

  public AbstractImage() {
  }

  public AbstractImage(CellAddress cellAddress) {
    this.cellAddress = cellAddress;
  }

  public AbstractImage(CellAddress cellAddress, ImageType type) {
    this.cellAddress = cellAddress;
    this.type = type;
  }

  public Image address(CellAddress cellAddress) {
    this.cellAddress = cellAddress;
    return this;
  }

  public Image type(ImageType type) {
    this.type = type;
    return this;
  }

  public CellAddress getCellAddress() {
    return cellAddress;
  }

  public ImageType getType() {
    return type;
  }

  public void setType(ImageType type) {
    this.type = type;
  }
}
