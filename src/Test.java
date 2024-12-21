import java.util.*;

public class Test {
    public static void main(String[] args) {

        int[] a = {10, 5, 2, 7, 1, 9};

        System.out.println(subarrPositive(a, 15));


    }

    static int secondMax(int[] arr) {
        int secondMax = Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                secondMax = max;
                max = arr[i];
            }

            if (arr[i] < max && arr[i] > secondMax) {
                secondMax = arr[i];
            }
        }

        return secondMax;
    }

    static int removeDuplicate(int[] arr) {
        int i = 0;
        for (int j = 1; j < arr.length; j++) {
            if (arr[i] != arr[j]) {
                arr[i + 1] = arr[j];
                i = i + 1;
            }
        }
        return i + 1;
    }

    static void moveZero(int[] arr) {
        int n = arr.length;
        int i = 0, j = 0;
        while (i < n && j < n) {
            if (arr[i] != 0) {
                i++;
            }

            if (arr[j] == 0) {
                j++;
            }

            if (i < n && j < n && arr[i] == 0 && arr[j] != 0) {
                swap(arr, i, j);
                i++;
                j++;
            }
        }

    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static List<Integer> findUnion(int[] a, int[] b) {
        int i = 0, j = 0;
        int n1 = a.length;
        int n2 = b.length;
        List<Integer> unionList = new ArrayList<>();
        while (i < n1 && j < n2) {
            if (a[i] <= b[j]) {
                if (!unionList.contains(a[i])) {
                    unionList.add(a[i]);
                }
                i++;
            } else {
                if (!unionList.contains(b[j])) {
                    unionList.add(b[j]);
                }
                j++;
            }
        }

        while (i < n1) {
            if (!unionList.contains(a[i])) {
                unionList.add(a[i]);
            }
            i++;
        }

        while (j < n2) {
            if (!unionList.contains(b[j])) {
                unionList.add(b[j]);
            }
            j++;
        }

        return unionList;
    }

    static int subArr(int[] arr, int k) {
        int maxlen = 0;
        int sum = 0;
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (sum == k) {
                maxlen = Math.max(maxlen, i + 1);
            }

            int rem = sum - k;
            if (map.containsKey(rem)) {
                int leg = i - map.get(rem);
                maxlen = Math.max(maxlen, leg);
            }

            if (!map.containsKey(rem)) {
                map.put(sum, i);
            }

        }
        return maxlen;

    }

    static int subarrPositive(int[] arr, int k) {
        int left = 0;
        int right = 0;
        int n = arr.length;
        int maxLeng = 0;
        int sum = arr[right];
        while (right < n) {
            while (left < right && sum > k) {
                sum -= arr[left];
                left++;
            }

            if (sum == k) {
                maxLeng = Math.max(maxLeng, right - left + 1);
            }

            right++;

            if (right < n) {
                sum += arr[right];
            }
        }

        return maxLeng;

    }

}

