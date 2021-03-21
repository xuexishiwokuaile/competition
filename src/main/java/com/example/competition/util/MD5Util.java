package com.example.competition.util;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * @author Chen Anran
 * @date 2021/3/21
 */
public class MD5Util {
    public static String md5(String str) {
        String salt = "chenanran";
        return new Md5Hash(str, salt).toString();
    }
}