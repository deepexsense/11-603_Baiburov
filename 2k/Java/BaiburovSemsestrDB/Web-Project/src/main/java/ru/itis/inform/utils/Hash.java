package ru.itis.inform.utils;

import org.apache.commons.codec.digest.DigestUtils;

//Хэшировка паролей для юзеров(инф безопасность)
public class Hash {
    public static String getMd5Apache(String password) {
        return DigestUtils.md5Hex(password);
    }
}
