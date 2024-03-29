package com.example.xiaohaweather.gson;

import android.view.textservice.SuggestionsInfo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Weather {

    @SerializedName("status")
    public String status;

    @SerializedName("basic")
    public Basic basic;

    @SerializedName("aqi")
    public AQI aqi;

    @SerializedName("now")
    public Now now;

    @SerializedName("suggestion")
    public Suggestion suggestion;

    @SerializedName("daily_forecast")
    public List<Forecast> forecastList;
}
