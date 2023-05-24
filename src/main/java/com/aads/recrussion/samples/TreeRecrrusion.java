package com.aads.recrussion.samples;

public class TreeRecrrusion {

  static void redNum(int n){

       if(n > 0){

           System.out.print(n +" ");
           redNum(n-1);
           redNum(n-1);

       }

    }

    public static void main(String[] args) {

       redNum(3);

    }
}
