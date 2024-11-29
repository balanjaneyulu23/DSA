package com.dsa.striversa2z.step1_6.basichashing;

import java.util.*;

public class BasicHashing {

    public static void main(String[] args) {
        int[] arr = {10, 5, 10, 15, 10, 5};
        minAndMaxFrequency(arr);
    }

    /**
     * This method is meant to find frequency of an array and print them
     */
    static void printFrequencyOfNumber() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        // reading elements from command line
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] hash = new int[13];
        for (int i = 0; i < n; i++) {
            hash[arr[i]] += 1;
        }

        int q = sc.nextInt();
        while (q-- != 0) {
            int number = sc.nextInt();
            System.out.print(hash[number]);
        }
    }

    /**
     * This method is meant to print frequency of a string which has all letters
     * in lower case
     */
    static void printFrequencyOfLowerCaseLetters() {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        int[] hash = new int[26];
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i) - 'a'] += 1;
        }

        int q = sc.nextInt();
        while (q-- > 0) {
            char ch = sc.next().charAt(0);
            System.out.println(hash[ch - 'a']);
        }
    }

    /**
     * This method is meant to print frequency of letters either in upper case or in lower case
     */
    static void printFrequencyOfLetters() {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        int[] hash = new int[256];
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i)] += 1;
        }

        int q = sc.nextInt();
        while (q-- > 0) {
            char ch = sc.next().charAt(0);
            System.out.println(hash[ch]);
        }

    }

    static void frequencyOfNumberUsingMap(int[] arr, int size) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < size; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }

        // printing frequency of an array element
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " occurred: " + entry.getValue());
        }
    }

    /**
     * https://www.geeksforgeeks.org/problems/frequency-of-array-elements-1587115620/0
     *
     * @param arr
     * @return
     */
    public static List<Integer> frequencyCount(int[] arr) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int j : arr) {
            if (map.containsKey(j)) {
                map.put(j, map.get(j) + 1);
            } else {
                map.put(j, 1);
            }
        }

        for (int i = 1; i < arr.length; i++) {
            list.add(map.getOrDefault(i, 0));
        }
        return list;
    }

    /**
     * Find the highest/lowest frequency element Brute force approach
     *
     * @param arr
     */
    static void countFreq(int[] arr) {
        int n = arr.length;
        int maxEle = 0, minEle = 0, maxFreq = 0, minFreq = n;

        //boolean array to keep track of visited elements
        // and skip the loop if element is already processed
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }

            int count = 1;
            for (int j = i + 1; j < n; j++) {
                if (arr[i] == arr[j]) {
                    visited[j] = true;
                    count++;
                }
            }

            if (count > maxFreq) {
                maxFreq = count;
                maxEle = arr[i];
            }

            if (count < minFreq) {
                minFreq = count;
                minEle = arr[i];
            }
        }

        System.out.println("Max element " + maxEle + " repeated " + maxFreq + " times");
        System.out.println("Min element " + minEle + " repeated " + minFreq + " times");
    }

    /**
     * Find the highest/lowest frequency element Brute force approach
     *
     * @param arr
     */
    static void minAndMaxFrequency(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }

        // logic to fetching min and max freq element
        int minFreq = n, maxFreq = 0, minEle = 0, maxEle = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int count = entry.getValue();
            if (count > maxFreq) {
                maxFreq = count;
                maxEle = key;
            }

            if (count < minFreq) {
                minFreq = count;
                minEle = key;
            }
        }
        System.out.println("Max element " + maxEle + " repeated " + maxFreq + " times");
        System.out.println("Min element " + minEle + " repeated " + minFreq + " times");
    }
}



