package com.example.androidweatherapp;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class SimpleFragmentPagerAdapter
        extends FragmentPagerAdapter {

    public SimpleFragmentPagerAdapter(
            FragmentManager fm)
    {
        super(fm);
    }

    @Override
    public Fragment getItem(int position)
    {
        if (position == 0) {
            return new CurrentWeatherScreen();
        }
        else if (position == 1) {
            return new HourlyWeatherScreen();
        }
        else {
            return new DailyWeatherScreen();
        }
    }

    @Override
    public int getCount()
    {
        return 3;
    }
}