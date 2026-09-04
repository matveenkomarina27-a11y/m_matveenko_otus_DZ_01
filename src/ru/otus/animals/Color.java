package ru.otus.animals;

import java.util.ArrayList;
import java.util.List;

public enum Color {

    UNDEFINED("неизвестный"),
    WHITE("белый"),
    BLACK("черный"),
    GREY("серый"),
    BROWN("коричневый"),
    ORANGE("рыжий");

    private final String value;

    public static final List<String> VALUES = collectValues();

    Color(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    private static List<String> collectValues() {
        List<String> result = new ArrayList<>();
        for (Color color : Color.values()) {
            result.add(color.getValue());
        }
        return result;
    }

    public static boolean doesNotContain(String value) {
        if (value == null) {
            return true;
        }
        return !VALUES.contains(value.toLowerCase().trim());
    }

    public static Color fromString(String value) {
        if (value == null) {
            return null;
        }
        String trimmed = value.toLowerCase().trim();
        for (Color color : Color.values()) {
            if (color.getValue().equals(trimmed)) {
                return color;
            }
        }
        return null;
    }
}


