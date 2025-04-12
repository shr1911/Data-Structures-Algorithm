package src.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsPowerSet2 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};

        System.out.println(subsetsWithDup(nums));

    }

    public List<List<Integer>> subsetsWithDupBackTracking(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> subsets = new ArrayList<>();
        List<Integer> currentSubset = new ArrayList<>();

        subsetsWithDupHelper(subsets, currentSubset, nums, 0);
        return subsets;
    }

    //Time complexity: O(n⋅2)
    //Space complexity: O(n) - The recursion call stack occupies at most O(n) space. The output list of subsets is not considered while analyzing space complexity. So, the space complexity of this approach is O(n).
    private void subsetsWithDupHelper(
            List<List<Integer>> subsets,
            List<Integer> currentSubset,
            int[] nums,
            int index
    ) {
        // Add the subset formed so far to the subsets list.
        subsets.add(new ArrayList<>(currentSubset));

        for (int i = index; i < nums.length; i++) {
            // If the current element is a duplicate, ignore.
            if (i != index && nums[i] == nums[i - 1]) {
                continue;
            }
            currentSubset.add(nums[i]);
            subsetsWithDupHelper(subsets, currentSubset, nums, i + 1);
            currentSubset.remove(currentSubset.size() - 1);
        }
    }


    //Time complexity: O(n⋅2n)
    //At first, we need to sort the given array which adds O(nlogn) to the time complexity.
    // Next, we use two for loops to create all possible subsets.
    // In the worst case, i.e., with an array of n distinct integers, we will have a total of 2n subsets.
    // Thus the two for loops will add O(2n) to time complexity. Also in the inner loop, we deep copy the previously generated subset before adding the current integer (to create a new subset).
    // This in turn requires the time of order n as the maximum number of elements in the currentSubset will be at most n.
    // Thus, the time complexity in the subset generation step using two loops is O(n⋅2n). Thereby, the overall time complexity is O(nlogn+n⋅2n) = O(n⋅(logn+2n)) ~ O(n⋅2n).
    //
    //Space complexity: O(logn)
    //The space complexity of the sorting algorithm depends on the implementation of each programming language. For instance, in Java, the Arrays.sort() for primitives is implemented as a variant of quicksort algorithm whose space complexity is O(logn). In C++ sort() function provided by STL is a hybrid of Quick Sort, Heap Sort and Insertion Sort with the worst case space complexity of O(logn). Thus the use of inbuilt sort() function adds O(logn) to space complexity.
    //The space required for the output list is not considered while analyzing space
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<Integer>());

        int subsetSize = 0;

        for (int i=0; i<nums.length; i++) {
            int startIndex = (i>=1 && nums[i] == nums[i-1]) ? subsetSize : 0;


            //// subsetSize refers to the size of the subset in the previous step. This value also indicates the starting index of the subsets generated in this step.
            subsetSize = subsets.size();

            for (int j = startIndex; j < subsetSize; j++) {
                List<Integer> currentSubset = new ArrayList<>(subsets.get(j));
                currentSubset.add(nums[i]);
                subsets.add(currentSubset);
            }
        }

        return subsets;
    }
}
