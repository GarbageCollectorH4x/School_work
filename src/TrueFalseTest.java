import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrueFalseTest {

    @Test
    void checkAnswer()
    {
        TriviaQuestion ques = new TrueFalse("Test question","f","tester");
        assertEquals("f",ques.getAnswer());

    }
    
}
