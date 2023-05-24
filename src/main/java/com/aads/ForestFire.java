package com.aads;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class ForestFire {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int x = sc.nextInt();

        Integer[] nAnimals = new Integer[n];

        for(int i=0; i<n; i++)
        {
            nAnimals[i]=sc.nextInt();
        }

        Arrays.sort(nAnimals, Collections.reverseOrder());


        int count = 0;
        for (int i = 0; i < n; i++) {
            if(nAnimals[i] > nAnimals[x])
                count ++;
            else
                break;

        }

        if(count == x)
        {
            System.out.println(nAnimals[x-1]);
        }
        else
        {
            System.out.println(-1);
        }

        System.out.println("n : "+n+" nAmimals : "+ Arrays.toString(nAnimals) +" x :"+x);

    }

}
