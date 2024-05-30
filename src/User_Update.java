import java.sql.PreparedStatement;
import java.sql.SQLException;

public class User_Update {
    public static void userupdate() throws SQLException {
        ConnectionDB db = new ConnectionDB();

        while (true) {
            //We are asking which value they want to change
            PreparedStatement update = null;
            System.out.print("Enter what you want to change:\n" +
                    "username / password / height / weight / weightgoal / pregnancy / exit\n");
            String choice = Main.sc.next();
            //Then according to their choice we are updating the Sql database and User_Info class
            switch (choice) {
                case "username":
                    System.out.print("Enter the new username:\n");
                    update = db.connect().prepareStatement("update users set username = ? where username=?");
                    update.setString(2, User_Info.username);
                    update.setString(1, User_Info.username = Main.sc.next());
                    update.executeUpdate();
                    System.out.print("Username changed successfully:\n");
                    break;
                case "password":
                    System.out.print("Enter the new password:\n");
                    update = db.connect().prepareStatement("update users set password = ? where username=?");
                    update.setString(2, User_Info.username);
                    update.setString(1, Main.sc.next());
                    update.executeUpdate();
                    System.out.print("Password changed successfully:\n");
                    break;
                case "height":
                    System.out.print("Enter the new height:\n");
                    update = db.connect().prepareStatement("update users set heigth = ?, bmi = ? where username=?");
                    update.setString(3, User_Info.username);
                    update.setFloat(1, User_Info.height = Main.sc.nextFloat());
                    update.setFloat(2, User_Info.bmi = (User_Info.weight / (((User_Info.height / 100)) * (User_Info.height / 100))));
                    update.executeUpdate();
                    System.out.print("Height changed successfully:\n");

                    break;
                case "weight":
                    System.out.print("Enter the new weight:\n");
                    update = db.connect().prepareStatement("update users set weight = ?, bmi = ? where username=?");
                    update.setString(3, User_Info.username);
                    update.setFloat(1, User_Info.weight = Main.sc.nextFloat());
                    update.setFloat(2, User_Info.bmi = (User_Info.weight / (((User_Info.height / 100)) * (User_Info.height / 100))));
                    update.executeUpdate();
                    System.out.print("Weight changed successfully:\n");

                    break;
                case "weightgoal":
                    System.out.print("Enter the new goal:\n");
                    update = db.connect().prepareStatement("update users set goal_w = ? where username=?");
                    update.setString(2, User_Info.username);
                    update.setFloat(1, Main.sc.nextFloat());
                    update.executeUpdate();
                    System.out.print("Weight Goal changed successfully:\n");

                    break;
                case "pregnancy":
                    System.out.print("Are you pregnant true/false:\n");
                    update = db.connect().prepareStatement("update users set pregnancy = ? where username=?");
                    update.setString(2, User_Info.username);
                    update.setBoolean(1, Main.sc.nextBoolean());
                    update.executeUpdate();
                    System.out.print("Pregnancy changed successfully:\n");

                    break;
                case "exit":
                    break;
            }
            if (choice.equals("exit")) {
                break;
            }
        }
    }
}
