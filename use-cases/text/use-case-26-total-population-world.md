# USE CASE 28: View population of a region
## CHARACTERISTIC INFORMATION
### Goal in context
Display the total population of a specific region so that users can compare demographic sizes within a continent.
### Scope
Global Population Information System
### Level
User Goal
### Preconditions
- The world database is successfully loaded and accessible.
- The application is running and connected to the database.
- The user specifies a valid region name.
### Success Condition
- The total population of the specified region is displayed accurately.
### Failed Condition
- Invalid region name.
- Database or query error occurs.
### Primary Actor
- Research Analyst
- Data Viewer
### Trigger
The user selects “Region Population Report” and enters the region name.
## MAIN SUCCESS SCENARIO
1. User launches the application.
2. User selects “Region Population Report.”
3. System prompts for a region name.
4. User enters a valid region name.
5. System connects to the world database.
6. System executes a query to calculate total population for that region.
7. System displays the result.
8. User reviews the data successfully.
## EXTENSION
3. **Invalid region name**:
    - System displays “Invalid input” and requests re-entry.
4. **Database connection fails**:
    - System retries or displays “Unable to connect to database.”
## SCHEDULE
Week 12 (Target for Code Review 4)
