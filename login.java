import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
public class login {

    public void loguj(String login, String haslo) throws SQLException {
        Scanner scan = new Scanner(System.in);
        ResultSet rs = ExecuteQuery.executeSelect("SELECT * FROM customers where login = '" + login + "'");
        while (rs.next()) {
            String loginB = rs.getString("login");
            String passB = rs.getString("pass");
            if (login.equals(loginB.trim()) && haslo.equals(passB.trim())) {
                int b;
                do {
                    System.out.println("Wybierz opcje: ");
                    System.out.println("1. Zobacz ofertę samochodów");
                    System.out.println("2. Wypożycz samochód");
                    System.out.println("3. Zwróć samochód");
                    System.out.println("4. Zobacz jakie samochody masz wypożyczone");
                    System.out.println("5. Wyjdź");
                    b = scan.nextInt();
                    switch (b) {
                        case 1:

                            ResultSet result1 = ExecuteQuery.executeSelect("SELECT * FROM cars WHERE czydostepny = 'true' order by id asc");
                            System.out.println("ID || Marka || Typ || Cena || czyDostępny");
                            while (result1.next()) {
                                int id = result1.getInt("id");
                                String marka = result1.getString("marka");
                                String typ = result1.getString("typ");
                                String cena = result1.getString("cena");
                                String dostepnosc = result1.getString("czyDostepny");
                                System.out.println(id + " || " + marka.trim() + " || " + typ.trim() + " || " +cena.trim()+" || " + dostepnosc.trim());
                            }
                            break;
                        case 2:
                            rent r1 = new rent();
                            System.out.println("Który samochód chcesz wypożyczyć? ");
                            int id = scan.nextInt();
                            r1.wypozycz(id, loginB);
                            break;
                        case 3:
                            rent r2 = new rent();
                            System.out.println("Który samochód chcesz zwrócic? ");
                            int idzwroc = scan.nextInt();
                            r2.zwroc(idzwroc, login);
                            break;
                        case 4:
                            rent r3 = new rent();
                            r3.jakieWypozyczone(loginB);
                            break;
                    }
                } while (b != 5);
            }
        }
    }
}
