package com.example.femmy.finalretrofit;

import java.util.List;
import java.util.StringTokenizer;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by FAMY on 25-Feb-17.
 */

public interface REGAPI {

    @GET("/dd/insert_register.php")
    Call<String> register (@Query("username") String username, @Query("password") String password,
                           @Query("email") String email, @Query("address") String address,
                           @Query("contact_number") String contact_address);

    @GET("/dd/insert_login.php")
    Call<String> login (@Query("username") String username,@Query("password") String password);

    @GET("/dd/garment_details.php")
    Call<List<GarmentDetail>> GarmentDetails();

    @GET("/dd/pattern_details.php")
    Call<List<PatternDetail>> PatternDetails();

    @GET("/dd/back_details.php")
    Call<List<BackDetail>> BackDetail();


    @GET("/dd/sleeve_details.php")
    Call<List<SleeveDetail>> SleeveDetail();

    @GET("/dd/bottom_details.php")
    Call<List<BottomDetail>> BottomDetail();

    @GET("/dd/hemline_details.php")
    Call<List<HemlineDetail>> HemlineDetail();

    @GET("/dd/other_details.php")
    Call<List<ExtraDetail>> ExtraDetail();
}
