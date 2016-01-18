package org.goodev.retrofitdemo.ClientAPI;

import android.content.Context;

import org.goodev.retrofitdemo.BuildConfig;
import org.goodev.retrofitdemo.utils.GsonUtils;
import org.goodev.retrofitdemo.utils.OkHttpUtils;

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
                    builder.setEndpoint("http://www.it1224.com");

                    builder.setConverter(new GsonConverter(GsonUtils
                            .newInstance()));
                    builder.setClient(new OkClient(OkHttpUtils
                            .getInstance(context)));
                    builder.setLogLevel(BuildConfig.DEBUG ? RestAdapter.LogLevel.FULL
                            : RestAdapter.LogLevel.NONE);
                    singleton = builder.build();
                }
            }
        }
        return singleton.create(clazz);
    }
}
