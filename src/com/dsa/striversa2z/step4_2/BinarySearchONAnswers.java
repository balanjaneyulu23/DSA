package com.dsa.striversa2z.step4_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.OptionalInt;

public class BinarySearchONAnswers {
    public static void main(String[] args) {
        Integer[] nums = {25, 46, 28, 49, 24};
        System.out.println(findPagesOptimal(new ArrayList<Integer>(Arrays.asList(nums)), 5, 4));
    }

    static int floorSqrtBruteForce(int n) {
        int answer = 0;
        for (int i = 1; i * i <= n; i++) {
            answer = i;
        }
        return answer;
    }

    static int floorSqrtOptimal(int n) {
        int low = 1, high = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid <= n / mid) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }

    public static int nthRoot(int n, int m) {
        int low = 1, high = m;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int value = mutiply(n, mid);
            if (value == m) {
                return mid;
            } else if (value <= m) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    static int mutiply(int n, int mid) {
        long answer = 1;
        for (int i = 1; i <= n; i++) {
            answer = answer * mid;
        }
        return (int) answer;
    }

    public static int minEatingSpeed(int[] piles, int h) {
        OptionalInt optionalInt = Arrays.stream(piles).max();
        int maxVal = 0;
        if (optionalInt.isPresent()) {
            maxVal = optionalInt.getAsInt();
        }
        for (int i = 1; i <= maxVal; i++) {
            if (requiredHours(piles, i) <= h) {
                return i;
            }
        }
        return 0;
    }

    static long requiredHours(int[] piles, int hours) {
        long requiredHrs = 0;
        for (int pile : piles) {
            requiredHrs += (int) Math.ceil((double) pile / hours);
        }
        return requiredHrs;
    }

    public static int minEatingSpeedOptimal(int[] piles, int h) {
        int maxVal = Arrays.stream(piles).max().getAsInt();
        int low = 1, high = maxVal;
        int answer = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (requiredHours(piles, mid) <= h) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return answer;
    }

    public static int minDays(int[] bloomDay, int m, int k) {
        int arrSize = bloomDay.length;
        // not possible
        long val = (long) m * k;
        if (arrSize < val) return -1;

        int min = Arrays.stream(bloomDay).min().getAsInt();
        int max = Arrays.stream(bloomDay).max().getAsInt();
        for (int i = min; i <= max; i++) {
            if (possible(bloomDay, i, m, k)) {
                return i;
            }
        }
        return -1;
    }

    static boolean possible(int[] bloomDay, int day, int m, int k) {
        int count = 0;
        int noOfBou = 0;
        for (int j : bloomDay) {
            if (j <= day) {
                count++;
            } else {
                noOfBou += count / k;
                count = 0;
            }
        }

        noOfBou += count / k;
        return noOfBou >= m;
    }

    public static int minDaysOptimal(int[] bloomDay, int m, int k) {
        int arrSize = bloomDay.length;
        // not possible
        long val = (long) m * k;
        if (arrSize < val) return -1;

        int min = Arrays.stream(bloomDay).min().getAsInt();
        int max = Arrays.stream(bloomDay).max().getAsInt();
        int low = min, high = max;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (possible(bloomDay, mid, m, k)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static int smallestDivisor(int[] nums, int threshold) {
        int arrSize = nums.length;
        int max = Arrays.stream(nums).max().getAsInt();
        for (int i = 1; i <= max; i++) {
            if (sumByDiv(nums, i) <= threshold) {
                return i;
            }
        }
        return -1;
    }

    public static int smallestDivisorOptimal(int[] nums, int threshold) {
        int arrSize = nums.length;
        int low = 1, high = Arrays.stream(nums).max().getAsInt();
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (sumByDiv(nums, mid) <= threshold) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    static long sumByDiv(int[] nums, int divisor) {
        long sum = 0;
        for (int num : nums) {
            sum += (long) Math.ceil((double) num / divisor);
        }
        return sum;
    }

    public static int shipWithinDays(int[] weights, int days) {
        int arrSize = weights.length;

        // max value would be min capacity
        int low = Arrays.stream(weights).max().getAsInt();
        int high = Arrays.stream(weights).sum();
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (requiredDays(weights, mid) <= days) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }
        return low;
    }

    static long requiredDays(int[] weights, int capacity) {
        int load = 0, days = 1;
        for (int i = 0; i < weights.length; i++) {
            if (load + weights[i] > capacity) {
                days++;
                load = weights[i];
            } else {
                load += weights[i];
            }

        }
        return days;
    }

    public static int findKthPositive(int[] arr, int k) {
        for (int num : arr) {
            if (num <= k) {
                k++;
            } else {
                return k;
            }
        }
        return k;
    }

    public static int findKthPositiveOptimal(int[] arr, int k) {
        int low = 0, high = arr.length - 1;
        if (arr[low] > k) return k;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int missingVals = arr[mid] - (mid + 1);
            if (missingVals < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        int diff = arr[high] - (high + 1);
        int miss = k - diff;
        return arr[high] + miss;
    }

    public static int aggressiveCows(int[] stalls, int cows) {
        int arrSize = stalls.length;
        Arrays.sort(stalls);
        // min should be 1 as minimum cows must be two so distance between two cows at least two
        // Max distance is last value in the array -first value in the array as
        // let's assume , if we take two cows so one cow at oth index and another cow at last index so
        // max distance is the distance between last value - first value
        int maxDis = stalls[arrSize - 1] - stalls[0];
        for (int i = 1; i <= maxDis; i++) {
            if (canCowPlaced(stalls, i, cows)) {
                continue;
            } else {
                return i - 1;
            }
        }

        return -1;
    }

    public static int aggressiveCowsOptimal(int[] stalls, int cows) {
        int arrSize = stalls.length;
        Arrays.sort(stalls);
        // min should be 1 as minimum cows must be two so distance between two cows at least two
        int low = 1;
        // Max distance is last value in the array -first value in the array as
        // let's assume , if we take two cows so one cow at oth index and another cow at last index so
        // max distance is the distance between last value - first value
        int high = stalls[arrSize - 1] - stalls[0];
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canCowPlaced(stalls, mid, cows)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return high;
    }

    /**
     * @param stalls
     * @param dist
     * @param cows
     * @return
     */
    private static boolean canCowPlaced(int[] stalls, int dist, int cows) {
        int cowCount = 1;
        int last = stalls[0];
        for (int j = 1; j <= stalls.length - 1; j++) {
            if (stalls[j] - last >= dist) {
                cowCount++;
                last = stalls[j];
            }
            if (cowCount >= cows) {
                return true;
            }
        }
        return false;
    }

    public static int findPages(ArrayList<Integer> arr, int n, int m) {
        if (n < m) return -1;

        int low = Collections.max(arr);
        int high = arr.stream().mapToInt(Integer::intValue).sum();
        for (int i = low; i <= high; i++) {
            if (getStudents(arr, m, i) == m) {
                return i;
            }
        }
        return -1;
    }

    public static int findPagesOptimal(ArrayList<Integer> arr, int n, int m) {
        if (n < m) return -1;
        int low = Collections.max(arr);
        int high = arr.stream().mapToInt(Integer::intValue).sum();
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (getStudents(arr, m, mid) > m) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    /**
     * @param arr
     * @param m
     * @param i
     * @return
     */
    private static int getStudents(ArrayList<Integer> arr, int m, int i) {
        int students = 1;
        int pages = 0;
        for (int j = 0; j < arr.size(); j++) {
            if (pages + arr.get(j) <= i) {
                pages += arr.get(j);
            } else {
                students++;
                pages = arr.get(j);
            }
        }
        return students;
    }

    public static int splitArray(int[] nums, int k) {
        int arrSize = nums.length;
        int low = nums[0];
        int high = nums[0];
        for (int num : nums) {
            low = Math.max(low, num);
            high += num;
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (countPartitions(nums, mid) > k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    private static int countPartitions(int[] nums, int mid) {
        int partionsCount = 1;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum + nums[i] <= mid) {
                sum += nums[i];
            } else {
                partionsCount++;
                sum = nums[i];
            }
        }
        return partionsCount;
    }

}
