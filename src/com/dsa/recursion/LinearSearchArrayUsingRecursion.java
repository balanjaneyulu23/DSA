package com.dsa.recursion;

import java.util.ArrayList;
import java.util.List;

public class LinearSearchArrayUsingRecursion {
    public static void main(String[] args) {

        int[] arr = {1, 2, 4,4};
//        System.out.println(search(arr, 33, 0));
//        System.out.println(searchIndex(arr, 33, 0));
//        System.out.println(findAllIndex(arr, 33, 0, new ArrayList<>()));
        System.out.println(findAllIndex1(arr,4,0));
    }

    static boolean search(int[] arr, int target, int index) {
        if (index == arr.length) {
            return false;
        }
        return arr[index] == target || search(arr, target, index + 1);
    }


    static int searchIndex(int[] arr, int target, int index) {
        if (index == arr.length) {
            return -1;
        }

        if (arr[index] == target) {
            return index;
        } else {
            return searchIndex(arr, target, index + 1);
        }
    }

    static List<Integer> findAllIndex(int[] arr, int target, int index, List<Integer> list) {
        if (index == arr.length) {
            return list;
        }

        if (arr[index] == target) {
            list.add(index);
        }

        return findAllIndex(arr, target, index + 1, list);

    }

    //{1, 2, 4,4};
    static List<Integer> findAllIndex1(int[] arr, int target, int index) {
        List<Integer> list = new ArrayList<>();
        if (index == arr.length) {
            return list;
        }

        // this call will contain only this call answer
        if (arr[index] == target) {
            list.add(index);
        }

        List<Integer> ansFromBelowCalls = findAllIndex1(arr, target, index + 1);
        System.out.println("ansFromBelowCalls"+ansFromBelowCalls);
        list.addAll(ansFromBelowCalls);
        System.out.println("list"+list);

        return list;
    }
}
