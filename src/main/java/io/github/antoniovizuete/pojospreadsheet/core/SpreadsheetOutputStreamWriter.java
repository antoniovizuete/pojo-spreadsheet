package io.github.antoniovizuete.pojospreadsheet.core;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author Antonio Vizuete
 * @since 0.1
 */
class SpreadsheetOutputStreamWriter extends AbstractWriter {

  @Override
  public byte[] write() {
    byte[] byteArray = null;
    try (OutputStream baos = new ByteArrayOutputStream()) {
      xssfWorkbook.write(baos);
      byteArray = ((ByteArrayOutputStream) baos).toByteArray();
    } catch (IOException e) {
      throw new IllegalArgumentException(e);
    }
    return byteArray;
  }


}
