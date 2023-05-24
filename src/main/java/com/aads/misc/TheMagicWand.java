package com.aads.misc;

import java.util.Arrays;
import java.util.Scanner;

public class TheMagicWand {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        Integer[] nInts = new Integer[n];

        for(int i=0; i<n; i++)
        {
            nInts[i]=sc.nextInt();
        }

        Integer[] mqieries = new Integer[m];

        for(int i=0; i<m; i++)
        {
            mqieries[i]=sc.nextInt();
        }


        Integer[] outputArray = new Integer[m];
        int outputIndexSum = 0;


        for (int i = 0; i < mqieries.length; i++) {

            for (int j = 0; j < nInts.length; j++) {

                outputIndexSum  = outputIndexSum+Math.abs(nInts[j]-mqieries[i]);

            }
            outputArray[i] = outputIndexSum;
            outputIndexSum = 0;
        }


        System.out.println(Arrays.toString(nInts));
        System.out.println(Arrays.toString(mqieries));
        System.out.println(Arrays.toString(outputArray));



    }

}
