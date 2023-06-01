package com.aads.recrussion;

public class Factorial {

    static int factorial(int n) throws Exception {

        if(n < 0)
            throw new Exception("Negetive Number");

        if(n == 0)
            return 1;
        else
            return factorial(n-1)*n;
    }

    public static void main(String[] args) throws Exception {

        System.out.println(factorial(4));
    }
}
