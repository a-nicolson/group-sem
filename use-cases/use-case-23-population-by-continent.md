# USE CASE 23: Population of people, people living in cities, and people not living in cities in each continent
## CHARACTERISTIC INFORMATION
### Goal in context
Generate a population report for each continent showing the total population, the number of people living in cities, and the number of people not living in cities (including percentages) so that users can analyse urbanisation and population distribution trends globally.
### Scope
Global Population Information System
### Level
User Goal
### Preconditions
- The world database is successfully loaded and accessible.
- The application is running and connected to the database.
- City and country population data are complete and consistent.
### Success Condition
- The system displays, for each continent:
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
The user selects “Continent Population Report” from the main menu.
## MAIN SUCCESS SCENARIO
1. User launches the application.
2. User selects “Continent Population Report.”
3. System connects to the world database.
4. System executes SQL queries to calculate:
    - Total population of each continent.
    - Population living in cities and not living in cities.
    - Percentage breakdowns for each.
5. System compiles and formats the data into a report or table.
6. System displays the population statistics for each continent.
7. User reviews and exports or saves the report if required.
## EXTENSION
3. **Database connection fails**:
    1. System retries connection or displays “Unable to connect to database.”
4. **SQL query fails or data inconsistency detected**:
    1. System logs the error and shows “Population data unavailable.”
5. **Missing data for a continent**:
    1. System displays “Data incomplete for selected continent.” and continues with available data.
6. **Export function fails (optional)**:
    1. System notifies the user that export could not be completed.
## SCHEDULE
Week 12 (Target for Code Review 4)
