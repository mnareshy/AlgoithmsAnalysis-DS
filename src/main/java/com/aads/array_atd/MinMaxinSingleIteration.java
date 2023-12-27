package com.aads.array_atd;

public class MinMaxinSingleIteration {

    public void minMax(int[] inArray){
        
        int min = inArray[0];
        int max = inArray[0];

        for (int i = 0; i < inArray.length; i++) {

            if(inArray[i] < min)
                min = inArray[i];
            else if(inArray[i] > max)
                max = inArray[i];

        }

        System.out.println(min + " : " + max);
        
    }
    
    public static void main(String[] args) {


        MinMaxinSingleIteration minMaxinSingleIteration =  new MinMaxinSingleIteration();

        int[] inArray = {5,8,3,4,2,4,2,4,2,4,2,5,7,9, 8 };
        minMaxinSingleIteration.minMax(inArray);

    }
   
    
}
