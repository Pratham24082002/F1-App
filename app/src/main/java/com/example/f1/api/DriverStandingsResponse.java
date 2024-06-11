package com.example.f1.api;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DriverStandingsResponse {
    @SerializedName("MRData")
    public MRData mrData;

    public static class MRData {
        @SerializedName("StandingsTable")
        public StandingsTable standingsTable;
    }

    public static class StandingsTable {
        @SerializedName("StandingsLists")
        public List<StandingsList> standingsLists;
    }

    public static class StandingsList {
        @SerializedName("DriverStandings")
        public List<DriverStanding> driverStandings;
    }

    public static class DriverStanding {
        @SerializedName("position")
        public String position;
        @SerializedName("points")
        public String points;
        @SerializedName("Driver")
        public Driver driver;
        @SerializedName("Constructors")
        public List<Constructor> constructors;
    }

    public static class Driver {
        @SerializedName("givenName")
        public String givenName;
        @SerializedName("familyName")
        public String familyName;
    }

    public static class Constructor {
        @SerializedName("name")
        public String name;
    }
}
