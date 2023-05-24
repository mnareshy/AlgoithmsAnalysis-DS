package com.aads.recrussion;

public class SumOfNauralNumbers {

    static int sumFormula(int n) {
        return (n * (n + 1)) / 2;
    }

    static int sumloop(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum = sum + i;
        }
        return sum;
    }

    static int sumRecrussion(int n) {

        if(n == 0)
            return 0;
        else
            return sumRecrussion(n - 1)+ n;
    }

    public static void main(String[] args) {

        System.out.println(sumFormula(8));
        System.out.println(sumloop(8));
        System.out.println(sumRecrussion(8));
    }
}
