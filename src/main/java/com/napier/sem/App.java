package com.napier.sem;

import java.sql.*;
import java.util.ArrayList;

public class App
{
    /**
     * Connection to MySQL database.
     */
    private Connection con = null;

    /**
     * Connect to the MySQL database.
     */
    public void connect()
    {
        try
        {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i)
        {
            System.out.println("Connecting to database...");
            try
            {
                // Wait a bit for db to start
                Thread.sleep(30000);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://db:3306/world?allowPublicKeyRetrieval=true&useSSL=false", "root", "example");
                System.out.println("Successfully connected");
                break;
            }
            catch (SQLException sqle)
            {
                System.out.println("Failed to connect to database attempt " + Integer.toString(i));
                System.out.println(sqle.getMessage());
            }
            catch (InterruptedException ie)
            {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }

    /**
     * Disconnect from the MySQL database.
     */
    public void disconnect()
    {
        if (con != null)
        {
            try
            {
                // Close connection
                con.close();
            }
            catch (Exception e)
            {
                System.out.println("Error closing connection to database");
            }
        }
    }

    /**
     * Produces an ArrayList of countries
     * ordered by populution descending
     */
    public ArrayList<Country> allCountriesByPopulationDesc()
    {
       try
       {
           Statement stmt = con.createStatement();

           String strSelect =
                   "SELECT Code, Name, Continent, Region, Population, Capital "
                   + "FROM country "
                   + "ORDER BY Population DESC";

           ResultSet rset = stmt.executeQuery(strSelect);

           ArrayList<Country> countries = new ArrayList<Country>();
           while(rset.next())
           {
               Country country = new Country();
               country.countryCode = rset.getString("Code");
               country.countryName = rset.getString("Name");
               country.continent = rset.getString("Continent");
               country.region = rset.getString("Region");
               country.population = rset.getInt("Population");
               country.capitalID = rset.getInt("Capital");
               countries.add(country);
           }
           return countries;
       }
       catch (Exception e)
       {
           System.out.println(e.getMessage());
           System.out.println("Failed to fetch countries");
           return null;
       }
    }

    /**
     *  Takes an ArrayList of countries sorted by population
     *  descending and produces a report
     */
    public void allCountriesByPopulationReportDesc()
    {
            ArrayList<Country> countries = allCountriesByPopulationDesc();

            if (countries == null || countries.isEmpty()) {
                System.out.println("No countries found.");
                return;
            }


        for(Country country : allCountriesByPopulationDesc())
        {
           System.out.println(
                   country.countryCode + " "
                   + country.countryName + " "
                   + country.continent + " "
                   + country.region + " "
                   + country.population + " ");

       }
   }

    /**
     *  Produces a report on a given country
     */
   public void countryReport(Country country)
   {
       if (country != null)
       {
           System.out.println(
                   country.countryCode + " "
                    + country.countryName + " "
                    + country.continent + " "
                    + country.region + " "
                    + country.population + " "
                    + country.capitalID);
       }
       else
       {
           System.out.println("Country is null");
       }
   }

    /**
     * Produces a city report taking a city as a parameter
     */
    public void cityReport(City city)
    {
        if (city != null)
        {
            System.out.println(
                    city.cityName + " "
                    + city.countryCode + " "
                    + city.district + " "
                    + city.population);
        }
        else
        {
            System.out.println("City is null");
        }
    }

    /**
     *
     * Creates city object using the cityName parameter to search
     */
    public City getCity(String cityName)
    {
        try
        {
            Statement stmt = con.createStatement();

            String strSelect =
                    "SELECT ID, Name, CountryCode, District, Population "
                    + "FROM city "
                    + "WHERE Name = '" + cityName + "';";

            ResultSet rset = stmt.executeQuery(strSelect);

            if (rset.next())
            {
                City city = new City();
                city.cityID = rset.getInt("ID");
                city.cityName = rset.getString("Name");
                city.countryCode = rset.getString("CountryCode");
                city.district = rset.getString("District");
                city.population = rset.getInt("Population");
                return city;
            }
            else
                return null;
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city " + cityName);
            return null;
        }
    }

    /**
     * Creates country object using countryName to search
     */
    public Country getCountry(String countryName)
    {
        try
        {
            Statement stmt = con.createStatement();

            String strSelect =
                    "SELECT Code, Name, Continent, Region, Population, Capital "
                    + "FROM country "
                    + "WHERE Name = '" + countryName + "';";

            ResultSet rset = stmt.executeQuery(strSelect);

            if (rset.next())
            {
                Country country = new Country();
                country.countryCode = rset.getString("Code");
                country.countryName = rset.getString("Name");
                country.continent = rset.getString("Continent");
                country.region = rset.getString("Region");
                country.population = rset.getInt("Population");
                country.capitalID = rset.getInt("Capital");
                return country;
            }
            else
                return null;
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country " + countryName);
            return null;
        }
    }

    /**
     * All the countries in a continent organised by largest to smallest population
     */
    public ArrayList<Country> getCountriesByPopulationContinent(String continent) {
        try
        {
            Statement stmt = con.createStatement();

            String strSelect =
                    "SELECT Code, Name, Continent, Region, Population, Capital "
                            + "FROM country "
                            + "WHERE Continent = '" + continent + "' "
                            + "ORDER BY Population DESC";

            ResultSet rset = stmt.executeQuery(strSelect);

            ArrayList<Country> countries = new ArrayList<Country>();
            while (rset.next())
            {
                Country country = new Country();
                country.countryCode = rset.getString("Code");
                country.countryName = rset.getString("Name");
                country.continent = rset.getString("Continent");
                country.region = rset.getString("Region");
                country.population = rset.getInt("Population");
                country.capitalID = rset.getInt("Capital");
                countries.add(country);
            }
            return countries;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to fetch countries in continent: " + continent);
            return null;
        }
    }

    /**
     *  Given the name of a continent, produces
     *  a report on the population of the countries in the continents
     */
    public void countriesByPopulationContinentReport(String continent)
    {
        ArrayList<Country> countries = getCountriesByPopulationContinent(continent);
        if (countries == null || countries.isEmpty()) {
            System.out.println("No countries found.");
            return;
        }

        for(Country country : getCountriesByPopulationContinent(continent)) {
            System.out.println(
                    country.countryCode + " "
                            + country.countryName + " "
                            + country.continent + " "
                            + country.region + " "
                            + country.population + " "
                            + country.capitalID);
        }
    }

    /**
     *  Fetches the countries within a given region,
     *  ordered by population descending
     */
    public ArrayList<Country> getCountriesByPopulationRegion(String region)
    {
        try
        {
            Statement stmt = con.createStatement();

            String strSelect =
                    "SELECT Code, Name, Continent, Region, Population, Capital "
                            + "FROM country "
                            + "WHERE Region = '" + region + "' "
                            + "ORDER BY Population DESC";

            ResultSet rset = stmt.executeQuery(strSelect);

            ArrayList<Country> countries = new ArrayList<Country>();
            while (rset.next())
            {
                Country country = new Country();
                country.countryCode = rset.getString("Code");
                country.countryName = rset.getString("Name");
                country.continent = rset.getString("Continent");
                country.region = rset.getString("Region");
                country.population = rset.getInt("Population");
                country.capitalID = rset.getInt("Capital");
                countries.add(country);
            }
            return countries;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to fetch countries in region: " + region);
            return null;
        }
    }

    /**
     *  Given the name of a region,
     *  produces a report on the countries within the region,
     *  ordered by population descending
     */
    public void countriesByPopulationRegionReport(String region)
    {
        ArrayList<Country> countries = getCountriesByPopulationRegion(region);
        if (countries != null)
        {
            for (Country country : countries)
            {
                System.out.println(
                        country.countryCode + " "
                                + country.countryName + " "
                                + country.continent + " "
                                + country.region + " "
                                + country.population + " "
                                + country.capitalID);
            }
        }
        else
        {
            System.out.println("No countries found in region: " + region);
        }
    }

    /**
     *  Fetches an ArrayList of all countries ordered by population descending
     */
    public ArrayList<Country> allCountriesByPopulationDesc(int n)
    {
        try
        {
            Statement stmt = con.createStatement();

            String strSelect =
                    "SELECT Code, Name, Continent, Region, Population, Capital "
                            + "FROM country "
                            + "ORDER BY Population DESC"
                            + " LIMIT " + n + ";";

            ResultSet rset = stmt.executeQuery(strSelect);

            ArrayList<Country> countries = new ArrayList<Country>();
            while(rset.next())
            {
                Country country = new Country();
                country.countryCode = rset.getString("Code");
                country.countryName = rset.getString("Name");
                country.continent = rset.getString("Continent");
                country.region = rset.getString("Region");
                country.population = rset.getInt("Population");
                country.capitalID = rset.getInt("Capital");
                countries.add(country);
            }
            return countries;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to fetch countries");
            return null;
        }
    }

    /**
     *  Produces a report of all countries ordered by population descending
     */
    public void allCountriesByPopulationReportDesc(int n)
    {
        for(Country country : allCountriesByPopulationDesc(n))
        {
            System.out.println(
                    country.countryCode + " "
                            + country.countryName + " "
                            + country.continent + " "
                            + country.region + " "
                            + country.population + " ");
        }
    }

    /**
     * Gets the top N populated countries in a continent where N is specified by the user
     */
    public ArrayList<Country> getCountriesByPopulationContinent(String continent, int n)
    {
        try
        {
            Statement stmt = con.createStatement();

            String strSelect =
                    "SELECT Code, Name, Continent, Region, Population, Capital "
                            + "FROM country "
                            + "WHERE Continent = '" + continent + "' "
                            + "ORDER BY Population DESC"
                            + " LIMIT " + n + ";";

            ResultSet rset = stmt.executeQuery(strSelect);

            ArrayList<Country> countries = new ArrayList<Country>();
            while(rset.next())
            {
                Country country = new Country();
                country.countryCode = rset.getString("Code");
                country.countryName = rset.getString("Name");
                country.continent = rset.getString("Continent");
                country.region = rset.getString("Region");
                country.population = rset.getInt("Population");
                country.capitalID = rset.getInt("Capital");
                countries.add(country);
            }
            return countries;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to fetch countries");
            return null;
        }
    }

    /**
     * Print report of top N populated countries in a continent
     */
    public void countriesByPopulationContinentReport(String continent, int n)
    {
        for(Country country : getCountriesByPopulationContinent(continent, n)) {
            System.out.println(
                    country.countryCode + " "
                            + country.countryName + " "
                            + country.continent + " "
                            + country.region + " "
                            + country.population + " "
                            + country.capitalID);
        }
    }

    /**
     * Gets top N populated countries in a region
     */
    public ArrayList<Country> getCountriesByPopulationRegion(String region, int n)
    {
        try
        {
            Statement stmt = con.createStatement();

            String strSelect =
                    "SELECT Code, Name, Continent, Region, Population, Capital "
                            + "FROM country "
                            + "WHERE Region = '" + region + "' "
                            + "ORDER BY Population DESC"
                            + " LIMIT " + n + ";";

            ResultSet rset = stmt.executeQuery(strSelect);

            ArrayList<Country> countries = new ArrayList<Country>();
            while(rset.next())
            {
                Country country = new Country();
                country.countryCode = rset.getString("Code");
                country.countryName = rset.getString("Name");
                country.continent = rset.getString("Continent");
                country.region = rset.getString("Region");
                country.population = rset.getInt("Population");
                country.capitalID = rset.getInt("Capital");
                countries.add(country);
            }
            return countries;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to fetch countries");
            return null;
        }
    }

    /**
     * Prints report for top N countries in a region where N is provided by the user
     */
    public void countriesByPopulationRegionReport(String region, int n)
    {
        for(Country country : getCountriesByPopulationRegion(region, n)) {
            System.out.println(
                    country.countryCode + " "
                            + country.countryName + " "
                            + country.continent + " "
                            + country.region + " "
                            + country.population + " "
                            + country.capitalID);
        }
    }

    /**
     * Gets cities and sorts them by population
     */
    public ArrayList<City> allCitiesByPopulation()
    {

        try
        {
            Statement stmt = con.createStatement();

            String strSelect =
                    "SELECT city.ID, city.Name AS CityName, country.Name AS CountryName, city.District, city.Population "
                            + "FROM city "
                            + "JOIN country ON city.CountryCode = country.Code "
                            + "ORDER BY city.Population DESC;";

            ResultSet rset = stmt.executeQuery(strSelect);

            ArrayList<City> cities = new ArrayList<City>();
            while (rset.next())
            {
                City city = new City();
                city.cityID = rset.getInt("ID");
                city.cityName = rset.getString("CityName");
                city.countryName = rset.getString("CountryName");
                city.district = rset.getString("District");
                city.population = rset.getInt("Population");
                cities.add(city);
            }
            return cities;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     *  Produces a report for all cities sorted by population descending
     */
    public void allCitiesByPopulationReport()
    {
        ArrayList<City> cities = allCitiesByPopulation();
        if (cities != null)
        {
            for (City city : cities)
            {
                System.out.println(
                        city.cityName + " " +
                                city.countryName + " " +
                                city.district + " " +
                                city.population);
            }
        }
        else
        {
            System.out.println("No cities found.");
        }
    }

    /**
     *  Fetches all cities in order of population descending
     */
    public ArrayList<City> citiesByPopulationContinent(String continent)
    {
        try
        {
            Statement stmt = con.createStatement();

            String strSelect =
                    "SELECT city.ID, city.Name AS CityName, country.Name AS CountryName, city.District, city.Population "
                            + "FROM city "
                            + "JOIN country ON city.CountryCode = country.Code "
                            + "WHERE country.Continent = '" + continent + "' "
                            + "ORDER BY city.Population DESC;";

            ResultSet rset = stmt.executeQuery(strSelect);

            ArrayList<City> cities = new ArrayList<City>();
            while (rset.next())
            {
                City city = new City();
                city.cityID = rset.getInt("ID");
                city.cityName = rset.getString("CityName");
                city.countryName = rset.getString("CountryName");
                city.district = rset.getString("District");
                city.population = rset.getInt("Population");
                cities.add(city);
            }
            return cities;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     *  Produces a report for all cities in a continent,
     *  in order of population descending
     */
    public void citiesByPopulationContinentReport(String continent)
    {
        for(City city : citiesByPopulationContinent(continent)) {
            System.out.println(
                    city.cityName + " " + city.countryName + " "
                    + city.district + " " + city.population);
        }
    }

    /**
     *  Fetches cities in a region, ordered by population descending
     */
    public ArrayList<City> citiesByPopulationRegion(String region)
    {
        try
        {
            Statement stmt = con.createStatement();

            String strSelect =
                    "SELECT city.ID, city.Name AS CityName, country.Name AS CountryName, city.District, city.Population "
                            + "FROM city "
                            + "JOIN country ON city.CountryCode = country.Code "
                            + "WHERE country.Region = '" + region + "' "
                            + "ORDER BY city.Population DESC;";

            ResultSet rset = stmt.executeQuery(strSelect);

            ArrayList<City> cities = new ArrayList<City>();
            while (rset.next())
            {
                City city = new City();
                city.cityID = rset.getInt("ID");
                city.cityName = rset.getString("CityName");
                city.countryName = rset.getString("CountryName");
                city.district = rset.getString("District");
                city.population = rset.getInt("Population");
                cities.add(city);
            }
            return cities;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     *  Produces a report for each city in a region,
     *  ordered by population descending
     */
    public void citiesByPopulationRegionReport(String region)
    {
        for(City city : citiesByPopulationRegion(region)) {
            System.out.println(
                    city.cityName + " " + city.countryName + " "
                            + city.district + " " + city.population);
        }
    }

    /**
     *  Fetches cities in a country, ordered by population descending
     */
    public ArrayList<City> citiesByPopulationCountry(String country)
    {
        try
        {
            Statement stmt = con.createStatement();

            String strSelect =
                    "SELECT city.ID , city.Name AS CityName, country.Name AS CountryName, city.District, city.Population "
                    + "FROM city "
                    + "JOIN country ON city.CountryCode = country.Code "
                    + "WHERE country.Name = '" + country + "' "
                    + "ORDER BY city.Population DESC;";
            ResultSet rset = stmt.executeQuery(strSelect);

            ArrayList<City> cities = new ArrayList<City>();
            while (rset.next())
            {
                City city = new City();
                city.cityID = rset.getInt("ID");
                city.cityName = rset.getString("CityName");
                city.countryName = rset.getString("CountryName");
                city.district = rset.getString("District");
                city.population = rset.getInt("Population");
                cities.add(city);
            }
            return cities;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     *  Produces a report for each city in a country,
     *  ordered by population descending
     */
    public void citiesByPopulationCountryReport(String country)
    {
        for(City city : citiesByPopulationCountry(country))
        {
            System.out.println(
                    city.cityName + " " + city.countryName + " "
                    + city.district + " " + city.population);
        }
    }

    /**
     *  Fetches all cities in a district, ordered by population descending
     */
    public ArrayList<City> citiesByPopulationDistrict(String district)
    {
        try
        {
            Statement stmt = con.createStatement();

            String strSelect =
                    "SELECT city.ID , city.Name AS CityName, country.Name AS CountryName, city.District, city.Population "
                            + "FROM city "
                            + "JOIN country ON city.CountryCode = country.Code "
                            + "WHERE city.District = '" + district + "' "
                            + "ORDER BY city.Population DESC;";
            ResultSet rset = stmt.executeQuery(strSelect);

            ArrayList<City> cities = new ArrayList<City>();
            while (rset.next())
            {
                City city = new City();
                city.cityID = rset.getInt("ID");
                city.cityName = rset.getString("CityName");
                city.countryName = rset.getString("CountryName");
                city.district = rset.getString("District");
                city.population = rset.getInt("Population");
                cities.add(city);
            }
            return cities;
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     *  Produces a report for all cities in a district,
     *  ordered by population descending
     */
    public void citiesByPopulationDistrictReport(String district)
    {
        for(City city : citiesByPopulationDistrict(district))
        {
            System.out.println(
                    city.cityName + " " + city.countryName + " "
                            + city.district + " " + city.population);
        }
    }

    /**
     *  Fetches top n cities, ordered by population descending
     */
    public ArrayList<City> allCitiesByPopulation(int n)
    {
        try
        {
            Statement stmt = con.createStatement();

            String strSelect =
                    "SELECT city.ID, city.Name AS CityName, country.Name AS CountryName, city.District, city.Population "
                            + "FROM city "
                            + "JOIN country ON city.CountryCode = country.Code "
                            + "ORDER BY city.Population DESC"
                            + " LIMIT " + n + ";";

            ResultSet rset = stmt.executeQuery(strSelect);

            ArrayList<City> cities = new ArrayList<City>();
            while (rset.next())
            {
                City city = new City();
                city.cityID = rset.getInt("ID");
                city.cityName = rset.getString("CityName");
                city.countryName = rset.getString("CountryName");
                city.district = rset.getString("District");
                city.population = rset.getInt("Population");
                cities.add(city);
            }
            return cities;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     *  Produces a report for the top n cities,
     *  ordered by population descending
     */
    public void allCitiesByPopulationReport(int n)
    {
        for(City city : allCitiesByPopulation(n))
        {
            System.out.println(
                    city.cityName + " " + city.countryName + " "
                            + city.district + " " + city.population);
        }
    }

    /**
     *  Fetches top n cities in a continent, ordered by population descending
     */
    public ArrayList<City> citiesByPopulationContinent(String continent, int n)
    {
        try
        {
            Statement stmt = con.createStatement();

            String strSelect =
                    "SELECT city.ID, city.Name AS CityName, country.Name AS CountryName, city.District, city.Population "
                            + "FROM city "
                            + "JOIN country ON city.CountryCode = country.Code "
                            + "WHERE country.Continent = '" + continent + "' "
                            + "ORDER BY city.Population DESC"
                            + " LIMIT " + n + ";";

            ResultSet rset = stmt.executeQuery(strSelect);

            ArrayList<City> cities = new ArrayList<City>();
            while (rset.next())
            {
                City city = new City();
                city.cityID = rset.getInt("ID");
                city.cityName = rset.getString("CityName");
                city.countryName = rset.getString("CountryName");
                city.district = rset.getString("District");
                city.population = rset.getInt("Population");
                cities.add(city);
            }
            return cities;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     *  Produces a report for top n cities in a continent,
     *  ordered by population descending
     */
    public void citiesByPopulationContinentReport(String continent, int n)
    {
        for(City city : citiesByPopulationContinent(continent, n)) {
            System.out.println(
                    city.cityName + " " + city.countryName + " "
                            + city.district + " " + city.population);
        }
    }

    /**
     *  Fetches n cities in a region, ordered by population descending
     */
    public ArrayList<City> citiesByPopulationRegion(String region, int n)
    {
        try
        {
            Statement stmt = con.createStatement();

            String strSelect =
                    "SELECT city.ID, city.Name AS CityName, country.Name AS CountryName, city.District, city.Population "
                            + "FROM city "
                            + "JOIN country ON city.CountryCode = country.Code "
                            + "WHERE country.Region = '" + region + "' "
                            + "ORDER BY city.Population DESC"
                            +  " LIMIT " + n + ";";

            ResultSet rset = stmt.executeQuery(strSelect);

            ArrayList<City> cities = new ArrayList<City>();
            while (rset.next())
            {
                City city = new City();
                city.cityID = rset.getInt("ID");
                city.cityName = rset.getString("CityName");
                city.countryName = rset.getString("CountryName");
                city.district = rset.getString("District");
                city.population = rset.getInt("Population");
                cities.add(city);
            }
            return cities;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     *  Produces a report for n cities in a region,
     *  ordered by population descending
     */
    public void citiesByPopulationRegionReport(String region, int n)
    {
        for(City city : citiesByPopulationRegion(region, n)) {
            System.out.println(
                    city.cityName + " " + city.countryName + " "
                            + city.district + " " + city.population);
        }
    }

    /**
     *  Fetches top n cities in a country, ordered by population descending
     */
    public ArrayList<City> citiesByPopulationCountry(String country, int n)
    {
        try
        {
            Statement stmt = con.createStatement();

            String strSelect =
                    "SELECT city.ID , city.Name AS CityName, country.Name AS CountryName, city.District, city.Population "
                            + "FROM city "
                            + "JOIN country ON city.CountryCode = country.Code "
                            + "WHERE country.Name = '" + country + "' "
                            + "ORDER BY city.Population DESC"
                            + " LIMIT " + n + ";";
            ResultSet rset = stmt.executeQuery(strSelect);

            ArrayList<City> cities = new ArrayList<City>();
            while (rset.next())
            {
                City city = new City();
                city.cityID = rset.getInt("ID");
                city.cityName = rset.getString("CityName");
                city.countryName = rset.getString("CountryName");
                city.district = rset.getString("District");
                city.population = rset.getInt("Population");
                cities.add(city);
            }
            return cities;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     *  Produces a report on top n cities in a country,
     *  ordered by population descending
     */
    public void citiesByPopulationCountryReport(String country, int n)
    {
        for(City city : citiesByPopulationCountry(country, n))
        {
            System.out.println(
                    city.cityName + " " + city.countryName + " "
                            + city.district + " " + city.population);
        }
    }

    public ArrayList<City> citiesByPopulationDistrict(String district, int n)
    {
        try
        {
            Statement stmt = con.createStatement();

            String strSelect =
                    "SELECT city.ID , city.Name AS CityName, country.Name AS CountryName, city.District, city.Population "
                            + "FROM city "
                            + "JOIN country ON city.CountryCode = country.Code "
                            + "WHERE city.District = '" + district + "' "
                            + "ORDER BY city.Population DESC"
                            + " LIMIT " + n + ";";
            ResultSet rset = stmt.executeQuery(strSelect);

            ArrayList<City> cities = new ArrayList<City>();
            while (rset.next())
            {
                City city = new City();
                city.cityID = rset.getInt("ID");
                city.cityName = rset.getString("CityName");
                city.countryName = rset.getString("CountryName");
                city.district = rset.getString("District");
                city.population = rset.getInt("Population");
                cities.add(city);
            }
            return cities;
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void citiesByPopulationDistrictReport(String district, int n)
    {
        for(City city : citiesByPopulationDistrict(district, n))
        {
            System.out.println(
                    city.cityName + " " + city.countryName + " "
                            + city.district + " " + city.population);
        }
    }

    public ArrayList<City> capitalsByPopulation() {
        try {
            Statement stmt = con.createStatement();
            String strSelect =
                    "SELECT city.ID, city.Name AS CityName, country.Name AS CountryName, city.Population"
                            + " FROM city "
                            + "JOIN country ON city.ID = country.Capital "
                            + " ORDER BY city.Population DESC;";

            ResultSet rset = stmt.executeQuery(strSelect);
            ArrayList<City> capitals = new ArrayList<>();
            while (rset.next()) {
                City city = new City();
                city.cityID = rset.getInt("ID");
                city.cityName = rset.getString("CityName");
                city.countryName = rset.getString("CountryName");
                city.population = rset.getInt("Population");
                capitals.add(city);
            }
            return capitals;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void capitalsByPopulationReport()
    {
        for(City city : capitalsByPopulation())
        {
            System.out.println(city.cityName + " " + city.countryName + " "
            + city.population);
        }
    }

    public ArrayList<City> capitalsByPopulationContinent(String continent)
    {
        try {
            Statement stmt = con.createStatement();
            String strSelect =
                    "SELECT city.ID, city.Name AS CityName, country.Name AS CountryName, city.Population "
                            + "FROM city "
                            + "JOIN country ON city.ID = country.Capital "
                            + "WHERE country.Continent = '" + continent + "' "
                            + "ORDER BY city.Population DESC;";
            ResultSet rset = stmt.executeQuery(strSelect);
            ArrayList<City> capitals = new ArrayList<>();
            while (rset.next()) {
                City city = new City();
                city.cityID = rset.getInt("ID");
                city.cityName = rset.getString("CityName");
                city.countryName = rset.getString("CountryName");
                city.population = rset.getInt("Population");
                capitals.add(city);
            }
            return capitals;
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void capitalsByPopulationContinentReport(String continent)
    {
        for(City city : capitalsByPopulationContinent(continent))
        {
            System.out.println(city.cityName + " " + city.countryName + " "
            + city.population);
        }
    }

    public ArrayList<City> capitalsByPopulationRegion(String region)
    {
        try {
            Statement stmt = con.createStatement();
            String strSelect =
                    "SELECT city.ID, city.Name AS CityName, country.Name AS CountryName, city.Population "
                            + "FROM city "
                            + "JOIN country ON city.ID = country.Capital "
                            + "WHERE country.Region = '" + region + "' "
                            + "ORDER BY city.Population DESC;";
            ResultSet rset = stmt.executeQuery(strSelect);
            ArrayList<City> capitals = new ArrayList<>();
            while (rset.next()) {
                City city = new City();
                city.cityID = rset.getInt("ID");
                city.cityName = rset.getString("CityName");
                city.countryName = rset.getString("CountryName");
                city.population = rset.getInt("Population");
                capitals.add(city);
            }
            return capitals;
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void capitalsByPopulationRegionReport(String region)
    {
        for(City city : capitalsByPopulationRegion(region))
        {
            System.out.println(city.cityName + " " + city.countryName + " "
                    + city.population);
        }
    }

    public ArrayList<City> allCapitalsByPopulation(int n) {
        try {
            Statement stmt = con.createStatement();
            String strSelect =
                    "SELECT city.ID, city.Name AS CityName, country.Name AS CountryName, city.Population " +
                            "FROM city " +
                            "JOIN country ON city.ID = country.Capital " +
                            "ORDER BY city.Population DESC " +
                            "LIMIT " + n + ";";
            ResultSet rset = stmt.executeQuery(strSelect);

            ArrayList<City> capitals = new ArrayList<>();
            while (rset.next()) {
                City city = new City();
                city.cityID = rset.getInt("ID");
                city.cityName = rset.getString("CityName");
                city.countryName = rset.getString("CountryName");
                city.population = rset.getInt("Population");
                capitals.add(city);
            }
            return capitals;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void allCapitalsByPopulationReport(int n)
    {
        for (City city : allCapitalsByPopulation(n))
        {
            System.out.println(city.cityName + " " + city.countryName + " " + city.population);
        }
    }

    public ArrayList<City> capitalsContinent(String continent, int n)
    {
        try
        {
            Statement stmt = con.createStatement();
            String strSelect =
                    "SELECT city.ID, city.Name AS CityName, country.Name AS CountryName, city.Population " +
                            "FROM city " +
                            "JOIN country ON city.ID = country.Capital " +
                            "WHERE country.Continent = '" + continent + "' " +
                            "ORDER BY city.Population DESC " +
                            "LIMIT " + n + ";";
            ResultSet rset = stmt.executeQuery(strSelect);

            ArrayList<City> capitals = new ArrayList<>();
            while (rset.next())
            {
                City city = new City();
                city.cityID = rset.getInt("ID");
                city.cityName = rset.getString("CityName");
                city.countryName = rset.getString("CountryName");
                city.population = rset.getInt("Population");
                capitals.add(city);
            }
            return capitals;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void capitalsContinentReport(String continent, int n)
    {
        for (City city : capitalsContinent(continent, n))
        {
            System.out.println(city.cityName + " " + city.countryName + " " + city.population);
        }
    }

    public ArrayList<City> capitalCitiesByRegion(String region, int n)
    {
        try
        {
            Statement stmt = con.createStatement();
            String strSelect =
                    "SELECT city.ID, city.Name AS CityName, country.Name AS CountryName, city.Population " +
                            "FROM city " +
                            "JOIN country ON city.ID = country.Capital " +
                            "WHERE country.Region = '" + region + "' " +
                            "ORDER BY city.Population DESC " +
                            "LIMIT " + n + ";";
            ResultSet rset = stmt.executeQuery(strSelect);

            ArrayList<City> capitals = new ArrayList<>();
            while (rset.next())
            {
                City city = new City();
                city.cityID = rset.getInt("ID");
                city.cityName = rset.getString("CityName");
                city.countryName = rset.getString("CountryName");
                city.population = rset.getInt("Population");
                capitals.add(city);
            }
            return capitals;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void capitalCitiesByRegionReport(String region, int n)
    {
        for (City city : capitalCitiesByRegion(region, n))
        {
            System.out.println(city.cityName + " " + city.countryName + " " + city.population);
        }
    }






    public static void main(String[] args)
    {
        App a = new App();

        a.connect();


        a.allCapitalsByPopulationReport(4);
        a.capitalsContinentReport("North America", 4);
        a.capitalCitiesByRegionReport("Middle East", 4);

        a.disconnect();

        try
        {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }
    }
}