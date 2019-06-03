package com.example.xiaohaweather.util;

import android.text.TextUtils;

import com.example.xiaohaweather.db.City;
import com.example.xiaohaweather.db.Country;
import com.example.xiaohaweather.db.Province;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Utility {

    public static boolean handleProvinceResponce(String responce) {
        if (!TextUtils.isEmpty(responce)) {
            try {
                JSONArray allProvinces = new JSONArray(responce);
                for (int i = 0; i < allProvinces.length(); i++) {
                    JSONObject provinceObject = allProvinces.getJSONObject(i);
                    Province province = new Province();
                    province.setProvinceName(provinceObject.getString("name"));
                    province.setProvinceCode(provinceObject.getInt("id"));
                    province.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static boolean handleCityResponce(String responce, int provinceId) {
        if (!TextUtils.isEmpty(responce)) {
            try {
                JSONArray allCities = new JSONArray(responce);
                for (int i = 0; i < allCities.length(); i++) {
                    JSONObject cityObject = allCities.getJSONObject(i);
                    City city = new City();
                    city.setCityName(cityObject.getString("name"));
                    city.setCityCode(cityObject.getInt("id"));
                    city.setProvinceId(provinceId);
                    city.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static boolean handleCountryResponce(String responce, int cityId) {
        if (!TextUtils.isEmpty(responce)) {
            try {
                JSONArray allCounties = new JSONArray(responce);
                for (int i = 0; i < allCounties.length(); i++) {
                    JSONObject countyObject = allCounties.getJSONObject(i);
                    Country country = new Country();
                    country.setCountryName(countyObject.getString("name"));
                    country.setWeatherId(countyObject.getString("weather_id"));
                    country.setCityId(cityId);
                    country.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
