package com.example.f1.api;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RaceResponse {
    @SerializedName("MRData")
    public MRData mrData;

    public static class MRData {
        @SerializedName("RaceTable")
        public RaceTable raceTable;
    }

    public static class RaceTable {
        @SerializedName("Races")
        public List<Race> races;
    }

    public static class Race {
        @SerializedName("raceName")
        public String raceName;
        @SerializedName("Circuit")
        public Circuit circuit;
        @SerializedName("date")
        public String date;
    }

    public static class Circuit {
        @SerializedName("Location")
        public Location location;
    }

    public static class Location {
        @SerializedName("locality")
        public String locality;
        @SerializedName("country")
        public String country;
    }
}
