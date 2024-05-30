import java.sql.SQLException;
import java.util.Scanner;

public class Sports {

    public static void sports_page() throws SQLException {
        Scanner sc = Main.sc;

        System.out.print("Welcome to Sports Page " + User_Info.username + ", What would you like to do?" +
                "\n->Start an Exercise\n->Activity History\n->\n->Sports\n->Update Info\n->Logout\n");


                String[] sports = {"Running", "Walking", "Swimming", "Cycling", "Yoga", "Weightlifting"};
//                double[] caloriesBurnedPerHour = {700, 500, 600, 300, 400}; bu ortalama 70 kilo biri için özel hesaplama yazicam buraya sonra

                System.out.println("Select an activity to see estimated calories burned per hour: ");

                for (int i = 0; i < sports.length; i++) {
                    System.out.println((i + 1) + ". " + sports[i]);
                }

                String sport_choice = sc.next().toLowerCase();
                System.out.println("How many minutes you did that");
                Float duration = sc.nextFloat()/60;

                User_Info.caloriesBurned = (float) 0;

                switch (sport_choice){
                    case "running":
                        User_Info.caloriesBurned += (10 * User_Info.weight * duration);
                        System.out.println("You burned approximately" + Math.round(User_Info.caloriesBurned) + "calories by doing" + sport_choice + "for" + duration + "hours");
                        break;
                    case "walking":
                        User_Info.caloriesBurned += (3 * User_Info.weight * duration);
                        System.out.println("You burned approximately" + Math.round(User_Info.caloriesBurned) + "calories by doing" + sport_choice + "for" + duration + "hours");
                        break;
                    case "swimming":
                        User_Info.caloriesBurned += (5 * User_Info.weight * duration);
                        System.out.println("You burned approximately" + Math.round(User_Info.caloriesBurned) + "calories by doing" + sport_choice + "for" + duration + "hours");
                        break;
                    case "cycling":
                        User_Info.caloriesBurned += (4 * User_Info.weight * duration);
                        System.out.println("You burned approximately" + Math.round(User_Info.caloriesBurned) + "calories by doing" + sport_choice + "for" + duration + "hours");
                        break;
                }

    }

}
