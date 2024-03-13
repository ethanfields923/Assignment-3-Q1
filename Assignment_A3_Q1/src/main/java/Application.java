import java.sql.*;
import java.util.Scanner;

public class Application {
    Connection connection;          //Used for forming a connection with the database

    //Constructor to connect the Application to the database
   Application (String url, String user, String password) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection(url, user, password);
    }

    //Displays all students that are in the table currently
    public void getAllStudents() throws SQLException{
        Statement statement = connection.createStatement();
        statement.executeQuery("SELECT * FROM students");
        ResultSet resultset = statement.getResultSet();

        while(resultset.next()){
            System.out.print(resultset.getInt("student_id") + "\t");
            System.out.print(resultset.getString("first_name") + "\t");
            System.out.print(resultset.getString("last_name") + "\t");
            System.out.print(resultset.getString("email") + "\t");
            System.out.println(resultset.getDate("enrollment_date"));
        }
        statement.close();
    }

    //Adds a new student into the table depending on the values provided
    public void addStudent(String fname, String lname, String Email, String enroll) throws SQLException{
           PreparedStatement prepStat = connection.prepareStatement("INSERT INTO students (first_name, last_name, email, enrollment_date) VALUES (?,?,?,?)");
           java.sql.Date sqlDate = Date.valueOf(enroll);                        //Converts the string in enroll parameter to a Date type

           //Sets the data in parameters to the prepared statement
           prepStat.setString(1,fname);
           prepStat.setString(2,lname);
           prepStat.setString(3,Email);
           prepStat.setDate(4, sqlDate);

           //Executes an update with the prepared statement on the database table
           prepStat.executeUpdate();
           System.out.println("Student successfully added...");
           prepStat.close();
    }

    //Updates the student email in the table according to the student id provided
    public void updateStudentEmail(int student_id, String new_email) throws SQLException{
        PreparedStatement prepStat = connection.prepareStatement("UPDATE students SET email = ? WHERE student_id = ?");

        prepStat.setString(1, new_email);
        prepStat.setInt(2, student_id);

        prepStat.executeUpdate();
        System.out.println("Student email successfully updated...");
    }

    //Deletes student from the table
    public void deleteStudent(int student_id) throws SQLException{
        PreparedStatement prepStat = connection.prepareStatement("DELETE FROM students WHERE student_id=?");

        prepStat.setInt(1,student_id);

        prepStat.executeUpdate();
        System.out.println("Student successfully deleted...");
    }

    //Closes connection to database when the user is exiting
    public void exitConnection() throws SQLException {
       connection.close();
    }

    //Used for pausing the output on screen for the user to view
    public void pauseOutput(){
       Scanner pause = new Scanner(System.in);
       System.out.println("Press enter to continue...");
       String enter = pause.nextLine();
    }
}
