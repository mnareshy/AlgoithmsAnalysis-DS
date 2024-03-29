package com.aads.strings;


public class FindingDuplicates {

    public void findUsingLoops(char[] inArray) {

        int length = inArray.length;
        int counter = 0;

        for (int i = 0; i < length - 1; i++) {

            for (int j = i + 1; j < length; j++) {

                if (inArray[i] == inArray[j]) {
                    counter++;
                }
            }

            if (counter > 0) {
                counter += 1;
                System.out.println(inArray[i] + " duplicated " + counter + " times !");
                counter = 0;
            }
        }
    }

    public void findUsingHasing(char[] inArray) {

        int[] hasing = new int[25];

        int lenght = inArray.length;

        for (int i = 0; i < lenght; i++) {
            hasing[inArray[i] - 97]++;
        }

        for (int i = 0; i < 25; i++) {
            if (hasing[i] > 1) {
                char tempChar = (char) ((int) 97 + i);
                System.out.println(tempChar + " duplicated " + hasing[i] + " times !");
            }
        }
        //System.out.println(Arrays.toString(hasing));
    }


    public void findingUsingBits(char[] inArray){

        int hashbits = 0;
        int comparebits = 0;

        int lenght = inArray.length;

        for (int i = 0; i < lenght; i++) {

            comparebits = 1;
            comparebits =  (comparebits << (inArray[i] - 97));

            if((comparebits & hashbits) > 0)
                System.out.println("Dupicates "+ inArray[i]);

            else
                hashbits =  (hashbits | comparebits);

            //System.out.println(Integer.toBinaryString(hashbits));

        }

    }



    public static void main(String[] args) {

        FindingDuplicates findingDuplicates = new FindingDuplicates();

        char[] inArray = {'f', 'i', 'n', 'd', 'i', 'n', 'g'};


        findingDuplicates.findUsingLoops(inArray);
        findingDuplicates.findUsingHasing(inArray);

      //  inArray = new char[]{'f', 'i', 'n', 'd', 'i', 'n', 'g', 'f', 'f', 'S', 'S'};
        findingDuplicates.findingUsingBits(inArray);
     //   findingDuplicates.findingUsingBitsRemove(inArray);

    }

}
