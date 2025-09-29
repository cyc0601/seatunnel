package org.apache.seatunnel.connectors.seatunnel.jdbc.catalog.utils;

public abstract class DbNameUtils {

    public static boolean isWrappedInBrackets(String str) {
        if (str == null || str.length() < 2) {
            return false;
        }
        return str.startsWith("[") && str.endsWith("]");
    }

    public static String removeBracketsIfPresent(String str) {
        if (isWrappedInBrackets(str)) {
            return str.substring(1, str.length() - 1);
        }
        return str;
    }

    public static String fixBracketsIfNotPresent(String str) {
        if (!isWrappedInBrackets(str)) {
            return String.format("[%s]", str);
        }
        return str;
    }
}
