package com.dsa.recursion;

import java.util.ArrayList;
import java.util.List;

public class NumberOfDice {
    public static void main(String[] args) {

        //dice("", 4);
        System.out.println(diceReturn("", 4, 6));
    }


    static void dice(String p, int target) {
        if (target == 0) {
            System.out.println(p);
            return;
        }

        for (int i = 1; i <= 6 && i <= target; i++) {
            dice(p + i, target - i);
        }

    }

    static List<String> diceReturn(String p, int target, int face) {
        if (target == 0) {
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        List<String> ans = new ArrayList<>();
        for (int i = 1; i <= face && i <= target; i++) {
            ans.addAll(diceReturn(p + i, target - i, face));
        }
        return ans;
    }


}
