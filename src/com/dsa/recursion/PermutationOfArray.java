package com.dsa.recursion;

import java.util.ArrayList;
import java.util.List;

public class PermutationOfArray {
    public static void main(String[] args) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        int[] nums = {1, 2, 3};
        boolean[] freqArr = new boolean[nums.length];
        permutateOfArrary(nums, ds, ans, freqArr);

        System.out.println(ans.toString());
    }

    static void permutateOfArrary(int[] nums, List<Integer> ds,
                                  List<List<Integer>> ans, boolean[] freArr) {
        System.out.println("recursion begin");
        if (ds.size() == nums.length) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!freArr[i]) {
                freArr[i] = true;
                ds.add(nums[i]);
                permutateOfArrary(nums, ds, ans, freArr);
                ds.removeLast();
                freArr[i] = false;
            }
        }

    }
}
