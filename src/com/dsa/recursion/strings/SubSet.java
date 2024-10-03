package com.dsa.recursion.strings;

import java.util.ArrayList;
import java.util.List;

public class SubSet {

    public static void main(String[] args) {
        subSet("", "122");
        //System.out.println(getSubSet("", "abc"));
        //System.out.println(getSubsetAscii("", "abc"));
    }

    /**
     * printing sub sets without returning
     *
     * @param p
     * @param up
     */
    static void subSet(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);
        subSet(p + ch, up.substring(1));
        subSet(p, up.substring(1));
    }

    /**
     * returning sub sets using arraylist
     *
     * @param p
     * @param up
     * @return
     */
    static List<String> getSubSet(String p, String up) {
        if (up.isEmpty()) {
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        char ch = up.charAt(0);
        List<String> left = getSubSet(p + ch, up.substring(1));
        List<String> right = getSubSet(p, up.substring(1));
        left.addAll(right);
        return left;
    }

    /**
     * returning sub set of ascii of a string
     * @param p
     * @param up
     * @return
     */
    static List<String> getSubsetAscii(String p, String up) {
        if (up.isEmpty()) {
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        char ch = up.charAt(0);
        List<String> left = getSubsetAscii(p + (ch + 0), up.substring(1));
        List<String> right = getSubsetAscii(p, up.substring(1));
        left.addAll(right);
        return left;
    }

}
