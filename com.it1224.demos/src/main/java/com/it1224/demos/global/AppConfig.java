package com.it1224.demos.global;

/**
 * Created by lenovo on 2016/1/19.
 */
public class AppConfig {

    public final static String PROTOCOL = "http";
    public final static String HOST = "www.it1224.com";
    public final static String PORT = "80";

    public final static String WEB_SERVER_PATH = PROTOCOL + "://" + HOST + ":" + PORT;

    public static class DemoHost{
        public final static String RETROFIT_ENDPOINT = "https://api.github.com";//retrofit
    }
}
