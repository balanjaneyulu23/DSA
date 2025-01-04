package com.dsa.striversa2z.step3_1.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayHardProblems {
    public static void main(String[] args) {
        int[] nums = {-2,0,1,1,2};
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> answerList = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || i == j) {
                    list.add(1);
                } else {
                    int elem1 = answerList.get(i - 1).get(j - 1);
                    int elem2 = answerList.get(i - 1).get(j);
                    list.add(elem1 + elem2);
                }
            }
            answerList.add(list);

        }
        return answerList;

    }

    static List<Integer> majorityElement(int[] nums) {
        int ele1 = Integer.MAX_VALUE, ele2 = Integer.MAX_VALUE;
        int cnt1 = 0, cnt2 = 0;

        for (int number : nums) {
            if (cnt1 == 0 && number != ele2) {
                cnt1 = 1;
                ele1 = number;
            } else if (cnt2 == 0 && number != ele1) {
                cnt2 = 1;
                ele2 = number;
            } else if (ele1 == number) {
                cnt1++;

            } else if (ele2 == number) {
                cnt2++;
            } else {
                cnt2--;
                cnt1--;
            }
        }

        cnt1 = 0;
        cnt2 = 0;
        for (int num : nums) {
            if (num == ele1) {
                cnt1++;
            }
            if (num == ele2) {
                cnt2++;
            }
        }

        List<Integer> result = new ArrayList<>();
        if (cnt1 > nums.length / 3) {
            result.add(ele1);
        }

        if (cnt2 > nums.length / 3) {
            result.add(ele2);
        }
        return result;
    }

    /**
     * 3Sum leetcode#15
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        int arrSize = nums.length;
        // sort an array
        Arrays.sort(nums);
        for (int i = 0; i < arrSize; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1;
            int k = arrSize - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    answer.add(list);
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) j++;
                    while (j < k && nums[k] == nums[k+1]) k--;
                }
            }

        }
        return answer;

    }
}
