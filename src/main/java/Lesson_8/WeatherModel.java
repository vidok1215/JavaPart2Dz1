package main.java.Lesson_8;

import main.java.Lesson_7.Period;

import java.io.IOException;

public interface WeatherModel {
    void getWeather(String selectedCity, Period period) throws IOException;

    // public List<Weather> getSavedToDBWeather();
}