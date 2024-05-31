import java.sql.Connection;
import java.sql.SQLException;
import java.util.Locale;
import java.util.Scanner;
import java.sql.PreparedStatement;

public class Sports {

    public static void sports_page() throws SQLException {
        //calling scanner from Main
        Scanner sc = Main.sc;
        //Calling connection establishment from ConnectionDB
        ConnectionDB db = new ConnectionDB();
        //PreparedStatement getCalorie = db.connect().prepareStatement("select lastweek_calory from users where username = ?");
        String[] sports = {"Running", "Walking", "Swimming", "Cycling", "Yoga", "Weightlifting"};
        //Giving information to user and asking the user for input
        System.out.print("Welcome to Sports Page " + User_Info.username + "! You burned " + User_Info.caloriesBurned +
                " calories this week.\n" + "\nWhat would you like to do?" + "\n->Add an Activity\t\t(1)\n->Go Home\t\t\t\t(2)\n");
        //getting the choice from user
        int choice = sc.nextInt();
        //temp for keeping the temporary calories to add it into weekly calories column on the data base
        Float temp_calories;
        //switch-case for giving user the decision to go home or add activity
        switch (choice){
            case(1):
                //while loop for looping until user wants to exit
                while(true) {
                    System.out.println("Select an activity to see estimated calories burned per hour: ");

                    for (int i = 0; i < sports.length; i++) {
                        System.out.print("-"+sports[i]+"\n");
                    }
                    System.out.println("Exit");

                    String sport_choice = sc.next().toLowerCase();
                    if(sport_choice.equals("exit")){
                        break;
                    }
                    System.out.println("How many minutes you did that");
                    Float duration = sc.nextFloat() / 60;
                    temp_calories = (float) 0 ;

                    switch (sport_choice) {
                        case "running":
                            temp_calories += (10 * User_Info.weight * duration);
                            System.out.println("You burned approximately " + Math.round(temp_calories) + " calories by doing" + sport_choice + "for" + duration + "hours");
                            break;
                        case "walking":
                            temp_calories += (3 * User_Info.weight * duration);
                            System.out.println("You burned approximately " + Math.round(temp_calories) + " calories by doing" + sport_choice + "for" + duration + "hours");
                            break;
                        case "swimming":
                            temp_calories += (5 * User_Info.weight * duration);
                            System.out.println("You burned approximately " + Math.round(temp_calories) + " calories by doing" + sport_choice + "for" + duration + "hours");
                            break;
                        case "cycling":
                            temp_calories += (4 * User_Info.weight * duration);
                            System.out.println("You burned approximately " + Math.round(temp_calories) + " calories by doing" + sport_choice + "for" + duration + "hours");
                            break;
                        case "yoga":
                            temp_calories += (3 * User_Info.weight * duration);
                            System.out.println("You burned approximately " + Math.round(temp_calories) + " calories by doing" + sport_choice + "for" + duration + "hours");
                            break;
                        case "weightlifting":
                            temp_calories += (5 * User_Info.weight * duration);
                            System.out.println("You burned approximately " + Math.round(temp_calories) + " calories by doing" + sport_choice + "for" + duration + "hours");
                            break;
                    }
                    //statement to add weekly calory data
                    PreparedStatement addcalory;
                    addcalory = db.connect().prepareStatement("update users set lastweek_calory = lastweek_calory + ? where username = ?");
                    addcalory.setFloat(1, User_Info.caloriesBurned+=temp_calories);
                    addcalory.setString(2, User_Info.username);
                    addcalory.executeUpdate();
                }
                break;
            case(2):
                break;
        }
    }
}