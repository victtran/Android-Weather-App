
package com.example.androidweatherapp;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


import androidx.fragment.app.Fragment;

import org.w3c.dom.Text;

import java.io.IOException;

public class CurrentWeatherScreen extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        WeatherInfo curW = new WeatherInfo();
        try {
            curW.LoadWeatherData();
        } catch (IOException e) {
            e.printStackTrace();
        }

        View view = inflater.inflate(R.layout.fragment_current_weather_screen, container, false);
        TextView temperature = (TextView) view.findViewById(R.id.temperature);
        TextView humidity = (TextView) view.findViewById(R.id.humidity);
        TextView windspeed = (TextView) view.findViewById(R.id.windspeed);
        TextView pressure = (TextView) view.findViewById(R.id.pressure);


        while(true){
            if(curW.currentWeather.size() ==1){
                break;
            }
        }

        String temptext = curW.currentWeather.get(0).get("temp").getAsString() + "\u00B0";
        String humidtext = curW.currentWeather.get(0).get("humidity").getAsString() + "%";
        String windspeedtext = curW.currentWeather.get(0).get("wind_speed").getAsString() + " mph";
        String pressuretext = curW.currentWeather.get(0).get("pressure").getAsString() + " hPa";

        temperature.setText(temptext);
        humidity.setText(humidtext);
        windspeed.setText(windspeedtext);
        pressure.setText(pressuretext);

        return view;



    }
}