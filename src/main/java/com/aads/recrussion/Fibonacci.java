package com.aads.recrussion;

import java.util.Arrays;

public class Fibonacci {


    static int fib(int n) {
        int t0 = 0;
        int t1 = 1;
        int sum = 0;

        if (n <= 1)
            return 1;

        for (int i = 2; i <= n; i++) {

            sum = t0 + t1;
            t0 = t1;
            t1 = sum;

        }

        return sum;

    }

    static int fibRecurssive(int n) {

        if (n <= 1)
            return n;

        return fibRecurssive(n - 2) + fibRecurssive(n - 1);

    }


    static int fArray[] = new int[100];

    static {
        Arrays.fill(fArray, -1);
    }

    static int fibRecurssiveOpt(int n) {

       // Arrays.fill(fArray, -1);
        if (n <= 1) {
            fArray[n] = n;
            return n;
        } else {

            if (fArray[n - 2] == -1)
                fArray[n - 2] = fibRecurssiveOpt(n - 2);

            if (fArray[n - 1] == -1)
                fArray[n - 1] = fibRecurssiveOpt(n - 1);
            //    System.out.println(Arrays.toString(fArray));

            return fArray[n - 2] + fArray[n - 1];
        }


    }


    public static void main(String[] args) {

        System.out.println(fib(8));
        System.out.println(fibRecurssive(8) );
        System.out.println(fibRecurssiveOpt(8) );

    }
}
