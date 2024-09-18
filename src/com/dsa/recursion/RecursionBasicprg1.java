package com.dsa.recursion;

public class RecursionBasicprg1 {

    int count = 0;

    public static void main(String[] args) {
        RecursionBasicprg1 basicprg1 = new RecursionBasicprg1();

        //basicprg1.func();
        basicprg1.name(1,5);
        //basicprg1.printNumbers1ToN();
        //basicprg1.printNumbers1ToN(6);
       // basicprg1.printNumbersNTo1(6);
    }


    /**
     * printing from N to 1
     *
     * @param number
     */
    void printNumbersNTo1(int number) {

        if (number == 0) {
            return;
        }

        System.out.print(number + " ");
        printNumbersNTo1(number - 1);
    }

    int num = 1;

    /**
     * printing numbers from 1 to N
     *
     * @param number
     */
    void printNumbers1ToN(int number) {

        if (number == 0) {
            return;
        }
        printNumbers1ToN(number - 1);
        System.out.print(number + " ");
    }


    /**
     * this names function prints name 5 times
     */
    void name(int i, int n) {

        if (i>n){
            return;
        }
        System.out.println("Balanjaneyulu");
        name(i+1,n);


    }

    /**
     * this is the basic function as to recursion basic
     */
    void func() {

        if (count == 3) {
            return;
        }

        System.out.println("printing count " + count);
        count++;
        func();

    }
}
