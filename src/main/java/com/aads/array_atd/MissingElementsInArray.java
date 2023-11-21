package com.aads.array_atd;

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


    public static void main(String[] args) {


        MissingElementsInArray missingElementsInArray = new MissingElementsInArray();

        int[] sortedArray = {6, 7, 8, 9, 10, 11, 13, 14, 15, 16, 17};
        missingElementsInArray.findSingleMissingElementinSortedArray(sortedArray);

        int[] sortedArray2 = {6, 7, 8, 9, 10, 11, 13, 14, 15, 16, 17, 20};
        missingElementsInArray.findMultipleMissingElementsinSortedArray(sortedArray2);


    }

}
