package io.github.antoniovizuete.pojospreadsheet.core;


import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;

/**
 * The type SpreadsheetFileWriter.
 *
 * @author Antonio Vizuete
 * @since 0.1
 */
class SpreadsheetFileWriter extends AbstractWriter {

  private String path;
  private String fileName;

  private File outputFile;

  /**
   * Instantiates a new Spreadsheet file writer.
   *
   * @param outputFile the output file
   */
  public SpreadsheetFileWriter(File outputFile) {
    this.outputFile = outputFile;
  }

  /**
   * Instantiates a new Spreadsheet file writer.
   *
   * @param path     the path
   * @param fileName the file name
   */
  public SpreadsheetFileWriter(String path, String fileName) {
    this.path = path;
    this.fileName = fileName;
  }

  /**
   * Instantiates a new Spreadsheet file writer.
   *
   * @param fileName the file name
   */
  public SpreadsheetFileWriter(String fileName) {
    this.fileName = fileName;
  }

  /**
   * Sets path.
   *
   * @param path the path
   */
  public void setPath(String path) {
    this.path = path;
  }

  /**
   * Sets file name.
   *
   * @param fileName the file name
   */
  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  /**
   * Sets output file.
   *
   * @param outputFile the output file
   */
  public void setOutputFile(File outputFile) {
    this.outputFile = outputFile;
  }

  @Override
  public byte[] write() {
    final File file = checkFile();

    try (FileOutputStream fos = new FileOutputStream(file)) {
      xssfWorkbook.write(fos);
    } catch (IOException e) {
      throw new IllegalArgumentException(e);
    }

    byte[] byteArray = new byte[(int)file.length()];
    try(DataInputStream dis  = new DataInputStream(new FileInputStream(file))) {
      dis.readFully(byteArray);
    } catch (IOException e) {
      throw new IllegalArgumentException(e);
    }

    return byteArray;
  }

  private File checkFile() {
    if(Objects.nonNull(outputFile)) {
      return outputFile;
    }

    if(Objects.isNull(fileName)) {
      throw new IllegalStateException("Filename can not be null.");
    }

    if(Objects.nonNull(path) && !path.isEmpty() && !(new File(path)).exists()) {
      throw new IllegalStateException("Output path \"" + path + "\" does not exist.");
    }

    final File file = new File(path + fileName);

    if(!file.canWrite()) {
      throw new IllegalStateException(path + fileName + " is not writable");
    }
    return file;
  }


}
