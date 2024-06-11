package com.example.f1.api;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ConstructorStandingsResponse {
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
        @SerializedName("ConstructorStandings")
        public List<ConstructorStanding> constructorStandings;
    }

    public static class ConstructorStanding {
        @SerializedName("position")
        public String position;
        @SerializedName("points")
        public String points;
        @SerializedName("Constructor")
        public Constructor constructor;
    }

    public static class Constructor {
        @SerializedName("name")
        public String name;
    }
}
