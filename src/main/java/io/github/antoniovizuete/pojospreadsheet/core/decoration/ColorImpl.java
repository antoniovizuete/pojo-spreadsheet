package io.github.antoniovizuete.pojospreadsheet.core.decoration;

import io.github.antoniovizuete.pojospreadsheet.core.model.Color;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

/**
 * Prototype class that represents a POI Color.
 *
 * @author Antonio Vizuete
 * @since 0.1
 */
public class ColorImpl implements Color {

  private static final int R = 0;
  private static final int G = 1;
  private static final int B = 2;
  private static final String REGEX = "^#?([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$";

  private String hexRGB;

  public ColorImpl(String hexRGB) {
    if (!Pattern.matches(REGEX, hexRGB)) {
      throw new IllegalArgumentException("Color not valid '" + hexRGB + "'");
    }
    this.hexRGB = hexRGB;
  }

  @Override public String toString() {
    return "Color{" + hexRGB + '}';
  }

  @Override public byte[] toByteArray() {
    return convertColor(this.getHexRGB());
  }

  private byte[] convertColor(String color) {
    byte[] colorBytes = new byte[3];
    if (Pattern.matches(REGEX, color)) {

      final String auxColor = transform(color);

      IntStream.range(0, colorBytes.length)
        .forEach(i -> colorBytes[i] = Integer.valueOf(auxColor.substring(i * 2, (i + 1) * 2), 16).byteValue());
    }
    return colorBytes;
  }

  private String transform(String color) {
    if (color.startsWith("#")) {
      color = color.substring(1);
    }

    if (color.length() == 3) {
      StringBuilder sb = new StringBuilder();
      Arrays.asList(color.split("")).forEach(part -> sb.append(part).append(part));
      color = sb.toString();
    }

    return color;
  }

  public java.awt.Color toAwtColor() {
    int[] intArray = new int[3];
    if (Pattern.matches(REGEX, this.hexRGB)) {

      final String color = transform(this.hexRGB);

      IntStream.range(0, intArray.length)
        .forEach(i -> intArray[i] = Integer.valueOf(color.substring(i * 2, (i + 1) * 2), 16));
    }
    return new java.awt.Color(intArray[R], intArray[G], intArray[B]);
  }

  @Override public int getRed() {
    return convertColor(this.getHexRGB())[R];
  }

  @Override public int getGreen() {
    return convertColor(this.getHexRGB())[G];
  }

  @Override public int getBlue() {
    return convertColor(this.getHexRGB())[B];
  }

  @Override public String getHexRGB() {
    return hexRGB;
  }

  @Override public void setHexRGB(String hexRGB) {
    this.hexRGB = hexRGB;
  }

}
