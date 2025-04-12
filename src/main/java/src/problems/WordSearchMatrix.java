package src.problems;

public class WordSearchMatrix {
    private char[][] board;
    private int ROWS;
    private int COLS;

    public static void main(String[] args) {

    }

    public boolean exist(char[][] input, String word) {
        board = input;
        ROWS = board.length;
        COLS = board[0].length;
        
        for (int row=0; row<ROWS; row++) {
            for (int col=0; col<COLS; col++) {
                if (backtrack(row, col, word, 0))
                    return true;
            }
        }

        return false;
    }

    //me Complexity: O(N⋅3
    //L
    // ) where N is the number of cells in the board and L is the length of the word to be matched.
    //
    //For the backtracking function, initially we could have at most 4 directions to explore, but further the choices are reduced into 3 (since we won't go back to where we come from).
    //As a result, the execution trace after the first step could be visualized as a 3-nary tree, each of the branches represent a potential exploration in the corresponding direction. Therefore, in the worst case, the total number of invocation would be the number of nodes in a full 3-nary tree, which is about 3
    //L
    // .
    //
    //We iterate through the board for backtracking, i.e. there could be N times invocation for the backtracking function in the worst case.
    //
    //As a result, overall the time complexity of the algorithm would be O(N⋅3
    //L
    // ).
    //
    //Space Complexity: O(L) where L is the length of the word to be matched.
    //
    //The main consumption of the memory lies in the recursion call of the backtracking function. The maximum length of the call stack would be the length of the word. Therefore, the space complexity of the algorithm is O(L).
    private boolean backtrack(int row, int col, String word, int index) {
        /* Step 1). check the bottom case. */
        if (index >= word.length()) return true;

        /* Step 2). Check the boundaries. */
        if (row < 0 || row == ROWS || col < 0 || col == COLS
                || board[row][col] != word.charAt(index))
            return false;

        /* Step 3). explore the neighbors in DFS */
        // mark the path before the next exploration
        board[row][col] = '#';

        int[] rowOffsets = {0, 1, 0, -1};
        int[] colOffsets = {1, 0, -1, 0};

        for (int direction =0; direction < 4; direction++) {
            if (backtrack(
                    row + rowOffsets[direction],
                    col + colOffsets[direction],
                    word,
                    index + 1
            ))
                return true;
        }

        /* Step 4). clean up and return the result. */
        board[row][col] = word.charAt(index);
        return false;
    }
}
