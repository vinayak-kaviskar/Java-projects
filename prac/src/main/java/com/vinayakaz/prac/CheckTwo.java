package com.vinayakaz.prac;

import java.util.ArrayList;
import java.util.List;

public class CheckTwo {

    public static void main(String[] args) {

        String name = "vinayak";

        System.out.println(reverse(name));

    }

    private static String reverse(String input) {

        char arrayOne[] = input.toCharArray();

        char arrayreV[] = new char[arrayOne.length];

        int j = 0;

        for (int i = arrayOne.length - 1; i >= 0; i--) {

            arrayreV[j] = arrayOne[i];
            j++;
        }

        return new String(arrayreV);
    }

    private static String findDuplicate(char[] myArray) {
        
        char[] duplichars = new char[myArray.length];
        
        

        
        for(int j=0; j< myArray.length; j++) {
            
            for(int i = 0; i<myArray.length-1; i++) {
                
                if(myArray[i] == myArray[j]) {
                    
                }
            }
        }
       
        return null;
    }
}
