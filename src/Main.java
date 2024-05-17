import java.sql.SQLException;
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
                 System.out.println("Gender: "+Login_Register.gender+"\n"+"Weight: "+Login_Register.weight+"\n"+"Height: "+Login_Register.height+"\n"+"Weight Goal: "+Login_Register.weight_goal+"\n"+"Body Mass Index: "+(Login_Register.weight/((Login_Register.height/100)*(Login_Register.height/100))));
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

                while(true) {
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
                            if(Login_Register.login_check==true) {
                                mainpage();
                            }
                            break;
                        case "register" : 
                            Login_Register.register(sc);
                            System.out.println("Thanks for registering!");
                            break;
                        case "exit" : break;
                    }
                    if(choice.toLowerCase().equals("exit")){
                        break;
                    }
                }

        sc.close();
    }
}
