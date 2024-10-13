package com.example.kvtag.util;

public class NumberFilterEvaluator {
    public static boolean isSearchingByNumber(String text) {
        return text.matches("^(>=|<=|>|<|=)?\\s*\\d+(\\.\\d+)?$");
    }

    public static boolean evaluateCondition(double value, String condition) {
        condition = condition.replaceAll("\\s+", "");

        String operator = condition.replaceAll("\\d+.*", "");
        String compareValueStr = condition.replaceAll("[^\\d.]", "");

        if (operator.isEmpty()) {
            operator = "=";
        }

        double compareValue = Double.parseDouble(compareValueStr);

        switch (operator) {
            case ">":
                return value > compareValue;
            case "<":
                return value < compareValue;
            case ">=":
                return value >= compareValue;
            case "<=":
                return value <= compareValue;
            case "=":
            case "==":
                return value == compareValue;
            default:
                return false;
        }
    }
}
