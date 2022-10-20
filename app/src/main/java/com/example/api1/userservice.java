package com.example.api1;
import retrofit2.http.Body;
import retrofit2.Call;
import retrofit2.http.POST;

public interface userservice {
    @POST("Login")
    Call<loginresponse> userlogin(@Body loginrequest loginrequest);


}
