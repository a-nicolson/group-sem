# USE CASE 16: Top N populated cities in a district
## CHARACTERISTIC INFORMATION
### Goal in context
Display the top N populated cities within a selected district ordered from largest to smallest so that users can identify and analyse the most populated urban areas within that district.
### Scope
Global Population Information System
### Level
User Goal
### Preconditions
- The world database is successfully loaded and accessible.
- The application is running and connected to the database.
- The user provides a valid positive integer value for N.
- The user selects a valid district name within a country.
### Success Condition
- The system displays the top N cities within the selected district ordered by population (largest to smallest).
- The report is accurate, readable, and complete.
### Failed Condition
- The user provides an invalid value for N (e.g., negative number, non-numeric input).
- The user enters an invalid district name.
- The database connection fails.
- The SQL query fails or returns no data.
### Primary Actor
- Data Viewer
- Research Analyst
### Trigger
The user selects “Top N Cities by District” and specifies both the district name and number of cities (N).
## MAIN SUCCESS SCENARIO
1. User launches the application.
2. User selects “Top N Cities by District.”
3. System prompts the user to enter a district name and number of cities (N).
4. User provides valid inputs (e.g., District = California, N = 10).
5. System connects to the world database.
6. System executes the SQL query to retrieve the top N cities within the selected district ordered by population.
7. System formats the retrieved data into a readable table or report.
8. System displays the top N cities in the selected district.
9. User reviews and confirms the report successfully.
## EXTENSION
3. **User does not enter district name or N value**:
    1. System displays an error and prompts again.
4. **Invalid input**:
    1. System displays an error message and requests valid data (valid district and positive integer N).
5. **Database connection fails**:
    1. System retries connection or displays “Unable to connect to database.”
6. **System fails to retrieve data**:
    1. **SQL query fails**
        - System logs the error and shows “Data unavailable.”
    2. **No data found**
        - System displays “No records found for the selected district.”
## SCHEDULE
Week 10 (Target for Code Review 3)
