import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        int a;
        do{
            Scanner scan = new Scanner(System.in);
            System.out.println("Wybierz opcje: ");
            System.out.println("1. Zaloguj się");
            System.out.println("2. Utwórz konto");
            System.out.println("3. Wyjdź");
            a = scan.nextInt();
            switch (a){
                case 1:
                    System.out.print("Login: ");
                    scan.nextLine();
                    String login = scan.nextLine();
                    System.out.print("Hasło: ");
                    String haslo = scan.nextLine();
                    login l1 = new login();
                    l1.loguj(login, haslo);
                    break;
                case 2:
                    System.out.print("Podaj login: ");
                    scan.nextLine();
                    String login1 = scan.nextLine().trim();
                    System.out.print("Podaj hasło: ");
                    String haslo1 = scan.nextLine().trim();
                    register r1 = new register();
                    r1.registerUser(login1,haslo1);
                    break;
            }
        }while(a!=3);
    }
}
