import java.util.Scanner;
import java.util.Calendar;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void mainpage(){
        String username=Login_Register.username;
        System.out.print("Welcome "+username+", What would you like to do?"+"\nShow Info\nMy Diet\nCalorie Library\nSports\n");
        Scanner sc=new Scanner (System.in);
        String choice_main_page=sc.nextLine();
        choice_main_page=choice_main_page.replaceAll("\\s", "");

        switch(choice_main_page.toLowerCase()){
            case "showinfo":
                String gender=Login_Register.gender;
                Float weight=Login_Register.weight;
                Float height=Login_Register.height;
                Float weight_goal=Login_Register.weight_goal;

                System.out.println("Gender: "+gender+"\n"+"Weight: "+weight+"\n"+"Height: "+height+"\n"+"Weight Goal: "+weight_goal+"\n"+"Body Mass Index: "+(weight/((height/100)*(height/100))));
                break;
                case "mydiet":

                    break;
                    case "calorielibrary":

                        break;
                        case "sports":

                            break;
        }

    }
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
    
        if (hour<12 && hour>=5){
            System.out.print("Goodmorning.Happy to see you here :) .\n");
         }
        else if(hour<20 && hour>=12){
            System.out.print("Goodevening.Happy to see you here :) .\n");
        }
        else{
            System.out.print("Goodnight.Happy to see you here :) .\nDon't stay up late!\n");
        }
        Scanner sc = new Scanner(System.in);

        ConnectionDB db = new ConnectionDB();
        db.connect();

       System.out.printf("========Welcome========\n" +
                        "Login\t\t=======> Login\n" +
                        "Register\t=======> Register\n" +
                        "Exit\t\t=======> Exit\n ");
                String choice = sc.next();
                switch(choice.toLowerCase(Locale.ROOT)){
                    case "login":

                        try {
                            Login_Register.login(sc);
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                        mainpage();
                        break;
                    case "register" : break;
                    case "exit" : break;
                }

        sc.close();
    }
}
