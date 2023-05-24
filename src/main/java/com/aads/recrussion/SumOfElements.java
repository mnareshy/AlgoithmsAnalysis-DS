package com.aads.recrussion;

public class SumOfElements {

    static   int  x =0;

    public static int sumEle(int n){

        x++;

        if(n < 0)

            return  0;
        else
            return sumEle(n-1)+n;

    }



    public static void main(String[] args) {

        System.out.println(sumEle(12) +" "+x);
        System.out.println(sumEle(12) +" "+x);

    }

}
