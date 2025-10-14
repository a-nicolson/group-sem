# USE CASE 19: All the capital cities in a region organised by largest population to smallest
## CHARACTERISTIC INFORMATION
### Goal in context
Display all the capital cities within a selected region ordered by population from largest to smallest so that users can analyse demographic and administrative patterns across regions.
### Scope
Global Population Information System
### Level
User Goal
### Preconditions
- The world database is successfully loaded and accessible.
- The application is running and connected to the database.
- The user selects a valid region name (e.g., Western Europe, Eastern Asia).
### Success Condition
- The system displays all capital cities in the selected region ordered by population (largest to smallest).
- The report is accurate, readable, and complete.
### Failed Condition
- The user enters an invalid region name.
- The database connection fails.
- The SQL query fails or returns no data.
### Primary Actor
- Data Viewer
- Research Analyst
### Trigger
The user selects “Capital Cities by Region Report” and specifies the desired region name.
## MAIN SUCCESS SCENARIO
1. User launches the application.
2. User selects “Capital Cities by Region Report.”
3. System prompts the user to enter or select a region name.
4. User provides a valid region name (e.g., Western Europe).
5. System connects to the world database.
6. System executes the SQL query to retrieve all capital cities in that region ordered by population.
7. System formats the data into a readable table or report.
8. System displays the ordered list of capital cities within the region.
9. User reviews the report successfully.
## EXTENSION
3. **User does not enter a region name**:
    1. System displays an error and prompts again.
4. **Invalid region name**:
    1. System notifies the user and requests re-entry.
5. **Database connection fails**:
    1. System retries connection or displays “Unable to connect to database.”
6. **System fails to retrieve data**:
    1. **SQL query fails**
        - System logs the error and shows “Data unavailable.”
    2. **No data found**
        - System displays “No records found for the selected region.”
## SCHEDULE
Week 10 (Target for Code Review 3)
