package com.dsa.recursion;

import java.util.ArrayList;
import java.util.List;

public class LetterCombination {
    public static void main(String[] args) {

        // pad("", "12");
       // System.out.println(padReturn("", "7").toString());
        System.out.println(padCount("", "23"));
    }

    static void pad(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }

        int digit = up.charAt(0) - '0'; // this will convert 1 into 1
        for (int i = (digit - 1) * 3; i < digit * 3; i++) {
            char ch = (char) ('a' + i);
            pad(p + ch, up.substring(1));
        }
    }

    static List<String> padReturn(String p, String up) {
        if (up.isEmpty()) {
            List<String> list = new ArrayList<>();
            if (p.isEmpty()) {
                return list;
            }
            list.add(p);
            return list;
        }

        List<String> ans = new ArrayList<>();
        int digit = up.charAt(0) - '0'; // this will give 2 into 2
        int i = (digit - 2) * 3;
        if (digit > 7) {
            i += 1;
        }

        int len = i + 3;
        if (digit == 7 || digit == 8) {
            len += 1;
        }

        for (; i < len; i++) {
            char ch = (char) ('a' + i);
            ans.addAll(padReturn(p + ch, up.substring(1)));
        }


        return ans;
    }

    static int padCount(String p, String up) {
        if (up.isEmpty()) {
            return 1;
        }

        int digit = up.charAt(0) - '0'; // this will give 2 into 2
        int i = (digit - 2) * 3;
        if (digit > 7) {
            i += 1;
        }

        int len = i + 3;
        if (digit == 7 || digit == 8) {
            len += 1;
        }
        int count = 0;
        for (; i < len; i++) {
            char ch = (char) ('a' + i);
            count = count + padCount(p + ch, up.substring(1));
        }


        return count;
    }
}
