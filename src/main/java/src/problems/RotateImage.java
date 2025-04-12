package src.problems;

public class RotateImage {
    public static void main(String[] args) {
        int[][] inputMatrix = {{1,2,3},{4,5,6},{7,8,9}};
        rotate(inputMatrix);

        int[][] inputMatrix2 = {{1,2,3},{4,5,6},{7,8,9}};
        rotateApproach2(inputMatrix2);

    }

    //Transpose, and then reverse - Reverse on the Diagonal and then Reverse Left to Right
    //
    //Time complexity: O(M). We perform two steps; transposing the matrix, and then reversing each row. Transposing the matrix has a cost of O(M) because we're moving the value of each cell once. Reversing each row also has a cost of O(M), because again we're moving the value of each cell once.
    //
    //Space complexity: O(1) because we do not use any other additional data structures.
    public static void rotateApproach2(int[][] matrix) {
        transpose(matrix);
        reflect(matrix);
    }

    private static void reflect(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = tmp;
            }
        }
    }

    private static void transpose(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
    }

    //Time complexity: O(M), as each cell is getting read once and written once.
    //
    //Space complexity: O(1) because we do not use any other additional data structures.
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < (n + 1) / 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - j - 1];
                matrix[n - 1 - i][n - j - 1] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }
}
