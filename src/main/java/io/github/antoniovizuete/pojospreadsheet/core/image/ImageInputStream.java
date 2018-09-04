package io.github.antoniovizuete.pojospreadsheet.core.image;

import io.github.antoniovizuete.pojospreadsheet.core.SheetImpl;
import io.github.antoniovizuete.pojospreadsheet.core.model.CellAddress;
import org.apache.poi.util.IOUtils;

import java.io.IOException;

/**
 * An {@link Image} implementation.
 * <p>It represents an image to place into a {@link SheetImpl}.
 * Requires the resource path.
 * </p>
 * @author Antonio Vizuete
 * @since 0.1
 */
public final class ImageInputStream extends AbstractImage implements Image {
	private String path;

    public ImageInputStream(String path, CellAddress cellAddress) {
		super(cellAddress);
		this.path = path;
	}
	
	public ImageInputStream(String path, CellAddress cellAddress, Type type) {
		super(cellAddress, type);
		this.path = path;
	}
	
	public byte[] getResource() throws IOException {
		return IOUtils.toByteArray(this.getClass().getResourceAsStream(this.getPath()));
	}

    private String getPath() {
        return path;
    }

    /**
     * Sets the resource path.
     * @param path Path to image resource
     */
    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "ImageInputStream[" +
                "'" + path + "'@" +getCellAddress().toString()+
                ']';
    }
}
