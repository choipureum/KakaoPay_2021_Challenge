package com.example.membership.util;

public class StringUtil {
    
    public static boolean isNullOrEmpty(String str)
    {
        if(str == null || str.trim().length() == 0)
        {
            return true;
        }
        return false;
    }
    public static boolean isNum(String str)
    {
        boolean isNumeric =  str.matches("[+-]?\\d*(\\.\\d+)?");
        return isNumeric;
    }
}