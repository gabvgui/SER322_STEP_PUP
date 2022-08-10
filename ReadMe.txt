Group 9 - SER322 - Deliverable 3
Project Title: STEP PUP  
Description: Doggie Daycare Application

Group Members:
Andrea Schoonover
Sergei Manukian
Gabrielle Gui
Lizell Cabalquinto

Video URL: <insert URL here>

Database Structure:
Packages:
    UI -> holds logic for interactive menu
    Database -> handles database src files, driver, ...
UI
Middle Layer
Database
JDBC connectivity

Instructions for using Step Pup: Doggie Daycare Application

Environment requirements:
MySQL Connection
rs2xml.jar File (included in libs folder)
JConnector File (included in libs folder)

- Steps for connecting the database:
After running the program, the console prompts the user to input their database url, username, and password. After those are entered correctly, it should automatically open the application.

- Steps for executing (compile/deploy/run) the application:
The application opens up to a main menu with 3 options: Add, Update/Delete, Query.
Add:
- Select the table from the dropdown menu you would like to add to and click 'Add'
- Fill out the form that pops up and click 'Save'
- A window should pop up with a success message, if the 'X' button is clicked the user is returned to the main menu
- If you want to return to the main menu, you can click on 'Cancel'
Update/Delete:
- Select the table from the dropdown menu you would like to delete or update from and click 'Select'
- The appropriate table will show up, choose the entry you would like to edit or delete
- If you would like to edit, click on 'Update', this will take you to a form to fill out the fields that can be updated
- If you would like to delete, click on 'Delete', this will delete the row you have selected
- A window should pop up with a success message, if the 'X' button is clicked the user is returned to the main menu
- If you want to return to the main menu, you can click on 'Cancel' or the 'X' Button
Query:
- In the input field, type out an SQL query that you would like to run and click 'Submit'
- If you want to return to the main menu, you can click on 'Cancel'
- The result of the query should print out in the console

- Misc notes:
The delete function will only allow data added to the database through the application

Individual contributions:

Andrea Schoonover - Readme.txt, contributed to Delete Function
Sergei Manukian - Query Function, contributed to video
Gabrielle Gui - Created GUI, Add Function, Update Function
Lizell Cabalquinto - Delete Function, contributed to video


SQL Files:

STEP_PUP_GROUP_9_create.sql 
    - Use CREATE method to create the following tables:
        - Customer
        - Dog
        - Employee
        - Manager
        - Route

STEP_PUP_GROUP_9_insert.sql 
    - Use INSERT method to insert the values to tables.

STEP_PUP_GROUP_9_select.sql 
    - Use SELECT method to identify the following:
        - List of Employees who have routes assigned to them
        - Customers and every dog they own
        - Employees, dogs, starting points, and cost of routes
        - Dogs sorted by assigned
        - Customers total cost
        
