package com.lixin.mvpdemo.utils;

/**
 * Created by lixin on 2017/2/28.
 */

public class StringUtils {


    /**
     * 判断字符串是否为空
     * <p/>
     * 空值返回 true
     *
     * @param str
     */
    public static boolean stringIsEmpty(String str) {
        boolean b = true;
        if (str != null && !str.equals("") && !str.equals("null")) {
            b = false;
        }
        return b;
    }

    public static boolean stringIsNotEmpty(String str) {
        boolean b = true;
        if (stringIsEmpty(str)) {
            b = false;
        }
        return b;
    }

}
