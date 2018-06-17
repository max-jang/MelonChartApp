package com.hynixlabs.melonchart.service;

import com.hynixlabs.melonchart.vo.MusicItem;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RequestInterface {

    @GET("/api")
    Call<MusicItem> getJSON();
}
