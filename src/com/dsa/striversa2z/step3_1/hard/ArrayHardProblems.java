package com.dsa.striversa2z.step3_1.hard;

import java.util.*;

public class ArrayHardProblems {
    public static void main(String[] args) {
        int[] nums = {2,3,-2,4};

        System.out.println(maxProduct(nums));
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

    static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int k = m + n - 1;
        int j = n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        while (i >= 0) {
            nums1[k--] = nums1[i--];
        }

        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }

    static ArrayList<Integer> findTwoElement(int arr[]) {
        long n = arr.length;
        long sn = ((long) n * (n + 1)) / 2;
        long s2n = (n * (n + 1) * (2L * n + 1)) / 6;

        //sum and squares of given array
        long s = 0, s2 = 0;
        for (int j : arr) {
            s += j;
            s2 += (long) j * j;
        }

        //finding x-y
        long val1 = s - sn;
        // finding x2-y2
        long val2 = s2 - s2n;

        //finding x-y
        val2 = val2 / val1;
        // finding x
        long x = ((val1 + val2) / 2);
        // finding y
        long y = (x - val1);

        ArrayList<Integer> list = new ArrayList<>();
        list.add((int) x);
        list.add((int) y);
        return list;
    }

    public static int mergeSort(int[] arr, int low, int high) {
        int cnt = 0;
        if (low >= high) return cnt;
        int mid = (low + high) / 2;
        cnt += mergeSort(arr, low, mid);  // left half
        cnt += mergeSort(arr, mid + 1, high); // right half
        cnt += countPairs(arr, low, mid, high); //Modification
        merge(arr, low, mid, high);  // merging sorted halves
        return cnt;
    }

    static int countPairs(int[] arr, int low, int mid, int high) {
        int right = mid + 1;
        int cnt = 0;
        for (int i = low; i <= mid; i++) {
            while (right <= high && arr[i] > (long) 2 * arr[right]) right++;
            cnt += (right - (mid + 1));
        }
        return cnt;
    }

    static void merge(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>(); // temporary array
        int left = low;      // starting index of left half of arr
        int right = mid + 1;   // starting index of right half of arr

        //storing elements in the temporary array in a sorted manner//

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
            }
        }

        // if elements on the left half are still left //

        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }

        //  if elements on the right half are still left //
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }

        // transfering all elements from temporary to arr //
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
    }

    public static int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    public static int maxProduct(int[] nums) {
        int pre = 1, suff = 1;
        int maxProd = Integer.MIN_VALUE;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            // to handle zero's
            if (pre == 0) pre = 1;
            if (suff == 0) suff = 1;

            pre *= nums[i];
            suff *= nums[n - 1 - i];

            maxProd = Math.max(maxProd, Math.max(pre, suff));
        }

        return maxProd;
    }
}
