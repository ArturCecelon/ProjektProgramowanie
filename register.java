public class register {

    public void registerUser(String login, String haslo){
        ExecuteQuery.executeQuery("INSERT INTO customers (login, pass) VALUES('"+login+"', '"+haslo+"')");
        System.out.println("Gratulacje! Dodałes użytkownika do bazy!");
    }
}
