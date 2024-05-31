import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws SQLException {
        Home home = new Home();
        ConnectionDB db = new ConnectionDB();
        db.connect();
        while(true) {
            System.out.printf("========Welcome========\n" +
                    "Login\t\t=======> Login\n" +
                    "Register\t=======> Register\n" +
                    "Exit\t\t=======> Exit\n");
            String choice = sc.next();
            switch(choice.toLowerCase()){
                case "login":
                    Login_Register.login();
                    if(User_Info.login_check==true) {
                        Home.home();
                    }
                    break;
                case "register" :
                    Login_Register.register();
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

// CREDITS

// DEVELOPPERS:
// Akif Eren Ertuğrul
// Osman Enes Doğaner
// Dora Bayraktar