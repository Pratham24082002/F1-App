package com.example.f1.api;

import retrofit2.Call;
import retrofit2.http.GET;

public interface F1Api {
    @GET("current/driverStandings.json")
    Call<DriverStandingsResponse> getDriverStandings();

    @GET("current/constructorStandings.json")
    Call<ConstructorStandingsResponse> getConstructorStandings();

    @GET("current.json")
    Call<RaceResponse> getRaces();
}
