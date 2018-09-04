package io.github.antoniovizuete.pojospreadsheet.core.model;

public interface Color {
  byte[] toByteArray();

  int getRed();

  int getGreen();

  int getBlue();

  String getHexRGB();

  void setHexRGB(String hexRGB);

  java.awt.Color toAwtColor();
}
