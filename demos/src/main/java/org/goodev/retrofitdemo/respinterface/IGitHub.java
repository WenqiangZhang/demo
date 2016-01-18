package org.goodev.retrofitdemo.respinterface;

import org.goodev.retrofitdemo.entity.Contributor;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by lenovo on 2016/1/15.
 */
public interface IGitHub {

    @GET("/repos/{owner}/{repo}/contributors")
    List<Contributor> contributors(@Path("owner") String owner, @Path("repo") String repo);

    @GET("/repos/{owner}/{repo}/contributors")
    void contributors(@Path("owner") String owner, @Path("repo") String repo, Callback<List<Contributor>> callback);
}
