import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Login_Register {
    public static String gender;
    public static Float weight;
    public static Float height;
    public static Float weight_goal;
    public static String username;
    public static String password;
    public static String pregnancy;
    public static boolean login_check = false;//login check
    public static void login(Scanner sc) throws SQLException {
//        Establish  connection to DB
        ConnectionDB db = new ConnectionDB();
        db.connect();
//        Get the info
        System.out.println("Enter Username");
        username = sc.nextLine();
        System.out.println("Enter Password");
        password = sc.nextLine();

        PreparedStatement user_check;
        user_check = db.connect().prepareStatement("select * from users");
        ResultSet rs = user_check.executeQuery();

        while (rs.next()) {
            if (rs.getString("username").equals(username) && rs.getString("password").equals(password)) {
                System.out.println("Login Successful");
                login_check = true; //login check
                gender =rs.getString("gender");
                 weight =rs.getFloat("weight");
                 height =rs.getFloat("heigth");
                 weight_goal =rs.getFloat("goal_w");
            } else {
                System.out.println("Login Failed\n" +
                        "Incorrect Username or Password");
                login_check = false; //login check
            }
        }
    }

    public static void register(Scanner sc) {
        ConnectionDB db = new ConnectionDB();
        db.connect();

        //get id from user
        System.out.print("Enter username:\n");
        username = sc.nextLine();
        //get pw from user
        System.out.print("Enter password:\n");
        password = sc.nextLine();
        System.out.print("Enter gender: (Male/Female)\n");
        do {
            gender = sc.nextLine();
            if (!(gender.equalsIgnoreCase("male")) && !(gender.equals("female"))) {
                System.out.println("Please enter a valid gender");
            }
        } while (!(gender.equalsIgnoreCase("male")) && !(gender.equals("female")));

        if(gender.equalsIgnoreCase("female")) {
            System.out.print("Are you pregnant? Yes/No");
            pregnancy = sc.next();
            if(pregnancy.equalsIgnoreCase("yes")) {
                System.out.println("Congratulations! :)\nKeep in mind that your BMI may not be accurate and instead of focusing on your weight your priority is a healthy diet.");
            }
        }
        
        System.out.print("Enter weight(kg):");
        weight = sc.nextFloat();
        System.out.print("Enter height(cm):\n");
         height = sc.nextFloat();
        System.out.print("Enter your target weight(kg):\n");
        weight_goal = sc.nextFloat();

        try{
            PreparedStatement register = db.connect().prepareStatement("INSERT INTO users" +
                    "(username, password, gender, heigth, weight, goal_w, bmi, pregnancy)values" +
                            "(?, ?, ?, ?, ?, ?, ?, ?)");{
                register.setString(1, username);
                register.setString(2, password);
                register.setString(3, gender);
                register.setFloat(4, height);
                register.setFloat(5, weight);
                register.setFloat(6, weight_goal);
                register.setFloat(7, (float) (weight/(Math.sqrt(height/100))));
                register.setString(8, pregnancy);
                System.out.println(register);
                register.executeUpdate();

            }

        }
        catch (SQLException e) {
            System.out.println("Error inserting user ");
        }

    }
}
