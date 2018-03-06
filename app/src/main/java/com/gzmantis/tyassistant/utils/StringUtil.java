package com.gzmantis.tyassistant.utils;

/**
 * Created by LONG on 2018/3/5.
 */

public class StringUtil {

    public static final String AND = "&";
    public static final String COLON = ":";
    public static final String COMMA = ",";
    public static final String EMPTY = "";
    public static final String EQUALS = "=";
    public static final String PROBLEM = "?";
    public static final String SEMICOLON = ";";

    public static boolean isEmpty(String paramString) {
        return ((paramString == null) || ("".equals(paramString)) || ("null".equals(paramString)));
    }
}
