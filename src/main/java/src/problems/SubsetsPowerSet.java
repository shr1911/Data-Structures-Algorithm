package src.problems;

import java.util.ArrayList;
import java.util.List;

public class SubsetsPowerSet {

    private static List<List<Integer>> answer = new ArrayList();
    private static int n;

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};

        System.out.println(subsets(nums));
        System.out.println(subsetsBackTracking(nums));
    }

    //Time complexity:O(n * 2^n)
    //Space complexity: O(n* 2^n)
    public static List<List<Integer>> subsetsBackTracking(int[] nums) {
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        for(int num : nums){
            int n = outer.size();
            for(int i=0; i<n; i++){
                List<Integer> internal = new ArrayList<>(outer.get(i));
                internal.add(num);
                outer.add(internal);
            }
        }
        return outer;
    }



    //Time complexity: O(N×2N) to generate all subsets and then copy them into the output list.
    //Space complexity: O(N×2N). This is exactly the number of solutions for subsets multiplied by the number N of elements to keep for each subset.
    public static List<List<Integer>> subsets(int[] nums) {
        answer.add(new ArrayList<>());

        for (int num : nums) {
            List<List<Integer>> newSubSets = new ArrayList<>();
            for (List<Integer> current: answer) {
                List<Integer> temp = new ArrayList<>(current);
                temp.add(num);
                newSubSets.add(temp);
            }

            for (List<Integer> current: newSubSets)
                answer.add(current);
        }

        return answer;
    }

}
