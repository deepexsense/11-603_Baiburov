package ru.itis.inform.verifiers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Проверка на число регуляркой...
public class Regulars {
    private static Pattern pattern;
    private static Matcher matcher;

    public static boolean isNumber(String line) {
        pattern = Pattern.compile("\\d+");
        matcher = pattern.matcher(line);
        return matcher.matches();
    }
}
