package io.github.antoniovizuete.pojospreadsheet.core.decoration.defaults;

import io.github.antoniovizuete.pojospreadsheet.core.decoration.keys.FontKey;

/**
 * Default Font key.
 *
 * @author Antonio Vizuete
 * @since 0.1
 */
public enum DefaultFont implements FontKey {
  DEFAULT_FONT;

  @Override public FontKey getKey() {
    return this;
  }
}
