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

    public ArrayList<Country> allCountriesByPopulationDesc()
    {
       try {
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

       public void allCountriesByPopulationReportDesc()
       {
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

       public ArrayList<Country> allCountriesByPopulationAsc()
       {
           try {
               Statement stmt = con.createStatement();

               String strSelect =
                       "SELECT Code, Name, Continent, Region, Population, Capital "
                               + "FROM country "
                               + "ORDER BY Population ASC";

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

    public void allCountriesByPopulationReportAsc()
    {
        for(Country country : allCountriesByPopulationAsc())
        {
            System.out.println(
                    country.countryCode + " "
                            + country.countryName + " "
                            + country.continent + " "
                            + country.region + " "
                            + country.population + " ");

        }

    }


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
     *
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
     *
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
/*
    public String languageReport()
    {
        return report;
    }
*/

    /**
     *
     * All the countries in a continent organised by largest to smallest population
     */
    public ArrayList<Country> getCountriesByPopulationContinent(String continent) {
        try {
            Statement stmt = con.createStatement();

            String strSelect =
                    "SELECT Code, Name, Continent, Region, Population, Capital "
                            + "FROM country "
                            + "WHERE Continent = '" + continent + "' "
                            + "ORDER BY Population DESC";

            ResultSet rset = stmt.executeQuery(strSelect);

            ArrayList<Country> countries = new ArrayList<Country>();
            while (rset.next()) {
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
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to fetch countries in continent: " + continent);
            return null;
        }
    }

    public void countriesByPopulationContinentReport(String continent)
    {
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


    public static void main(String[] args)
    {
        App a = new App();

        a.connect();

        City city = a.getCity("London");
        a.cityReport(city);

        Country country = a.getCountry("Brazil");
        a.countryReport(country);

        a.allCountriesByPopulationReportAsc();
        a.allCountriesByPopulationReportDesc();
        a.countriesByPopulationContinentReport("Oceania");

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