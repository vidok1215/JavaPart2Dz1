package main.java.Lesson_8;

import com.fasterxml.jackson.databind.ObjectMapper;
import main.java.Lesson_7.Period;
import main.java.Lesson_7.WeatherModel;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class AccuweatherModel implements WeatherModel {
    //http://dataservice.accuweather.com/forecasts/v1/daily/1day/349727
    private static final String PROTOKOL = "https";
    private static final String BASE_HOST = "dataservice.accuweather.com";
    private static final String FORECASTS = "forecasts";
    private static final String VERSION = "v1";
    private static final String DAILY = "daily";
    private static final String ONE_DAY = "1day";
    private static final String FIVE_DAYS = "5day";
    private static final String API_KEY = "idYYTiXuj0tuImPlMUy1UN8fmPnFK8RA";
    private static final String API_KEY_QUERY_PARAM = "apikey";
    private static final String LOCATIONS = "locations";
    private static final String CITIES = "cities";
    private static final String AUTOCOMPLETE = "autocomplete";

    private static final OkHttpClient okHttpClient = new OkHttpClient();
    private static final ObjectMapper objectMapper = new ObjectMapper();

    //private DataBaseRepository dataBaseRepository = new DataBaseRepository();

    public void getWeather(String selectedCity, Period period) throws IOException {
        switch (period) {
            case NOW:
                HttpUrl httpUrl = new HttpUrl.Builder()
                        .scheme(PROTOKOL)
                        .host(BASE_HOST)
                        .addPathSegment(FORECASTS)
                        .addPathSegment(VERSION)
                        .addPathSegment(DAILY)
                        .addPathSegment(ONE_DAY)
                        .addPathSegment(detectCityKey(selectedCity))
                        .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                        .build();

                Request request = new Request.Builder()
                        .url(httpUrl)
                        .build();

                Response oneDayForecastResponse = okHttpClient.newCall(request).execute();
                String weatherResponse = oneDayForecastResponse.body().string();
                System.out.println(weatherResponse);

                // String weatherText = "Privet";
                // String localDate = objectMapper.readTree(weatherResponse).at("/DailyForecasts").get(0).at("/Date").asText();
                //double temperature = objectMapper.readTree(weatherResponse).at("/DailyForecasts").get(0).at("/Temperature/Maximum/Value").asDouble();
                //double degrees = 20.5;
                //Weather weather = new Weather(selectedCity, localDate, temperature);
                //System.out.println(weather);



                // String weatherDate = "05.11.2021";
                //String temperature = "10.5";
                String localDate = objectMapper.readTree(weatherResponse).at("/DailyForecasts").get(0).at("/Date").asText();
                String temperature = objectMapper.readTree(weatherResponse).at("/DailyForecasts").get(0).at("/Temperature/Maximum/Value").asText();
                System.out.println("Погода в городе: " + selectedCity);
                System.out.println("На дату: " + localDate);
                System.out.println("Температура воздуха: " + temperature);
                //TODO: сделать человекочитаемый вывод погоды. Выбрать параметры для вывода на свое усмотрение
                //Например: Погода в городе Москва - 5 градусов по цельсию Expect showers late Monday night
                //dataBaseRepository.saveWeatherToDataBase(new Weather()) - тут после парсинга добавляем данные в БД
                break;
            case FIVE_DAYS:
                //TODO*: реализовать вывод погоды на 5 дней


                HttpUrl httpUrlFiveDays = new HttpUrl.Builder()
                        .scheme(PROTOKOL)
                        .host(BASE_HOST)
                        .addPathSegment(FORECASTS)
                        .addPathSegment(VERSION)
                        .addPathSegment(DAILY)
                        .addPathSegment(FIVE_DAYS)
                        .addPathSegment(detectCityKey(selectedCity))
                        .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                        .build();

                Request requestFiveDay = new Request.Builder()
                        .url(httpUrlFiveDays)
                        .build();

                Response fiveDayForecastResponse = okHttpClient.newCall(requestFiveDay).execute();
                String weatherResponseFive = fiveDayForecastResponse.body().string();
                System.out.println(weatherResponseFive);

                for (int i=0; i<5; i++) {

                    String fiveDate = objectMapper.readTree(weatherResponseFive).at("/DailyForecasts").get(i).at("/Date").asText();
                    String fiveTemperature = objectMapper.readTree(weatherResponseFive).at("/DailyForecasts").get(i).at("/Temperature/Maximum/Value").asText();
                    System.out.println("Погода в городе: " + selectedCity);
                    System.out.println("На дату: " + fiveDate);
                    System.out.println("Температура воздуха: " + fiveTemperature);
                    System.out.println();
                }

                break;


        }
    }



    // @Override
    //public List<Weather> getSavedToDBWeather() {
    //  return dataBaseRepository.getSavedToDBWeather();
    //}

    private String detectCityKey(String selectCity) throws IOException {
        //http://dataservice.accuweather.com/locations/v1/cities/autocomplete
        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme(PROTOKOL)
                .host(BASE_HOST)
                .addPathSegment(LOCATIONS)
                .addPathSegment(VERSION)
                .addPathSegment(CITIES)
                .addPathSegment(AUTOCOMPLETE)
                .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                .addQueryParameter("q", selectCity)
                .build();

        Request request = new Request.Builder()
                .url(httpUrl)
                .get()
                .addHeader("accept", "application/json")
                .build();

        Response response = okHttpClient.newCall(request).execute();
        String responseString = response.body().string();

        String cityKey = objectMapper.readTree(responseString).get(0).at("/Key").asText();
        return cityKey;
    }
}