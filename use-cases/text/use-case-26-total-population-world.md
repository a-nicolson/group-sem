# USE CASE 26: View total population of the world
## CHARACTERISTIC INFORMATION
### Goal in context
Display the total population of the world so that users can understand global population size and use it as a reference for percentage-based reports.
### Scope
Global Population Information System
### Level
User Goal
### Preconditions
- The world database is successfully loaded and accessible.
- The application is running and connected to the database.
### Success Condition
- The total population of the world is displayed accurately.
### Failed Condition
- Database connection fails.
- Query for world population fails or returns no data.
### Primary Actor
- Research Analyst
- Data Viewer
### Trigger
The user selects “World Population Report” from the main menu.
## MAIN SUCCESS SCENARIO
1. User launches the application.
2. User selects “World Population Report.”
3. System connects to the world database.
4. System executes a query to calculate total world population.
5. System displays the total population on screen.
6. User reviews the result successfully.
## EXTENSION
3. **Database connection fails**:
    - System retries or shows “Unable to connect to database.”
4. **Query execution fails**:
    - System logs the error and displays “Data unavailable.”
## SCHEDULE
Week 12 (Target for Code Review 4)
