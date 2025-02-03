package com.dsa.striversa2z.step5_1;

import java.util.Arrays;
import java.util.Map;

public class BasicStrings {
    public static void main(String[] args) {

        String [] str={"flower","flow","flight"};
        System.out.println(isIsomorphic("egg","adq"));
    }

    public static String reverseWords(String s) {
        String[] strings = s.trim().split(" +");

        int left = 0, right = strings.length - 1;
        while (left < right) {
            swap(strings, left, right);
            left++;
            right--;
        }
        return String.join(" ", strings);
    }

    private static void swap(String[] strings, int left, int right) {
        String temp = strings[left];
        strings[left] = strings[right];
        strings[right] = temp;
    }

    public static boolean palindromeCheck(String s) {
        if (s == null) return false;
        if (s.isEmpty() || s.isBlank()) return false;

        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    public static String largestOddNumber(String num) {
        if (num == null) return num;
        if (num.isBlank() | num.isBlank()) return num;
        int n = num.length();
        int j = -1;
        for (int i = n - 1; i >= 0; i--) {
            int number = num.charAt(i) - '0';
            if (number % 2 != 0) {
                j = i;
                break;
            }
        }

        if (j == -1) return "";
        int i = 0;
        while (i < n) {
            if (num.charAt(i) - '0' == 0) {
                i++;
            } else {
                break;
            }
        }
        return num.substring(i, j + 1);
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        // sort an array
        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length - 1];
        int range = Math.min(first.length(), last.length());
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < range; i++) {
            if (first.charAt(i) != last.charAt(i)) break;
            ans.append(first.charAt(i));
        }
        return ans.toString();
    }

    public static boolean isIsomorphic(String s, String t) {
        int n=s.length();

        // taking 256 is for all ascii values total 256
        int [] first=new int[256];
        int [] second=new int[256];
        for (int i = 0; i <n ; i++) {
            if (first[s.charAt(i)]!=second[t.charAt(i)]) return false;

            first[s.charAt(i)]=i+1; // +1 is for putting 1 instead of default value 0
            second[t.charAt(i)]=i+1;
        }

        return true;
    }

}
