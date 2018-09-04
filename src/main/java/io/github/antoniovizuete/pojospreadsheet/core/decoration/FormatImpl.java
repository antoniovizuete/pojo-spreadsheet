package io.github.antoniovizuete.pojospreadsheet.core.decoration;

import io.github.antoniovizuete.pojospreadsheet.core.model.Format;

/**
 * Prototype class that represents a POI Format.
 *
 * @author Antonio Vizuete
 * @since 0.1
 */
public class FormatImpl implements Format {

  private String value;

  public FormatImpl(String value) {
    this.value = value;
  }

  @Override public String getValue() {
    return value;
  }

  @Override public void setValue(String value) {
    this.value = value;
  }
}
