# USE CASE 32: View population by language
## CHARACTERISTIC INFORMATION
### Goal in context
Display the number of people who speak specific major languages (Chinese, English, Hindi, Spanish, and Arabic), ordered from the greatest number of speakers to the smallest, including the percentage of the world population for each language.
### Scope
Global Population Information System
### Level
User Goal
### Preconditions
- The world database is successfully loaded and accessible.
- The application is running and connected to the database.
- The system includes a table or dataset containing language and population data.
### Success Condition
- The system displays the number of people who speak each specified language.
- Each language entry includes its percentage of the total world population.
- The list is correctly ordered from greatest to smallest.
### Failed Condition
- Database connection fails.
- The query for language data fails or returns no results.
- The application terminates before displaying output.
### Primary Actor
- Research Analyst
- Data Viewer
### Trigger
The user selects “Language Population Report” from the application menu.
## MAIN SUCCESS SCENARIO
1. User launches the application.
2. User selects “Language Population Report.”
3. System connects to the world database.
4. System executes a query to retrieve population data for specified languages (Chinese, English, Hindi, Spanish, Arabic).
5. System calculates the percentage of total world population for each language.
6. System orders the languages by population (largest to smallest).
7. System displays the results in a readable table format.
8. User reviews the output successfully.
## EXTENSION
3. **Database connection fails**:
   1. System retries the connection or displays “Unable to connect to database.”
4. **Query execution fails**:
   1. System logs the error and shows “Data unavailable.”
5. **No data found**:
   1. System displays “No records found for specified languages.”
## SCHEDULE
Week 12 (Target for Code Review 4)
