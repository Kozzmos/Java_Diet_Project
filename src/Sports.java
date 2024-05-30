import java.sql.SQLException;
import java.util.Scanner;

public class Sports {

    public static void sports_page() throws SQLException {
        Scanner sc = Main.sc;

        System.out.print("Welcome to Sports Page " + User_Info.username + ", What would you like to do?" +
                "\n->Start an Exercise\n->Activity History\n->\n->Sports\n->Update Info\n->Logout\n");


                String[] sports = {"Running", "Walking", "Swimming", "Cycling", "Yoga", "Weightlifting"};
//                double[] caloriesBurnedPerHour = {700, 500, 600, 300, 400}; bu ortalama 70 kilo biri için özel hesaplama yazicam buraya sonra

                System.out.println("Select an activity to see estimated calories burned per hour:");
                String sport_choice = sc.nextLine().toLowerCase();
                System.out.println("How many minutes you did that");
                Float duration = sc.nextFloat()/60;

                switch (sport_choice){
                    case "running":
                        Float caloriesBurned_run = (10 * User_Info.weight * duration);
                        System.out.println("You burned approximately" + Math.round(caloriesBurned_run) + "calories by doing" + sport_choice + "for" + duration + "hours");
                        break;
                    case "walking":
                        Float caloriesBurned_walk = (3 * User_Info.weight * duration);
                        System.out.println("You burned approximately" + Math.round(caloriesBurned_walk) + "calories by doing" + sport_choice + "for" + duration + "hours");
                        break;
                    case "swimming":
                        Float caloriesBurned_swim = (5 * User_Info.weight * duration);
                        System.out.println("You burned approximately" + Math.round(caloriesBurned_swim) + "calories by doing" + sport_choice + "for" + duration + "hours");
                        break;
                    case "cycling":
                        Float caloriesBurned_cyc = (4 * User_Info.weight * duration);
                        System.out.println("You burned approximately" + Math.round(caloriesBurned_cyc) + "calories by doing" + sport_choice + "for" + duration + "hours");
                        break;
                }

    }

}
