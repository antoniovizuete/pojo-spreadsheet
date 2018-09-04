package io.github.antoniovizuete.pojospreadsheet.core.image;

import io.github.antoniovizuete.pojospreadsheet.core.converter.PoiValue;
import io.github.antoniovizuete.pojospreadsheet.core.model.CellAddress;

import java.io.IOException;

/**
 * Interface indicating the basic members of an Image.
 *
 * @author Antonio Vizuete
 * @since 0.1
 */
public interface Image {

  /**
   * The enum Type.
   */
  enum ImageType implements PoiValue<Integer> {
    EMF(2), WMF(3), PICT(4), JPEG(5), PNG(6), DIB(7);
    Integer type;

    ImageType(Integer type) {
      this.type = type;
    }

    public Integer getPoiValue() {
      return this.type;
    }
  }

  /**
   * Return the {@link CellAddress} of an Image.
   *
   * @return the {@link CellAddress} of an Image,
   * or {@code {@link CellAddress#empty()}} if none
   */
  CellAddress getCellAddress();

  /**
   * Return the {@link ImageType} of an Image.
   *
   * @return {@link ImageType} of an Image,
   * or {@code EXA.Spreadsheets.Image.Type.JPEG} if none
   */
  ImageType getType();

  /**
   * Set the {@link ImageType} of an Image.
   * @param type the type
   */
  void setType(ImageType type);

  /**
   * "Builder-Look" method, set the address and return the .
   * <p>Set the {@link CellAddress}.</p>
   * <p>And it returns the instance.</p>
   *
   * @param cellAddress the address
   * @return the instance of current object ({@link Image})
   */
  Image address(CellAddress cellAddress);

  /**
   * "Builder-Look" method.
   * <p> Set the {@link ImageType} of an Image.</p>
   * <p>And it returns the instance.</p>
   *
   * @param  type the image type
   * @return the instance of current object ({@link Image})
   */
  Image type(ImageType type);

  /**
   * The method returns the Image resource converted into byte array.
   *
   * @return Image byte array, or byte[0] if none
   * @throws IOException treats the resource
   */
  byte[] getResource() throws IOException;
}
