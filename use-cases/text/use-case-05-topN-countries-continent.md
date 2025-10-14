# USE CASE 05: Top N populated countries in a continent
## CHARACTERISTIC INFORMATION
### Goal in context
Display the top N populated countries in a selected continent ordered from largest to smallest so that users can analyse and compare population distribution among major countries within that continent.
### Scope
Global Population Information System
### Level
User Goal
### Preconditions
- The world database is successfully loaded and accessible.
- The application is running and connected to the database.
- The user provides a valid positive integer value for N.
- The user selects a valid continent name (e.g., Asia, Europe, Africa).
### Success Condition
- The system displays the top N countries within the selected continent ordered by population (largest to smallest).
- The report is accurate, readable, and complete.
### Failed Condition
- The user provides an invalid value for N (e.g., negative number, non-numeric input).
- The user enters an invalid continent name.
- The database connection fails.
- The SQL query fails or returns no data.
### Primary Actor
- Data Viewer
- Research Analyst
### Trigger
The user selects “Top N Countries by Continent” and specifies both the continent and the number of countries (N).
## MAIN SUCCESS SCENARIO
1. User launches the application.
2. User selects “Top N Countries by Continent.”
3. System prompts the user to enter the continent name and number of countries (N).
4. User provides valid inputs (e.g., Continent = Asia, N = 10).
5. System connects to the world database.
6. System executes the SQL query to retrieve the top N countries within the specified continent ordered by population.
7. System formats the retrieved data into a readable table or report.
8. System displays the ordered list of top N countries in the selected continent.
9. User reviews and confirms the report successfully.
## EXTENSION
3. **User does not enter continent or N value**:
    1. System prompts the user again for both inputs.
4. **Invalid input**:
    1. System displays an error message and requests valid data (valid continent and positive integer N).
5. **Database connection fails**:
    1. System retries or displays “Unable to connect to database.”
6. **System fails to retrieve data**:
    1. **SQL query fails**
        - System logs the error and shows “Data unavailable.”
    2. **No data found**
        - System displays “No records found for the selected continent.”
## SCHEDULE
Week 6 (Target for Code Review 2)
