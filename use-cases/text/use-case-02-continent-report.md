# USE CASE 02: All the countries in a continent organised by largest population to smallest
## CHARACTERISTIC INFORMATION
### Goal in context
View all countries in a specific continent ordered by population (from largest to smallest) so that users can analyse and compare population distributions within continents.
### Scope
Global Population Information System
### Level
User Goal
### Preconditions
- The world database is successfully loaded and accessible.
- The application is running and connected to the database.
- The user selects or specifies a valid continent name.
### Success Condition
- The system displays all countries within the selected continent ordered by population from largest to smallest.
- The report is readable, accurate, and complete.
### Failed Condition
- The user enters an invalid continent name.
- The database connection fails.
- The SQL query returns no data or errors occur during execution.
### Primary Actor
- Data Viewer
- Research Analyst
### Trigger
The user selects “Continent Report” and specifies a continent (e.g., Asia, Europe, Africa).
## MAIN SUCCESS SCENARIO
1. User launches the application.
2. User selects “Continent Report.”
3. System prompts the user to select or enter a continent name.
4. User specifies a valid continent name.
5. System connects to the world database.
6. System executes the SQL query to retrieve all countries in that continent ordered by population.
7. System formats the data into a readable table or report.
8. System displays the ordered list of countries within the selected continent.
9. User reviews the output successfully.
## EXTENSION
3. **User does not enter a continent name**: 
   1. System displays an error message and prompts again.
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
Week 6 (Target for Code Review 2)