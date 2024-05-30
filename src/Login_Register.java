import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login_Register {
    public static void login() throws SQLException {

//        Establish and test connection to DB
        ConnectionDB db = new ConnectionDB();
        db.connect();
//        Get the info
        System.out.println("Enter Username");
        User_Info.username = Main.sc.next();
        System.out.println("Enter Password");
        User_Info.password = Main.sc.next();

        PreparedStatement user_check;
        user_check = db.connect().prepareStatement("select * from users");
        ResultSet rs = user_check.executeQuery();

        while (rs.next()) {
            if (rs.getString("username").equals(User_Info.username) && rs.getString("password").equals(User_Info.password)) {

                User_Info.login_check = true;
                User_Info.gender = rs.getString("gender");
                User_Info.weight = rs.getFloat("weight");
                User_Info.height = rs.getFloat("heigth");
                User_Info.weight_goal = rs.getFloat("goal_w");
                User_Info.pregnancy = rs.getBoolean("pregnancy");
                User_Info.bmi = rs.getFloat("bmi");
                User_Info.cheatday_counter=rs.getInt("cheat_day_timer");
                break;
            } else {
                User_Info.login_check = false;
            }
        }
        if(User_Info.login_check == true) {
            System.out.println("Login Successful");
        } else {
            System.out.println("Login Failed");
        }
    }

    public static void register() throws SQLException {
        ConnectionDB db = new ConnectionDB();
        db.connect();

        try{PreparedStatement register = db.connect().prepareStatement("INSERT INTO users" +
                "(username, password, gender, heigth, weight, goal_w, bmi, pregnancy,cheat_day_timer)values" +
                "(?, ?, ?, ?, ?, ?, ?, ?, ?)");
            {
                System.out.print("Enter username:");
                PreparedStatement if_user_exist;
                if_user_exist = db.connect().prepareStatement("select username from users where username=?");
                while(true) {
                    register.setString(1, User_Info.username=Main.sc.next());
                    if_user_exist.setString(1, User_Info.username);
                    ResultSet rs1 = if_user_exist.executeQuery();
                    if (rs1.next()) {
                        System.out.println("\nUsername already exists. Please enter another name:");
                    }
                    else{
                        break;
                    }
                }
                System.out.print("Enter password:");
                register.setString(2, User_Info.password=Main.sc.next());
                System.out.print("Enter gender:");
                do {
                    register.setString(3, User_Info.gender=Main.sc.next());
                    if (!(User_Info.gender.equalsIgnoreCase("male")) && !(User_Info.gender.equals("female"))) {
                        System.out.println("Please enter a valid gender");
                    }
                } while (!(User_Info.gender.equalsIgnoreCase("male")) && !(User_Info.gender.equals("female")));

                if(User_Info.gender.equalsIgnoreCase("female")) {
                    System.out.println("Are you pregnant? Yes/No");
                    if(Main.sc.next().equalsIgnoreCase("yes")) {
                        System.out.println("Congratulations! :)\nKeep in mind that your BMI may not be accurate and instead of focusing on your weight your priority is a healthy diet.");
                        register.setBoolean(8, true);
                    }
                    else {
                        register.setBoolean(8, false);
                    }
                }else register.setBoolean(8, false);

                System.out.print("Enter height(cm):");
                register.setFloat(4, User_Info.height=Main.sc.nextFloat());
                System.out.print("Enter weight(kg):");
                register.setFloat(5, User_Info.weight=Main.sc.nextFloat());
                System.out.printf("Our advice on your ideal weight is %d kg.\n", (User_Info.height-110));
                User_Info.bmi = (User_Info.weight / (((User_Info.height / 100)*(User_Info.height / 100))));
                int wg;
                do{
                    wg=1;
                    System.out.print("Enter your target weight(kg):");
                    User_Info.weight_goal=Main.sc.nextFloat();
                    if(User_Info.weight_goal/((User_Info.height/100)*(User_Info.height/100))< 18.5 || User_Info.weight_goal/((User_Info.height/100)*(User_Info.height/100)) >= 25) {
                        System.out.println("Your BMI is not at normal references for your weight goal.Please change it.");
                        wg=0;

                    }
                }while(wg==0);
                register.setFloat(6, User_Info.weight_goal);
                register.setFloat(7,User_Info.bmi);
                User_Info.cheatday_counter=0;
                register.setInt(9,User_Info.cheatday_counter);
                System.out.println(register);
                register.executeUpdate();
            }
        }
        catch (SQLException e) {
            System.out.println("Error inserting user ");
        }
    }
}
