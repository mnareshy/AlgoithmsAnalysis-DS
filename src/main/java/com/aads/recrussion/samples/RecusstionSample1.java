package com.aads.recrussion.samples;

public class RecusstionSample1 {

    static void reduceNum(int n){

        if(n>0){
            System.out.print(n + " ");
            reduceNum(n-1);

        }

    }

    public static void main(String[] args) {

        int n =  4;
        reduceNum(n);

    }
}
