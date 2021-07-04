package com.example.membership.util;

public class StringUtil {
    
    /**
     * null or empty 유효성 검사
     * @param str
     * @return
     */
    public static boolean isNullOrEmpty(String str)
    {
        if(str == null || str.trim().length() == 0)
        {
            return true;
        }
        return false;
    }
    /**
     * 넘버릭 유효성검사
     * @param str
     * @return
     */
    public static boolean isNum(String str)
    {
        boolean isNumeric =  str.matches("[+-]?\\d*(\\.\\d+)?");
        return isNumeric;
    }
}