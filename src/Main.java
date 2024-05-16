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
                          "Login        =======> 1\n" +
                          "Register     =======> 2\n" +
                          "Exit         =======> 3\n ");
        int choice = sc.nextInt();
        switch(choice){
            case 1:  try {
                            Login_Register.login(sc);
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        } break;
            case 2: break;
            case 3: break;
        }

        sc.close();
    }
}
