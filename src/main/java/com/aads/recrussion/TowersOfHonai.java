package com.aads.recrussion;

public class TowersOfHonai {

    static int count = 0;

    static void toh(int n, int a, int b, int c) {

        if (n > 0) {

            toh(n - 1, a, c, b);
           // System.out.print(a + "," + c + " ");
            toh(n - 1, b, a, c);
            System.out.println(count++);

        }
    }

    public static void main(String[] args) {

        toh(7, 1, 2, 3);
    }
}
