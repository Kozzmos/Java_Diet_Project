import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Login_Register {
    public static void login(Scanner sc) throws SQLException {
//        Establish  connection to DB
        ConnectionDB db = new ConnectionDB();
        db.connect();
//        Get the info
        System.out.println("Enter Username");
        String username = sc.nextLine();
        System.out.println("Enter Password");
        String password = sc.nextLine();

        PreparedStatement user_check;
        user_check = db.connect().prepareStatement("select * from users");
        ResultSet rs = user_check.executeQuery();

        while (rs.next()) {
            if (rs.getString("username").equals(username) && rs.getString("password").equals(password)) {
                System.out.println("Login Successful");
            } else {
                System.out.println("Login Failed\n" +
                        "Incorrect Username or Password");
            }
        }
    }

    public static void register(Scanner sc) {
        ConnectionDB db = new ConnectionDB();
        db.connect();

        //get id from user
        System.out.print("Enter username:\n");
        String username = sc.nextLine();
        //get pw from user
        System.out.print("Enter password:\n");
        String pw = sc.nextLine();
        String gender;
        System.out.print("Enter gender: (Male/Female)\n");
        do {
            gender = sc.nextLine();
            if (!(gender.equalsIgnoreCase("male")) && !(gender.equals("female"))) {
                System.out.println("Please enter a valid gender");
            }
        } while (!(gender.equalsIgnoreCase("male")) && !(gender.equals("female")));

        System.out.print("Enter weight(kg):");
        Float weight = sc.nextFloat();
        System.out.print("Enter height(cm):\n");
        Float height = sc.nextFloat();
        System.out.print("Enter your target weight(kg):\n");
        Float weight_goal = sc.nextFloat();

        try{
            PreparedStatement register = db.connect().prepareStatement("INSERT INTO users" +
                    "(username, password, gender, heigth, weight, goal_w, bmi)values" +
                            "(?, ?, ?, ?, ?, ?, ?)");{
                register.setString(1, username);
                register.setString(2, pw);
                register.setString(3, gender);
                register.setFloat(4, height);
                register.setFloat(5, weight);
                register.setFloat(6, weight_goal);
                register.setFloat(7, (float) (weight/(Math.sqrt(height/100))));
                System.out.println(register);
                register.executeUpdate();

            }

        }
        catch (SQLException e) {
            System.out.println("Error inserting user ");
        }

    }
}
