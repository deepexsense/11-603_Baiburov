package ru.itis.inform.verifiers;

// Проверка число ли это
public class IsNumber {
    public static boolean isNumber(String a) {
        try {
            Integer.parseInt(a);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
