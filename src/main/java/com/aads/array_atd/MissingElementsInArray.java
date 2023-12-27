package com.aads.array_atd;

import java.util.Arrays;

public class MissingElementsInArray {

    void findSingleMissingElementinSortedArray(int[] sortedArray) {

        int lenght = sortedArray.length;
        int lo = sortedArray[0];
        int hi = sortedArray[lenght - 1];

        int index = 0;

        int diff = lo - index;

        for (; index < lenght; index++) {

            if ((sortedArray[index] - index) != diff) {
                System.out.println(index + diff);
                break;
            }

        }

    }

    void findMultipleMissingElementsinSortedArray(int[] sortedArray) {


        int lenght = sortedArray.length;
        int lo = sortedArray[0];
        int hi = sortedArray[lenght - 1];
        int index = 0;
        int diff = lo - index;

        for (; index < lenght; index++) {

            if ((sortedArray[index] - index) != diff) {

                while (diff < (sortedArray[index] - index)) {

                    System.out.println(index + diff);
                    diff++;
                }
            }
        }
    }

    void findMultipleMissingElementsinUnSortedArrayUsingHashing(int[] inArray, int high, int lo) {

        int[] hashArray = new int[high+1];

        int temp = 0;

        for (int i = 0; i < inArray.length; i++) {

            temp = inArray[i];
            hashArray[temp]++;
/*
            System.out.println(Arrays.toString(hashArray));
*/

        }

        for (int i = lo; i < high; i++) {

            if(hashArray[i] == 0)
                System.out.print(i + " ");

        }


    }




    public static void main(String[] args) {


        MissingElementsInArray missingElementsInArray = new MissingElementsInArray();

        int[] sortedArray = {6, 7, 8, 9, 10, 11, 13, 14, 15, 16, 17};
        missingElementsInArray.findSingleMissingElementinSortedArray(sortedArray);

        int[] sortedArray2 = {6, 7, 8, 9, 10, 11, 13, 14, 15, 16, 17, 20};
        missingElementsInArray.findMultipleMissingElementsinSortedArray(sortedArray2);


        int[] inArray = {2, 8, 7, 10, 8, 6, 14, 16, 15, 20, 17};
        missingElementsInArray.findMultipleMissingElementsinUnSortedArrayUsingHashing(inArray, 20, 2);


    }

}
