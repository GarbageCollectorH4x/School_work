import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
 

public class TrueFalse {
 
    private Connection connect() {
        String dbPath = "jdbc:sqlite:C:/Users/Dell/Desktop/GitWork/classwork/School_work/Triviaquestions/MazeTrueFalse.db";
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
        String str = "SELECT * FROM TrueFalse";
        
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet resultset    = stmt.executeQuery(str)) {
            
            while (resultset.next()) {
                System.out.println(resultset.getInt("id") + ") " + 
                                  resultset.getString("question")+ "\r\n" +
                                  "Answer(0 equals false, 1 equals true) "+ resultset.getString("answer")+ "\r\n"+
                                  "Wrong Answer " + resultset.getString("incorrectAnswer")+ "\r\n"+
                                  "Hint) " + resultset.getString("hint")+ "\r\n"+
            }
            
        } 
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        MultipleChoice mchoice = new MultipleChoice();
        mchoice.selectAll();
        
     
        }
    }
