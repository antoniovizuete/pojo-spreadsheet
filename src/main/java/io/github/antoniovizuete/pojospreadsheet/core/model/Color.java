package io.github.antoniovizuete.pojospreadsheet.core.model;

/**
 * The interface Color.
 *
 * @author Antonio Vizuete
 * @since 0.1
 */
public interface Color {
  /**
   * To byte array byte [ ].
   *
   * @return the byte [ ]
   */
  byte[] toByteArray();

  /**
   * Gets red.
   *
   * @return the red
   */
  int getRed();

  /**
   * Gets green.
   *
   * @return the green
   */
  int getGreen();

  /**
   * Gets blue.
   *
   * @return the blue
   */
  int getBlue();

  /**
   * Gets hex rgb.
   *
   * @return the hex rgb
   */
  String getHexRGB();

  /**
   * Sets hex rgb.
   *
   * @param hexRGB the hex rgb
   */
  void setHexRGB(String hexRGB);

  /**
   * To awt color java . awt . color.
   *
   * @return the java . awt . color
   */
  java.awt.Color toAwtColor();
}
