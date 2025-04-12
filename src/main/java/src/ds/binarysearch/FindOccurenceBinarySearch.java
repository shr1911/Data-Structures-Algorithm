package src.ds.binarysearch;

public class FindOccurenceBinarySearch {
    public static void main(String[] args) {
        int[] inputArray = {2, 4, 10, 10, 10, 18, 20};
        System.out.println(findFirstOccurence(inputArray, 10));
        System.out.println(findLastOccurence(inputArray, 10));
        System.out.println(findCount(inputArray, 10));

    }

    // Time complexity - O(logn)
    private static int findCount(int[] inputArray, int num) {
        int first = findFirstOccurence(inputArray, num); // O(logn)
        int last = findLastOccurence(inputArray, num); // O(logn)

        return last - first + 1;
    }

    // Time complexity - O(logn)
    // space complexity -
    public static int findFirstOccurence(int[] inputArray, int data) {
        int low = 0;
        int high = inputArray.length - 1;
        int result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (data == inputArray[mid]) {
                result = mid;
                high = mid - 1;
            }
            else if (data < inputArray[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return result;
    }

    public static int findLastOccurence(int[] inputArray, int data) {
        int low = 0;
        int high = inputArray.length - 1;
        int result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (data == inputArray[mid]) {
                result = mid;
                low = mid + 1;
            }
            else if (data < inputArray[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return result;
    }
}
