package com.aads.recrussion;

public class Power {


    static int pow(int m, int n){

        if(n == 0)
            return 1;
        return pow(m, n-1)*m;

    }

    static int powOpt(int m, int n){

        if(n == 0)
            return 1;

        if(n % 2 == 0)
            return powOpt( m * m,  n/2);
        else
            return m*powOpt(m*m,(n-1)/2);

    }

    public static void main(String[] args) {


        System.out.println(pow(2,9));
        System.out.println(powOpt(2,9));

        int i = (int)Math.pow(2,9);
        System.out.println(i);

    }
}
