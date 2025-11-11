package com.napier.sem;

import org.junit.jupiter.api.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest
{
    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
    }

    // ---- City Report Tests ----

    @Test
    void testCityReport_Null()
    {
        assertDoesNotThrow(() -> app.cityReport(null)); // city null
    }

    @Test
    void testCityReport_EmptyList()
    {
        ArrayList<City> cities = new ArrayList<>(); // empty list
        for (City city : cities)
            app.cityReport(city);
        assertTrue(cities.isEmpty());
    }

    @Test
    void testCityReport_ListContainsNull()
    {
        ArrayList<City> cities = new ArrayList<>();
        cities.add(null); // contains null
        for (City city : cities)
            assertDoesNotThrow(() -> app.cityReport(city));
    }

    @Test
    void testCityReport_Valid()
    {
        City city = new City();
        city.cityName = "Tokyo";
        city.countryCode = "JPN";
        city.district = "Tokyo-to";
        city.population = 13929286;

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        app.cityReport(city);
        String output = out.toString().trim();

        assertTrue(output.contains("Tokyo"));
        assertTrue(output.contains("JPN"));
        assertTrue(output.contains("13929286"));
    }

    // ---- Country Report Tests ----

    @Test
    void testCountryReport_Null()
    {
        assertDoesNotThrow(() -> app.countryReport(null)); // country null
    }

    @Test
    void testCountryReport_EmptyList()
    {
        ArrayList<Country> countries = new ArrayList<>(); // empty list
        for (Country c : countries)
            app.countryReport(c);
        assertTrue(countries.isEmpty());
    }

    @Test
    void testCountryReport_ListContainsNull()
    {
        ArrayList<Country> countries = new ArrayList<>();
        countries.add(null); // contains null
        for (Country c : countries)
            assertDoesNotThrow(() -> app.countryReport(c));
    }

    @Test
    void testCountryReport_Valid()
    {
        Country country = new Country();
        country.countryCode = "JPN";
        country.countryName = "Japan";
        country.continent = "Asia";
        country.region = "East Asia";
        country.population = 125000000;
        country.capitalID = 3793;

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        app.countryReport(country);
        String output = out.toString().trim();

        assertTrue(output.contains("Japan"));
        assertTrue(output.contains("Asia"));
        assertTrue(output.contains("125000000"));
    }
}
