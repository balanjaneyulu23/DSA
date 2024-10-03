package com.dsa.recursion;

import java.util.ArrayList;
import java.util.List;

public class SubSetOfArray {

    public static void main(String[] args) {
        int[] arr = {3, 1, 2};
        //subset(new ArrayList<>(), arr, 0);
        System.out.println(subSetReturn(arr).toString());
    }

    static void subset(List<Integer> list, int[] arr, int index) {
        if (index == arr.length) {
            if (!list.isEmpty()) {
                System.out.println(list.toString());
            }
            return;
        }
        list.add(arr[index]);
        subset(list, arr, index + 1);
        list.removeLast();
        subset(list, arr, index + 1);


    }

    static List<List<Integer>> subSetReturn(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> help = new ArrayList<>();

        subSetHelp(help, nums, 0, ans);
        return ans;
    }

    static void subSetHelp(List<Integer> help, int[] nums,
                           int index, List<List<Integer>> ans) {
        System.out.println();
        if (index == nums.length) {
            ans.add(new ArrayList<>(help));
            return;
        }

        help.add(nums[index]);
        subSetHelp(help, nums, index + 1, ans);
        help.removeLast();
        subSetHelp(help, nums, index + 1, ans);
    }


}
