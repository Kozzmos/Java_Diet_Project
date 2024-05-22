import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;
import java.util.Calendar;

public class Home {
    public static void home() throws SQLException {
        Calendar calendar = Calendar.getInstance();

        //breakfast   --->17 elements
        //lowcal      --->17 elements
        //morningbev  ---> 4 elements
        //cheatsnacks --->16 elements
        //carbs       --->16 elements
        //maindish_protein --->19 elements
        String[] carbs = {"Baked potato (1 piece-173g)", "Boiled potato (1 portion-200g)", "Mashed potato with milk and butter(1 portion-250g)", "Roasted sweet potato(1 portion-340g)", "Hash brown potato (1 portion-156g)", "Ramen (1 portion)", "Basmati rice (1 portion-50g)", "Black rice (1 portion-50g)", "Rice cake (4 piece-40g)", "White rice (1 portion-50g)", "Egg noodles (1 portion-160g)", "Spaghetti (1 portion-140g)", "Fettuccine (1 portion-80g)"};
        int[] carbs_cal = {212, 177, 184, 381, 196, 432, 176, 181, 156, 257, 221, 221, 283};

        String[] breakfast = {"Avocado toast (1 portion-76g)", "Boiled egg (2 large piece-100g)", "Egg omlette (122g)", "Egg,sunny side up (2 piece-100g)", "Eggy bread(1 slice-65g)", "Poached egg (2 piece-100g)", "Granola (1 portion-30g)", "Curd cheese (1 portion-50g)", "Labneh (1 portion-28g)", "Sausage (1 piece-41g)", "Turkey salami (112g)", "Peanut butter(30g)", "Oat meal (100g)", "Oat meal with 1 banana (170g)"};
        int[] breakfast_calories = {190, 138, 188, 144, 177, 166, 152, 43, 50, 79, 68, 180, 70, 139};

        String[] lowcalside = {"Hazelnut (1 portion-30g)", "Almond (30 piece-30gr)", "Low fat yogurt(150g)", "Carrot (2 pieces-120g)", "Carrots,cooked (3 portion-138g)", "Corn,canned (1 cup-256g)", "Cucumber (1 portion-150g)", "Jalapeno (6 piece-74g)", "Kimchi (1 portion-38g)", "Onion,raw (5 slice-65g)", "Pickle (1 portion-40g)", "Pumpkin (1 portion-125g)",
                "Iceberg Lettuce (1 portion-200g)", "Mushrooms (1 portion-150g)", "Granola bar (1 bar-25g)", "%85 dark chocolate (1 piece-4g)"};
        int[] lowcalside_cal = {202, 180, 63, 46, 30, 81, 21, 24, 8, 25, 11, 36, 37, 36, 81, 25};

        String[] cheatsnacks = {"Chips (1 portion-30g)", "Caramel Popcorn (1 portion-32g)", "Corn chips (1 portion-30g)", "Doritos (1 portion-28g)", "Flaming hot cheetos (1 portion-28g)", "Popcorn, oil popped (1 portion-30g)", "Soy chips (1 portion-29g)", "Souffle (1 portion-60g)", "Birthday cake (1 piece-85g)", "Candy apple (1 piece-320g)", "Chocolate chip cookie (1 piece-56g)", "Dark chocolate (1 portion-30g)", "Glazed donut (1 portion-79g)", "Gummy bears (1 portion-40g)", "Lollipop (1 piece-12g)"};
        int[] cheatsnacks_cal = {170, 118, 144, 145, 160, 98, 156, 269, 340, 429, 276, 155, 330, 137, 47};

        String[] maindishes_protein = {"Chicken breast,without skin (1 portion-100g)", "Beef (1 portion-170g)", "Beef liver,cooked(1 portion-80g)", "Beef patty(4 piece-340g)", "Chicken breast fillet (1 portion-100g)", "Lamb Meat (1 portion-85g)", "Meatball (3 piece-56g)", "Chicken Fajita (1 portion-139g)", "Indian chicken curry (1 portion-350g)", "Taco (1 piece-102g)", "Calamari (1 portion-370g)", "Fish fingers (4 piece-100g)", "Lobster (1 portion-150g)", "Octopus (1 portion-85g)", "Tuna (1 portion-50g)", "Salmon,cooked (1 portion-100g)", "Salmon,baked (1 portion-85g)", "Shrimp (1 portion-85g)", "Tuna,canned in water (2 can-112g)"};
        int[] maindishes_protein_cal = {164, 265, 196, 192, 195, 157, 126, 224, 371, 210, 298, 256, 124, 69, 113, 185, 95, 77, 110};

        String[] morning_bev = {"Americano (1 cup)", "Black coffee (1 cup)", "Espresso (1 cup)", "Turkish coffee (1 cup)"};
        int[] morning_bev_cal = {9, 5, 1, 46};
        //these strings store foods and their call

        while(true) {
            int hour = calendar.get(Calendar.HOUR_OF_DAY);

            if (hour < 12 && hour >= 5) {
                System.out.print("Good morning.Happy to see you here :) .\n");
            } else if (hour < 20 && hour >= 12) {
                System.out.print("Good evening.Happy to see you here :) .\n");
            } else {
                System.out.print("Goodnight.Happy to see you here :) .\nDon't stay up late!\n");
            }
            System.out.println("Don't forget to drink water!(up to 2-3 Liters for a day)");
            System.out.print("Welcome " + User_Info.username + ", What would you like to do?" +
                    "\n->Show Info\n->My Diet\n->Calorie Library\n->Sports\n->updateinfo\n->logout");
            Scanner sc1 = new Scanner(System.in);
            String choice_main_page = sc1.nextLine();
            choice_main_page = choice_main_page.replaceAll("\\s", "");

            switch (choice_main_page.toLowerCase()) {
                case "logout":
                    break;
                case "showinfo":
                    System.out.println("Gender: " + User_Info.gender + "\n" + "Weight: " + User_Info.weight + "\n" + "Height: " + User_Info.height + "\n" + "Weight Goal: " + User_Info.weight_goal + "\n" + "Body Mass Index: " + (User_Info.bmi));
                    break;
                case "updateinfo":
                    User_Update.userupdate();
                    break;
                case "mydiet":

                    if (hour < 11) { //this part is for breakfast
                        int random_b;
                        int sumbreakfastcal;
                        String[] breakfastdiet = new String[5];
                        Random random = new Random();

                        if (User_Info.bmi < 18.5 && User_Info.gender.equals("female")) {
                            do {

                                sumbreakfastcal = 0;
                                random_b = random.nextInt(4);
                                breakfastdiet[0] = breakfast[random_b];
                                sumbreakfastcal += breakfast_calories[random_b];

                                random_b = random.nextInt(5, 14);
                                breakfastdiet[1] = breakfast[random_b];
                                sumbreakfastcal += breakfast_calories[random_b];

                                random_b = random.nextInt(0, 2);
                                breakfastdiet[2] = lowcalside[random_b];
                                sumbreakfastcal += lowcalside_cal[random_b];

                                random_b = random.nextInt(morning_bev.length);
                                breakfastdiet[3] = morning_bev[random_b];
                                sumbreakfastcal += morning_bev_cal[random_b];

                            } while (sumbreakfastcal > 600 || sumbreakfastcal < 500);

                            for (int a = 0; a < 4; a++) {
                                System.out.print(breakfastdiet[a] + "\n");
                            }
                            System.out.println("Sum Breakfast Calories: " + sumbreakfastcal);
                            System.out.println("Remember to use olive oil (up to 50ml for a day) while cooking!");
                        }

                        if (User_Info.bmi < 18.5 && User_Info.gender.equals("male")) {
                            do {

                                sumbreakfastcal = 0;
                                random_b = random.nextInt(4);
                                breakfastdiet[0] = breakfast[random_b];
                                sumbreakfastcal += breakfast_calories[random_b];

                                random_b = random.nextInt(5, 14);
                                breakfastdiet[1] = breakfast[random_b];
                                sumbreakfastcal += breakfast_calories[random_b];

                                random_b = random.nextInt(0, 2);
                                breakfastdiet[2] = lowcalside[random_b];
                                sumbreakfastcal += lowcalside_cal[random_b];

                                random_b = random.nextInt(morning_bev.length);
                                breakfastdiet[3] = morning_bev[random_b];
                                sumbreakfastcal += morning_bev_cal[random_b];
                            } while (sumbreakfastcal > 700 || sumbreakfastcal < 600);
                            for (int a = 0; a < 4; a++) {
                                System.out.print(breakfastdiet[a] + "\n");
                            }
                            System.out.println("Sum Breakfast Calories: " + sumbreakfastcal);
                            System.out.println("Remember to use olive oil (up to 50ml for a day) while cooking!");

                        }
                        if (User_Info.bmi >= 25 && User_Info.gender.equals("female")) {
                            do {
                                sumbreakfastcal = 0;
                                random_b = random.nextInt(4);
                                breakfastdiet[0] = breakfast[random_b];
                                sumbreakfastcal += breakfast_calories[random_b];

                                random_b = random.nextInt(5, 14);
                                breakfastdiet[1] = breakfast[random_b];
                                sumbreakfastcal += breakfast_calories[random_b];

                                random_b = random.nextInt(0, 2);
                                breakfastdiet[2] = lowcalside[random_b];
                                sumbreakfastcal += lowcalside_cal[random_b];

                                random_b = random.nextInt(morning_bev.length);
                                breakfastdiet[3] = morning_bev[random_b];
                                sumbreakfastcal += morning_bev_cal[random_b];

                            } while (sumbreakfastcal > 500 || sumbreakfastcal < 400);

                            for (int a = 0; a < 4; a++) {
                                System.out.print(breakfastdiet[a] + "\n");
                            }
                            System.out.println("Sum Breakfast Calories: " + sumbreakfastcal);
                            System.out.println("Remember to use olive oil (up to 50ml for a day) while cooking!");
                        }

                        if (User_Info.bmi >= 25 && User_Info.gender.equals("male")) {
                            do {

                                sumbreakfastcal = 0;
                                random_b = random.nextInt(4);
                                breakfastdiet[0] = breakfast[random_b];
                                sumbreakfastcal += breakfast_calories[random_b];

                                random_b = random.nextInt(5, 14);
                                breakfastdiet[1] = breakfast[random_b];
                                sumbreakfastcal += breakfast_calories[random_b];

                                random_b = random.nextInt(0, 2);
                                breakfastdiet[2] = lowcalside[random_b];
                                sumbreakfastcal += lowcalside_cal[random_b];

                                random_b = random.nextInt(morning_bev.length);
                                breakfastdiet[3] = morning_bev[random_b];
                                sumbreakfastcal += morning_bev_cal[random_b];
                            } while (sumbreakfastcal > 600 || sumbreakfastcal < 500);
                            for (int a = 0; a < 4; a++) {
                                System.out.print(breakfastdiet[a] + "\n");
                            }
                            System.out.println("Sum Breakfast Calories: " + sumbreakfastcal);
                            System.out.println("Remember to use olive oil (up to 50ml for a day) while cooking!");

                        }
                    }

                    if (hour >= 11) { //this part is for lunch
                        int random_b;
                        int summealcal;
                        String[] mealdiet = new String[5];
                        Random random = new Random();

                        if (User_Info.bmi < 18.5 && User_Info.gender.equals("female")) {
                            do {

                                summealcal = 0;

                                random_b = random.nextInt(maindishes_protein.length);
                                mealdiet[0] = maindishes_protein[random_b];
                                summealcal += maindishes_protein_cal[random_b];

                                random_b = random.nextInt(carbs.length);
                                mealdiet[1] = carbs[random_b];
                                summealcal += carbs_cal[random_b];

                                random_b = random.nextInt(2, lowcalside.length);
                                mealdiet[2] = lowcalside[random_b];
                                summealcal += lowcalside_cal[random_b];

                                random_b = random.nextInt(morning_bev.length);
                                mealdiet[3] = morning_bev[random_b];
                                summealcal += morning_bev_cal[random_b];

                            } while (summealcal > 800 || summealcal < 700);

                            for (int a = 0; a < 4; a++) {
                                System.out.print(mealdiet[a] + "\n");
                            }
                            System.out.println("Sum Meal Calories: " + summealcal);
                            System.out.println("Remember to use olive oil (up to 50ml for a day) while cooking!");
                        }
                        if (User_Info.bmi < 18.5 && User_Info.gender.equals("male")) {
                            do {

                                summealcal = 0;

                                random_b = random.nextInt(maindishes_protein.length);
                                mealdiet[0] = maindishes_protein[random_b];
                                summealcal += maindishes_protein_cal[random_b];

                                random_b = random.nextInt(carbs.length);
                                mealdiet[1] = carbs[random_b];
                                summealcal += carbs_cal[random_b];

                                random_b = random.nextInt(2, lowcalside.length);
                                mealdiet[2] = lowcalside[random_b];
                                summealcal += lowcalside_cal[random_b];

                                random_b = random.nextInt(morning_bev.length);
                                mealdiet[3] = morning_bev[random_b];
                                summealcal += morning_bev_cal[random_b];

                            } while (summealcal > 900 || summealcal < 800);

                            for (int a = 0; a < 4; a++) {
                                System.out.print(mealdiet[a] + "\n");
                            }
                            System.out.println("Sum Meal Calories: " + summealcal);
                            System.out.println("Remember to use olive oil (up to 50ml for a day) while cooking!");
                        }
                        if (User_Info.bmi <= 18.5 && User_Info.gender.equals("female") && User_Info.bmi < 25) {
                            do {
                                summealcal = 0;

                                random_b = random.nextInt(maindishes_protein.length);
                                mealdiet[0] = maindishes_protein[random_b];
                                summealcal += maindishes_protein_cal[random_b];

                                random_b = random.nextInt(carbs.length);
                                mealdiet[1] = carbs[random_b];
                                summealcal += carbs_cal[random_b];

                                random_b = random.nextInt(2, lowcalside.length);
                                mealdiet[2] = lowcalside[random_b];
                                summealcal += lowcalside_cal[random_b];

                                random_b = random.nextInt(morning_bev.length);
                                mealdiet[3] = morning_bev[random_b];
                                summealcal += morning_bev_cal[random_b];

                            } while (summealcal > 700 || summealcal < 600);

                            for (int a = 0; a < 4; a++) {
                                System.out.print(mealdiet[a] + "\n");
                            }
                            System.out.println("Sum Meal Calories: " + summealcal);
                            System.out.println("Remember to use olive oil (up to 50ml for a day) while cooking!");
                        }
                        if (User_Info.bmi <= 18.5 && User_Info.gender.equals("male") && User_Info.bmi < 25) {
                            do {
                                summealcal = 0;

                                random_b = random.nextInt(maindishes_protein.length);
                                mealdiet[0] = maindishes_protein[random_b];
                                summealcal += maindishes_protein_cal[random_b];

                                random_b = random.nextInt(carbs.length);
                                mealdiet[1] = carbs[random_b];
                                summealcal += carbs_cal[random_b];

                                random_b = random.nextInt(2, lowcalside.length);
                                mealdiet[2] = lowcalside[random_b];
                                summealcal += lowcalside_cal[random_b];

                                random_b = random.nextInt(morning_bev.length);
                                mealdiet[3] = morning_bev[random_b];
                                summealcal += morning_bev_cal[random_b];

                            } while (summealcal > 850 || summealcal < 750);

                            for (int a = 0; a < 4; a++) {
                                System.out.print(mealdiet[a] + "\n");
                            }
                            System.out.println("Sum Meal Calories: " + summealcal);
                            System.out.println("Remember to use olive oil (up to 50ml for a day) while cooking!");
                        }

                        if (User_Info.bmi >= 25 && User_Info.gender.equals("female")) {
                            do {
                                summealcal = 0;

                                random_b = random.nextInt(maindishes_protein.length);
                                mealdiet[0] = maindishes_protein[random_b];
                                summealcal += maindishes_protein_cal[random_b];

                                random_b = random.nextInt(carbs.length);
                                mealdiet[1] = carbs[random_b];
                                summealcal += carbs_cal[random_b];

                                random_b = random.nextInt(2, lowcalside.length);
                                mealdiet[2] = lowcalside[random_b];
                                summealcal += lowcalside_cal[random_b];

                                random_b = random.nextInt(morning_bev.length);
                                mealdiet[3] = morning_bev[random_b];
                                summealcal += morning_bev_cal[random_b];

                            } while (summealcal > 600 || summealcal < 500);

                            for (int a = 0; a < 4; a++) {
                                System.out.print(mealdiet[a] + "\n");
                            }
                            System.out.println("Sum Meal Calories: " + summealcal);
                            System.out.println("Remember to use olive oil (up to 50ml for a day) while cooking!");
                        }

                        if (User_Info.bmi >= 25 && User_Info.gender.equals("male")) {
                            do {
                                summealcal = 0;

                                random_b = random.nextInt(maindishes_protein.length);
                                mealdiet[0] = maindishes_protein[random_b];
                                summealcal += maindishes_protein_cal[random_b];

                                random_b = random.nextInt(carbs.length);
                                mealdiet[1] = carbs[random_b];
                                summealcal += carbs_cal[random_b];

                                random_b = random.nextInt(2, lowcalside.length);
                                mealdiet[2] = lowcalside[random_b];
                                summealcal += lowcalside_cal[random_b];

                                random_b = random.nextInt(morning_bev.length);
                                mealdiet[3] = morning_bev[random_b];
                                summealcal += morning_bev_cal[random_b];

                            } while (summealcal > 700 || summealcal < 600);

                            for (int a = 0; a < 4; a++) {
                                System.out.print(mealdiet[a] + "\n");
                            }
                            System.out.println("Sum Meal Calories: " + summealcal);
                            System.out.println("Remember to use olive oil (up to 50ml for a day) while cooking!");
                        }
                    }

                    if (hour >= 20 && User_Info.bmi >= 25) {
                        System.out.println("Don't eat something for 4 hours before bed!");
                    }

                    break;
                case "calorielibrary":

                    break;
                case "sports":

                    break;
            }
            if(choice_main_page.equalsIgnoreCase("logout")){
                break;
            }
        }
    }
}