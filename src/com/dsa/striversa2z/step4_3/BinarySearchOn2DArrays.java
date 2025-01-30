package com.dsa.striversa2z.step4_3;

import java.util.Arrays;

public class BinarySearchOn2DArrays {

    public static void main(String[] args) {
        int[][] arr = {{1, 3, 5},
                {2, 6, 9},
                {3, 6, 9}
        };
        System.out.println(median(arr));
    }

    public static int rowWithMax1s(int arr[][]) {
        int n = arr.length;
        int colLen = arr[0].length;
        int maxRowIndex = -1;
        int count = 0;
        int ans = -1;

        for (int i = 0; i < n; i++) {
            int low = 0, high = arr[i].length - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (arr[i][mid] == 1) {
                    ans = mid;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            if (ans != -1) {
                int colCnt = colLen - ans;
                if (count < colCnt) {
                    maxRowIndex = i;
                    count = colCnt;
                }
            }


        }
        return maxRowIndex;
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) { //row's
            int low = 0, high = matrix[i].length - 1;
            while (low <= high) { //col
                int mid = (low + high) / 2;
                if (matrix[i][mid] == target) {
                    return true;
                }

                if (matrix[i][mid] < target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

        }
        return false;
    }

    public static boolean searchMatrix2(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int row = 0, col = m - 1;
        while (row < n && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                row++;
            } else {
                col--;
            }
        }
        return false;
    }

    public static int[] findPeakGrid(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int low = 0, high = m - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int row = rowIndexOfMaxElementInArray(mat, mid);
            int leftSmallEle = mid - 1 >= 0 ? mat[row][mid - 1] : -1;
            int rightSmallEle = mid + 1 <= m - 1 ? mat[row][mid + 1] : -1;
            if (leftSmallEle < mat[row][mid] && mat[row][mid] > rightSmallEle) {
                return new int[]{row, mid};
            } else if (leftSmallEle > mat[row][mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return new int[]{-1, -1};
    }

    static int rowIndexOfMaxElementInArray(int[][] arr, int col) {
        int maxEle = Integer.MIN_VALUE;
        int rowIndex = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][col] > maxEle) {
                maxEle = arr[i][col];
                rowIndex = i;
            }
        }
        return rowIndex;
    }

    static int median(int mat[][]) {
        int m = mat.length;// no  of rows
        int n = mat[0].length; // no of col
        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;
        //finding min element and max element in row wised sorted matrix
        for (int i = 0; i < m; i++) {
            low = Math.min(low, mat[i][0]);
            high = Math.max(high, mat[i][n - 1]);
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int reqNumbers = (m * n) / 2;
            int numberOfSmallestEquals = smallestEquals(mat, mid);
            if (numberOfSmallestEquals <= reqNumbers) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low; // when condition failed low and high crossed and low is pointing to median
    }


    private static int smallestEquals(int[][] mat, int mid) {
        int m = mat.length;
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            cnt += upperBound(mat[i], mid);
        }
        return cnt;
    }

    private static int upperBound(int[] ints, int x) {
        int n = ints.length;
        int low = 0, high = n - 1;
        int ans = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (ints[mid] >x) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid +1;
            }
        }
        return ans;
    }
}
