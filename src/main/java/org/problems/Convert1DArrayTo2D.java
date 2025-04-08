package org.problems;

import java.util.Arrays;

public class Convert1DArrayTo2D {
    public static void main(String[] args) {
        int[] original = {1,2,3,4};
        int m = 2, n = 2;

        System.out.println(Arrays.deepToString(construct2DArray(original, m, n)));

    }

    //Time complexity: O(m×n)
    //
    //The algorithm initializes a 2D array and fills it using nested loops. The outer loop runs m times and the inner loop runs n times. Thus, the total number of iterations is m×n, which equals a time complexity of O(m×n).
    //
    //Space complexity: O(1)
    //
    //The output array has a space complexity of O(m×n). However, we do not consider input and output space as part of our space complexity calculations. Thus, the space complexity of the algorithm is constant.
    public static int[][] construct2DArray(int[] original, int m, int n) {
        if (m*n != original.length) {
            return new int[0][0];
        }

        int[][] result = new int[m][n];

        int index = 0;

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                result[i][j] = original[index];
                index++;
            }
        }

        // Second logic
        //for (int i = 0; i < original.length; i++) {
        //            resultArray[i / n][i % n] = original[i];
        //        }

        return result;

    }
}
