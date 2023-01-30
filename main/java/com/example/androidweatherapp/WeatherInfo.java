package com.example.androidweatherapp;



import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;




public class WeatherInfo {
    final String currentSite = "https://api.openweathermap.org/data/2.5/onecall?lat=30.267153&lon=-97.743057&exclude=minutely,hourly,daily,alerts&units=imperial&appid=16a41dcae4d3fb03e27bc3334652b304";
    final String hourbyhourSite = "https://api.openweathermap.org/data/2.5/onecall?lat=30.267153&lon=-97.743057&exclude=current,minutely,daily,alerts&units=imperial&appid=16a41dcae4d3fb03e27bc3334652b304";
    final String daybydaySite = "https://api.openweathermap.org/data/2.5/onecall?lat=30.267153&lon=-97.743057&exclude=current,minutely,hourly,alerts&units=imperial&appid=16a41dcae4d3fb03e27bc3334652b304";


    ArrayList<JsonObject> currentWeather = new ArrayList<>();
    ArrayList<JsonObject> hourbyhourWeather = new ArrayList<>();
    ArrayList<JsonObject> daybydayWeather = new ArrayList<>();



    void LoadWeatherData() throws IOException {

        NetworkRequest();

    }

    void NetworkRequest() throws IOException {

        Thread currentThread = new Thread() {
            public void run() {

                try {

                    URL currentURL = new URL(currentSite);
                    URL hourbyhourURL = new URL(hourbyhourSite);
                    URL daybydayURL = new URL(daybydaySite);

                    // Connect to the URL using java's native library

                    URLConnection currentrequest = currentURL.openConnection();
                    currentrequest.connect();

                    JsonParser currentparser = new JsonParser(); //from gson
                    JsonElement currentroot = currentparser.parse(new InputStreamReader((InputStream) currentrequest.getContent())); //Convert the input stream to a json element
                    JsonObject currentrootobj = currentroot.getAsJsonObject(); // Array of (lat, lon, timezone, offset, current)

                    String CurrentObjString = currentrootobj.get("current").toString();

                    JsonElement newCurrentRoot = currentparser.parse(CurrentObjString);
                    JsonObject CurrentObj = newCurrentRoot.getAsJsonObject(); // Subarray of current(dt, sunrise, sunset, temp,... etc) important
                 //   String NewCurrentObj = newCurrentRootObj.get("temp").getAsString(); //example of getting json data from temp
                    currentWeather.add(CurrentObj);

//////////////////////////////////////////////////////////
                    URLConnection hourrequest = hourbyhourURL.openConnection();
                    hourrequest.connect();

                    // Convert to a JSON object to print data
                    JsonParser hourparser = new JsonParser(); //from gson
                    JsonElement hourroot = currentparser.parse(new InputStreamReader((InputStream) hourrequest.getContent())); //Convert the input stream to a json element
                    JsonObject hourrootobj = hourroot.getAsJsonObject(); //May be an array, may be an object.
                  //  String hourObj = hourrootobj.get("hourly").toString();
                  //  System.out.println(hourObj);
                    JsonArray newHourRootObj = (JsonArray) hourrootobj.get("hourly");

                    JsonArray HourObj = new JsonArray();
                    for(int i = 0; i < 6; i++){
                        HourObj.add(newHourRootObj.get(i)); //next 5 hours of weather prediction plus current weather
                    }

                    for(int i = 0; i < 6; i++){
                        hourbyhourWeather.add((JsonObject) HourObj.get(i));
                    }
/////////////////////////////////////////////////////////////////////////////////////////

                    URLConnection dayrequest = daybydayURL.openConnection();
                    dayrequest.connect();

                    // Convert to a JSON object to print data
                    JsonParser dayparser = new JsonParser(); //from gson
                    JsonElement dayroot = currentparser.parse(new InputStreamReader((InputStream) dayrequest.getContent())); //Convert the input stream to a json element
                    JsonObject dayrootobj = dayroot.getAsJsonObject(); //May be an array, may be an object.

                    JsonArray DayObj = (JsonArray) dayrootobj.get("daily"); // 8 elements , the current day and the next 7 days
                    ArrayList<JsonObject> dayWeather = new ArrayList<>();
                    for(int i = 0; i < 8; i++){
                        dayWeather.add((JsonObject) DayObj.get(i));
                        daybydayWeather.add((JsonObject) dayWeather.get(i).get("temp"));
                    }



                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        };
        currentThread.start();

        while(true){
            if((currentWeather.size() ==1) && (hourbyhourWeather.size() == 6) && daybydayWeather.size() == 8){
                currentThread.interrupt();
                break;
            }
        }



   }


}
