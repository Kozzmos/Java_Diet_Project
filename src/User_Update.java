import java.sql.PreparedStatement;
import java.sql.SQLException;

public class User_Update {
    public static void userupdate() throws SQLException {
        ConnectionDB db = new ConnectionDB();
        System.out.print("Enter what you want to change:\n");
        String choice = Main.sc.next();

        PreparedStatement update = null;

        switch (choice){
            case "username":
                update = db.connect().prepareStatement("update users set username = ? where username=?");
                update.setString(2, User_Info.username);
                update.setString(1, User_Info.username=Main.sc.next());
                update.executeUpdate();
                break;
            case "password":
                update = db.connect().prepareStatement("update users set password = ? where username=?");
                update.setString(2, User_Info.username);
                update.setString(1, Main.sc.next());
                update.executeUpdate();
                break;
            case "height":
                update = db.connect().prepareStatement("update users set heigth = ?, bmi = ? where username=?");
                update.setString(3, User_Info.username);
                update.setFloat(1, Main.sc.nextFloat());
                update.setFloat(2, User_Info.bmi = (User_Info.weight / (((User_Info.height / 100)) * (User_Info.height / 100))));
                update.executeUpdate();
                break;
            case "weight":
                update = db.connect().prepareStatement("update users set weight = ?, bmi = ? where username=?");
                update.setString(3, User_Info.username);
                update.setFloat(1, Main.sc.nextFloat());
                update.setFloat(2, User_Info.bmi = (User_Info.weight / (((User_Info.height / 100)) * (User_Info.height / 100))));
                update.executeUpdate();
                break;
            case "weightgoal":
                update = db.connect().prepareStatement("update users set goal_w = ? where username=?");
                update.setString(2, User_Info.username);
                update.setFloat(1, Main.sc.nextFloat());
                update.executeUpdate();
                break;
            case "pregnancy":
                update = db.connect().prepareStatement("update users set pregnancy = ? where username=?");
                update.setString(2, User_Info.username);
                update.setFloat(1, Main.sc.nextFloat());
                update.executeUpdate();
                break;
        }
//        if(choice.equalsIgnoreCase("height") || choice.equalsIgnoreCase("weight")) {
//            User_Info.bmi = (User_Info.weight / (((User_Info.height / 100)) * (User_Info.height / 100)));
//        }
    }
}
