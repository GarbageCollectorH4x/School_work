import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MultipleChoiceTest {

    @Test
    void checkAnswer()
    {
        TriviaQuestion ques = new MultipleChoice("Testing","testing","tester","test","tes","tesing");
        assertEquals("testing",ques.getAnswer());

    }
}