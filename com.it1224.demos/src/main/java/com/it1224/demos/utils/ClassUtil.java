package com.it1224.demos.utils;

import android.content.Context;

/**
 * Created by lenovo on 2016/1/19.
 */
public class ClassUtil {

    public static Class<?> getClass(Context context, String className) {
        try {
            Class<?> clazz = Class.forName(context.getPackageName() + ".retrofit.activity." + className);
            return clazz;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
