//team: garbage collector
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
 

public class Database{

    private static String      question;
    private static String      answer;
    private static String      hint;
   
    static ArrayList<String> questions = new ArrayList<String>();


   //Constructor
    public TriviaQuestion(String q, String a, String h){

        this.question = q;

        this.answer =   a;
       
        this.hint = h;

    }
   
    //Connectv to 3 DBs
    private Connection connection() {
        //String MultChoiceDBPath = "jdbc:sqlite:C:/Users/kdudani/Desktop/Triviaquestions/MazeTriviaQuestions.db";
        //String TrueFalseDBPath = "jdbc:sqlite:C:/Users/kdudani/Desktop/Triviaquestions/MazeTrueFalse.db";
        //String ShortAnsDBPath = "jdbc:sqlite:C:/Users/kdudani/Desktop/Triviaquestions/ShortAnswer.db";
        
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
   
      void selectAll() {
        String str = "SELECT * FROM MultipleChoice";
       
        try (Connection conn = this.connection();
             Statement stmt  = conn.createStatement();
             ResultSet resultset    = stmt.executeQuery(str)) {
           
            while (resultset.next()) {
                questions.add(resultset.getString("question"));
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
   //for testing only
   public static void main(String[] args) {
        TriviaQuestion trivia = new TriviaQuestion(question, answer, hint);
        trivia.selectAll();
        System.out.println(questions);

        }
    }
