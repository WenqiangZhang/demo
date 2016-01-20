package com.it1224.demos.psretrofit.ClientAPI;

import android.content.Context;

import com.it1224.demos.BuildConfig;
import com.it1224.demos.global.AppConfig;

import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit.converter.GsonConverter;

/**
 * Created by lenovo on 2016/1/15.
 */
public class APIClient {

    private static RestAdapter singleton;

    public static <T> T createApi(Context context, Class<T> clazz) {

        if (singleton == null) {
            synchronized (APIClient.class) {
                if (singleton == null) {
                    RestAdapter.Builder builder = new RestAdapter.Builder();
                    builder.setEndpoint(AppConfig.WEB_SERVER_PATH);

                    builder.setConverter(new GsonConverter(com.it1224.demos.psretrofit.utils.GsonUtils
                            .newInstance()));
                    builder.setClient(new OkClient(com.it1224.demos.psretrofit.utils.OkHttpUtils
                            .getInstance(context)));
                    builder.setLogLevel(BuildConfig.DEBUG ? RestAdapter.LogLevel.FULL
                            : RestAdapter.LogLevel.NONE);
                    singleton = builder.build();
                }
            }
        }
        return singleton.create(clazz);
    }

    private static RestAdapter.Builder singleBuilder;

    public static <T> T createConvertApi(Context context, Class<T> clazz, String endpoint) {
        if (singleBuilder == null) {
            synchronized (APIClient.class) {
                if (singleBuilder == null) {
                    RestAdapter.Builder builder = new RestAdapter.Builder();

                    builder.setConverter(new GsonConverter(com.it1224.demos.psretrofit.utils.GsonUtils
                            .newInstance()));
                    builder.setClient(new OkClient(com.it1224.demos.psretrofit.utils.OkHttpUtils
                            .getInstance(context)));
                    builder.setLogLevel(BuildConfig.DEBUG ? RestAdapter.LogLevel.FULL
                            : RestAdapter.LogLevel.NONE);
                    singleBuilder = builder;
                }
            }
        }
        singleBuilder.setEndpoint(endpoint);
        return singleBuilder.build().create(clazz);

    }
}
