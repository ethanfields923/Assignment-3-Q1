# Assignment-3-Q1
NAME: Ethan Fields
Student #: 101245491

1. Download and extract the 'Assignment_A3_Q1_main' zip folder.
2. Copy and paste the sql query from the sql file, "Database creation.sql", into the postgresql query tool in pgadmin to get started.
3. Open the folder 'Assignment_A3_Q1' in the 'Assignment_A3_Q1_main' folder either in VS code (assuming you have the appropraite JDK and java V8 downloaded already) or in IntelliJ IDEA Community Edition
4. Build and run the code in the main.java file to start the program.
5. There will be 5 options to run the program:
     a. Print all the students (Selecting this option will print all the students currently in the database table 'students')
     b. Add a student (Selecting this option will add a new student to the database, only after asking the user for the input needed)
     c. Update Student email (Selecting this option will update the email of an existing student in the database table based on the provided ID from the user)
     d. Delete Student (Selecting this option will delete the existing student from the database table based on the provided ID from the user)
     e. Exit Program (Selecting this option will close the connection to the database and exit the program)
6. To test these options, use the following:
     a. Just select the 'Print all' option and see if all the current students in the database table are shown in the terminal.
     b. You can include the following input when asked for input to see if the 'Add Student' option works:
         [Billy,
         Bob,
         Bill.bob@example.com,
         2023-04-05]
         After doing this, you can select the 'print all' option when brought back to the menu options to see if the new entry is included in the database table
     c. You can use the following input when asked for input to see if the 'Update Student Email' options works:
         [4  (If this is not the ID given to the new student, then use their ID shown after using the 'print all' option),
         Billy.bob@example.com] 
         After doing this, you can select the 'print all' option when brought back to the menu options to see if the latest entry has their email changed in the database table.
     d. You can use the following input to test the 'Delete Student' option:
        [4 (Or the ID shown after using the 'print all' option if it is not that)]
        After doing this, you can select the 'print all' option when brought back to the menu options to see if the entry we had added is deleted from the table.


Video Demonstration Link:
NOTE: The code is implemented under the assumption that the user will give valid input to the program. Hence, there is no explicit error-handling implemented in this code.
