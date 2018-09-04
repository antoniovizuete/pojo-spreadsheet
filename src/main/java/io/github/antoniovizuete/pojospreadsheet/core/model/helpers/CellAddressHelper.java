package io.github.antoniovizuete.pojospreadsheet.core.model.helpers;

import io.github.antoniovizuete.pojospreadsheet.utils.regex.RegexUtils;

import java.util.Optional;

/**
 * The type Cell address helper.
 *
 * @author Antonio Vizuete
 * @since 0.1
 */
public final class CellAddressHelper {

  private static final String REGEX_CELL_COL = "[A-Z]+";
  private static final String REGEX_CELL_ROW = "\\d+";
  private static final String SHEET_SEP = "!";

  private CellAddressHelper() { /* Not-instantiable class. */ }

  /**
   * Extract row integer.
   *
   * @param address the address
   * @return the integer
   */
  public static Integer extractRow(String address) {
    return Optional.ofNullable(RegexUtils.regexSubstring(REGEX_CELL_ROW, extractAddressInfo(address)))
      .map(Integer::parseInt).orElse(null);
  }

  /**
   * Extract column integer.
   *
   * @param address the address
   * @return the integer
   */
  public static Integer extractColumn(final String address) {
    return Optional.ofNullable(RegexUtils.regexSubstring(REGEX_CELL_COL, extractAddressInfo(address)))
      .map(CellAddressHelper::toNumber).orElse(null);
  }

  /**
   * Extract sheet name string.
   *
   * @param address the address
   * @return the string
   */
  public static String extractSheetName(final String address) {
    final Integer index = address.indexOf(SHEET_SEP);
    if (index == -1) {
      return null;
    }
    return address.substring(0, index);
  }

  private static String extractAddressInfo(String address) {
    String computedAddress = address;
    if (computedAddress.contains(SHEET_SEP)) {
      computedAddress = address.substring(address.indexOf(SHEET_SEP));
    }
    return computedAddress;
  }

  /**
   * To number integer.
   *
   * @param name the name
   * @return the integer
   */
  public static Integer toNumber(String name) {
    if (name == null) {
      return null;
    }
    int number = 0;
    for (int i = 0; i < name.length(); i++) {
      number = number * 26 + (name.charAt(i) - ('A' - 1));
    }
    return number;
  }

  /**
   * To name string.
   *
   * @param number the number
   * @return the string
   */
  public static String toName(int number) {
    StringBuilder sb = new StringBuilder();
    while (number-- > 0) {
      sb.append((char) ('A' + (number % 26)));
      number /= 26;
    }
    return sb.reverse().toString();
  }
}
