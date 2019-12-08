import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.sql.*;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {

    Connection conn1,conn2,conn3;
    Database db;
    @BeforeEach
    void setUp() throws Exception
    {
        conn1 = DriverManager.getConnection("jdbc:sqlite:./MazeTriviaQuestions.db");
        conn2 = DriverManager.getConnection("jdbc:sqlite:./MazeTrueFalse.db");
        conn3 = DriverManager.getConnection("jdbc:sqlite:./ShortAnswer.db");
        db = new Database();
    }

    @AfterEach
    void tearDown() throws SQLException {
        conn1.close();
        conn2.close();
        conn3.close();
    }


    @Test
    void addMultiChoiceQuestion() throws Exception
    {
        db.addMultiChoiceQuestion("testing","testing","te","ting","ing","testing");

        String str = "SELECT * FROM MultipleChoice where question = \"testing\"";

        Statement stmt = conn1.createStatement();
        ResultSet rst = stmt.executeQuery(str);

        String ans = rst.getString("correctAnswer");
        assertEquals("testing",ans);
        System.out.println("test passed");

        String str1 = "DELETE FROM MultipleChoice where question = \"testing\"";
        Statement stmt1 = conn1.createStatement();
        stmt1.executeUpdate(str1);

    }

    @Test
    void addTrueFalseQuestion() throws Exception
    {
        db.addTrueFalseQuestion("testing","testing","te");

        String str = "SELECT * FROM TrueFalse where question = \"testing\"";

        Statement stmt = conn2.createStatement();
        ResultSet rst = stmt.executeQuery(str);

        String ans = rst.getString("answer");
        assertEquals("testing",ans);
        System.out.println("test passed");

        String str1 = "DELETE FROM TrueFalse where question = \"testing\"";
        Statement stmt1 = conn2.createStatement();
        stmt1.executeUpdate(str1);
    }

    @Test
    void addShortAnsQuestion() throws Exception
    {
        db.addShortAnsQuestion("testing","testing","te");

        String str = "SELECT * FROM ShortAnswer where question = \"testing\"";

        Statement stmt = conn3.createStatement();
        ResultSet rst = stmt.executeQuery(str);

        String ans = rst.getString("answer");
        assertEquals("testing",ans);
        System.out.println("test passed");

        String str1 = "DELETE FROM ShortAnswer where question = \"testing\"";
        Statement stmt1 = conn3.createStatement();
        stmt1.executeUpdate(str1);
    }
}