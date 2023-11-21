package com.aads.array_atd;

import java.util.Arrays;

public class ArrayUtils {

    public void insertInSortedArray(int[] array, int element) {

        int index = 0;
        for (int i = array.length - 3; array[i] > element; i--) {

            array[i + 1] = array[i];
            index = i;
        }
        array[index] = element;
    }

    public boolean isSorted(int[] intArray) {

        for (int i = 0; i < intArray.length - 1; i++) {

            if (intArray[i] > intArray[i + 1])
                return false;
        }
        return true;
    }

    public void negetivesAndPositivesSaparation(int[] npIntArray) {

        int i = 0;
        int j = npIntArray.length - 1;
        int temp = 0;

        while (i < j) {

            while (npIntArray[i] < 0)
                i++;
            while (npIntArray[j] > 0)
                j--;

            if (i < j) {
                temp = npIntArray[i];
                npIntArray[i] = npIntArray[j];
                npIntArray[j] = temp;
            }

        }


    }

    public int[] mergeSortedArrays(int arrM[], int arrN[]) {

        int lenghtM = arrM.length;
        int lenghtN = arrN.length;

        int[] arrResult = new int[lenghtM + lenghtN];

        int i = 0;
        int j = 0;
        int k = 0;


        while (i < lenghtM && j < lenghtN) {

            if (arrM[i] < arrN[j])
                arrResult[k++] = arrM[i++];
            else
                arrResult[k++] = arrN[j++];

        }

        for (; i < lenghtM; i++) {

            arrResult[k++] = arrM[i];
        }
        for (; j < lenghtM; j++) {

            arrResult[k++] = arrN[j];
        }

        return arrResult;
    }

    public int[] unionofUnSortedArrays(int arrM[], int arrN[]) {

        int lenghtM = arrM.length;
        int lenghtN = arrN.length;
        int k = 0;

        int[] arrResult = new int[lenghtM + lenghtN];

        for (int i = 0; i < lenghtM; i++) {

            arrResult[k++] = arrM[i];

        }

        boolean eleMatch;

        for (int j = 0; j < lenghtN; j++) {

            eleMatch = false;

            for (int i = 0; i < lenghtM; i++) {

                if (arrN[j] == arrM[i]) {
                    eleMatch = true;
                    break;
                }


                // System.out.println(arrN[j] + " : " + arrM[i]);
            }

            if (eleMatch == false)
                arrResult[k++] = arrN[j];

            //System.out.println(Arrays.toString(arrResult));


        }


        return arrResult;
    }

    public int[] unionofSortedArrays(int arrM[], int arrN[]) {

        int lenghtM = arrM.length;
        int lenghtN = arrN.length;

        int[] arrResult = new int[lenghtM + lenghtN];

        int i = 0;
        int j = 0;
        int k = 0;


        while (i < lenghtM && j < lenghtN) {

            if (arrM[i] < arrN[j])
                arrResult[k++] = arrM[i++];
            else if (arrN[j] < arrM[i])
                arrResult[k++] = arrN[j++];
            else {
                arrResult[k++] = arrM[i++];
                j++;
            }
        }

        for (; i < lenghtM; i++) {

            arrResult[k++] = arrM[i];
        }
        for (; j < lenghtM; j++) {

            arrResult[k++] = arrN[j];
        }

        return arrResult;
    }

    public int[] intersectionOfSortedArrays(int arrM[], int arrN[]) {

        int lenghtM = arrM.length;
        int lenghtN = arrN.length;

        int[] arrResult = new int[lenghtM + lenghtN];

        int i = 0;
        int j = 0;
        int k = 0;


        while (i < lenghtM && j < lenghtN) {

            if (arrM[i] < arrN[j])
                i++;
            else if (arrN[j] < arrM[i])
                j++;
            else {
                arrResult[k++] = arrM[i++];
                j++;
            }
        }

        return arrResult;
    }

    public int[] differenceOfSortedArrays(int arrM[], int arrN[]) {

        int lenghtM = arrM.length;
        int lenghtN = arrN.length;

        int[] arrResult = new int[lenghtM + lenghtN];

        int i = 0;
        int j = 0;
        int k = 0;


        while (i < lenghtM && j < lenghtN) {

            if (arrM[i] < arrN[j])
                arrResult[k++] = arrM[i++];
            else if (arrN[j] < arrM[i])
                j++;
            else {
                i++;
                j++;
            }
        }

        for (; i < lenghtM; i++) {

            arrResult[k++] = arrM[i];
        }


        return arrResult;
    }

    public static void main(String[] args) {

        ArrayUtils arrayUtils = new ArrayUtils();

        int[] intArray = {1, 2, 4, 5, 6, 7, 9, 10, 12, 14, 17, 20, 0, 0};

        arrayUtils.insertInSortedArray(intArray, 8);
        System.out.println("insertInSortedArray");
        System.out.println(Arrays.toString(intArray));

        int[] intArray1 = {1, 2, 4, 5, 6, 7, 9, 10, 12, 14, 17, 20};
        System.out.println(arrayUtils.isSorted(intArray1));

        int[] npIntArray = {-1, 2, -4, 5, -6, 7, -9, 10, -12, 14, -17, 20};
        arrayUtils.negetivesAndPositivesSaparation(npIntArray);
        System.out.println(Arrays.toString(npIntArray));

        int[] arrM = {2, 4, 6, 8, 12};
        int[] arrN = {3, 5, 7, 9, 14};
        System.out.println(Arrays.toString(arrayUtils.mergeSortedArrays(arrM, arrN)));


        int[] arrAus = {5, 3, 10, 4, 6};
        int[] arrBus = {12, 4, 7, 2, 5};
        System.out.println(Arrays.toString(arrayUtils.unionofUnSortedArrays(arrAus, arrBus)));

        int[] arrAs = {3, 4, 5, 6, 10};
        int[] arrBs = {2, 4, 5, 7, 12};
        System.out.println(Arrays.toString(arrayUtils.unionofSortedArrays(arrAs, arrBs)));

        int[] arrAs1 = {3, 4, 5, 6, 10};
        int[] arrBs2 = {2, 4, 5, 7, 12};
        System.out.println(Arrays.toString(arrayUtils.intersectionOfSortedArrays(arrAs1, arrBs2)));


        System.out.println(Arrays.toString(arrayUtils.differenceOfSortedArrays(arrAs1, arrBs)));


    }

}
