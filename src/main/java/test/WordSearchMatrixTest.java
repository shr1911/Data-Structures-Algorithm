package test;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import src.problems.WordSearchMatrix;

import static org.junit.Assert.assertTrue;


// https://medium.com/@keployio/junit-mocking-a-complete-guide-43965665c29f
@RunWith(MockitoJUnitRunner.class)
public class WordSearchMatrixTest {


    @InjectMocks
    WordSearchMatrix wordSearchMatrix;

    @Before
    public void setup(){
    }


    @Test
    public void testWordExists(){
        char[][] input = {{'C', 'C', 'C', 'C'}, {'C', 'A', 'B', 'C'}, {'C', 'B', 'B', 'A'}, {'C','C','C','C'}};
        String word = "ABBA";

        boolean isWordPResent = wordSearchMatrix.exist(input, word);

        System.out.println(isWordPResent);
        // assertEquals(true, isWordPResent); // expected, actual
        assertTrue(isWordPResent);
    }
}
