package com.dsa.recursion.strings;

public class SkipLetter {

    public static void main(String[] args) {

        skip("", "abc");
    }

    /**
     * p is for processed string as output
     * up is for un processed string as input
     *
     * @param p
     * @param up
     */
    static  void skip(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);
        if (ch == 'a') {
            skip(p, up.substring(1));
        } else {
            skip(p + ch, up.substring(1));
        }

    }
}
