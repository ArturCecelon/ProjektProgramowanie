import java.sql.ResultSet;
import java.sql.SQLException;

public class rent {
    public void wypozycz(int id, String login){
        try{
            ResultSet result = ExecuteQuery.executeSelect("SELECT * FROM rent WHERE id_sam = "+id);
            if(result.next()){
                System.out.println("Samochód nie jest obecnie dostępny! ");
            }
            else{
                ExecuteQuery.executeQuery("UPDATE cars SET czydostepny = 'false' WHERE id = "+id);
                ExecuteQuery.executeQuery("INSERT INTO rent (id_sam) VALUES("+id+")");
                ExecuteQuery.executeQuery("UPDATE rent SET login_user = '"+login+"' WHERE id_sam = "+id);
                System.out.println("Brawo wypożyczyłeś samochod o id "+id);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void zwroc(int id, String login){
        try{
            ResultSet result = ExecuteQuery.executeSelect("SELECT * FROM rent WHERE id_sam = "+id+" AND login_user = '"+login+"'");
            if(result.next()){
                ExecuteQuery.executeQuery("DELETE FROM rent where id_sam = "+id);
                ExecuteQuery.executeQuery("UPDATE cars SET czydostepny = 'true' WHERE id = "+id);
                System.out.println("Oddałes samochód o id: "+id);
            }
            else{
                System.out.println("Nie możesz zwrócic samochodu, któego nie wypożyczyłeś! ");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void jakieWypozyczone(String login) throws SQLException {
        ResultSet result = ExecuteQuery.executeSelect("SELECT * FROM rent WHERE login_user = '"+login+"'");
        System.out.println("Twoje samochody: ");
        while(result.next()){
            int id = result.getInt("id_sam");
            ResultSet result1 = ExecuteQuery.executeSelect("SELECT * FROM cars WHERE id = "+id);
            while(result1.next()){
                int idresult = result1.getInt("id");
                String marka = result1.getString("marka");
                String typ = result1.getString("typ");
                System.out.println(idresult+" "+marka+" "+typ);
            }
        }
    }

}
