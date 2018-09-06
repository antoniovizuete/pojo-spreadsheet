package io.github.antoniovizuete.pojospreadsheet.core;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * The type SpreadsheetOutputStreamWriter.
 *
 * @author Antonio Vizuete
 * @since 0.1
 */
class SpreadsheetByteArrayOutputStreamWriter extends AbstractWriter<ByteArrayOutputStream> {

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

  @Override
  public ByteArrayOutputStream performWrite() {
    ByteArrayOutputStream result;
    try (OutputStream baos = new ByteArrayOutputStream()) {
      xssfWorkbook.write(baos);
      result = (ByteArrayOutputStream) baos;
    } catch (IOException e) {
      throw new IllegalArgumentException(e);
    }
    return result;
  }
}
