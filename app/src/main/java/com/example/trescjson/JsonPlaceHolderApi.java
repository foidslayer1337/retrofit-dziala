package com.example.trescjson;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {

    @GET("db.json")
    Call<BazaDanychJSON> getAktywnosci();

}
