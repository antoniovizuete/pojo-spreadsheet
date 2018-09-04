package io.github.antoniovizuete.pojospreadsheet.core.model.helpers;

import io.github.antoniovizuete.pojospreadsheet.utils.regex.RegexUtils;

import java.util.Optional;

public final class CellAddressHelper {

  private static final String REGEX_CELL_COL = "[A-Z]+";
  private static final String REGEX_CELL_ROW = "\\d+";
  private static final String SHEET_SEP = "!";

  private CellAddressHelper() { /* Not-instantiable class. */ }

  public static Integer extractRow(String address) {
    return Optional.ofNullable(RegexUtils.regexSubstring(REGEX_CELL_ROW, extractAddressInfo(address))).map(Integer::parseInt).orElse(null);
  }

  public static Integer extractColumn(final String address) {
    return Optional.ofNullable(RegexUtils.regexSubstring(REGEX_CELL_COL, extractAddressInfo(address))).map(
      CellAddressHelper::toNumber).orElse(null);
  }

  public static String extractSheetName(final String address) {
    final Integer index = address.indexOf(SHEET_SEP);
    if (index == -1) {
      return null;
    }
    return address.substring(0, index);
  }

  private static String extractAddressInfo(String address) {
    String computedAddress = address;
    if(computedAddress.contains(SHEET_SEP)) {
      computedAddress = address.substring(address.indexOf(SHEET_SEP));
    }
    return computedAddress;
  }

  public static Integer toNumber(String name) {
      if(name == null) {
          return null;
      }
      int number = 0;
      for (int i = 0; i < name.length(); i++) {
          number = number * 26 + (name.charAt(i) - ('A' - 1));
      }
      return number;
  }

  public static String toName(int number) {
      StringBuilder sb = new StringBuilder();
      while (number-- > 0) {
          sb.append((char)('A' + (number % 26)));
          number /= 26;
      }
      return sb.reverse().toString();
  }
}
