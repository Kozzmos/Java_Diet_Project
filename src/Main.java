import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ConnectionDB db = new ConnectionDB();
        db.connect();

        System.out.printf("========Welcome========\n" +
                          "Login        =======> 1\n" +
                          "Register     =======> 2\n" +
                          "Exit         =======> 3\n ");
        int choice = sc.nextInt();
        switch(choice){
            case 1: break;
            case 2: break;
            case 3: break;
        }

        sc.close();
    }
}