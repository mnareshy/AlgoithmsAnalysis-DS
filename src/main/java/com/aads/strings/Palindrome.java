package com.aads.strings;

public class Palindrome {

    public String compare(char[] soure, char[] target) {

        String result = "";

        int i = 0, j = 0;

        boolean flag = true;

        for (; i < soure.length && j < target.length; i++, j++) {

            if (soure[i] != target[j]) {
                flag = false;
                break;
            }
        }

        if (flag) {
            i--;
            j--;
        }


        if (soure[i] == target[j])
            result = "equal";
        else if (soure[i] < target[j])
            result = "smaller";
        else
            result = "greater";

        return result;
    }

    public boolean isPalindrome(char[] soure){
        boolean isPalindrome =  true;
        int i = 0;
        int j = soure.length-1;

        for (; i < j ; i++,j--) {

            if(soure[i] != soure[j]){
                isPalindrome = false;
                break;
            }


        }


        return isPalindrome;
    }


    public static void main(String[] args) {

        Palindrome palindrome = new Palindrome();

        char[] source = {'p', 'a', 'i', 'n', 't', 'e', 'r'};
        char[] target = {'p', 'a', 'i', 'n', 't', 'i', 'n', 'g'};

        System.out.println(palindrome.compare(source, target));

        char[] source1 = {'m', 'a', 'd','a', 'm'};
        System.out.println(palindrome.isPalindrome(source1));


    }

}
