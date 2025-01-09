package com.dsa.striversa2z.step3_1.hard;

import java.util.*;

public class ArrayHardProblems {
    public static void main(String[] args) {
        int[][] nums = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println(mergeOptimal(nums));
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
     *
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
                    while (j < k && nums[k] == nums[k + 1]) k--;
                }
            }

        }
        return answer;

    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        //sort the array
        Arrays.sort(nums);
        int arrSize = nums.length;
        //result list
        List<List<Integer>> answer = new ArrayList<>();
        for (int i = 0; i < arrSize; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < arrSize; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1]) continue;
                int k = j + 1;
                int l = arrSize - 1;
                while (k < l) {
                    long sum = nums[i];
                    sum += nums[j];
                    sum += nums[k];
                    sum += nums[l];
                    if (sum > target) {
                        l--;
                    } else if (sum < target) {
                        k++;
                    } else {
                        answer.add(Arrays.asList(nums[i],
                                nums[j], nums[k], nums[l]));
                        k++;
                        l--;
                        while (k < l && nums[k] == nums[k - 1]) {
                            k++;
                        }

                        while (k < l && nums[l] == nums[l + 1]) {
                            l--;
                        }
                    }

                }

            }

        }
        return answer;
    }

    static int maxLen(int arr[]) {
        //store prefix sum as a key and it's index as value
        Map<Integer, Integer> map = new HashMap<>();
        int maxLen = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == 0) {
                maxLen = i + 1;
            } else {
                if (map.containsKey(sum)) {
                    maxLen = Math.max(maxLen, i - map.get(sum));
                } else {
                    map.put(sum, i);
                }
            }
        }

        return maxLen;
    }

    static int subArrayXORK(int[] a, int k) {
        int n = a.length;
        int xr = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int j : a) {
            xr = xr ^ j;
            int x = xr ^ k;
            if (map.containsKey(x)) {
                count = count + map.get(x);
            }

            if (map.containsKey(xr)) {
                map.put(xr, map.get(xr) + 1);
            } else {
                map.put(xr, 1);
            }
        }

        return count;
    }

    public static List<List<Integer>> merge(int[][] intervals) {
        List<List<Integer>> answer = new ArrayList<>();
        int n = intervals.length;
        //sorting the given array intervals
        Arrays.sort(intervals, (int[] a, int[] b) -> {
            return a[0] - b[0];
        });

        for (int i = 0; i < n; i++) { // select an interval:
            int start = intervals[i][0];
            int end = intervals[i][1];
            List<Integer> list = new ArrayList<>();

            //Skip all the merged intervals:
            if (!answer.isEmpty() && answer.getLast().getLast() >= end) {
                continue;
            }

            //check the rest of the intervals:
            for (int j = i + 1; j < n; j++) {
                if (end >= intervals[j][0]) {
                    end = Math.max(end, intervals[j][1]);
                } else {
                    break;
                }

            }
            list.add(start);
            list.add(end);
            answer.add(list);

        }
        return answer;
    }

    static int[][] mergeOptimal(int[][] intervals) {
        List<List<Integer>> ansList = new ArrayList<>();

        //sort an array
        Arrays.sort(intervals, (int[] a, int[] b) -> a[0] - b[0]);

        for (int i = 0; i < intervals.length; i++) {
            if (ansList.isEmpty() || intervals[i][0] > ansList.getLast().getLast()) {
                ansList.add(Arrays.asList(intervals[i][0], intervals[i][1]));
            } else {
                ansList.getLast().set(1, Math.max(ansList.getLast().get(1), intervals[i][1]));
            }
        }
        return ansList.stream()
                .map(l -> l.stream()
                .mapToInt(Integer::intValue).toArray()).toArray(int[][]::new);
    }
}
