package src.problems;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] input = {100,4,200,1,3,2};

        System.out.println(longestConsecutive(input));
    }

    //Time complexity : O(n).
    //
    //Although the time complexity appears to be quadratic due to the while
    //loop nested within the for loop, closer inspection reveals it to be
    //linear. Because the while loop is reached only when currentNum marks
    //the beginning of a sequence (i.e. currentNum-1 is not present in
    //nums), the while loop can only run for n iterations throughout the
    //entire runtime of the algorithm. This means that despite looking like
    //O(n⋅n) complexity, the nested loops actually run in O(n+n)=O(n)
    //time. All other computations occur in constant time, so the overall
    //runtime is linear.
    //
    //Space complexity : O(n).
    //
    //In order to set up O(1) containment lookups, we allocate linear space
    //for a hash table to store the O(n) numbers in nums. Other than that,
    //the space complexity is identical to that of the brute force solution.
    public static int longestConsecutive(int[] nums) {
        Set<Integer> num_set = new HashSet<>();
        for (int num: nums) {
            num_set.add(num);
        }

        int longestStreak = 0;

        for (int num: num_set) {
            if (!num_set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (num_set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return  longestStreak;
    }

}
