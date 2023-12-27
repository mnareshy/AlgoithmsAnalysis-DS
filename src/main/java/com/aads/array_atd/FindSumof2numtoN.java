package com.aads.array_atd;

public class FindSumof2numtoN {

    public void sumOf2NuminUnsortedArray(int[] inArray, int desiredSum) {

        int lenght = inArray.length;

        for (int i = 0; i < lenght - 1; i++) {

            for (int j = i + 1; j < lenght; j++) {

                if (inArray[i] + inArray[j] == desiredSum)
                    System.out.println(inArray[i] + " + " + inArray[j]);

            }

        }

    }

    public void sumOf2NuminUnsortedArrayUsingHashing(int[] inArray, int maxNum, int desiredSum) {

        int[] hashingArray = new int[maxNum];

        for (int i = 0; i < inArray.length; i++) {

            if ((desiredSum - inArray[i] >= 0) && hashingArray[desiredSum - inArray[i]] != 0)
                System.out.println(inArray[i] + " + " + (desiredSum - inArray[i]));

            hashingArray[inArray[i]]++;
        }

    }

    public void sumOf2NuminSortedArray(int[] inArray, int desiredSum) {

        int i = 0;
        int j = inArray.length - 1;

        while (i < j) {

            if ((inArray[i] + inArray[j]) == desiredSum) {
                System.out.println(inArray[i] + " + " + inArray[j]);
                i++;
                j--;
            } else if ((inArray[i] + inArray[j]) > desiredSum)
                j--;
            else
                i++;
        }


    }


    public static void main(String[] args) {

        FindSumof2numtoN findSumof2numtoN = new FindSumof2numtoN();

        int[] inArray = {6, 3, 8, 10, 16, 7, 5, 2, 9, 14};
        int desiredSum = 10;


        int maxNum = 17;
        findSumof2numtoN.sumOf2NuminUnsortedArray(inArray, desiredSum);
        findSumof2numtoN.sumOf2NuminUnsortedArrayUsingHashing(inArray, maxNum, desiredSum);


        int[] inSortedArray = {1, 3, 4, 5, 6, 8, 9, 10, 12, 14};
        findSumof2numtoN.sumOf2NuminUnsortedArray(inSortedArray, desiredSum);


    }


}
