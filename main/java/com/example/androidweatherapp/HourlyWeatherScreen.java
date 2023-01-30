package com.example.androidweatherapp;


import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.io.IOException;

public class HourlyWeatherScreen extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        WeatherInfo hourW = new WeatherInfo();
        try {
            hourW.LoadWeatherData();
        } catch (IOException e) {
            e.printStackTrace();
        }

        View view = inflater.inflate(R.layout.fragment_hourly_weather_screen, container, false);
      //  TextView hour0 = (TextView) view.findViewById(R.id.hour0);
        TextView hour1 = (TextView) view.findViewById(R.id.hour1);
        TextView hour2 = (TextView) view.findViewById(R.id.hour2);
        TextView hour3 = (TextView) view.findViewById(R.id.hour3);
        TextView hour4 = (TextView) view.findViewById(R.id.hour4);
        TextView hour5 = (TextView) view.findViewById(R.id.hour5);


        while(true){
            if(hourW.hourbyhourWeather.size() == 6){
                break;
            }
        }

     //   String hour0text = hourW.hourbyhourWeather.get(0).get("temp").getAsString() + "\u00B0";
        String hour1text = hourW.hourbyhourWeather.get(1).get("temp").getAsString() + "\u00B0";
        String hour2text = hourW.hourbyhourWeather.get(2).get("temp").getAsString() + "\u00B0";
        String hour3text = hourW.hourbyhourWeather.get(3).get("temp").getAsString() + "\u00B0";
        String hour4text = hourW.hourbyhourWeather.get(4).get("temp").getAsString() + "\u00B0";
        String hour5text = hourW.hourbyhourWeather.get(5).get("temp").getAsString() + "\u00B0";

     //   hour0.setText(hour0text);
        hour1.setText(hour1text);
        hour2.setText(hour2text);
        hour3.setText(hour3text);
        hour4.setText(hour4text);
        hour5.setText(hour5text);


        return view;



    }
}