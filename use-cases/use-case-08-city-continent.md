# USE CASE 08: All the cities in a continent organised by largest population to smallest
## CHARACTERISTIC INFORMATION
### Goal in context
Display all the cities within a selected continent ordered by population from largest to smallest so that users can analyse urban population trends across the continent.
### Scope
Global Population Information System
### Level
User Goal
### Preconditions
- The world database is successfully loaded and accessible.
- The application is running and connected to the database.
- The user specifies a valid continent name (e.g., Asia, Europe, Africa).
### Success Condition
- The system displays all cities within the selected continent ordered by population from largest to smallest.
- The report is readable, accurate, and complete.
### Failed Condition
- The user enters an invalid continent name.
- The database connection fails.
- The SQL query fails or returns no results.
### Primary Actor
- Data Viewer
- Research Analyst
### Trigger
The user selects “All Cities by Continent” and specifies a continent name.
## MAIN SUCCESS SCENARIO
1. User launches the application.
2. User selects “All Cities by Continent.”
3. System prompts the user to enter a continent name.
4. User provides a valid continent name (e.g., Asia).
5. System connects to the world database.
6. System executes the SQL query to retrieve all cities in that continent ordered by population.
7. System formats the retrieved data into a readable table or report.
8. System displays the ordered list of all cities in the continent.
9. User reviews the report successfully.
## EXTENSION
3. **User does not enter a continent name**:
    1. System displays an error and prompts again.
4. **Invalid continent name**:
    1. System notifies the user and requests re-entry.
5. **Database connection fails**:
    1. System retries connection or displays “Unable to connect to database.”
6. **System fails to retrieve data**:
    1. **SQL query fails**
        - System logs the error and shows “Data unavailable.”
    2. **No data found**
        - System displays “No city data found for the selected continent.”
## SCHEDULE
Week 6 (Target for Code Review 2)
