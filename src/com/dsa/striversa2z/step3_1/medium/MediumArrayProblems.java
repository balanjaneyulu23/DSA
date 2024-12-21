package com.dsa.striversa2z.step3_1.medium;

import java.util.*;

public class MediumArrayProblems {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));

    }

    static int[] twoSumArrPrblm(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int arrSize = nums.length;
        for (int i = 0; i < arrSize; i++) {
            int num = nums[i];
            int neededMore = target - num;
            if (map.containsKey(neededMore)) {
                return new int[]{i, map.get(neededMore)};
            }
            map.put(num, i);
        }

        return new int[]{-1, -1};
    }

    static int[] twoSumArrPrblmOptimal(int[] nums, int target) {
        int arrSize = nums.length;
        int[] originalArr = Arrays.copyOf(nums, arrSize);
        int leftPointer = 0;
        int rightPointer = arrSize - 1;
        Arrays.sort(nums);
        int num1 = 0, num2 = 0;
        while (leftPointer < rightPointer) {
            int sum = nums[leftPointer] + nums[rightPointer];

            if (sum == target) {
                num1 = nums[leftPointer];
                num2 = nums[rightPointer];
                break;
            }

            if (sum < target) {
                leftPointer++;
            } else {
                rightPointer--;
            }
        }

        int[] ans = {-1, -1};
        for (int i = 0; i < arrSize; i++) {
            if (num1 == originalArr[i]) {
                if (ans[0] == -1) {
                    ans[0] = i;
                    continue;
                }
            }

            if (num2 == originalArr[i]) {
                if (ans[1] == -1) {
                    ans[1] = i;
                }
            }

        }

        return ans;
    }

    public static void sortColors(int[] nums) {
        int arrSize = nums.length;
        int zeroCount = 0, oneCount = 0, twoCount = 0;
        for (int num : nums) {
            if (num == 0) {
                zeroCount++;
                continue;
            }

            if (num == 1) {
                oneCount++;
                continue;
            }

            if (num == 2) {
                twoCount++;
            }
        }
        for (int i = 0; i < arrSize; i++) {
            if (i < zeroCount) {
                nums[i] = 0;
                continue;
            }

            if (i < (zeroCount + oneCount)) {
                nums[i] = 1;
                continue;
            }

            if (i < (zeroCount + oneCount + twoCount)) {
                nums[i] = 2;
            }
        }
    }

    public static void sortColorsOptimal(int[] nums) {
        int arrSize = nums.length;
        int mid = 0, low = 0, high = arrSize - 1;
        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, mid, low);
                mid++;
                low++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swap(nums, mid, high);
                high--;
            }
        }
    }


    private static void swap(int[] nums, int mid, int low) {
        if (mid == low) {
            return;
        }
        int temp = nums[mid];
        nums[mid] = nums[low];
        nums[low] = temp;
    }

    static int majorityElement(int[] nums) {
        int arrSize = nums.length;
        int count = 0;
        int ele = 0;
        for (int i = 0; i <= arrSize - 1; i++) {
            if (count == 0) {
                ele = nums[i];
                count = 1;
            } else if (ele == nums[i]) {
                count++;
            } else {
                count--;
            }
        }

        int cnt = 0;
        for (int num : nums) {
            if (num == ele) {
                cnt++;
            }
        }

        if (cnt > arrSize / 2) {
            return ele;
        }

        return -1;

    }

    static int maxSubarraySum(int[] arr) {
        int res = arr[0];

        // Outer loop for starting point of subarray
        for (int i = 0; i < arr.length; i++) {
            int currSum = 0;

            // Inner loop for ending point of subarray
            for (int j = i; j < arr.length; j++) {
                currSum = currSum + arr[j];

                // Update res if currSum is greater than res
                res = Math.max(res, currSum);
            }
        }
        return res;
    }

    static int maxSubarraySumOptionalKadanesAlg(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int start = 0, ansStart = -1, ansEnd = -1;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum == 0) {
                start = i;
            }

            sum += nums[i];
            if (sum > maxSum) {
                maxSum = sum;
                ansStart = start;
                ansEnd = i;
            }

            if (sum < 0) {
                sum = 0;
            }
        }

        //Printing sub array
        for (int i = ansStart; i <= ansEnd; i++) {
            System.out.println(nums[i]);

        }
        return maxSum;
    }

    static int pairWithMaxSum(int[] arr) {
        int minMaxSum = 0;
        int arrSize = arr.length;
        for (int i = 0; i <= arrSize - 2; i++) {
            for (int j = i + 1; j <= arrSize - 1; j++) {
                int firstMin = Integer.MAX_VALUE;
                int secondMin = Integer.MAX_VALUE;
                int sum;
                for (int k = i; k <= j; k++) {
                    if (firstMin > arr[k]) {
                        secondMin = firstMin;
                        firstMin = arr[k];
                    } else if (secondMin > arr[k]) {
                        secondMin = arr[k];
                    }
                }
                sum = secondMin + firstMin;
                minMaxSum = Math.max(minMaxSum, sum);
            }
        }

        return minMaxSum;
    }

    static int maxProfit(int[] prices) {
        int arrSize = prices.length;
        int maxProfit = 0;
        for (int i = 0; i < arrSize - 1; i++) {
            for (int j = i + 1; j <= arrSize - 1; j++) {
                if (prices[j] > prices[i]) {
                    int profit = prices[j] - prices[i];
                    maxProfit = Math.max(maxProfit, profit);
                }
            }

        }
        return maxProfit;
    }

    static int maxProfitOptimal(int[] prices) {
        int minPrice = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > minPrice) {
                int profit = prices[i] - minPrice;
                maxProfit = Math.max(profit, maxProfit);
            } else {
                minPrice = prices[i];
            }
        }

        return maxProfit;
    }

    static int[] rearrangeArray(int[] nums) {
        int arrSize = nums.length;
        int[] posArr = new int[arrSize / 2];
        int[] negArr = new int[arrSize / 2];

        int posInd = 0, negInd = 0;
        for (int num : nums) {
            if (num > 0) {
                posArr[posInd] = num;
                posInd++;
            } else {
                negArr[negInd] = num;
                negInd++;
            }
        }

        for (int i = 0; i < arrSize / 2; i++) {
            nums[2 * i] = posArr[i];
            nums[2 * i + 1] = negArr[i];
        }
        return nums;
    }

    static void nextPermutation(int[] nums) {
        int ind = -1;
        int arrSize = nums.length;
        //step1: find break point of the given array
        for (int i = arrSize - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                ind = i;
                break;
            }
        }

        if (ind == -1) {
            reverseArr(nums, 0, arrSize - 1);
            return;
        }
        //step2: find out the smallest one but greater than i
        for (int i = arrSize - 1; i > ind; i--) {
            if (nums[i] > nums[ind]) {
                swap(nums, i, ind);
                break;
            }
        }

        // step3: Reverse the remaining array from ind to n-1
        reverseArr(nums, ind + 1, arrSize - 1);

    }

    private static void reverseArr(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}
