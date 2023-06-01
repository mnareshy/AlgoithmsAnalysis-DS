package com.aads.recrussion;

public class TylorSeries {

    static double power = 1;
    static double factorial = 1;

    static  double e(int x, int n){

        double result = 1;

        if(n == 0)
            return 1;
        else
        {
          result =   e(x,n-1);

          power = power * x;
          factorial = factorial * n;

          return result+power/factorial;

        }


    }


    static double eOptimizedLoop(int x, int n){

        double result = 1;

        for ( ;n >0 ; n --) {

            result = 1+((double)x/n)*result;

        }

        return result;
    }

    static double result = 1;
    static double eOptimized(int x, int n){


        if(n == 0)
            return result;

       result =  1+((double)x/n)*result;

       return eOptimized(x,n-1);

    }



    public static void main(String[] args) {

        System.out.println(e(4,14));
        System.out.println(eOptimizedLoop(4,14));
        System.out.println(eOptimized(4,14));


    }
}
