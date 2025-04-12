package test;

import org.junit.Before;
import org.junit.Test;
import src.problems.WordSearchMatrix;

import static org.junit.Assert.*;

public class WordSearchMatrixTest {

    private WordSearchMatrix wordSearchMatrix;

    @Before
    public void setup(){
        wordSearchMatrix = new WordSearchMatrix();
    }


    @Test
    public void testWordExists(){
        char[][] input = {{'C', 'C', 'C', 'C'}, {'C', 'A', 'B', 'C'}, {'C', 'B', 'B', 'A'}, {'C','C','C','C'}};
        String word = "ABBA";

        boolean isWordPResent = wordSearchMatrix.exist(input, word);

        // assertEquals(true, isWordPResent); // expected, actual
        assertTrue(isWordPResent);

    }
}
