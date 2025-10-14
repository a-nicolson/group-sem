# USE CASE 17: All the capital cities in the world organised by largest population to smallest
## CHARACTERISTIC INFORMATION
### Goal in context
Display all the capital cities in the world ordered by population from largest to smallest so that users can understand global capital population distribution and identify the largest capital cities worldwide.
### Scope
Global Population Information System
### Level
User Goal
### Preconditions
- The world database is successfully loaded and accessible.
- The application is running and connected to the database.
- The system has a working data retrieval and display function.
### Success Condition
- The system displays all capital cities ordered by population from largest to smallest.
- The report is readable, accurate, and complete.
### Failed Condition
- The system cannot connect to the database.
- The SQL query fails or returns no data.
- The application terminates before displaying output.
### Primary Actor
- Data Viewer
- Research Analyst
### Trigger
The user selects “All Capital Cities Report” from the main menu or initiates the corresponding command.
## MAIN SUCCESS SCENARIO
1. User launches the application.
2. User selects “All Capital Cities Report.”
3. System connects to the world database.
4. System executes the SQL query to retrieve all capital cities ordered by population.
5. System formats the retrieved data into a readable table or report.
6. System displays the ordered list of all capital cities.
7. User reviews the report successfully.
## EXTENSION
3. **Database connection fails**:
    1. System retries connection or displays “Unable to connect to database.”
4. **SQL query fails**:
    1. System logs the error and shows “Data unavailable.”
5. **No records found**:
    1. System displays “No capital city data found.”
## SCHEDULE
Week 10 (Target for Code Review 3)
