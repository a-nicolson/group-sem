package com.napier.sem;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class AppTest
{
    App app = new App();

    // ---------- Single Reports ----------

    @Test
    void testCountryReport_Null()
    {
        app.countryReport(null);
    }

    @Test
    void testCountryReport_Normal()
    {
        Country c = new Country();
        c.countryCode = "JPN";
        c.countryName = "Japan";
        c.continent = "Asia";
        c.region = "Eastern Asia";
        c.population = 126714000;
        c.capitalID = 1532;
        app.countryReport(c);
    }

    @Test
    void testCityReport_Null()
    {
        app.cityReport(null);
    }

    @Test
    void testCityReport_Normal()
    {
        City city = new City();
        city.cityName = "Tokyo";
        city.countryCode = "JPN";
        city.district = "Tokyo-to";
        city.population = 7980230;
        app.cityReport(city);
    }

    // ---------- Countries by Population ----------

    @Test
    void testAllCountriesByPopulationReportDesc_Null()
    {
        app = new App() {
            public ArrayList<Country> allCountriesByPopulationDesc() { return null; }
        };
        app.allCountriesByPopulationReportDesc();
    }

    @Test
    void testAllCountriesByPopulationReportDesc_Empty()
    {
        app = new App() {
            public ArrayList<Country> allCountriesByPopulationDesc() { return new ArrayList<>(); }
        };
        app.allCountriesByPopulationReportDesc();
    }

    @Test
    void testAllCountriesByPopulationReportDesc_Normal()
    {
        app = new App() {
            public ArrayList<Country> allCountriesByPopulationDesc() {
                ArrayList<Country> list = new ArrayList<>();
                Country c = new Country();
                c.countryCode = "USA";
                c.countryName = "United States";
                c.continent = "North America";
                c.region = "North America";
                c.population = 278357000;
                c.capitalID = 3813;
                list.add(c);
                return list;
            }
        };
        app.allCountriesByPopulationReportDesc();
    }

    // ---------- Countries by Continent ----------

    @Test
    void testCountriesByPopulationContinentReport_Null()
    {
        app = new App() {
            public ArrayList<Country> getCountriesByPopulationContinent(String continent) { return null; }
        };
        app.countriesByPopulationContinentReport("Asia");
    }

    @Test
    void testCountriesByPopulationContinentReport_Normal()
    {
        app = new App() {
            public ArrayList<Country> getCountriesByPopulationContinent(String continent) {
                ArrayList<Country> list = new ArrayList<>();
                Country c = new Country();
                c.countryCode = "JPN";
                c.countryName = "Japan";
                c.continent = "Asia";
                c.region = "Eastern Asia";
                c.population = 126714000;
                c.capitalID = 1532;
                list.add(c);
                return list;
            }
        };
        app.countriesByPopulationContinentReport("Asia");
    }

    // ---------- Countries by Region ----------

    @Test
    void testCountriesByPopulationRegionReport_Null()
    {
        app = new App() {
            public ArrayList<Country> getCountriesByPopulationRegion(String region) { return null; }
        };
        app.countriesByPopulationRegionReport("Western Europe");
    }

    @Test
    void testCountriesByPopulationRegionReport_Normal()
    {
        app = new App() {
            public ArrayList<Country> getCountriesByPopulationRegion(String region) {
                ArrayList<Country> list = new ArrayList<>();
                Country c = new Country();
                c.countryCode = "FRA";
                c.countryName = "France";
                c.continent = "Europe";
                c.region = "Western Europe";
                c.population = 59225700;
                c.capitalID = 2974;
                list.add(c);
                return list;
            }
        };
        app.countriesByPopulationRegionReport("Western Europe");
    }

    // ---------- Cities ----------

    @Test
    void testAllCitiesByPopulationReport_Null()
    {
        app = new App() {
            public ArrayList<City> allCitiesByPopulation() { return null; }
        };
        app.allCitiesByPopulationReport();
    }

    @Test
    void testAllCitiesByPopulationReport_Normal()
    {
        app = new App() {
            public ArrayList<City> allCitiesByPopulation() {
                ArrayList<City> list = new ArrayList<>();
                City city = new City();
                city.cityName = "London";
                city.countryName = "United Kingdom";
                city.district = "England";
                city.population = 7285000;
                list.add(city);
                return list;
            }
        };
        app.allCitiesByPopulationReport();
    }

    @Test
    void testCitiesByPopulationContinentReport_Normal()
    {
        app = new App() {
            public ArrayList<City> citiesByPopulationContinent(String continent) {
                ArrayList<City> list = new ArrayList<>();
                City city = new City();
                city.cityName = "Tokyo";
                city.countryName = "Japan";
                city.district = "Tokyo-to";
                city.population = 7980230;
                list.add(city);
                return list;
            }
        };
        app.citiesByPopulationContinentReport("Asia");
    }

    @Test
    void testCitiesByPopulationRegionReport_Normal()
    {
        app = new App() {
            public ArrayList<City> citiesByPopulationRegion(String region) {
                ArrayList<City> list = new ArrayList<>();
                City city = new City();
                city.cityName = "Paris";
                city.countryName = "France";
                city.district = "Île-de-France";
                city.population = 2125246;
                list.add(city);
                return list;
            }
        };
        app.citiesByPopulationRegionReport("Western Europe");
    }

    @Test
    void testCitiesByPopulationCountryReport_Normal()
    {
        app = new App() {
            public ArrayList<City> citiesByPopulationCountry(String country) {
                ArrayList<City> list = new ArrayList<>();
                City city = new City();
                city.cityName = "Brasília";
                city.countryName = "Brazil";
                city.district = "Distrito Federal";
                city.population = 1969868;
                list.add(city);
                return list;
            }
        };
        app.citiesByPopulationCountryReport("Brazil");
    }

    // ---------- Capitals ----------

    @Test
    void testCapitalsByPopulationReport_Normal()
    {
        app = new App() {
            public ArrayList<City> capitalsByPopulation() {
                ArrayList<City> list = new ArrayList<>();
                City city = new City();
                city.cityName = "Tokyo";
                city.countryName = "Japan";
                city.population = 7980230;
                list.add(city);
                return list;
            }
        };
        app.capitalsByPopulationReport();
    }

    @Test
    void testCapitalsByPopulationContinentReport_Normal()
    {
        app = new App() {
            public ArrayList<City> capitalsByPopulationContinent(String continent) {
                ArrayList<City> list = new ArrayList<>();
                City city = new City();
                city.cityName = "Tokyo";
                city.countryName = "Japan";
                city.population = 7980230;
                list.add(city);
                return list;
            }
        };
        app.capitalsByPopulationContinentReport("Asia");
    }

    @Test
    void testCapitalsByPopulationRegionReport_Normal()
    {
        app = new App() {
            public ArrayList<City> capitalsByPopulationRegion(String region) {
                ArrayList<City> list = new ArrayList<>();
                City city = new City();
                city.cityName = "Paris";
                city.countryName = "France";
                city.population = 2125246;
                list.add(city);
                return list;
            }
        };
        app.capitalsByPopulationRegionReport("Western Europe");
    }
}
