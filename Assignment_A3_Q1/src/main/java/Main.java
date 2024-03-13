import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/Assignment3Q1";
        String user = "postgres";
        String password = "admin";
        Application app;                        //For using the methods inside of Application.java

        Scanner input = new Scanner(System.in);          //For getting user input for the program
        boolean flag = true;                             //For while loop
        String fname, lname, email, enrollment;     //Important data needed for adding the new student for second option
        int SID;                                    //Important for third choice
        String new_email;                           //Important for third choice
        int ID_delete;                              //Important for fourth choice

        try{
            app = new Application(url, user, password);             //Connects the database to the Application.java file
            System.out.println("Connection to database succeeded");

            while(flag) {
                System.out.println("Select an option:\n1. Print All Students\n2. Add New Student\n3. Update Student Email\n4. Delete Student Email\n5. Exit Program\n");
                String choice = input.nextLine();
                switch (choice) {
                    case "1":
                        System.out.println("Printing all students from database...");
                        app.getAllStudents();
                        app.pauseOutput();
                        break;

                    case "2":
                        System.out.println("\nEnter first name: ");
                        fname = input.nextLine();
                        System.out.println("\nEnter last name: ");
                        lname = input.nextLine();
                        System.out.println("\nEnter email: ");
                        email = input.nextLine();
                        System.out.println("\nEnter enrollment date (yyyy-mm-dd): ");
                        enrollment = input.nextLine();

                        System.out.println("\nAdding new student to database...\n");
                        app.addStudent(fname, lname, email, enrollment);
                        app.pauseOutput();
                        break;

                    case "3":
                        System.out.println("\nEnter student ID:");
                        SID = Integer.parseInt(input.nextLine());
                        System.out.println("\nEnter new email:");
                        new_email = input.nextLine();

                        System.out.println("\nUpdating Student Email in database...\n");
                        app.updateStudentEmail(SID, new_email);
                        app.pauseOutput();
                        break;

                    case "4":
                        System.out.println("Enter student ID: ");
                        ID_delete = Integer.parseInt(input.nextLine());

                        System.out.println("\nDeleting Student from database...\n");
                        app.deleteStudent(ID_delete);
                        app.pauseOutput();
                        break;

                    case "5":
                        System.out.println("Exiting program...");
                        app.exitConnection();
                        flag = false;
                        break;

                    default:
                        System.out.println("Invalid input. Please enter a valid choice.");
                        app.pauseOutput();
                }
            }

        }catch(Exception e){
            System.out.println("Connection to database failed");
        }
    }
}
