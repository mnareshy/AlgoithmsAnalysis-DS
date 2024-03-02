package com.aads.strings;

import java.util.Arrays;

public class Permitaions {

    int[] flagArry = new int[4];
    char[] resultStr = new char[4];

    public void findPermitations(char[] srcStr, int k) {

        int srcLength = srcStr.length;
  /*      int[] flagArry = new int[srcLength];
        char[] resultStr = new char[srcLength];*/

        if (srcLength == k) {
            System.out.println(Arrays.toString(resultStr));
        } else {

            for (int i = 0; i < srcLength; i++) {

                if (flagArry[i] == 0) {

                    resultStr[k] = srcStr[i];
                    flagArry[i] = 1;
                    System.out.println("forward " + Arrays.toString(flagArry));
                    System.out.println("forward result" + Arrays.toString(resultStr));

                    findPermitations(srcStr, k + 1);

                    flagArry[i] = 0;

                    System.out.println("on return " + Arrays.toString(flagArry));
                    System.out.println("forward result" + Arrays.toString(resultStr));
                }

            }
        }
    }

    public void findPermitationsUsingSwap(char[] srcStr, int lo, int hi) {

        int i;

        if (lo == hi) {

            System.out.println("O/P "+Arrays.toString(srcStr));
        } else {

            for (i = lo; i <= hi; i++) {

                swap(srcStr, lo, i);
            //    System.out.println("Foreard "+Arrays.toString(srcStr));
                findPermitationsUsingSwap(srcStr, lo + 1, hi);
                swapBack(srcStr, lo, i);
            //    System.out.println("OnReturn "+Arrays.toString(srcStr));

            }

        }

    }

    public void swap(char[] srcStr, int lo, int i) {

        char temp;

        temp = srcStr[lo];
        srcStr[lo] = srcStr[i];
        srcStr[i] = temp;

    }

    public void swapBack(char[] srcStr, int lo, int i) {

        swap(srcStr, lo, i);

    }

    public static void main(String[] args) {


        Permitaions permitaions = new Permitaions();
        char[] srcStr = {'A', 'B', 'C','D'};
        //char[] srcStr = {'A', 'B', 'C','A', 'B', 'C','A', 'B'};
        permitaions.findPermitations(srcStr, 0);
        permitaions.findPermitationsUsingSwap(srcStr, 0, srcStr.length-1);


    }

}
