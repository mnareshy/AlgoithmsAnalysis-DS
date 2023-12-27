package com.aads.strings;

public class ChangeCase {

    String toUpper(String inStr){

        char[] charStr = inStr.toCharArray();

        for (int i = 0; i < charStr.length; i++) {
           charStr[i] -= 32;
        }
        return new String(charStr);
    }

    String caseToggle(String inStr){
        char[] charStr = inStr.toCharArray();

        for (int i = 0; i < charStr.length; i++) {

            if(charStr[i] >= 65 && charStr[i] <= 90)
                charStr[i] += 32;
            else if(charStr[i] >= 'a' && charStr[i] <= 122)
                charStr[i] -= 32;


        }

        return String.valueOf(charStr);
    }



    public static void main(String[] args) {

        ChangeCase changeCase = new ChangeCase();
        System.out.println(changeCase.toUpper("welcome"));
        System.out.println(changeCase.caseToggle("welcome"));


    }

}
