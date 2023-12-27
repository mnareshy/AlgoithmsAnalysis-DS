package com.aads.array_atd;

public class DupicateElementsInArray {

    public void printDuplicatesinSortedArray(int inArray[]) {

        int lastDuplicate = -1;

        for (int i = 0; i < inArray.length - 1; i++) {

            if (inArray[i] == inArray[i + 1] && inArray[i] != lastDuplicate) {
                System.out.println(inArray[i]);
                lastDuplicate = inArray[i];
            }

        }

    }

    public void printDuplicatesinSortedArrayAndCount(int inArray[]) {

        int j = 0;
        for (int i = 0; i < inArray.length - 1; i++) {

            if (inArray[i] == inArray[i + 1]) {
                j = i + 1;
                while (inArray[j] == inArray[i])
                    j++;
                System.out.println("Duplicate Element" + " " + inArray[i] + " And Count " + (j - i));

                i = j - 1;
            }
        }

    }

    public void printDuplicatesinSortedArrayAndCountUsingHashing(int inArray[]) {

        int hashArray[] = new int[inArray[inArray.length-1]];

        for (int i = 0; i < inArray.length-1; i++) {

            hashArray[inArray[i]]++;

        }

        for (int i = 0; i < hashArray.length; i++) {

            if(hashArray[i] > 1)
                System.out.println("Dupicate element "+ i +" count "+hashArray[i]);

        }

    }

    public static void main(String[] args) {

        DupicateElementsInArray dupicateElementsInArray = new DupicateElementsInArray();

        int[] inArray = {3, 6, 8, 8, 10, 12, 15, 15, 15, 20};
        dupicateElementsInArray.printDuplicatesinSortedArray(inArray);

        dupicateElementsInArray.printDuplicatesinSortedArrayAndCount(inArray);

        dupicateElementsInArray.printDuplicatesinSortedArrayAndCountUsingHashing(inArray);


    }

}
