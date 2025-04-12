package src.problems;

public class FindTheDuplicate {
    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 2, 2};
        System.out.println(findDuplicate(nums));
    }

    //Time Complexity: O(n)
    //
    //Each element is visited at most twice (once in the first loop to find the duplicate and once in the second loop to restore the numbers).
    //
    //Space Complexity: O(1)
    //
    //All manipulation is done in place, so no additional storage (barring one variable) is needed.
    public static int findDuplicate(int[] nums) {
        int duplicate = -1;
        for (int i = 0; i < nums.length; i++) {
            int cur = Math.abs(nums[i]);
            if (nums[cur] < 0) {
                duplicate = cur;
                break;
            }
            nums[cur] *= -1;
        }

        // Restore numbers
        for (int i = 0; i < nums.length; i++)
            nums[i] = Math.abs(nums[i]);

        return duplicate;
    }
}