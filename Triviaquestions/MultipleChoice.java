import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 

public class MultipleChoice {
 
    private Connection connect() {
        String dbPath = "jdbc:sqlite:C:/Users/Dell/Desktop/Triviaquestions/MazeTriviaQuestions.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(dbPath);
        } 
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
 
   public void selectAll() {
        String str = "SELECT * FROM MultipleChoice";
        
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet resultset    = stmt.executeQuery(str)) {
            
            while (resultset.next()) {
                System.out.println(resultset.getInt("id") + ") " + 
                                  resultset.getString("question")+ "\r\n" +
                                  "A) "+ resultset.getString("incorrectAnswerA")+ "\r\n"+
                                  "B) " + resultset.getString("incorrectAnswerB")+ "\r\n"+
                                  "C) " + resultset.getString("correctAnswer")+ "\r\n"+
                                  "D) " + resultset.getString("incorrectAnswerC")+ "\r\n");
            }
        } 
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        SelectApp sapplication = new SelectApp();
        sapplication.selectAll();
    }
 
}