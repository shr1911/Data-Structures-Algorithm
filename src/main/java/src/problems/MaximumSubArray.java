package src.problems;

public class MaximumSubArray {
    public static void main(String[] args) {
        int[] arr = {1, -3, 2, -5, 7, 6, -1, -4, 11, -23};

        System.out.println(maximum_sub_array_bruteforce(arr, arr.length));
    }

    // Kadane's Algorithm - works only if array contains at least 1 positive value. Hence, intializing sum by 0.
    // If array contains all negative value, then have a separate check if all values negative, if so return maximum out of it.
    // Time complexity - O(n)
    // Space complexity - O(1)
    public static int maxSubArrayKadanesAlgo(int[] arr, int n) {
        int ans = 0, sum = 0;

        for (int i = 0; i < n; i++) {
            if (sum + arr[i] > 0) {
                sum += arr[i];
            } else {
                sum = 0;
            }
        }
        return ans;
    }

        //Time complexity - n(nlogn)
    //space complexity - O(log n)
    public static int maxSubArrayDivideConquer(int[] arr, int n) {
        if (n == 1) {
            return arr[0];
        }

        int m = n / 2;

        int[] leftPart = new int[m];
        int[] rightPart = new int[n - m];
        System.arraycopy(arr, 0, leftPart, 0, m);
        System.arraycopy(arr, m, rightPart, 0, n - m);

        int leftMSS = maxSubArrayDivideConquer(leftPart, m);
        int rightMSS = maxSubArrayDivideConquer(rightPart, n - m);

        int leftSum = Integer.MIN_VALUE;
        int rightSum = Integer.MIN_VALUE;
        int sum = 0;

        // Right half (starting from middle to end)
        for (int i = m; i < n; i++) {
            sum += arr[i];
            rightSum = Math.max(rightSum, sum);
        }

        sum = 0;

        // Left half (from m-1 to 0)
        for (int i = m - 1; i >= 0; i--) {
            sum += arr[i];
            leftSum = Math.max(leftSum, sum);
        }

        int crossSum = leftSum + rightSum;

        return Math.max(Math.max(leftMSS, rightMSS), crossSum);
    }

    // Time complexity - O(n*2)
    public static int maximum_sub_array_bruteforce(int[] arr, int size) {
        int ans = Integer.MIN_VALUE;

        for (int start_index = 0; start_index < size; start_index++) {
            int sum = 0;

            for (int sub_array_size = 1; sub_array_size <= size ; sub_array_size++) {
                if (start_index + sub_array_size > size)
                    break;

                sum += arr[start_index + sub_array_size - 1];
                ans = Math.max(ans, sum);
            }
        }
        return ans;
    }

}
