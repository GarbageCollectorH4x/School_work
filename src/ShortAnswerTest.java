import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShortAnswerTest {

    @Test
    void checkAnswer()
    {
        TriviaQuestion ques = new ShortAnswer("test","testingbruh","tester");
        assertTrue(ques.checkAnswer("testingbruh"));
    }
}