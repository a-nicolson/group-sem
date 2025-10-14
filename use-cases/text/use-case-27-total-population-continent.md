# USE CASE 27: View population of a continent
## CHARACTERISTIC INFORMATION
### Goal in context
Display the total population of a specific continent so that users can analyse continental demographics and compare population sizes between continents.
### Scope
Global Population Information System
### Level
User Goal
### Preconditions
- The world database is successfully loaded and accessible.
- The application is running and connected to the database.
- The user specifies a valid continent name.
### Success Condition
- The total population of the specified continent is displayed accurately.
### Failed Condition
- Invalid continent name.
- Database connection or query fails.
### Primary Actor
- Research Analyst
- Data Viewer
### Trigger
The user selects “Continent Population Report” and provides a continent name.
## MAIN SUCCESS SCENARIO
1. User launches the application.
2. User selects “Continent Population Report.”
3. System prompts for a continent name.
4. User enters a valid continent name.
5. System connects to the database.
6. System executes a query to calculate total population for that continent.
7. System displays the population result.
8. User reviews the data successfully.
## EXTENSION
3. **User enters invalid continent name**:
   1. System displays an error and requests valid input.
4. **Database connection fails**:
   1. System retries or displays “Unable to connect to database.”
## SCHEDULE
Week 12 (Target for Code Review 4)
