package src.problems;

public class Print2DArraySpiralOrder {
    public static void main(String[] args) {
        int[][] input = {{2, 4, 6, 8}, {5, 9, 12, 16}, {2, 11, 5, 9}, {3, 2, 1, 8}};

        print2DArray(input);
    }

    // Time complexity = O(m * n)
    // Space complexity = O(1)
    public static void print2DArray(int[][] input){
        int top = 0;
        int bottom = input.length - 1;
        int left = 0;
        int right = input[0].length - 1;

        // 0 -> right, 1 -> top to bottom, 2 -> right to left, 3 -> bottom to top
        int direction = 0;

        while (top <= bottom && left <= right) {
            if (direction == 0) {
                for (int i = left; i <= right; i++) {
                    System.out.println(input[top][i]);
                }
                top++;
            } else if (direction == 1) {
                for (int i = top; i <= bottom; i++) {
                    System.out.println(input[i][right]);
                }
                right--;
            } else if (direction == 2) {
                for (int i = right; i >= left; i--) {
                    System.out.println(input[bottom][i]);
                }
                bottom--;
            } else if(direction == 3) {
                for (int i = bottom; i >= top; i--) {
                    System.out.println(input[i][left]);
                }
                left++;
            }
            direction = (direction + 1) % 4;
        }

    }

}