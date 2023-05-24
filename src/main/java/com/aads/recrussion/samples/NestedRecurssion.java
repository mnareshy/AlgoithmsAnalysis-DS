package com.aads.recrussion.samples;

public class NestedRecurssion {

    static int nestedM(int n){

        if(n>100)
            return n-10;
        else
            return nestedM(nestedM(n+12));

    }

    public static void main(String[] args) {

        System.out.println(nestedM(100));

    }


}
