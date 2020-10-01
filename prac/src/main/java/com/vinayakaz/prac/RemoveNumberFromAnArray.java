package com.vinayakaz.prac;

import java.util.Arrays;
import java.util.Scanner;

public class RemoveNumberFromAnArray {

    public static void main(String arg[]) {
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the number of elements in the array");
        int size = scanner.nextInt();
        
        
        
        int[] inputArray = new int[size];
        
        System.out.println("Enter the numbers one by one");
        
        for(int i = 0; i<size;i++) {
            System.out.println("Enter "+i+"th element");
            inputArray[i] = scanner.nextInt();
        }
        
        System.out.println("Enter the number u want ot remove");
        int removeNum = scanner.nextInt();
        
        scanner.close();
        
        System.out.println(Arrays.toString(inputArray));
        
        int[] resultArray = removeTheNumber(inputArray, removeNum );
        
        System.out.println("Result array is: "+ Arrays.toString(resultArray));
        
    }

    private static int[] removeTheNumber(int[] numArray, int number) {

        int[] resultArray = new int[numArray.length - 1];
        int k = 0;
        for (int i = 0; i < numArray.length; i++) {

            if (numArray[i] == number) {
                continue;
            }

            resultArray[k++] = numArray[i];
        }

        return resultArray;

    }
}
