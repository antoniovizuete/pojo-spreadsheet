package io.github.antoniovizuete.pojospreadsheet.core.decoration.defaults;

import io.github.antoniovizuete.pojospreadsheet.core.decoration.keys.FormatKey;

/**
 * Default Format key.
 *
 * @author Antonio Vizuete
 * @since 0.1
 */
public enum DefaultFormat implements FormatKey {
  DD_MM_YYYY;


  @Override public FormatKey getKey() {
    return this;
  }
}
