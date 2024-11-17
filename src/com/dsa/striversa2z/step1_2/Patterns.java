package com.dsa.striversa2z.step1_2;

public class Patterns {

    public static void main(String[] args) {
        //pattern1(4, 4);
        //pattern2(5);
        pattern21(4);
    }

    public static void pattern1(int row, int col) {

        //outer loop
        for (int i = 0; i < row; i++) {
            // inner loop
            for (int j = 0; j < col; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void pattern2(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }

            System.out.println();
        }

    }

    public static void pattern3(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static void pattern4(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static void pattern5(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void pattern6(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }


    public static void pattern7(int n) {

        // outer loop for rows
        for (int i = 0; i < n; i++) {

            // spaces printing
            for (int j = 0; j <= n - i - 1; j++) {
                System.out.print(" ");
            }

            //stars printing
            for (int j = 0; j < 2 * i + 1; j++) {
                System.out.print("*");
            }

            // spaces
            for (int j = 0; j <= n - i - 1; j++) {
                System.out.print(" ");
            }

            // line break
            System.out.println();

        }

    }

    public static void pattern8(int n) {
        // outer loop for rows
        for (int i = 0; i < n; i++) {

            // space printing
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }

            //star printing
            for (int j = 0; j < 2 * n - (2 * i + 1); j++) {
                System.out.print("*");
            }

            // space printing
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }

            System.out.println();
        }

    }

    public static void pattern10(int n) {
        int stars;
        // outer loop
        for (int i = 1; i <= 2 * n - 1; i++) {
            // condition for symmetric
            stars = i > n ? 2 * n - i : i;
            //printing stars
            for (int j = 1; j <= stars; j++) {
                System.out.print("*");
            }

            System.out.println();
        }

    }

    public static void pattern11(int n) {
        int start; // it holds either zero or one
        //outer loop for rows
        for (int i = 1; i <= n; i++) {
            //If odd then return 1 to start else return 0
            start = i % 2 == 0 ? 0 : 1;
            for (int j = 1; j <= i; j++) {
                System.out.print(start);
                start = 1 - start;
            }
            System.out.println();
        }

    }

    public static void pattern12(int n) {
        //outer loop for rows
        for (int i = 1; i <= n; i++) {
            //printing numbers
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }

            // printing spaces
            for (int j = 1; j <= 2 * n - i * 2; j++) {
                System.out.print(" ");
            }

            // printing numbers in reverse order
            for (int j = i; j >= 1; j--) {
                System.out.print(j);
            }
            System.out.println();
        }

    }


    public static void pattern13(int n) {
        int count = 1;
        // outer loop for rows
        for (int i = 0; i < n; i++) {

            for (int j = 0; j <= i; j++) {
                System.out.print(count);
                System.out.print(" ");
                count += 1;
            }
            System.out.println();
        }

    }

    public static void pattern14(int n) {
        for (int i = 0; i < n; i++) {
            for (char ch = 'A'; ch <= 'A' + i; ch++) {
                System.out.print(ch);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void pattern15(int n) {
        for (int i = 0; i < n; i++) {
            for (char ch = 'A'; ch < 'A' + (n - i); ch++) {
                System.out.print(ch);
            }
            System.out.println();

        }
    }

    public static void pattern16(int n) {
        char ch = 'A';
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(ch);
            }
            ch += 1;
            System.out.println();
        }
    }

    public static void pattern17(int n) {

        // outer loop for rows
        for (int i = 0; i < n; i++) {

            //spaces
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }

            // printing alphabet
            char ch = 'A';
            int breakPoint = (2 * i + 1) / 2;
            for (int j = 1; j <= 2 * i + 1; j++) {
                System.out.print(ch);
                //symmetric condition
                if (j <= breakPoint) {
                    ch++;
                } else {
                    ch--;
                }

            }
            //spaces
            for (int j = 0; j <= n - i - 1; j++) {
                System.out.print(" ");
            }

            System.out.println();
        }
    }

    public static void pattern18(int n) {
        //outer loop for rows
        for (int i = 0; i < n; i++) {

            // printing alphabets
            for (char ch = (char) ('A' + (n - i - 1)); ch <= 'A' + n - 1; ch++) {
                System.out.print(ch);
            }
            System.out.println();
        }
    }

    public static void pattern19(int n) {
        //outer loop for rows for first half
        for (int i = 0; i < n; i++) {
            //stars
            for (int j = 0; j < n - i; j++) {
                System.out.print("*");
            }

            // spaces
            for (int j = 0; j < i * 2; j++) {
                System.out.print(" ");
            }

            //stars
            for (int j = 0; j < n - i; j++) {
                System.out.print("*");
            }

            System.out.println();
        }

        //Second half , outer loop
        for (int i = 0; i < n; i++) {

            // stars
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }

            //Spaces
            for (int j = 0; j < 2 * (n - 1) - 2 * i; j++) {
                System.out.print(" ");
            }

            // stars
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }

            System.out.println();
        }

    }

    public static void pattern20(int n) {
        // outer loop for first half
        for (int i = 0; i < n; i++) {

            //STAR
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }

            //SPACE
            for (int j = 0; j < 2 * (n - 1) - i * 2; j++) {
                System.out.print(" ");
            }

            //STAR
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        for (int i = 0; i < n - 1; i++) {

            //STAR
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print("*");
            }

            //Space
            for (int j = 0; j < i * 2 + 2; j++) {
                System.out.print(" ");
            }

            //STAR
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void pattern21(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0 || i == n - 1 || j == n - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

    }

}
