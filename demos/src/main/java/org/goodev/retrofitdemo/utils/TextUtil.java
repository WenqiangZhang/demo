package org.goodev.retrofitdemo.utils;

/**
 * Created by lenovo on 2016/1/18.
 * 处理字符串
 */
public class TextUtil {

    /**
     * 判断字符串是否为空（去空格）
     * @param string
     * @return
     */
    public static boolean isEmpty(String string){
        return string == null || string.trim().length() == 0;
    }
}
