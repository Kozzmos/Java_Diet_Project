import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.Calendar;

public class Home {
    public static void home() throws SQLException {
        Calendar calendar = Calendar.getInstance();
        Sports sports = new Sports();
        ConnectionDB db = new ConnectionDB();

        //Dummy Food List

        String[] carbs = {"Baked potato (1 piece-173g)", "Boiled potato (1 portion-200g)", "Mashed potato with milk and butter(1 portion-250g)", "Roasted sweet potato(1 portion-340g)", "Hash brown potato (1 portion-156g)", "Ramen (1 portion)", "Basmati rice (1 portion-50g)", "Black rice (1 portion-50g)", "Rice cake (4 piece-40g)", "White rice (1 portion-50g)", "Egg noodles (1 portion-160g)", "Spaghetti (1 portion-140g)", "Fettuccine (1 portion-80g)"
                ,"French fries (1 portion-80g)","Gnocchi(1 portion-200g)","Instant noodles (1 portion-80g)"};
        int[] carbs_cal = {212, 177, 184, 381, 196, 432, 176, 181, 156, 257, 221, 221, 283, 196, 250, 188};

        String[] breakfast = {"Avocado toast (1 portion-76g)", "Boiled egg (2 large piece-100g)", "Egg omlette (122g)", "Egg,sunny side up (2 piece-100g)", "Eggy bread(1 slice-65g)", "Poached egg (2 piece-100g)", "Granola (1 portion-30g)", "Curd cheese (1 portion-50g)", "Labneh (1 portion-28g)", "Sausage (1 piece-41g)", "Turkey salami (112g)", "Peanut butter(30g)", "Oat meal (100g)", "Oat meal with 1 banana (170g)"};
        int[] breakfast_calories = {190, 138, 188, 144, 177, 166, 152, 43, 50, 79, 68, 180, 70, 139};

        String[] lowcalside = {"Hazelnut (1 portion-30g)", "Almond (30 piece-30gr)", "Low fat yogurt(150g)", "Carrot (2 pieces-120g)", "Carrots,cooked (3 portion-138g)", "Corn,canned (1 cup-256g)", "Cucumber (1 portion-150g)", "Jalapeno (6 piece-74g)", "Kimchi (1 portion-38g)", "Onion,raw (5 slice-65g)", "Pickle (1 portion-40g)", "Pumpkin (1 portion-125g)",
                "Iceberg Lettuce (1 portion-200g)", "Mushrooms (1 portion-150g)", "Granola bar (1 bar-25g)", "%85 dark chocolate (1 piece-4g)","Coleslaw (1 portion-120g)","Fortune cookies (1 piece-8g)"};
        int[] lowcalside_cal = {202, 180, 63, 46, 30, 81, 21, 24, 8, 25, 11, 36, 37, 36, 81, 25, 174, 30};

        String[] cheatsnacks = {"Chips (1 portion-30g)", "Caramel Popcorn (1 portion-32g)", "Corn chips (1 portion-30g)", "Doritos (1 portion-28g)", "Flaming hot cheetos (1 portion-28g)", "Popcorn, oil popped (1 portion-30g)", "Soy chips (1 portion-29g)", "Souffle (1 portion-60g)", "Birthday cake (1 piece-85g)", "Candy apple (1 piece-320g)", "Chocolate chip cookie (1 piece-56g)", "Dark chocolate (1 portion-30g)", "Glazed donut (1 portion-79g)", "Gummy bears (1 portion-40g)", "Lollipop (1 piece-12g)"};
        int[] cheatsnacks_cal = {170, 118, 144, 145, 160, 98, 156, 269, 340, 429, 276, 155, 330, 137, 47};

        String[] maindishes_protein = {"Chicken breast,without skin (1 portion-100g)", "Beef (1 portion-170g)", "Beef liver,cooked(1 portion-80g)", "Beef patty(4 piece-340g)", "Chicken breast fillet (1 portion-100g)", "Lamb Meat (1 portion-85g)", "Meatball (3 piece-56g)", "Chicken Fajita (1 portion-139g)", "Indian chicken curry (1 portion-350g)", "Taco (1 piece-102g)", "Calamari (1 portion-370g)", "Fish fingers (4 piece-100g)", "Lobster (1 portion-150g)", "Octopus (1 portion-85g)", "Tuna (1 portion-50g)", "Salmon,cooked (1 portion-100g)", "Salmon,baked (1 portion-85g)", "Shrimp (1 portion-85g)", "Tuna,canned in water (2 can-112g)","Hot dog (1 portion-48g)","Lasagna (1 portion-206g)","Taco (1 serving)"};
        int[] maindishes_protein_cal = {164, 265, 196, 192, 195, 157, 126, 224, 371, 210, 298, 256, 124, 69, 113, 185, 95, 77, 110, 155, 336, 170};

        String[] bev = {"Americano (1 cup)", "Black coffee (1 cup)", "Espresso (1 cup)", "Turkish coffee (1 cup)","Diet Coke","Diet Sprite","Juice"};
        int[] bev_cal = {9, 5, 1, 46, 1, 2, 54};
        //these strings store foods and their call

        String[] diet = new String[4];

        while(true) {
            int hour = calendar.get(Calendar.HOUR_OF_DAY);
            //Greeting Parts
            if (hour < 12 && hour >= 5) {
                System.out.print("Good morning.Happy to see you here :) .\n");
            } else if (hour < 20 && hour >= 12) {
                System.out.print("Good evening.Happy to see you here :) .\n");
            } else {
                System.out.print("Goodnight.Happy to see you here :) .\nDon't stay up late!\n");
            }
            System.out.println("Don't forget to drink water!(up to 2-3 Liters for a day)");
            //Main Menu aka. Homepage
            System.out.print("Welcome " + User_Info.username + ", What would you like to do?" +
                    "\n->Show Info\n->My Diet\n->Calorie Library\n->Sports\n->Update Info\n->Logout\n");
            Scanner sc1 = new Scanner(System.in);
            String choice_main_page = sc1.nextLine();
            choice_main_page = choice_main_page.replaceAll("\\s", "");

            switch (choice_main_page.toLowerCase()) {
                case "logout":
                    break;
                case "showinfo":
                    //Shows information and statistics of user
                    System.out.println("Gender: " + User_Info.gender + "\n" + "Weight: " + User_Info.weight + "\n" + "Height: " + User_Info.height + "\n" + "Weight Goal: " + User_Info.weight_goal + "\n" + "Body Mass Index: " + (User_Info.bmi) + "\nYou burned " + User_Info.caloriesBurned + " calories this week !" );
                    if (User_Info.bmi > 25) {
                        if (User_Info.bmi > 30){
                            System.out.print("Your BMI value is really high("+User_Info.bmi+"), you should eat more healthy!\n");
                        } else System.out.print("Your BMI value is high("+User_Info.bmi+"), you should eat more healthy!\n");
                    } else {
                        if (User_Info.bmi <= 25) {
                            if (User_Info.bmi<20) {
                                System.out.print("Your BMI value is low("+User_Info.bmi+", you should gain more weight!\n");
                            } else if (User_Info.bmi == 20) {
                                //easter egg (if you have the BMI value of exactly 20)
                                System.out.print("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠻⣶⡀⠀⠀⣴⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠸⣿⣶⣶⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠸⣿⣿⣿⣿⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣶⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢹⣿⡏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                                        "⠀⠀⠀⠀⠀⠀⠀⠀⢀⡄⠀⠀⠀⠀⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                                        "⠀⠀⠀⠀⠀⠀⠀⠀⠘⢷⣶⣶⣶⣾⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢻⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠸⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⢻⣿⡏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠸⣿⣇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⣠⣤⣴⣶⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣶⣶⣶⣶⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⡀⠀⠀⠀⠀⠀⠀⢀⣀⣤⣴⣶⣿⣿⡿⠿⠟⠛⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠀⠀⠀⠀⠻⠿⢿⣿⣿⣿⣦⡀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢹⣿⡇⠀⠀⣀⣤⣶⣿⣿⡿⠿⠛⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠛⢿⣿⣷⣦⡀⠀⠀⠀⠀\n" +
                                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠸⣿⣧⣴⣿⡿⠿⠛⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⠀⠀⠈⠙⢻⣿⣧⡀⠀⠀\n" +
                                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣾⣿⣿⠛⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢿⡿⠇⠀⠀⠀⠀⠙⣿⣷⡀⠀\n" +
                                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣾⣿⠟⢻⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠸⣿⡿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢹⣿⡧⠀\n" +
                                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⣼⣿⡟⠁⠀⠸⣿⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡀⣀⣀⣀⣀⣤⣤⣴⣾⡿⠃⠀\n" +
                                        "⠀⠀⠀⠀⠀⠀⠀⠀⣼⣿⡟⠀⠀⠀⠀⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⣀⣀⣀⣀⣀⣀⣄⣠⣤⣤⣴⣶⣾⣿⣶⣾⣿⣿⣿⣿⡿⠿⠿⠿⠿⠟⠛⠛⠁⠀⠀⠀\n" +
                                        "⠀⠀⠀⠀⠀⠀⠀⣾⣿⠏⠀⠀⠀⠀⠀⣸⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⣾⣿⣿⣿⣿⣿⠿⠿⠿⠿⠿⠿⠿⠿⠟⠻⣛⣟⣿⣿⡍⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                                        "⠀⠀⠀⠀⠀⠀⣼⣿⠏⠀⠀⠀⠀⠀⠀⢸⣿⡀⠀⠀⠀⠀⠀⠀⠀⠀⠹⢆⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠹⣿⣧⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                                        "⠀⠀⠀⠀⠀⣼⣿⡟⠀⠀⠀⠀⠀⠀⠀⠘⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠓⣤⣤⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢿⣿⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                                        "⠀⠀⠀⠀⣼⣿⡟⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠛⠿⣿⣦⣤⣤⣄⣀⣀⣀⣠⣤⠜⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                                        "⠀⠀⠀⢀⣿⡿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠉⠉⠉⠉⠉⠉⠉⢰⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                                        "⠀⠀⠀⣼⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣸⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢻⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                                        "⠀⠀⠀⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣤⣿⡟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠸⣿⣷⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                                        "⠀⠀⢸⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                                        "⠀⠀⣿⣿⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢻⣿⣇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                                        "⠀⢸⣿⡟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                                        "⠀⣾⣿⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢼⣿⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                                        "⢀⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠸⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                                        "⢸⣿⡏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣷⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                                        "⢸⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢻⣿⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                                        "⢿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                                        "⠀⠙⠇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⡗⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀"+"\nWOW you are so healthy with BMI value of EXACTLY 20! How is this even possible?\n");
                            } else if (User_Info.bmi < 25) {
                                System.out.print("You are healthy with BMI value of"+User_Info.bmi+". Keep being healthy!\n");
                            }
                        }
                    }
                    System.out.println("Wanna Go Home => Yes");
                    if(sc1.nextLine().equalsIgnoreCase("yes")) {
                        break;
                    }
                case "updateinfo":
                    //This allows to user change his/her informations
                    User_Update.userupdate();
                    break;
                case "mydiet":
                    //To create a special diet list according to user's calculated bmi
                    PreparedStatement if_diet_list_exist;
                    if_diet_list_exist = db.connect().prepareStatement("select diet_list from users where username = ?");
                    if_diet_list_exist.setString(1, User_Info.username);
                    ResultSet rs = if_diet_list_exist.executeQuery();
                    rs.next();
                    User_Info.diet_list=rs.getString("diet_list");
                    if (rs.getString("diet_list") == null) {
                        if (User_Info.cheatday_counter != 93) {
                            if (hour < 11) { //this part is for breakfast
                                int random_b;
                                int sumbreakfastcal;
                                Random random = new Random();

                                if (User_Info.bmi < 18.5 && User_Info.gender.equals("female")) {
                                    do {
                                        sumbreakfastcal = 0;
                                        random_b = random.nextInt(0, 6);
                                        diet[0] = breakfast[random_b];
                                        sumbreakfastcal += breakfast_calories[random_b];

                                        random_b = random.nextInt(6, 14);
                                        diet[1] = breakfast[random_b];
                                        sumbreakfastcal += breakfast_calories[random_b];

                                        random_b = random.nextInt(0, 2);
                                        diet[2] = lowcalside[random_b];
                                        sumbreakfastcal += lowcalside_cal[random_b];

                                        random_b = random.nextInt(0, 4);
                                        diet[3] = bev[random_b];
                                        sumbreakfastcal += bev_cal[random_b];

                                    } while (sumbreakfastcal > 600 || sumbreakfastcal < 500);

                                    for (int a = 0; a < 4; a++) {
                                        System.out.print(diet[a] + "\n");
                                    }

                                    System.out.println("Sum Breakfast Calories: " + sumbreakfastcal);
                                    System.out.println("Remember to use olive oil (up to 50ml for a day) while cooking!");

                                }

                                if (User_Info.bmi < 18.5 && User_Info.gender.equals("male")) {
                                    do {
                                        sumbreakfastcal = 0;
                                        random_b = random.nextInt(0, 6);
                                        diet[0] = breakfast[random_b];
                                        sumbreakfastcal += breakfast_calories[random_b];

                                        random_b = random.nextInt(6, 14);
                                        diet[1] = breakfast[random_b];
                                        sumbreakfastcal += breakfast_calories[random_b];

                                        random_b = random.nextInt(0, 2);
                                        diet[2] = lowcalside[random_b];
                                        sumbreakfastcal += lowcalside_cal[random_b];

                                        random_b = random.nextInt(0, 4);
                                        diet[3] = bev[random_b];
                                        sumbreakfastcal += bev_cal[random_b];
                                    } while (sumbreakfastcal < 600);
                                    for (int a = 0; a < 4; a++) {
                                        System.out.print(diet[a] + "\n");
                                    }
                                    System.out.println("Sum Breakfast Calories: " + sumbreakfastcal);
                                    System.out.println("Remember to use olive oil (up to 50ml for a day) while cooking!");

                                }
                                if (User_Info.bmi >= 25 && User_Info.gender.equals("female")) {
                                    do {
                                        sumbreakfastcal = 0;
                                        random_b = random.nextInt(0, 6);
                                        diet[0] = breakfast[random_b];
                                        sumbreakfastcal += breakfast_calories[random_b];

                                        random_b = random.nextInt(6, 14);
                                        diet[1] = breakfast[random_b];
                                        sumbreakfastcal += breakfast_calories[random_b];

                                        random_b = random.nextInt(0, 2);
                                        diet[2] = lowcalside[random_b];
                                        sumbreakfastcal += lowcalside_cal[random_b];

                                        random_b = random.nextInt(0, 4);
                                        diet[3] = bev[random_b];
                                        sumbreakfastcal += bev_cal[random_b];

                                    } while (sumbreakfastcal > 500 || sumbreakfastcal < 400);

                                    for (int a = 0; a < 4; a++) {
                                        System.out.print(diet[a] + "\n");
                                    }
                                    System.out.println("Sum Breakfast Calories: " + sumbreakfastcal);
                                    System.out.println("Remember to use olive oil (up to 50ml for a day) while cooking!");
                                }

                                if (User_Info.bmi >= 25 && User_Info.gender.equals("male")) {
                                    do {

                                        sumbreakfastcal = 0;
                                        random_b = random.nextInt(0, 6);
                                        diet[0] = breakfast[random_b];
                                        sumbreakfastcal += breakfast_calories[random_b];

                                        random_b = random.nextInt(6, 14);
                                        diet[1] = breakfast[random_b];
                                        sumbreakfastcal += breakfast_calories[random_b];

                                        random_b = random.nextInt(0, 2);
                                        diet[2] = lowcalside[random_b];
                                        sumbreakfastcal += lowcalside_cal[random_b];

                                        random_b = random.nextInt(0, 4);
                                        diet[3] = bev[random_b];
                                        sumbreakfastcal += bev_cal[random_b];
                                    } while (sumbreakfastcal > 600 || sumbreakfastcal < 500);
                                    for (int a = 0; a < 4; a++) {
                                        System.out.print(diet[a] + "\n");
                                    }
                                    System.out.println("Sum Breakfast Calories: " + sumbreakfastcal);
                                    System.out.println("Remember to use olive oil (up to 50ml for a day) while cooking!");

                                }
                                User_Info.cheatday_counter += 1;

                            }

                            if (hour >= 11) { //this part is for lunch
                                int random_b;
                                int summealcal;

                                Random random = new Random();

                                if (User_Info.bmi < 18.5 && User_Info.gender.equals("female")) {
                                    do {

                                        summealcal = 0;

                                        random_b = random.nextInt(0, 19);
                                        diet[0] = maindishes_protein[random_b];
                                        summealcal += maindishes_protein_cal[random_b];

                                        random_b = random.nextInt(0, 13);
                                        diet[1] = carbs[random_b];
                                        summealcal += carbs_cal[random_b];

                                        random_b = random.nextInt(2, 12);
                                        diet[2] = lowcalside[random_b];
                                        summealcal += lowcalside_cal[random_b];

                                        random_b = random.nextInt(4, 8);
                                        diet[3] = bev[random_b];
                                        summealcal += bev_cal[random_b];

                                    } while (summealcal > 800 || summealcal < 700);

                                    for (int a = 0; a < 4; a++) {
                                        System.out.print(diet[a] + "\n");
                                    }
                                    System.out.println("Sum Meal Calories: " + summealcal);
                                    System.out.println("Remember to use olive oil (up to 50ml for a day) while cooking!");
                                }
                                if (User_Info.bmi < 18.5 && User_Info.gender.equals("male")) {
                                    do {

                                        summealcal = 0;

                                        random_b = random.nextInt(0, 19);
                                        diet[0] = maindishes_protein[random_b];
                                        summealcal += maindishes_protein_cal[random_b];

                                        random_b = random.nextInt(0, 13);
                                        diet[1] = carbs[random_b];
                                        summealcal += carbs_cal[random_b];

                                        random_b = random.nextInt(2, 12);
                                        diet[2] = lowcalside[random_b];
                                        summealcal += lowcalside_cal[random_b];

                                        random_b = random.nextInt(4, 8);
                                        diet[3] = bev[random_b];
                                        summealcal += bev_cal[random_b];

                                    } while (summealcal > 900 || summealcal < 800);

                                    for (int a = 0; a < 4; a++) {
                                        System.out.print(diet[a] + "\n");
                                    }
                                    System.out.println("Sum Meal Calories: " + summealcal);
                                    System.out.println("Remember to use olive oil (up to 50ml for a day) while cooking!");
                                }
                                if (User_Info.bmi <= 18.5 && User_Info.gender.equals("female") && User_Info.bmi < 25) {
                                    do {
                                        summealcal = 0;

                                        random_b = random.nextInt(0, 19);
                                        diet[0] = maindishes_protein[random_b];
                                        summealcal += maindishes_protein_cal[random_b];

                                        random_b = random.nextInt(0, 13);
                                        diet[1] = carbs[random_b];
                                        summealcal += carbs_cal[random_b];

                                        random_b = random.nextInt(2, 12);
                                        diet[2] = lowcalside[random_b];
                                        summealcal += lowcalside_cal[random_b];

                                        random_b = random.nextInt(4, 8);
                                        diet[3] = bev[random_b];
                                        summealcal += bev_cal[random_b];

                                    } while (summealcal > 700 || summealcal < 600);

                                    for (int a = 0; a < 4; a++) {
                                        System.out.print(diet[a] + "\n");
                                    }
                                    System.out.println("Sum Meal Calories: " + summealcal);
                                    System.out.println("Remember to use olive oil (up to 50ml for a day) while cooking!");
                                }
                                if (User_Info.bmi <= 18.5 && User_Info.gender.equals("male") && User_Info.bmi < 25) {
                                    do {
                                        summealcal = 0;

                                        random_b = random.nextInt(0, 19);
                                        diet[0] = maindishes_protein[random_b];
                                        summealcal += maindishes_protein_cal[random_b];

                                        random_b = random.nextInt(0, 13);
                                        diet[1] = carbs[random_b];
                                        summealcal += carbs_cal[random_b];

                                        random_b = random.nextInt(2, 12);
                                        diet[2] = lowcalside[random_b];
                                        summealcal += lowcalside_cal[random_b];

                                        random_b = random.nextInt(4, 8);
                                        diet[3] = bev[random_b];
                                        summealcal += bev_cal[random_b];

                                    } while (summealcal > 850 || summealcal < 750);

                                    for (int a = 0; a < 4; a++) {
                                        System.out.print(diet[a] + "\n");
                                    }
                                    System.out.println("Sum Meal Calories: " + summealcal);
                                    System.out.println("Remember to use olive oil (up to 50ml for a day) while cooking!");
                                }

                                if (User_Info.bmi >= 25 && User_Info.gender.equals("female")) {
                                    do {
                                        summealcal = 0;

                                        random_b = random.nextInt(0, 19);
                                        diet[0] = maindishes_protein[random_b];
                                        summealcal += maindishes_protein_cal[random_b];

                                        random_b = random.nextInt(0, 13);
                                        diet[1] = carbs[random_b];
                                        summealcal += carbs_cal[random_b];

                                        random_b = random.nextInt(2, 12);
                                        diet[2] = lowcalside[random_b];
                                        summealcal += lowcalside_cal[random_b];

                                        random_b = random.nextInt(4, 7);
                                        diet[3] = bev[random_b];
                                        summealcal += bev_cal[random_b];

                                    } while (summealcal > 600 || summealcal < 500);

                                    for (int a = 0; a < 4; a++) {
                                        System.out.print(diet[a] + "\n");
                                    }
                                    System.out.println("Sum Meal Calories: " + summealcal);
                                    System.out.println("Remember to use olive oil (up to 50ml for a day) while cooking!");
                                }

                                if (User_Info.bmi >= 25 && User_Info.gender.equals("male")) {
                                    do {
                                        summealcal = 0;

                                        random_b = random.nextInt(0, 19);
                                        diet[0] = maindishes_protein[random_b];
                                        summealcal += maindishes_protein_cal[random_b];

                                        random_b = random.nextInt(0, 13);
                                        diet[1] = carbs[random_b];
                                        summealcal += carbs_cal[random_b];

                                        random_b = random.nextInt(2, 12);
                                        diet[2] = lowcalside[random_b];
                                        summealcal += lowcalside_cal[random_b];

                                        random_b = random.nextInt(4, 8);
                                        diet[3] = bev[random_b];
                                        summealcal += bev_cal[random_b];

                                    } while (summealcal > 700 || summealcal < 600);

                                    for (int a = 0; a < 4; a++) {
                                        System.out.print(diet[a] + "\n");
                                    }
                                    System.out.println("Sum Meal Calories: " + summealcal);
                                    System.out.println("Remember to use olive oil (up to 50ml for a day) while cooking!");
                                }
                                User_Info.cheatday_counter += 1;
                            }
                        } else
                            //We added a cheat day counter for users
                            System.out.println("Congrats!You've been determined through 31 days and we owe you a CHEAT DAY!You can eat whatever you want today.\n");

                        if (hour >= 20 && User_Info.bmi >= 25) {
                            System.out.println("Don't eat something for 4 hours before bed!");
                        }

                        //We store the diet list for user to make them able to see whenever they want
                        String final_string = Arrays.toString(diet);
                        PreparedStatement insertbf;
                        insertbf = db.connect().prepareStatement("update users set diet_list = ? where username = ?");
                        insertbf.setString(1, User_Info.diet_list = final_string);
                        insertbf.setString(2, User_Info.username);
                        insertbf.executeUpdate();
                    } else {
                        //If a diet list already exist system just shows his list not creating a new list
                        System.out.println(User_Info.diet_list);
                    }
                    System.out.println("Wanna Go Home => Yes");

                    if (sc1.nextLine().equalsIgnoreCase("yes")) {
                        break;
                    }
                    break;
                case "calorielibrary":
                    //For here we added all the foods and their respective calories so user can see the values
                    String answer;

                    do {
                        System.out.println("Which category would you like to see?\nCarbs,Cheat Snacks,Side Meals,Main Dish,Breakfast,Beverages or EXIT");
                        answer = sc1.nextLine();
                        answer = answer.replaceAll("\\s", "");
                        switch (answer.toLowerCase()) {
                            case "carbs":
                                for (int i = 0; i < carbs.length; i++)
                                    System.out.printf("%-50s %d cal\n", carbs[i], carbs_cal[i]);
                                break;
                            case "cheatsnacks":
                                for (int i = 0; i < cheatsnacks.length; i++)
                                    System.out.printf("%-40s %d cal\n", cheatsnacks[i], cheatsnacks_cal[i]);
                                break;
                            case "sidemeals":
                                for (int i = 0; i < lowcalside.length; i++)
                                    System.out.printf("%-35s %d cal\n", lowcalside[i], lowcalside_cal[i]);
                                break;
                            case "maindish":
                                for (int i = 0; i < maindishes_protein.length; i++)
                                    System.out.printf("%-50s %d cal\n", maindishes_protein[i], maindishes_protein_cal[i]);
                                break;
                            case "beverages":
                                for (int i = 0; i < bev.length; i++)
                                    System.out.printf("%-25s %d cal\n", bev[i], bev_cal[i]);
                                break;
                            case "breakfast":
                                for (int i = 0; i < breakfast.length; i++)
                                    System.out.printf("%-40s %d cal\n", breakfast[i], breakfast_calories[i]);
                                break;
                            case "exit":
                                break;
                        } if (answer.equalsIgnoreCase("exit")){
                            break;
                        }
                    }while(true);
                    break;
                case "sports":
                    //This part is for going to sports page which includes many sports and lets user to calculate and store the burned calory amount
                    System.out.println("Please note that these calculations are based on average.If you think there's a mistake you can update your weight on 'update info'.");
                    Sports.sports_page();
                    break;
            }
            // For logout
            if(choice_main_page.equalsIgnoreCase("logout")){
                break;
            }
        }
    }
}

