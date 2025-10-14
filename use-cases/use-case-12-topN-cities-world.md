# USE CASE 12: Top N populated cities in the world
## CHARACTERISTIC INFORMATION
### Goal in context
Display the top N populated cities in the world ordered from largest to smallest so that users can quickly identify the most populated urban areas globally.
### Scope
Global Population Information System
### Level
User Goal
### Preconditions
- The world database is successfully loaded and accessible.
- The application is running and connected to the database.
- The user provides a valid positive integer value for N.
### Success Condition
- The system displays the top N cities ordered by population (largest to smallest).
- The report is accurate, readable, and complete.
### Failed Condition
- The user provides an invalid value for N (e.g., negative number, non-numeric input).
- The database connection fails.
- The SQL query fails or returns no data.
### Primary Actor
- Data Viewer
- Research Analyst
### Trigger
The user selects “Top N Cities Report” and specifies the number of cities (N).
## MAIN SUCCESS SCENARIO
1. User launches the application.
2. User selects “Top N Cities Report.”
3. System prompts the user to enter the number of cities (N).
4. User provides a valid positive integer (e.g., 10).
5. System connects to the world database.
6. System executes the SQL query to retrieve the top N cities ordered by population.
7. System formats the retrieved data into a readable table or report.
8. System displays the top N cities by population.
9. User reviews and confirms the output.
## EXTENSION
3. **User does not enter a value for N**:
    1. System prompts the user again for input.
4. **User enters invalid value for N (e.g., negative or non-numeric)**:
    1. System displays an error message and requests valid input.
5. **Database connection fails**:
    1. System retries connection or displays “Unable to connect to database.”
6. **System fails to retrieve data**:
    1. **SQL query fails**
        - System logs the error and shows “Data unavailable.”
    2. **No data found**
        - System displays “No records found.”
## SCHEDULE
Week 10 (Target for Code Review 3)
