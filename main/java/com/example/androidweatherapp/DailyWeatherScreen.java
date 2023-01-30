package com.example.androidweatherapp;


import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.io.IOException;


public class DailyWeatherScreen extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        WeatherInfo dayW = new WeatherInfo();
        try {
            dayW.LoadWeatherData();
        } catch (IOException e) {
            e.printStackTrace();
        }

        View view = inflater.inflate(R.layout.fragment_daily_weather_screen, container, false);
        //  TextView hour0 = (TextView) view.findViewById(R.id.hour0);
        TextView day1 = (TextView) view.findViewById(R.id.day1);
        TextView day2 = (TextView) view.findViewById(R.id.day2);
        TextView day3 = (TextView) view.findViewById(R.id.day3);
        TextView day4 = (TextView) view.findViewById(R.id.day4);
        TextView day5 = (TextView) view.findViewById(R.id.day5);
        TextView day6 = (TextView) view.findViewById(R.id.day6);
        TextView day7 = (TextView) view.findViewById(R.id.day7);

        TextView night1 = (TextView) view.findViewById(R.id.night1);
        TextView night2 = (TextView) view.findViewById(R.id.night2);
        TextView night3 = (TextView) view.findViewById(R.id.night3);
        TextView night4 = (TextView) view.findViewById(R.id.night4);
        TextView night5 = (TextView) view.findViewById(R.id.night5);
        TextView night6 = (TextView) view.findViewById(R.id.night6);
        TextView night7 = (TextView) view.findViewById(R.id.night7);

        TextView max1 = (TextView) view.findViewById(R.id.max1);
        TextView max2 = (TextView) view.findViewById(R.id.max2);
        TextView max3 = (TextView) view.findViewById(R.id.max3);
        TextView max4 = (TextView) view.findViewById(R.id.max4);
        TextView max5 = (TextView) view.findViewById(R.id.max5);
        TextView max6 = (TextView) view.findViewById(R.id.max6);
        TextView max7 = (TextView) view.findViewById(R.id.max7);

        TextView min1 = (TextView) view.findViewById(R.id.min1);
        TextView min2 = (TextView) view.findViewById(R.id.min2);
        TextView min3 = (TextView) view.findViewById(R.id.min3);
        TextView min4 = (TextView) view.findViewById(R.id.min4);
        TextView min5 = (TextView) view.findViewById(R.id.min5);
        TextView min6 = (TextView) view.findViewById(R.id.min6);
        TextView min7 = (TextView) view.findViewById(R.id.min7);


        while(true){
            if(dayW.daybydayWeather.size() == 8){
                break;
            }
        }


        String day1text = dayW.daybydayWeather.get(1).get("day").getAsString() + "\u00B0";
        String day2text = dayW.daybydayWeather.get(2).get("day").getAsString() + "\u00B0";
        String day3text = dayW.daybydayWeather.get(3).get("day").getAsString() + "\u00B0";
        String day4text = dayW.daybydayWeather.get(4).get("day").getAsString() + "\u00B0";
        String day5text = dayW.daybydayWeather.get(5).get("day").getAsString() + "\u00B0";
        String day6text = dayW.daybydayWeather.get(6).get("day").getAsString() + "\u00B0";
        String day7text = dayW.daybydayWeather.get(7).get("day").getAsString() + "\u00B0";

        String night1text = dayW.daybydayWeather.get(1).get("night").getAsString() + "\u00B0";
        String night2text = dayW.daybydayWeather.get(2).get("night").getAsString() + "\u00B0";
        String night3text = dayW.daybydayWeather.get(3).get("night").getAsString() + "\u00B0";
        String night4text = dayW.daybydayWeather.get(4).get("night").getAsString() + "\u00B0";
        String night5text = dayW.daybydayWeather.get(5).get("night").getAsString() + "\u00B0";
        String night6text = dayW.daybydayWeather.get(6).get("night").getAsString() + "\u00B0";
        String night7text = dayW.daybydayWeather.get(7).get("night").getAsString() + "\u00B0";

        String max1text = dayW.daybydayWeather.get(1).get("max").getAsString() + "\u00B0";
        String max2text = dayW.daybydayWeather.get(2).get("max").getAsString() + "\u00B0";
        String max3text = dayW.daybydayWeather.get(3).get("max").getAsString() + "\u00B0";
        String max4text = dayW.daybydayWeather.get(4).get("max").getAsString() + "\u00B0";
        String max5text = dayW.daybydayWeather.get(5).get("max").getAsString() + "\u00B0";
        String max6text = dayW.daybydayWeather.get(6).get("max").getAsString() + "\u00B0";
        String max7text = dayW.daybydayWeather.get(7).get("max").getAsString() + "\u00B0";

        String min1text = dayW.daybydayWeather.get(1).get("min").getAsString() + "\u00B0";
        String min2text = dayW.daybydayWeather.get(2).get("min").getAsString() + "\u00B0";
        String min3text = dayW.daybydayWeather.get(3).get("min").getAsString() + "\u00B0";
        String min4text = dayW.daybydayWeather.get(4).get("min").getAsString() + "\u00B0";
        String min5text = dayW.daybydayWeather.get(5).get("min").getAsString() + "\u00B0";
        String min6text = dayW.daybydayWeather.get(6).get("min").getAsString() + "\u00B0";
        String min7text = dayW.daybydayWeather.get(7).get("min").getAsString() + "\u00B0";

        day1.setText(day1text);
        day2.setText(day2text);
        day3.setText(day3text);
        day4.setText(day4text);
        day5.setText(day5text);
        day6.setText(day6text);
        day7.setText(day7text);

        night1.setText(night1text);
        night2.setText(night2text);
        night3.setText(night3text);
        night4.setText(night4text);
        night5.setText(night5text);
        night6.setText(night6text);
        night7.setText(night7text);

        max1.setText(max1text);
        max2.setText(max2text);
        max3.setText(max3text);
        max4.setText(max4text);
        max5.setText(max5text);
        max6.setText(max6text);
        max7.setText(max7text);

        min1.setText(min1text);
        min2.setText(min2text);
        min3.setText(min3text);
        min4.setText(min4text);
        min5.setText(min5text);
        min6.setText(min6text);
        min7.setText(min7text);


        return view;



    }
}