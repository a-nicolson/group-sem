# USE CASE 18: All the capital cities in a continent organised by largest population to smallest
## CHARACTERISTIC INFORMATION
### Goal in context
Display all the capital cities within a selected continent ordered by population from largest to smallest so that users can analyse and compare capital city populations across different continents.
### Scope
Global Population Information System
### Level
User Goal
### Preconditions
- The world database is successfully loaded and accessible.
- The application is running and connected to the database.
- The user selects a valid continent name (e.g., Asia, Europe, Africa).
### Success Condition
- The system displays all capital cities in the selected continent ordered by population (largest to smallest).
- The report is accurate, readable, and complete.
### Failed Condition
- The user enters an invalid continent name.
- The database connection fails.
- The SQL query fails or returns no data.
### Primary Actor
- Data Viewer
- Research Analyst
### Trigger
The user selects “Capital Cities by Continent Report” and specifies the desired continent name.
## MAIN SUCCESS SCENARIO
1. User launches the application.
2. User selects “Capital Cities by Continent Report.”
3. System prompts the user to enter or select a continent name.
4. User provides a valid continent name (e.g., Asia).
5. System connects to the world database.
6. System executes the SQL query to retrieve all capital cities in that continent ordered by population.
7. System formats the data into a readable table or report.
8. System displays the ordered list of capital cities within the continent.
9. User reviews the report successfully.
## EXTENSION
3. **User does not enter a continent name**:
    1. System displays an error and prompts again.
4. **Invalid continent name**:
    1. System notifies the user and requests re-entry.
5. **Database connection fails**:
    1. System retries or displays “Unable to connect to database.”
6. **System fails to retrieve data**:
    1. **SQL query fails**
        - System logs the error and shows “Data unavailable.”
    2. **No data found**
        - System displays “No records found for the selected continent.”
## SCHEDULE
Week 10 (Target for Code Review 3)
