# USE CASE 31: View population of a city
## CHARACTERISTIC INFORMATION
### Goal in context
Display the total population of a specific city so that users can view detailed urban demographic data.
### Scope
Global Population Information System
### Level
User Goal
### Preconditions
- The world database is successfully loaded and accessible.
- The application is running and connected to the database.
- The user specifies a valid city name.
### Success Condition
- The total population of the specified city is displayed accurately.
### Failed Condition
- Invalid city name.
- Database or query error occurs.
### Primary Actor
- Research Analyst
- Data Viewer
### Trigger
The user selects “City Population Report” and enters the city name.
## MAIN SUCCESS SCENARIO
1. User launches the application.
2. User selects “City Population Report.”
3. System prompts for a city name.
4. User enters a valid city name.
5. System connects to the database.
6. System executes a query to calculate total population for the specified city.
7. System displays the result.
8. User reviews the report successfully.
## EXTENSION
3. **Invalid city name**:
    - System displays “Invalid input” and prompts again.
4. **Database connection fails**:
    - System retries or displays “Unable to connect to database.”
## SCHEDULE
Week 12 (Target for Code Review 4)
