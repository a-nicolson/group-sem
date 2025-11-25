/**package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AppIntegrationTest {

    static App app;

    @BeforeAll
    static void init() {
        app = new App();
        app.connect("localhost:33060", 30000);
    }

    @AfterAll
    static void cleanup() {
        app.disconnect();
    }

    @Test
    void testGetCity() {
        City city = app.getCity("London");
        assertNotNull(city);
        assertEquals("London", city.cityName);
        assertEquals("GBR", city.countryCode);
    }

    @Test
    void testGetCountry() {
        Country country = app.getCountry("Brazil");
        assertNotNull(country);
        assertEquals("Brazil", country.countryName);
        assertEquals("BRA", country.countryCode);
    }

    @Test
    void testCountriesByPopulationContinent() {
        ArrayList<Country> countries = app.getCountriesByPopulationContinent("Oceania");
        assertNotNull(countries);
        assertTrue(countries.size() > 0);
    }
}
**/