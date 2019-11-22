//team: garbage collector
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
 

public class TriviaQuestion{

    private String      question;
    private String      answer;
    private String      hint;


   //Constructor
    public TriviaQuestion(String q, String a){

        this.question = q;

        this.answer =   a;

    }
    
    //Connectv to 3 DBs
    private Connection connection() {
        String MultChoiceDBPath = "jdbc:sqlite:C:/Users/Dell/Desktop/GitWork/classwork/School_work/Triviaquestions/MazeTriviaQuestions.db";
        String TrueFalseDBPath = "jdbc:sqlite:C:/Users/Dell/Desktop/GitWork/classwork/School_work/Triviaquestions/MazeTrueFalse.db";
        String ShortAnsDBPath = "jdbc:sqlite:C:/Users/Dell/Desktop/GitWork/classwork/School_work/Triviaquestions/ShortAnswer.db";

        Connection conn = null;
        Connection conn2 = null;
        Connection conn3 = null;
        try {
             conn = DriverManager.getConnection(MultChoiceDBPath);
             conn2 = DriverManager.getConnection(TrueFalseDBPath);
             conn3 = DriverManager.getConnection(ShortAnsDBPath);
        } 
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    
    public void selectAll() {
        String str = "SELECT * FROM MultipleChoice";
        
        try (Connection conn = this.connection();
             Statement stmt  = conn.createStatement();
             ResultSet resultset    = stmt.executeQuery(str)) {
            
            while (resultset.next()) {
                System.out.println(resultset.getInt("id") + ") " + 
                                  resultset.getString("question")+ "\r\n" +
                                  "A) "+ resultset.getString("incorrectAnswerA")+ "\r\n"+
                                  "B) " + resultset.getString("incorrectAnswerB")+ "\r\n"+
                                  "C) " + resultset.getString("correctAnswer")+ "\r\n"+
                                  "D) " + resultset.getString("incorrectAnswerC")+ "\r\n"+
                                  "Hint: " + resultset.getString("hint")+ "\r\n");
            }
        } 
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


}//end class TriviaQuestion