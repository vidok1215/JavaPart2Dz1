package main.java.Lesson_8;


import Lesson_8.entity.Weather;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataBaseRepository {
    private String insertWeather = "insert into weather (city, localDate, weatherText, temperature) values (?, ?, ?, ?)";
    private String getWeather = "select * from weather";

    private static final String DB_PATH = "jdbc:sqlite:weather.db";

    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public boolean saveWeatherToDataBase(Weather weather) throws SQLException {
        try (Connection connection = DriverManager.getConnection(DB_PATH)) {
            PreparedStatement saveWeather = connection.prepareStatement(insertWeather);
            saveWeather.setString(1, weather.getCity());
            saveWeather.setString(2, weather.getLocalDate());
            saveWeather.setString(3, weather.getWeatherText());
            saveWeather.setDouble(4, weather.getTemperature());
            return saveWeather.execute();
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        throw new SQLException ("Сохранение погоды в базу данных не выполнено!");
    }

    public void saveWeatherToDataBase(List<Weather> weatherList) throws SQLException {
        try (Connection connection = DriverManager.getConnection(DB_PATH)) {
            PreparedStatement saveWeather = connection.prepareStatement(insertWeather);
            for (Weather weather : weatherList) {
                saveWeather.setString(1, weather.getCity());
                saveWeather.setString(2, weather.getLocalDate());
                saveWeather.setString(3, weather.getWeatherText());
                saveWeather.setDouble(4, weather.getTemperature());
                saveWeather.addBatch();
            }
            saveWeather.executeBatch();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /*public List<Weather> getSavedToDBWeather() {
        List<Weather> weatherList = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(DB_PATH)) {
             Statement statement = connection.createStatement();
               ResultSet resultSet = statement.executeQuery(getWeather);
            //TODO: реализовать этот метод получения данных из таблицы погоды
            while (resultSet.next()) {
                System.out.print(resultSet.getString("city") + ",");
                System.out.print(resultSet.getString("localDate") + ",");
                System.out.print(resultSet.getString("weatherText") + ",");
                System.out.print(resultSet.getInt("temperature"));
                System.out.println();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return weatherList;
    }*/

    Alex Savin, [16.11.2021 9:25]
    public List<Weather> getSavedToDBWeather() {
        List<Weather> weatherList = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(DB_PATH)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(getWeather);
            while (resultSet.next()) {
                System.out.print(resultSet.getInt("id"));
                System.out.println(" ");
                System.out.print(resultSet.getString("city"));
                System.out.println(" ");
                System.out.print(resultSet.getString("localDate"));
                System.out.println(" ");
                System.out.print(resultSet.getString("weatherText"));
                System.out.println(" ");
                System.out.print(resultSet.getDouble("temperature"));
                System.out.println(" ");
                weatherList.add(new Weather(resultSet.getString("city"),
                        resultSet.getString("localDate"),
                        resultSet.getString("weatherText"),
                        resultSet.getDouble("temperature")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return weatherList;
    }

    public static void main(String[] args) throws SQLException {
        DataBaseRepository dataBaseRepository = new DataBaseRepository();

        dataBaseRepository.saveWeatherToDataBase(
                new Weather("Moscow", "11.12.2021", "Clear",0.3));

        System.out.println(dataBaseRepository.getSavedToDBWeather());
    }
}