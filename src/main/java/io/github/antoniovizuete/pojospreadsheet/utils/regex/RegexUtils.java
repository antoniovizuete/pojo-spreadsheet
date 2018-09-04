package io.github.antoniovizuete.pojospreadsheet.utils.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * The type Regex utils.
 *
 * @author Antonio Vizuete
 * @since 0.1
 */
public interface RegexUtils {
  /**
   * Regex substring string.
   *
   * @param regex   the regex
   * @param charSeq the char seq
   * @return the string
   */
  static String regexSubstring(String regex, String charSeq) {
    Pattern p = Pattern.compile(regex);
    Matcher m = p.matcher(charSeq);
    if (m.find()) {
      return m.group();
    }
    return null;
  }
}
