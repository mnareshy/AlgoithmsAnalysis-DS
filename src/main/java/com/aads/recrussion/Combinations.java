package com.aads.recrussion;

public class Combinations {


   static int fact(int n){

       if(n <= 1 )
           return 1;
       else return fact(n-1)*n;

    }


   static int ncr(int n , int r){

       return fact(n)/(fact(r)*fact(n-r));

    }

    static int ncrRe(int n, int r){
       if( r == 0 || r == n)
           return 1;
       else
           return ncrRe(n-1,r-1)+ncrRe(n-1,r);

    }



    public static void main(String[] args) {

        System.out.println(ncr(4,2));
        System.out.println(ncrRe(4,2));

    }
}
