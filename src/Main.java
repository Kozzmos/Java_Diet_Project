import java.util.Scanner;
import java.util.Calendar;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
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
                        String gender=Login_Register.gender;
                        System.out.println(gender);
                        break;
                    case "register" : break;
                    case "exit" : break;
                }

        sc.close();
    }
}
