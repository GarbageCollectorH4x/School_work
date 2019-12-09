//team: garbage collector

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.sql.*;


public class Database {

    private ArrayList<TriviaQuestion> questionList;

    public Database() {
        this.questionList = new ArrayList<TriviaQuestion>();
        this.load();
    }

    private Connection connectDB() {
        String MultChoiceDBPath = "jdbc:sqlite:./QuestionDB.db";

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(MultChoiceDBPath);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    private void multiChoiceSelectAll() {
        String str = "SELECT * FROM MultipleChoice";

        try (Connection conn = this.connectDB();
             Statement stmt = conn.createStatement();
             ResultSet rst = stmt.executeQuery(str)) {

            while (rst.next()) {
                MultipleChoice multi = new MultipleChoice(rst.getString("question"), rst.getString("correctAnswer"), rst.getString("hint"), rst.getString("incorrectAnswerA"), rst.getString("incorrectAnswerB"), rst.getString("incorrectAnswerC"));
                questionList.add(multi);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void trueFalseSelectAll() {
        String str = "SELECT * FROM TrueFalse";

        try (Connection conn = this.connectDB();
             Statement stmt = conn.createStatement();
             ResultSet rst = stmt.executeQuery(str)) {

            while (rst.next()) {
                TrueFalse trueFalse = new TrueFalse(rst.getString("question"), rst.getString("answer"), rst.getString("hint"));
                questionList.add(trueFalse);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void shortAnswerSelectAll() {
        String str = "SELECT * FROM ShortAnswer";

        try (Connection conn = this.connectDB();
             Statement stmt = conn.createStatement();
             ResultSet rst = stmt.executeQuery(str)) {

            while (rst.next()) {
                ShortAnswer shortAns = new ShortAnswer(rst.getString("question"), rst.getString("answer"), rst.getString("hint"));
                questionList.add(shortAns);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //add question to Multi Choice DB
    public void addMultiChoiceQuestion(String question, String answer, String incorrectAnswer1, String incorrectAnswer2, String incorrectAnswer3, String hint) {
        String sql = "INSERT INTO MultipleChoice(question, correctAnswer, incorrectAnswerA, incorrectAnswerB, incorrectAnswerC, hint) VALUES(?,?,?,?,?,?)";

        try (Connection conn = this.connectDB();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, question);
            pstmt.setString(2, answer);
            pstmt.setString(3, incorrectAnswer1);
            pstmt.setString(4, incorrectAnswer2);
            pstmt.setString(5, incorrectAnswer3);
            pstmt.setString(6, hint);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //add question to Truefalse DB
    public void addTrueFalseQuestion(String question, String answer, String hint) {
        String sql = "INSERT INTO TrueFalse(question, answer, hint) VALUES(?,?,?)";

        try (Connection conn = this.connectDB();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, question);
            pstmt.setString(2, answer);
            pstmt.setString(3, hint);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //add question to ShortAnswer DB
    public void addShortAnsQuestion(String question, String answer, String hint) {
        String sql = "INSERT INTO ShortAnswer(question, answer, hint) VALUES(?,?,?)";

        try (Connection conn = this.connectDB();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, question);
            pstmt.setString(2, answer);
            pstmt.setString(3, hint);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public void load() {

        this.multiChoiceSelectAll();
        this.trueFalseSelectAll();
        this.shortAnswerSelectAll();
        Collections.shuffle(this.questionList);

    }


    public ArrayList<TriviaQuestion> getList() {

        return this.questionList;

    }


}