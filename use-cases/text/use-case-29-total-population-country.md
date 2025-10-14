# USE CASE 29: View population of a country
## CHARACTERISTIC INFORMATION
### Goal in context
Display the total population of a specific country so that users can examine national population data and trends.
### Scope
Global Population Information System
### Level
User Goal
### Preconditions
- The world database is successfully loaded and accessible.
- The application is running and connected to the database.
- The user specifies a valid country name.
### Success Condition
- The total population of the specified country is displayed accurately.
### Failed Condition
- Invalid country name.
- Database connection fails or query returns no data.
### Primary Actor
- Research Analyst
- Data Viewer
### Trigger
The user selects “Country Population Report” and enters a country name.
## MAIN SUCCESS SCENARIO
1. User launches the application.
2. User selects “Country Population Report.”
3. System prompts for a country name.
4. User enters a valid country name.
5. System connects to the database.
6. System executes a query to retrieve total population of that country.
7. System displays the result.
8. User reviews the report successfully.
## EXTENSION
3. **Invalid country name**:
    - System displays “Invalid input” and prompts again.
4. **Database connection fails**:
    - System retries or displays “Unable to connect to database.”
## SCHEDULE
Week 12 (Target for Code Review 4)
