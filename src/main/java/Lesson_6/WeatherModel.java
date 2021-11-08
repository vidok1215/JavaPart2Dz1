package main.java.Lesson_6;

import java.io.IOException;
import java.util.List;

public interface WeatherModel {
    void getWeather(String selectedCity, Controller period) throws IOException;

}