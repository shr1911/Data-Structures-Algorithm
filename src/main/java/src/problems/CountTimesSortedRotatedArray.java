package src.problems;

//How many times is a sorted array rotated?
// No duplicates present in the array

// Solution - find index of minimum element in the array, and we are done
public class CountTimesSortedRotatedArray {
    public static void main(String[] args) {
        int[] inputArray = {9, 10, 11, 12, 2, 3, 5, 8};
        System.out.println(checkRotation(inputArray));
    }

    // no. of rotations = index of minimum element
    // Intuition -  linear search (Time - O(n))
    // Use property of the array called circularly sorted
    // Modified binary search - pivot property: next and prev are both greater
    // Time complexity - O(logn)
    public static int checkRotation(int[] inputArray) {
        int low = 0;
        int high = inputArray.length-1;

        while (low <= high) {
            // Case 1: found pivot
            if (inputArray[low] <= inputArray[high]) return low;

            int mid = low + (high-low)/2;
            int next = (mid + 1) % inputArray.length;
            int prev = (mid + inputArray.length - 1) % inputArray.length;

            //Case 2: found pivot
            if (inputArray[mid] <= inputArray[next] &&
                    inputArray[mid] <= inputArray[prev]) {
                return mid;
            } else if (inputArray[mid] <= inputArray[high])
                high = mid - 1;
            else if (inputArray[mid] >= inputArray[low])
                low = mid + 1;
        }
        return -1;
    }
}
