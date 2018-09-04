package io.github.antoniovizuete.pojospreadsheet.core.image;

import io.github.antoniovizuete.pojospreadsheet.core.converter.PoiValue;
import io.github.antoniovizuete.pojospreadsheet.core.model.CellAddress;

import java.io.IOException;

/**
 * Interface indicating the basic members of an Image.
 *
 * @author Antonio Vizuete
 * @since 0.1
 *
 */
public interface Image {

    enum Type implements PoiValue<Integer> {
        EMF(2), WMF(3), PICT(4), JPEG(5), PNG(6), DIB(7);
        Integer type;

        Type(Integer type) {
            this.type = type;
        }

        public Integer getPoiValue() {
            return this.type;
        }
    }

    /**
     * Return the {@link CellAddress} of an Image.
     * @return the {@link CellAddress} of an Image,
     *          or {@code {@link CellAddress#empty()}} if none
     */
    CellAddress getCellAddress();

    /**
     * Return the {@link Type} of an Image.
     * @return {@link Type} of an Image,
     *          or {@code EXA.Spreadsheets.Image.Type.JPEG} if none
     */
	Type getType();

    /**
     * Set the {@link Type} of an Image.
     */
    void setType(Type type);

    /**
     * "Builder-Look" method, set the address and return the .
     * <p>Set the {@link CellAddress}.</p>
     * <p>And it returns the instance.</p>
     *
     * @return the instance of current object ({@link Image})
     */
    Image address(CellAddress cellAddress);

    /**
     * "Builder-Look" method.
     * <p> Set the {@link Type} of an Image.</p>
     * <p>And it returns the instance.</p>
     *
     * @return the instance of current object ({@link Image})
     */
    Image type(Type type);

    /**
     * The method returns the Image resource converted into byte array.
     * @return Image byte array, or byte[0] if none
     * @throws IOException
     */
    byte[] getResource() throws IOException;
}
