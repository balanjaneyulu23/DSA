package com.dsa.striversa2z.step4_1;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class BinarySearchOn1DArrays {

    public static void main(String[] args) {



    }


    public static int search(int[] nums, int target) {
        int high = nums.length - 1;
        int low = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    static int search(int[] nums, int low, int high, int target) {
        if (low > high) {
            return -1;
        }

        int mid = (low + high) / 2;
        if (target == nums[mid]) return mid;
        if (nums[mid] > target) {
            return search(nums, low, mid - 1, target);
        } else {
            return search(nums, mid + 1, high, target);
        }
    }

    static int findFloor(int[] arr, int k) {
        int low = 0, high = arr.length - 1;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] <= k) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    static int getCeil(int x, int[] arr) {
        int low = 0, high = arr.length - 1;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= x) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static int[] getFloorAndCeil(int x, int[] arr) {
        Arrays.sort(arr);
        int floor = findFloor(arr, x);
        if (floor != -1) {
            floor = arr[floor];
        }

        int ceil = getCeil(x, arr);
        if (ceil != -1) {
            ceil = arr[ceil];
        }
        return new int[]{floor, ceil};
    }

    public int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int ans = nums.length;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] >= target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    static int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};
        int arrSize = nums.length;
        int lowerBound = lowerBound(nums, target);

        //edge case: when target is not found
        if (lowerBound == arrSize || nums[lowerBound] != target) {
            return ans;
        }

        int upperBound = upperBound(nums, target);
        ans[0] = lowerBound;
        ans[1] = upperBound - 1;
        return ans;
    }

    static int lowerBound(int[] nums, int target) {
        int arrSize = nums.length;
        int lowerBound = arrSize;
        int low = 0, high = arrSize - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] >= target) {
                lowerBound = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return lowerBound;
    }

    static int upperBound(int[] nums, int target) {
        int arrSize = nums.length;
        int low = 0, high = arrSize - 1;
        int upperBound = arrSize;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > target) {
                upperBound = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return upperBound;
    }

    static int firstOccuranceOfElement(int[] nums, int target) {
        int firstPos = -1;
        int arrSize = nums.length;
        int low = 0, high = arrSize - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                firstPos = mid;
                high = mid - 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return firstPos;
    }

    static int lastOccuranceOfElement(int[] nums, int target) {
        int lastPos = -1;
        int arrSize = nums.length;
        int low = 0, high = arrSize - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                lastPos = mid;
                low = mid + 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return lastPos;
    }

    static int[] firstAndLastOccuranceOfElement(int[] nums, int target) {
        int firstPos = firstOccuranceOfElement(nums, target);
        int lastPos = lastOccuranceOfElement(nums, target);
        return new int[]{firstPos, lastPos};
    }

    static int countFreq(int[] arr, int target) {
        int firstPos = firstOccuranceOfElement(arr, target);
        if (firstPos == -1) {
            return 0;
        }
        int lastPos = lastOccuranceOfElement(arr, target);
        return lastPos - firstPos + 1;
    }

    public static int searchInRotatedArr(int[] nums, int target) {
        int arrSize = nums.length;
        int low = 0, high = arrSize - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            // checking search space is sorted or not
            //below condition is met then left part is sorted
            if (nums[low] <= nums[mid]) {
                // search space is sorted, so now checking element is existed in sorted part or not
                if (nums[low] <= target && target <= nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                // right part is sorted
                // checking target is existed
                if (nums[mid + 1] <= target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

        }
        return -1;
    }

    public static boolean searchInRotatedArrayWithDuplicate(int[] nums, int target) {
        int arrSize = nums.length;
        int low = 0, high = arrSize - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
                low++;
                high--;
                continue;
            }

            // checking search space is sorted or not
            //below condition is met then left part is sorted
            if (nums[low] <= nums[mid]) {
                // search space is sorted, so now checking element is existed in sorted part or not
                if (nums[low] <= target && target <= nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                // right part is sorted
                // checking target is existed
                if (nums[mid + 1] <= target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

        }
        return false;
    }

    public static int findMin(int[] nums) {
        int arrSize = nums.length;
        int low = 0, high = arrSize - 1;
        int minVal = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            //if array is sorted
            if (nums[low] <= nums[high]) {
                minVal = Math.min(minVal, nums[low]);
                break;
            }

            //checking left part is sorted
            if (nums[low] <= nums[mid]) {
                minVal = Math.min(minVal, nums[low]);
                low = mid + 1;
            } else {
                // right part is sorted
                minVal = Math.min(minVal, nums[mid]);
                high = mid - 1;
            }
        }
        return minVal;
    }

    public static int findKRotation(List<Integer> arr) {
        int arrSize = arr.size();
        int low = 0, high = arrSize - 1;
        int minVal = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr.get(low) <= arr.get(mid)) {
                minVal = Math.min(minVal, arr.get(low));
                low = mid + 1;
            } else {
                minVal = Math.min(minVal, arr.get(mid));
                high = mid - 1;
            }
        }
        return arr.indexOf(minVal);
    }

    public static int singleNonDuplicate(int[] nums) {
        int arrSize = nums.length;
        //check array has single element
        if (arrSize == 1) {
            return nums[0];
        }
        //check first element is our answer
        if (nums[0] != nums[1]) {
            return nums[0];
        }

        // check last element is our answer
        if (nums[arrSize - 1] != nums[arrSize - 2]) {
            return nums[arrSize - 1];
        }

        int low = 1, high = arrSize - 2;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            //Mid is our single element
            if (nums[mid] != nums[mid + 1] && nums[mid] != nums[mid - 1]) {
                return nums[mid];
            }

            //we're at left part of the array and element we're searching in right
            //so eliminate left part
            // standing at left part is determine by same two elements at (even ,odd)
            if (mid % 2 == 0 && nums[mid] == nums[mid + 1] || mid % 2 != 0 && nums[mid] == nums[mid - 1]) {
                //eliminate left part
                low = mid + 1;
            } else {
                // standing at right part but element is at left part so eliminating right part
                high = mid - 1;
            }
        }
        return -1;
    }

    public static int findPeakElement(int[] nums) {
        int arrSize = nums.length;
        //Array has single element that would be the answer
        if (arrSize == 1) return 0;
        // check first element is the answer
        if (nums[0] > nums[1]) return 0;
        //check last element is the answer
        if (nums[arrSize - 1] > nums[arrSize - 2]) return arrSize - 1;

        //we have verified first and last position since they don't have left and right so default we are consider
        // -1 for left for first and -1 for right of last element
        // that is the reason search space is taking from 1 to n-2
        int low = 1, high = arrSize - 2;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            //checking mid is the peak element
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            }

            //check mid is in the left part of the array so peak must be in right part
            // eliminating left park
            if (nums[mid] > nums[mid - 1]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;

    }

}