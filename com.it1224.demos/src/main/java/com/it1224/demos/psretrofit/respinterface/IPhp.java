package com.it1224.demos.psretrofit.respinterface;

import com.it1224.demos.entity.DemoInfo;
import com.it1224.demos.psretrofit.entity.ImageInfo;

import java.util.List;

import retrofit.Callback;
import retrofit.http.Field;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Query;

/**
 * Created by lenovo on 2016/1/15.
 */
public interface IPhp {

    /**
     * 获取多张图片
     */
    @GET("/interfaceapp/php/imgurl/getImageUrls.php")
    void getImageUrls(@Query("type") String type, Callback<List<ImageInfo>> cb);

    /**
     * 获取多张图片
     */
    @GET("/interfaceapp/php/imgurl/getImageUrls.php")
    List<ImageInfo> getImageUrls(@Query("type") String type);

    /**
     * 获取每个Demo的信息
     */
    @GET("/interfaceapp/php/android/demos/getAndroidDemos.php")
    void getAndroidDemos(Callback<List<DemoInfo>> cb);

    /**
     * 添加demo
     */
    @POST("/interfaceapp/php/android/demos/setAndroidDemos.php")
    void setAndroidDemos(@Field("name") String name, @Field("description") String description, @Field("time") String time, @Field("activity") String activity, Callback<List<DemoInfo>> cb);

}
