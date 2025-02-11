package com.dsa.striversa2z.step5_1;

import java.util.*;
import java.util.stream.Collectors;

public class BasicStrings {
    public static void main(String[] args) {
        System.out.println(countSubstr("aba", 2));

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
        int n = s.length();

        // taking 256 is for all ascii values total 256
        int[] first = new int[256];
        int[] second = new int[256];
        for (int i = 0; i < n; i++) {
            if (first[s.charAt(i)] != second[t.charAt(i)]) return false;

            first[s.charAt(i)] = i + 1; // +1 is for putting 1 instead of default value 0
            second[t.charAt(i)] = i + 1;
        }
        return true;
    }

    public static boolean rotateString(String s, String goal) {
        int n = s.length();
        for (int i = 0; i < n; i++) {
            String str = s.substring(i, n) + s.substring(0, i);
            if (str.equals(goal)) {
                return true;
            }
        }
        return false;
    }

    public static boolean rotateStringOptimal(String s, String goal) {
        if (s.length() != goal.length()) return false;
        String doubleS = s + s;
        return doubleS.contains(goal);
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        //sorting two given strings
        String first = s.chars().mapToObj(Character::toString).sorted().collect(Collectors.joining());
        String second = t.chars().mapToObj(Character::toString).sorted().collect(Collectors.joining());
        return first.equals(second);
    }

    public static boolean isAnagramOptimal(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            count[c - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }


    public String frequencySort(String s) {
        StringBuilder builder = new StringBuilder();
        //taking map to store key and it's frequency
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        List<Character> list = new ArrayList<>(map.keySet());
        for (char ch : list) {
            System.out.println(ch);
        }

        list.sort((obj1, obj2) -> map.get(obj2) - map.get(obj1)
        );

        for (char ch : list) {
            int freq = map.get(ch);
            while (freq > 0) {
                builder.append(ch);
                freq--;
            }
        }
        return builder.toString();
    }

    public static int maxDepth(String s) {
        int maxVal = 0;
        int currentCnt = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                currentCnt++;
            }
            maxVal = Math.max(currentCnt, maxVal);
            if (ch == ')') {
                currentCnt--;
            }
        }
        return maxVal;
    }

    public static int romanToInt(String s) {
        char[] ch = s.toCharArray();
        int sum = 0;
        Map<String, Integer> romanToInMap = romanToIntMapping();
        for (int i = 0; i < ch.length; i++) {
            if (i + 1 < ch.length && romanToInMap.get(Character.toString(ch[i]))
                    < romanToInMap.get(Character.toString(ch[i + 1]))) {
                sum -= romanToInMap.get(Character.toString(ch[i]));
            } else {
                sum += romanToInMap.get(Character.toString(ch[i]));
            }
        }

        return sum;
    }

    static Map<String, Integer> romanToIntMapping() {
        Map<String, Integer> romanTomap = new HashMap<>();
        romanTomap.put("I", 1);
        romanTomap.put("V", 5);
        romanTomap.put("X", 10);
        romanTomap.put("L", 50);
        romanTomap.put("C", 100);
        romanTomap.put("D", 500);
        romanTomap.put("M", 1000);
        return romanTomap;
    }

    public static int myAtoi(String s) {
        if (s == null) return 0;
        s = s.trim();
        if (s.isEmpty()) return 0;
        int sign = 1;
        if (s.charAt(0) == '-') sign = -1;
        // checking first index has sign or not
        int index = (s.charAt(0) == '-' || s.charAt(0) == '+') ? 1 : 0;
        long ans = 0;
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        while (index < s.length()) {
            if (s.charAt(index) == ' ' || !Character.isDigit(s.charAt(index))) {
                return (int) (ans * sign);
            }
            ans = ans * 10 + s.charAt(index) - '0';
            if (sign == -1 && sign * ans < min) return min;
            if (sign == 1 && ans > max) return max;
            index++;
        }
        return (int) (sign * ans);
    }

    static int countSubstr(String s, int k) {
        int n = s.length();
        int ans = 0;
        boolean[] seen = new boolean[26];
        for (int i = 0; i < n; i++) {
            int distChars = 0;
            Arrays.fill(seen, false);
            for (int j = i; j < n; j++) {
                if (!seen[s.charAt(j)-'a']) {
                    distChars++;
                }
                
                seen[s.charAt(j)-'a'] = true;
                if (distChars == k) {
                    ans++;
                }
            }
        }
        return ans;

    }


}
