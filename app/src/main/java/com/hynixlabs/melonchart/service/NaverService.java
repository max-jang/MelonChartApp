package com.hynixlabs.melonchart.service;

import com.hynixlabs.melonchart.vo.WordItems;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface NaverService {
    @Headers({
            "X-Naver-Client-Id: sg3ym0bsgTSLA9wj4W5P",
            "X-Naver-Client-Secret: KI1v3AuquJ"})

    @GET("/v1/search/book.json")
    Call<WordItems> getSearchItems(
            @Query(value = "query", encoded = true) String query,
            @Query(value = "display") String display,
            @Query(value = "start") String start
    );
}
