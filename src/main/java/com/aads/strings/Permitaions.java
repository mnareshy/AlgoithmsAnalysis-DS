package com.aads.strings;

import java.util.Arrays;

public class Permitaions {

    int[] flagArry = new int[3];
    char[] resultStr = new char[3];

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
                    System.out.println("forward "+ Arrays.toString(flagArry));
                    System.out.println("forward result"+ Arrays.toString(resultStr));

                    findPermitations(srcStr, k + 1);

                    flagArry[i] = 0;

                    System.out.println("on return " + Arrays.toString(flagArry));
                    System.out.println("forward result"+ Arrays.toString(resultStr));
                }

            }

        }


    }


    public static void main(String[] args) {


        Permitaions permitaions = new Permitaions();
        char[] srcStr = {'A', 'B', 'C'};
        //char[] srcStr = {'A', 'B', 'C','A', 'B', 'C','A', 'B'};
        permitaions.findPermitations(srcStr, 0);


    }

}
