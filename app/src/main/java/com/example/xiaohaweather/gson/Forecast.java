package com.example.xiaohaweather.gson;

import com.google.gson.annotations.SerializedName;

public class Forecast {

    @SerializedName("data")
    public String data;

    @SerializedName("cond")
    public More more;

    @SerializedName("tmp")
    public Temperature temperature;

    public class Temperature {
        @SerializedName("max")
        public String max;

        @SerializedName("min")
        public String min;
    }

    public class More {
        @SerializedName("txt_d")
        public String info;
    }
}
