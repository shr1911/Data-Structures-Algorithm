package src.problems;

public class SearchElementInCircularSortedArray {
    public static void main(String[] args) {
        int[] input = {12, 14, 18, 21, 3, 6, 8, 9};

        System.out.println(findElement(input, 8));
    }

    // Time complexity - O(logn)
    public static int findElement(int[] input, int x) {
        int low = 0;
        int high = input.length - 1;

        while (low <= high) {
            int mid = low + (high-low) /2;

            if (input[mid] == x) return mid;

            if (input[mid] <= input[high]) {
                if (x > input[mid] && x <= input[high]) {
                    low = mid + 1;
                } else {
                    high = mid -1;
                }
            } else {
                if (input[low] <= x && x < input[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }

        return -1;
    }
}
