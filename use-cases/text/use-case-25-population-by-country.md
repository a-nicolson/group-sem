# USE CASE 25: Population of people, people living in cities, and people not living in cities in each country
## CHARACTERISTIC INFORMATION
### Goal in context
Generate a population report for each country showing the total population, the number of people living in cities, and the number of people not living in cities (including percentages) so that users can understand national urbanisation trends and demographic structures.
### Scope
Global Population Information System
### Level
User Goal
### Preconditions
- The world database is successfully loaded and accessible.
- The application is running and connected to the database.
- City and country population data are complete and consistent.
### Success Condition
- The system displays, for each country:
    - Total population
    - Population living in cities (and percentage)
    - Population not living in cities (and percentage)
- The report is accurate, readable, and complete.
### Failed Condition
- The database connection fails.
- The SQL query fails or returns incomplete/missing data.
- City or country data is inconsistent or missing.
### Primary Actor
- Data Analyst
- Researcher
- Policy Maker
### Trigger
The user selects “Country Population Report” from the main menu.
## MAIN SUCCESS SCENARIO
1. User launches the application.
2. User selects “Country Population Report.”
3. System connects to the world database.
4. System executes SQL queries to calculate:
    - Total population of each country.
    - Population living in cities and not living in cities.
    - Percentage breakdowns for each.
5. System compiles and formats the data into a report or table.
6. System displays the population statistics for each country.
7. User reviews and exports or saves the report if required.
## EXTENSION
3. **Database connection fails**:
    1. System retries connection or displays “Unable to connect to database.”
4. **SQL query fails or data inconsistency detected**:
    1. System logs the error and shows “Population data unavailable.”
5. **Missing data for a country**:
    1. System displays “Data incomplete for selected country.” and continues with available data.
## SCHEDULE
Week 12 (Target for Code Review 4)
