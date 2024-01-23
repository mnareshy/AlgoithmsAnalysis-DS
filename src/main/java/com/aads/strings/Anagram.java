package com.aads.strings;

public class Anagram {

    public void areAnagrams(char[] srcStr, char[] tgtStr) {

        boolean flag = true;
        int[] hashArray = new int[25];

        int sLengt = srcStr.length;
        int tLenght = tgtStr.length;

        if(sLengt != tLenght){
            System.out.println("Not Anagram");
            return;
        }

        for (int i = 0; i < sLengt; i++) {

            hashArray[srcStr[i] - 97] ++;

        }

        for (int i = 0; i < tLenght; i++) {

            hashArray[tgtStr[i] - 97] --;

            if( hashArray[tgtStr[i] - 97] < 0){

                System.out.println("Not Anagram");
                flag = false;
                break;

            }

        }

        if(flag)
            System.out.println("Anagram");

    }


    public static void main(String[] args) {

        char[] srcStr = {'d', 'e', 'c', 'i', 'm', 'a', 'l'};
        char[] tgtStr = {'m', 'e', 'd', 'i', 'c', 'a', 'l'};

        Anagram anagram = new Anagram();
        anagram.areAnagrams(srcStr, tgtStr);
    }

}
