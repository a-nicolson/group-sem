# USE CASE 30: View population of a district
## CHARACTERISTIC INFORMATION
### Goal in context
Display the total population of a specific district within a country so that users can analyse smaller-scale population data.
### Scope
Global Population Information System
### Level
User Goal
### Preconditions
- The world database is successfully loaded and accessible.
- The application is running and connected to the database.
- The user specifies a valid district name.
### Success Condition
- The total population of the specified district is displayed accurately.
### Failed Condition
- Invalid district name.
- Database connection or query fails.
### Primary Actor
- Research Analyst
- Data Viewer
### Trigger
The user selects “District Population Report” and provides the district name.
## MAIN SUCCESS SCENARIO
1. User launches the application.
2. User selects “District Population Report.”
3. System prompts for a district name.
4. User enters a valid district name.
5. System connects to the database.
6. System executes a query to calculate total population of that district.
7. System displays the result.
8. User reviews the result successfully.
## EXTENSION
3. **Invalid district name**:
    - System displays “Invalid input” and requests new entry.
4. **Database connection fails**:
    - System retries or displays “Unable to connect to database.”
## SCHEDULE
Week 12 (Target for Code Review 4)
