package io.github.antoniovizuete.pojospreadsheet.utils.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by avizuete on 07/03/2017.
 */
public class RegexUtils {
  public static String regexSubstring(String regex, String charSeq) {
    Pattern p = Pattern.compile(regex);
    Matcher m = p.matcher(charSeq);
    if (m.find()) {
      return m.group();
    }
    return null;
  }
}
