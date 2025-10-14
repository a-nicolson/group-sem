# USE CASE 21: Top N populated capital cities in a continent
## CHARACTERISTIC INFORMATION
### Goal in context
Display the top N populated capital cities within a selected continent ordered from largest to smallest so that users can analyse and compare major capital cities within that continent.
### Scope
Global Population Information System
### Level
User Goal
### Preconditions
- The world database is successfully loaded and accessible.
- The application is running and connected to the database.
- The user selects a valid continent name (e.g., Asia, Europe, Africa).
- The user provides a valid positive integer value for N.
### Success Condition
- The system displays the top N capital cities in the selected continent ordered by population (largest to smallest).
- The report is accurate, readable, and complete.
### Failed Condition
- The user provides an invalid value for N (e.g., negative number, non-numeric input).
- The user enters an invalid or non-existent continent name.
- The database connection fails.
- The SQL query fails or returns no data.
### Primary Actor
- Data Viewer
- Research Analyst
### Trigger
The user selects “Top N Capital Cities by Continent Report” and specifies both the continent name and the number of cities (N).
## MAIN SUCCESS SCENARIO
1. User launches the application.
2. User selects “Top N Capital Cities by Continent Report.”
3. System prompts the user to enter a continent name and a value for N.
4. User provides valid input for both fields (e.g., Continent = “Asia”, N = 10).
5. System connects to the world database.
6. System executes the SQL query to retrieve the top N capital cities in the specified continent ordered by population.
7. System formats the retrieved data into a readable table or report.
8. System displays the top N capital cities in the selected continent.
9. User reviews and confirms the output.
## EXTENSION
3. **User does not enter a continent name or N value**:
    1. System displays an error and prompts again.
4. **Invalid continent name or invalid N value (negative/non-numeric)**:
    1. System displays an error message and requests valid input.
5. **Database connection fails**:
    1. System retries connection or displays “Unable to connect to database.”
6. **System fails to retrieve data**:
    1. **SQL query fails**
        - System logs the error and shows “Data unavailable.”
    2. **No data found**
        - System displays “No records found for the selected continent.”
## SCHEDULE
Week 10 (Target for Code Review 3)
